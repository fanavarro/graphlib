package com.github.fanavarro.graphlib;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Map based graph implementation.
 *
 * @author fabad
 * @param <N>
 *            the node type
 * @param <E>
 *            the edge type
 */
public class SimpleGraphImpl<N, E> extends AbstractGraph<N, E> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2726268195016138010L;
	/**
	 * The adjacent nodes. Key is a node, value is a map where the key is an
	 * edge and value is a set of nodes connected thought the edge.
	 */
	private Map<N, Map<E, Set<N>>> adjacentNodes;

	/**
	 * Instantiates a new simple graph impl.
	 */
	public SimpleGraphImpl() {
		adjacentNodes = new HashMap<N, Map<E, Set<N>>>();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see es.um.dis.graphlib.AbstractGraph#getNodes()
	 */
	@Override
	public Set<N> getNodes() {
		return adjacentNodes.keySet();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * es.um.dis.graphlib.AbstractGraph#getAdjacentNodesWithEdges(java.lang.
	 * Object)
	 */
	@Override
	public Map<E, Set<N>> getAdjacentNodesByEdgeMap(N node) {
		return adjacentNodes.getOrDefault(node, new HashMap<E, Set<N>>());
	}

	/**
	 * Adds the node.
	 *
	 * @param node
	 *            the node
	 */
	public void addNode(N node) {
		if (!adjacentNodes.containsKey(node)) {
			adjacentNodes.put(node, new HashMap<E, Set<N>>());
		}
	}

	/**
	 * Adds the node.
	 *
	 * @param node
	 *            the node
	 * @param edge
	 *            the edge
	 * @param adjacentNode
	 *            the adjacent node
	 */
	public void addNode(N node, E edge, N adjacentNode) {
		if (!adjacentNodes.containsKey(node)) {
			this.addNode(node);
		}
		if (!adjacentNodes.containsKey(adjacentNode)) {
			this.addNode(adjacentNode);
		}
		if (!adjacentNodes.get(node).containsKey(edge)) {
			adjacentNodes.get(node).put(edge, new HashSet<N>());
		}
		adjacentNodes.get(node).get(edge).add(adjacentNode);
	}

	/**
	 * Adds the node.
	 *
	 * @param node
	 *            the node
	 * @param edge
	 *            the edge
	 * @param adjacentNodes
	 *            the adjacent nodes
	 */
	public void addNode(N node, E edge, Set<N> adjacentNodes) {
		for (N adjacentNode : adjacentNodes) {
			this.addNode(node, edge, adjacentNode);
		}
	}
	
	/**
	 * Adds the node.
	 *
	 * @param node the node
	 * @param edges the edges
	 * @param adjacentNode the adjacent node
	 */
	public void addNode(N node, Set<E> edges, N adjacentNode) {
		for(E edge : edges){
			this.addNode(node, edge, adjacentNode);
		}
	}
	
	/**
	 * Remove the node passed as argument. Also, references to this node are also removed.
	 *
	 * @param nodeToRemove the node to remove
	 */
	public void removeNode(N nodeToRemove){
		/* Remove the entry in the adjacent nodes map */
		this.adjacentNodes.remove(nodeToRemove);
		
		/* Remove references */
		for(Entry<N,Map<E,Set<N>>> entry : this.adjacentNodes.entrySet()){
			N node = entry.getKey();
			Iterator<E> edgeIterator = adjacentNodes.get(node).keySet().iterator();
			while(edgeIterator.hasNext()){
				E edge = edgeIterator.next();
				this.adjacentNodes.get(node).get(edge).remove(nodeToRemove);
				if(this.adjacentNodes.get(node).get(edge).isEmpty()){
					edgeIterator.remove();
				}
			}
		}
	}
	
	/**
	 * Remove the relation between source and target through edge in the graph.
	 * @param source The source node.
	 * @param edge The edge.
	 * @param target The target node.
	 */
	public void removeLink(N source, E edge, N target){
		if (this.adjacentNodes.containsKey(source)){
			if(this.adjacentNodes.get(source).containsKey(edge)){
				this.adjacentNodes.get(source).get(edge).remove(target);
				if(this.adjacentNodes.get(source).get(edge).isEmpty()){
					this.adjacentNodes.get(source).remove(edge);
				}
				
				/* Remove source node if it has no adjacent nodes and it is not adjacent to other nodes */
				if(this.getAdjacentNodes(source).isEmpty() && this.getIncomingNodes(source).isEmpty()){
					this.removeNode(source);
				}
				/* Remove target node if it has no adjacent nodes and it is not adjacent to other nodes */
				if(this.getAdjacentNodes(target).isEmpty() && this.getIncomingNodes(target).isEmpty()){
					this.removeNode(target);
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SimpleGraphImpl)) {
			return false;
		}
		SimpleGraphImpl<?, ?> castOther = (SimpleGraphImpl<?, ?>) other;
		return new EqualsBuilder().append(adjacentNodes, castOther.adjacentNodes).isEquals();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(adjacentNodes).toHashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Entry <N, Map<E, Set<N>>> entry : adjacentNodes.entrySet()){
			N node = entry.getKey();
			Map<E, Set<N>> adjacentNodesWithEdge = entry.getValue();
			for(Entry<E, Set<N>> entry2 : adjacentNodesWithEdge.entrySet()){
				E edge = entry2.getKey();
				Set<N> adjacentNodes = entry2.getValue();
				sb.append(String.format("%s -[%s]->  %s\n", node, edge, adjacentNodes));
			}
		}
		return sb.toString();
	}



}

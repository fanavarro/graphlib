package com.github.fanavarro.graphlib;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import com.github.fanavarro.graphlib.algorithms.Algorithm;
import com.github.fanavarro.graphlib.algorithms.AlgorithmInput;
import com.github.fanavarro.graphlib.algorithms.AlgorithmOutput;

/**
 * Class representing a graph. It defines all methods for applying graph
 * algorithms
 *
 * @author fabad
 *
 * @param <N>
 *            Node
 * @param <E>
 *            Edge
 */
public abstract class AbstractGraph<N, E> implements Graph<N, E> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3585035402556938043L;
	
	/* (non-Javadoc)
	 * @see com.github.fanavarro.graphlib.Graph#getEdgesByAdjacentNodeMap(java.lang.Object)
	 */
	@Override
	public Map<N, Set<E>> getEdgesByAdjacentNodeMap(N node){
		Map<E, Set<N>> adjacentNodesByEdgeMap = this.getAdjacentNodesByEdgeMap(node);
		return trasposeMap(adjacentNodesByEdgeMap);
	}


	/**
	 * Traspose map.
	 *
	 * @param nodesByEdgeMap the nodes by edge map
	 * @return the map
	 */
	private Map<N, Set<E>> trasposeMap(Map<E, Set<N>> nodesByEdgeMap) {
		Map<N, Set<E>> edgeByNodeMap = new HashMap<>();
		for(Entry<E, Set<N>> entry : nodesByEdgeMap.entrySet()){
			E edge = entry.getKey();
			for (N adjacentNode : entry.getValue()){
				if(!edgeByNodeMap.containsKey(adjacentNode)){
					edgeByNodeMap.put(adjacentNode, new HashSet<E>());
				}
				edgeByNodeMap.get(adjacentNode).add(edge);
			}
		}
		return edgeByNodeMap;
	}


	/* (non-Javadoc)
	 * @see com.github.fanavarro.graphlib.Graph#getAdjacentNodes(java.lang.Object)
	 */
	@Override
	public Set<N> getAdjacentNodes(N node) {
		return this.getAdjacentNodesByEdgeMap(node).values().stream().flatMap(Collection::stream)
				.collect(Collectors.toSet());
	}
	
	/* (non-Javadoc)
	 * @see com.github.fanavarro.graphlib.Graph#getOutgoingEdges(java.lang.Object)
	 */
	@Override
	public Set<E> getOutgoingEdges(N node){
		return this.getAdjacentNodesByEdgeMap(node).keySet();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see es.um.dis.graphlib.Graph#getIncomingNodesWithedges(java.lang.Object)
	 */
	@Override
	public Map<E, Set<N>> getIncomingNodesByEdgeMap(N node) {
		Map<E, Set<N>> incomingNodes = new HashMap<E, Set<N>>();
		for (N otherNode : getNodes()) {
			if (otherNode.equals(node)) {
				continue;
			}

			Map<E, Set<N>> adjacentNodes = this.getAdjacentNodesByEdgeMap(otherNode);
			for (Entry<E, Set<N>> entry : adjacentNodes.entrySet()) {
				if (entry.getValue().contains(node)) {
					E edge = entry.getKey();
					incomingNodes.putIfAbsent(edge, new HashSet<N>());
					incomingNodes.get(edge).add(otherNode);
				}
			}
		}
		return incomingNodes;
	}
	
	/* (non-Javadoc)
	 * @see com.github.fanavarro.graphlib.Graph#getEdgesByIncomingNodesMap(java.lang.Object)
	 */
	@Override
	public Map<N, Set<E>> getEdgesByIncomingNodesMap(N node){
		Map<E, Set<N>> incomingNodesByEdgeMap = this.getIncomingNodesByEdgeMap(node);
		return this.trasposeMap(incomingNodesByEdgeMap);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see es.um.dis.graphlib.Graph#getIncomingNodes(java.lang.Object)
	 */
	@Override
	public Set<N> getIncomingNodes(N node) {
		return this.getIncomingNodesByEdgeMap(node).values().stream().flatMap(Collection::stream)
				.collect(Collectors.toSet());
	}
	
	/* (non-Javadoc)
	 * @see com.github.fanavarro.graphlib.Graph#getIncomingEdges(java.lang.Object)
	 */
	@Override
	public Set<E> getIncomingEdges(N node){
		return this.getIncomingNodesByEdgeMap(node).keySet();
	}
	
	/* (non-Javadoc)
	 * @see com.github.fanavarro.graphlib.Graph#getSourceNodes(java.lang.Object)
	 */
	@Override
	public Set<N> getSourceNodes(E edge){
		 return this.getNodes().stream().filter(n -> (this.getOutgoingEdges(n).contains(edge))).collect(Collectors.toSet());
	}
	
	/* (non-Javadoc)
	 * @see com.github.fanavarro.graphlib.Graph#getTargetNodes(java.lang.Object)
	 */
	@Override
	public Set<N> getTargetNodes(E edge){
		return this.getNodes().stream().filter(n -> (this.getIncomingEdges(n).contains(edge))).collect(Collectors.toSet());
	}
	
	/* (non-Javadoc)
	 * @see com.github.fanavarro.graphlib.Graph#isContainedIn(com.github.fanavarro.graphlib.Graph)
	 */
	@Override
	public boolean isContainedIn(Graph<N, E> other){
		boolean isSubGraph = true;
		Set<N> thisNodes = this.getNodes();
		if(other != null && other.getNodes().containsAll(thisNodes)){
			for(N node : thisNodes){
				Map<E, Set<N>> adjacentNodes = this.getAdjacentNodesByEdgeMap(node);
				Map<E, Set<N>> otherAdjacentNodes = other.getAdjacentNodesByEdgeMap(node);
				otherAdjacentNodes = this.removeNodesNotContainedInCurrentGraph(otherAdjacentNodes, thisNodes);
				if(!adjacentNodes.equals(otherAdjacentNodes)){
					isSubGraph = false;
					break;
				}
			}
		} else {
			isSubGraph = false;
		}
		return isSubGraph;
	}

	/**
	 * Removes the nodes not contained in current graph.
	 *
	 * @param otherAdjacentNodes the other adjacent nodes
	 * @param thisNodes the this nodes
	 * @return the map
	 */
	private Map<E, Set<N>> removeNodesNotContainedInCurrentGraph(Map<E, Set<N>> otherAdjacentNodes, Set<N> thisNodes) {
		Map<E, Set<N>> filteredAdjacentNodes = new HashMap<E, Set<N>>();
		for(Entry<E, Set<N>> entry : otherAdjacentNodes.entrySet()){
			E edge = entry.getKey();
			Set<N> nodes = new HashSet<N>(entry.getValue());
			Iterator<N> iterator = nodes.iterator();
			while(iterator.hasNext()){
				N node = iterator.next();
				if(!thisNodes.contains(node)){
					iterator.remove();
				}
			}
			if(!nodes.isEmpty()){
				filteredAdjacentNodes.put(edge, nodes);
			}
		}
		return filteredAdjacentNodes;
	}


	/* (non-Javadoc)
	 * @see com.github.fanavarro.graphlib.Graph#applyAlgorithm(com.github.fanavarro.graphlib.algorithms.Algorithm, com.github.fanavarro.graphlib.algorithms.AlgorithmInput)
	 */
	@Override
	public AlgorithmOutput<N, E> applyAlgorithm(Algorithm<N, E> algorithm, AlgorithmInput<N, E> input) {
		input.setGraph(this);
		return algorithm.apply(input);
	}

	/* (non-Javadoc)
	 * @see com.github.fanavarro.graphlib.Graph#isEmpty()
	 */
	@Override
	public boolean isEmpty(){
		return this.getNodes().isEmpty();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		/*
		 * Emulate hash code for abstract map. We create entries on the fly,
		 * where key is a node and value is the adjacent nodes set
		 */
		int h = 0;
		for (N node : this.getNodes()) {
			Map<E, Set<N>> adjacentNodes = getAdjacentNodesByEdgeMap(node);
			Entry<N, Map<E, Set<N>>> entry = new AbstractMap.SimpleEntry<N, Map<E, Set<N>>>(node, adjacentNodes);
			h += entry.hashCode();
		}
		return h;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null) {
			return false;
		}
		if (!(other instanceof Graph<?, ?>)) {
			return false;
		}

		Graph<N, E> otherGraph = (Graph<N, E>) other;

		if (!this.getNodes().equals(otherGraph.getNodes())) {
			return false;
		}
		for (N node : this.getNodes()) {
			if (!this.getAdjacentNodesByEdgeMap(node).equals(otherGraph.getAdjacentNodesByEdgeMap(node))) {
				return false;
			}
		}
		return true;
	}
}

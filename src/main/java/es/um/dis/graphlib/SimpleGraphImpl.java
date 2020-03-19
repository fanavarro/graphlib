package es.um.dis.graphlib;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

	/**
	 * 
	 */
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
	public Map<E, Set<N>> getAdjacentNodesWithEdges(N node) {
		return adjacentNodes.get(node);
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

}

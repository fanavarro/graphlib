package es.um.dis.graphlib;

import java.util.Map;
import java.util.Set;

/**
 * Simple tree implementation. It is a simple graph that includes a root and a
 * set of leaves elements
 *
 * @author fabad
 * @param <N>
 *            the node type
 * @param <E>
 *            the edge type
 */
public class SimpleTreeImpl<N, E> extends AbstractTree<N, E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7635999002152850671L;

	/**
	 * The internal graph representation.
	 */
	private SimpleGraphImpl<N, E> internalGraph;

	public SimpleTreeImpl() {
		internalGraph = new SimpleGraphImpl<N, E>();
	}

	@Override
	public Set<N> getNodes() {
		return internalGraph.getNodes();
	}

	@Override
	public Map<E, Set<N>> getAdjacentNodesWithEdges(N node) {
		return internalGraph.getAdjacentNodesWithEdges(node);
	}

	/**
	 * Adds the node.
	 *
	 * @param node
	 *            the node
	 */
	public void addNode(N node) {
		internalGraph.addNode(node);
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
		internalGraph.addNode(node, edge, adjacentNode);
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
		internalGraph.addNode(node, edge, adjacentNodes);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((internalGraph == null) ? 0 : internalGraph.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof SimpleTreeImpl)) {
			return false;
		}
		SimpleTreeImpl<?, ?> other = (SimpleTreeImpl<?, ?>) obj;
		if (internalGraph == null) {
			if (other.internalGraph != null) {
				return false;
			}
		} else if (!internalGraph.equals(other.internalGraph)) {
			return false;
		}
		return true;
	}

}

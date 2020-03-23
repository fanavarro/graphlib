package es.um.dis.graphlib;

import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SimpleTreeImpl)) {
			return false;
		}
		SimpleTreeImpl<?, ?> castOther = (SimpleTreeImpl<?, ?>) other;
		return new EqualsBuilder().append(internalGraph, castOther.internalGraph).isEquals();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(internalGraph).toHashCode();
	}

}

package com.github.fanavarro.graphlib;

import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.github.fanavarro.graphlib.algorithms.shortest_path.ShortestPathAlgorithm;
import com.github.fanavarro.graphlib.algorithms.shortest_path.ShortestPathInput;
import com.github.fanavarro.graphlib.algorithms.shortest_path.ShortestPathOutput;

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
	public Map<E, Set<N>> getAdjacentNodesByEdgeMap(N node) {
		return internalGraph.getAdjacentNodesByEdgeMap(node);
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
	 * Adds the node.
	 *
	 * @param node the node
	 * @param edges the edges
	 * @param adjacentNodes the adjacent nodes
	 */
	public void addNode(N node, Set<E> edges, N adjacentNodes) {
		internalGraph.addNode(node, edges, adjacentNodes);
	}
	
	/**
	 * Remove the node
	 * @param nodeToRemove Node to remove.
	 * @see {@link com.github.fanavarro.graphlib.SimpleGraphImpl#removeNode(N)}
	 */
	public void removeNode(N nodeToRemove){
		internalGraph.removeNode(nodeToRemove);
	}
	
	/**
	 * Remove the relation between source and target through edge in the graph.
	 * @param source The source node.
	 * @param edge The edge.
	 * @param target The target node.
	 * @see {@link com.github.fanavarro.graphlib.SimpleGraphImpl#removeLink(N, E, N)}
	 */
	public void removeLink(N source, E edge, N target){
		internalGraph.removeLink(source, edge, target);
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.internalGraph.toString();
	}

	@Override
	public int getHeight() {
		N root = this.getRoot();
		Set<N> leaves = this.getLeaves();
		int height = 0;
		ShortestPathAlgorithm<N, E> shortestPathAlgorithm = new ShortestPathAlgorithm<N, E>();
		for (N leaf : leaves){
			ShortestPathInput<N, E> input = new ShortestPathInput<N, E>();
			input.setGraph(this);
			input.setMaxDepth(Integer.MAX_VALUE);
			input.setSourceNode(root);
			input.setTargetNode(leaf);
			ShortestPathOutput<N, E> output = shortestPathAlgorithm.apply(input);
			if (output != null && output.getPath() != null && output.getPath().size() > height){
				height = output.getPath().size();
			}
		}
		return height + 1;
	}

	@Override
	public int getMaxWidth() {
		int maxWidth = 0;
		for (N node : this.getNodes()){
			Set<N> adjacentNodes = this.getAdjacentNodes(node);
			if (adjacentNodes != null && adjacentNodes.size() > maxWidth){
				maxWidth = adjacentNodes.size();
			}
		}
		return maxWidth;
	}



}

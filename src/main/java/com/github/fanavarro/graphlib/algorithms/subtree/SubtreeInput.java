package com.github.fanavarro.graphlib.algorithms.subtree;

import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.github.fanavarro.graphlib.Graph;
import com.github.fanavarro.graphlib.algorithms.AlgorithmInput;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The Class SubtreeInput.
 *
 * @param <N>
 *            the node type
 * @param <E>
 *            the edge type
 */
public class SubtreeInput<N, E> implements AlgorithmInput<N, E> {

	/** The graph. */
	private Graph<N, E> graph;

	/** The nodes to be contained. */
	private Set<N> nodesToBeContained;
	
	/** The edges to be contained. */
	private Set<E> edgesToBeContained;
	
	/**  The max depth limit for the tree search. */
	private Integer maxDepth;
	
	/** Flag indicating if the common ancestor is computed for creating the tree. */
	private boolean computeCommonAncestor;

	/*
	 * (non-Javadoc)
	 *
	 * @see es.um.dis.graphlib.algorithms.AlgorithmInput#getGraph()
	 */
	@Override
	public Graph<N, E> getGraph() {
		return graph;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * es.um.dis.graphlib.algorithms.AlgorithmInput#setGraph(es.um.dis.graphlib.
	 * Graph)
	 */
	@Override
	public void setGraph(Graph<N, E> graph) {
		this.graph = graph;
	}

	/**
	 * Gets the nodes to be contained.
	 *
	 * @return the nodes to be contained
	 */
	public Set<N> getNodesToBeContained() {
		return nodesToBeContained;
	}

	/**
	 * Sets the nodes to be contained.
	 *
	 * @param nodesToBeContained
	 *            the new nodes to be contained
	 */
	public void setNodesToBeContained(Set<N> nodesToBeContained) {
		this.nodesToBeContained = nodesToBeContained;
	}

	/**
	 * Gets the edges to be contained.
	 *
	 * @return the edgesToBeContained
	 */
	public Set<E> getEdgesToBeContained() {
		return edgesToBeContained;
	}

	/**
	 * Sets the edges to be contained.
	 *
	 * @param edgesToBeContained the edgesToBeContained to set
	 */
	public void setEdgesToBeContained(Set<E> edgesToBeContained) {
		this.edgesToBeContained = edgesToBeContained;
	}

	/**
	 * Gets the max depth.
	 *
	 * @return the max depth
	 */
	public Integer getMaxDepth() {
		return maxDepth;
	}

	/**
	 * Sets the max depth.
	 *
	 * @param maxDepth the new max depth
	 */
	public void setMaxDepth(Integer maxDepth) {
		this.maxDepth = maxDepth;
	}

	/**
	 * Checks if is compute common ancestor.
	 *
	 * @return true, if is compute common ancestor
	 */
	public boolean isComputeCommonAncestor() {
		return computeCommonAncestor;
	}

	/**
	 * Sets the compute common ancestor.
	 *
	 * @param computeCommonAncestor the new compute common ancestor
	 */
	public void setComputeCommonAncestor(boolean computeCommonAncestor) {
		this.computeCommonAncestor = computeCommonAncestor;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SubtreeInput)) {
			return false;
		}
		SubtreeInput<?, ?> castOther = (SubtreeInput<?, ?>) other;
		return new EqualsBuilder().append(graph, castOther.graph).append(maxDepth, castOther.maxDepth)
				.append(nodesToBeContained, castOther.nodesToBeContained)
				.append(edgesToBeContained, castOther.edgesToBeContained).append(computeCommonAncestor, castOther.computeCommonAncestor).isEquals();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(graph).append(nodesToBeContained).append(edgesToBeContained).append(maxDepth).append(computeCommonAncestor).toHashCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("graph", graph).append("nodesToBeContained", nodesToBeContained)
				.append("edgesToBeContained", edgesToBeContained).append("maxDepth", maxDepth).append("computeCommonAncestor", computeCommonAncestor).toString();
	}



}

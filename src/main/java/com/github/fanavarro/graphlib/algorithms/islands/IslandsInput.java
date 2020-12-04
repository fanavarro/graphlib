package com.github.fanavarro.graphlib.algorithms.islands;

import java.io.Serializable;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.github.fanavarro.graphlib.Graph;
import com.github.fanavarro.graphlib.algorithms.AlgorithmInput;

/**
 * The Class IslandsInput.
 *
 * @param <N>
 *            the node type
 * @param <E>
 *            the edge type
 */
public class IslandsInput<N, E> implements AlgorithmInput<N, E>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7401628548398514896L;

	/** The graph. */
	private Graph<N, E> graph;

	/** Specify if the direction of the edges should be taken into account for computing the islands. */
	private boolean ignoreEdgeDirection;

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
	 * Checks if is ignore edge direction.
	 *
	 * @return the ignoreEdgeDirection
	 */
	public boolean isIgnoreEdgeDirection() {
		return ignoreEdgeDirection;
	}

	/**
	 * Sets the ignore edge direction.
	 *
	 * @param ignoreEdgeDirection            The ignoreEdgeDirection to set. This parameter is used for
	 *            ignoring edge direction when computing the islands of the
	 *            graph.
	 */
	public void setIgnoreEdgeDirection(boolean ignoreEdgeDirection) {
		this.ignoreEdgeDirection = ignoreEdgeDirection;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof IslandsInput)) {
			return false;
		}
		IslandsInput<?, ?> castOther = (IslandsInput<?, ?>) other;
		return new EqualsBuilder().append(graph, castOther.graph)
				.append(ignoreEdgeDirection, castOther.ignoreEdgeDirection).isEquals();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(graph).append(ignoreEdgeDirection).toHashCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("graph", graph).append("ignoreEdgeDirection", ignoreEdgeDirection)
				.toString();
	}

}

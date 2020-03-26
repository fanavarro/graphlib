package com.github.fanavarro.graphlib.algorithms.islands;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.github.fanavarro.graphlib.Graph;
import com.github.fanavarro.graphlib.algorithms.AlgorithmInput;
import com.github.fanavarro.graphlib.algorithms.AlgorithmOutput;

/**
 * The Class IslandsOutput. This is the output for IslandsAlgorithm.
 *
 * @param <N>
 *            the node type
 * @param <E>
 *            the edge type
 */
public class IslandsOutput<N, E> implements AlgorithmOutput<N, E>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7715153749498616803L;

	/** The input. */
	private IslandsInput<N, E> input;

	/** The detected islands. */
	private Set<Graph<N, E>> islands;

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.um.dis.graphlib.algorithms.AlgorithmOutput#getInput()
	 */
	@Override
	public AlgorithmInput<N, E> getInput() {
		return input;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.um.dis.graphlib.algorithms.AlgorithmOutput#setInput(es.um.dis.graphlib
	 * .algorithms.AlgorithmInput)
	 */
	@Override
	public void setInput(AlgorithmInput<N, E> input) {
		this.input = (IslandsInput<N, E>) input;
	}

	/**
	 * Gets the islands.
	 *
	 * @return the islands
	 */
	public Set<Graph<N, E>> getIslands() {
		return islands;
	}

	/**
	 * Sets the islands.
	 *
	 * @param islands the islands
	 */
	public void setIslands(Set<Graph<N, E>> islands) {
		this.islands = islands;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof IslandsOutput)) {
			return false;
		}
		IslandsOutput<?, ?> castOther = (IslandsOutput<?, ?>) other;
		return new EqualsBuilder().append(input, castOther.input).append(islands, castOther.islands).isEquals();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(input).append(islands).toHashCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("input", input).append("islands", islands).toString();
	}

}

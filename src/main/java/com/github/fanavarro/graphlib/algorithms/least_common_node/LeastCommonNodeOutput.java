package com.github.fanavarro.graphlib.algorithms.least_common_node;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.github.fanavarro.graphlib.algorithms.AlgorithmInput;
import com.github.fanavarro.graphlib.algorithms.AlgorithmOutput;

/**
 * The Class LeastCommonNodeOutput.
 *
 * @param <N>
 *            the node type
 * @param <E>
 *            the edge type
 */
public class LeastCommonNodeOutput<N, E> implements Serializable, AlgorithmOutput<N, E> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8021326381257947314L;

	/** The input. */
	private LeastCommonNodeInput<N, E> input;

	/** The least common nodes. */
	private Set<N> leastCommonNodes;

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.um.dis.graphlib.algorithms.AlgorithmOutput#getInput()
	 */
	@Override
	public LeastCommonNodeInput<N, E> getInput() {
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
		this.input = (LeastCommonNodeInput<N, E>) input;
	}

	/**
	 * Gets the least common nodes.
	 *
	 * @return the least common nodes
	 */
	public Set<N> getLeastCommonNodes() {
		return leastCommonNodes;
	}

	/**
	 * Sets the least common nodes.
	 *
	 * @param leastCommonNodes
	 *            the new least common nodes
	 */
	public void setLeastCommonNodes(Set<N> leastCommonNodes) {
		this.leastCommonNodes = leastCommonNodes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LeastCommonNodeOutput [input=");
		builder.append(input);
		builder.append(", leastCommonNodes=");
		builder.append(leastCommonNodes);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LeastCommonNodeOutput)) {
			return false;
		}
		LeastCommonNodeOutput<?, ?> castOther = (LeastCommonNodeOutput<?, ?>) other;
		return new EqualsBuilder().append(input, castOther.input).append(leastCommonNodes, castOther.leastCommonNodes)
				.isEquals();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(input).append(leastCommonNodes).toHashCode();
	}

}

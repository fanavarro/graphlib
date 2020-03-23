package es.um.dis.graphlib.algorithms.least_common_node;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import es.um.dis.graphlib.Graph;
import es.um.dis.graphlib.algorithms.AlgorithmInput;

/**
 * The Class LessCommonNodeInput.
 *
 * @param <N>
 *            the node type
 * @param <E>
 *            the edge type
 */
public class LeastCommonNodeInput<N, E> implements Serializable, AlgorithmInput<N, E> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3870514401416895135L;

	/** The graph. */
	private Graph<N, E> graph;

	/** The nodes. */
	private Set<N> nodes;

	/** The reverse. */
	private boolean reverse;

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
	 * Gets the nodes.
	 *
	 * @return the nodes
	 */
	public Set<N> getNodes() {
		return nodes;
	}

	/**
	 * Sets the nodes.
	 *
	 * @param nodes
	 *            the new nodes
	 */
	public void setNodes(Set<N> nodes) {
		this.nodes = nodes;
	}

	/**
	 * Checks if is reverse.
	 *
	 * @return true, if is reverse
	 */
	public boolean isReverse() {
		return reverse;
	}

	/**
	 * Sets the reverse.
	 *
	 * @param inverse
	 *            the new reverse
	 */
	public void setReverse(boolean inverse) {
		this.reverse = inverse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LeastCommonNodeInput [graph=");
		builder.append(graph);
		builder.append(", nodes=");
		builder.append(nodes);
		builder.append(", reverse=");
		builder.append(reverse);
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
		if (!(other instanceof LeastCommonNodeInput)) {
			return false;
		}
		LeastCommonNodeInput<?, ?> castOther = (LeastCommonNodeInput<?, ?>) other;
		return new EqualsBuilder().append(graph, castOther.graph).append(nodes, castOther.nodes)
				.append(reverse, castOther.reverse).isEquals();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(graph).append(nodes).append(reverse).toHashCode();
	}

}

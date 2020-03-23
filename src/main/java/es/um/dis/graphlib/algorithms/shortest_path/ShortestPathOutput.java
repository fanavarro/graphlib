package es.um.dis.graphlib.algorithms.shortest_path;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import es.um.dis.graphlib.algorithms.AlgorithmInput;
import es.um.dis.graphlib.algorithms.AlgorithmOutput;

/**
 * The Class ShortestPathOutput.
 *
 * @param <N>
 *            the node type
 * @param <E>
 *            the edge type
 */
public class ShortestPathOutput<N, E> implements AlgorithmOutput<N, E>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8206138700195961657L;

	/** The input. */
	private ShortestPathInput<N, E> input;

	/** The path. */
	private List<PathNode<N, E>> path;

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.um.dis.graphlib.algorithms.AlgorithmOutput#getInput()
	 */
	@Override
	public ShortestPathInput<N, E> getInput() {
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
		this.input = (ShortestPathInput<N, E>) input;
	}

	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public List<PathNode<N, E>> getPath() {
		return path;
	}

	/**
	 * Sets the path.
	 *
	 * @param path
	 *            the path
	 */
	public void setPath(List<PathNode<N, E>> path) {
		this.path = path;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShortestPathOutput [input=");
		builder.append(input);
		builder.append(", path=");
		builder.append(path);
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
		if (!(other instanceof ShortestPathOutput)) {
			return false;
		}
		ShortestPathOutput<?, ?> castOther = (ShortestPathOutput<?, ?>) other;
		return new EqualsBuilder().append(input, castOther.input).append(path, castOther.path).isEquals();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(input).append(path).toHashCode();
	}

}

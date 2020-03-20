package es.um.dis.graphlib.algorithms.shortest_path;

import java.io.Serializable;
import java.util.List;

import es.um.dis.graphlib.algorithms.AlgorithmInput;
import es.um.dis.graphlib.algorithms.AlgorithmOutput;




/**
 * The Class ShortestPathOutput.
 *
 * @param <N> the node type
 * @param <E> the edge type
 */
public class ShortestPathOutput<N,E> implements AlgorithmOutput<N,E>, Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8206138700195961657L;
	
	/** The input. */
	private ShortestPathInput<N, E> input;
	
	/** The path. */
	private List<PathNode<N,E>> path;

	/* (non-Javadoc)
	 * @see es.um.dis.graphlib.algorithms.AlgorithmOutput#getInput()
	 */
	@Override
	public ShortestPathInput<N, E> getInput() {
		return input;
	}

	/* (non-Javadoc)
	 * @see es.um.dis.graphlib.algorithms.AlgorithmOutput#setInput(es.um.dis.graphlib.algorithms.AlgorithmInput)
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
	 * @param path the path
	 */
	public void setPath(List<PathNode<N, E>> path) {
		this.path = path;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((input == null) ? 0 : input.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ShortestPathOutput<?,?> other = (ShortestPathOutput<?,?>) obj;
		if (input == null) {
			if (other.input != null) {
				return false;
			}
		} else if (!input.equals(other.input)) {
			return false;
		}
		if (path == null) {
			if (other.path != null) {
				return false;
			}
		} else if (!path.equals(other.path)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
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

	
	
}

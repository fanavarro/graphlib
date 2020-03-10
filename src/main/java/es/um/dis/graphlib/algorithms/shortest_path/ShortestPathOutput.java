package es.um.dis.graphlib.algorithms.shortest_path;

import java.io.Serializable;
import java.util.List;

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
	
	/** The path. */
	private List<PathNode<N,E>> path;

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
	
}

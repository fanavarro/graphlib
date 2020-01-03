package es.um.dis.graphlib.algorithms.shortest_path;

import java.io.Serializable;
import java.util.List;

import es.um.dis.graphlib.algorithms.AlgorithmOutput;

public class ShortestPathOutput<N,E> implements AlgorithmOutput<N,E>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8206138700195961657L;
	private List<PathNode<N,E>> path;

	public List<PathNode<N, E>> getPath() {
		return path;
	}

	public void setPath(List<PathNode<N, E>> path) {
		this.path = path;
	}
	
}

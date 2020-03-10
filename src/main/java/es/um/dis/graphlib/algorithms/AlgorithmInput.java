package es.um.dis.graphlib.algorithms;

import es.um.dis.graphlib.Graph;

/**
 * Interface for the input used in algorithms. All algorithms have at least a
 * graph as input.
 * 
 * @author fabad
 *
 */
public interface AlgorithmInput<N, E> {
	/**
	 * Obtain the path in which the algorithm should be applied.
	 * @return
	 */
	Graph<N, E> getGraph();
	
	/**
	 * Set the graph
	 * @param graph
	 */
	void setGraph(Graph<N,E> graph);
}

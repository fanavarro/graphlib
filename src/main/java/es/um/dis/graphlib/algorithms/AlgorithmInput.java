package es.um.dis.graphlib.algorithms;

import es.um.dis.graphlib.Graph;



// TODO: Auto-generated Javadoc
/**
 * Interface for the input used in algorithms. All algorithms have at least a
 * graph as input.
 *
 * @author fabad
 * @param <N> the node type
 * @param <E> the edge type
 */
public interface AlgorithmInput<N, E> {
	
	/**
	 * Obtain the path in which the algorithm should be applied.
	 *
	 * @return the graph
	 */
	Graph<N, E> getGraph();
	
	/**
	 * Set the graph.
	 *
	 * @param graph the graph
	 */
	void setGraph(Graph<N,E> graph);
}

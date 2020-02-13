package es.um.dis.graphlib;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import es.um.dis.graphlib.algorithms.Algorithm;
import es.um.dis.graphlib.algorithms.AlgorithmInput;
import es.um.dis.graphlib.algorithms.AlgorithmOutput;

/**
 * Class representing a graph. It defines all methods for applying graph
 * algorithms
 * 
 * @author fabad
 *
 * @param <N>
 *            Node
 * @param <E>
 *            Edge
 */
public abstract class AbstractGraph<N, E> implements Graph<N,E>{
	/**
	 * Get the nodes in a graph.
	 * 
	 * @return Set of nodes
	 */
	@Override
	public abstract Set<N> getNodes();

	/**
	 * Retrieve the adjacent nodes of the node passed as parameter. This method
	 * returns a map where the key is an edge, and the value is a set of nodes
	 * connected through the corresponding edge to the node passed as parameter.
	 * 
	 * @param node
	 * @return
	 */
	@Override
	public abstract Map<E, Set<N>> getAdjacentNodesWithEdges(N node);

	/**
	 * Retrieve a set of adjacent nodes of the node passed as parameter.
	 * Information about the edges connecting this node with its adjacent is not
	 * retrieved.
	 * 
	 * @param node
	 * @return
	 */
	@Override
	public Set<N> getAdjacentNodes(N node){
		return this.getAdjacentNodesWithEdges(node).values().stream().flatMap(Collection::stream).collect(Collectors.toSet());
	}

	/**
	 * Execute an algorithm on the graph.
	 * 
	 * @param algorithm
	 *            The algorithm to be executed.
	 * @param input
	 *            The input arguments for the algorithm.
	 * @return AlgorithmOutput
	 */
	@Override
	public AlgorithmOutput<N, E> applyAlgorithm(Algorithm<N, E> algorithm, AlgorithmInput<N, E> input) {
		input.setGraph(this);
		return algorithm.apply(input);
	}
}

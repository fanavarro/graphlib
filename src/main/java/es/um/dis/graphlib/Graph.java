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
public abstract class Graph<N, E> {
	/**
	 * Get the nodes in a graph.
	 * 
	 * @return Set of nodes
	 */
	public abstract Set<N> getNodes();

	/**
	 * Retrieve the adjacent nodes of the node passed as parameter. This method
	 * returns a map where the key is an edge, and the value is a set of nodes
	 * connected through the corresponding edge to the node passed as parameter.
	 * 
	 * @param node
	 * @return
	 */
	public abstract Map<E, Set<N>> getAdjacentNodesWithEdges(N node);

	/**
	 * Retrieve a set of adjacent nodes of the node passed as parameter.
	 * Information about the edges connecting this node with its adjacent is not
	 * retrieved.
	 * 
	 * @param node
	 * @return
	 */
	public Set<N> getAdjacentNodes(N node){
		return this.getAdjacentNodesWithEdges(node).values().stream().flatMap(Collection::stream).collect(Collectors.toSet());
	}

	/**
	 * Retrieve the nodes acting as source node in the edge passed as parameter
	 * 
	 * @param edge
	 * @return A set of nodes.
	 */
	// public abstract Set<N> getSourceNodesFromEdge(E edge);

	/**
	 * Retrieve the edges those source is the node passed as argument.
	 * 
	 * @param node
	 * @return A set of edges.
	 */
	// public Set<E> getEdgesFromSourceNode(N node) {
	// return new HashSet<E>(getAdjacentNodes(node).keySet());
	// }

	/**
	 * Execute an algorithm on the graph.
	 * 
	 * @param algorithm
	 *            The algorithm to be executed.
	 * @param input
	 *            The input arguments for the algorithm.
	 * @return AlgorithmOutput
	 */
	public AlgorithmOutput<N, E> applyAlgorithm(Algorithm<N, E> algorithm, AlgorithmInput<N, E> input) {
		input.setGraph(this);
		return algorithm.apply(input);
	}
}

package es.um.dis.graphlib;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import es.um.dis.graphlib.algorithms.Algorithm;
import es.um.dis.graphlib.algorithms.AlgorithmInput;
import es.um.dis.graphlib.algorithms.AlgorithmOutput;

/**
 * The Interface Graph.
 *
 * @param <N>
 *            the node type
 * @param <E>
 *            the edge type
 */
public interface Graph<N, E> extends Serializable {
	/**
	 * Get the nodes in a graph.
	 *
	 * @return Set of nodes
	 */
	Set<N> getNodes();

	/**
	 * Retrieve the adjacent nodes of the node passed as parameter. This method
	 * returns a map where the key is an edge, and the value is a set of nodes
	 * connected through the corresponding edge FROM the node passed as
	 * parameter.
	 *
	 * @param node
	 *            the node
	 * @return the adjacent nodes with edges
	 */
	Map<E, Set<N>> getAdjacentNodesWithEdges(N node);

	/**
	 * Retrieve a set of adjacent nodes of the node passed as parameter.
	 * Information about the edges connecting this node with its adjacent is not
	 * retrieved.
	 *
	 * @param node
	 *            the node
	 * @return the adjacent nodes
	 */
	Set<N> getAdjacentNodes(N node);

	/**
	 * Retrieve the incoming nodes of the node passed as parameter. This method
	 * returns a map where the key is an edge, and the value is a set of nodes
	 * connected through the corresponding edge TO the node passed as parameter.
	 *
	 * @param node
	 *            the node
	 * @return the incoming nodes withedges
	 */
	Map<E, Set<N>> getIncomingNodesWithEdges(N node);

	/**
	 * Retrieve the incoming nodes of the node passed as parameter. Information
	 * about the edges connecting incoming nodes to this node is not retrieved.
	 *
	 * @param node
	 *            the node
	 * @return the incoming nodes
	 */
	Set<N> getIncomingNodes(N node);

	/**
	 * Execute an algorithm on the graph.
	 *
	 * @param algorithm
	 *            The algorithm to be executed.
	 * @param input
	 *            The input arguments for the algorithm.
	 * @return AlgorithmOutput
	 */
	AlgorithmOutput<N, E> applyAlgorithm(Algorithm<N, E> algorithm, AlgorithmInput<N, E> input);

	/**
	 * Return true if this graph is contained in the graph passed as parameter.
	 * Every node and every edge between the nodes in the current graph should
	 * exist in the other one
	 * 
	 * @param other
	 *            The other graph to check if this one is contained.
	 * @return True if this graph is contained in the other graph, false
	 *         otherwise.
	 */
	boolean isContainedIn(Graph<N, E> other);

}

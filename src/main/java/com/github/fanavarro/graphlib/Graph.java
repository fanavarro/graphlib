package com.github.fanavarro.graphlib;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import com.github.fanavarro.graphlib.algorithms.Algorithm;
import com.github.fanavarro.graphlib.algorithms.AlgorithmInput;
import com.github.fanavarro.graphlib.algorithms.AlgorithmOutput;

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
	Map<E, Set<N>> getAdjacentNodesByEdgeMap(N node);
	
	/**
	 * Retrieve the adjacent nodes of the node passed as parameter. This method
	 * returns a map where the key is a node, and the value is a set of edges
	 * connecting the corresponding node FROM the node passed as
	 * parameter.
	 *
	 * @param node
	 *            the node
	 * @return the adjacent nodes with edges
	 */
	Map<N, Set<E>> getEdgesByAdjacentNodeMap(N node);

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
	 * Retrieve a set of adjacent edges of the node passed as parameter.
	 *
	 * @param node
	 *            the node
	 * @return the adjacent edges
	 */
	Set<E> getOutgoingEdges(N node);

	/**
	 * Retrieve the incoming nodes of the node passed as parameter. This method
	 * returns a map where the key is an edge, and the value is a set of nodes
	 * connected through the corresponding edge TO the node passed as parameter.
	 *
	 * @param node
	 *            the node
	 * @return the incoming nodes withedges
	 */
	Map<E, Set<N>> getIncomingNodesByEdgeMap(N node);
	
	/**
	 * Retrieve the incoming nodes of the node passed as parameter. This method
	 * returns a map where the key is a node, and the value is a set of edges
	 * connecting the corresponding node TO the node passed as parameter.
	 *
	 * @param node
	 *            the node
	 * @return the incoming nodes withedges
	 */
	Map<N, Set<E>> getEdgesByIncomingNodesMap(N node);

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
	 * Retrieve the incoming edges of the node passed as parameter. 
	 *
	 * @param node
	 *            the node
	 * @return the incoming edges
	 */
	Set<E> getIncomingEdges(N node);
	
	/**
	 * Get the nodes which are the source of the edge passed as argument.
	 * @param edge
	 * @return A set of nodes from which the edge starts.
	 */
	Set<N> getSourceNodes(E edge);
	
	/**
	 * Get the nodes which are the target of the edge passed as argument,
	 * @param edge
	 * @return A set of nodes from which the edge ends.
	 */
	Set<N> getTargetNodes(E edge);

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
	
	/**
	 * Return true if the graph is empty; false otherwise.
	 * @return true if the graph is empty; false otherwise.
	 */
	boolean isEmpty();

}

package com.github.fanavarro.graphlib.serializers;

import java.util.Set;

import com.github.fanavarro.graphlib.Graph;

/**
 * Serializer interface, which defines the methods for serializing graphs.
 * @param N Type of the node.
 * @param E Type of the edge.
 * @author fabad
 *
 */
public interface Serializer <N, E>{
	/**
	 * Serialize the graph passed as argument.
	 * @param graph The graph to serialize.
	 * @param graphName. The name of the graph to be serialized.
	 * @return A string with the graph serialization.
	 */
	String serialize(Graph <N, E> graph, String graphName);
	
	/**
	 * Serialize the node passed as argument.
	 * @param node The node to serialize.
	 * @return A string representing the node.
	 */
	String serializeNode(N node);
	
	/**
	 * Serialize the edge with its adjacent nodes passed as parameter.
	 * @param sourceNode The source node of the edge.
	 * @param edge The edge.
	 * @param targetNodes The target nodes of the edge.
	 * @return A string representing the edge.
	 */
	String serializeEdge(N sourceNode, E edge, Set<N> targetNodes);
}

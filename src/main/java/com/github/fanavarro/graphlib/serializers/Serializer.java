package com.github.fanavarro.graphlib.serializers;

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
}

package com.github.fanavarro.graphlib.serializers;

import com.github.fanavarro.graphlib.Graph;

/**
 * Serializer interface, which defines the methods for serializing graphs.
 *
 * @author fabad
 * @param <N> the number type
 * @param <E> the element type
 */
public interface Serializer <N, E>{
	
	/**
	 * Serialize the graph passed as argument.
	 *
	 * @param graph The graph to serialize.
	 * @param graphName the graph name
	 * @return A string with the graph serialization.
	 */
	String serialize(Graph <N, E> graph, String graphName);
}

package com.github.fanavarro.graphlib.serializers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fanavarro.graphlib.Graph;

/**
 * Class for serializing graphs into Json Graph format (JGF).
 *
 * @author fabad
 * @param <N>            Type of node.
 * @param <E>            Type of edge.
 * @see https://jsongraphformat.info/
 */
public class JGFSerializer<N, E> implements Serializer<N, E> {

	/** The Constant ARRAY_SEPARATOR. */
	protected static final String ARRAY_SEPARATOR = ", ";
	
	/** The Constant RELATION. */
	protected static final String RELATION = "relation";
	
	/** The Constant TARGET. */
	protected static final String TARGET = "target";
	
	/** The Constant SOURCE. */
	protected static final String SOURCE = "source";
	
	/** The Constant ID. */
	protected static final String ID = "id";
	
	/** The Constant GRAPH. */
	protected static final String GRAPH = "graph";
	
	/** The Constant EDGES. */
	protected static final String EDGES = "edges";
	
	/** The Constant NODES. */
	protected static final String NODES = "nodes";
	
	/** The Constant DIRECTED. */
	protected static final String DIRECTED = "directed";
	
	/** The Constant LABEL. */
	protected static final String LABEL = "label";
	
	/** The Constant METADATA. */
	protected static final String METADATA = "metadata";
	
	/** The mapper. */
	private ObjectMapper mapper;

	/**
	 * Instantiates a new JGF serializer.
	 */
	public JGFSerializer() {
		mapper = new ObjectMapper();
	}

	/* (non-Javadoc)
	 * @see com.github.fanavarro.graphlib.serializers.Serializer#serialize(com.github.fanavarro.graphlib.Graph, java.lang.String)
	 */
	@Override
	public String serialize(Graph<N, E> graph, String graphName) {
		ObjectNode jsonRoot = mapper.createObjectNode();
		ObjectNode jsonGraph = mapper.createObjectNode();
		jsonGraph.put(LABEL, graphName);
		jsonGraph.put(DIRECTED, true);
		jsonGraph.set(NODES, this.createNodes(graph));
		jsonGraph.set(EDGES, this.createEdges(graph));
		jsonRoot.set(GRAPH, jsonGraph);
		return jsonRoot.toPrettyString();
	}

	/**
	 * Creates the nodes.
	 *
	 * @param graph the graph
	 * @return the array node
	 */
	private ArrayNode createNodes(Graph<N, E> graph) {
		ArrayNode jsonGraphNodes = mapper.createArrayNode();
		for (N node : graph.getNodes()) {
			ObjectNode jsonGraphNode = this.serializeNode(node, graph);
			jsonGraphNodes.add(jsonGraphNode);
		}
		return jsonGraphNodes;
	}

	/**
	 * Creates the edges.
	 *
	 * @param graph the graph
	 * @return the array node
	 */
	private ArrayNode createEdges(Graph<N, E> graph) {
		ArrayNode jsonGraphEdges = mapper.createArrayNode();
		for (N node : graph.getNodes()) {
			for (Entry<E, Set<N>> entry : graph.getAdjacentNodesByEdgeMap(node).entrySet()) {
				E edge = entry.getKey();
				Set<N> adjacentNodes = entry.getValue();
				if(!adjacentNodes.isEmpty()){
					for(ObjectNode edgeJson : this.serializeEdge(node, edge, adjacentNodes, graph)){
						jsonGraphEdges.add(edgeJson);
					}
				}

			}
		}
		return jsonGraphEdges;
	}

	/**
	 * Serialize the node passed as argument.
	 * @param node The node to serialize.
	 * @param graph The graph that contains the node.
	 * @return A string representing the node.
	 */
	
	protected ObjectNode serializeNode(N node, Graph<N, E> graph) {
		ObjectNode jsonGraphNode = mapper.createObjectNode();
		ObjectNode metadata = getMetadataNode(node, graph);
		jsonGraphNode.put(ID, node.toString());
		jsonGraphNode.put(LABEL, node.toString());
		if(metadata != null){
			jsonGraphNode.set(METADATA, metadata);
		}
		return jsonGraphNode;
	}

	
	/**
	 * Serialize the edge with its adjacent nodes passed as parameter.
	 * @param sourceNode The source node of the edge.
	 * @param edge The edge.
	 * @param targetNodes The target nodes of the edge.
	 * @param graph The graph that contains the edge.
	 * @return A string representing the edge.
	 */
	protected List<ObjectNode> serializeEdge(N sourceNode, E edge, Set<N> targetNodes, Graph<N, E> graph) {
		List<ObjectNode> jsonGraphEdges = new ArrayList<ObjectNode>();
		
		for (N targetNode : targetNodes) {
			ObjectNode jsonGraphEdge = this.serializeEdge(sourceNode, edge, targetNode, graph);
			jsonGraphEdges.add(jsonGraphEdge);
		}
		return jsonGraphEdges;
	}
	
	/**
	 * Serialize the edge with its adjacent node passed as parameter.
	 * @param sourceNode The source node of the edge.
	 * @param edge The edge.
	 * @param targetNode The target node of the edge.
	 * @param graph The graph that contains the edge.
	 * @return A string representing the edge.
	 */
	protected ObjectNode serializeEdge(N sourceNode, E edge, N targetNode, Graph<N, E> graph){
		ObjectNode jsonGraphEdge = mapper.createObjectNode();
		ObjectNode metadata = getMetadataEdge(edge, graph);
		jsonGraphEdge.put(SOURCE, sourceNode.toString());
		jsonGraphEdge.put(TARGET, targetNode.toString());
		jsonGraphEdge.put(RELATION, edge.toString());
		jsonGraphEdge.put(LABEL, edge.toString());
		if(metadata != null){
			jsonGraphEdge.set(METADATA, metadata);
		}
		return jsonGraphEdge;
	}
	
	/**
	 * Get the metadata for a node in a graph. Classes extending this one should override this method to include extra information about nodes in the graph.
	 * @param node The node.
	 * @param graph The graph containing the node.
	 * @return An ObjectNode with metadata for the specified node in the specified graph.
	 */
	protected ObjectNode getMetadataNode(N node, Graph<N, E> graph){
		return null;
	}
	
	/**
	 * Get the metadata for a edge in a graph. Classes extending this one should override this method to include extra information about edges in the graph.
	 * @param edge The edge.
	 * @param graph The graph containing the edge.
	 * @return An ObjectNode with metadata for the specified edge in the specified graph.
	 */
	protected ObjectNode getMetadataEdge(E edge, Graph<N, E> graph){
		return null;
	}
	
	/**
	 * Gets the mapper.
	 *
	 * @return the mapper
	 */
	protected ObjectMapper getMapper(){
		return this.mapper;
	}
}

package com.github.fanavarro.graphlib.serializers;

import java.util.Map.Entry;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fanavarro.graphlib.Graph;

/**
 * Class for serializing graphs into Jsone Graph format (JGF).
 * @author fabad
 * @see https://jsongraphformat.info/
 * @param <N> Type of node.
 * @param <E> Type of edge.
 */
public class JGFSerializer<N, E> implements Serializer<N, E>{


	@Override
	public String serialize(Graph<N, E> graph, String graphName) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode jsonRoot = mapper.createObjectNode();
		ObjectNode jsonGraph = mapper.createObjectNode();
		jsonGraph.put("label", graphName);
		jsonGraph.put("directed", true);
		jsonGraph.set("nodes", this.createNodes(graph, mapper));
		jsonGraph.set("edges", this.createEdges(graph, mapper));
		jsonRoot.set("graph", jsonGraph);
		return jsonRoot.toPrettyString();
	}
	
	

	private ArrayNode createNodes(Graph<N, E> graph, ObjectMapper mapper){
		ArrayNode jsonGraphNodes = mapper.createArrayNode();
		for(N node : graph.getNodes()){
			ObjectNode jsonGraphNode = this.createJsonGraphNode(node, mapper);
			jsonGraphNodes.add(jsonGraphNode);
		}
		return jsonGraphNodes;
	}

	private ObjectNode createJsonGraphNode(N node, ObjectMapper mapper) {
		ObjectNode jsonGraphNode = mapper.createObjectNode();
		jsonGraphNode.put("id", node.toString());
		jsonGraphNode.put("label", node.toString());
		return jsonGraphNode;
	}
	
	private ArrayNode createEdges(Graph<N, E> graph, ObjectMapper mapper) {
		ArrayNode jsonGraphEdges = mapper.createArrayNode();
		for(N node : graph.getNodes()){
			for(Entry<E, Set<N>> entry : graph.getAdjacentNodesWithEdges(node).entrySet()){
				E edge = entry.getKey();
				Set<N> adjacentNodes = entry.getValue();
				for(N adjacentNode : adjacentNodes){
					ObjectNode jsonGraphEdge = createEdge(mapper, node, edge, adjacentNode);
					jsonGraphEdges.add(jsonGraphEdge);
				}
			}
		}
		return jsonGraphEdges;
	}



	private ObjectNode createEdge(ObjectMapper mapper, N node, E edge, N adjacentNode) {
		ObjectNode jsonGraphEdge = mapper.createObjectNode();
		jsonGraphEdge.put("source", node.toString());
		jsonGraphEdge.put("target", adjacentNode.toString());
		jsonGraphEdge.put("relation", edge.toString());
		jsonGraphEdge.put("label", edge.toString());
		return jsonGraphEdge;
	}

}

package com.github.fanavarro.graphlib.serializers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.RawValue;
import com.github.fanavarro.graphlib.Graph;

/**
 * Class for serializing graphs into Json Graph format (JGF).
 * 
 * @author fabad
 * @see https://jsongraphformat.info/
 * @param <N>
 *            Type of node.
 * @param <E>
 *            Type of edge.
 */
public class JGFSerializer<N, E> implements Serializer<N, E> {

	private static final String RELATION = "relation";
	private static final String TARGET = "target";
	private static final String SOURCE = "source";
	private static final String ID = "id";
	private static final String GRAPH2 = "graph";
	private static final String EDGES = "edges";
	private static final String NODES = "nodes";
	private static final String DIRECTED = "directed";
	private static final String LABEL = "label";
	private ObjectMapper mapper;

	public JGFSerializer() {
		mapper = new ObjectMapper();
	}

	@Override
	public String serialize(Graph<N, E> graph, String graphName) {
		ObjectNode jsonRoot = mapper.createObjectNode();
		ObjectNode jsonGraph = mapper.createObjectNode();
		jsonGraph.put(LABEL, graphName);
		jsonGraph.put(DIRECTED, true);
		jsonGraph.set(NODES, this.createNodes(graph));
		jsonGraph.set(EDGES, this.createEdges(graph));
		jsonRoot.set(GRAPH2, jsonGraph);
		return jsonRoot.toPrettyString();
	}

	private ArrayNode createNodes(Graph<N, E> graph) {
		ArrayNode jsonGraphNodes = mapper.createArrayNode();
		for (N node : graph.getNodes()) {
			String jsonGraphNode = this.serializeNode(node);
			jsonGraphNodes.addRawValue(new RawValue(jsonGraphNode));
		}
		return jsonGraphNodes;
	}

	private ArrayNode createEdges(Graph<N, E> graph) {
		ArrayNode jsonGraphEdges = mapper.createArrayNode();
		for (N node : graph.getNodes()) {
			for (Entry<E, Set<N>> entry : graph.getAdjacentNodesWithEdges(node).entrySet()) {
				E edge = entry.getKey();
				Set<N> adjacentNodes = entry.getValue();
				String edgeJson = this.serializeEdge(node, edge, adjacentNodes);

				jsonGraphEdges.addRawValue(new RawValue(edgeJson));

			}
		}
		return jsonGraphEdges;
	}

	@Override
	public String serializeNode(N node) {
		ObjectNode jsonGraphNode = mapper.createObjectNode();
		jsonGraphNode.put(ID, node.toString());
		jsonGraphNode.put(LABEL, node.toString());
		return jsonGraphNode.toString() + System.lineSeparator();
	}

	@Override
	public String serializeEdge(N sourceNode, E edge, Set<N> targetNodes) {
		StringBuilder sb = new StringBuilder();
		List<ObjectNode> jsonGraphEdges = new ArrayList<ObjectNode>();
		for (N targetNode : targetNodes) {
			ObjectNode jsonGraphEdge = mapper.createObjectNode();
			jsonGraphEdge.put(SOURCE, sourceNode.toString());
			jsonGraphEdge.put(TARGET, targetNode.toString());
			jsonGraphEdge.put(RELATION, edge.toString());
			jsonGraphEdge.put(LABEL, edge.toString());
			jsonGraphEdges.add(jsonGraphEdge);
			sb.append(jsonGraphEdge.toString()).append(System.lineSeparator());
		}
		return sb.toString();
	}
}

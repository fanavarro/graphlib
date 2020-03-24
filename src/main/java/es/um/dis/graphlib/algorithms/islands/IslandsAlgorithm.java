package es.um.dis.graphlib.algorithms.islands;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import es.um.dis.graphlib.Graph;
import es.um.dis.graphlib.SimpleGraphImpl;
import es.um.dis.graphlib.algorithms.Algorithm;
import es.um.dis.graphlib.algorithms.AlgorithmInput;
import es.um.dis.graphlib.algorithms.AlgorithmOutput;

/**
 * The Class IslandsAlgorithm.
 * @param <N> the node type
 * @param <E> the edge type
 */
public class IslandsAlgorithm<N, E> implements Algorithm<N, E> {

	private enum RelationType{ADJACENT_NODE, INCOMING_NODE};
	
	@Override
	public AlgorithmOutput<N, E> apply(AlgorithmInput<N, E> input) {
		IslandsOutput<N, E> output = new IslandsOutput<N, E>();
		Graph<N, E> graph = input.getGraph();
		boolean ignoreEdgeDirection = ((IslandsInput< ?, ?>)input).isIgnoreEdgeDirection();
		SortedSet<N> nodesToVisit = new TreeSet<N>(graph.getNodes());
		Set<Graph<N, E>> islands = new HashSet<Graph<N, E>>();
		while (!nodesToVisit.isEmpty()) {
			Graph<N, E> island = getIslandFrom(nodesToVisit.first(), graph, ignoreEdgeDirection);
			islands.add(island);
			nodesToVisit.removeAll(island.getNodes());
		}
		output.setInput(input);
		output.setIslands(islands);
		return output;
	}

	private Graph<N, E> getIslandFrom(N node, Graph<N, E> graph, boolean ignoreEdgeDirection) {
		SimpleGraphImpl<N, E> island = new SimpleGraphImpl<N, E>();
		Set<N> visited = new HashSet<N>();
		expand(node, graph, island, visited, ignoreEdgeDirection);
		
		return island;
	}

	private void expand(N node, Graph<N, E> graph, SimpleGraphImpl<N, E> island, Set<N> visited, boolean ignoreEdgeDirection) {
		if (visited.contains(node)) {
			return;
		}
		island.addNode(node);
		visited.add(node);
		Map<E, Set<N>> adjacentNodesWithEdges = graph.getAdjacentNodesWithEdges(node);
		visit(node, graph, island, visited, adjacentNodesWithEdges, RelationType.ADJACENT_NODE, ignoreEdgeDirection);
		
		/* Incoming nodes are also expanded if ignoreEdgeDirection is true. */
		if(ignoreEdgeDirection){
			Map<E, Set<N>> incomingNodesWithEdges = graph.getIncomingNodesWithEdges(node);
			visit(node, graph, island, visited, incomingNodesWithEdges, RelationType.INCOMING_NODE, ignoreEdgeDirection);
		}
	}

	private void visit(N node, Graph<N, E> graph, SimpleGraphImpl<N, E> island, Set<N> visited,
			Map<E, Set<N>> relatedNodesWithEdges, RelationType relationType, boolean ignoreEdgeDirection) {
		for (Entry<E, Set<N>> entry : relatedNodesWithEdges.entrySet()) {
			E edge = entry.getKey();
			Set<N> relatedNodes = entry.getValue();

			if(RelationType.ADJACENT_NODE.equals(relationType)){
				island.addNode(node, edge, relatedNodes);
			} 
			if(RelationType.INCOMING_NODE.equals(relationType)){
				this.addIncomingNodes(island, relatedNodes, edge, node);
			}
			for(N relatedNode : relatedNodes){
				this.expand(relatedNode, graph, island, visited, ignoreEdgeDirection);
			}
		}
	}
	
	private void addIncomingNodes(SimpleGraphImpl<N, E> island, Set<N> incomingNodes, E edge, N node){
		for(N incomingNode : incomingNodes){
			island.addNode(incomingNode, edge, node);
		}
	}

}

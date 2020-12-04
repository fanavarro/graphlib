package com.github.fanavarro.graphlib.algorithms.islands;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import com.github.fanavarro.graphlib.Graph;
import com.github.fanavarro.graphlib.SimpleGraphImpl;
import com.github.fanavarro.graphlib.algorithms.Algorithm;
import com.github.fanavarro.graphlib.algorithms.AlgorithmInput;
import com.github.fanavarro.graphlib.algorithms.AlgorithmOutput;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * The Class IslandsAlgorithm.
 * 
 * @param <N>
 *            the node type
 * @param <E>
 *            the edge type
 */
public class IslandsAlgorithm<N, E> implements Algorithm<N, E> {

	/**
	 * The Enum RelationType.
	 */
	private enum RelationType {
		
		/** The adjacent node. */
		ADJACENT_NODE, 
 /** The incoming node. */
 INCOMING_NODE
	};

	/* (non-Javadoc)
	 * @see com.github.fanavarro.graphlib.algorithms.Algorithm#apply(com.github.fanavarro.graphlib.algorithms.AlgorithmInput)
	 */
	@Override
	public AlgorithmOutput<N, E> apply(AlgorithmInput<N, E> input) {
		IslandsOutput<N, E> output = new IslandsOutput<N, E>();
		Graph<N, E> graph = input.getGraph();
		boolean ignoreEdgeDirection = ((IslandsInput<?, ?>) input).isIgnoreEdgeDirection();
		SortedSet<N> nodesToVisit = new TreeSet<N>(graph.getNodes());
		Set<Graph<N, E>> islands = new HashSet<Graph<N, E>>();
		while (!nodesToVisit.isEmpty()) {
			N rootNode = nodesToVisit.first();
			Graph<N, E> island = getIslandFrom(rootNode, graph, ignoreEdgeDirection);
			islands.add(island);
			nodesToVisit.removeAll(island.getNodes());
		}

		/*
		 * If edge direction is taking into account, depending on the selected
		 * root nodes for island building, it could appear redundant island that
		 * are contained in another ones. This step removes these redundant
		 * islands
		 */
		if (!ignoreEdgeDirection) {
			islands = this.removeRedundantIslands(islands);
		}
		output.setInput(input);
		output.setIslands(islands);
		return output;
	}

	/**
	 * Removes the redundant islands.
	 *
	 * @param islands the islands
	 * @return the sets the
	 */
	private Set<Graph<N, E>> removeRedundantIslands(Set<Graph<N, E>> islands) {
		Set<Graph<N, E>> finalIslands = new HashSet<Graph<N, E>>();
		if (islands.size() == 1) {
			return islands;
		}
		for (Graph<N, E> island1 : islands) {
			boolean valid = true;
			for (Graph<N, E> island2 : islands) {
				if (island1 == island2) {
					continue;
				}
				if (island1.isContainedIn(island2)) {
					valid = false;
					break;
				}
			}
			if (valid) {
				finalIslands.add(island1);
			}
		}
		return finalIslands;
	}

	/**
	 * Gets the island from.
	 *
	 * @param node the node
	 * @param graph the graph
	 * @param ignoreEdgeDirection the ignore edge direction
	 * @return the island from
	 */
	private Graph<N, E> getIslandFrom(N node, Graph<N, E> graph, boolean ignoreEdgeDirection) {
		SimpleGraphImpl<N, E> island = new SimpleGraphImpl<N, E>();
		Set<N> visited = new HashSet<N>();
		expand(node, graph, island, visited, ignoreEdgeDirection);

		return island;
	}

	/**
	 * Expand.
	 *
	 * @param node the node
	 * @param graph the graph
	 * @param island the island
	 * @param visited the visited
	 * @param ignoreEdgeDirection the ignore edge direction
	 */
	private void expand(N node, Graph<N, E> graph, SimpleGraphImpl<N, E> island, Set<N> visited,
			boolean ignoreEdgeDirection) {
		if (visited.contains(node)) {
			return;
		}
		island.addNode(node);
		visited.add(node);
		Map<E, Set<N>> adjacentNodesWithEdges = graph.getAdjacentNodesByEdgeMap(node);
		visit(node, graph, island, visited, adjacentNodesWithEdges, RelationType.ADJACENT_NODE, ignoreEdgeDirection);

		/* Incoming nodes are also expanded if ignoreEdgeDirection is true. */
		if (ignoreEdgeDirection) {
			Map<E, Set<N>> incomingNodesWithEdges = graph.getIncomingNodesByEdgeMap(node);
			visit(node, graph, island, visited, incomingNodesWithEdges, RelationType.INCOMING_NODE,
					ignoreEdgeDirection);
		}
	}

	/**
	 * Visit.
	 *
	 * @param node the node
	 * @param graph the graph
	 * @param island the island
	 * @param visited the visited
	 * @param relatedNodesWithEdges the related nodes with edges
	 * @param relationType the relation type
	 * @param ignoreEdgeDirection the ignore edge direction
	 */
	private void visit(N node, Graph<N, E> graph, SimpleGraphImpl<N, E> island, Set<N> visited,
			Map<E, Set<N>> relatedNodesWithEdges, RelationType relationType, boolean ignoreEdgeDirection) {
		for (Entry<E, Set<N>> entry : relatedNodesWithEdges.entrySet()) {
			E edge = entry.getKey();
			Set<N> relatedNodes = entry.getValue();

			if (RelationType.ADJACENT_NODE.equals(relationType)) {
				island.addNode(node, edge, relatedNodes);
			}
			if (RelationType.INCOMING_NODE.equals(relationType)) {
				this.addIncomingNodes(island, relatedNodes, edge, node);
			}
			for (N relatedNode : relatedNodes) {
				this.expand(relatedNode, graph, island, visited, ignoreEdgeDirection);
			}
		}
	}

	/**
	 * Adds the incoming nodes.
	 *
	 * @param island the island
	 * @param incomingNodes the incoming nodes
	 * @param edge the edge
	 * @param node the node
	 */
	private void addIncomingNodes(SimpleGraphImpl<N, E> island, Set<N> incomingNodes, E edge, N node) {
		for (N incomingNode : incomingNodes) {
			island.addNode(incomingNode, edge, node);
		}
	}

}

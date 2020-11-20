package com.github.fanavarro.graphlib.algorithms.subtree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import com.github.fanavarro.graphlib.Graph;
import com.github.fanavarro.graphlib.SimpleTreeImpl;
import com.github.fanavarro.graphlib.Tree;
import com.github.fanavarro.graphlib.algorithms.Algorithm;
import com.github.fanavarro.graphlib.algorithms.AlgorithmInput;
import com.github.fanavarro.graphlib.algorithms.AlgorithmOutput;
import com.github.fanavarro.graphlib.algorithms.least_common_node.LeastCommonNodeAlgorithm;
import com.github.fanavarro.graphlib.algorithms.least_common_node.LeastCommonNodeInput;
import com.github.fanavarro.graphlib.algorithms.least_common_node.LeastCommonNodeOutput;
import com.google.common.collect.Sets;

/**
 * The Class SubtreeAlgorithm.
 *
 * @param <N>
 *            the node type
 * @param <E>
 *            the edge type
 */
public class SubtreeAlgorithm<N, E> implements Algorithm<N, E> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.um.dis.graphlib.algorithms.Algorithm#apply(es.um.dis.graphlib.
	 * algorithms.AlgorithmInput)
	 */
	@Override
	public AlgorithmOutput<N, E> apply(AlgorithmInput<N, E> input) {
		SubtreeInput<N, E> subtreeInput = (SubtreeInput<N, E>) input;

		SubtreeOutput<N, E> output = this.getTreeContainingNodes(subtreeInput);
		return output;
	}

	/**
	 * Gets the tree containing nodes.
	 *
	 * @param subtreeInput
	 *            the subtree input
	 * @return the tree containing nodes
	 */
	private SubtreeOutput<N, E> getTreeContainingNodes(SubtreeInput<N, E> subtreeInput) {
		SubtreeOutput<N, E> output = new SubtreeOutput<N, E>();
		output.setInput(subtreeInput);
		Set<N> nodesToBeContained = subtreeInput.getNodesToBeContained() != null ? subtreeInput.getNodesToBeContained()
				: new HashSet<N>();
		Set<E> edgesToBeContained = subtreeInput.getEdgesToBeContained() != null ? subtreeInput.getEdgesToBeContained()
				: new HashSet<E>();
		Graph<N, E> graph = subtreeInput.getGraph();
		Integer maxDepth = subtreeInput.getMaxDepth() != null ? subtreeInput.getMaxDepth()
				: Integer.MAX_VALUE;
		boolean computeCommonAncestors = subtreeInput.isComputeCommonAncestor();
		
		if(nodesToBeContained.isEmpty()){
			for(E edge : edgesToBeContained){
				Set<N> sourceNodes = graph.getSourceNodes(edge);
				nodesToBeContained.addAll(sourceNodes);
			}
		}
		
		Set<N> commonAncestors = new HashSet<N>();
		if (computeCommonAncestors){
			commonAncestors = this.getCommonAncestors(graph, nodesToBeContained);
		}
		
		Set<N> possibleRoots = new HashSet<N>(nodesToBeContained);
		possibleRoots.addAll(commonAncestors);
		for (N rootNode : possibleRoots) {
			Tree<N, E> subtree = getTreeContainingNodes(graph, nodesToBeContained, edgesToBeContained, rootNode, maxDepth);
			if (subtree != null) {
				output.addTree(subtree);
			}
		}

		return output;
	}

	/**
	 * Gets the common ancestors.
	 *
	 * @param graph
	 *            the graph
	 * @param nodes
	 *            the nodes
	 * @return the common ancestors
	 */
	private Set<N> getCommonAncestors(Graph<N, E> graph, Set<N> nodes) {
		Set<N> commonAncestors = new HashSet<N>();
		LeastCommonNodeAlgorithm<N, E> lcnAlgorithm = new LeastCommonNodeAlgorithm<N, E>();
		LeastCommonNodeInput<N, E> input = new LeastCommonNodeInput<N, E>();
		input.setGraph(graph);
		input.setNodes(nodes);
		input.setReverse(true);
		LeastCommonNodeOutput<N, E> output = (LeastCommonNodeOutput<N, E>) graph.applyAlgorithm(lcnAlgorithm, input);
		if (output != null && output.getLeastCommonNodes() != null) {
			commonAncestors = output.getLeastCommonNodes();
		}
		return commonAncestors;
	}

	/**
	 * Gets the tree containing nodes. First, a breadth first traversal is
	 * performed to create a tree containing all desired nodes. Then, this tree
	 * is pruned for removing extra nodes included during the traversal.
	 *
	 * @param graph
	 *            the graph
	 * @param nodesToBeContained
	 *            the nodes to be contained
	 * @param rootNode
	 *            the root node
	 * @return the tree containing nodes
	 */
	private Tree<N, E> getTreeContainingNodes(Graph<N, E> graph, Set<N> nodesToBeContained, Set<E> edgesToBeContained,
			N rootNode, Integer maxDepth) {
		SimpleTreeImpl<N, E> output = new SimpleTreeImpl<N, E>();
		Set<N> nodesToVisit = new HashSet<N>(nodesToBeContained);
		Set<E> edgesToVisit = new HashSet<E>(edgesToBeContained);
		Queue<N> queuedNodes = new LinkedList<N>();
		Queue<Set<E>> queuedEdges = new LinkedList<Set<E>>();
		Queue<N> queuedSourceNodes = new LinkedList<N>();
		Queue<Integer> depthQueue = new LinkedList<Integer>();
		depthQueue.add(1);
		queuedNodes.add(rootNode);
		nodesToVisit.remove(rootNode);
		Set<N> visitedNodes = new HashSet<N>();

		while (!queuedNodes.isEmpty()) {
			N currentNode = queuedNodes.poll();
			Set<E> prevEdges = queuedEdges.poll();
			N prevNode = queuedSourceNodes.poll();
			Integer depth = depthQueue.poll();
			
			if (prevNode == null && prevEdges == null) {
				output.addNode(currentNode);
			} else {
				output.addNode(prevNode, prevEdges, currentNode);
				edgesToVisit.removeAll(prevEdges);
			}
			nodesToVisit.remove(currentNode);

			visitedNodes.add(currentNode);
			if (nodesToVisit.isEmpty() && edgesToVisit.isEmpty()) {
				/* The tree is pruned in order to remove not desired nodes */
				pruneTree(output, nodesToBeContained, edgesToBeContained);
				return output;
			}

			if (depth >= maxDepth){
				continue;
			}
			
			Map<N, Set<E>> adjacentNodesWithEdges = graph.getEdgesByAdjacentNodeMap(currentNode);
			for (Entry<N, Set<E>> entry : adjacentNodesWithEdges.entrySet()) {
				N adjacentNode = entry.getKey();
				Set<E> edges = entry.getValue();
				if (!visitedNodes.contains(adjacentNode)) {
					queuedSourceNodes.add(currentNode);
					queuedEdges.add(edges);
					queuedNodes.add(adjacentNode);
					depthQueue.add(depth + 1);
				}

			}
		}
		return null;
	}

	private void pruneTree(Tree<N, E> tree, Set<N> nodesToBeContained, Set<E> edgesToBeContained) {
		/*
		 * Prune leaves: finish condition: all leaves are included in nodesToBeContained or
		 * their edges are contained in edgesToBeContained
		 */
		while (!pruneTreeFinishCondition(tree, nodesToBeContained, edgesToBeContained)) {
			for (N leaf : tree.getLeaves()) {
				if(shouldPruneLeaf(tree, nodesToBeContained, edgesToBeContained, leaf)){
					((SimpleTreeImpl<N, E>) tree).removeNode(leaf);
				}
			}
		}
		
		/*
		 * Remove extra edges: if two nodes are connected by an edge to be contained, remove the others.
		 */
		for (N node : tree.getNodes()){
			Map<N, Set<E>> edgesByAdjacentNodes = tree.getEdgesByAdjacentNodeMap(node);
			for (Entry<N, Set<E>> edgesByAdjacentNode : edgesByAdjacentNodes.entrySet()){
				N adjacentNode = edgesByAdjacentNode.getKey();
				Set<E> edges = edgesByAdjacentNode.getValue();
				
				if (edgesToBeContained.stream().anyMatch(edges::contains)){
					for (E edge : edges){
						if (!edgesToBeContained.contains(edge)){
							((SimpleTreeImpl<N, E>) tree).removeLink(node, edge, adjacentNode);
						}
					}
				}
			}
			
		}

	}

	private boolean shouldPruneLeaf(Tree<N, E> tree, Set<N> nodesToBeContained, Set<E> edgesToBeContained, N leaf){
		boolean prune = false;
		if (!nodesToBeContained.contains(leaf)){
			Map<E, Set<N>> leafIncomingNodesWithEdges = tree.getIncomingNodesByEdgeMap(leaf);
			Set<E> edgeIntersection = Sets.intersection(leafIncomingNodesWithEdges.keySet(), edgesToBeContained);
			if (edgeIntersection.isEmpty()){
				prune = true;
			}
			for (N otherLeaf : tree.getLeaves()){
				if (otherLeaf == leaf){
					continue;
				}
				if(nodesToBeContained.contains(otherLeaf)){
					for(E edge : edgeIntersection){
						Set <N> incomingNodesThroughEdgeInOtherLeaf = tree.getIncomingNodesByEdgeMap(otherLeaf).get(edge);
						if(incomingNodesThroughEdgeInOtherLeaf != null && incomingNodesThroughEdgeInOtherLeaf.containsAll(leafIncomingNodesWithEdges.get(edge))){
							prune = true;
							
						} else {
							prune = prune && false;
						}
					}
				}
			}
		}
		return prune;
	}
	private boolean pruneTreeFinishCondition(Tree<N, E> tree, Set<N> nodesToBeContained, Set<E> edgesToBeContained) {
		for (N leaf : tree.getLeaves()) {
			if (!nodesToBeContained.contains(leaf)) {
				if (!tree.getIncomingEdges(leaf).stream().anyMatch(edge -> (edgesToBeContained.contains(edge)))) {
					return false;
				}
			}
		}
		return true;
	}

}

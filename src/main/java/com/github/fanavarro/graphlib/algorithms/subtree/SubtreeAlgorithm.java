package com.github.fanavarro.graphlib.algorithms.subtree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;

import com.github.fanavarro.graphlib.Graph;
import com.github.fanavarro.graphlib.SimpleTreeImpl;
import com.github.fanavarro.graphlib.Tree;
import com.github.fanavarro.graphlib.algorithms.Algorithm;
import com.github.fanavarro.graphlib.algorithms.AlgorithmInput;
import com.github.fanavarro.graphlib.algorithms.AlgorithmOutput;
import com.github.fanavarro.graphlib.algorithms.least_common_node.LeastCommonNodeAlgorithm;
import com.github.fanavarro.graphlib.algorithms.least_common_node.LeastCommonNodeInput;
import com.github.fanavarro.graphlib.algorithms.least_common_node.LeastCommonNodeOutput;

import java.util.Queue;
import java.util.Set;

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
		Set<N> nodesToBeContained = subtreeInput.getNodesToBeContained();
		Graph<N, E> graph = subtreeInput.getGraph();
		Set<N> commonAncestors = this.getCommonAncestors(graph, nodesToBeContained);
		Set<N> possibleRoots = new HashSet<N>(nodesToBeContained);
		possibleRoots.addAll(commonAncestors);
		for (N rootNode : possibleRoots) {
			Tree<N, E> subtree = getTreeContainingNodes(graph, nodesToBeContained, rootNode);
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
	 * Gets the tree containing nodes.
	 *
	 * @param graph
	 *            the graph
	 * @param nodesToBeContained
	 *            the nodes to be contained
	 * @param rootNode
	 *            the root node
	 * @return the tree containing nodes
	 */
	private Tree<N, E> getTreeContainingNodes(Graph<N, E> graph, Set<N> nodesToBeContained, N rootNode) {
		SimpleTreeImpl<N, E> output = new SimpleTreeImpl<N, E>();
		Set<N> nodesToVisit = new HashSet<N>(nodesToBeContained);
		Queue<N> q = new LinkedList<N>();
		q.add(rootNode);
		nodesToVisit.remove(rootNode);
		Set<N> visited = new HashSet<N>();
		while (!q.isEmpty()) {
			N current = q.poll();
			output.addNode(current);
			nodesToVisit.remove(current);
			visited.add(current);
			if (nodesToVisit.isEmpty()) {
				return output;
			}

			for (Entry<E, Set<N>> entry : graph.getAdjacentNodesWithEdges(current).entrySet()) {
				E edge = entry.getKey();
				for (N adjacentNode : entry.getValue()) {
					if (!visited.contains(adjacentNode)) {
						output.addNode(current, edge, adjacentNode);
						q.add(adjacentNode);
					}
				}
			}
		}
		return null;
	}
}
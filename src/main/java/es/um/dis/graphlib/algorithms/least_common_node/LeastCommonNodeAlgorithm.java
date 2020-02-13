package es.um.dis.graphlib.algorithms.least_common_node;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import es.um.dis.graphlib.AbstractGraph;
import es.um.dis.graphlib.algorithms.Algorithm;
import es.um.dis.graphlib.algorithms.AlgorithmInput;

public class LeastCommonNodeAlgorithm<N, E> implements Algorithm<N, E> {

	@Override
	public LeastCommonNodeOutput<N, E> apply(AlgorithmInput<N, E> input) {
		LeastCommonNodeInput<N, E> leastCommonNodeInput = (LeastCommonNodeInput<N, E>) input;
		N node1 = leastCommonNodeInput.getNode1();
		N node2 = leastCommonNodeInput.getNode2();
		AbstractGraph<N, E> graph = leastCommonNodeInput.getGraph();
		Set<N> leastCommonNodes = this.getLeastCommonNode(graph, node1, node2);
		LeastCommonNodeOutput<N, E> leastCommonNodeOutput = new LeastCommonNodeOutput<N, E>();
		leastCommonNodeOutput.setNode1(node1);
		leastCommonNodeOutput.setNode2(node2);
		leastCommonNodeOutput.setLeastCommonNodes(leastCommonNodes);
		return leastCommonNodeOutput;
	}

	private Set<N> getLeastCommonNode(AbstractGraph<N, E> graph, N node1, N node2) {
		Set<N> commonNodes = null;
		SortedMap<Integer, Set<N>> nodesByLevel1 = new TreeMap<Integer, Set<N>>();
		SortedMap<Integer, Set<N>> nodesByLevel2 = new TreeMap<Integer, Set<N>>();
		this.getRelatedNodesByLevel(graph, nodesByLevel1, node1, 0);
		this.getRelatedNodesByLevel(graph, nodesByLevel2, node2, 0);
		commonNodes = getLeastCommonNode(nodesByLevel1, nodesByLevel2);
		return commonNodes;
	}

	private Set<N> getLeastCommonNode(SortedMap<Integer, Set<N>> nodesByLevel1, SortedMap<Integer, Set<N>> nodesByLevel2) {
		Set<N> commonNode = null;
		int maxLevel1 = nodesByLevel1.lastKey();
		for(int level1 = 0; level1 <= maxLevel1; level1++){
			Set<N> nodeSet1 = nodesByLevel1.get(level1);
			int maxLevel2 = nodesByLevel2.lastKey();
			for(int level2 = 0; level2 <= maxLevel2; level2++){
				Set<N> nodeSet2 = nodesByLevel2.get(level2);
				Set<N> intersection = nodeSet1.stream().filter(nodeSet2::contains).collect(Collectors.toSet());
				if(!intersection.isEmpty()){
					return intersection;
				}
			}
		}
		return commonNode;
	}

	/**
	 * Fill the map nodesByLevel whose values are a set of nodes related with node passed as
	 * parameter, and whose keys are the number of edges from the node passed as
	 * parameter to the nodes in the value.
	 * 
	 * @param graph
	 * @param nodesByLevel
	 * @param node
	 * @param level
	 */
	private void getRelatedNodesByLevel(AbstractGraph<N, E> graph, Map<Integer, Set<N>> nodesByLevel, N node, int level) {
		if (nodesByLevel.get(level) == null) {
			nodesByLevel.put(level, new HashSet<N>());
		}
		nodesByLevel.get(level).add(node);
		for (N adjacentNode : graph.getAdjacentNodes(node)) {
			// We skip the current node if it has been visited before (cycle
			// supporting)
			if (nodesByLevel.values().stream().flatMap(Collection::stream).anyMatch(n -> (n.equals(adjacentNode)))) {
				continue;
			}
			getRelatedNodesByLevel(graph, nodesByLevel, adjacentNode, level + 1);
		}
	}

}

package es.um.dis.graphlib.algorithms.least_common_node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import es.um.dis.graphlib.Graph;
import es.um.dis.graphlib.algorithms.Algorithm;
import es.um.dis.graphlib.algorithms.AlgorithmInput;


/**
 * The Class LeastCommonNodeAlgorithm.
 *
 * @param <N> the node type
 * @param <E> the edge type
 */
public class LeastCommonNodeAlgorithm<N, E> implements Algorithm<N, E> {
	
	/* (non-Javadoc)
	 * @see es.um.dis.graphlib.algorithms.Algorithm#apply(es.um.dis.graphlib.algorithms.AlgorithmInput)
	 */
	@Override
	public LeastCommonNodeOutput<N, E> apply(AlgorithmInput<N, E> input) {
		LeastCommonNodeInput<N, E> leastCommonNodeInput = (LeastCommonNodeInput<N, E>) input;
		Set<N> nodes = leastCommonNodeInput.getNodes();
		Graph<N, E> graph = leastCommonNodeInput.getGraph();
		boolean reverse = leastCommonNodeInput.isReverse();
		Set<N> leastCommonNodes = this.getLeastCommonNode(graph, nodes, reverse);
		LeastCommonNodeOutput<N, E> leastCommonNodeOutput = new LeastCommonNodeOutput<N, E>();
		leastCommonNodeOutput.setNodes(nodes);
		leastCommonNodeOutput.setLeastCommonNodes(leastCommonNodes);
		leastCommonNodeOutput.setReverse(leastCommonNodeInput.isReverse());
		return leastCommonNodeOutput;
	}


	/**
	 * Gets the least common node.
	 *
	 * @param graph the graph
	 * @param nodes the nodes
	 * @param reverse the reverse
	 * @return the least common node
	 */
	private Set<N> getLeastCommonNode(Graph<N, E> graph, Set<N> nodes, boolean reverse) {
		Set<N> commonNodes = null;
		List<SortedMap<Integer, Set<N>>> nodesByLevels = new ArrayList<SortedMap<Integer, Set<N>>>();
		for (N node : nodes) {
			SortedMap<Integer, Set<N>> nodesByLevel = new TreeMap<Integer, Set<N>>();
			this.getRelatedNodesByLevel(graph, nodesByLevel, node, 0, reverse);
			nodesByLevels.add(nodesByLevel);
		}
		commonNodes = getLeastCommonNode(nodesByLevels);
		return commonNodes;
	}

	/**
	 * Gets the least common node.
	 *
	 * @param nodesByLevels the nodes by levels
	 * @return the least common node
	 */
	private Set<N> getLeastCommonNode(List<SortedMap<Integer, Set<N>>> nodesByLevels) {
		Set<N> leastCommonNodes = new HashSet<N>();
		int minLevel = Integer.MAX_VALUE;
		
		Set<N> commonNodes = getCommonNodes(nodesByLevels);
		for(N node : commonNodes){
			int level = getMaxLevel(nodesByLevels, node);
			if (level < minLevel){
				minLevel = level;
				leastCommonNodes.clear();
				leastCommonNodes.add(node);
			} else if(level == minLevel){
				leastCommonNodes.add(node);
			}
		}
		return leastCommonNodes;
	}

	/**
	 * Gets the max level.
	 *
	 * @param nodesByLevels the nodes by levels
	 * @param node the node
	 * @return the max level
	 */
	private int getMaxLevel(List<SortedMap<Integer, Set<N>>> nodesByLevels, N node) {
		int max = Integer.MIN_VALUE;
		for(SortedMap<Integer, Set<N>> nodesByLevel : nodesByLevels){
			for(Entry<Integer, Set<N>> entry : nodesByLevel.entrySet()){
				if(entry.getValue().contains(node)){
					if (entry.getKey() > max){
						max = entry.getKey();
					}		
				}
			}
		}
		return max;
	}

	/**
	 * Gets the common nodes.
	 *
	 * @param nodesByLevels the nodes by levels
	 * @return the common nodes
	 */
	private Set<N> getCommonNodes(List<SortedMap<Integer, Set<N>>> nodesByLevels) {
		Set<N> commonNodes = new HashSet<N>();
		List<Set<N>> nodes = new ArrayList<Set<N>>();
		for (SortedMap<Integer, Set<N>> nodesByLevel : nodesByLevels) {
			nodes.add(nodesByLevel.values().stream().flatMap(Collection::stream).collect(Collectors.toSet()));
		}
		commonNodes = findIntersection(nodes);
		return commonNodes;
	}


	/**
	 * Fill the map nodesByLevel whose values are a set of nodes related with
	 * node passed as parameter, and whose keys are the number of edges from the
	 * node passed as parameter to the nodes in the value.
	 *
	 * @param graph the graph
	 * @param nodesByLevel the nodes by level
	 * @param node the node
	 * @param level the level
	 * @param reverse the reverse
	 * @return the related nodes by level
	 */
	private void getRelatedNodesByLevel(Graph<N, E> graph, Map<Integer, Set<N>> nodesByLevel, N node,
			int level, boolean reverse) {
		if (nodesByLevel.get(level) == null) {
			nodesByLevel.put(level, new HashSet<N>());
		}
		nodesByLevel.get(level).add(node);
		Set<N> relatedNodes;
		if(reverse){
			relatedNodes = graph.getIncomingNodes(node);
		} else {
			relatedNodes = graph.getAdjacentNodes(node);
		}
		 
		for (N relatedNode : relatedNodes) {
			// We skip the current node if it has been visited before (cycle
			// supporting)
			if (nodesByLevel.values().stream().flatMap(Collection::stream).anyMatch(n -> (n.equals(relatedNode)))) {
				continue;
			}
			getRelatedNodesByLevel(graph, nodesByLevel, relatedNode, level + 1, reverse);
		}
	}

	/**
	 * Find intersection.
	 *
	 * @param nodes the nodes
	 * @return the sets the
	 */
	public Set<N> findIntersection(List<Set<N>> nodes) {
		Set<N> hashSet = new HashSet<N>();
		boolean first = true;
		for (Set<N> collection : nodes) {
			if (first) {
				hashSet.addAll(collection);
				first = false;
			} else {
				hashSet.retainAll(collection);
			}
		}
		return hashSet;
	}
}

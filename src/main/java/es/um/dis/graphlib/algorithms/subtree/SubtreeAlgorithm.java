package es.um.dis.graphlib.algorithms.subtree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

import es.um.dis.graphlib.AbstractGraph;
import es.um.dis.graphlib.SimpleTreeImpl;
import es.um.dis.graphlib.Tree;
import es.um.dis.graphlib.algorithms.Algorithm;
import es.um.dis.graphlib.algorithms.AlgorithmInput;
import es.um.dis.graphlib.algorithms.AlgorithmOutput;

public class SubtreeAlgorithm<N, E> implements Algorithm<N,E>{

	@Override
	public AlgorithmOutput<N, E> apply(AlgorithmInput<N, E> input) {
		SubtreeInput<N,E> subtreeInput = (SubtreeInput<N, E>)input;
		Set<N> nodesToBeContained = subtreeInput.getNodesToBeContained();
		AbstractGraph<N,E> graph = subtreeInput.getGraph();
		SubtreeOutput<N, E> output = this.getTreeContainingNodes(graph, nodesToBeContained);
		return output;
	}

	private SubtreeOutput<N, E> getTreeContainingNodes(AbstractGraph<N, E> graph, Set<N> nodesToBeContained) {
		SubtreeOutput<N, E> output = new SubtreeOutput<N, E>();
		for(N rootNode : nodesToBeContained){
			Tree<N, E> subtree = getTreeContainingNodes(graph, nodesToBeContained, rootNode);
			if(subtree != null){
				output.addTree(subtree);
			}
		}
		return output;
	}
	
	private Tree<N,E> getTreeContainingNodes(AbstractGraph<N, E> graph, Set<N> nodesToBeContained, N rootNode) {
		SimpleTreeImpl<N,E> output = new SimpleTreeImpl<N,E>();
		Set<N> nodesToVisit = new HashSet<N>(nodesToBeContained);
		Queue<N> q = new LinkedList<N>();
		q.add(rootNode);
		nodesToVisit.remove(rootNode);
		Set<N> visited = new HashSet<N>();
		while(!q.isEmpty()){
			N current = q.poll();
			output.addNode(current);
			nodesToVisit.remove(current);
			visited.add(current);
			if(nodesToVisit.isEmpty()) {
				return output;
			}
			
			for(Entry<E, Set<N>> entry : graph.getAdjacentNodesWithEdges(current).entrySet()){
				E edge = entry.getKey();
				for(N adjacentNode : entry.getValue()){
					if(!visited.contains(adjacentNode)){
						output.addNode(current, edge, adjacentNode);
						q.add(adjacentNode);
					}
				}
			}
		}
		return null;
	}
}

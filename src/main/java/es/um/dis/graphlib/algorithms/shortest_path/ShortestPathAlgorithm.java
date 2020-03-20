package es.um.dis.graphlib.algorithms.shortest_path;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

import es.um.dis.graphlib.Graph;
import es.um.dis.graphlib.algorithms.Algorithm;
import es.um.dis.graphlib.algorithms.AlgorithmInput;




/**
 * The Class ShortestPathAlgorithm.
 *
 * @param <N> the node type
 * @param <E> the edge type
 */
public class ShortestPathAlgorithm<N, E> implements Algorithm<N, E> {

	/* (non-Javadoc)
	 * @see es.um.dis.graphlib.algorithms.Algorithm#apply(es.um.dis.graphlib.algorithms.AlgorithmInput)
	 */
	public ShortestPathOutput<N, E> apply(AlgorithmInput<N, E> input) {
		ShortestPathInput<N, E> shortestPathInput = (ShortestPathInput<N,E>)input;
		N source = shortestPathInput.getSourceNode();
		N target = shortestPathInput.getTargetNode();
		Graph<N,E> graph = input.getGraph();
		int maxDepth = Integer.MAX_VALUE;
		if (shortestPathInput.getMaxDepth() > 0){
			maxDepth = shortestPathInput.getMaxDepth();
		}
		TreeNode<N, Set<E>> destinyNode = this.getTreePaths(graph, source, target, maxDepth);
		List<PathNode<N,E>> path =  this.buildPath(destinyNode);
		ShortestPathOutput<N,E> output = new ShortestPathOutput<N,E>();
		output.setInput(shortestPathInput);
		output.setPath(path);
		return output;
	}
	
	/**
	 * Builds the path.
	 *
	 * @param node the node
	 * @return the list
	 */
	private List<PathNode<N,E>> buildPath(TreeNode<N, Set<E>> node) {
		List<PathNode<N,E>> path = null;
		if (node != null) {
			path = new ArrayList<PathNode<N,E>>();
			while (node.getParent() != null) {
				PathNode<N,E> pathNode = new PathNode<N,E>();

				N pathNodeSource = node.getParent().getContent();
				N pathNodeDest = node.getContent();

				pathNode.setTarget(pathNodeDest);
				pathNode.setSource(pathNodeSource);
				pathNode.getEdges().addAll(node.getRelationToParent());
				path.add(0, pathNode);
				node = node.getParent();
			}
		}
		return path;
	}
	
	/**
	 * BFS algorithm.
	 *
	 * @param graph the graph
	 * @param source the source
	 * @param destiny the destiny
	 * @param maxDepth the max depth
	 * @return the tree paths
	 */
	private TreeNode<N, Set<E>> getTreePaths(Graph<N,E> graph, N source, N destiny, int maxDepth) {
		Set<TreeNode<N, Set<E>>> visited = new HashSet<TreeNode<N, Set<E>>>();
		Queue<TreeNode<N, Set<E>>> q = new LinkedList<TreeNode<N, Set<E>>>();
		Queue<Integer> depthQueue = new LinkedList<Integer>();
		
		q.add(new TreeNode<N, Set<E>>(source, 0));
		visited.add(new TreeNode<N, Set<E>>(source, 0));
		depthQueue.add(0);
		
		while (!q.isEmpty()){
			TreeNode<N, Set<E>> current = q.poll();
			if (current.getContent() == null){
				break;
			}
			Integer depth = depthQueue.poll();
			
			/*
			 * We have found the destiny class if current is equals to destiny
			 */
			if(current.getContent().equals(destiny)){
				return current;
			}
			
			/* If the depth limit has been reached, the algorithm will not expand this branch. */
			if (depth != null && depth > maxDepth){
				continue;
			}
			
			/* In the entry, E is an edge and set N is a set of nodes reached from current node throug E edge */
			for(Entry<E, Set<N>> entry : graph.getAdjacentNodesWithEdges(current.getContent()).entrySet()){
				E edge = entry.getKey();
				for(N node : entry.getValue()){
					/* This is needed to store all edges linking two nodes */
					TreeNode<N, Set<E>> n = getTreeNodeFromCollection(node, current.getContent(), q);
					if(n == null){
						n = new TreeNode<N, Set<E>>(node);
						n.setRelationToParent(new HashSet<E>());
					}
					
					if(!visited(n, visited, depth+1)){
						n.setHeight(depth + 1);
						n.setParent(current);
						n.getRelationToParent().add(edge);
						current.addChild(n);
						q.add(n);
						visited.add(n);
						depthQueue.add(depth+1);
					}
				}
			}
		}
		return null;
		
	}
	
	/**
	 * Visited.
	 *
	 * @param node the node
	 * @param s the s
	 * @param currentDepth the current depth
	 * @return true, if successful
	 */
	private boolean visited(TreeNode<N, Set<E>> node, Collection<TreeNode<N, Set<E>>> s, int currentDepth) {
		for(TreeNode<N, Set<E>> iterator : s){
			if(iterator.getContent().equals(node.getContent())){
				if(currentDepth > iterator.getHeight().intValue()){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Gets the tree node from collection.
	 *
	 * @param owlClass the owl class
	 * @param parent the parent
	 * @param collection the collection
	 * @return the tree node from collection
	 */
	private TreeNode<N, Set<E>> getTreeNodeFromCollection(N owlClass, N parent, Collection<TreeNode<N, Set<E>>> collection){
		for(TreeNode<N, Set<E>> node : collection){
			if(node.getContent().equals(owlClass) && node.getParent().getContent().equals(parent)){
				return node;
			}
		}
		return null;
	}

}

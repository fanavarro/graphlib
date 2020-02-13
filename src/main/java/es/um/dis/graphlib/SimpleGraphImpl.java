package es.um.dis.graphlib;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Map based graph implementation
 * @author fabad
 *
 * @param <N>
 * @param <E>
 */
public class SimpleGraphImpl<N,E> extends AbstractGraph<N, E>{
	
	/* Key is a node, value is a map where the key is an edge and value is a set of nodes connected thought the edge. */
	private Map<N, Map<E, Set<N>>> adjacentNodes;
	
	public SimpleGraphImpl(){
		adjacentNodes = new HashMap<N, Map<E, Set<N>>>();
	}

	@Override
	public Set<N> getNodes() {
		return adjacentNodes.keySet();
	}

	@Override
	public Map<E, Set<N>> getAdjacentNodesWithEdges(N node) {
		return adjacentNodes.get(node);
	}
	
	public void addNode(N node){
		if(!adjacentNodes.containsKey(node)){
			adjacentNodes.put(node, new HashMap<E, Set<N>>());
		}
	}
	
	public void addNode(N node, E edge, N adjacentNode){
		if(!adjacentNodes.containsKey(node)){
			this.addNode(node);
		}
		if(!adjacentNodes.containsKey(adjacentNode)){
			this.addNode(adjacentNode);
		}
		if(!adjacentNodes.get(node).containsKey(edge)){
			adjacentNodes.get(node).put(edge, new HashSet<N>());
		}
		adjacentNodes.get(node).get(edge).add(adjacentNode);
	}
	
	public void addNode(N node, E edge, Set<N> adjacentNodes){
		for(N adjacentNode : adjacentNodes){
			this.addNode(node, edge, adjacentNode);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adjacentNodes == null) ? 0 : adjacentNodes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleGraphImpl<?,?> other = (SimpleGraphImpl<?,?>) obj;
		if (adjacentNodes == null) {
			if (other.adjacentNodes != null)
				return false;
		} else if (!adjacentNodes.equals(other.adjacentNodes))
			return false;
		return true;
	}
	


}

package es.um.dis.graphlib.algorithms.shortest_path;

import java.io.Serializable;

import es.um.dis.graphlib.Graph;
import es.um.dis.graphlib.algorithms.AlgorithmInput;

public class ShortestPathInput<N, E> implements AlgorithmInput<N, E>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8422914860142875681L;
	private Graph<N,E> graph;
	private N sourceNode;
	private N targetNode;
	private int maxDepth;
	
	public N getSourceNode() {
		return sourceNode;
	}
	public void setSourceNode(N sourceNode) {
		this.sourceNode = sourceNode;
	}
	public N getTargetNode() {
		return targetNode;
	}
	public void setTargetNode(N targetNode) {
		this.targetNode = targetNode;
	}
	public int getMaxDepth() {
		return maxDepth;
	}
	public void setMaxDepth(int maxDepth) {
		this.maxDepth = maxDepth;
	}
	public Graph<N, E> getGraph() {
		return graph;
	}
	public void setGraph(Graph<N, E> graph) {
		this.graph = graph;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((graph == null) ? 0 : graph.hashCode());
		result = prime * result + maxDepth;
		result = prime * result + ((sourceNode == null) ? 0 : sourceNode.hashCode());
		result = prime * result + ((targetNode == null) ? 0 : targetNode.hashCode());
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
		ShortestPathInput<?, ?> other = (ShortestPathInput<?, ?>) obj;
		if (graph == null) {
			if (other.graph != null)
				return false;
		} else if (!graph.equals(other.graph))
			return false;
		if (maxDepth != other.maxDepth)
			return false;
		if (sourceNode == null) {
			if (other.sourceNode != null)
				return false;
		} else if (!sourceNode.equals(other.sourceNode))
			return false;
		if (targetNode == null) {
			if (other.targetNode != null)
				return false;
		} else if (!targetNode.equals(other.targetNode))
			return false;
		return true;
	}
	
	
	
}

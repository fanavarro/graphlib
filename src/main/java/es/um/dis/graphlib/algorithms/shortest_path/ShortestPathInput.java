package es.um.dis.graphlib.algorithms.shortest_path;

import java.io.Serializable;

import es.um.dis.graphlib.Graph;
import es.um.dis.graphlib.algorithms.AlgorithmInput;



// TODO: Auto-generated Javadoc
/**
 * The Class ShortestPathInput.
 *
 * @param <N> the node type
 * @param <E> the edge type
 */
public class ShortestPathInput<N, E> implements AlgorithmInput<N, E>, Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8422914860142875681L;
	
	/** The graph. */
	private Graph<N,E> graph;
	
	/** The source node. */
	private N sourceNode;
	
	/** The target node. */
	private N targetNode;
	
	/** The max depth. */
	private int maxDepth;
	
	/**
	 * Gets the source node.
	 *
	 * @return the source node
	 */
	public N getSourceNode() {
		return sourceNode;
	}
	
	/**
	 * Sets the source node.
	 *
	 * @param sourceNode the new source node
	 */
	public void setSourceNode(N sourceNode) {
		this.sourceNode = sourceNode;
	}
	
	/**
	 * Gets the target node.
	 *
	 * @return the target node
	 */
	public N getTargetNode() {
		return targetNode;
	}
	
	/**
	 * Sets the target node.
	 *
	 * @param targetNode the new target node
	 */
	public void setTargetNode(N targetNode) {
		this.targetNode = targetNode;
	}
	
	/**
	 * Gets the max depth.
	 *
	 * @return the max depth
	 */
	public int getMaxDepth() {
		return maxDepth;
	}
	
	/**
	 * Sets the max depth.
	 *
	 * @param maxDepth the new max depth
	 */
	public void setMaxDepth(int maxDepth) {
		this.maxDepth = maxDepth;
	}
	
	/* (non-Javadoc)
	 * @see es.um.dis.graphlib.algorithms.AlgorithmInput#getGraph()
	 */
	public Graph<N, E> getGraph() {
		return graph;
	}
	
	/* (non-Javadoc)
	 * @see es.um.dis.graphlib.algorithms.AlgorithmInput#setGraph(es.um.dis.graphlib.Graph)
	 */
	public void setGraph(Graph<N, E> graph) {
		this.graph = graph;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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

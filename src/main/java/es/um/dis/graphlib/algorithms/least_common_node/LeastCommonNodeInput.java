package es.um.dis.graphlib.algorithms.least_common_node;

import java.io.Serializable;

import es.um.dis.graphlib.AbstractGraph;
import es.um.dis.graphlib.algorithms.AlgorithmInput;

// TODO: Auto-generated Javadoc
/**
 * The Class LessCommonNodeInput.
 *
 * @param <N> the number type
 * @param <E> the element type
 */
public class LeastCommonNodeInput<N, E> implements Serializable, AlgorithmInput<N, E>{


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3870514401416895135L;
	
	/** The graph. */
	private AbstractGraph<N, E> graph;
	
	/** The node 1. */
	private N node1;
	
	/** The node 2. */
	private N node2;
	
	/* (non-Javadoc)
	 * @see es.um.dis.graphlib.algorithms.AlgorithmInput#getGraph()
	 */
	public AbstractGraph<N, E> getGraph() {
		return graph;
	}
	
	/* (non-Javadoc)
	 * @see es.um.dis.graphlib.algorithms.AlgorithmInput#setGraph(es.um.dis.graphlib.Graph)
	 */
	public void setGraph(AbstractGraph<N, E> graph) {
		this.graph = graph;
	}
	
	/**
	 * Gets the node 1.
	 *
	 * @return the node 1
	 */
	public N getNode1() {
		return node1;
	}
	
	/**
	 * Sets the node 1.
	 *
	 * @param node1 the new node 1
	 */
	public void setNode1(N node1) {
		this.node1 = node1;
	}
	
	/**
	 * Gets the node 2.
	 *
	 * @return the node 2
	 */
	public N getNode2() {
		return node2;
	}
	
	/**
	 * Sets the node 2.
	 *
	 * @param node2 the new node 2
	 */
	public void setNode2(N node2) {
		this.node2 = node2;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((graph == null) ? 0 : graph.hashCode());
		result = prime * result + ((node1 == null) ? 0 : node1.hashCode());
		result = prime * result + ((node2 == null) ? 0 : node2.hashCode());
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
		LeastCommonNodeInput<?, ?> other = (LeastCommonNodeInput<?, ?>) obj;
		if (graph == null) {
			if (other.graph != null)
				return false;
		} else if (!graph.equals(other.graph))
			return false;
		if (node1 == null) {
			if (other.node1 != null)
				return false;
		} else if (!node1.equals(other.node1))
			return false;
		if (node2 == null) {
			if (other.node2 != null)
				return false;
		} else if (!node2.equals(other.node2))
			return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LessCommonNodeInput [graph=");
		builder.append(graph);
		builder.append(", node1=");
		builder.append(node1);
		builder.append(", node2=");
		builder.append(node2);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}

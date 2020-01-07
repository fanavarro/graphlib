package es.um.dis.graphlib.algorithms.least_common_node;

import java.io.Serializable;
import java.util.Set;

import es.um.dis.graphlib.algorithms.AlgorithmOutput;

// TODO: Auto-generated Javadoc
/**
 * The Class LeastCommonNodeOutput.
 *
 * @param <N> the number type
 * @param <E> the element type
 */
public class LeastCommonNodeOutput<N, E> implements Serializable, AlgorithmOutput<N, E> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8021326381257947314L;
	
	/** The node 1. */
	private N node1;
	
	/** The node 2. */
	private N node2;
	
	/** The least common nodes. */
	private Set<N> leastCommonNodes;

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

	/**
	 * Gets the least common nodes.
	 *
	 * @return the least common nodes
	 */
	public Set<N> getLeastCommonNodes() {
		return leastCommonNodes;
	}

	/**
	 * Sets the least common nodes.
	 *
	 * @param leastCommonNodes the new least common nodes
	 */
	public void setLeastCommonNodes(Set<N> leastCommonNodes) {
		this.leastCommonNodes = leastCommonNodes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((leastCommonNodes == null) ? 0 : leastCommonNodes.hashCode());
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
		LeastCommonNodeOutput<?, ?> other = (LeastCommonNodeOutput<?, ?>) obj;
		if (leastCommonNodes == null) {
			if (other.leastCommonNodes != null)
				return false;
		} else if (!leastCommonNodes.equals(other.leastCommonNodes))
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
		builder.append("LeastCommonNodeOutput [node1=");
		builder.append(node1);
		builder.append(", node2=");
		builder.append(node2);
		builder.append(", leastCommonNodes=");
		builder.append(leastCommonNodes);
		builder.append("]");
		return builder.toString();
	}

}

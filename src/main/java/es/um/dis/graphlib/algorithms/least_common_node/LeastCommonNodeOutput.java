package es.um.dis.graphlib.algorithms.least_common_node;

import java.io.Serializable;
import java.util.Set;

import es.um.dis.graphlib.algorithms.AlgorithmOutput;

/**
 * The Class LeastCommonNodeOutput.
 *
 * @param <N> the number type
 * @param <E> the element type
 */
public class LeastCommonNodeOutput<N, E> implements Serializable, AlgorithmOutput<N, E> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8021326381257947314L;
	
	private Set<N> nodes;
	
	/** The least common nodes. */
	private Set<N> leastCommonNodes;


	public Set<N> getNodes() {
		return nodes;
	}

	public void setNodes(Set<N> nodes) {
		this.nodes = nodes;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((leastCommonNodes == null) ? 0 : leastCommonNodes.hashCode());
		result = prime * result + ((nodes == null) ? 0 : nodes.hashCode());
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
		LeastCommonNodeOutput<?, ?> other = (LeastCommonNodeOutput<?, ?>) obj;
		if (leastCommonNodes == null) {
			if (other.leastCommonNodes != null)
				return false;
		} else if (!leastCommonNodes.equals(other.leastCommonNodes))
			return false;
		if (nodes == null) {
			if (other.nodes != null)
				return false;
		} else if (!nodes.equals(other.nodes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LeastCommonNodeOutput [nodes=");
		builder.append(nodes);
		builder.append(", leastCommonNodes=");
		builder.append(leastCommonNodes);
		builder.append("]");
		return builder.toString();
	}


}

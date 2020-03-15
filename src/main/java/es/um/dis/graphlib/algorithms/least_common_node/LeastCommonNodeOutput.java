package es.um.dis.graphlib.algorithms.least_common_node;

import java.io.Serializable;
import java.util.Set;

import es.um.dis.graphlib.algorithms.AlgorithmOutput;


/**
 * The Class LeastCommonNodeOutput.
 *
 * @param <N> the node type
 * @param <E> the edge type
 */
public class LeastCommonNodeOutput<N, E> implements Serializable, AlgorithmOutput<N, E> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8021326381257947314L;
	
	/** The nodes. */
	private Set<N> nodes;
	
	/** The reverse. */
	private boolean reverse;
	
	/** The least common nodes. */
	private Set<N> leastCommonNodes;


	/**
	 * Gets the nodes.
	 *
	 * @return the nodes
	 */
	public Set<N> getNodes() {
		return nodes;
	}

	/**
	 * Sets the nodes.
	 *
	 * @param nodes the new nodes
	 */
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

	/**
	 * Checks if is reverse.
	 *
	 * @return true, if is reverse
	 */
	public boolean isReverse() {
		return reverse;
	}

	/**
	 * Sets the reverse.
	 *
	 * @param reverse the new reverse
	 */
	public void setReverse(boolean reverse) {
		this.reverse = reverse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((leastCommonNodes == null) ? 0 : leastCommonNodes.hashCode());
		result = prime * result + ((nodes == null) ? 0 : nodes.hashCode());
		result = prime * result + (reverse ? 1231 : 1237);
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
		LeastCommonNodeOutput<?,?> other = (LeastCommonNodeOutput<?,?>) obj;
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
		if (reverse != other.reverse)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LeastCommonNodeOutput [nodes=");
		builder.append(nodes);
		builder.append(", reverse=");
		builder.append(reverse);
		builder.append(", leastCommonNodes=");
		builder.append(leastCommonNodes);
		builder.append("]");
		return builder.toString();
	}

}

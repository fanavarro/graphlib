package es.um.dis.graphlib.algorithms.least_common_node;

import java.io.Serializable;
import java.util.Set;

import es.um.dis.graphlib.algorithms.AlgorithmInput;
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
	
	/** The input. */
	private LeastCommonNodeInput<N, E> input;
	
	/** The least common nodes. */
	private Set<N> leastCommonNodes;

	/* (non-Javadoc)
	 * @see es.um.dis.graphlib.algorithms.AlgorithmOutput#getInput()
	 */
	@Override
	public LeastCommonNodeInput<N, E> getInput() {
		return input;
	}

	/* (non-Javadoc)
	 * @see es.um.dis.graphlib.algorithms.AlgorithmOutput#setInput(es.um.dis.graphlib.algorithms.AlgorithmInput)
	 */
	@Override
	public void setInput(AlgorithmInput<N, E> input) {
		this.input = (LeastCommonNodeInput<N, E>) input;
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
		result = prime * result + ((input == null) ? 0 : input.hashCode());
		result = prime * result + ((leastCommonNodes == null) ? 0 : leastCommonNodes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		LeastCommonNodeOutput<?,?> other = (LeastCommonNodeOutput<?,?>) obj;
		if (input == null) {
			if (other.input != null) {
				return false;
			}
		} else if (!input.equals(other.input)) {
			return false;
		}
		if (leastCommonNodes == null) {
			if (other.leastCommonNodes != null){
				return false;
			}
		} else if (!leastCommonNodes.equals(other.leastCommonNodes)){
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LeastCommonNodeOutput [input=");
		builder.append(input);
		builder.append(", leastCommonNodes=");
		builder.append(leastCommonNodes);
		builder.append("]");
		return builder.toString();
	}




}

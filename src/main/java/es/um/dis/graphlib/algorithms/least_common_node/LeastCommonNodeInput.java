package es.um.dis.graphlib.algorithms.least_common_node;

import java.io.Serializable;
import java.util.Set;

import es.um.dis.graphlib.Graph;
import es.um.dis.graphlib.algorithms.AlgorithmInput;




/**
 * The Class LessCommonNodeInput.
 *
 * @param <N> the node type
 * @param <E> the edge type
 */
public class LeastCommonNodeInput<N, E> implements Serializable, AlgorithmInput<N, E>{


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3870514401416895135L;
	
	/** The graph. */
	private Graph<N, E> graph;
	
	/** The nodes. */
	private Set<N> nodes;
	
	/** The reverse. */
	private boolean reverse;
	
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
	 * @param inverse the new reverse
	 */
	public void setReverse(boolean inverse) {
		this.reverse = inverse;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((graph == null) ? 0 : graph.hashCode());
		result = prime * result + ((nodes == null) ? 0 : nodes.hashCode());
		result = prime * result + (reverse ? 1231 : 1237);
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
		LeastCommonNodeInput<?,?> other = (LeastCommonNodeInput<?,?>) obj;
		if (graph == null) {
			if (other.graph != null)
				return false;
		} else if (!graph.equals(other.graph))
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LeastCommonNodeInput [graph=");
		builder.append(graph);
		builder.append(", nodes=");
		builder.append(nodes);
		builder.append(", reverse=");
		builder.append(reverse);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}

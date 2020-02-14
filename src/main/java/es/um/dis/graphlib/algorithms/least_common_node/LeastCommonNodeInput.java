package es.um.dis.graphlib.algorithms.least_common_node;

import java.io.Serializable;
import java.util.Set;

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
	
	private Set<N> nodes;
	
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
	
	
	public Set<N> getNodes() {
		return nodes;
	}

	public void setNodes(Set<N> nodes) {
		this.nodes = nodes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((graph == null) ? 0 : graph.hashCode());
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
		LeastCommonNodeInput<?, ?> other = (LeastCommonNodeInput<?, ?>) obj;
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
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LeastCommonNodeInput [graph=");
		builder.append(graph);
		builder.append(", nodes=");
		builder.append(nodes);
		builder.append("]");
		return builder.toString();
	}
	
	
}

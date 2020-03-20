package es.um.dis.graphlib.algorithms.subtree;

import java.util.Set;

import es.um.dis.graphlib.Graph;
import es.um.dis.graphlib.algorithms.AlgorithmInput;




/**
 * The Class SubtreeInput.
 *
 * @param <N> the node type
 * @param <E> the edge type
 */
public class SubtreeInput<N,E> implements AlgorithmInput<N,E>{
	
	/** The graph. */
	private Graph<N,E> graph;
	
	/** The nodes to be contained. */
	private Set<N> nodesToBeContained;

	/* (non-Javadoc)
	 * @see es.um.dis.graphlib.algorithms.AlgorithmInput#getGraph()
	 */
	@Override
	public Graph<N, E> getGraph() {
		return graph;
	}

	/* (non-Javadoc)
	 * @see es.um.dis.graphlib.algorithms.AlgorithmInput#setGraph(es.um.dis.graphlib.Graph)
	 */
	@Override
	public void setGraph(Graph<N, E> graph) {
		this.graph = graph;
	}

	/**
	 * Gets the nodes to be contained.
	 *
	 * @return the nodes to be contained
	 */
	public Set<N> getNodesToBeContained() {
		return nodesToBeContained;
	}

	/**
	 * Sets the nodes to be contained.
	 *
	 * @param nodesToBeContained the new nodes to be contained
	 */
	public void setNodesToBeContained(Set<N> nodesToBeContained) {
		this.nodesToBeContained = nodesToBeContained;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((graph == null) ? 0 : graph.hashCode());
		result = prime * result + ((nodesToBeContained == null) ? 0 : nodesToBeContained.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
		SubtreeInput<?, ?> other = (SubtreeInput<?, ?>) obj;
		if (graph == null) {
			if (other.graph != null) {
				return false;
			}
		} else if (!graph.equals(other.graph)) {
			return false;
		}
		if (nodesToBeContained == null) {
			if (other.nodesToBeContained != null) {
				return false;
			}
		} else if (!nodesToBeContained.equals(other.nodesToBeContained)) {
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
		builder.append("SubtreeInput [graph=");
		builder.append(graph);
		builder.append(", nodesToBeContained=");
		builder.append(nodesToBeContained);
		builder.append("]");
		return builder.toString();
	}
	

}

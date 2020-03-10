package es.um.dis.graphlib.algorithms.subtree;

import java.util.Set;

import es.um.dis.graphlib.Graph;
import es.um.dis.graphlib.algorithms.AlgorithmInput;

public class SubtreeInput<N,E> implements AlgorithmInput<N,E>{
	private Graph<N,E> graph;
	private Set<N> nodesToBeContained;

	@Override
	public Graph<N, E> getGraph() {
		return graph;
	}

	@Override
	public void setGraph(Graph<N, E> graph) {
		this.graph = graph;
	}

	public Set<N> getNodesToBeContained() {
		return nodesToBeContained;
	}

	public void setNodesToBeContained(Set<N> nodesToBeContained) {
		this.nodesToBeContained = nodesToBeContained;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((graph == null) ? 0 : graph.hashCode());
		result = prime * result + ((nodesToBeContained == null) ? 0 : nodesToBeContained.hashCode());
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
		SubtreeInput<?, ?> other = (SubtreeInput<?, ?>) obj;
		if (graph == null) {
			if (other.graph != null)
				return false;
		} else if (!graph.equals(other.graph))
			return false;
		if (nodesToBeContained == null) {
			if (other.nodesToBeContained != null)
				return false;
		} else if (!nodesToBeContained.equals(other.nodesToBeContained))
			return false;
		return true;
	}

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

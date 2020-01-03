package es.um.dis.graphlib.algorithms.shortest_path;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Class representing a node in a path. It contains source and target nodes, and
 * a set of edges that relate both nodes.
 * 
 * @author fabad
 *
 * @param <N> Node type
 * @param <E> Edge type
 */
public class PathNode<N, E> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5217033016368776817L;

	private N source;
	private Set<E> edges;
	private N target;

	public PathNode(){
		edges = new HashSet<E>();
	}
	
	public N getSource() {
		return source;
	}

	public void setSource(N source) {
		this.source = source;
	}

	public Set<E> getEdges() {
		return edges;
	}

	public void setEdges(Set<E> edges) {
		this.edges = edges;
	}

	public N getTarget() {
		return target;
	}

	public void setTarget(N target) {
		this.target = target;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edges == null) ? 0 : edges.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PathNode other = (PathNode) obj;
		if (edges == null) {
			if (other.edges != null)
				return false;
		} else if (!edges.equals(other.edges))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PathNode [source=");
		builder.append(source);
		builder.append(", edges=");
		builder.append(edges);
		builder.append(", target=");
		builder.append(target);
		builder.append("]");
		return builder.toString();
	}

}

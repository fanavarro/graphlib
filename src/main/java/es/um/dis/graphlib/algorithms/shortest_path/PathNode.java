package es.um.dis.graphlib.algorithms.shortest_path;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



// TODO: Auto-generated Javadoc
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

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5217033016368776817L;

	/** The source. */
	private N source;
	
	/** The edges. */
	private Set<E> edges;
	
	/** The target. */
	private N target;

	/**
	 * Instantiates a new path node.
	 */
	public PathNode(){
		edges = new HashSet<E>();
	}
	
	/**
	 * Gets the source.
	 *
	 * @return the source
	 */
	public N getSource() {
		return source;
	}

	/**
	 * Sets the source.
	 *
	 * @param source the new source
	 */
	public void setSource(N source) {
		this.source = source;
	}

	/**
	 * Gets the edges.
	 *
	 * @return the edges
	 */
	public Set<E> getEdges() {
		return edges;
	}

	/**
	 * Sets the edges.
	 *
	 * @param edges the new edges
	 */
	public void setEdges(Set<E> edges) {
		this.edges = edges;
	}

	/**
	 * Gets the target.
	 *
	 * @return the target
	 */
	public N getTarget() {
		return target;
	}

	/**
	 * Sets the target.
	 *
	 * @param target the new target
	 */
	public void setTarget(N target) {
		this.target = target;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edges == null) ? 0 : edges.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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

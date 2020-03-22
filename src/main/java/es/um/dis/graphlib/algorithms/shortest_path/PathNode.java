package es.um.dis.graphlib.algorithms.shortest_path;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;




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




	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PathNode)) {
			return false;
		}
		PathNode<N,E> castOther = (PathNode<N, E>) other;
		return new EqualsBuilder().append(source, castOther.source).append(edges, castOther.edges)
				.append(target, castOther.target).isEquals();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(source).append(edges).append(target).toHashCode();
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

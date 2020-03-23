package es.um.dis.graphlib.algorithms.shortest_path;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import es.um.dis.graphlib.Graph;
import es.um.dis.graphlib.algorithms.AlgorithmInput;

/**
 * The Class ShortestPathInput.
 *
 * @param <N>
 *            the node type
 * @param <E>
 *            the edge type
 */
public class ShortestPathInput<N, E> implements AlgorithmInput<N, E>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8422914860142875681L;

	/** The graph. */
	private Graph<N, E> graph;

	/** The source node. */
	private N sourceNode;

	/** The target node. */
	private N targetNode;

	/** The max depth. */
	private int maxDepth;

	/**
	 * Gets the source node.
	 *
	 * @return the source node
	 */
	public N getSourceNode() {
		return sourceNode;
	}

	/**
	 * Sets the source node.
	 *
	 * @param sourceNode
	 *            the new source node
	 */
	public void setSourceNode(N sourceNode) {
		this.sourceNode = sourceNode;
	}

	/**
	 * Gets the target node.
	 *
	 * @return the target node
	 */
	public N getTargetNode() {
		return targetNode;
	}

	/**
	 * Sets the target node.
	 *
	 * @param targetNode
	 *            the new target node
	 */
	public void setTargetNode(N targetNode) {
		this.targetNode = targetNode;
	}

	/**
	 * Gets the max depth.
	 *
	 * @return the max depth
	 */
	public int getMaxDepth() {
		return maxDepth;
	}

	/**
	 * Sets the max depth.
	 *
	 * @param maxDepth
	 *            the new max depth
	 */
	public void setMaxDepth(int maxDepth) {
		this.maxDepth = maxDepth;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.um.dis.graphlib.algorithms.AlgorithmInput#getGraph()
	 */
	@Override
	public Graph<N, E> getGraph() {
		return graph;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.um.dis.graphlib.algorithms.AlgorithmInput#setGraph(es.um.dis.graphlib.
	 * Graph)
	 */
	@Override
	public void setGraph(Graph<N, E> graph) {
		this.graph = graph;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ShortestPathInput)) {
			return false;
		}
		ShortestPathInput<?, ?> castOther = (ShortestPathInput<?, ?>) other;
		return new EqualsBuilder().append(graph, castOther.graph).append(sourceNode, castOther.sourceNode)
				.append(targetNode, castOther.targetNode).append(maxDepth, castOther.maxDepth).isEquals();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(graph).append(sourceNode).append(targetNode).append(maxDepth).toHashCode();
	}

}

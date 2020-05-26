package com.github.fanavarro.graphlib;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * The Class AbstractTree.
 *
 * @param <N>
 *            the node type
 * @param <E>
 *            the edge type
 */
public abstract class AbstractTree<N, E> extends AbstractGraph<N, E> implements Tree<N, E> {

	/**
	 *
	 */
	private static final long serialVersionUID = -1773262514460428150L;

	/*
	 * (non-Javadoc)
	 *
	 * @see es.um.dis.graphlib.Tree#getRoot()
	 */
	@Override
	public N getRoot() {
		Set<N> possibleRoots = this.getNodes().stream().filter(root -> getNodes().stream().filter(n -> n != root)
				.allMatch(n -> !this.getAdjacentNodes(n).contains(root))).collect(Collectors.toSet());

		if (possibleRoots.size() > 1) {
			throw new IllegalStateException(String.format(
					"Error retrieving the root of the tree. The following nodes could be roots:\n%s\n Is this graph actually a tree?",
					possibleRoots.stream().map(Object::toString).collect(Collectors.joining("\n"))));
		}

		return possibleRoots.stream().findFirst().orElseThrow(() -> new IllegalStateException(
				"Error retrieving the root of the tree. There is not exist any node without incoming edges."));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see es.um.dis.graphlib.Tree#getLeaves()
	 */
	@Override
	public Set<N> getLeaves() {
		return this.getNodes().stream().filter(n -> (this.getAdjacentNodes(n).isEmpty())).collect(Collectors.toSet());
	}
	
	@Override
	public boolean isRoot(N node) {
		return this.getIncomingNodes(node).isEmpty();
	}

	@Override
	public boolean isLeaf(N node) {
		// TODO Auto-generated method stub
		return this.getAdjacentNodes(node).isEmpty();
	}
}

package com.github.fanavarro.graphlib;

import java.util.Set;

/**
 * Class representing a tree, which a graph specialization containing a root and
 * a set of leaves elements.
 *
 * @author fabad
 * @param <N>
 *            the node type
 * @param <E>
 *            the edge type
 */
public interface Tree<N, E> extends Graph<N, E> {

	/**
	 * Get the root of the tree.
	 *
	 * @return the root
	 */
	public N getRoot();

	/**
	 * Get the leaves of the tree.
	 *
	 * @return the leaves
	 */
	public Set<N> getLeaves();
	
	/**
	 * Check if the node passed as argument is the root.
	 *
	 * @param node the node
	 * @return True if node is the root, false otherwise.
	 */
	public boolean isRoot(N node);
	
	/**
	 * Check if the node passed as argument is a leaf.
	 *
	 * @param node the node
	 * @return True if node is a leaf, false otherwise.
	 */
	public boolean isLeaf(N node);
	
	/**
	 * Return the height of the tree.
	 *
	 * @return the height
	 */
	public int getHeight();
	
	/**
	 * Return the maximum width of the tree.
	 * 
	 * @return the maximum width.
	 */
	public int getMaxWidth();
}

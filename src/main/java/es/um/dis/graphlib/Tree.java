package es.um.dis.graphlib;

import java.util.Set;

/**
 * Class representing a tree, which a graph specialization containing a root and
 * a set of leaves elements.
 * 
 * @author fabad
 *
 * @param <N>
 * @param <E>
 */
public interface Tree<N, E> extends Graph<N, E> {
	/**
	 * Get the root of the tree
	 * @return
	 */
	public N getRoot();

	/**
	 * Get the leaves of the tree
	 * @return
	 */
	public Set<N> getLeaves();
}

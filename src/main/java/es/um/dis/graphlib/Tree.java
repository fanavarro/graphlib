package es.um.dis.graphlib;

import java.util.Set;



// TODO: Auto-generated Javadoc
/**
 * Class representing a tree, which a graph specialization containing a root and
 * a set of leaves elements.
 *
 * @author fabad
 * @param <N> the node type
 * @param <E> the edge type
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
}

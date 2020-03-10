package es.um.dis.graphlib.algorithms.subtree;

import java.util.HashSet;
import java.util.Set;

import es.um.dis.graphlib.Tree;
import es.um.dis.graphlib.algorithms.AlgorithmOutput;


/**
 * The Class SubtreeOutput.
 *
 * @param <N> the node type
 * @param <E> the edge type
 */
public class SubtreeOutput<N, E> implements AlgorithmOutput<N,E> {
	
	/** The trees. */
	private Set<Tree<N, E>> trees;
	
	/**
	 * Instantiates a new subtree output.
	 */
	public SubtreeOutput(){
		this.trees = new HashSet<Tree<N,E>>();
	}

	/**
	 * Gets the trees.
	 *
	 * @return the trees
	 */
	public Set<Tree<N, E>> getTrees() {
		return trees;
	}

	/**
	 * Adds the tree.
	 *
	 * @param tree the tree
	 */
	public void addTree(Tree<N, E> tree) {
		this.getTrees().add(tree);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((trees == null) ? 0 : trees.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubtreeOutput<?, ?> other = (SubtreeOutput<?, ?>) obj;
		if (trees == null) {
			if (other.trees != null)
				return false;
		} else if (!trees.equals(other.trees))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SubtreeOutput [tree=");
		builder.append(trees);
		builder.append("]");
		return builder.toString();
	}
	
}

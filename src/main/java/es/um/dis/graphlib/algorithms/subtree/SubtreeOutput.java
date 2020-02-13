package es.um.dis.graphlib.algorithms.subtree;

import java.util.HashSet;
import java.util.Set;

import es.um.dis.graphlib.Tree;
import es.um.dis.graphlib.algorithms.AlgorithmOutput;

public class SubtreeOutput<N, E> implements AlgorithmOutput<N,E> {
	private Set<Tree<N, E>> trees;
	
	public SubtreeOutput(){
		this.trees = new HashSet<Tree<N,E>>();
	}

	public Set<Tree<N, E>> getTrees() {
		return trees;
	}

	public void addTree(Tree<N, E> tree) {
		this.getTrees().add(tree);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((trees == null) ? 0 : trees.hashCode());
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
		SubtreeOutput<?, ?> other = (SubtreeOutput<?, ?>) obj;
		if (trees == null) {
			if (other.trees != null)
				return false;
		} else if (!trees.equals(other.trees))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SubtreeOutput [tree=");
		builder.append(trees);
		builder.append("]");
		return builder.toString();
	}
	
}

package es.um.dis.graphlib;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;



// TODO: Auto-generated Javadoc
/**
 * The Class AbstractTree.
 *
 * @param <N> the node type
 * @param <E> the edge type
 */
public abstract class AbstractTree<N, E> extends AbstractGraph<N, E> implements Tree<N, E> {

	/* (non-Javadoc)
	 * @see es.um.dis.graphlib.Tree#getRoot()
	 */
	@Override
	public N getRoot() {
		Set<N> possibleRoots = this.getNodes().stream().filter(root -> getNodes().stream().filter(n -> n != root)
				.allMatch(n -> !this.getAdjacentNodes(n).contains(root))).collect(Collectors.toSet());
		
		
		if (possibleRoots.size() == 0) {
			throw new IllegalStateException("Error retrieving the root of the tree. There is not exist any node without relations from another node.");
		}

		if (possibleRoots.size() > 1) {
			throw new IllegalStateException(String.format(
					"Error retrieving the root of the tree. The following nodes could be roots:\n%s\n Is this graph actually a tree?",
					possibleRoots.stream().map(Object::toString).collect(Collectors.joining("\n"))));
		}

		return possibleRoots.stream().findFirst().get();
	}

	/* (non-Javadoc)
	 * @see es.um.dis.graphlib.Tree#getLeaves()
	 */
	@Override
	public Set<N> getLeaves() {
		return this.getNodes().stream().filter(n -> (this.getAdjacentNodes(n).isEmpty())).collect(Collectors.toSet());
	}

	/* (non-Javadoc)
	 * @see es.um.dis.graphlib.AbstractGraph#getNodes()
	 */
	@Override
	public abstract Set<N> getNodes();

	/* (non-Javadoc)
	 * @see es.um.dis.graphlib.AbstractGraph#getAdjacentNodesWithEdges(java.lang.Object)
	 */
	@Override
	public abstract Map<E, Set<N>> getAdjacentNodesWithEdges(N node);

}

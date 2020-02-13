package es.um.dis.graphlib;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractTree<N, E> extends AbstractGraph<N, E> implements Tree<N, E> {

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

	@Override
	public Set<N> getLeaves() {
		return this.getNodes().stream().filter(n -> (this.getAdjacentNodes(n).isEmpty())).collect(Collectors.toSet());
	}

	@Override
	public abstract Set<N> getNodes();

	@Override
	public abstract Map<E, Set<N>> getAdjacentNodesWithEdges(N node);

}

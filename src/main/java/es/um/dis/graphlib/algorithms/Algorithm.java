package es.um.dis.graphlib.algorithms;




/**
 * The Interface Algorithm.
 *
 * @param <N> the node type
 * @param <E> the edge type
 */
public interface Algorithm <N, E>{
	
	/**
	 * Apply.
	 *
	 * @param input the input
	 * @return the algorithm output
	 */
	AlgorithmOutput<N, E> apply(AlgorithmInput<N, E> input);
}

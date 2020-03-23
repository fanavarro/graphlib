package es.um.dis.graphlib.algorithms;

/**
 * The Interface AlgorithmOutput.
 *
 * @param <N>
 *            the node type
 * @param <E>
 *            the edge type
 */
public interface AlgorithmOutput<N, E> {
	/**
	 * Get the input used for obtaining this output.
	 * 
	 * @return An AlgorithmInput object used as input for the algorithm.
	 */
	AlgorithmInput<N, E> getInput();

	/**
	 * Set method for the algorithm input used for obtaining the results.
	 * 
	 * @param input
	 *            An AlgorithmInput object.
	 */
	void setInput(AlgorithmInput<N, E> input);
}

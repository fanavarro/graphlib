package es.um.dis.graphlib.algorithms;

public interface Algorithm <N, E>{
	AlgorithmOutput<N, E> apply(AlgorithmInput<N, E> input);
}

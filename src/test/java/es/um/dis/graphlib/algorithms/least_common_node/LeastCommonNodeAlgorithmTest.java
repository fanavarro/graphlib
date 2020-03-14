package es.um.dis.graphlib.algorithms.least_common_node;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

import es.um.dis.graphlib.FakeGraph;
import es.um.dis.graphlib.algorithms.least_common_node.LeastCommonNodeAlgorithm;
import es.um.dis.graphlib.algorithms.least_common_node.LeastCommonNodeInput;
import es.um.dis.graphlib.algorithms.least_common_node.LeastCommonNodeOutput;

/**
 * The Class LeastCommonNodeAlgorithmTest.
 */
public class LeastCommonNodeAlgorithmTest {

	/**
	 * Least commonnode test 1.
	 */
	@Test
	public void leastCommonNodeTest1() {
		/* Create the graph */
		FakeGraph graph = new FakeGraph();

		/* Create the algorithm to apply */
		LeastCommonNodeAlgorithm<String, String> algorithm = new LeastCommonNodeAlgorithm<String, String>();

		/* Create the input for the algorithm */
		LeastCommonNodeInput<String, String> input = new LeastCommonNodeInput<String, String>();
		input.setGraph(graph);
		input.setNodes(new HashSet<String>(Arrays.asList("A", "C")));

		/* Apply the algorithm */
		LeastCommonNodeOutput<String, String> output = (LeastCommonNodeOutput<String, String>) graph
				.applyAlgorithm(algorithm, input);

		/* Check output */
		assertNotNull(output);
		assertNotNull(output.getLeastCommonNodes());
		assertEquals(1, output.getLeastCommonNodes().size());
		assertTrue(output.getLeastCommonNodes().contains("B"));
	}

	/**
	 * Least commonnode test 2.
	 */
	@Test
	public void leastCommonNodeTest2() {
		FakeGraph graph = new FakeGraph();
		LeastCommonNodeInput<String, String> input = new LeastCommonNodeInput<String, String>();
		input.setGraph(graph);
		input.setNodes(new HashSet<String>(Arrays.asList("C", "E")));
		LeastCommonNodeAlgorithm<String, String> algorithm = new LeastCommonNodeAlgorithm<String, String>();
		LeastCommonNodeOutput<String, String> output = (LeastCommonNodeOutput<String, String>) graph
				.applyAlgorithm(algorithm, input);
		assertNotNull(output);
		assertNotNull(output.getLeastCommonNodes());
		assertEquals(1, output.getLeastCommonNodes().size());
		assertTrue(output.getLeastCommonNodes().contains("C"));
	}

	/**
	 * Least commonnode test 3.
	 */
	@Test
	public void leastCommonNodeTest3() {
		FakeGraph graph = new FakeGraph();
		LeastCommonNodeInput<String, String> input = new LeastCommonNodeInput<String, String>();
		input.setGraph(graph);
		input.setNodes(new HashSet<String>(Arrays.asList("F", "A")));
		LeastCommonNodeAlgorithm<String, String> algorithm = new LeastCommonNodeAlgorithm<String, String>();
		LeastCommonNodeOutput<String, String> output = (LeastCommonNodeOutput<String, String>) graph
				.applyAlgorithm(algorithm, input);
		assertNotNull(output);
		assertNotNull(output.getLeastCommonNodes());
		assertEquals(1, output.getLeastCommonNodes().size());
		assertTrue(output.getLeastCommonNodes().contains("F"));
	}

	/**
	 * Least commonnode test 4.
	 */
	@Test
	public void leastCommonNodeTest4() {
		FakeGraph graph = new FakeGraph();
		LeastCommonNodeInput<String, String> input = new LeastCommonNodeInput<String, String>();
		input.setGraph(graph);
		input.setNodes(new HashSet<String>(Arrays.asList("G", "H")));
		LeastCommonNodeAlgorithm<String, String> algorithm = new LeastCommonNodeAlgorithm<String, String>();
		LeastCommonNodeOutput<String, String> output = (LeastCommonNodeOutput<String, String>) graph
				.applyAlgorithm(algorithm, input);
		assertNotNull(output);
		assertNotNull(output.getLeastCommonNodes());
		assertEquals(2, output.getLeastCommonNodes().size());
		assertTrue(output.getLeastCommonNodes().contains("I"));
		assertTrue(output.getLeastCommonNodes().contains("J"));
	}

	/**
	 * Least commonnode test 5.
	 */
	@Test
	public void leastCommonNodeTest5() {
		FakeGraph graph = new FakeGraph();
		LeastCommonNodeInput<String, String> input = new LeastCommonNodeInput<String, String>();
		input.setGraph(graph);
		input.setNodes(new HashSet<String>(Arrays.asList("E", "G")));
		LeastCommonNodeAlgorithm<String, String> algorithm = new LeastCommonNodeAlgorithm<String, String>();
		LeastCommonNodeOutput<String, String> output = (LeastCommonNodeOutput<String, String>) graph
				.applyAlgorithm(algorithm, input);
		assertNotNull(output);
		assertTrue(output.getLeastCommonNodes().isEmpty());
	}

	/**
	 * Least commonnode test 6.
	 */
	@Test
	public void leastCommonNodeTest6() {
		FakeGraph graph = new FakeGraph();
		LeastCommonNodeInput<String, String> input = new LeastCommonNodeInput<String, String>();
		input.setGraph(graph);
		input.setNodes(new HashSet<String>(Arrays.asList("D", "E", "C")));
		LeastCommonNodeAlgorithm<String, String> algorithm = new LeastCommonNodeAlgorithm<String, String>();
		LeastCommonNodeOutput<String, String> output = (LeastCommonNodeOutput<String, String>) graph
				.applyAlgorithm(algorithm, input);
		assertNotNull(output);
		assertFalse(output.getLeastCommonNodes().isEmpty());
		assertTrue(output.getLeastCommonNodes().contains("C"));
	}

	/**
	 * Least commonnode test 7.
	 */
	@Test
	public void leastCommonNodeTest7() {
		FakeGraph graph = new FakeGraph();
		LeastCommonNodeInput<String, String> input = new LeastCommonNodeInput<String, String>();
		input.setGraph(graph);
		input.setNodes(new HashSet<String>(Arrays.asList("A", "E", "C")));
		LeastCommonNodeAlgorithm<String, String> algorithm = new LeastCommonNodeAlgorithm<String, String>();
		LeastCommonNodeOutput<String, String> output = (LeastCommonNodeOutput<String, String>) graph
				.applyAlgorithm(algorithm, input);
		assertNotNull(output);
		assertFalse(output.getLeastCommonNodes().isEmpty());
		assertTrue(output.getLeastCommonNodes().contains("B"));
	}

	/**
	 * Least commonnode test 8.
	 */
	@Test
	public void leastCommonNodeTest8() {
		FakeGraph graph = new FakeGraph();
		LeastCommonNodeInput<String, String> input = new LeastCommonNodeInput<String, String>();
		input.setGraph(graph);
		input.setNodes(new HashSet<String>(Arrays.asList("B", "D")));
		input.setReverse(true);
		LeastCommonNodeAlgorithm<String, String> algorithm = new LeastCommonNodeAlgorithm<String, String>();
		LeastCommonNodeOutput<String, String> output = (LeastCommonNodeOutput<String, String>) graph
				.applyAlgorithm(algorithm, input);
		assertNotNull(output);
		assertFalse(output.getLeastCommonNodes().isEmpty());
		assertEquals(1, output.getLeastCommonNodes().size());
		assertTrue(output.getLeastCommonNodes().contains("B"));
	}

	/**
	 * Least commonnode test 9.
	 */
	@Test
	public void leastCommonNodeTest9() {
		FakeGraph graph = new FakeGraph();
		LeastCommonNodeInput<String, String> input = new LeastCommonNodeInput<String, String>();
		input.setGraph(graph);
		input.setNodes(new HashSet<String>(Arrays.asList("A", "E")));
		input.setReverse(true);
		LeastCommonNodeAlgorithm<String, String> algorithm = new LeastCommonNodeAlgorithm<String, String>();
		LeastCommonNodeOutput<String, String> output = (LeastCommonNodeOutput<String, String>) graph
				.applyAlgorithm(algorithm, input);
		assertNotNull(output);
		assertFalse(output.getLeastCommonNodes().isEmpty());
		assertTrue(output.getLeastCommonNodes().contains("A"));
	}

	/**
	 * Least commonnode test 10.
	 */
	public void leastCommonNodeTest10() {
		FakeGraph graph = new FakeGraph();
		LeastCommonNodeInput<String, String> input = new LeastCommonNodeInput<String, String>();
		input.setGraph(graph);
		input.setNodes(new HashSet<String>(Arrays.asList("B", "E")));
		input.setReverse(true);
		LeastCommonNodeAlgorithm<String, String> algorithm = new LeastCommonNodeAlgorithm<String, String>();
		LeastCommonNodeOutput<String, String> output = (LeastCommonNodeOutput<String, String>) graph
				.applyAlgorithm(algorithm, input);
		assertNotNull(output);
		assertFalse(output.getLeastCommonNodes().isEmpty());
		assertEquals(2, output.getLeastCommonNodes().size());
		assertTrue(output.getLeastCommonNodes().contains("E"));
		assertTrue(output.getLeastCommonNodes().contains("B"));
	}
}

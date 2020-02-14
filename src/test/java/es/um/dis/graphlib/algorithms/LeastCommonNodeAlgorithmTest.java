package es.um.dis.graphlib.algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

import es.um.dis.graphlib.FakeGraph;
import es.um.dis.graphlib.algorithms.least_common_node.LeastCommonNodeAlgorithm;
import es.um.dis.graphlib.algorithms.least_common_node.LeastCommonNodeInput;
import es.um.dis.graphlib.algorithms.least_common_node.LeastCommonNodeOutput;

public class LeastCommonNodeAlgorithmTest {

	@Test
	public void leastCommonnodeTest1() {
		FakeGraph graph = new FakeGraph();
		LeastCommonNodeInput<String, String> input = new LeastCommonNodeInput<String, String>();
		input.setGraph(graph);
		input.setNodes(new HashSet<String>(Arrays.asList("A", "C")));
		LeastCommonNodeAlgorithm<String, String> algorithm = new LeastCommonNodeAlgorithm<String, String>();
		LeastCommonNodeOutput<String, String> output = (LeastCommonNodeOutput<String, String>) graph.applyAlgorithm(algorithm, input);
		assertNotNull(output);
		assertNotNull(output.getLeastCommonNodes());
		assertEquals(1, output.getLeastCommonNodes().size());
		assertTrue(output.getLeastCommonNodes().contains("B"));
	}

	@Test
	public void leastCommonnodeTest2() {
		FakeGraph graph = new FakeGraph();
		LeastCommonNodeInput<String, String> input = new LeastCommonNodeInput<String, String>();
		input.setGraph(graph);
		input.setNodes(new HashSet<String>(Arrays.asList("C", "E")));
		LeastCommonNodeAlgorithm<String, String> algorithm = new LeastCommonNodeAlgorithm<String, String>();
		LeastCommonNodeOutput<String, String> output = (LeastCommonNodeOutput<String, String>) graph.applyAlgorithm(algorithm, input);
		assertNotNull(output);
		assertNotNull(output.getLeastCommonNodes());
		assertEquals(1, output.getLeastCommonNodes().size());
		assertTrue(output.getLeastCommonNodes().contains("C"));
	}
	
	@Test
	public void leastCommonnodeTest3() {
		FakeGraph graph = new FakeGraph();
		LeastCommonNodeInput<String, String> input = new LeastCommonNodeInput<String, String>();
		input.setGraph(graph);
		input.setNodes(new HashSet<String>(Arrays.asList("F", "A")));
		LeastCommonNodeAlgorithm<String, String> algorithm = new LeastCommonNodeAlgorithm<String, String>();
		LeastCommonNodeOutput<String, String> output = (LeastCommonNodeOutput<String, String>) graph.applyAlgorithm(algorithm, input);
		assertNotNull(output);
		assertNotNull(output.getLeastCommonNodes());
		assertEquals(1, output.getLeastCommonNodes().size());
		assertTrue(output.getLeastCommonNodes().contains("F"));
	}
	
	@Test
	public void leastCommonnodeTest4() {
		FakeGraph graph = new FakeGraph();
		LeastCommonNodeInput<String, String> input = new LeastCommonNodeInput<String, String>();
		input.setGraph(graph);
		input.setNodes(new HashSet<String>(Arrays.asList("G", "H")));
		LeastCommonNodeAlgorithm<String, String> algorithm = new LeastCommonNodeAlgorithm<String, String>();
		LeastCommonNodeOutput<String, String> output = (LeastCommonNodeOutput<String, String>) graph.applyAlgorithm(algorithm, input);
		assertNotNull(output);
		assertNotNull(output.getLeastCommonNodes());
		assertEquals(2, output.getLeastCommonNodes().size());
		assertTrue(output.getLeastCommonNodes().contains("I"));
		assertTrue(output.getLeastCommonNodes().contains("J"));
	}
	
	@Test
	public void leastCommonnodeTest5() {
		FakeGraph graph = new FakeGraph();
		LeastCommonNodeInput<String, String> input = new LeastCommonNodeInput<String, String>();
		input.setGraph(graph);
		input.setNodes(new HashSet<String>(Arrays.asList("E", "G")));
		LeastCommonNodeAlgorithm<String, String> algorithm = new LeastCommonNodeAlgorithm<String, String>();
		LeastCommonNodeOutput<String, String> output = (LeastCommonNodeOutput<String, String>) graph.applyAlgorithm(algorithm, input);
		assertNotNull(output);
		assertTrue(output.getLeastCommonNodes().isEmpty());
	}
}

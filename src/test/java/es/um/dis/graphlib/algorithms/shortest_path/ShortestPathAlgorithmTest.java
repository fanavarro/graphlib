package es.um.dis.graphlib.algorithms.shortest_path;

import static org.junit.Assert.*;

import org.junit.Test;

import es.um.dis.graphlib.FakeGraph;
import es.um.dis.graphlib.algorithms.shortest_path.ShortestPathAlgorithm;
import es.um.dis.graphlib.algorithms.shortest_path.ShortestPathInput;
import es.um.dis.graphlib.algorithms.shortest_path.ShortestPathOutput;



/**
 * The Class ShortestPathAlgorithmTest.
 */
public class ShortestPathAlgorithmTest {

	/**
	 * Test shortest path 1.
	 */
	@Test
	public void testShortestPath1() {
		FakeGraph graph = new FakeGraph();
		ShortestPathInput<String, String> shortestPathInput = new ShortestPathInput<String,String>();
		shortestPathInput.setSourceNode("A");
		shortestPathInput.setTargetNode("C");
		ShortestPathAlgorithm<String, String> algorithm= new ShortestPathAlgorithm<String, String>();
		ShortestPathOutput<String, String> output = (ShortestPathOutput<String, String>) graph.applyAlgorithm(algorithm, shortestPathInput);
		assertNotNull(output);
		assertEquals(2, output.getPath().size());
		assertEquals("A", output.getPath().get(0).getSource());
		assertEquals("1", output.getPath().get(0).getEdges().iterator().next());
		assertEquals("B", output.getPath().get(0).getTarget());
		assertEquals("B", output.getPath().get(1).getSource());
		assertEquals("2", output.getPath().get(1).getEdges().iterator().next());
		assertEquals("C", output.getPath().get(1).getTarget());
	}

	/**
	 * Test shortest path 2.
	 */
	@Test
	public void testShortestPath2() {
		FakeGraph graph = new FakeGraph();
		ShortestPathInput<String, String> shortestPathInput = new ShortestPathInput<String,String>();
		shortestPathInput.setSourceNode("C");
		shortestPathInput.setTargetNode("F");
		ShortestPathAlgorithm<String, String> algorithm= new ShortestPathAlgorithm<String, String>();
		ShortestPathOutput<String, String> output = (ShortestPathOutput<String, String>) graph.applyAlgorithm(algorithm, shortestPathInput);
		assertNotNull(output);
		assertEquals(4, output.getPath().size());
		assertEquals("C", output.getPath().get(0).getSource());
		assertEquals("8", output.getPath().get(0).getEdges().iterator().next());
		assertEquals("B", output.getPath().get(0).getTarget());
		assertEquals("B", output.getPath().get(1).getSource());
		assertEquals("3", output.getPath().get(1).getEdges().iterator().next());
		assertEquals("D", output.getPath().get(1).getTarget());
		assertEquals("D", output.getPath().get(2).getSource());
		assertEquals("4", output.getPath().get(2).getEdges().iterator().next());
		assertEquals("E", output.getPath().get(2).getTarget());
		assertEquals("E", output.getPath().get(3).getSource());
		assertEquals(2, output.getPath().get(3).getEdges().size());
		assertTrue(output.getPath().get(3).getEdges().contains("5"));
		assertTrue(output.getPath().get(3).getEdges().contains("6"));
		assertEquals("F", output.getPath().get(3).getTarget());
	}
	
	/**
	 * Test shortest path 3.
	 */
	@Test
	public void testShortestPath3() {
		FakeGraph graph = new FakeGraph();
		ShortestPathInput<String, String> shortestPathInput = new ShortestPathInput<String,String>();
		shortestPathInput.setSourceNode("C");
		shortestPathInput.setTargetNode("F");
		shortestPathInput.setMaxDepth(2);
		ShortestPathAlgorithm<String, String> algorithm= new ShortestPathAlgorithm<String, String>();
		ShortestPathOutput<String, String> output = (ShortestPathOutput<String, String>) graph.applyAlgorithm(algorithm, shortestPathInput);
		assertNotNull(output);
		assertNull(output.getPath());
		
	}
	
	/**
	 * Test shortest path 4.
	 */
	@Test
	public void testShortestPath4() {
		FakeGraph graph = new FakeGraph();
		ShortestPathInput<String, String> shortestPathInput = new ShortestPathInput<String,String>();
		shortestPathInput.setSourceNode("F");
		shortestPathInput.setTargetNode("A");
		ShortestPathAlgorithm<String, String> algorithm= new ShortestPathAlgorithm<String, String>();
		ShortestPathOutput<String, String> output = (ShortestPathOutput<String, String>) graph.applyAlgorithm(algorithm, shortestPathInput);
		assertNotNull(output);
		assertNull(output.getPath());
	}
	
	/**
	 * Test shortest path 5.
	 */
	@Test
	public void testShortestPath5() {
		FakeGraph graph = new FakeGraph();
		ShortestPathInput<String, String> shortestPathInput = new ShortestPathInput<String,String>();
		shortestPathInput.setSourceNode("E");
		shortestPathInput.setTargetNode("A");
		ShortestPathAlgorithm<String, String> algorithm= new ShortestPathAlgorithm<String, String>();
		ShortestPathOutput<String, String> output = (ShortestPathOutput<String, String>) graph.applyAlgorithm(algorithm, shortestPathInput);
		assertNotNull(output);
		assertNull(output.getPath());
	}

}

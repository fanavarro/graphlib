package com.github.fanavarro.graphlib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.github.fanavarro.graphlib.Graph;
import com.github.fanavarro.graphlib.SimpleGraphImpl;

/**
 * The Class GraphTest.
 */
public class GraphTest {

	/**
	 * Test get adjacent nodes.
	 */
	@Test
	public void testGetAdjacentNodes() {
		FakeGraph graph = new FakeGraph();
		assertEquals(2, graph.getAdjacentNodes("E").size());
		assertTrue(graph.getAdjacentNodes("E").containsAll(Arrays.asList("F", "C")));
	}

	/**
	 * Test get incoming nodes.
	 */
	@Test
	public void testGetIncomingNodes() {
		FakeGraph graph = new FakeGraph();
		assertEquals(incomingNodesB(), graph.getIncomingNodesByEdgeMap("B"));
		assertEquals(incomingNodesF(), graph.getIncomingNodesByEdgeMap("F"));
		assertEquals(new HashSet<String>(Arrays.asList("A", "C")), graph.getIncomingNodes("B"));
		assertEquals(new HashSet<String>(Arrays.asList("E")), graph.getIncomingNodes("F"));
		assertEquals(new HashSet<String>(Arrays.asList("E", "B")), graph.getIncomingNodes("C"));
	}
	
	@Test
	public void testGetIncomingEdges(){
		FakeGraph graph = new FakeGraph();
		assertEquals(new HashSet<String>(), graph.getIncomingEdges("A"));
		assertEquals(new HashSet<String>(Arrays.asList("1", "8")), graph.getIncomingEdges("B"));
		assertEquals(new HashSet<String>(Arrays.asList("2", "7")), graph.getIncomingEdges("C"));
		assertEquals(new HashSet<String>(Arrays.asList("5", "6")), graph.getIncomingEdges("F"));
	}
	
	@Test
	public void testGetAdjacentEdges(){
		FakeGraph graph = new FakeGraph();
		assertEquals(new HashSet<String>(Arrays.asList("1")), graph.getAdjacentEdges("A"));
		assertEquals(new HashSet<String>(Arrays.asList("3", "2")), graph.getAdjacentEdges("B"));
		assertEquals(new HashSet<String>(Arrays.asList("8")), graph.getAdjacentEdges("C"));
		assertEquals(new HashSet<String>(), graph.getAdjacentEdges("F"));
	}
	
	@Test
	public void testIsContainedIn(){
		Graph<String, String> graph = new FakeGraph();
		
		assertTrue(getContainedGraph1().isContainedIn(graph));
		assertTrue(getContainedGraph2().isContainedIn(graph));
		assertTrue(getEmptyGraph().isContainedIn(graph));
		assertFalse(getNotContainedGraph1().isContainedIn(graph));
		assertFalse(getNotContainedGraph2().isContainedIn(graph));
		assertFalse(getNotContainedGraph3().isContainedIn(graph));
		assertFalse(getNotContainedGraph3().isContainedIn(null));
	}

	private Graph<String, String> getContainedGraph1() {
		SimpleGraphImpl<String, String> g = new SimpleGraphImpl<String, String>();
		g.addNode("G", "9", "I");
		g.addNode("G", "10", "J");
		g.addNode("H", "11", "I");
		g.addNode("H", "12", "J");
		return g;
	}
	
	private Graph<String, String> getContainedGraph2() {
		SimpleGraphImpl<String, String> g = new SimpleGraphImpl<String, String>();
		g.addNode("G");
		return g;
	}
	
	private Graph<String, String> getEmptyGraph() {
		SimpleGraphImpl<String, String> g = new SimpleGraphImpl<String, String>();
		return g;
	}
	
	private Graph<String, String> getNotContainedGraph1() {
		SimpleGraphImpl<String, String> g = new SimpleGraphImpl<String, String>();
		g.addNode("D", "1", "G");
		return g;
	}
	private Graph<String, String> getNotContainedGraph2() {
		SimpleGraphImpl<String, String> g = new SimpleGraphImpl<String, String>();
		g.addNode("X", "1", "Y");
		return g;
	}
	private Graph<String, String> getNotContainedGraph3() {
		SimpleGraphImpl<String, String> g = new SimpleGraphImpl<String, String>();
		g.addNode("A", "1", "G");
		return g;
	}

	/**
	 * Test equals 1.
	 */
	@Test
	public void testEquals1() {
		FakeGraph g1 = new FakeGraph();
		FakeGraph g2 = new FakeGraph();

		assertTrue(g1.equals(g1));
		assertTrue(g1.equals(g2));
		assertTrue(g2.equals(g1));
		assertFalse(g1.equals(null));
	}

	/**
	 * Test equals 2.
	 */
	@Test
	public void testEquals2() {
		SimpleGraphImpl<Integer, Integer> g3 = new SimpleGraphImpl<Integer, Integer>();
		g3.addNode(1);
		SimpleGraphImpl<Integer, Integer> g4 = new SimpleGraphImpl<Integer, Integer>();
		g4.addNode(1);
		assertTrue(g3.equals(g3));
		assertTrue(g4.equals(g4));
		assertTrue(g3.equals(g4));
		assertTrue(g4.equals(g3));

		g3.addNode(1, 10, 3);
		g4.addNode(1, 11, 3);

		assertFalse(g3.equals(g4));
		assertFalse(g4.equals(g3));
	}

	/**
	 * Incoming nodes B.
	 *
	 * @return the map
	 */
	private Map<String, Set<String>> incomingNodesB() {
		Map<String, Set<String>> expected = new HashMap<String, Set<String>>();
		expected.put("1", new HashSet<String>(Arrays.asList("A")));
		expected.put("8", new HashSet<String>(Arrays.asList("C")));
		return expected;
	}

	/**
	 * Incoming nodes F.
	 *
	 * @return the map
	 */
	private Map<String, Set<String>> incomingNodesF() {
		Map<String, Set<String>> expected = new HashMap<String, Set<String>>();
		expected.put("5", new HashSet<String>(Arrays.asList("E")));
		expected.put("6", new HashSet<String>(Arrays.asList("E")));
		return expected;
	}
}

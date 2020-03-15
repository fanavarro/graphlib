package es.um.dis.graphlib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

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
		assertEquals(incomingNodesB(), graph.getIncomingNodesWithedges("B"));
		assertEquals(incomingNodesF(), graph.getIncomingNodesWithedges("F"));
		assertEquals(new HashSet<String>(Arrays.asList("A", "C")), graph.getIncomingNodes("B"));
		assertEquals(new HashSet<String>(Arrays.asList("E")), graph.getIncomingNodes("F"));
		assertEquals(new HashSet<String>(Arrays.asList("E", "B")), graph.getIncomingNodes("C"));
	}

	@Test
	public void testEquals() {
		FakeGraph g1 = new FakeGraph();
		FakeGraph g2 = new FakeGraph();
		SimpleGraphImpl<Integer, Integer> g3 = new SimpleGraphImpl<Integer, Integer>();
		g3.addNode(1);
		SimpleGraphImpl<Integer, Integer> g4 = new SimpleGraphImpl<Integer, Integer>();
		g4.addNode(1);

		assertTrue(g1.equals(g1));
		assertTrue(g1.equals(g2));
		assertTrue(g2.equals(g1));
		assertFalse(g1.equals(null));
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

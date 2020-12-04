package com.github.fanavarro.graphlib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.meanbean.test.EqualsMethodTester;
import org.meanbean.test.HashCodeMethodTester;

import com.github.fanavarro.graphlib.Graph;
import com.github.fanavarro.graphlib.SimpleGraphImpl;
import com.github.fanavarro.graphlib.test_config.GraphTestFactory;

/**
 * The Class SimpleGraphImplTest.
 */
public class SimpleGraphImplTest {

	/**
	 * Test get nodes.
	 */
	@Test
	public void testGetNodes() {
		SimpleGraphImpl<String, String> graph = this.createTestGraph1();
		assertNotNull(graph);
		assertEquals(new HashSet<String>(Arrays.asList("A", "B", "C", "D")), graph.getNodes());
		assertEquals(new HashSet<String>(Arrays.asList("B", "C")), graph.getAdjacentNodes("A"));
		assertEquals(new HashSet<String>(Arrays.asList("A")), graph.getSourceNodes("1"));
		assertEquals(new HashSet<String>(Arrays.asList("B")), graph.getTargetNodes("1"));
		
		graph = this.createTestGraph2();
		assertEquals(new HashSet<String>(Arrays.asList("A", "C")), graph.getSourceNodes("1"));
		assertEquals(new HashSet<String>(Arrays.asList("B", "D")), graph.getTargetNodes("1"));
		
		 Map<String, Set<String>> edgesByIncomingNodesMap = graph.getEdgesByIncomingNodesMap("B");
		 assertEquals(new HashSet<String>(Arrays.asList("A")), edgesByIncomingNodesMap.keySet());
		 assertEquals(new HashSet<String>(Arrays.asList("1")), edgesByIncomingNodesMap.get("A"));
	}

	/**
	 * Test get adjacent nodes with edges.
	 */
	@Test
	public void testGetAdjacentNodesWithEdges() {
		SimpleGraphImpl<String, String> graph = this.createTestGraph1();
		assertNotNull(graph);
		Map<String, Set<String>> adjacentNodes = graph.getAdjacentNodesByEdgeMap("A");
		assertEquals(new HashSet<String>(Arrays.asList("1", "2")), adjacentNodes.keySet());
		assertEquals(new HashSet<String>(Arrays.asList("B")), adjacentNodes.get("1"));
		assertEquals(new HashSet<String>(Arrays.asList("C")), adjacentNodes.get("2"));
	}

	/**
	 * Test add node N.
	 */
	@Test
	public void testAddNodeN() {
		SimpleGraphImpl<String, String> graph = new SimpleGraphImpl<String, String>();
		assertTrue(graph.getNodes().isEmpty());
		graph.addNode("A");
		assertEquals(new HashSet<String>(Arrays.asList("A")), graph.getNodes());
		assertTrue(graph.getAdjacentNodes("A").isEmpty());
		assertTrue(graph.getAdjacentNodesByEdgeMap("A").isEmpty());

		graph.addNode("A");
		assertEquals(1, graph.getNodes().size());
	}

	/**
	 * Test add node NEN.
	 */
	@Test
	public void testAddNodeNEN() {
		SimpleGraphImpl<String, String> graph = new SimpleGraphImpl<String, String>();
		assertTrue(graph.getNodes().isEmpty());
		graph.addNode("A", "1", "B");
		assertEquals(new HashSet<String>(Arrays.asList("A", "B")), graph.getNodes());
		assertEquals(new HashSet<String>(Arrays.asList("B")), graph.getAdjacentNodes("A"));
		assertEquals(new HashSet<String>(Arrays.asList("B")), graph.getAdjacentNodesByEdgeMap("A").get("1"));

		graph.addNode("A");
		graph.addNode("B");
		assertEquals(2, graph.getNodes().size());

		graph.addNode("C");
		graph.addNode("B", "2", "C");
	}

	/**
	 * Test add node NE set of N.
	 */
	@Test
	public void testAddNodeNESetOfN() {
		SimpleGraphImpl<String, String> graph = new SimpleGraphImpl<String, String>();
		assertTrue(graph.getNodes().isEmpty());
		graph.addNode("A", "1", new HashSet<String>(Arrays.asList("B", "C", "D")));
		assertEquals(new HashSet<String>(Arrays.asList("A", "B", "C", "D")), graph.getNodes());
		assertEquals(new HashSet<String>(Arrays.asList("B", "C", "D")), graph.getAdjacentNodes("A"));
		assertEquals(new HashSet<String>(Arrays.asList("B", "C", "D")), graph.getAdjacentNodesByEdgeMap("A").get("1"));

		graph.addNode("A");
		graph.addNode("B");
		assertEquals(4, graph.getNodes().size());
	}

	/**
	 * Test remove 1.
	 */
	@Test
	public void testRemove1() {
		SimpleGraphImpl<String, String> graph = createTestGraph1();
		SimpleGraphImpl<String, String> expected = this.getExpectedGraphTestRemove1();
		graph.removeNode("C");

		assertEquals(expected, graph);
	}

	/**
	 * Test remove 2.
	 */
	@Test
	public void testRemove2() {
		SimpleGraphImpl<String, String> graph = createTestGraph1();
		SimpleGraphImpl<String, String> expected = this.getExpectedGraphTestRemove2();
		graph.removeNode("D");

		assertEquals(expected, graph);
	}

	/**
	 * Test remove 3.
	 */
	@Test
	public void testRemove3() {
		SimpleGraphImpl<String, String> graph = createTestGraph2();
		SimpleGraphImpl<String, String> expected = this.getExpectedGraphTestRemove3();
		graph.removeNode("C");

		assertEquals(expected, graph);
	}

	/**
	 * Test remove 4.
	 */
	@Test
	public void testRemove4() {
		SimpleGraphImpl<String, String> graph = createTestGraph2();
		SimpleGraphImpl<String, String> expected = this.getExpectedGraphTestRemove4();
		graph.removeNode("B");

		assertEquals(expected, graph);
	}

	/**
	 * Test remove link 1.
	 */
	@Test
	public void testRemoveLink1() {
		SimpleGraphImpl<String, String> graph = createTestGraph1();
		SimpleGraphImpl<String, String> expected = this.getExpectedGraphTestRemoveLink1();
		graph.removeLink("C", "3", "D");
		assertEquals(expected, graph);
	}
	
	/**
	 * Test is empty.
	 */
	@Test
	public void testIsEmpty(){
		SimpleGraphImpl<String, String> graph = createTestGraph1();
		assertFalse(graph.isEmpty());
		
		SimpleGraphImpl<String, String> emptyGraph = new SimpleGraphImpl<String, String>();
		assertTrue(emptyGraph.isEmpty());
	}

	/**
	 * Test equals object.
	 */
	@Test
	public void testEqualsObject() {
		assertTrue(new SimpleGraphImpl<String, String>().equals(new SimpleGraphImpl<String, String>()));
		SimpleGraphImpl<String, String> g1 = this.createTestGraph1();
		SimpleGraphImpl<String, String> g2 = this.createTestGraph1();

		assertTrue(g1.equals(g2));
		assertTrue(g2.equals(g1));
		assertTrue(g1.equals(g1));
		assertTrue(g2.equals(g2));
		assertTrue(g1.hashCode() == g2.hashCode());

		g2.addNode("X");
		assertTrue(!g1.equals(g2));
		assertTrue(!g2.equals(g1));
		assertTrue(!g1.equals(null));
		assertTrue(!g1.equals(new String()));

		assertTrue(g1.hashCode() != g2.hashCode());
	}

	/**
	 * Test equals.
	 */
	@Test
	public void testEquals() {
		EqualsMethodTester tester = new EqualsMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testEqualsMethod(SimpleGraphImpl.class);
	}

	/**
	 * Test hash.
	 */
	@Test
	public void testHash() {
		HashCodeMethodTester tester = new HashCodeMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testHashCodeMethod(SimpleGraphImpl.class);
	}

	/**
	 * Creates the test graph.
	 *
	 * @return the simple graph impl
	 */
	private SimpleGraphImpl<String, String> createTestGraph1() {
		SimpleGraphImpl<String, String> graph = new SimpleGraphImpl<String, String>();
		graph.addNode("A", "1", "B");
		graph.addNode("A", "2", "C");
		graph.addNode("C", "3", "D");
		return graph;
	}

	/**
	 * Creates the test graph.
	 *
	 * @return the simple graph impl
	 */
	private SimpleGraphImpl<String, String> createTestGraph2() {
		SimpleGraphImpl<String, String> graph = new SimpleGraphImpl<String, String>();
		graph.addNode("A", "1", "B");
		graph.addNode("A", "2", "C");
		graph.addNode("C", new HashSet<String>(Arrays.asList("1", "3")), "D");
		return graph;
	}

	/**
	 * Gets the expected graph test remove 1.
	 *
	 * @return the expected graph test remove 1
	 */
	private SimpleGraphImpl<String, String> getExpectedGraphTestRemove1() {
		SimpleGraphImpl<String, String> graph = new SimpleGraphImpl<String, String>();
		graph.addNode("A", "1", "B");
		graph.addNode("D");
		return graph;
	}

	/**
	 * Gets the expected graph test remove 2.
	 *
	 * @return the expected graph test remove 2
	 */
	private SimpleGraphImpl<String, String> getExpectedGraphTestRemove2() {
		SimpleGraphImpl<String, String> graph = new SimpleGraphImpl<String, String>();
		graph.addNode("A", "1", "B");
		graph.addNode("A", "2", "C");
		return graph;
	}

	/**
	 * Gets the expected graph test remove 3.
	 *
	 * @return the expected graph test remove 3
	 */
	private SimpleGraphImpl<String, String> getExpectedGraphTestRemove3() {
		return getExpectedGraphTestRemove1();
	}

	/**
	 * Gets the expected graph test remove 4.
	 *
	 * @return the expected graph test remove 4
	 */
	private SimpleGraphImpl<String, String> getExpectedGraphTestRemove4() {
		SimpleGraphImpl<String, String> graph = new SimpleGraphImpl<String, String>();
		graph.addNode("A", "2", "C");
		graph.addNode("C", new HashSet<String>(Arrays.asList("1", "3")), "D");
		return graph;
	}

	/**
	 * Gets the expected graph test remove link 1.
	 *
	 * @return the expected graph test remove link 1
	 */
	private SimpleGraphImpl<String, String> getExpectedGraphTestRemoveLink1() {
		SimpleGraphImpl<String, String> graph = new SimpleGraphImpl<String, String>();
		graph.addNode("A", "1", "B");
		graph.addNode("A", "2", "C");
		return graph;
	}

}

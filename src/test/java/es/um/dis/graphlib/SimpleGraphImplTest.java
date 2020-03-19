package es.um.dis.graphlib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.meanbean.test.EqualsMethodTester;
import org.meanbean.test.HashCodeMethodTester;

import es.um.dis.graphlib.test_config.GraphTestFactory;



/**
 * The Class SimpleGraphImplTest.
 */
public class SimpleGraphImplTest {

	/**
	 * Test get nodes.
	 */
	@Test
	public void testGetNodes() {
		SimpleGraphImpl<String, String> graph = this.createTestGraph();
		assertNotNull(graph);
		assertEquals(new HashSet<String>(Arrays.asList("A","B", "C", "D")), graph.getNodes());
	}

	/**
	 * Test get adjacent nodes with edges.
	 */
	@Test
	public void testGetAdjacentNodesWithEdges() {
		SimpleGraphImpl<String, String> graph = this.createTestGraph();
		assertNotNull(graph);
		Map<String, Set<String>> adjacentNodes = graph.getAdjacentNodesWithEdges("A");
		assertEquals(new HashSet<String>(Arrays.asList("1","2")), adjacentNodes.keySet());
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
		assertTrue(graph.getAdjacentNodesWithEdges("A").isEmpty());
		
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
		assertEquals(new HashSet<String>(Arrays.asList("B")), graph.getAdjacentNodesWithEdges("A").get("1"));
		
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
		assertEquals(new HashSet<String>(Arrays.asList("B", "C", "D")), graph.getAdjacentNodesWithEdges("A").get("1"));
		
		graph.addNode("A");
		graph.addNode("B");
		assertEquals(4, graph.getNodes().size());
	}

	/**
	 * Test equals object.
	 */
	@Test
	public void testEqualsObject() {
		assertTrue(new SimpleGraphImpl<String, String>().equals(new SimpleGraphImpl<String, String>()));
		SimpleGraphImpl<String, String> g1 = this.createTestGraph();
		SimpleGraphImpl<String, String> g2 = this.createTestGraph();
		
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
	public void testEquals(){
		EqualsMethodTester tester = new EqualsMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testEqualsMethod(SimpleGraphImpl.class);
	}
	
	/**
	 * Test hash.
	 */
	@Test
	public void testHash(){
		HashCodeMethodTester tester = new HashCodeMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testHashCodeMethod(SimpleGraphImpl.class);
	}
	
	/**
	 * Creates the test graph.
	 *
	 * @return the simple graph impl
	 */
	private SimpleGraphImpl<String, String> createTestGraph(){
		SimpleGraphImpl<String, String> graph = new SimpleGraphImpl<String, String>();
		graph.addNode("A", "1", "B");
		graph.addNode("A", "2", "C");
		graph.addNode("C", "3", "D");
		return graph;
	}

}

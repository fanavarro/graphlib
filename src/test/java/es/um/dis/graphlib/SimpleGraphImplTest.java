package es.um.dis.graphlib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class SimpleGraphImplTest {

	@Test
	public void testGetNodes() {
		SimpleGraphImpl<String, String> graph = this.createTestGraph();
		assertNotNull(graph);
		assertEquals(new HashSet<String>(Arrays.asList("A","B", "C", "D")), graph.getNodes());
	}

	@Test
	public void testGetAdjacentNodesWithEdges() {
		SimpleGraphImpl<String, String> graph = this.createTestGraph();
		assertNotNull(graph);
		Map<String, Set<String>> adjacentNodes = graph.getAdjacentNodesWithEdges("A");
		assertEquals(new HashSet<String>(Arrays.asList("1","2")), adjacentNodes.keySet());
		assertEquals(new HashSet<String>(Arrays.asList("B")), adjacentNodes.get("1"));
		assertEquals(new HashSet<String>(Arrays.asList("C")), adjacentNodes.get("2"));
	}


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
	}

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

	@Test
	public void testEqualsObject() {
		SimpleGraphImpl<String, String> g1 = this.createTestGraph();
		SimpleGraphImpl<String, String> g2 = this.createTestGraph();
		
		assertTrue(g1.equals(g2));
		assertTrue(g2.equals(g1));
		
		g2.addNode("X");
		assertTrue(!g1.equals(g2));
		assertTrue(!g2.equals(g1));
	}
	
	private SimpleGraphImpl<String, String> createTestGraph(){
		SimpleGraphImpl<String, String> graph = new SimpleGraphImpl<String, String>();
		graph.addNode("A", "1", "B");
		graph.addNode("A", "2", "C");
		graph.addNode("C", "3", "D");
		return graph;
	}

}

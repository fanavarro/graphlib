package es.um.dis.graphlib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class GraphTest {
	
	@Test
	public void testGetAdjacentNodes(){
		FakeGraph graph = new FakeGraph();
		assertEquals(2, graph.getAdjacentNodes("E").size());
		assertTrue(graph.getAdjacentNodes("E").containsAll(Arrays.asList("F","C")));
	}
	
	@Test
	public void testGetIncomingNodes(){
		FakeGraph graph = new FakeGraph();
		assertEquals(incomingNodesB(), graph.getIncomingNodesWithedges("B"));
		assertEquals(incomingNodesF(), graph.getIncomingNodesWithedges("F"));
		assertEquals(new HashSet<String>(Arrays.asList("A", "C")), graph.getIncomingNodes("B"));
		assertEquals(new HashSet<String>(Arrays.asList("E")), graph.getIncomingNodes("F"));
		assertEquals(new HashSet<String>(Arrays.asList("E", "B")), graph.getIncomingNodes("C"));
	}
	
	private Map<String, Set<String>> incomingNodesB(){
		Map<String, Set<String>> expected = new HashMap<String, Set<String>>();
		expected.put("1", new HashSet<String>(Arrays.asList("A")));
		expected.put("8", new HashSet<String>(Arrays.asList("C")));
		return expected;
	}
	
	private Map<String, Set<String>> incomingNodesF(){
		Map<String, Set<String>> expected = new HashMap<String, Set<String>>();
		expected.put("5", new HashSet<String>(Arrays.asList("E")));
		expected.put("6", new HashSet<String>(Arrays.asList("E")));
		return expected;
	}
}

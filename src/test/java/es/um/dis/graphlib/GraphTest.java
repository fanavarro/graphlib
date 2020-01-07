package es.um.dis.graphlib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class GraphTest {
	
	@Test
	public void testGetNodes(){
		FakeGraph graph = new FakeGraph();
		assertEquals(2, graph.getAdjacentNodes("E").size());
		assertTrue(graph.getAdjacentNodes("E").containsAll(Arrays.asList("F","C")));
	}
}

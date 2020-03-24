package es.um.dis.graphlib.algorithms.islands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import es.um.dis.graphlib.FakeGraph;
import es.um.dis.graphlib.Graph;
import es.um.dis.graphlib.SimpleGraphImpl;
import es.um.dis.graphlib.algorithms.Algorithm;

public class IslandsAlgorithmTest {

	@Test
	public void testIgnoringEdgeDirection() {
		Algorithm<String, String> algorithm = new IslandsAlgorithm<String, String>();
		IslandsInput<String, String> input = new IslandsInput<String, String>();
		input.setGraph(new FakeGraph());
		input.setIgnoreEdgeDirection(true);
		IslandsOutput<String, String> output = (IslandsOutput<String, String>) algorithm.apply(input);
		assertNotNull(output);
		assertNotNull(output.getIslands());
		assertEquals(2, output.getIslands().size());
		assertEquals(getExpectedIslandsIgnoringEdgeDirection(), output.getIslands());
	}
	
	@Test
	public void testNotIgnoringEdgeDirection() {
		Algorithm<String, String> algorithm = new IslandsAlgorithm<String, String>();
		IslandsInput<String, String> input = new IslandsInput<String, String>();
		input.setGraph(new FakeGraph());
		input.setIgnoreEdgeDirection(false);
		IslandsOutput<String, String> output = (IslandsOutput<String, String>) algorithm.apply(input);
		assertNotNull(output);
		assertNotNull(output.getIslands());
		assertEquals(3, output.getIslands().size());
		assertEquals(getExpectedIslandsNotIgnoringEdgeDirection(), output.getIslands());
	}

	private Set<Graph<String, String>> getExpectedIslandsIgnoringEdgeDirection(){
		Set<Graph<String, String>> islands = new HashSet<Graph<String, String>>();
		islands.add(getExpectedIsland1());
		islands.add(getExpectedIsland2());
		return islands;
	}
	
	private Set<Graph<String, String>> getExpectedIslandsNotIgnoringEdgeDirection(){
		Set<Graph<String, String>> islands = new HashSet<Graph<String, String>>();
		islands.add(getExpectedIsland1());
		islands.add(getExpectedIsland3());
		islands.add(getExpectedIsland4());
		return islands;
	}

	private Graph<String, String> getExpectedIsland1() {
		SimpleGraphImpl<String, String> g = new SimpleGraphImpl<String, String>();
		g.addNode("A", "1", "B");
		g.addNode("B", "2", "C");
		g.addNode("B", "3", "D");
		g.addNode("C", "8", "B");
		g.addNode("D", "4", "E");
		g.addNode("E", "7", "C");
		g.addNode("E", "5", "F");
		g.addNode("E", "6", "F");
		return g;
	}

	private Graph<String, String> getExpectedIsland2() {
		SimpleGraphImpl<String, String> g = new SimpleGraphImpl<String, String>();
		g.addNode("G", "9", "I");
		g.addNode("G", "10", "J");
		g.addNode("H", "11", "I");
		g.addNode("H", "12", "J");
		return g;
	}
	
	private Graph<String, String> getExpectedIsland3() {
		SimpleGraphImpl<String, String> g = new SimpleGraphImpl<String, String>();
		g.addNode("G", "9", "I");
		g.addNode("G", "10", "J");
		return g;
	}
	
	private Graph<String, String> getExpectedIsland4() {
		SimpleGraphImpl<String, String> g = new SimpleGraphImpl<String, String>();
		g.addNode("H", "11", "I");
		g.addNode("H", "12", "J");
		return g;
	}
}

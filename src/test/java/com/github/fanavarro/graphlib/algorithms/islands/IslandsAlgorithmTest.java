package com.github.fanavarro.graphlib.algorithms.islands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.github.fanavarro.graphlib.FakeGraph;
import com.github.fanavarro.graphlib.Graph;
import com.github.fanavarro.graphlib.SimpleGraphImpl;
import com.github.fanavarro.graphlib.algorithms.Algorithm;
import com.github.fanavarro.graphlib.algorithms.islands.IslandsAlgorithm;
import com.github.fanavarro.graphlib.algorithms.islands.IslandsInput;
import com.github.fanavarro.graphlib.algorithms.islands.IslandsOutput;

/**
 * The Class IslandsAlgorithmTest.
 */
public class IslandsAlgorithmTest {

	/**
	 * Test ignoring edge direction.
	 */
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
	
	/**
	 * Test not ignoring edge direction.
	 */
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
	
	/**
	 * Test conflictive graph.
	 */
	@Test
	public void testConflictiveGraph() {
		Algorithm<String, String> algorithm = new IslandsAlgorithm<String, String>();
		IslandsInput<String, String> input = new IslandsInput<String, String>();
		input.setGraph(new AnotherFakeGraph());
		input.setIgnoreEdgeDirection(false);
		IslandsOutput<String, String> output = (IslandsOutput<String, String>) algorithm.apply(input);
		assertNotNull(output);
		assertNotNull(output.getIslands());
		assertEquals(2, output.getIslands().size());
		assertEquals(getExpectedIslandsConflictiveGraph(), output.getIslands());
	}

	/**
	 * Gets the expected islands ignoring edge direction.
	 *
	 * @return the expected islands ignoring edge direction
	 */
	private Set<Graph<String, String>> getExpectedIslandsIgnoringEdgeDirection(){
		Set<Graph<String, String>> islands = new HashSet<Graph<String, String>>();
		islands.add(getExpectedIsland1());
		islands.add(getExpectedIsland2());
		return islands;
	}
	
	/**
	 * Gets the expected islands not ignoring edge direction.
	 *
	 * @return the expected islands not ignoring edge direction
	 */
	private Set<Graph<String, String>> getExpectedIslandsNotIgnoringEdgeDirection(){
		Set<Graph<String, String>> islands = new HashSet<Graph<String, String>>();
		islands.add(getExpectedIsland1());
		islands.add(getExpectedIsland3());
		islands.add(getExpectedIsland4());
		return islands;
	}
	
	/**
	 * Gets the expected islands conflictive graph.
	 *
	 * @return the expected islands conflictive graph
	 */
	private Set<Graph<String, String>> getExpectedIslandsConflictiveGraph(){
		Set<Graph<String, String>> islands = new HashSet<Graph<String, String>>();
		islands.add(getExpectedIsland5());
		islands.add(getExpectedIsland6());
		return islands;
	}

	/**
	 * Gets the expected island 1.
	 *
	 * @return the expected island 1
	 */
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

	/**
	 * Gets the expected island 2.
	 *
	 * @return the expected island 2
	 */
	private Graph<String, String> getExpectedIsland2() {
		SimpleGraphImpl<String, String> g = new SimpleGraphImpl<String, String>();
		g.addNode("G", "9", "I");
		g.addNode("G", "10", "J");
		g.addNode("H", "11", "I");
		g.addNode("H", "12", "J");
		return g;
	}
	
	/**
	 * Gets the expected island 3.
	 *
	 * @return the expected island 3
	 */
	private Graph<String, String> getExpectedIsland3() {
		SimpleGraphImpl<String, String> g = new SimpleGraphImpl<String, String>();
		g.addNode("G", "9", "I");
		g.addNode("G", "10", "J");
		return g;
	}
	
	/**
	 * Gets the expected island 4.
	 *
	 * @return the expected island 4
	 */
	private Graph<String, String> getExpectedIsland4() {
		SimpleGraphImpl<String, String> g = new SimpleGraphImpl<String, String>();
		g.addNode("H", "11", "I");
		g.addNode("H", "12", "J");
		return g;
	}
	
	/**
	 * Gets the expected island 5.
	 *
	 * @return the expected island 5
	 */
	private Graph<String, String> getExpectedIsland5() {
		SimpleGraphImpl<String, String> g = new SimpleGraphImpl<String, String>();
		g.addNode("C", "1", "A");
		g.addNode("C", "2", "B");
		return g;
	}
	
	/**
	 * Gets the expected island 6.
	 *
	 * @return the expected island 6
	 */
	private Graph<String, String> getExpectedIsland6() {
		SimpleGraphImpl<String, String> g = new SimpleGraphImpl<String, String>();
		g.addNode("D", "3", "A");
		g.addNode("D", "4", "B");
		return g;
	}
	
	/**
	 * The Class AnotherFakeGraph.
	 */
	private class AnotherFakeGraph extends SimpleGraphImpl<String, String>{
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1924974165350966390L;

		/**
		 * Instantiates a new another fake graph.
		 */
		public AnotherFakeGraph(){
			super();
			this.addNode("C", "1", "A");
			this.addNode("C", "2", "B");
			this.addNode("D", "3", "A");
			this.addNode("D", "4", "B");
		}
	}
}

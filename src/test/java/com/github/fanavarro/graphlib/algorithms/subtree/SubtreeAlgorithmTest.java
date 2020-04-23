package com.github.fanavarro.graphlib.algorithms.subtree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.github.fanavarro.graphlib.FakeGraph;
import com.github.fanavarro.graphlib.SimpleTreeImpl;
import com.github.fanavarro.graphlib.Tree;
import com.github.fanavarro.graphlib.algorithms.Algorithm;
import com.github.fanavarro.graphlib.algorithms.subtree.SubtreeAlgorithm;
import com.github.fanavarro.graphlib.algorithms.subtree.SubtreeInput;
import com.github.fanavarro.graphlib.algorithms.subtree.SubtreeOutput;

/**
 * The Class SubtreeAlgorithmTests.
 */
public class SubtreeAlgorithmTest {

	/**
	 * Subtree algorithm test 1.
	 */
	@Test
	public void subtreeAlgorithmTest1() {
		FakeGraph graph = new FakeGraph();
		Algorithm<String, String> algorithm = new SubtreeAlgorithm<String, String>();

		Set<String> nodesToContain = new HashSet<String>(Arrays.asList("B", "C", "F"));
		SubtreeInput<String, String> input = new SubtreeInput<String, String>();
		input.setGraph(graph);
		input.setNodesToBeContained(nodesToContain);

		SubtreeOutput<String, String> output = (SubtreeOutput<String, String>) algorithm.apply(input);
		assertNotNull(output);
		assertNotNull(output.getTrees());
		assertTrue(!output.getTrees().isEmpty());

		Set<Tree<String, String>> expectedTrees = createExpectedTreesForTest1();
		assertEquals(expectedTrees, output.getTrees());
	}

	/**
	 * Subtree algorithm test 2.
	 */
	@Test
	public void subtreeAlgorithmTest2() {
		FakeGraph graph = new FakeGraph();
		Algorithm<String, String> algorithm = new SubtreeAlgorithm<String, String>();

		Set<String> nodesToContain = new HashSet<String>(Arrays.asList("I", "G", "J"));
		SubtreeInput<String, String> input = new SubtreeInput<String, String>();
		input.setGraph(graph);
		input.setNodesToBeContained(nodesToContain);

		SubtreeOutput<String, String> output = (SubtreeOutput<String, String>) algorithm.apply(input);
		assertNotNull(output);
		assertNotNull(output.getTrees());
		assertTrue(!output.getTrees().isEmpty());

		Set<Tree<String, String>> expectedTrees = createExpectedTreesForTest2();
		assertEquals(expectedTrees, output.getTrees());
	}

	/**
	 * Subtree algorithm test 3.
	 */
	@Test
	public void subtreeAlgorithmTest3() {
		FakeGraph graph = new FakeGraph();
		Algorithm<String, String> algorithm = new SubtreeAlgorithm<String, String>();

		Set<String> nodesToContain = new HashSet<String>(Arrays.asList("I", "G", "H"));
		SubtreeInput<String, String> input = new SubtreeInput<String, String>();
		input.setGraph(graph);
		input.setNodesToBeContained(nodesToContain);

		SubtreeOutput<String, String> output = (SubtreeOutput<String, String>) algorithm.apply(input);
		assertNotNull(output);
		assertNotNull(output.getTrees());
		assertTrue(output.getTrees().isEmpty());
	}

	/**
	 * Subtree algorithm test 4.
	 */
	@Test
	public void subtreeAlgorithmTest4() {
		FakeGraph graph = new FakeGraph();
		Algorithm<String, String> algorithm = new SubtreeAlgorithm<String, String>();

		Set<String> nodesToContain = new HashSet<String>(Arrays.asList("I", "J"));
		SubtreeInput<String, String> input = new SubtreeInput<String, String>();
		input.setGraph(graph);
		input.setNodesToBeContained(nodesToContain);

		SubtreeOutput<String, String> output = (SubtreeOutput<String, String>) algorithm.apply(input);
		assertNotNull(output);
		assertNotNull(output.getTrees());
		assertTrue(!output.getTrees().isEmpty());

		Set<Tree<String, String>> expectedTrees = createExpectedTreesForTest4();
		assertEquals(expectedTrees, output.getTrees());
	}
	
	/**
	 * Subtree algorithm test 5.
	 */
	@Test
	public void subtreeAlgorithmTest5() {
		FakeGraph graph = new FakeGraph();
		Algorithm<String, String> algorithm = new SubtreeAlgorithm<String, String>();

		Set<String> nodesToContain = new HashSet<String>(Arrays.asList("A", "B"));
		SubtreeInput<String, String> input = new SubtreeInput<String, String>();
		input.setGraph(graph);
		input.setNodesToBeContained(nodesToContain);

		SubtreeOutput<String, String> output = (SubtreeOutput<String, String>) algorithm.apply(input);
		assertNotNull(output);
		assertNotNull(output.getTrees());
		assertTrue(!output.getTrees().isEmpty());

		Set<Tree<String, String>> expectedTrees = createExpectedTreesForTest5();
		assertEquals(expectedTrees, output.getTrees());
	}
	
	/**
	 * Subtree algorithm test 6.
	 */
	@Test
	public void subtreeAlgorithmTest6() {
		FakeGraph graph = new FakeGraph();
		Algorithm<String, String> algorithm = new SubtreeAlgorithm<String, String>();

		Set<String> nodesToContain = new HashSet<String>(Arrays.asList("A", "B"));
		Set<String> edgesToContain = new HashSet<String>(Arrays.asList("1", "2"));
		SubtreeInput<String, String> input = new SubtreeInput<String, String>();
		input.setGraph(graph);
		input.setNodesToBeContained(nodesToContain);
		input.setEdgesToBeContained(edgesToContain);

		SubtreeOutput<String, String> output = (SubtreeOutput<String, String>) algorithm.apply(input);
		assertNotNull(output);
		assertNotNull(output.getTrees());
		assertTrue(!output.getTrees().isEmpty());

		Set<Tree<String, String>> expectedTrees = createExpectedTreesForTest6();
		assertEquals(expectedTrees, output.getTrees());
	}
	
	/**
	 * Subtree algorithm test 7.
	 */
	@Test
	public void subtreeAlgorithmTest7() {
		FakeGraph graph = new FakeGraph();
		Algorithm<String, String> algorithm = new SubtreeAlgorithm<String, String>();

		Set<String> nodesToContain = new HashSet<String>(Arrays.asList("A", "B"));
		Set<String> edgesToContain = new HashSet<String>(Arrays.asList("4"));
		SubtreeInput<String, String> input = new SubtreeInput<String, String>();
		input.setGraph(graph);
		input.setNodesToBeContained(nodesToContain);
		input.setEdgesToBeContained(edgesToContain);

		SubtreeOutput<String, String> output = (SubtreeOutput<String, String>) algorithm.apply(input);
		assertNotNull(output);
		assertNotNull(output.getTrees());
		assertTrue(!output.getTrees().isEmpty());

		Set<Tree<String, String>> expectedTrees = createExpectedTreesForTest7();
		assertEquals(expectedTrees, output.getTrees());
	}
	
	/**
	 * Subtree algorithm test 8.
	 */
	@Test
	public void subtreeAlgorithmTest8() {
		FakeGraph graph = new FakeGraph();
		Algorithm<String, String> algorithm = new SubtreeAlgorithm<String, String>();

		Set<String> nodesToContain = new HashSet<String>(Arrays.asList("A", "F"));
		Set<String> edgesToContain = new HashSet<String>(Arrays.asList("8"));
		SubtreeInput<String, String> input = new SubtreeInput<String, String>();
		input.setGraph(graph);
		input.setNodesToBeContained(nodesToContain);
		input.setEdgesToBeContained(edgesToContain);

		SubtreeOutput<String, String> output = (SubtreeOutput<String, String>) algorithm.apply(input);
		assertNotNull(output);
		assertNotNull(output.getTrees());
		assertTrue(output.getTrees().isEmpty());

	}
	
	/**
	 * Subtree algorithm test 9.
	 */
	@Test
	public void subtreeAlgorithmTest9() {
		FakeGraph graph = new FakeGraph();
		Algorithm<String, String> algorithm = new SubtreeAlgorithm<String, String>();

		Set<String> nodesToContain = new HashSet<String>(Arrays.asList("A", "F"));
		Set<String> edgesToContain = new HashSet<String>();
		SubtreeInput<String, String> input = new SubtreeInput<String, String>();
		input.setGraph(graph);
		input.setNodesToBeContained(nodesToContain);
		input.setEdgesToBeContained(edgesToContain);

		SubtreeOutput<String, String> output = (SubtreeOutput<String, String>) algorithm.apply(input);
		assertNotNull(output);
		assertNotNull(output.getTrees());
		assertTrue(!output.getTrees().isEmpty());

		Set<Tree<String, String>> expectedTrees = createExpectedTreesForTest9();
		assertEquals(expectedTrees, output.getTrees());
	}

	/**
	 * Creates the expected trees for test 1.
	 *
	 * @return the sets the
	 */
	private Set<Tree<String, String>> createExpectedTreesForTest1() {
		SimpleTreeImpl<String, String> tree1 = new SimpleTreeImpl<String, String>();
		tree1.addNode("B", "2", "C");
		tree1.addNode("B", "3", "D");
		tree1.addNode("D", "4", "E");
		tree1.addNode("E", "5", "F");
		tree1.addNode("E", "6", "F");

		SimpleTreeImpl<String, String> tree2 = new SimpleTreeImpl<String, String>();
		tree2.addNode("C", "8", "B");
		tree2.addNode("B", "3", "D");
		tree2.addNode("D", "4", "E");
		tree2.addNode("E", "5", "F");
		tree2.addNode("E", "6", "F");

		SimpleTreeImpl<String, String> tree3 = new SimpleTreeImpl<String, String>();
		tree3.addNode("E", "7", "C");
		tree3.addNode("C", "8", "B");
		tree3.addNode("E", "5", "F");
		tree3.addNode("E", "6", "F");

		Set<Tree<String, String>> expectedTrees = new HashSet<Tree<String, String>>();
		expectedTrees.add(tree1);
		expectedTrees.add(tree2);
		expectedTrees.add(tree3);
		return expectedTrees;
	}

	/**
	 * Creates the expected trees for test 2.
	 *
	 * @return the sets the
	 */
	private Set<Tree<String, String>> createExpectedTreesForTest2() {
		SimpleTreeImpl<String, String> tree1 = new SimpleTreeImpl<String, String>();
		tree1.addNode("G", "9", "I");
		tree1.addNode("G", "10", "J");

		Set<Tree<String, String>> expectedTrees = new HashSet<Tree<String, String>>();
		expectedTrees.add(tree1);
		return expectedTrees;
	}

	/**
	 * Creates the expected trees for test 4.
	 *
	 * @return the sets the
	 */
	private Set<Tree<String, String>> createExpectedTreesForTest4() {
		SimpleTreeImpl<String, String> tree1 = new SimpleTreeImpl<String, String>();
		tree1.addNode("G", "9", "I");
		tree1.addNode("G", "10", "J");

		SimpleTreeImpl<String, String> tree2 = new SimpleTreeImpl<String, String>();
		tree2.addNode("H", "11", "I");
		tree2.addNode("H", "12", "J");

		Set<Tree<String, String>> expectedTrees = new HashSet<Tree<String, String>>();
		expectedTrees.add(tree1);
		expectedTrees.add(tree2);
		return expectedTrees;
	}
	
	/**
	 * Creates the expected trees for test 5.
	 *
	 * @return the sets the
	 */
	private Set<Tree<String, String>> createExpectedTreesForTest5() {
		SimpleTreeImpl<String, String> tree1 = new SimpleTreeImpl<String, String>();
		tree1.addNode("A", "1", "B");

		Set<Tree<String, String>> expectedTrees = new HashSet<Tree<String, String>>();
		expectedTrees.add(tree1);
		return expectedTrees;
	}
	
	/**
	 * Creates the expected trees for test 6.
	 *
	 * @return the sets the
	 */
	private Set<Tree<String, String>> createExpectedTreesForTest6() {
		SimpleTreeImpl<String, String> tree1 = new SimpleTreeImpl<String, String>();
		tree1.addNode("A", "1", "B");
		tree1.addNode("B", "2", "C");

		Set<Tree<String, String>> expectedTrees = new HashSet<Tree<String, String>>();
		expectedTrees.add(tree1);
		return expectedTrees;
	}
	
	/**
	 * Creates the expected trees for test 7.
	 *
	 * @return the sets the
	 */
	private Set<Tree<String, String>> createExpectedTreesForTest7() {
		SimpleTreeImpl<String, String> tree1 = new SimpleTreeImpl<String, String>();
		tree1.addNode("A", "1", "B");
		tree1.addNode("B", "3", "D");
		tree1.addNode("D", "4", "E");

		Set<Tree<String, String>> expectedTrees = new HashSet<Tree<String, String>>();
		expectedTrees.add(tree1);
		return expectedTrees;
	}

	/**
	 * Creates the expected trees for test 8.
	 *
	 * @return the sets the
	 */
	private Set<Tree<String, String>> createExpectedTreesForTest9() {
		SimpleTreeImpl<String, String> tree1 = new SimpleTreeImpl<String, String>();
		tree1.addNode("A", "1", "B");
		tree1.addNode("B", "3", "D");
		tree1.addNode("D", "4", "E");
		tree1.addNode("E", new HashSet<String>(Arrays.asList("5", "6")), "F");

		Set<Tree<String, String>> expectedTrees = new HashSet<Tree<String, String>>();
		expectedTrees.add(tree1);
		return expectedTrees;
	}
}

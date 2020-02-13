package es.um.dis.graphlib.algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import es.um.dis.graphlib.FakeGraph;
import es.um.dis.graphlib.SimpleTreeImpl;
import es.um.dis.graphlib.Tree;
import es.um.dis.graphlib.algorithms.subtree.SubtreeAlgorithm;
import es.um.dis.graphlib.algorithms.subtree.SubtreeInput;
import es.um.dis.graphlib.algorithms.subtree.SubtreeOutput;

public class SubtreeAlgorithmTests {

	@Test
	public void subtreeAlgorithmTest1() {
		FakeGraph graph = new FakeGraph();
		Algorithm<String, String> algorithm = new SubtreeAlgorithm<String, String>();

		Set<String> nodesToContain = new HashSet<String>(Arrays.asList("B", "C", "F"));
		SubtreeInput<String, String> input = new SubtreeInput<String, String>();
		input.setGraph(graph);
		input.setNodesToBeContained(nodesToContain);

		SubtreeOutput<String, String> output = (SubtreeOutput<String, String>) graph.applyAlgorithm(algorithm, input);
		assertNotNull(output);
		assertNotNull(output.getTrees());
		assertTrue(!output.getTrees().isEmpty());
		
		Set<Tree<String, String>> expectedTrees = createExpectedTreesForTest1();
		assertEquals(expectedTrees, output.getTrees());
	}
	
	@Test
	public void subtreeAlgorithmTest2() {
		FakeGraph graph = new FakeGraph();
		Algorithm<String, String> algorithm = new SubtreeAlgorithm<String, String>();

		Set<String> nodesToContain = new HashSet<String>(Arrays.asList("I", "G", "J"));
		SubtreeInput<String, String> input = new SubtreeInput<String, String>();
		input.setGraph(graph);
		input.setNodesToBeContained(nodesToContain);

		SubtreeOutput<String, String> output = (SubtreeOutput<String, String>) graph.applyAlgorithm(algorithm, input);
		assertNotNull(output);
		assertNotNull(output.getTrees());
		assertTrue(!output.getTrees().isEmpty());
		
		Set<Tree<String, String>> expectedTrees = createExpectedTreesForTest2();
		assertEquals(expectedTrees, output.getTrees());
	}
	
	@Test
	public void subtreeAlgorithmTest3() {
		FakeGraph graph = new FakeGraph();
		Algorithm<String, String> algorithm = new SubtreeAlgorithm<String, String>();

		Set<String> nodesToContain = new HashSet<String>(Arrays.asList("I", "G", "H"));
		SubtreeInput<String, String> input = new SubtreeInput<String, String>();
		input.setGraph(graph);
		input.setNodesToBeContained(nodesToContain);

		SubtreeOutput<String, String> output = (SubtreeOutput<String, String>) graph.applyAlgorithm(algorithm, input);
		assertNotNull(output);
		assertNotNull(output.getTrees());
		assertTrue(output.getTrees().isEmpty());
		
	}

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
		
		
		Set<Tree<String, String>> expectedTrees = new HashSet<Tree<String, String>>();
		expectedTrees.add(tree1);
		expectedTrees.add(tree2);
		return expectedTrees;
	}
	
	private Set<Tree<String, String>> createExpectedTreesForTest2() {
		SimpleTreeImpl<String, String> tree1 = new SimpleTreeImpl<String, String>();
		tree1.addNode("G", "9", "I");
		tree1.addNode("G", "10", "J");
		
		Set<Tree<String, String>> expectedTrees = new HashSet<Tree<String, String>>();
		expectedTrees.add(tree1);
		return expectedTrees;
	}

}

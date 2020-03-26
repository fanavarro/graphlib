package com.github.fanavarro.graphlib.algorithms.subtree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.meanbean.lang.EquivalentFactory;
import org.meanbean.lang.Factory;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.EqualsMethodTester;
import org.meanbean.test.HashCodeMethodTester;

import com.github.fanavarro.graphlib.FakeGraph;
import com.github.fanavarro.graphlib.Graph;
import com.github.fanavarro.graphlib.SimpleTreeImpl;
import com.github.fanavarro.graphlib.Tree;
import com.github.fanavarro.graphlib.algorithms.subtree.SubtreeInput;
import com.github.fanavarro.graphlib.algorithms.subtree.SubtreeOutput;
import com.github.fanavarro.graphlib.test_config.GraphTestFactory;
import com.github.fanavarro.graphlib.test_config.MeanBeanConfigurationBase;

/**
 * The Class SubtreeOutputTest.
 */
public class SubtreeOutputTest {

	/** The configuration. */
	private final Configuration configuration = MeanBeanConfigurationBase.getConfigurationBuilderBase()
			.overrideFactory("input", new InputFactory()).build();

	/**
	 * Test getters and setters.
	 */
	@Test
	public void testGettersAndSetters() {
		new BeanTester().testBean(SubtreeOutput.class, configuration);
	}

	/**
	 * Test equals.
	 */
	@Test
	public void testEquals() {
		EqualsMethodTester tester = new EqualsMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testEqualsMethod(new SubtreeOutputEquivalentFactory(), configuration);
	}

	/**
	 * Test equals.
	 */
	@Test
	public void testEquals2() {
		SubtreeOutput<String, String> o1;
		SubtreeOutput<String, String> o2;

		o1 = new SubtreeOutputEquivalentFactory().create();
		o2 = new SubtreeOutputEquivalentFactory().create();
		assertTrue(o1.equals(o2));
		assertTrue(o2.equals(o1));
		assertTrue(o1.equals(o1));
		assertTrue(o2.equals(o2));
		assertTrue(o1.hashCode() == o2.hashCode());

		o1 = new SubtreeOutputEquivalentFactory().create();
		o2 = new SubtreeOutputEquivalentFactory().create();
		o2.setInput(null);
		assertFalse(o1.equals(o2));
		assertFalse(o2.equals(o1));
		assertTrue(o1.equals(o1));
		assertTrue(o2.equals(o2));
		assertFalse(o1.hashCode() == o2.hashCode());

		o1 = new SubtreeOutputEquivalentFactory().create();
		o2 = new SubtreeOutputEquivalentFactory().create();
		o2.setTrees(null);
		assertFalse(o1.equals(o2));
		assertFalse(o2.equals(o1));
		assertTrue(o1.equals(o1));
		assertTrue(o2.equals(o2));
		assertFalse(o1.hashCode() == o2.hashCode());
	}

	/**
	 * Test hash.
	 */
	@Test
	public void testHash() {
		HashCodeMethodTester tester = new HashCodeMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testHashCodeMethod(new SubtreeOutputEquivalentFactory());
	}

	/**
	 * A factory for creating SubtreeOutputEquivalent objects.
	 */
	private class SubtreeOutputEquivalentFactory implements EquivalentFactory<SubtreeOutput<String, String>> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.meanbean.lang.EquivalentFactory#create()
		 */
		@Override
		public SubtreeOutput<String, String> create() {
			SubtreeOutput<String, String> output = new SubtreeOutput<String, String>();
			SubtreeInput<String, String> input = new InputFactory().create();
			output.setTrees(createExampleTrees());
			output.setInput(input);
			return output;
		}

	}

	/**
	 * A factory for creating Input objects.
	 */
	private class InputFactory implements Factory<SubtreeInput<String, String>> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.meanbean.lang.Factory#create()
		 */
		@Override
		public SubtreeInput<String, String> create() {
			SubtreeInput<String, String> input = new SubtreeInput<String, String>();
			input.setGraph(new FakeGraph());
			input.setNodesToBeContained(new HashSet<String>(Arrays.asList("B", "C", "F")));
			return input;
		}

	}

	/**
	 * Creates the sample trees.
	 *
	 * @return the sets the
	 */
	private Set<Tree<String, String>> createExampleTrees() {
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

		Set<Tree<String, String>> exampleTrees = new HashSet<Tree<String, String>>();
		exampleTrees.add(tree1);
		exampleTrees.add(tree2);
		exampleTrees.add(tree3);
		return exampleTrees;
	}

}

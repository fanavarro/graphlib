package com.github.fanavarro.graphlib.algorithms.subtree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;
import org.meanbean.lang.EquivalentFactory;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.EqualsMethodTester;
import org.meanbean.test.HashCodeMethodTester;

import com.github.fanavarro.graphlib.FakeGraph;
import com.github.fanavarro.graphlib.Graph;
import com.github.fanavarro.graphlib.algorithms.subtree.SubtreeInput;
import com.github.fanavarro.graphlib.test_config.GraphTestFactory;
import com.github.fanavarro.graphlib.test_config.MeanBeanConfigurationBase;

/**
 * The Class SubtreeInputTest.
 */
public class SubtreeInputTest {

	/** The configuration. */
	private final Configuration configuration = MeanBeanConfigurationBase.getConfigurationBuilderBase().build();

	/**
	 * Test getters and setters.
	 */
	@Test
	public void testGettersAndSetters() {
		new BeanTester().testBean(SubtreeInput.class, configuration);
	}

	/**
	 * Test equals.
	 */
	@Test
	public void testEquals() {
		EqualsMethodTester tester = new EqualsMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testEqualsMethod(new SubtreeInputEquivalentFactory(), configuration);
	}

	/**
	 * Test equals.
	 */
	@Test
	public void testEquals2() {
		SubtreeInput<String, String> o1;
		SubtreeInput<String, String> o2;

		o1 = new SubtreeInputEquivalentFactory().create();
		o2 = new SubtreeInputEquivalentFactory().create();
		assertTrue(o1.equals(o2));
		assertTrue(o2.equals(o1));
		assertTrue(o1.equals(o1));
		assertTrue(o2.equals(o2));
		assertTrue(o1.hashCode() == o2.hashCode());

		o1 = new SubtreeInputEquivalentFactory().create();
		o2 = new SubtreeInputEquivalentFactory().create();
		o2.setGraph(null);
		assertFalse(o1.equals(o2));
		assertFalse(o2.equals(o1));
		assertTrue(o1.equals(o1));
		assertTrue(o2.equals(o2));
		assertFalse(o1.hashCode() == o2.hashCode());

		o1 = new SubtreeInputEquivalentFactory().create();
		o2 = new SubtreeInputEquivalentFactory().create();
		o2.setNodesToBeContained(null);
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
		tester.testHashCodeMethod(new SubtreeInputEquivalentFactory());
	}

	/**
	 * A factory for creating SubtreeInputEquivalent objects.
	 */
	private class SubtreeInputEquivalentFactory implements EquivalentFactory<SubtreeInput<String, String>> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.meanbean.lang.EquivalentFactory#create()
		 */
		@Override
		public SubtreeInput<String, String> create() {
			SubtreeInput<String, String> input = new SubtreeInput<String, String>();
			input.setGraph(new FakeGraph());
			input.setNodesToBeContained(new HashSet<String>(Arrays.asList("A", "B", "C")));
			input.setEdgesToBeContained(new HashSet<String>(Arrays.asList("1", "2", "3")));
			return input;
		}

	}

}

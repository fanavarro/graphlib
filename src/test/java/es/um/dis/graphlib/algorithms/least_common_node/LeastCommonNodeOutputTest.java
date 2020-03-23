package es.um.dis.graphlib.algorithms.least_common_node;

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

import es.um.dis.graphlib.FakeGraph;
import es.um.dis.graphlib.Graph;
import es.um.dis.graphlib.test_config.GraphTestFactory;
import es.um.dis.graphlib.test_config.MeanBeanConfigurationBase;

/**
 * The Class LeastCommonNodeOutputTest.
 */
public class LeastCommonNodeOutputTest {

	/** The configuration. */
	private final Configuration configuration = MeanBeanConfigurationBase.getConfigurationBuilderBase()
			.overrideFactory("leastCommonNodes", new LeastCommonNodesFactory())
			.overrideFactory("input", new InputFactory()).build();

	/**
	 * Test getters and setters.
	 */
	@Test
	public void testGettersAndSetters() {
		new BeanTester().testBean(LeastCommonNodeOutput.class, configuration);
	}

	/**
	 * Test equals.
	 */
	@Test
	public void testEquals1() {
		EqualsMethodTester tester = new EqualsMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testEqualsMethod(new LeastCommonNodeOutputEquivalentFactory(), configuration);
	}

	/**
	 * Test equals.
	 */
	@Test
	public void testEquals2() {
		LeastCommonNodeOutput<String, String> o1 = new LeastCommonNodeOutputEquivalentFactory().create();
		LeastCommonNodeOutput<String, String> o2 = new LeastCommonNodeOutputEquivalentFactory().create();
		o1.setLeastCommonNodes(null);

		assertFalse(o1.equals(o2));
		assertFalse(o2.equals(o1));
		assertTrue(o1.equals(o1));
		assertTrue(o2.equals(o2));
		assertFalse(o1.hashCode() == o2.hashCode());
		assertTrue(o1.hashCode() == o1.hashCode());
		assertTrue(o2.hashCode() == o2.hashCode());
	}

	/**
	 * Test equals.
	 */
	@Test
	public void testEquals3() {
		LeastCommonNodeOutput<String, String> o1 = new LeastCommonNodeOutputEquivalentFactory().create();
		LeastCommonNodeOutput<String, String> o2 = new LeastCommonNodeOutputEquivalentFactory().create();
		o1.setInput(null);

		assertFalse(o1.equals(o2));
		assertFalse(o2.equals(o1));
		assertTrue(o1.equals(o1));
		assertTrue(o2.equals(o2));
		assertFalse(o1.hashCode() == o2.hashCode());
		assertTrue(o1.hashCode() == o1.hashCode());
		assertTrue(o2.hashCode() == o2.hashCode());
	}

	/**
	 * Test hash.
	 */
	@Test
	public void testHash() {
		HashCodeMethodTester tester = new HashCodeMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testHashCodeMethod(new LeastCommonNodeOutputEquivalentFactory());
	}

	/**
	 * A factory for creating LeastCommonNodeOutputEquivalent objects.
	 */
	private class LeastCommonNodeOutputEquivalentFactory
			implements EquivalentFactory<LeastCommonNodeOutput<String, String>> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.meanbean.lang.EquivalentFactory#create()
		 */
		@Override
		public LeastCommonNodeOutput<String, String> create() {
			LeastCommonNodeOutput<String, String> output = new LeastCommonNodeOutput<String, String>();
			LeastCommonNodeInput<String, String> input = new InputFactory().create();

			input.setNodes(new HashSet<String>(Arrays.asList("B", "C")));
			input.setReverse(false);
			input.setGraph(new FakeGraph());
			output.setLeastCommonNodes(new HashSet<String>(Arrays.asList("A")));
			output.setInput(input);
			return output;
		}
	}

	/**
	 * A factory for creating LeastCommonNodes objects.
	 */
	private class LeastCommonNodesFactory implements Factory<Set<String>> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.meanbean.lang.Factory#create()
		 */
		@Override
		public Set<String> create() {
			return new HashSet<String>(Arrays.asList("A"));
		}

	}

	/**
	 * A factory for creating Input objects.
	 */
	private class InputFactory implements Factory<LeastCommonNodeInput<String, String>> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.meanbean.lang.Factory#create()
		 */
		@Override
		public LeastCommonNodeInput<String, String> create() {
			LeastCommonNodeInput<String, String> input = new LeastCommonNodeInput<String, String>();

			input.setNodes(new HashSet<String>(Arrays.asList("B", "C")));
			input.setReverse(false);
			input.setGraph(new FakeGraph());
			return input;
		}
	}
}

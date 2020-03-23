package es.um.dis.graphlib.algorithms.shortest_path;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
 * The Class ShortestPathInputTest.
 */
public class ShortestPathInputTest {

	/** The configuration. */
	private final Configuration configuration = MeanBeanConfigurationBase.getConfigurationBuilderBase()
			.overrideFactory("sourceNode", new SourceNodeFactory())
			.overrideFactory("targetNode", new TargetNodeFactory()).build();

	/**
	 * Test getters and setters.
	 */
	@Test
	public void testGettersAndSetters() {
		new BeanTester().testBean(ShortestPathInput.class, configuration);
	}

	/**
	 * Test equals.
	 */
	@Test
	public void testEquals() {
		EqualsMethodTester tester = new EqualsMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testEqualsMethod(new ShortestPathInputFactory(), configuration);
	}

	/**
	 * Test equals.
	 */
	@Test
	public void testEquals2() {
		ShortestPathInput<String, String> input1;
		ShortestPathInput<String, String> input2;

		input1 = new ShortestPathInputFactory().create();
		input2 = new ShortestPathInputFactory().create();
		assertTrue(input1.equals(input2));
		assertTrue(input2.equals(input1));
		assertTrue(input1.equals(input1));
		assertTrue(input2.equals(input2));
		assertTrue(input1.hashCode() == input2.hashCode());

		input1 = new ShortestPathInputFactory().create();
		input2 = new ShortestPathInputFactory().create();
		input1.setGraph(null);
		assertFalse(input1.equals(input2));
		assertFalse(input2.equals(input1));
		assertTrue(input1.equals(input1));
		assertTrue(input2.equals(input2));
		assertFalse(input1.hashCode() == input2.hashCode());

		input1 = new ShortestPathInputFactory().create();
		input2 = new ShortestPathInputFactory().create();
		input1.setSourceNode(null);
		assertFalse(input1.equals(input2));
		assertFalse(input2.equals(input1));
		assertTrue(input1.equals(input1));
		assertTrue(input2.equals(input2));
		assertFalse(input1.hashCode() == input2.hashCode());

		input1 = new ShortestPathInputFactory().create();
		input2 = new ShortestPathInputFactory().create();
		input1.setTargetNode(null);
		assertFalse(input1.equals(input2));
		assertFalse(input2.equals(input1));
		assertTrue(input1.equals(input1));
		assertTrue(input2.equals(input2));
		assertFalse(input1.hashCode() == input2.hashCode());
	}

	/**
	 * Test hash.
	 */
	@Test
	public void testHash() {
		HashCodeMethodTester tester = new HashCodeMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testHashCodeMethod(new ShortestPathInputFactory());
	}

	/**
	 * A factory for creating SourceNode objects.
	 */
	private class SourceNodeFactory implements Factory<String> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.meanbean.lang.Factory#create()
		 */
		@Override
		public String create() {
			return "A";
		}

	}

	/**
	 * A factory for creating TargetNode objects.
	 */
	private class TargetNodeFactory implements Factory<String> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.meanbean.lang.Factory#create()
		 */
		@Override
		public String create() {
			return "B";
		}

	}

	/**
	 * A factory for creating ShortestPathInput objects.
	 */
	private class ShortestPathInputFactory implements EquivalentFactory<ShortestPathInput<String, String>> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.meanbean.lang.EquivalentFactory#create()
		 */
		@Override
		public ShortestPathInput<String, String> create() {
			ShortestPathInput<String, String> input = new ShortestPathInput<String, String>();
			input.setGraph(new FakeGraph());
			input.setSourceNode("A");
			input.setTargetNode("B");
			input.setMaxDepth(5);
			return input;
		}

	}
}

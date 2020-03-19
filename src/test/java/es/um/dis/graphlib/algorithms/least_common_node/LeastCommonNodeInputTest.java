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
 * The Class LeastCommonNodeInputTest.
 */
public class LeastCommonNodeInputTest {

	/** The configuration. */
	private final Configuration configuration = MeanBeanConfigurationBase.getConfigurationBuilderBase()
			.overrideFactory("nodes", new NodesFactory()).build();

	/**
	 * Test getters and setters.
	 */
	@Test
	public void testGettersAndSetters() {
		new BeanTester().testBean(LeastCommonNodeInput.class, configuration);

	}

	/**
	 * Test equals.
	 */
	@Test
	public void testEquals1() {
		LeastCommonNodeInput<String, String> input1 = new LeastCommonNodeInputEquivalentFactory().create();
		LeastCommonNodeInput<String, String> input2 = new LeastCommonNodeInputEquivalentFactory().create();
		
		input1.setGraph(null);
		assertFalse(input1.equals(input2));
		assertFalse(input2.equals(input1));
		assertFalse(input1.hashCode() == input2.hashCode());
		assertTrue(input1.hashCode() == input1.hashCode());
		assertTrue(input2.hashCode() == input2.hashCode());
	}
	
	/**
	 * Test equals.
	 */
	@Test
	public void testEquals2() {
		LeastCommonNodeInput<String, String> input1 = new LeastCommonNodeInputEquivalentFactory().create();
		LeastCommonNodeInput<String, String> input2 = new LeastCommonNodeInputEquivalentFactory().create();
		
		input1.setNodes(null);
		assertFalse(input1.equals(input2));
		assertFalse(input2.equals(input1));
		assertFalse(input1.hashCode() == input2.hashCode());
		assertTrue(input1.hashCode() == input1.hashCode());
		assertTrue(input2.hashCode() == input2.hashCode());
	}
	
	/**
	 * Test equals.
	 */
	@Test
	public void testEquals3() {
		EqualsMethodTester tester = new EqualsMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testEqualsMethod(new LeastCommonNodeInputEquivalentFactory(), configuration);
	}

	/**
	 * Test hash.
	 */
	@Test
	public void testHash() {
		HashCodeMethodTester tester = new HashCodeMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testHashCodeMethod(new LeastCommonNodeInputEquivalentFactory());
	}

	/**
	 * A factory for creating LeastCommonNodeInputEquivalent objects.
	 */
	private class LeastCommonNodeInputEquivalentFactory
			implements EquivalentFactory<LeastCommonNodeInput<String, String>> {

		/* (non-Javadoc)
		 * @see org.meanbean.lang.EquivalentFactory#create()
		 */
		@Override
		public LeastCommonNodeInput<String, String> create() {
			LeastCommonNodeInput<String, String> input = new LeastCommonNodeInput<String, String>();
			input.setGraph(new FakeGraph());
			input.setNodes(new HashSet<String>(Arrays.asList("A", "B", "C")));
			input.setReverse(false);
			return input;
		}

	}

	/**
	 * A factory for creating Nodes objects.
	 */
	private class NodesFactory implements Factory<Set<String>> {

		/* (non-Javadoc)
		 * @see org.meanbean.lang.Factory#create()
		 */
		@Override
		public Set<String> create() {
			return new HashSet<String>(Arrays.asList("B", "C"));
		}

	}
}

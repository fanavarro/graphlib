package es.um.dis.graphlib.algorithms.subtree;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;
import org.meanbean.lang.EquivalentFactory;
import org.meanbean.lang.Factory;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.EqualsMethodTester;
import org.meanbean.test.HashCodeMethodTester;

import es.um.dis.graphlib.FakeGraph;
import es.um.dis.graphlib.Graph;
import es.um.dis.graphlib.SimpleTreeImpl;
import es.um.dis.graphlib.test_config.GraphTestFactory;
import es.um.dis.graphlib.test_config.MeanBeanConfigurationBase;

// TODO: Auto-generated Javadoc
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

		/* (non-Javadoc)
		 * @see org.meanbean.lang.EquivalentFactory#create()
		 */
		@Override
		public SubtreeOutput<String, String> create() {
			SubtreeOutput<String, String> output = new SubtreeOutput<String, String>();
			SubtreeInput<String, String> input = new InputFactory().create();
			output.addTree(new SimpleTreeImpl<String, String>());
			output.setInput(input);
			return output;
		}

	}

	/**
	 * A factory for creating Input objects.
	 */
	private class InputFactory implements Factory<SubtreeInput<String, String>> {

		/* (non-Javadoc)
		 * @see org.meanbean.lang.Factory#create()
		 */
		@Override
		public SubtreeInput<String, String> create() {
			SubtreeInput<String, String> input = new SubtreeInput<String, String>();
			input.setGraph(new FakeGraph());
			input.setNodesToBeContained(new HashSet<String>(Arrays.asList("A", "B")));
			return input;
		}

	}

}

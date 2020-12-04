package com.github.fanavarro.graphlib.algorithms.islands;

import org.junit.Test;
import org.meanbean.lang.EquivalentFactory;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.EqualsMethodTester;
import org.meanbean.test.HashCodeMethodTester;

import com.github.fanavarro.graphlib.FakeGraph;
import com.github.fanavarro.graphlib.Graph;
import com.github.fanavarro.graphlib.algorithms.islands.IslandsInput;
import com.github.fanavarro.graphlib.test_config.GraphTestFactory;
import com.github.fanavarro.graphlib.test_config.MeanBeanConfigurationBase;

/**
 * The Class IslandsInputTest.
 */
public class IslandsInputTest {

	/** The configuration. */
	private final Configuration configuration = MeanBeanConfigurationBase.getConfigurationBuilderBase().build();
	
	/**
	 * Test getters and setters.
	 */
	@Test
	public void testGettersAndSetters() {
		new BeanTester().testBean(IslandsInput.class, configuration);
	}
	
	/**
	 * Test equals.
	 */
	@Test
	public void testEquals() {
		EqualsMethodTester tester = new EqualsMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testEqualsMethod(new IslandsInputEquivalentFactory(), configuration);
	}

	/**
	 * Test hash.
	 */
	@Test
	public void testHash() {
		HashCodeMethodTester tester = new HashCodeMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testHashCodeMethod(new IslandsInputEquivalentFactory());
	}
	
	/**
	 * A factory for creating IslandsInputEquivalent objects.
	 */
	private class IslandsInputEquivalentFactory implements EquivalentFactory<IslandsInput<String, String>>{

		/* (non-Javadoc)
		 * @see org.meanbean.lang.EquivalentFactory#create()
		 */
		@Override
		public IslandsInput<String, String> create() {
			IslandsInput<String, String> input = new IslandsInput<String, String>();
			input.setGraph(new FakeGraph());
			input.setIgnoreEdgeDirection(true);
			return input;
		}

	
		
	}

}

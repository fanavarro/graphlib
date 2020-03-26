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

public class IslandsInputTest {

	private final Configuration configuration = MeanBeanConfigurationBase.getConfigurationBuilderBase().build();
	
	@Test
	public void testGettersAndSetters() {
		new BeanTester().testBean(IslandsInput.class, configuration);
	}
	
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
	
	private class IslandsInputEquivalentFactory implements EquivalentFactory<IslandsInput<String, String>>{

		@Override
		public IslandsInput<String, String> create() {
			IslandsInput<String, String> input = new IslandsInput<String, String>();
			input.setGraph(new FakeGraph());
			input.setIgnoreEdgeDirection(true);
			return input;
		}

	
		
	}

}

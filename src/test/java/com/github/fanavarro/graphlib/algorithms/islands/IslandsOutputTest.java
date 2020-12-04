package com.github.fanavarro.graphlib.algorithms.islands;

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
import com.github.fanavarro.graphlib.algorithms.islands.IslandsInput;
import com.github.fanavarro.graphlib.algorithms.islands.IslandsOutput;
import com.github.fanavarro.graphlib.test_config.GraphTestFactory;
import com.github.fanavarro.graphlib.test_config.MeanBeanConfigurationBase;

/**
 * The Class IslandsOutputTest.
 */
public class IslandsOutputTest {

	/** The configuration. */
	private final Configuration configuration = MeanBeanConfigurationBase.getConfigurationBuilderBase().overrideFactory("input", new IslandsInputFactory()).build();
	
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
		tester.testEqualsMethod(new IslandsOutputEquivalentFactory(), configuration);
	}

	/**
	 * Test hash.
	 */
	@Test
	public void testHash() {
		HashCodeMethodTester tester = new HashCodeMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testHashCodeMethod(new IslandsOutputEquivalentFactory());
	}
	
	/**
	 * A factory for creating IslandsOutputEquivalent objects.
	 */
	private class IslandsOutputEquivalentFactory implements EquivalentFactory<IslandsOutput<String, String>>{

		/* (non-Javadoc)
		 * @see org.meanbean.lang.EquivalentFactory#create()
		 */
		@Override
		public IslandsOutput<String, String> create() {
			IslandsOutput<String, String> output = new IslandsOutput<String, String>();
			
			output.setInput(new IslandsInputFactory().create());
			output.setIslands(new IslandsFactory().create());
			return output;
		}
	}
	
	/**
	 * A factory for creating Islands objects.
	 */
	private class IslandsFactory implements Factory<Set<Graph<String, String>>>{

		/* (non-Javadoc)
		 * @see org.meanbean.lang.Factory#create()
		 */
		@Override
		public Set<Graph<String, String>> create() {
			return new HashSet<Graph<String, String>>(Arrays.asList(new FakeGraph()));
		}
	}
	
	/**
	 * A factory for creating IslandsInput objects.
	 */
	private class IslandsInputFactory implements Factory<IslandsInput<String, String>>{

		/* (non-Javadoc)
		 * @see org.meanbean.lang.Factory#create()
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

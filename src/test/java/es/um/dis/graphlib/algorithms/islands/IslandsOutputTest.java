package es.um.dis.graphlib.algorithms.islands;

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

public class IslandsOutputTest {

	private final Configuration configuration = MeanBeanConfigurationBase.getConfigurationBuilderBase().overrideFactory("input", new IslandsInputFactory()).build();
	
	@Test
	public void testGettersAndSetters() {
		new BeanTester().testBean(IslandsInput.class, configuration);
	}
	
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
	
	private class IslandsOutputEquivalentFactory implements EquivalentFactory<IslandsOutput<String, String>>{

		@Override
		public IslandsOutput<String, String> create() {
			IslandsOutput<String, String> output = new IslandsOutput<String, String>();
			
			output.setInput(new IslandsInputFactory().create());
			output.setIslands(new IslandsFactory().create());
			return output;
		}
	}
	
	private class IslandsFactory implements Factory<Set<Graph<String, String>>>{

		@Override
		public Set<Graph<String, String>> create() {
			return new HashSet<Graph<String, String>>(Arrays.asList(new FakeGraph()));
		}
	}
	
	private class IslandsInputFactory implements Factory<IslandsInput<String, String>>{

		@Override
		public IslandsInput<String, String> create() {
			IslandsInput<String, String> input = new IslandsInput<String, String>();
			input.setGraph(new FakeGraph());
			input.setIgnoreEdgeDirection(true);
			return input;
		}
		
	}

}

package es.um.dis.graphlib.algorithms.shortest_path;

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
	 * Test hash.
	 */
	@Test
	public void testHash() {
		HashCodeMethodTester tester = new HashCodeMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testHashCodeMethod(new ShortestPathInputFactory());
	}

	private class SourceNodeFactory implements Factory<String> {

		@Override
		public String create() {
			return "A";
		}

	}

	private class TargetNodeFactory implements Factory<String> {

		@Override
		public String create() {
			return "B";
		}

	}
	
	private class ShortestPathInputFactory implements EquivalentFactory<ShortestPathInput<String, String>>{

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

package es.um.dis.graphlib.algorithms.shortest_path;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

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
 * The Class ShortestPathOutputTest.
 */
public class ShortestPathOutputTest {
	
	/** The configuration. */
	private final Configuration configuration = MeanBeanConfigurationBase.getConfigurationBuilderBase()
			.overrideFactory("input", new InputFactory()).build();

	/**
	 * Test getters and setters.
	 */
	@Test
	public void testGettersAndSetters() {
		new BeanTester().testBean(ShortestPathOutput.class, configuration);
	}

	/**
	 * Test equals.
	 */
	@Test
	public void testEquals() {
		EqualsMethodTester tester = new EqualsMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testEqualsMethod(new ShortestPathOutputEquivalentFactory(), configuration);
	}

	/**
	 * Test equals.
	 */
	@Test
	public void testEquals2() {
		ShortestPathOutput<String, String> o1;
		ShortestPathOutput<String, String> o2;

		o1 = new ShortestPathOutputEquivalentFactory().create();
		o2 = new ShortestPathOutputEquivalentFactory().create();
		assertTrue(o1.equals(o2));
		assertTrue(o2.equals(o1));
		assertTrue(o1.equals(o1));
		assertTrue(o2.equals(o2));
		assertTrue(o1.hashCode() == o2.hashCode());

		o1 = new ShortestPathOutputEquivalentFactory().create();
		o2 = new ShortestPathOutputEquivalentFactory().create();
		o2.setPath(null);
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
		tester.testHashCodeMethod(new ShortestPathOutputEquivalentFactory());
	}

	/**
	 * A factory for creating ShortestPathOutputEquivalent objects.
	 */
	private class ShortestPathOutputEquivalentFactory implements EquivalentFactory<ShortestPathOutput<String, String>> {

		/* (non-Javadoc)
		 * @see org.meanbean.lang.EquivalentFactory#create()
		 */
		@Override
		public ShortestPathOutput<String, String> create() {

			ShortestPathInput<String, String> input = new InputFactory().create();
			List<PathNode<String, String>> path = new ArrayList<PathNode<String, String>>();

			PathNode<String, String> n1 = new PathNode<String, String>();
			n1.setSource("A");
			n1.setEdges(new HashSet<String>(Arrays.asList("1", "2")));
			n1.setTarget("B");
			path.add(n1);

			PathNode<String, String> n2 = new PathNode<String, String>();
			n2.setSource("B");
			n2.setEdges(new HashSet<String>(Arrays.asList("3")));
			n2.setTarget("C");
			path.add(n2);

			ShortestPathOutput<String, String> output = new ShortestPathOutput<String, String>();
			output.setPath(path);
			output.setInput(input);

			return output;
		}
	}

	/**
	 * A factory for creating Input objects.
	 */
	private class InputFactory implements Factory<ShortestPathInput<String, String>> {

		/* (non-Javadoc)
		 * @see org.meanbean.lang.Factory#create()
		 */
		@Override
		public ShortestPathInput<String, String> create() {
			ShortestPathInput<String, String> input = new ShortestPathInput<String, String>();
			input.setGraph(new FakeGraph());
			input.setMaxDepth(5);
			input.setSourceNode("A");
			input.setTargetNode("C");

			return input;
		}

	}
}

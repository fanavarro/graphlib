package es.um.dis.graphlib.algorithms.shortest_path;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;
import org.meanbean.lang.EquivalentFactory;
import org.meanbean.lang.Factory;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;
import org.meanbean.test.EqualsMethodTester;
import org.meanbean.test.HashCodeMethodTester;

import es.um.dis.graphlib.Graph;
import es.um.dis.graphlib.test_config.GraphTestFactory;

/**
 * The Class PathNodeTest.
 */
public class PathNodeTest {
	private Configuration configuration = new ConfigurationBuilder().overrideFactory("source", new NodeFactory())
			.overrideFactory("target", new NodeFactory()).build();

	/**
	 * Test getters and setters.
	 */
	@Test
	public void testGettersAndSetters() {
		new BeanTester().testBean(PathNode.class, configuration);
	}

	/**
	 * Test equals.
	 */
	@Test
	public void testEquals() {
		EqualsMethodTester tester = new EqualsMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testEqualsMethod(new PathNodeFactory(), configuration);
	}

	/**
	 * Test hash.
	 */
	@Test
	public void testHash() {
		HashCodeMethodTester tester = new HashCodeMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testHashCodeMethod(new PathNodeFactory());
	}

	private class NodeFactory implements Factory<String> {

		@Override
		public String create() {
			return "A";
		}
	}
	
	private class PathNodeFactory implements EquivalentFactory<PathNode<String, String>>{

		@Override
		public PathNode<String, String> create() {
			PathNode<String, String> pathNode = new PathNode<String, String>();
			pathNode.setEdges(new HashSet<String>(Arrays.asList("1", "2")));
			pathNode.setSource("A");
			pathNode.setTarget("B");
			return pathNode;
		}
	}
}

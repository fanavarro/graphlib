package es.um.dis.graphlib.algorithms.shortest_path;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
	
	/** The configuration. */
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
	public void testEquals1() {
		EqualsMethodTester tester = new EqualsMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testEqualsMethod(new PathNodeFactory(), configuration);
	}
	
	/**
	 * Test equals.
	 */
	@Test
	public void testEquals2() {
		PathNode<String, String> pathNode1;
		PathNode<String, String> pathNode2;
		
		pathNode1 = new PathNodeFactory().create();
		pathNode2 = new PathNodeFactory().create();
		assertTrue(pathNode1.equals(pathNode2));
		assertTrue(pathNode2.equals(pathNode1));
		assertTrue(pathNode1.equals(pathNode1));
		assertTrue(pathNode2.equals(pathNode2));
		assertTrue(pathNode1.hashCode() == pathNode2.hashCode());
		
		pathNode1 = new PathNodeFactory().create();
		pathNode2 = new PathNodeFactory().create();
		pathNode1.setEdges(null);
		assertFalse(pathNode1.equals(pathNode2));
		assertFalse(pathNode2.equals(pathNode1));
		assertTrue(pathNode1.equals(pathNode1));
		assertTrue(pathNode2.equals(pathNode2));
		assertFalse(pathNode1.hashCode() == pathNode2.hashCode());
		
		pathNode1 = new PathNodeFactory().create();
		pathNode2 = new PathNodeFactory().create();
		pathNode1.setSource(null);
		assertFalse(pathNode1.equals(pathNode2));
		assertFalse(pathNode2.equals(pathNode1));
		assertTrue(pathNode1.equals(pathNode1));
		assertTrue(pathNode2.equals(pathNode2));
		assertFalse(pathNode1.hashCode() == pathNode2.hashCode());
		
		pathNode1 = new PathNodeFactory().create();
		pathNode2 = new PathNodeFactory().create();
		pathNode1.setTarget(null);
		assertFalse(pathNode1.equals(pathNode2));
		assertFalse(pathNode2.equals(pathNode1));
		assertTrue(pathNode1.equals(pathNode1));
		assertTrue(pathNode2.equals(pathNode2));
		assertFalse(pathNode1.hashCode() == pathNode2.hashCode());
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

	/**
	 * A factory for creating Node objects.
	 */
	private class NodeFactory implements Factory<String> {

		/* (non-Javadoc)
		 * @see org.meanbean.lang.Factory#create()
		 */
		@Override
		public String create() {
			return "A";
		}
	}
	
	/**
	 * A factory for creating PathNode objects.
	 */
	private class PathNodeFactory implements EquivalentFactory<PathNode<String, String>>{

		/* (non-Javadoc)
		 * @see org.meanbean.lang.EquivalentFactory#create()
		 */
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

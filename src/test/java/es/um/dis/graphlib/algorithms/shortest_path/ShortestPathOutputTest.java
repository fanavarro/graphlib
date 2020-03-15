package es.um.dis.graphlib.algorithms.shortest_path;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.EqualsMethodTester;
import org.meanbean.test.HashCodeMethodTester;

import es.um.dis.graphlib.Graph;
import es.um.dis.graphlib.test_config.GraphTestFactory;
import es.um.dis.graphlib.test_config.MeanBeanConfigurationBase;


/**
 * The Class ShortestPathOutputTest.
 */
public class ShortestPathOutputTest {

	/**
	 * Test getters and setters.
	 */
	@Test
	public void testGettersAndSetters() {
		new BeanTester().testBean(ShortestPathOutput.class, MeanBeanConfigurationBase.getConfigurationBuilderBase().build());
	}
	
	/**
	 * Test equals.
	 */
	@Test
	public void testEquals(){
		EqualsMethodTester tester = new EqualsMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testEqualsMethod(ShortestPathOutput.class);
	}

	/**
	 * Test hash.
	 */
	@Test
	public void testHash(){
		HashCodeMethodTester tester = new HashCodeMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testHashCodeMethod(ShortestPathOutput.class);
	}
}

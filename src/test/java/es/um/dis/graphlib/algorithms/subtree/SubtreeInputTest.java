package es.um.dis.graphlib.algorithms.subtree;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.EqualsMethodTester;
import org.meanbean.test.HashCodeMethodTester;

import es.um.dis.graphlib.Graph;
import es.um.dis.graphlib.test_config.GraphTestFactory;
import es.um.dis.graphlib.test_config.MeanBeanConfigurationBase;


/**
 * The Class SubtreeInputTest.
 */
public class SubtreeInputTest {

	/**
	 * Test getters and setters.
	 */
	@Test
	public void testGettersAndSetters() {
		new BeanTester().testBean(SubtreeInput.class, MeanBeanConfigurationBase.getConfigurationBuilderBase().build());
	}
	
	/**
	 * Test equals.
	 */
	@Test
	public void testEquals(){
		EqualsMethodTester tester = new EqualsMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testEqualsMethod(SubtreeInput.class);
	}
	
	/**
	 * Test hash.
	 */
	@Test
	public void testHash(){
		HashCodeMethodTester tester = new HashCodeMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testHashCodeMethod(SubtreeInput.class);
	}

}

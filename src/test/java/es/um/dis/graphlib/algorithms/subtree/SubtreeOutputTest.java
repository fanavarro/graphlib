package es.um.dis.graphlib.algorithms.subtree;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.EqualsMethodTester;
import org.meanbean.test.HashCodeMethodTester;

import es.um.dis.graphlib.Graph;
import es.um.dis.graphlib.test_config.GraphTestFactory;
import es.um.dis.graphlib.test_config.MeanBeanConfigurationBase;

public class SubtreeOutputTest {

	@Test
	public void testGettersAndSetters() {
		new BeanTester().testBean(SubtreeOutput.class, MeanBeanConfigurationBase.getConfiguration());
	}
	
	@Test
	public void testEquals(){
		EqualsMethodTester tester = new EqualsMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testEqualsMethod(SubtreeOutput.class);
	}
	
	@Test
	public void testHash(){
		HashCodeMethodTester tester = new HashCodeMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testHashCodeMethod(SubtreeOutput.class);
	}

}

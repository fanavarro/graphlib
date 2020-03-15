package es.um.dis.graphlib.algorithms.shortest_path;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.EqualsMethodTester;
import org.meanbean.test.HashCodeMethodTester;

import es.um.dis.graphlib.Graph;
import es.um.dis.graphlib.test_config.GraphTestFactory;
import es.um.dis.graphlib.test_config.MeanBeanConfigurationBase;

public class TreeNodeTest {

	@Test
	public void testGettersAndSetters() {
		new BeanTester().testBean(TreeNode.class, MeanBeanConfigurationBase.getConfiguration());
	}
	
	@Test
	public void testEquals(){
		EqualsMethodTester tester = new EqualsMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testEqualsMethod(TreeNode.class, "parent", "children", "relationToParent", "height");
	}
	
	@Test
	public void testHash(){
		HashCodeMethodTester tester = new HashCodeMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testHashCodeMethod(TreeNode.class);
	}

}

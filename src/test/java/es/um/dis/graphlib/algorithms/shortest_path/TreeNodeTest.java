package es.um.dis.graphlib.algorithms.shortest_path;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

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
 * The Class TreeNodeTest.
 */
public class TreeNodeTest {

	/** The configuration. */
	private final Configuration configuration = new ConfigurationBuilder()
			.overrideFactory("parent", new TreeNodeFactory()).overrideFactory("children", new ChildrenFactory())
			.overrideFactory("relationToParent", new RelationToParentFactory())
			.overrideFactory("content", new ContentFactory()).build();

	/**
	 * Test getters and setters.
	 */
	@Test
	public void testGettersAndSetters() {
		new BeanTester().testBean(TreeNode.class, configuration);
	}

	/**
	 * Test equals.
	 */
	@Test
	public void testEquals() {
		EqualsMethodTester tester = new EqualsMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testEqualsMethod(new TreeNodeEquivalentFactory(), configuration, "parent", "children", "relationToParent", "height");
	}
	
	/**
	 * Test equals.
	 */
	@Test
	public void testEquals2() {
		TreeNode<String, String> o1;
		TreeNode<String, String> o2;
		
		
		o1 = new TreeNodeEquivalentFactory().create();
		o2 = new TreeNodeEquivalentFactory().create();
		assertTrue(o1.equals(o2));
		assertTrue(o2.equals(o1));
		assertTrue(o1.equals(o1));
		assertTrue(o2.equals(o2));
		assertTrue(o1.hashCode() == o2.hashCode());
		
		o1 = new TreeNodeEquivalentFactory().create();
		o2 = new TreeNodeEquivalentFactory().create();
		o2.setContent(null);
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
		tester.testHashCodeMethod(new TreeNodeEquivalentFactory());
	}

	/**
	 * A factory for creating TreeNodeEquivalent objects.
	 */
	private class TreeNodeEquivalentFactory implements EquivalentFactory<TreeNode<String, String>> {

		/* (non-Javadoc)
		 * @see org.meanbean.lang.EquivalentFactory#create()
		 */
		@Override
		public TreeNode<String, String> create() {
			TreeNode<String, String> treeNodeA = new TreeNode<String, String>();
			treeNodeA.setContent("A");

			TreeNode<String, String> treeNodeB = new TreeNode<String, String>();
			treeNodeB.setContent("B");
			
			TreeNode<String, String> treeNodeC = new TreeNode<String, String>();
			treeNodeC.setContent("C");

			treeNodeA.addChild(treeNodeB);
			treeNodeA.setHeight(0);

			treeNodeB.setParent(treeNodeA);
			treeNodeB.setHeight(1);
			treeNodeB.setRelationToParent("1");
			treeNodeB.addChild(treeNodeC);
			
			treeNodeC.setParent(treeNodeB);
			treeNodeC.setHeight(2);
			treeNodeC.setRelationToParent("2");

			return treeNodeB;
		}

	}

	/**
	 * A factory for creating TreeNode objects.
	 */
	private class TreeNodeFactory implements Factory<TreeNode<String, String>> {

		/* (non-Javadoc)
		 * @see org.meanbean.lang.Factory#create()
		 */
		@Override
		public TreeNode<String, String> create() {
			TreeNode<String, String> treeNodeA = new TreeNode<String, String>();
			treeNodeA.setContent("A");

			TreeNode<String, String> treeNodeB = new TreeNode<String, String>();
			treeNodeB.setContent("B");

			treeNodeA.addChild(treeNodeB);
			treeNodeA.setHeight(0);

			treeNodeB.setParent(treeNodeA);
			treeNodeB.setHeight(1);

			treeNodeB.setRelationToParent("1");

			return treeNodeA;
		}

	}

	/**
	 * A factory for creating Children objects.
	 */
	private class ChildrenFactory implements Factory<List<TreeNode<String, String>>> {

		/* (non-Javadoc)
		 * @see org.meanbean.lang.Factory#create()
		 */
		@Override
		public List<TreeNode<String, String>> create() {
			TreeNode<String, String> treeNodeA = new TreeNode<String, String>();
			treeNodeA.setContent("A");

			TreeNode<String, String> treeNodeB = new TreeNode<String, String>();
			treeNodeB.setContent("B");

			treeNodeA.addChild(treeNodeB);
			treeNodeA.setHeight(0);

			treeNodeB.setParent(treeNodeA);
			treeNodeB.setHeight(1);

			treeNodeB.setRelationToParent("1");

			return treeNodeA.getChildren();
		}

	}

	/**
	 * A factory for creating RelationToParent objects.
	 */
	private class RelationToParentFactory implements Factory<String> {

		/* (non-Javadoc)
		 * @see org.meanbean.lang.Factory#create()
		 */
		@Override
		public String create() {
			return "1";
		}

	}

	/**
	 * A factory for creating Content objects.
	 */
	private class ContentFactory implements Factory<String> {

		/* (non-Javadoc)
		 * @see org.meanbean.lang.Factory#create()
		 */
		@Override
		public String create() {
			return "A";
		}

	}

}

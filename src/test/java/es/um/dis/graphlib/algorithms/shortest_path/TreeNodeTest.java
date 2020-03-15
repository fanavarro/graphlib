package es.um.dis.graphlib.algorithms.shortest_path;

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
	 * Test hash.
	 */
	@Test
	public void testHash() {
		HashCodeMethodTester tester = new HashCodeMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testHashCodeMethod(new TreeNodeEquivalentFactory());
	}

	private class TreeNodeEquivalentFactory implements EquivalentFactory<TreeNode<String, String>> {

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

	private class TreeNodeFactory implements Factory<TreeNode<String, String>> {

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

	private class ChildrenFactory implements Factory<List<TreeNode<String, String>>> {

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

	private class RelationToParentFactory implements Factory<String> {

		@Override
		public String create() {
			return "1";
		}

	}

	private class ContentFactory implements Factory<String> {

		@Override
		public String create() {
			return "A";
		}

	}

}

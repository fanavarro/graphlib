package es.um.dis.graphlib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;
import org.meanbean.test.EqualsMethodTester;
import org.meanbean.test.HashCodeMethodTester;

import es.um.dis.graphlib.test_config.GraphTestFactory;




/**
 * The Class TreeTest.
 */
public class SimpleTreeImplTest {
	
	/**
	 * Test add node.
	 */
	@Test
	public void testAddNode(){
		SimpleTreeImpl<String, String> tree = new SimpleTreeImpl<String, String>();
		tree.addNode("A", "1", new HashSet<String>(Arrays.asList("B", "C")));
		tree.addNode("C", "2", "D");
		
		assertEquals(new HashSet<String>(Arrays.asList("A", "B", "C", "D")), tree.getNodes());
		assertEquals(new HashSet<String>(Arrays.asList("B", "C")), tree.getAdjacentNodes("A"));
		assertTrue(tree.getAdjacentNodes("B").isEmpty());
		assertEquals(new HashSet<String>(Arrays.asList("D")), tree.getAdjacentNodes("C"));
	}
	
	/**
	 * Test equals 1.
	 */
	@Test
	public void testEquals1(){
		assertTrue(new SimpleTreeImpl<String, String>().equals(new SimpleTreeImpl<String, String>()));
		SimpleTreeImpl<String, String> tree1 = (SimpleTreeImpl<String, String>) createCorrectTree();
		SimpleTreeImpl<String, String> tree2 = (SimpleTreeImpl<String, String>) createCorrectTree();
		
		assertTrue(tree1.equals(tree2));
		assertTrue(tree2.equals(tree1));
		assertTrue(tree1.equals(tree1));
		assertTrue(tree2.equals(tree2));
		assertTrue(tree1.hashCode() == tree2.hashCode());
		
		tree2.addNode("D", "3", "X");
		assertTrue(!tree1.equals(tree2));
		assertTrue(!tree2.equals(tree1));
		assertTrue(tree1.hashCode() != tree2.hashCode());
		
		assertTrue(!tree1.equals(null));
		assertTrue(!tree1.equals(new String()));
	}

	/**
	 * Test correct tree.
	 */
	@Test
	public void testCorrectTree() {
		Tree<String, String> tree = createCorrectTree();
		assertEquals("A", tree.getRoot());
		assertEquals(new HashSet<String>(Arrays.asList("B", "D", "E")), tree.getLeaves());
	}

	

	/**
	 * Test incorrect tree 1.
	 */
	@Test(expected = IllegalStateException.class)
	public void testIncorrectTree1() {
		Tree<String, String> tree = createIncorrectTree1();
		tree.getRoot();
	}
	
	/**
	 * Test incorrect tree 2.
	 */
	@Test(expected = IllegalStateException.class)
	public void testIncorrectTree2() {
		Tree<String, String> tree = createIncorrectTree2();
		tree.getRoot();
	}
	
	/**
	 * Test equals 2.
	 */
	@Test
	public void testEquals2(){
		EqualsMethodTester tester = new EqualsMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testEqualsMethod(SimpleTreeImpl.class);
	}
	
	/**
	 * Test hash.
	 */
	@Test
	public void testHash(){
		HashCodeMethodTester tester = new HashCodeMethodTester();
		tester.getFactoryCollection().addFactory(Graph.class, new GraphTestFactory());
		tester.testHashCodeMethod(SimpleTreeImpl.class);
	}
	
	/**
	 * Creates the correct tree.
	 *
	 * @return the tree
	 */
	private Tree<String, String> createCorrectTree() {
		SimpleTreeImpl<String, String> tree = new SimpleTreeImpl<String, String>();
		tree.addNode("A", "1", "B");
		tree.addNode("A", "2", "C");
		tree.addNode("C", "3", "D");
		tree.addNode("C", "4", "E");
		return tree;
	}

	/**
	 * Creates the incorrect tree 1.
	 *
	 * @return the tree
	 */
	private Tree<String, String> createIncorrectTree1() {
		SimpleTreeImpl<String, String> tree = new SimpleTreeImpl<String, String>();
		tree.addNode("A", "1", "B");
		tree.addNode("A", "2", "C");
		tree.addNode("C", "3", "D");
		tree.addNode("C", "4", "E");
		tree.addNode("X", "5", "B");
		return tree;
	}
	
	/**
	 * Creates the incorrect tree 2.
	 *
	 * @return the tree
	 */
	private Tree<String, String> createIncorrectTree2() {
		SimpleTreeImpl<String, String> tree = new SimpleTreeImpl<String, String>();
		tree.addNode("A", "1", "B");
		tree.addNode("A", "2", "C");
		tree.addNode("C", "3", "D");
		tree.addNode("C", "4", "E");
		tree.addNode("B", "5", "A");
		return tree;
	}
}

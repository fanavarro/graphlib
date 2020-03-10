package es.um.dis.graphlib;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;


/**
 * The Class TreeTest.
 */
public class TreeTest {
	

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

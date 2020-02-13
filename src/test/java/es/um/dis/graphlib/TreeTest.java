package es.um.dis.graphlib;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

public class TreeTest {
	

	@Test
	public void testCorrectTree() {
		Tree<String, String> tree = createCorrectTree();
		assertEquals("A", tree.getRoot());
		assertEquals(new HashSet<String>(Arrays.asList("B", "D", "E")), tree.getLeaves());
	}

	

	@Test(expected = IllegalStateException.class)
	public void testIncorrectTree1() {
		Tree<String, String> tree = createIncorrectTree1();
		tree.getRoot();
	}
	
	@Test(expected = IllegalStateException.class)
	public void testIncorrectTree2() {
		Tree<String, String> tree = createIncorrectTree2();
		tree.getRoot();
	}
	
	private Tree<String, String> createCorrectTree() {
		SimpleTreeImpl<String, String> tree = new SimpleTreeImpl<String, String>();
		tree.addNode("A", "1", "B");
		tree.addNode("A", "2", "C");
		tree.addNode("C", "3", "D");
		tree.addNode("C", "4", "E");
		return tree;
	}

	private Tree<String, String> createIncorrectTree1() {
		SimpleTreeImpl<String, String> tree = new SimpleTreeImpl<String, String>();
		tree.addNode("A", "1", "B");
		tree.addNode("A", "2", "C");
		tree.addNode("C", "3", "D");
		tree.addNode("C", "4", "E");
		tree.addNode("X", "5", "B");
		return tree;
	}
	
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

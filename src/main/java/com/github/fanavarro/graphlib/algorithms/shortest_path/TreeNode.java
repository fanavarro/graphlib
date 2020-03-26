package com.github.fanavarro.graphlib.algorithms.shortest_path;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * The Class TreeNode.
 *
 * @param <N>
 *            the node type
 * @param <E>
 *            the edge type
 */
public class TreeNode<N, E> {

	/** The parent. */
	private TreeNode<N, E> parent;

	/** The children. */
	private List<TreeNode<N, E>> children;

	/** The relation to parent. */
	private E relationToParent;

	/** The content. */
	private N content;

	/** The height. */
	private Integer height;

	/**
	 * Instantiates a new tree node.
	 */
	public TreeNode() {
		this(null, null, null, null);
	}

	/**
	 * Instantiates a new tree node.
	 *
	 * @param content
	 *            the content
	 * @param parent
	 *            the parent
	 * @param children
	 *            the children
	 * @param height
	 *            the height
	 */
	public TreeNode(N content, TreeNode<N, E> parent, List<TreeNode<N, E>> children, Integer height) {
		this.content = content;
		this.parent = parent;
		this.children = children;
		this.height = height;
	}

	/**
	 * Instantiates a new tree node.
	 *
	 * @param content
	 *            the content
	 */
	public TreeNode(N content) {
		this(content, null, null, null);
		this.height = 0;
	}

	/**
	 * Instantiates a new tree node.
	 *
	 * @param content
	 *            the content
	 * @param height
	 *            the height
	 */
	public TreeNode(N content, Integer height) {
		this(content, null, null, height);
	}

	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	public TreeNode<N, E> getParent() {
		return parent;
	}

	/**
	 * Sets the parent.
	 *
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(TreeNode<N, E> parent) {
		this.parent = parent;
	}

	/**
	 * Gets the children.
	 *
	 * @return the children
	 */
	public List<TreeNode<N, E>> getChildren() {
		return children;
	}

	/**
	 * Sets the children.
	 *
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<TreeNode<N, E>> children) {
		this.children = children;
	}

	/**
	 * Adds the child.
	 *
	 * @param child
	 *            the child
	 */
	public void addChild(TreeNode<N, E> child) {
		if (this.children == null) {
			this.children = new ArrayList<TreeNode<N, E>>();
		}
		this.children.add(child);
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public N getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 *
	 * @param content
	 *            the content to set
	 */
	public void setContent(N content) {
		this.content = content;
	}

	/**
	 * Gets the relation to parent.
	 *
	 * @return the relation to parent
	 */
	public E getRelationToParent() {
		return relationToParent;
	}

	/**
	 * Sets the relation to parent.
	 *
	 * @param relationToParent
	 *            the new relation to parent
	 */
	public void setRelationToParent(E relationToParent) {
		this.relationToParent = relationToParent;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height
	 *            the new height
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TreeNode)) {
			return false;
		}
		TreeNode<N, E> castOther = (TreeNode<N, E>) other;
		return new EqualsBuilder().append(content, castOther.content).isEquals();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(content).toHashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TreeNode [content=");
		builder.append(content);
		builder.append("]");
		return builder.toString();
	}

}

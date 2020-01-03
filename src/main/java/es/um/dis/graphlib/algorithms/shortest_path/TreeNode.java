package es.um.dis.graphlib.algorithms.shortest_path;

import java.util.ArrayList;
import java.util.List;


public class TreeNode <N, E> {
	private TreeNode<N, E> parent;
	private List<TreeNode<N, E>> children;
	private E relationToParent;
	private N content;
	private Integer height;
	
	public TreeNode(){
		this(null,null,null,null);
	}
	public TreeNode(N content, TreeNode<N, E> parent, List<TreeNode<N, E>> children, Integer height){
		this.content = content;
		this.parent = parent;
		this.children = children;
		this.height = height;
	}
	
	public TreeNode(N content){
		this(content, null, null, null);
		this.height = 0;
	}
	
	public TreeNode(N content, Integer height){
		this(content, null, null, height);
	}
	
	/**
	 * @return the parent
	 */
	public TreeNode<N, E> getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(TreeNode<N, E> parent) {
		this.parent = parent;
	}
	/**
	 * @return the children
	 */
	public List<TreeNode<N, E>> getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(List<TreeNode<N, E>> children) {
		this.children = children;
	}
	
	public void addChild(TreeNode<N, E> child){
		if(this.children == null){
			this.children = new ArrayList<TreeNode<N, E>>();
		}
		this.children.add(child);
	}
	/**
	 * @return the content
	 */
	public N getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(N content) {
		this.content = content;
	}
	public E getRelationToParent() {
		return relationToParent;
	}

	public void setRelationToParent(E relationToParent) {
		this.relationToParent = relationToParent;
	}

	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	/* (non-Javadoc)
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeNode<N, E> other = (TreeNode<N,E>) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		return true;
	}
}

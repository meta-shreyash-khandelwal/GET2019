package bst;

public class BSTNode {
	private Entry newEntry;
	private BSTNode leftChildNode;
	private BSTNode rightChildNode;
	private BSTNode rootNode;
//Respective Getters and Setters
	public Entry getNewEntry() {
		return newEntry;
	}
	public void setNewEntry(Entry newEntry) {
		this.newEntry = newEntry;
	}
	public BSTNode getLeftChildNode() {
		return leftChildNode;
	}
	public void setLeftChildNode(BSTNode leftChildNode) {
		this.leftChildNode = leftChildNode;
	}
	public BSTNode getRightChildNode() {
		return rightChildNode;
	}
	public void setRightChildNode(BSTNode rightChildNode) {
		this.rightChildNode = rightChildNode;
	}
	public BSTNode getRootNode() {
		return rootNode;
	}
	public void setRootNode(BSTNode rootNode) {
		this.rootNode = rootNode;
	}
}

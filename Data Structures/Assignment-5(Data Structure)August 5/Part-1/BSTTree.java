package bst;
import java.util.*;
public class BSTTree implements BinarySearchTreeInterface {
	private BSTNode root;//Contains the root node
	private List<Entry> sortedList;//ArrayList of entries
/*Constructor to create dictionary with specified entries*/
	public BSTTree() {
		sortedList = new ArrayList<Entry>();
		this.root = null;
	}
	//Getter
	public BSTNode getRoot() {
		return root;
	}
//Setter
	public void setRoot(BSTNode root) {
		this.root = root;
	}
/**
 * This method gives Inorder traversal of the BST tree which via recursion 
 * @param node is the BSTNode is a Node of BST
 */
	public void inorderTree(BSTNode node) {
		if (node == null) {
			return;
		}
		inorderTree(node.getLeftChildNode());
		sortedList.add(node.getNewEntry());
	//	System.out.print("Key " + node.getNewEntry().key + " "
		//		+ node.getNewEntry().value);
	//	System.out.println();
		inorderTree(node.getRightChildNode());
	}
/**
 * This method finds whether a specified key is present or not in tree	
 * @param key is the key value in integer
 * @return the BST Node if found , otherwise returns null
 */
	public BSTNode Find(int key) {
		BSTNode node = root;
		while (node != null) {
			int compared = Integer.compare(key, node.getNewEntry().key);
			if (compared < 0) {
				node = node.getLeftChildNode();
			} else if (compared > 0) {
				node = node.getRightChildNode();
			} else {
				/*The keys are equal! Hence return the node's entry */
				return node;
			}
		}
		return null;
	}
/**
 * This method returns specified value of a key
 * @param key is the integer value of key
 * @return the value corresponding to key
 */
	public String getValueFromKey(int key) {
		BSTNode node = root;
		while (node != null) {
			int compared = Integer.compare(key, node.getNewEntry().key);//comparing values
			if (compared < 0) {
				node = node.getLeftChildNode();
			} else if (compared > 0) {
				node = node.getRightChildNode();
			} else {
				return node.getNewEntry().value;
			}

		}
		return null;
	}
/**
 * This method adds a specified key value pair to dictionary
 *@param key is the integer value of key
 *@param value is String value
 *@return the object of type Entry
 */
	public Entry insertNode(int key, String value) {
		if (root == null) {
			root = new BSTNode();
			root.setNewEntry(new Entry(key, value));
			return root.getNewEntry();
		}
		BSTNode node = root;
		BSTNode newNode = new BSTNode();
		newNode.setNewEntry(new Entry(key, value));
//Placing in left if small,otherwise place in right
		while (node != null) {
			int compared = Integer.compare(key, node.getNewEntry().key);
			if (compared < 0) {
				if (node.getLeftChildNode() == null) {
					node.setLeftChildNode(newNode);
					newNode.setRootNode(node);
					return newNode.getNewEntry();
				} else {
					node = node.getLeftChildNode();
				}
			} else if (compared > 0) {

				if (node.getRightChildNode() == null) {
					node.setRightChildNode(newNode);
					newNode.setRootNode(node);
					return newNode.getNewEntry();
				} else {
					node = node.getRightChildNode();
				}
			} else {
				node = node.getLeftChildNode();
			}
		}
		return null;
	}
/**
 * This method removes specified Key-value pair from BST Nodes
 * @param key is the integer value of key
 */
	public void removeNode(int key) {
		BSTNode nodeToBeRemoved = Find(key);
		if (nodeToBeRemoved == null) {
			return;
		}
		if (nodeToBeRemoved.getLeftChildNode() == null
				&& nodeToBeRemoved.getRightChildNode() == null) {
			RemoveChildlessNode(nodeToBeRemoved);

		} else if (nodeToBeRemoved.getLeftChildNode() == null) {
			BSTNode replacementNode = nodeToBeRemoved.getRightChildNode();
			RemoveOneChildNode(nodeToBeRemoved, replacementNode);

		} else if (nodeToBeRemoved.getRightChildNode() == null) {
			BSTNode replacementNode = nodeToBeRemoved.getLeftChildNode();
			RemoveOneChildNode(nodeToBeRemoved, replacementNode);
		} else {
			BSTNode node = nodeToBeRemoved.getRightChildNode();
			while (node.getLeftChildNode() != null) {
				node = node.getLeftChildNode();
			}
			nodeToBeRemoved.setNewEntry(node.getNewEntry());
			if (node.getRightChildNode() == null) {
				RemoveChildlessNode(node);
			} else {
				BSTNode replacementNode = node.getRightChildNode();
				RemoveOneChildNode(node, replacementNode);
			}
		}
	}
/**
 * This method consider deletion in case there is no child node of parent node
 * @param nodeToBeRemoved is the node to be deleted
 */
	private void RemoveChildlessNode(BSTNode nodeToBeRemoved) {
		if (nodeToBeRemoved.getRootNode()
				.getLeftChildNode() == nodeToBeRemoved) {
			nodeToBeRemoved.getRootNode().setLeftChildNode(null);
		} else if (nodeToBeRemoved.getRootNode()
				.getRightChildNode() == nodeToBeRemoved) {
			nodeToBeRemoved.getRootNode().setRightChildNode(null);
		}
		nodeToBeRemoved.setRootNode(null);
	}
/**
 * This method deletes the node in case parent node has one child node
 * @param nodeToBeRemoved is the node to be deleted
 * @param replacementNode is the node to be replaced
 */
	private void RemoveOneChildNode(BSTNode nodeToBeRemoved,
			BSTNode replacementNode) {
		replacementNode.setRootNode(nodeToBeRemoved.getRootNode());
		if (nodeToBeRemoved.getRootNode()
				.getLeftChildNode() == nodeToBeRemoved) {
			nodeToBeRemoved.getRootNode().setLeftChildNode(replacementNode);
		} else if (nodeToBeRemoved.getRootNode()
				.getRightChildNode() == nodeToBeRemoved) {
			nodeToBeRemoved.getRootNode().setRightChildNode(replacementNode);
		}
		nodeToBeRemoved.setRootNode(null);
	}
/**
 * This method returns the list of key-value pairs in the sorted form
 * @param List<Entry> is the ArrayList of type Entry
 * @return sorted List 	
 */
	public List<Entry> sortedOrderGeneral() {
		inorderTree(root);
		return sortedList;
	}
/**
 * This method returns the sorted List from key>=Key1 && key<=Key2
 * @param List<Entry> is the ArrayList of type Entry
 * @return sorted List from Key1 to Key2 		
 */
	public List<Entry> sortedOrderFixed(int key1, int key2) {
		List<Entry> fixedList = new ArrayList<Entry>();
		inorderTree(root);
		for (int j = 0; j < sortedList.size(); j++) {
			if (sortedList.get(j).key >= key1
					&& sortedList.get(j).key <= key2) {
				fixedList.add(sortedList.get(j));
			}
		}
		return fixedList;
	}
/**
 * This method prints the BST Tree	
 */
	public void printSorted() {
		inorderTree(root);
	}
}

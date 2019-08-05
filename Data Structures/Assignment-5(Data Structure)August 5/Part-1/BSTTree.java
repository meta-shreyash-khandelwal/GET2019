package bst;
import java.util.*;
public class BSTTree implements BinarySearchTreeInterface {
private BSTNode root;
private List<Entry> sortedList;
public BSTTree()
{

sortedList=new ArrayList<Entry>();
	this.root=null;
}
public BSTNode getRoot() {
	return root;
}

public void setRoot(BSTNode root) {
	this.root = root;
}

public void inorderTreeWalk(BSTNode node) {
    if(node == null) {
        return;
    }
    inorderTreeWalk(node.getLeftChildNode());
    sortedList.add(node.getNewEntry());
    System.out.print("Key "+node.getNewEntry().key + " "+node.getNewEntry().value);
    System.out.println();
    inorderTreeWalk(node.getRightChildNode());
}
public BSTNode Find(int key) {
    BSTNode node = root;
    while (node != null) {
        int compared = Integer.compare(key, node.getNewEntry().key);
        if (compared < 0) {        
        	node = node.getLeftChildNode();
        } else if (compared > 0) {
            node = node.getRightChildNode();
        } else {
        /*The keys are equal!
         Hence return the node's entry*/
            return node;
        }

    }
    return null;

}

public String getVakueFromKey(int key)
{
	BSTNode node=root;
	while(node!=null)
	{
		  int compared = Integer.compare(key, node.getNewEntry().key);
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
	
	







public Entry Insert(int key, String value) {
    if (root == null) {
        root = new BSTNode();
        root.setNewEntry(new Entry(key,value));
        return root.getNewEntry();
    }
    BSTNode node = root;
    BSTNode newNode = new BSTNode();
    newNode.setNewEntry(new Entry(key, value));

    while (node != null) {
        int compared = Integer.compare(key, node.getNewEntry().key);
        if (compared < 0) {
        /* This means the key we are looking for is smaller than entry.key
            so we should go to the left side of this node, where entry.key is smaller
            and hence we have a better chance of finding a match
        */
            if (node.getLeftChildNode() == null) {
                //node.leftChildNode = newNode;
                node.setLeftChildNode(newNode);
                //newNode.parentNode = node;
                newNode.setRootNode(node);
                return newNode.getNewEntry();
            } else {
                node = node.getLeftChildNode();
            }
        }
        else if (compared > 0) {

            if (node.getRightChildNode() == null) {
                 node.setRightChildNode(newNode);
                //node.rightChildNode = newNode;
               // newNode.parentNode = node;
                newNode.setRootNode(node);
                 return newNode.getNewEntry();
            } else {
                node = node.getRightChildNode();
            }

        } else {
        /*If an exact match is found go to the left tree to re enter this key*/
            node = node.getLeftChildNode();

        }

    }
    return null;

}




public void Remove(int key) {
    BSTNode nodeToBeRemoved = Find(key);
    if (nodeToBeRemoved == null) {
        return;
    }
    if (nodeToBeRemoved.getLeftChildNode() == null && nodeToBeRemoved.getRightChildNode() == null) {
        //No children
        RemoveChildlessNode(nodeToBeRemoved);

    } else if (nodeToBeRemoved.getLeftChildNode() == null) {
        //The node to be removed has only a right child
        BSTNode replacementNode = nodeToBeRemoved.getRightChildNode();
        RemoveOneChildNode(nodeToBeRemoved, replacementNode);


    } else if (nodeToBeRemoved.getRightChildNode() == null) {
        //The node to be removed has only a left child
        BSTNode replacementNode = nodeToBeRemoved.getLeftChildNode();
        RemoveOneChildNode(nodeToBeRemoved, replacementNode);
    } else {
        //The node has both left and right child
        //Go to the right child then keep going left
        //Take its entry and move it to the node to be deleted
        BSTNode node = nodeToBeRemoved.getRightChildNode();
        while (node.getLeftChildNode() != null) {
            node = node.getLeftChildNode();
        }
        nodeToBeRemoved.setNewEntry(node.getNewEntry());

        //Now that we have switched the entry, remove the node that we stole the entry from
        //Since we kept going as far left as we could, obviously the node does not have a left child
        //Check however if it has a right child
        if (node.getRightChildNode()== null) {
            RemoveChildlessNode(node);
        } else {
            BSTNode replacementNode = node.getRightChildNode();
            RemoveOneChildNode(node, replacementNode);
        }

    }

}

private void RemoveChildlessNode(BSTNode nodeToBeRemoved) {
    if (nodeToBeRemoved.getRootNode().getLeftChildNode() == nodeToBeRemoved) {
        //nodeToBeRemoved.parentNode.leftChildNode = null;
    	nodeToBeRemoved.getRootNode().setLeftChildNode(null);
    } else if (nodeToBeRemoved.getRootNode().getRightChildNode() == nodeToBeRemoved) {
        //nodeToBeRemoved.parentNode.rightChildNode = null;
    	nodeToBeRemoved.getRootNode().setRightChildNode(null);
        
    }
    //nodeToBeRemoved.parentNode = null;
    nodeToBeRemoved.setRootNode(null);
}

private void RemoveOneChildNode(BSTNode nodeToBeRemoved, BSTNode replacementNode) {
//    replacementNode.parentNode = nodeToBeRemoved.parentNode;
	replacementNode.setRootNode(nodeToBeRemoved.getRootNode());
	
	
    //Fix the child reference of the parent
    //if (nodeToBeRemoved.parentNode.leftChildNode == nodeToBeRemoved) {
        //node to be removed is a leftchild
    if(nodeToBeRemoved.getRootNode().getLeftChildNode()==nodeToBeRemoved)  {
	
//	nodeToBeRemoved.parentNode.leftChildNode = replacementNode;
    	nodeToBeRemoved.getRootNode().setLeftChildNode(replacementNode);  

} 
    
    //else if (nodeToBeRemoved.parentNode.rightChildNode == nodeToBeRemoved) {
    else if(nodeToBeRemoved.getRootNode().getRightChildNode()==nodeToBeRemoved){  
    	nodeToBeRemoved.getRootNode().setRightChildNode(replacementNode);  
    //node to be removed is a right child
        //nodeToBeRemoved.parentNode.rightChildNode = replacementNode;
    
    }
   // nodeToBeRemoved.parentNode = null;
nodeToBeRemoved.setRootNode(null);
}




/*
public int First() {
    BSTNode node = root;

    while (node != null) {
        if (node.getLeftChildNode() != null) {
            node = node.getLeftChildNode();
        } else {
            return node.getNewEntry().key;
        }
    }

    return node.getNewEntry().key;

}


public int Last() {
    BSTNode node = root;

    while (node != null) {
        if (node.getRightChildNode()!= null) {
            node = node.getRightChildNode();
        } else {
            return node.getNewEntry().key;
        }
    }

    return node.getNewEntry().key;

}
*/


public List<Entry> sortedOrderGeneral()
{	return sortedList;
}


public List<Entry> sortedOrderFixed(int key1,int key2)
{
List<Entry> fixedList=new ArrayList<Entry>();

for(int j=0;j<sortedList.size();j++)
{
	//System.out.println("Kye== "+sortedList.get(j).key);
	if(sortedList.get(j).key>=key1 && sortedList.get(j).key<=key2)
		{
		System.out.println("J== "+j);
		System.out.println("Key here== "+sortedList.get(j).key);
		
		fixedList.add(sortedList.get(j));
		
		}
}
	return fixedList;
	

}







public void PrintSorted() {
  inorderTreeWalk(root);
}
}






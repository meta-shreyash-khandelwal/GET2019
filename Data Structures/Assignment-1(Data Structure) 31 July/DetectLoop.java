package dataStructure;
import java.util.*;
public class DetectLoop {
/**
 * This method checks whether there is a loop in a linked list or not 
 * @param list is the linked list in which loop is to be found
 * @return true when there exists a loop in a linked list otherwise returns false
 */
	public static boolean detectLoopInList(LinkedList list) {
		Set<Node> referenceSet = new HashSet<Node>();
		Node traverse = list.head;
		while (traverse != null) {
			if (referenceSet.contains(traverse)) {//Checking whether the node's reference is already present or not
				return true;
			}
			referenceSet.add(traverse);//Otherwise add into the set
			traverse = traverse.next;

		}
		return false;
	}

}

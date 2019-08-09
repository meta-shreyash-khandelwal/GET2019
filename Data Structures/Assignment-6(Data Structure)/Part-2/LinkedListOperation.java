package qs;

import java.util.List;
import java.util.*;

public class LinkedListOperation {
	Node head;// For storing head position

	/**
	 * This method helps in inserting any new nodes to the list
	 * @param list is the linked list containing head
	 * @param data is the employee object to be inserted in list
	 * @return the linked list with its head position
	 */
	public LinkedListOperation addNode(LinkedListOperation list, Employee data) {
		Node newEntry = new Node(data);
		try {
			if (data == null) {
				throw new Exception("Invalid");
			}
		} catch (Exception e) {
			System.out.println("Invalid entry !! Try Again");
		}
		if (list.head == null) {
			list.head = newEntry;
		} else {
			Node pointer = list.head;
			while (pointer.next != null) {
				pointer = pointer.next;
			}
			pointer.next = newEntry;
		}
		return list;
	}

	/**
	 * This method prints the given linked list
	 * @param list is the linked list to be printed
	 */
	public void printList(LinkedListOperation list) {
		Node pointer = list.head;
		while (pointer != null) {
			System.out.println("ID " + pointer.object.getEmployeeId()
					+ "  Name--->" + pointer.object.getName()
					+ "     Salary -->" + pointer.object.getSalary()
					+ "  Age -->" + pointer.object.getAge());
			pointer = pointer.next;
		}
	}

	/**
	 * This method performs the quicksort considering last node as tail node
	 * @param head is the starting node's reference
	 * @return head reference of sorted List
	 */
	public Node quickSort(Node head) {
		if (head == null || head.next == null)
			return head;
		Node pivot = findTail(head);// pointing pivot
		// At this state nodes from leftHalf to pivot(tail) <= pivot and nodes
		// from pivot.next(tail.next) to end are > pivot
		Node leftHalf = partition(head, pivot);	// dividing right half
		Node rightHalf = pivot.next;
		pivot.next = null;
		cutPivot(leftHalf);// cut pivot temporarily
		Node sortedLeft = quickSort(leftHalf);
		addLast(sortedLeft, pivot);// add pivot again
		pivot.next = quickSort(rightHalf);
		return sortedLeft;
	}

	/**
	 * This method adds pivot to last
	 * @param sortedLeft is the left side reference
	 * @param pivot is the reference of pivot node
	 */
	private void addLast(Node sortedLeft, Node pivot) {
		Node temporary = sortedLeft;
		while (temporary.next != null) {
			temporary = temporary.next;
		}
		temporary.next = pivot;
	}

	/**
	 * Cuts pivot into half nodes  
	 * @param leftHalf
	 */
	private void cutPivot(Node leftHalf) {
		if (leftHalf == null || leftHalf.next == null)
			return;
		Node temporary = leftHalf;
		Node previous = null;
		while (temporary.next != null) {
			previous = temporary;
			temporary = temporary.next;
		}
		previous.next = null;
	}
/**
 * This method finds the tail of the list when its head is passed
 * @param head is the head of Linked list
 * @return the reference of tail node
 */
	private Node findTail(Node head) {
		Node temporary = head;
		while (temporary.next != null)
			temporary = temporary.next;
		return temporary;
	}

	/**
	 * It assumes tail as pivot. It starts traversing from head and adds every
	 * node which is > tail(i.e. pivot) added at last
	 * @param head is node of starting reference
	 * @param tail is end tail reference
	 * @return the Node reference of the pivot correct position
	 */
	private Node partition(Node head, Node tail) {
		Node actualHead = head;
		Node newTail = tail;
		Node previous = null;
		if (head == tail) {
			return head;
		}
		// tail node is pivot
		while (head != tail) {
			// all the nodes should be left of pivot which are less than pivot
			if (head.object.getSalary() >= tail.object.getSalary()) {
				previous = head;
				head = head.next;
			}
			// all the nodes should be right of pivot
			else {
				// remove head node and add at tail
				if (previous != null) {
					previous.next = head.next;
				} else {
					actualHead = head.next;
				}
				// adding at tail
				Node temporary = head;
				head = head.next;
				temporary.next = null;
				newTail.next = temporary;
				newTail = newTail.next;

			}
		}
		return actualHead;
	}

	/**
	 * This method returns the result after the complete evaluation
	 * @param list is the linked list
	 * @return the result containing array list of the object
	 */
	public List<Employee> resultList(LinkedListOperation list) {
		List<Employee> result = new ArrayList<Employee>();
		Node pointer = list.head;
		while (pointer != null) {
			System.out.println(pointer.object.getSalary());
			result.add(pointer.object);
			pointer = pointer.next;
		}
		return result;
	}
}

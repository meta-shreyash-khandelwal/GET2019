package dataStructure;

import java.util.*;

class LinkedList {
	Node head;
/**
 * This method inserts the element in a linked list
 * @param newList is the linked list in which element is to be added
 * @param data is the integer data to be added in linked list	
 * @return the linked list with data inserted
 */
	public LinkedList insertList(LinkedList newList, int data) {
		Node newNode = new Node(data);
		if (newList.head == null) {
			newList.head = newNode;
		} else {
			Node last = newList.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}
		return newList;
	}
/**
 * This method prints the linked list 
 * @param list is the linked list to be printed
 */
	public ArrayList<Integer> printLinkedList(LinkedList list) {
		Node pointer = list.head;
		int index=0;
		ArrayList<Integer> element=new ArrayList<Integer>();
		while (pointer != null) {
	element.add(pointer.data);
		index++;
			System.out.println("DATA " + pointer.data + " REFERENCE "
					+ pointer.next);
			pointer = pointer.next;
		}
		return element;
	}
/**
 * This method returns the reference of node at a specified position
 * @param list is the linked list in which 
 * @param position is the integer in the list representing node
 * @return the Node containing reference at specified position
 */
	public Node checkReference(LinkedList list, int position) {
		int counter = 1;
		Node pointer = list.head;
		if (position == 1) {// For initial case
			return pointer;
		} else {
			while (pointer != null) {
				counter++;
				pointer = pointer.next;
				if (counter == position) { 
					return pointer;
				}
			}
		}
		return null;
	}
/**
 * This method rotates the given sub-linked list from left to right at specified number clockwise
 * @param list is the complete linked list in which the element is to be rotated
 * @param left is the starting point of sub linked list
 * @param right is the ending point of  sub-linked list
 * @param numberOfTurning is the number by which the list is to be rotated from left to right
 * @return the rotated linked list
 */
	public LinkedList rotateSubList(LinkedList list, int left, int right,
			int numberOfTurning) {
		if (numberOfTurning == right - 1)
			return list;
		if(left==1)
		{
			
			//Node leftPrevious = null;
			Node leftNode = list.head;
			Node rightNode = checkReference(list, right);
			System.out.println("RIGHT "+rightNode);
			Node rightNext = rightNode.next;
			Node turningNode = checkReference(list, left + numberOfTurning - 1);
			Node turningNext = turningNode.next;
			//leftPrevious.next = turningNext;//Transferring the previous left node to next
			list.head=turningNext;
			turningNode.next = rightNext; //Transferring the rotating node's next to right
			rightNode.next = leftNode; //Transferring the next of right node to left node
		}
		
		else
		{
		Node leftPrevious = checkReference(list, left - 1);
		Node leftNode = leftPrevious.next;
		Node rightNode = checkReference(list, right);
		Node rightNext = rightNode.next;
		Node turningNode = checkReference(list, left + numberOfTurning - 1);
		Node turningNext = turningNode.next;

		leftPrevious.next = turningNext;//Transferring the previous left node to next
		rightNode.next = leftNode; //Transferring the next of right node to left node
		turningNode.next = rightNext; //Transferring the rotating node's next to right
		}
		return list;
	}
}

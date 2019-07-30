package dataStructure;

class LinkedList {
	Node head;

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

	public void printLinkedList(LinkedList list) {
		Node pointer = list.head;
		while (pointer != null) {
			System.out.println("DATA " + pointer.data + " REFERENCE "
					+ pointer.next);
			pointer = pointer.next;
		}
	}

	public Node checkReference(LinkedList list, int position) {
		int counter = 1;
		Node pointer = list.head;
		if (position == 1) {// System.out.println("C "+counter+" ASDA "+pointer.data);
			return pointer;
		} else {
			while (pointer != null) {
				counter++;
				pointer = pointer.next;
				if (counter == position) { // System.out.println("C "+counter+" ASDA "+pointer.data);
					return pointer;
				}

			}
			// System.out.println("HRER "+pointer);
		}
		return null;
	}

	public LinkedList rotateSubList(LinkedList list, int left, int right,
			int numberOfTurning) {
		// Node pointer=list.head;

		if (numberOfTurning == right - 1)
			return list;
		Node leftPrevious = checkReference(list, left - 1);
		Node leftNode = leftPrevious.next;
		Node rightNode = checkReference(list, right);
		Node rightNext = rightNode.next;
		Node turningNode = checkReference(list, left + numberOfTurning - 1);
		Node turningNext = turningNode.next;

		/*
		 * System.out.println("LPRE "+leftPrevious); System.out.println("L "+L);
		 * System.out.println("R "+rightNode);
		 * System.out.println("Rnext  "+RNex);
		 * System.out.println("K "+turningNode);
		 * System.out.println("K next "+turningNext);
		 */
		leftPrevious.next = turningNext;
		System.out.println("COPYY " + rightNext);
		rightNode.next = leftNode;
		// System.out.println("RENEX .nextCOPYY "+rightNext.next);
		turningNode.next = rightNext;

		return list;

	}
}

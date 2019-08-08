package qs;

public class Node {
	Employee object;
	Node next;

	public Employee getObject() {
		return object;
	}

	public Node(Employee object) {
		this.object = object;
		next = null;
	}
}
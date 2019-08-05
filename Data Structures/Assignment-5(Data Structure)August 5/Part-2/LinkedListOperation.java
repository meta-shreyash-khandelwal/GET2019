package vk;

import java.util.List;
import java.util.*;
public class LinkedListOperation {
	Node head;//For storing head position
/**
 * This method helps in inserting any new nodes to the list
 * @param list is the linked list containing head
 * @param data is the employee object to be inserted in list
 * @return the linked list with its head position
 */
	public LinkedListOperation addNode(LinkedListOperation list, Employee data) {
		Node newEntry = new Node(data);
		try{
		if(data==null)
		{
			throw new Exception("Invalid");
		}
		}
		catch(Exception e)
		{
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
 * This method sorts the employee objects on the basis of salary
 * @param list is the linked list containing the objects of type Employee
 * @return the sorted linked list on the basis of salary with its head
 */
	public LinkedListOperation sortList(LinkedListOperation list) {
		Node current = list.head;
		Node index = null;
		Employee temporary;
		while (current != null) {
			index = current.next;
			while (index != null) {
				if (current.object.getSalary() < index.object.getSalary()) {
					temporary = current.object;
					current.object = index.object;
					index.object = temporary;
				}
				if (current.object.getSalary() == index.object.getSalary()) {/*In case salary is equal then the one having the lower age would be given preference*/
					if (current.object.getAge() >= index.object.getAge()) {//Comparing age
						temporary = current.object;
						current.object = index.object;
						index.object = temporary;
					}
				}
				index = index.next;
			}
			current = current.next;
		}

		return list;
	}
/**
 * This method returns the result after the complete evaluation	
 * @param list is the linked list 
 * @return the result containing array list of the object
 */
	public List<Employee> resultList(LinkedListOperation list)
	{
		List<Employee> result=new ArrayList<Employee>();
		Node pointer = list.head;
		while (pointer != null) {
			result.add(pointer.object);
			pointer = pointer.next;
		}
		return result;
	}
	}

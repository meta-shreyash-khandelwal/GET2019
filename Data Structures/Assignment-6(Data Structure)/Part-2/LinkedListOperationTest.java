package qs;

import static org.junit.Assert.*;
import java.util.*;
import java.util.List;

import org.junit.Test;

public class LinkedListOperationTest {
	LinkedListOperation object=new LinkedListOperation();
	
	@Test
	public void testSortList1() {
		
			LinkedListOperation object1=new LinkedListOperation();
	
		Employee object11=new Employee(2,"Shamshir",10000,20);
		Employee object22=new Employee(1,"Vikrant",21600,23);
		Employee object33=new Employee(4,"Varun",22500,23);
		Employee object44=new Employee(5,"Surya",12000,23);
		Employee object55=new Employee(3,"Raju",500,24);
		object.addNode(object1,object11);
		object.addNode(object1,object22);
		object.addNode(object1, object33);
		object.addNode(object1, object44);
		object.addNode(object1, object55);
		object1.head=object1.quickSort(object1.head);
		List<Employee> list1=new ArrayList<Employee>();
		list1=object.resultList(object1);
		String expected[]=new String[] {"Varun","Vikrant","Surya","Shamshir","Raju"};
		String actual[]=new String[5];
		for(int i=0;i<list1.size();i++)
		{
			actual[i]=list1.get(i).getName();
		}
		assertArrayEquals(actual,expected);
	}
	
	
	

}
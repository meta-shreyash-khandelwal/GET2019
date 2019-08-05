package vk;

import static org.junit.Assert.*;
import java.util.*;
import java.util.List;

import org.junit.Test;

public class Test2 {
	LinkedListOperation object=new LinkedListOperation();
	
	@Test
	public void testSortList1() {
		
			LinkedListOperation object1=new LinkedListOperation();
	
		Employee object11=new Employee(2,"Shamshir",1000,20);
		Employee object22=new Employee(1,"Vikrant",2000,23);
		Employee object33=new Employee(3,"Raju",500,24);
		object.addNode(object1,object11);
		object.addNode(object1,object22);
		object.addNode(object1, object33);
		object.sortList(object1);
		//object.printList(object1);
		List<Employee> list1=new ArrayList<Employee>();
		list1=object.resultList(object1);
		String expected[]=new String[] {"Vikrant","Shamshir","Raju"};
		String actual[]=new String[3];
		for(int i=0;i<list1.size();i++)
		{
			actual[i]=list1.get(i).getName();
		}
		assertArrayEquals(actual,expected);
	}
	@Test
	public void testSortList2() {
		LinkedListOperation object1=new LinkedListOperation();
		
		Employee object11=new Employee(2,"Jam",2500,20);
		Employee object22=new Employee(1,"Viru",21000,23);
		Employee object33=new Employee(3,"Raj",1500,24);
		Employee object44=new Employee(3,"Sheena",2500,24);
		
		object.addNode(object1,object11);
		object.addNode(object1,object22);
		object.addNode(object1, object33);
		object.addNode(object1, object44);
		
		object.sortList(object1);
		//object.printList(object1);
		List<Employee> list1=new ArrayList<Employee>();
		list1=object.resultList(object1);
		String expected[]=new String[] {"Viru","Jam","Sheena","Raj"};
		String actual[]=new String[list1.size()];
		for(int i=0;i<list1.size();i++)
		{
			actual[i]=list1.get(i).getName();
		}
		assertArrayEquals(actual,expected);	
	
	}
	
	
	
	

}

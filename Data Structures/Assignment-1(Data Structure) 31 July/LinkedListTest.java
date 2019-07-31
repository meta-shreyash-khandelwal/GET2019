import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class LinkedListTest {
	LinkedList obj=new LinkedList();

	@Test
	public void testRotateSubList1() {
		LinkedList newList=new LinkedList();
		 obj.insertList(newList, 2);
		 obj.insertList(newList, 3);
		 obj.insertList(newList, 4);
		 obj.insertList(newList, 5);
		 obj.insertList(newList, 6);
		 obj.insertList(newList, 7);
		 obj.insertList(newList, 8);
		 obj.insertList(newList, 9);
		 obj.rotateSubList(newList, 1, 5, 2);//Rotating
		 List<Integer> list=new ArrayList<Integer>();
		 list=obj.printLinkedList(newList);
		int result[]=new int[list.size()];
		 for(int i=0;i<result.length;i++)
		 {
			 result[i]=list.get(i);
		 }
		 
		int expected[]=new int[]{4,5,6,2,3,7,8,9};
		 assertArrayEquals(expected,result);
		 
	}

	
	@Test
	public void testRotateSubList2() {
		LinkedList newList=new LinkedList();
		 obj.insertList(newList, 10);
		 obj.insertList(newList, 15);
		 obj.insertList(newList, 20);
		 obj.insertList(newList, 50);
		 obj.insertList(newList, 60);
		 obj.insertList(newList, 90);
		 obj.insertList(newList, 100);
		 obj.insertList(newList, 110);
		 obj.rotateSubList(newList, 3, 7, 2);//Rotating
		 List<Integer> list=new ArrayList<Integer>();
		 list=obj.printLinkedList(newList);
		int result[]=new int[list.size()];
		 for(int i=0;i<result.length;i++)
		 {
			 result[i]=list.get(i);
		 }
		 
		int expected[]=new int[]{10,15,60,90,100,20,50,110};
		int expectedNot[]=new int[]{10,15,60,90,100,20,50,11};
		
		assertArrayEquals(expected,result);//Positive test case
		assertFalse(Arrays.equals(expected, expectedNot));//Negative test case
	}
	
	@Test
	public void testDetectLoopInList1() {
		LinkedList newList=new LinkedList();
		 obj.insertList(newList, 10);
		 obj.insertList(newList, 15);
		 obj.insertList(newList, 20);
		 obj.insertList(newList, 50);
		 obj.insertList(newList, 60);
		 obj.insertList(newList, 90);
		 obj.insertList(newList, 100);
		 obj.insertList(newList, 110);
		 assertFalse(DetectLoop.detectLoopInList(newList));//Negative test case
	}
	
	@Test
	public void testDetectLoopInList2() {
		 LinkedList newList2=new LinkedList();
		 obj.insertList(newList2, 15);
		 obj.insertList(newList2, 20);
		 obj.insertList(newList2, 25);
		 obj.insertList(newList2, 30);
		 obj.insertList(newList2, 40);
		Node position1=obj.checkReference(newList2, 5);
		Node position2=obj.checkReference(newList2, 2);
		position1.next=position2;
		 assertTrue(DetectLoop.detectLoopInList(newList2));//Negative test case
		}

	
	@Test
	public void testGetDegree1()
	{
		//Assuming we have 4 variable x,y,z,w
		MultivariatePolynomial object=new MultivariatePolynomial();
		ArrayList<Integer> list1=new ArrayList<Integer>();//Representing x^2*y^1
			list1.add(2);
			list1.add(1);
			list1.add(0);
			list1.add(0);

			ArrayList<Integer> list2=new ArrayList<Integer>();//Representing y^1*z^1*w^1
			list2.add(0);
			list2.add(1);
			list2.add(3);
			list2.add(1);

			ArrayList<Integer> list3=new ArrayList<Integer>();//Representing x^1*y^1*z^1*w^1
			list3.add(1);
			list3.add(1);
			list3.add(1);
			list3.add(1);

			ArrayList<Integer> list4=new ArrayList<Integer>();//Representing x^3*y^2*z^1*w^2
			list4.add(3);
			list4.add(2);
			list4.add(1);
			list4.add(2);

			ArrayList<Integer> list5=new ArrayList<Integer>();//Representing x^1*z^1*w^2
			list5.add(1);
			list5.add(0);
			list5.add(1);
			list5.add(2);
			//Adding all the terms to create a polynomial
			object.addterms(1, list1);	
			object.addterms(2, list2);	
			object.addterms(3, list3);	
			object.addterms(4, list4);	
			object.addterms(5, list5);	
int expected=8;
assertEquals(expected,object.getDegree());
	}
	
	
	@Test
	public void testGetDegree2()
	{
		//Assuming we have 4 variable x,y,z
		MultivariatePolynomial object=new MultivariatePolynomial();
		ArrayList<Integer> list1=new ArrayList<Integer>();//Representing x^1*y^1
			list1.add(1);
			list1.add(1);
			list1.add(0);
		

			ArrayList<Integer> list2=new ArrayList<Integer>();//Representing y^1*z^3
			list2.add(0);
			list2.add(1);
			list2.add(3);
		
			ArrayList<Integer> list3=new ArrayList<Integer>();//Representing x^1
			list3.add(1);
			list3.add(0);
			list3.add(0);
		
			ArrayList<Integer> list4=new ArrayList<Integer>();//Representing x^1*y^2*z^1
			list4.add(1);
			list4.add(2);
			list4.add(1);
	
//Adding all the terms to create a polynomial
		object.addterms(1, list1);	
		object.addterms(2, list2);	
		object.addterms(3, list3);	
		object.addterms(4, list4);	
int expected=4;
assertEquals(expected,object.getDegree());
	}
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

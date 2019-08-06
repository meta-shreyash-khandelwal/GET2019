package bst;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;
public class Test {

	@org.junit.Test
	public void testAddKeyValue() {
		BSTTree bTree=new BSTTree();
		bTree.insertNode(1, "one");
		bTree.insertNode(2, "two");
		bTree.insertNode(5, "five");
		bTree.insertNode(6, "six");
		bTree.insertNode(4, "four");
		bTree.insertNode(3, "three");
		List<Entry> list=new ArrayList<Entry>();
		list=bTree.sortedOrderGeneral();
		assertEquals(6,list.size());
	}
	
	@org.junit.Test
	public void testDeleteValue() {
		BSTTree bTree=new BSTTree();
		bTree.insertNode(5, "five");
		bTree.insertNode(6, "six");
		bTree.insertNode(4, "four");
		bTree.insertNode(3, "three");
		bTree.removeNode(6);
		bTree.removeNode(3);
		List<Entry> list=new ArrayList<Entry>();
		list=bTree.sortedOrderGeneral();
		assertEquals(2,list.size());//Since two keys 3 and 6 are removed
	}
	@org.junit.Test
	public void testGetValueFromKey() {
		BSTTree bTree=new BSTTree();
		bTree.insertNode(1, "one");
		bTree.insertNode(2, "two");
		bTree.insertNode(5, "five");
		bTree.insertNode(6, "six");
		bTree.insertNode(4, "four");
		bTree.insertNode(3, "three");
		List<Entry> list=new ArrayList<Entry>();
		String expected1="six";
		String expected2="three";
	assertEquals(expected1,bTree.getValueFromKey(6));
	assertEquals(expected2,bTree.getValueFromKey(3));
	}
	@org.junit.Test
	public void testSortedListKeyValue() {
		
		BSTTree bTree=new BSTTree();
		bTree.insertNode(6, "six");
		bTree.insertNode(1, "one");
		bTree.insertNode(2, "two");
		bTree.insertNode(5, "five");
		bTree.insertNode(4, "four");
		List<Entry> list=new ArrayList<Entry>();
		list=bTree.sortedOrderGeneral();
		int expected[]=new int[]{1,2,4,5,6};
		int actual[]=new int[list.size()];
		for(int j=0;j<list.size();j++)
		{
			actual[j]=list.get(j).key;
		}
		assertArrayEquals(expected,actual);

	}
	@org.junit.Test
	public void testSpecifiedSorted() {
		
		BSTTree bTree=new BSTTree();
		bTree.insertNode(6, "six");
		bTree.insertNode(1, "one");
		bTree.insertNode(2, "two");
		bTree.insertNode(5, "five");
		bTree.insertNode(4, "four");
		bTree.insertNode(12, "twelve");
		bTree.insertNode(15, "fifteen");
		bTree.insertNode(10, "ten");
		List<Entry> list=new ArrayList<Entry>();
		int key1=4;
		int  key2=12;
		int index=0;
		list=bTree.sortedOrderFixed(key1, key2);
		int expected[]=new int[]{4,5,6,10,12};
		int actual[]=new int[list.size()];
		for(int j=0;j<list.size();j++)
		{
			actual[j]=list.get(j).key;
		}
		assertArrayEquals(expected,actual);
	}
	

}

package varunk;
import java.util.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class IntSetTest {

	@Test
	public void testSize() {
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(1);
		set1.add(10);
		set1.add(21);
		set1.add(100);
		set1.add(19);
		set1.add(15);
		IntSet object=new IntSet(set1);
		assertEquals(6,object.size());
		
	}
	@Test
	public void testMemberPresent() {
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(100);
		set1.add(1);
		set1.add(20);
		set1.add(50);
		set1.add(200);
		IntSet object=new IntSet(set1);
		assertFalse(object.isMember(6));
		//assertTrue(object.isMember(60));
	}
	
	@Test
	public void testMemberPresent2() {
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(100);
		set1.add(1);
		set1.add(20);
		set1.add(50);
		set1.add(200);
		IntSet object=new IntSet(set1);
		assertTrue(object.isMember(200));
		//assertTrue(object.isMember(60));
	}
	@Test
	public void testsubset1() {
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(100);
		set1.add(1);
		set1.add(20);
		set1.add(50);
		set1.add(200);
		IntSet object1=new IntSet(set1);
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(100);
		set2.add(20);
		IntSet object2=new IntSet(set2);
		assertTrue(object1.isSubSet(object2));//set2 subset of set1 or not
		//assertTrue(object.isMember(60));
	}
	@Test
	public void testsubset2() {
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(1);
		set1.add(20);
		set1.add(40);
		set1.add(800);
		set1.add(5);
		IntSet object1=new IntSet(set1);
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(100);
		set2.add(20);
		IntSet object2=new IntSet(set2);
		assertFalse(object1.isSubSet(object2));//set2 subset of set1 or not
		//assertTrue(object.isMember(60));
	}
	
	@Test
	public void testunion1() {
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(30);
		set1.add(40);
		set1.add(50);
		set1.add(80);
		IntSet object1=new IntSet(set1);
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(10);
		set2.add(20);
		IntSet object2=new IntSet(set2);
		Set<Integer> set3 = new HashSet<Integer>();
		set3.add(10);
		set3.add(20);
		set3.add(30);
		set3.add(40);
		set3.add(50);
		set3.add(80);
		assertEquals(set3,object2.union(object1,object2));
	
		//assertTrue(object.isMember(60));
	}
	
	
	@Test
	public void testunion2() {
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(300);
		set1.add(400);
		set1.add(500);
		set1.add(800);
		IntSet object1=new IntSet(set1);
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(100);
		set2.add(200);
		set2.add(500);
		set2.add(800);
		IntSet object2=new IntSet(set2);
		Set<Integer> set3 = new HashSet<Integer>();
		set3.add(100);
		set3.add(200);
		set3.add(300);
		set3.add(400);
		set3.add(500);
		set3.add(800);
		assertEquals(set3,object1.union(object1,object2));
	
	
	}
	

	@Test
	public void testgetcomplement1() {
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(100);
		set1.add(400);
		set1.add(500);
		set1.add(999);
		IntSet object1=new IntSet(set1);
		Set<Integer> set3 = new HashSet<Integer>();
		for(int i=1;i<=1000;i++)
		{
			if(i!=100 && i!=400 && i!=500 && i!=999)
				set3.add(i);
		}
		
		
		assertEquals(set3,object1.getComplement());
	
	
	}
	
	
	
	
	
	
	
	
	
	
	

}

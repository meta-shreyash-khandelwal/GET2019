import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;
public class IntSetTest {
	@Test
	public void testSizeShouldReturn_SizeWhenInput_Set() {
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
	public void testMemberPresentShouldReturn_TrueWhenElementPresentInSet1() {
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
	public void testMemberPresentShouldReturn_TrueWhenElementPresentInSet2() {
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
	public void testSubsetShouldReturn_TrueWhenSet2_Is_Subset_Of_Set1() {
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
	public void testSubsetShouldReturn_TrueWhenSet2_Is_Subset_Of_Set1_2() {
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
	public void testUnionShouldReturn_Union_Of_Set2_And_Set1_1() {
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
	}
	@Test
	public void testUnionShouldReturn_Union_Of_Set2_And_Set1_2() {
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
	public void testComplementShouldReturn_Complement_Of_Set1_from_UniversalSet() {
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

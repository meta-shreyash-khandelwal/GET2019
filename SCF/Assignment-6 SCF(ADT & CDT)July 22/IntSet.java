import java.util.*;
public class IntSet {
	Set<Integer> setOfInteger;//HashSet for avoiding any duplicates
/*Constructor initializes the value of instance variable */
 	public IntSet(Set<Integer> set) {
		setOfInteger = new HashSet<Integer>(1000);
		setOfInteger = set;
	}
/**
 * This method returns the size of the set
 * @return integer value depicting size of array
 */
	public int size() {
		try
		{
		if(setOfInteger==null)
		{
			throw new Exception("Empty Set");
		}
		}
		catch(Exception e)
		{
			System.out.println("Empty Set Passed");
		}
		return setOfInteger.size();
	}
/**
 * This method check whether x is a member of the set or not
 * @param x is integer member to be searched in set
 * @return true if element is found and false if the element not found
 */
	public boolean isMember(int x) {
		Integer object = new Integer(x);
		return setOfInteger.contains(object);
	}
/**
 * This method tells whether "subset" is the subset of given set
 * @param subset is the object containing Set to be checked
 * @return true if subset exists otherwise returns false
 */
	public boolean isSubSet(IntSet subset) {
		try
		{
		if(subset==null)
		{
			throw new Exception("Empty Set");
		}
		}
		catch(Exception e)
		{
			System.out.println("Empty Set Passed");
		}
	
		return setOfInteger.containsAll(subset.setOfInteger);
	}
/**
 * This method returns the complement of the given set
 * @return the Set containing complement of the set
 */
	public Set<Integer> getComplement() {
		Set<Integer> universal = new HashSet<Integer>(1000);
		for (int i = 1; i <= 1000; i++) {
			universal.add(i);
		}
		universal.removeAll(setOfInteger);
		return universal;
	}
/**
 * This method returns the union of two set
 * @param object1 containing the object having first set
 * @param object2 containing the object having second set
 * @return the Set containing the union of two sets
 */
	public Set<Integer> union(IntSet object1, IntSet object2) {
		try
		{
		if(object1.setOfInteger==null || object2.setOfInteger==null)
		{
			throw new Exception("Empty Set");
		}
		}
		catch(Exception e)
		{
			System.out.println("Empty Set Passed");
		}
	
		object1.setOfInteger.addAll(object2.setOfInteger);
		return object1.setOfInteger;
	}
}
/*
class MainChecking {
	public static void main(String[] args) {

		Set<Integer> s1 = new HashSet<Integer>();
		s1.add(1);
		s1.add(10);
		s1.add(21);
		s1.add(100);
		s1.add(19);
		s1.add(15);
		Set<Integer> s2 = new HashSet<Integer>();
		s2.add(11);
		s2.add(110);
		s2.add(210);
		s2.add(99);
		s2.add(990);
		Set<Integer> s3 = new HashSet<Integer>();
		s3.add(1);
		s3.add(10);
		s3.add(210);
		s3.add(100);

		IntSet set1 = new IntSet(s1);
		// set1.addNumbers(10);
		IntSet set2 = new IntSet(s2);
		IntSet set3 = new IntSet(s3);

		System.out.println(set1.size());
		System.out.println(set2.size());
		System.out.println(set1.isMember(10));
		System.out.println(set2.isMember(900));
		System.out.println(set1.isSubSet(set3));
		System.out.println(set1.getComplement());
		System.out.println(set1.union(set1, set3));

	}

}
*/

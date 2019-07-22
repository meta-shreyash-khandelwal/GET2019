package varunk;
import java.util.*;
public class IntSet {
Set<Integer> setOfInteger;
public IntSet(Set<Integer> set)
{
	setOfInteger=new HashSet<Integer>(1000);
	setOfInteger=set;
}
//private void addNumbers(int numberAdd)
//{
	/*Scanner in=new Scanner(System.in);
}
	int number=0;
	for(int i=0;i<numberAdd;i++)
	{
		System.out.println("Enter in range 1-1000");
		number=in.nextInt();*/
	//	setOfInteger.add(numberAdd);
//}
public int size()
{
	return setOfInteger.size();
}
public boolean isMember(int x)
	{
	Integer object=new Integer(x);
return setOfInteger.contains(object);		
	}
public boolean isSubSet(IntSet subset)
{
	return setOfInteger.containsAll(subset.setOfInteger);
}
public Set<Integer> getComplement()
{
	Set<Integer> universal=new HashSet<Integer>(1000);
	for(int i=1;i<=1000;i++)
	{
		universal.add(i);
	}
	universal.removeAll(setOfInteger);
return universal;
}
public Set<Integer> union(IntSet object1, IntSet object2)
{
	object1.setOfInteger.addAll(object2.setOfInteger);
	return object1.setOfInteger;
}

}
class MainCheck
{
	public static void main(String[] args) {
		
 
		Set<Integer> s1=new HashSet<Integer>();
		s1.add(1);
		s1.add(10);
		s1.add(21);
		s1.add(100);
		s1.add(19);
		s1.add(15);
		Set<Integer> s2=new HashSet<Integer>();
		s2.add(11);
		s2.add(110);
		s2.add(210);
		s2.add(99);
		s2.add(990);
		Set<Integer> s3=new HashSet<Integer>();
		s3.add(1);
		s3.add(10);
		s3.add(210);
		s3.add(100);
		
		
		IntSet set1=new IntSet(s1);
		//set1.addNumbers(10);
		IntSet set2=new IntSet(s2);
		IntSet set3=new IntSet(s3);
		
		System.out.println(set1.size());
		System.out.println(set2.size());
		System.out.println(set1.isMember(10));
		System.out.println(set2.isMember(900));
		System.out.println(set1.isSubSet(set3));
		System.out.println(set1.getComplement());
		System.out.println(set1.union(set1,set3));
		
	}

}


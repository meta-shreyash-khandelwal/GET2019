package bst;
import java.util.*;
public class Main {
public static void main(String args[])
{
	BSTTree b=new BSTTree();
	b.Insert(1, "one");
	b.Insert(2, "two");
	b.Insert(5, "five");
	b.Insert(6, "six");
	b.Insert(4, "four");

	b.Insert(3, "three");
	b.PrintSorted();
	System.out.println();
	BSTNode n=b.Find(3);
	//b.Remove(2);
	b.Remove(5);
	//b.PrintSorted();
	List<Entry> lt=new ArrayList<Entry>();
	lt=b.sortedOrderGeneral();
	for(int i=0;i<lt.size();i++)
	{
		System.out.println("Key "+lt.get(i).key+" Value  "+lt.get(i).value);
	}
	
	
	System.out.println(b.getVakueFromKey(5));

	System.out.println(n.getNewEntry().value);
	
	
	
	List<Entry> lt1=new ArrayList<Entry>();
	lt1=b.sortedOrderFixed(3, 5) ;
	for(int i=0;i<lt1.size();i++)
	{
		System.out.println("Key "+lt1.get(i).key+" Value  "+lt1.get(i).value);
	}
	
	
}
}

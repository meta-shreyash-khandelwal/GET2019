package dataStructure;
import java.util.*;
public class MultivariateMain {
public static void main(String args[])
{
	MultivariatePolynomial object=new MultivariatePolynomial();
	ArrayList<Integer> list1=new ArrayList<Integer>();
	list1.add(2);
	list1.add(1);
	list1.add(0);
	list1.add(0);

	ArrayList<Integer> list2=new ArrayList<Integer>();
	list2.add(0);
	list2.add(1);
	list2.add(3);
	list2.add(1);

	ArrayList<Integer> list3=new ArrayList<Integer>();
	list3.add(1);
	list3.add(1);
	list3.add(1);
	list3.add(1);

	ArrayList<Integer> list4=new ArrayList<Integer>();
	list4.add(3);
	list4.add(2);
	list4.add(1);
	list4.add(2);

	ArrayList<Integer> list5=new ArrayList<Integer>();
	list5.add(1);
	list5.add(0);
	list5.add(1);
	list5.add(2);

object.addterms(1, list1);	
object.addterms(2, list2);	
object.addterms(3, list3);	
object.addterms(4, list4);	
object.addterms(5, list5);	
System.out.println("DEGREE "+object.getDegree());
	
	
	
	//object.addterms(termNumber, coefficient);
	
	
	
}
}

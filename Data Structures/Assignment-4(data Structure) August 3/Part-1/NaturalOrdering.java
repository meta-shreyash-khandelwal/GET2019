package varunk;
import java.util.*;
public class NaturalOrdering 
{ 
	public static void main(String args[])
	{
List<Employee> empList=new ArrayList<Employee>();
empList.add(new Employee(5,"Ajay","Raj Nagar"));		
empList.add(new Employee(2,"Broad","Tilak Nagar"));
empList.add(new Employee(4,"Steve","Ajmeri Gate"));
empList.add(new Employee(3,"Virat","Ram Nagar"));
empList.add(new Employee(1,"Shreyash","Shastri Nagar"));
		Collections.sort(empList);
		for(int i=0;i<empList.size();i++)
		{
			System.out.println(empList.get(i).getEmployeeId()+"  "+empList.get(i).getName());
	
		}
		
		NameCompare object1=new NameCompare();
		Collections.sort(empList, object1);
		System.out.println();
		
		for(int i=0;i<empList.size();i++)
		{
			System.out.println(empList.get(i).getEmployeeId()+"  "+empList.get(i).getName());
	
		}
		
		
		
		
			}
	  
}

package varunkumar;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
public class TestClass {

	@Test
	public void testCompareOnNaturalOrder() {
		List<Employee> empList=new ArrayList<Employee>();
		
		empList.add(new Employee(5,"Ajay","Raj Nagar"));		
		empList.add(new Employee(2,"Broad","Tilak Nagar"));
		empList.add(new Employee(4,"Steve","Ajmeri Gate"));
		empList.add(new Employee(3,"Virat","Ram Nagar"));
		empList.add(new Employee(1,"Shreyash","Shastri Nagar"));
		int  expected[]=new int[] {1,2,3,4,5};
		int actual[]=new int[5];
		Collections.sort(empList);
		for(int k=0;k<expected.length;k++)
		{
			actual[k]=empList.get(k).getEmployeeId();
		}
		assertArrayEquals(expected,actual);
		}
	@Test
	public void testCompareNameSorting() {
		List<Employee> empList=new ArrayList<Employee>();
			empList.add(new Employee(2,"Broad","Tilak Nagar"));
		empList.add(new Employee(4,"Steve","Ajmeri Gate"));
		empList.add(new Employee(5,"Ajay","Raj Nagar"));	
		empList.add(new Employee(3,"Virat","Ram Nagar"));
		empList.add(new Employee(1,"Shreyash","Shastri Nagar"));
		NameCompare object1=new NameCompare();
		Collections.sort(empList, object1);
		String  expected[]=new String[] {"Ajay","Broad","Shreyash","Steve","Virat"};
		String actual[]=new String[5];
	//	Collections.sort(arg0, arg1);
		for(int k=0;k<expected.length;k++)
		{
			actual[k]=empList.get(k).getName();
		}
		assertArrayEquals(expected,actual);
		}
	@Test
	public void testUniqueAddingId()throws Exception {
		List<Employee> empList=new ArrayList<Employee>();
		UniqueEmployee object=new UniqueEmployee();
		empList.add(new Employee(2,"Broad","Tilak Nagar"));
		empList.add(new Employee(3,"Virat","Ram Nagar"));
		empList.add(new Employee(3,"Virat Kohli ","Ram Nagar"));
		empList.add(new Employee(3,"Virat Kohli ","Ram Nagar"));
		assertTrue(object.addEmployees(empList.get(0)));
		assertTrue(object.addEmployees(empList.get(1)));
		assertFalse(object.addEmployees(empList.get(2)));
	}

	
	@Test
	public void testFindUniqueCharacter()
	{
		StringCharacter object=new StringCharacter();
		assertEquals(5,object.findUniqueCharacter("varun"));
		assertEquals(3,object.findUniqueCharacter("aaabbbc"));
		assertEquals(5,object.findUniqueCharacter("varun"));//Caches by printing
	}
	
	@Test
	public void teatCalculateMass1()
	{OrganicCompoundMass object=new OrganicCompoundMass();
	assertEquals(270,object.calculateMass("C6H6O12"));
		
	}
	@Test
	public void teatCalculateMass2()
	{OrganicCompoundMass object=new OrganicCompoundMass();
	assertEquals(286,object.calculateMass("(CH)22"));
		
	}
	@Test
	public void teatCalculateMass3()
	{OrganicCompoundMass object=new OrganicCompoundMass();
	assertEquals(193,object.calculateMass("CH3(COOH)3OH(CH)2"));
		
	}
	@Test
	public void teatCalculateMass4()
	{OrganicCompoundMass object=new OrganicCompoundMass();
	assertEquals(645,object.calculateMass("CH3(CO6H)3OH(CH)22"));
		
	}
	@Test
	public void teatCalculateMass5()
	{OrganicCompoundMass object=new OrganicCompoundMass();
	assertEquals(465,object.calculateMass("CH3(CO2H)10"));
		
	}
	
	
}

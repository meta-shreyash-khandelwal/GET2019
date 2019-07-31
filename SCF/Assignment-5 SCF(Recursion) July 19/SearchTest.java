import static org.junit.Assert.*;
import java.util.*;
import java.util.Arrays;
import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
@RunWith(Parameterized.class)
public class SearchTest {
private int inputArray[];
private int item;
private int expected;
private Search object;
public SearchTest(int inputArray[],int item,int expected)
{
	this.inputArray=inputArray;
	this.item=item;
	this.expected=expected;
}
@Before
public void initialize()
{
	object=new Search();
}
@Parameterized.Parameters
public static Collection binarySearch()
{
	return Arrays.asList(new Object[][]{
			{new int[]{1,2,3,4,5},3,2},
			{new int[]{6,8,12,19,20,40,50,89},40,5},
			{new int[]{10,25,32,49,95},10,0},
			{new int[]{12,28,42,56,80},80,4}
			
	});
}
@Test
public void testbinarySerach()
{
	assertEquals(expected,object.binarySearch(inputArray, item));
}
@Test
public void testLinearSerach()
{
	assertEquals(expected,object.linearSearch(inputArray, item));
}	
}

import static org.junit.Assert.*;
import java.util.*;
import java.util.Arrays;
import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
@RunWith(Parameterized.class)
public class LCMTest {
private int numberFirst;
private int numberSecond;
private int expected;
private HCFAndLCM object;
public LCMTest(int numberFirst,int numberSecond,int expected)
{
	this.numberFirst=numberFirst;
	this.numberSecond=numberSecond;
	this.expected=expected;
}
@Before
public void initialize()
{
	object=new HCFAndLCM();
}
@Parameterized.Parameters
public static Collection binarySearch()
{
	return Arrays.asList(new Object[][]{
			{18,24,72},
			{3,6,6},
			{10,15,30},
			{25,40,200}
			
	});
}
@Test
public void hcfOfTwoNumbertest1() {
assertEquals(expected,object.lcmOfTwoNumber(numberFirst, numberSecond));	
}
}

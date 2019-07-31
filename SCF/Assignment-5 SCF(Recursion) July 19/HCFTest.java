package varunk;
import static org.junit.Assert.*;
import java.util.*;
import java.util.Arrays;
import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class HCFTest {
	private int numberFirst;
	private int numberSecond;
	private int expected;
	private HCFAndLCM object;

	public HCFTest(int numberFirst, int numberSecond, int expected) {
		this.numberFirst = numberFirst;
		this.numberSecond = numberSecond;
		this.expected = expected;
	}

	@Before
	public void initialize() {
		object = new HCFAndLCM();
	}

	@Parameterized.Parameters
	public static Collection binarySearch() {
		return Arrays.asList(new Object[][] { { 2, 4, 2 }, { 35, 10, 5 },
				{ 4, 9, 1 }, { 49, 14, 7 }

		});
	}
	@Test
	public void hcfOfTwoNumbertest1() {
		assertEquals(expected, object.hcfOfTwoNumber(numberFirst, numberSecond));
	}
}

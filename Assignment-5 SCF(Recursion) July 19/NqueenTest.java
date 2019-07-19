package varunk;
import static org.junit.Assert.*;
import org.junit.Test;
public class NqueenTest {

	@Test
	public void test() {
		int board[][]=new int[4][4];
		assertEquals(true,NQueen.nQueen(board,0,4));
		
		fail("Not yet implemented");
	}

}

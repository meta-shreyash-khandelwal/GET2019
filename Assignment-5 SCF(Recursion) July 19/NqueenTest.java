import static org.junit.Assert.*;
import org.junit.Test;
public class NqueenTest {

	@Test
	public void testNqueen1() {
		int board[][] = new int[4][4];
		assertTrue(NQueen.nQueenCheck(board, 0, 4));
	}

	@Test
	public void testNqueen2(){
		int board[][] = new int[8][8];
		assertTrue(NQueen.nQueenCheck(board, 0, 8));
	}

	@Test
	public void testNqueen3(){
			int board[][] = new int[3][3];
		System.out.println("Return Value is" + NQueen.nQueenCheck(board, 0, 3));
		assertFalse(NQueen.nQueenCheck(board, 0, 3));
	}

	@Test
	public void testNqueen4(){
			int board[][] = new int[2][2];
		System.out.println("Return value is " + NQueen.nQueenCheck(board, 0, 2));
		assertFalse(NQueen.nQueenCheck(board, 0, 2));
	}
	
}

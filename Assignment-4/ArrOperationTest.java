package varunk;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
public class ArrOperationTest {
	@Test
	public void testLargestMirror1() {
		int arrayCheck[]=new int[]{1, 2, 3, 8, 9, 3, 2, 1};
		int k=ArrOperation.largestMirror(arrayCheck, arrayCheck.length);
		assertEquals(3,k);
	}
	@Test
	public void testLargestMirror2() {
		int arrayCheck[]=new int[]{7, 1, 4, 9, 7, 4, 1};
		int k=ArrOperation.largestMirror(arrayCheck, arrayCheck.length);
		assertEquals(2,k);
	}	@Test
	public void testLargestMirror3() {
		
		int arrayCheck[]=new int[]{1, 2, 1, 4};
		int k=ArrOperation.largestMirror(arrayCheck, arrayCheck.length);
		assertEquals(3,k);
	}	
	@Test
	public void testLargestMirror4() {
		int arrayCheck[]=new int[]{1, 4, 5, 3, 5, 4, 1};
		int k=ArrOperation.largestMirror(arrayCheck, arrayCheck.length);
		assertEquals(7,k);
	}
	
	@Test
	public void testLargestMirrornoOfClumps1() {
		int arrayCheck[]=new int[]{1, 1, 2, 1, 1};
		int k=ArrOperation.numberOfClumps(arrayCheck);
		assertEquals(2,k);
	}
	@Test
	public void testLargestMirrornoOfClumps2() {
		int arrayCheck[]=new int[]{1,1,1, 1, 2, 2,3,4,4,6,6};
		int k=ArrOperation.numberOfClumps(arrayCheck);
		assertEquals(4,k);
	}
	@Test
	public void testLargestMirrornoOfClumps3() {
		int arrayCheck[]=new int[]{1, 1, 1, 1};
		int k=ArrOperation.numberOfClumps(arrayCheck);
		assertEquals(1,k);
	}
	
	@Test
	public void fixXY1() {
		int arrayCheck[]=new int[]{5, 4, 9, 4, 9, 5};
		int arrayExpected[]=new int[]{9, 4, 5, 4, 5, 9};
		int X=4;
		int Y=5;
		assertArrayEquals(arrayExpected,ArrOperation.fixXY(arrayCheck, X, Y));
	}
	@Test
	public void fixXY2() {
		int arrayCheck[]=new int[]{1,4,1,5};
		int arrayExpected[]=new int[]{1, 4, 5, 1};
		int X=4;
		int Y=5;
		assertArrayEquals(arrayExpected,ArrOperation.fixXY(arrayCheck, X, Y));
	}
	
	@Test
	public void testSplitArray1() {
		int arrayCheck[]=new int[]{1,1,1,2,1};
		int k=ArrOperation.indexOfSplit(arrayCheck);
		assertEquals(3,k);
	}
	
	@Test
	public void testSplitArray2() {
		int arrayCheck[]=new int[]{2,1,3,1,2,3};
		int k=ArrOperation.indexOfSplit(arrayCheck);
		assertEquals(3,k);
	}
	@Test
	public void testSplitArray3() {
		int arrayCheck[]=new int[]{2,1,1,2,1};
		int k=ArrOperation.indexOfSplit(arrayCheck);
		assertEquals(-1,k);
	}
	@Test
	public void testSplitArray4() {
		int arrayCheck[]=new int[]{10,10};
		int k=ArrOperation.indexOfSplit(arrayCheck);
		assertEquals(1,k);
	}
	@Test
	public void testSplitArray5() {
		int arrayCheck[]=new int[]{7,1,1,2,1};
		int k=ArrOperation.indexOfSplit(arrayCheck);
		assertEquals(-1,k);
	}
	
	@Test(expected = AssertionError.class)
	public void whenExceptionThrownClumps() {
	    int blank[]={};
		ArrOperation.numberOfClumps(blank);	
	}
	
	@Test(expected = AssertionError.class)
	public void whenExceptionThrownLargestMirror() {
	    int blank[]={};
		ArrOperation.largestMirror(blank,blank.length);	
	}
	
	@Test(expected = AssertionError.class)
	public void whenExceptionFixXY() {
	    int blank[]={};
		ArrOperation.fixXY(blank,4,5);	
	}
	
	@Test(expected = AssertionError.class)
	public void fixXY1CheckExceptionLast() {
		int arrayCheck[]=new int[]{5, 4, 9, 4, 9, 5,4};
		//int arrayExpected[]=new int[]{9, 4, 5, 4, 5, 9};
		int X=4;
		int Y=5;
		ArrOperation.fixXY(arrayCheck,4,5);	
		}
	public void fixXY2CheckExceptionUnequal() {
		int arrayCheck[]=new int[]{4,5, 4, 9, 4, 9, 5};
		//int arrayExpected[]=new int[]{9, 4, 5, 4, 5, 9};
		int X=4;
		int Y=5;
		ArrOperation.fixXY(arrayCheck,4,5);	
		}
	

	
	}
	

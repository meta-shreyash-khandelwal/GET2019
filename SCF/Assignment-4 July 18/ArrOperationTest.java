package varunk;
import static org.junit.Assert.*;
import org.junit.Test;
public class ArrOperationTest {
	@Test
	public void testLargestMirror1() {
		ArrOperation object=new ArrOperation();
		int arrayCheck[]=new int[]{1, 2, 3, 8, 9, 3, 2, 1};
		assertEquals(3,object.largestMirror(arrayCheck, arrayCheck.length));
	}
	@Test
	public void testLargestMirror2() {
		ArrOperation object=new ArrOperation();
		int arrayCheck[]=new int[]{7, 1, 4, 9, 7, 4, 1};
		assertEquals(2,object.largestMirror(arrayCheck, arrayCheck.length));
	}	
	@Test
	public void testLargestMirror3() {
		ArrOperation object=new ArrOperation();
		int arrayCheck[]=new int[]{1, 2, 1, 4};
		assertEquals(3,object.largestMirror(arrayCheck, arrayCheck.length));
	}	
	@Test
	public void testLargestMirror4() {
		ArrOperation object=new ArrOperation();
		int arrayCheck[]=new int[]{1, 4, 5, 3, 5, 4, 1};
		assertEquals(7,object.largestMirror(arrayCheck, arrayCheck.length));;
	}
	
	@Test
	public void testLargestMirrornoOfClumps1() {
		ArrOperation object=new ArrOperation();
		int arrayCheck[]=new int[]{1, 1, 2, 1, 1};
		assertEquals(2,object.numberOfClumps(arrayCheck));
	}
	@Test
	public void testLargestMirrornoOfClumps2() {
		ArrOperation object=new ArrOperation();
		int arrayCheck[]=new int[]{1,1,1, 1, 2, 2,3,4,4,6,6};
		assertEquals(4,object.numberOfClumps(arrayCheck));
	}
	@Test
	public void testLargestMirrornoOfClumps3() {
		ArrOperation object=new ArrOperation();
		int arrayCheck[]=new int[]{1, 1, 1, 1};
		assertEquals(1,object.numberOfClumps(arrayCheck));
	}
	@Test
	public void arrangeXYTest1() {
		ArrOperation object=new ArrOperation();
		int arrayCheck[]=new int[]{5, 4, 9, 4, 9, 5};
		int arrayExpected[]=new int[]{9, 4, 5, 4, 5, 9};
		int ElementX=4;
		int ElementY=5;
		assertArrayEquals(arrayExpected,object.arrangeXY(arrayCheck, ElementX, ElementY));
	}
	@Test
	public void arrangeXYTest2() {
		ArrOperation object=new ArrOperation();
		int arrayCheck[]=new int[]{1,4,1,5};
		int arrayExpected[]=new int[]{1, 4, 5, 1};
		int ElementX=4;
		int ElementY=5;
		assertArrayEquals(arrayExpected,object.arrangeXY(arrayCheck, ElementX, ElementY));
	}
	
	@Test
	public void testSplitArray1() {
		ArrOperation object=new ArrOperation();
		int arrayCheck[]=new int[]{1,1,1,2,1};
		assertEquals(3,object.indexOfSplit(arrayCheck));
	}
	
	@Test
	public void testSplitArray2() {
		ArrOperation object=new ArrOperation();
		int arrayCheck[]=new int[]{2,1,3,1,2,3};
		assertEquals(3,object.indexOfSplit(arrayCheck));
	}
	@Test
	public void testSplitArray3() {
		ArrOperation object=new ArrOperation();
		int arrayCheck[]=new int[]{2,1,1,2,1};
		assertEquals(-1,object.indexOfSplit(arrayCheck));
	}
	@Test
	public void testSplitArray4() {
		ArrOperation object=new ArrOperation();
		int arrayCheck[]=new int[]{10,10};
		assertEquals(1,object.indexOfSplit(arrayCheck));
	}
	@Test
	public void testSplitArray5() {
		ArrOperation object=new ArrOperation();
		int arrayCheck[]=new int[]{7,1,1,2,1};
		assertEquals(-1,object.indexOfSplit(arrayCheck));
	}
	
	@Test(expected = AssertionError.class)
	public void whenExceptionThrownClumps() {
		ArrOperation object=new ArrOperation();
	    int blank[]={};
	    object.numberOfClumps(blank);	
	}
	@Test(expected = AssertionError.class)
	public void whenExceptionThrowninMirror() {
		ArrOperation object=new ArrOperation();
	    int blank[]={};
	    object.largestMirror(blank,0);	
	}
	@Test(expected = AssertionError.class)
	public void whenExceptionFixXY() {
		ArrOperation object=new ArrOperation();
	    int blank[]={};
	    object.arrangeXY(blank,4,5);	
	}
	@Test(expected = AssertionError.class)
	public void fixXY1CheckExceptionLast() {
		ArrOperation object=new ArrOperation();
		int arrayCheck[]=new int[]{5, 4, 9, 4, 9, 5,4};
		int ElementX=4;
		int ElementY=5;
		object.arrangeXY(arrayCheck,ElementX,ElementY);	
		}
	@Test(expected = AssertionError.class)
		public void fixXY2CheckExceptionUnequal() {
		ArrOperation object=new ArrOperation();
		int arrayCheck[]=new int[]{4,5, 4, 9, 4, 9, 5};
		int ElementX=4;
		int ElementY=5;
		object.arrangeXY(arrayCheck,ElementX,ElementY);	
		}
		}
	

import static org.junit.Assert.*;
import org.junit.Test;
public class SparseMatrixTest {
    @Test
	public void testTransposeArrayOpertionShouldReturn_TransposeWhenInput_SparseMatrix() {
	 int sparseMatrix[][]=new int[][]{{0,3,1},{1,1,5},{2,2,3},{3,0,9},{3,4,10}};
	 int transposeMatrix[][]=new int[][]{{0,3,9},{1,1,5},{2,2,3},{3,0,1},{4,3,10}};
		assertArrayEquals(transposeMatrix,SparseMatrix.transposeArrayOpertion(sparseMatrix));
	}
	@Test
	public void testSymmetricArrayOperationShouldReturn_TrueWhenInput_SparseMatrix1() {
	 int sparseMatrix[][] = new int[][] { { 0, 0, 4 }, { 0, 1, 1 }, { 0, 2, 2 },
				{ 0, 3, 5 }, { 0, 4, 2 }, { 1, 0, 1 }, { 1, 1, 5 },
				{ 2, 0, 2 }, { 2, 2, 3 }, { 3, 0, 5 }, { 3, 3, 6 },
				{ 4, 0, 2 }, { 4, 4, 16 } };
		assertTrue(SparseMatrix.symmetricArrayOperation(sparseMatrix));
	}
	@Test
	public void testSymmetricArrayOperationShouldReturn_TrueWhenInput_SparseMatrix2() {
	 int sparseMatrix[][] = new int[][] { { 1, 0, 4 }, { 0, 1, 1 }, { 0, 2, 2 },
				{ 0, 3, 5 }, { 0, 4, 2 }, { 1, 0, 1 }, { 1, 1, 5 },
				{ 2, 0, 2 }, { 2, 2, 3 }, { 3, 0, 5 }, { 3, 3, 6 },
				{ 4, 0, 2 }, { 4, 4, 16 } };
		assertFalse(SparseMatrix.symmetricArrayOperation(sparseMatrix));
	}
	@Test
	public void testAdditionArrayOperationShouldReturn_AdditionWhenInput_SparseMatrix1_And_SparseMatrix2()
	{
		int sparseMatrix1[][] = new int[][] { { 1, 2, 3 }, { 2, 1, 4 }, { 3, 4, 3 } };
		int sparseMatrix2[][] = new int[][] { { 0, 3, 4 }, { 1, 2, 5 }, { 1, 3, 1 },
				{ 2, 4, 3 }, { 3, 1, 1 }};
		int sparseMatrix3[][]=new int[][]{{0,3,4},{0,0,0},{1,2,8},{1,3,1},{2,1,4},{2,4,3},{3,4,3},{3,1,1}};
		assertArrayEquals(sparseMatrix3,SparseMatrix.addMatrices(sparseMatrix1, sparseMatrix2));
}
	@Test
	public void testMultiplicationArrayOperationShouldReturn_MultiplicationWhenInput_SparseMatrix1_And_SparseMatrix2()
	{
		int sparseMatrix1[][] = new int[][] { { 0, 0, 0, 1, 0 }, { 3, 0, 0, 0, 0 },
				{ 0, 0, 2, 0, 0 }, { 0, 0, 0, 0, 9 } };
		int sparseMatrix2[][] = new int[][] { { 0, 6, 0, 0 }, { 0, 0, 0, 7 },
				{ 1, 0, 0, 0 }, { 0, 0, 2, 0 }, { 0, 8, 0, 0 } };
		int sparseMatrix3[][]=new int[][]{{0,2,2},{1,1,18},{2,0,2},{3,1,72}};
		assertArrayEquals(sparseMatrix3,SparseMatrix.multiplyMatrices(sparseMatrix1, sparseMatrix2));
	}
}

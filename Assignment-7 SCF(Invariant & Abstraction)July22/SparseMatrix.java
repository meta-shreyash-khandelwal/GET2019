import java.util.Arrays;
final public class SparseMatrix {
/**
 * This method sorts the two Sparse matrix 
 * @param inputSparseMatrix is the matrix containing the sparse matrix
 * @return the 2-Dimensional array containing sorted array
 */
	private static int[][] sortTransposeMatrix(int inputSparseMatrix[][]) {// The worst case complexity is O(n^2) (bubble sort)
		int temporaryNumber1 = 0, temporaryNumber2 = 0, temporaryNumber3 = 0;
		for (int i = 0; i < inputSparseMatrix.length; i++) {
			for (int j = 0; j < inputSparseMatrix.length - i - 1; j++) {
				if (inputSparseMatrix[j][0] > inputSparseMatrix[j + 1][0]) {
					temporaryNumber1 = inputSparseMatrix[j][0];
					temporaryNumber2 = inputSparseMatrix[j][1];
					temporaryNumber3 = inputSparseMatrix[j][2];
					inputSparseMatrix[j][0] = inputSparseMatrix[j + 1][0];
					inputSparseMatrix[j][1] = inputSparseMatrix[j + 1][1];
					inputSparseMatrix[j][2] = inputSparseMatrix[j + 1][2];
					inputSparseMatrix[j + 1][0] = temporaryNumber1;
					inputSparseMatrix[j + 1][1] = temporaryNumber2;
					inputSparseMatrix[j + 1][2] = temporaryNumber3;
				}
			}
		}
		return inputSparseMatrix;
	}
/**
 * This method calculates the transpose of matrix
 * @param inputSparseArray is the 2D array containing the sparse matrix 
 * @return the 2-Dimensional array containing the transpose of matrix
 */
	public static int[][] transposeArrayOpertion(int inputSparseArray[][]) {//The worst case complexity is O(n) 
		try{
			if(inputSparseArray.length == 0)
			{
				throw new Exception("Empty array");
			}
			}
			catch(Exception e)
			{
				System.out.println("Empty array ");
			}
		int transposeArray[][] = new int[inputSparseArray.length][3];
		int column = 0;
		for (int i = 0; i < inputSparseArray.length; i++) {
			transposeArray[i][column] = inputSparseArray[i][column + 1];
			transposeArray[i][column + 1] = inputSparseArray[i][column];
			transposeArray[i][column + 2] = inputSparseArray[i][column + 2];
		}
		transposeArray = sortTransposeMatrix(transposeArray);
		return transposeArray;
	}
/**
 * This method checks whether sparse array is symmetric or not
 * @param inputSparseArray is the 2D array containing the sparse matrix 
 * @return true if sparse array is symmetric otherwise returns false
 */
	public static boolean symmetricArrayOperation(int inputSparseArray[][]) {//The worst case complexity is O(n^2) 
		int symmetricTransposeArray[][] = new int[inputSparseArray.length][3];
		symmetricTransposeArray = transposeArrayOpertion(inputSparseArray);
		return Arrays.deepEquals(inputSparseArray, symmetricTransposeArray);

	}
/**
 * This method performs the addition of two matrices
 * @param inputSparseArrayFirst is the 2D array containing first Sparse matrix
 * @param inputSparseArraySecond  is the 2D array containing first Sparse matrix
 * @return the 2d array containing addition of matrices in sparse matrix representation
 */
	public static int[][] addMatrices(int inputSparseArrayFirst[][],  //The worst case complexity is O(n^2) 
			int inputSparseArraySecond[][]) {
		try{
		if(inputSparseArrayFirst.length==0 || inputSparseArraySecond.length == 0)
		{
			throw new Exception("Empty");
		}
		}
		catch(Exception e)
		{
			System.out.println("Empty");
		}
		int rowNumber = 0, columnNumber = 0, value = 0;
		int counter = 0;//counter value
		int startRow = 0, startColumn = 0;
		int resultAdd[][] = new int[inputSparseArrayFirst.length
				+ inputSparseArraySecond.length][3];
			for (int i = 0; i < inputSparseArrayFirst.length; i++) {
			rowNumber = inputSparseArrayFirst[i][0];
			columnNumber = inputSparseArrayFirst[i][1];
			value = inputSparseArrayFirst[i][2];
			counter = 0;
			for (int j = 0; j < inputSparseArraySecond.length; j++) {
				if ((inputSparseArraySecond[j][0] == rowNumber)
						&& (inputSparseArraySecond[j][1] == columnNumber)) {
					counter = 1;
					resultAdd[startRow][0] = rowNumber;
					resultAdd[startRow][1] = columnNumber;
					resultAdd[startRow][2] = value
							+ inputSparseArraySecond[j][2];
					startRow++;
				}
			}
		if (counter == 0) {
			resultAdd[startRow][0] = inputSparseArrayFirst[i][0];
				resultAdd[startRow][1] = inputSparseArrayFirst[i][1];
				resultAdd[startRow][2] = inputSparseArrayFirst[i][2];
				startRow++;
			}
		}
			counter=0;
		for (int i = 0; i < inputSparseArraySecond.length; i++) {
			rowNumber = inputSparseArraySecond[i][0];
			columnNumber = inputSparseArraySecond[i][1];
			value = inputSparseArraySecond[i][2];
			counter = 0;
		    for (int j = 0; j < inputSparseArrayFirst.length; j++) {
				if ((inputSparseArrayFirst[j][0] == rowNumber)
						&& (inputSparseArrayFirst[j][1] == columnNumber)) {
					counter = 1;

				}
			}
			if (counter == 0) {
				resultAdd[startRow][0] = inputSparseArraySecond[i][0];
				resultAdd[startRow][1] = inputSparseArraySecond[i][1];
				resultAdd[startRow][2] = inputSparseArraySecond[i][2];
				startRow++;
			}
		}
		resultAdd=sortTransposeMatrix(resultAdd);
		return resultAdd;
	}
	/**
	 * This method performs the multiplication of two matrices
	 * @param inputSparseArrayFirst is the 2D array containing first Sparse matrix
	 * @param inputSparseArraySecond  is the 2D array containing first Sparse matrix
	 * @return the 2d array containing multiplication of matrices in sparse matrix representation
	 */
		
	public static int[][] multiplyMatrices(int inputSparseArrayFirst[][], //The worst case complexity is O(n^3) 
			int inputSparseArraySecond[][]) {
		int rowNumber = 0, columnNumber = 0, value = 0;
		int startRow = 0, startColumn = 0;
		int resultMultiply[][] = new int[inputSparseArrayFirst.length][inputSparseArraySecond[0].length];
		if (inputSparseArrayFirst[0].length != inputSparseArraySecond.length) {
			try {
				throw new Exception("Not possible due to unequal length");
			} catch (Exception e) {
				System.out.println("NOT POSSIBLE Incompatible matrices");
			}
		} else {
			value = 1;
					for (int i = 0; i < inputSparseArrayFirst.length; i++) {
				for (int j = 0; j < inputSparseArraySecond[0].length; j++) {

					for (int k = 0; k < inputSparseArraySecond.length; k++) {

						resultMultiply[i][j] += inputSparseArrayFirst[i][k]
								* inputSparseArraySecond[k][j];
					}
				}
			}
		}

		int row = 0;
		int column = 0;
		int countElement = 0;
		for (int i = 0; i < resultMultiply.length; i++) {
			for (int j = 0; j < resultMultiply[i].length; j++) {
				if (resultMultiply[i][j] != 0) {
					countElement++;
				}
			}
		}

		int sparseArray[][] = new int[countElement][3];
		for (int i = 0; i < resultMultiply.length; i++) {
			for (int j = 0; j < resultMultiply[i].length; j++) {
				if (resultMultiply[i][j] != 0) {
					sparseArray[row][column] = i;
					sparseArray[row][column + 1] = j;
					sparseArray[row][column + 2] = resultMultiply[i][j];
					row++;

				}
			}
		}
		return sparseArray;

	}
/*
	public static void main(String[] args) {
		SparseMatrix s = new SparseMatrix();

		int td1[][] = new int[][] { { 1, 2, 3 }, { 2, 1, 4 }, { 3, 4, 3 } };
		int td2[][] = new int[][] { { 0, 2, 4 }, { 1, 2, 5 }, { 1, 3, 1 },
				{ 2, 3, 3 }, { 3, 1, 1 } };
		int td3[][] = new int[][] { { 0, 0, 4 }, { 0, 1, 1 }, { 0, 2, 2 },
				{ 0, 3, 5 }, { 0, 4, 2 }, { 1, 0, 1 }, { 1, 1, 5 },
				{ 2, 0, 2 }, { 2, 2, 3 }, { 3, 0, 5 }, { 3, 3, 6 },
				{ 4, 0, 2 }, { 4, 4, 16 } };

		int td4[][] = new int[][] { { 0, 3, 4 }, { 0, 4, 10 }, { 1, 2, 5 },
				{ 1, 3, 1 }, { 2, 4, 3 }, { 3, 1, 1 }, { 2, 0, 15 } };
		int td5[][] = new int[][] { { 0, 4, 9 }, { 1, 1, 8 }, { 2, 0, 4 },
				{ 2, 3, 2 }, { 3, 1, 2 }, { 3, 4, 5 } };

		int td6[][] = new int[12][3];

		int td7[][] = new int[][] { { 0, 0, 0, 1, 0 }, { 3, 0, 0, 0, 0 },
				{ 0, 0, 2, 0, 0 }, { 0, 0, 0, 0, 9 } };

		int td8[][] = new int[][] { { 0, 6, 0, 0 }, { 0, 0, 0, 7 },
				{ 1, 0, 0, 0 }, { 0, 0, 2, 0 }, { 0, 8, 0, 0 } };
		int td9[][] = new int[td7.length][td8[0].length];
		int td10[][] = new int[td1.length][3];

		// td6=addMatrices(td4,td5);
		td9 = multiplyMatrices(td7, td8);

		System.out.println("Symmetric Array "+symmetricArrayOperation(td3));
		td10=addMatrices(td1,td2);
		System.out.println("Addition Array ");
		
		for (int i = 0; i < td10.length; i++) {
			for (int j = 0; j < td10[i].length; j++) {
				System.out.print(td10[i][j] + " ");
			}
			System.out.println();
		}

		
		
		// int siz=countElementSparse(td);
		// int tdd[][]=new int[siz][3];
		// tdd=representSparseMatrix(td);
		// int tdd1[][]=new int[3][siz];
		// tdd1=transposeArrayOpertion(tdd);
		// int td3[][]=new int[td2.length][3];
		// td3=transposeArrayOpertion(td3);
		System.out.println("Multiply ");
		for (int i = 0; i < td9.length; i++) {
			for (int j = 0; j < td9[i].length; j++) {
				System.out.print(td9[i][j] + " ");
			}
			System.out.println();
		}

		// System.out.println(symmetricArrayOperation(td3));
	}*/
}

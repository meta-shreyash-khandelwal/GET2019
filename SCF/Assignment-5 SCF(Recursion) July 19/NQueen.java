/*This class helps in finding the solutions for the N Queen problem*/
class NQueen {
	private static int check = 0;//Checking the possible solutions exists or not
	/**
	 * This method helps in printing solutions which exists for the N Queen where (1-Queen present 0-Queen Not present) 
	 * @param board is the 2D array which is passed 
	 * @param dimension is the Number of Queen
	 */
	private static void printSolution(int board[][], int dimension) {
		try{
			if(board.length == 0 || board == null)
			{
				throw new Exception("Empty Array");
			}
			}
			catch(Exception e)
			{
				System.out.println("Empty Array passed");
			}
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
		System.out.println("");
	}
	/**
	 * This method checks if there is a safe place which exists in the board or not
	 * @param board is the 2D array
	 * @param row is the row in column
	 * @param column is column value in 2D array
	 * @param dimension is the Number of Queen (NQueen
	 * @return the boolean true is there is safe place otherwise returns false
	 */
	private static boolean isSafePlace(int board[][], int row, int column,
			int dimension) {
		try{
			if(board.length == 0 || board == null)
			{
				throw new Exception("Empty Array");
			}
			}
			catch(Exception e)
			{
				System.out.println("Empty Array passed");
			}
		/* Checking row on left side of board */
		for (int i = 0; i < column; i++)
			if (board[row][i] == 1)
				return false;
		/* Checking upper diagonal on left side */
		for (int i = row, j = column; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;
		/* Checking lower diagonal on left side */
		for (int i = row, j = column; j >= 0 && i < dimension; i++, j--)
			if (board[i][j] == 1)
				return false;
		return true; /*If all the cases fail then return true indicating safe place */
	}
	/**
	 * This is the method for implementing the NQueen problem using recursion
	 * @param board is the 2D array
	 * @param startingColumn is the beginning column value
	 * @param dimension is the number of Queen
	 * @return boolean true if solution exists otherwise returns the boolean false
	 */
	private static boolean nQueen(int board[][], int startingColumn,
			int dimension) {
		// base case
		try{
			if(board.length == 0 || board == null)
			{
				throw new Exception("Empty Array");
			}
			}
			catch(Exception e)
			{
				System.out.println("Empty Array passed");
			}
		if (startingColumn == dimension) {
			printSolution(board, dimension);
			check++;
			return true;
		}
		/*Consider this column and try placing this queen in all rows one by one*/
		boolean result = false;
		for (int i = 0; i < dimension; i++) {
			if (isSafePlace(board, i, startingColumn, dimension)) {// Checking safe place for queen
				board[i][startingColumn] = 1;
				result = nQueen(board, startingColumn + 1, dimension); // Recursive call
				board[i][startingColumn] = 0;// If no solution exists, then remove queen by backtracking
			}
		}
		// If queen can not be place in any row in this column then return false
		return result;
	}
    /**
     * This method is used for checking N queen exists for any value N or not
     * @param board  is the 2D array
     * @param startingRow is the beginning row value
     * @param dimension is the 2D value of array or number of Queen
     * @return boolean true if solution exists otherwise returns the boolean false 
     */
	public static boolean nQueenCheck(int board[][], int startingRow,
			int dimension) {
		try{
		if(board.length == 0 || board == null)
		{
			throw new Exception("Empty Array");
		}
		}
		catch(Exception e)
		{
			System.out.println("Empty Array passed");
		}
		if (nQueen(board, startingRow, dimension) == false && check == 0) {
			return false;
		} else {
			check = 0;
			return true;
		}
	}
/*
	public static void main(String[] args) {
		int board[][] = new int[3][3];
		if (nQueen(board, 0, 3) == false && check == 0) {
			System.out.println("Solution does not exist");
			// return ;
		}
		System.out.println("Return value  " + nQueenCheck(board, 0, 3));
	}
*/
}

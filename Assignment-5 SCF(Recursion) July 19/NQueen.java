package varunk;
class NQueen   
{ 
static int N = 4;  
static int k = 1; 
/*
static void printSolution(int board[][])  
{  
    System.out.printf("%d-\n", k++);  
    for (int i = 0; i < N; i++)  
    {  
        for (int j = 0; j < N; j++)  
            System.out.printf(" %d ", board[i][j]);  
        System.out.printf("\n");  
    }  
    System.out.printf("\n");  
} 
*/ 
/* A utility function to check if a queen can  
be placed on board[row][col]. Note that this  
function is called when "col" queens are  
already placed in columns from 0 to col -1.  
So we need to check only left side for  
attacking queens */
public static boolean isSafePlace(int board[][], int row, int column)  
{  
    int i, j;  
    /* Check this row on left side of board*/
    for (i = 0; i < column; i++)  
        if (board[row][i] == 1)  
            return false;  
    /* Check upper diagonal on left side */
    for (i = row, j = column; i >= 0 && j >= 0; i--, j--)  
        if (board[i][j] == 1)  
            return false;  
    /* Check lower diagonal on left side */
    for (i = row, j = column; j >= 0 && i < N; i++, j--)  
        if (board[i][j] == 1)  
            return false;  
  
    return true;  /*If all the cases fail then return true indicating safe place*/
}  
  
/* A recursive utility function  
to solve N Queen problem */
public static boolean nQueen(int board[][], int startingColumn,int dimension)  
{  
    /* base case: If all queens are placed  
    then return true */
    if (startingColumn == dimension)  
    {  
        //printSolution(board);  
        return true;  
    }  
  
    /* Consider this column and try placing  
    this queen in all rows one by one */
    boolean result = false;  
    for (int i = 0; i < dimension; i++)  
    {  
        /* Check if queen can be placed on board[i][startingColumn] */
        if ( isSafePlace(board, i, startingColumn) )  
        {  
            board[i][startingColumn] = 1;  
            // Make result true if any placement recursive call  
            result = nQueen(board, startingColumn + 1,4);  
            /* If placing queen in board[i][column] doesn't lead to a solution, then remove queen
            board[i][startingColumn] = 0; */ //BACKTRACK  
        }  
    }  
     // If queen can not be place in any row in this column then return false 
    return result;  
}  
  
/* This function solves the N Queen problem using  
Backtracking. It mainly uses solveNQUtil() to  
solve the problem. It returns false if queens  
cannot be placed, otherwise return true and  
prints placement of queens in the form of 1s.  
Please note that there may be more than one  
solutions, this function prints one of the  
feasible solutions.*/
/*
static void solveNQ()  
{  
    int board[][] = new int[N][N];  
  
    if (solveNQUtil(board, 0,4) == false)  
    {  
        System.out.printf("Solution does not exist");  
        return ;  
    }  
  
    return ;  
}  
  
// Driver code  
public static void main(String[] args) 
{ 
    solveNQ(); 
} */
} 
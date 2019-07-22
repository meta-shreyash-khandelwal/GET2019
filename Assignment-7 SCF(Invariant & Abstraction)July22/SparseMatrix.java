package varunk;

import java.util.Arrays;

public class SparseMatrix {
	int row=0;
	int column=0;
	/*
	public static int countElementSparse(int inputArray[][])
	{
		int countElement=0;
		for(int i=0;i<inputArray.length;i++)
		{
			for(int j=0;j<inputArray[i].length;j++)
			{
				if(inputArray[i][j]!=0)
				{
					countElement++;
				}
			}
		}
		
		return countElement;
	}
	public static  int[][] representSparseMatrix(int inputArray[][])
	{
		int countElement=countElementSparse(inputArray);
	int sparseArray[][]=new int[countElement][3];
int row=0;
int column=0;
	for(int i=0;i<inputArray.length;i++)
	{
		for(int j=0;j<inputArray[i].length;j++)
		{
			if(inputArray[i][j]!=0)
			{
				sparseArray[row][column]=i;
				sparseArray[row][column+1]=j;
				sparseArray[row][column+2]=inputArray[i][j];
				row++;
				
			}
		}
	}
	return sparseArray;
	}
	*/
	public static int[][] sortTransposeMatrix(int inputSparseMatrix[][])
	{
		int temporary1=0,temporary2=0,temporary3=0;
		for(int i=0;i<inputSparseMatrix.length;i++)
		{
			for(int j=0;j<inputSparseMatrix.length-i-1;j++)
			{
				if(inputSparseMatrix[j][0]>inputSparseMatrix[j+1][0])
				{
					temporary1=inputSparseMatrix[j][0];
					temporary2=inputSparseMatrix[j][1];
					temporary3=inputSparseMatrix[j][2];
					inputSparseMatrix[j][0]=inputSparseMatrix[j+1][0];
					inputSparseMatrix[j][1]=inputSparseMatrix[j+1][1];
					inputSparseMatrix[j][2]=inputSparseMatrix[j+1][2];
					inputSparseMatrix[j+1][0]=temporary1;
					inputSparseMatrix[j+1][1]=temporary2;
					inputSparseMatrix[j+1][2]=temporary3;
					
					
				}
				
			}
			
			
		}
		return inputSparseMatrix;
		
	}
	
	
	public static  int[][] transposeArrayOpertion(int inputSparseArray[][])
	{
		int transposeArray[][]=new int[inputSparseArray.length][3];
		int column=0;
		//System.out.println("TDD Length"+inputSparseArray.length+ " ");
		//System.out.println("TDD "+inputSparseArray[j][i]+ " ");
		for(int i=0;i<inputSparseArray.length;i++)
		{
			transposeArray[i][column]=inputSparseArray[i][column+1];
					transposeArray[i][column+1]=inputSparseArray[i][column];
							transposeArray[i][column+2]=inputSparseArray[i][column+2];
			//System.out.print("TDD "+inputSparseArray[j][i]+ " ");
	     }
		transposeArray=sortTransposeMatrix(transposeArray);
		return transposeArray;
	}
	
	
	
	
	
	
	
	
	public static  boolean symmetricArrayOperation(int inputSparseArray[][])
	{
		int symmetricTransposeArray[][]=new int[inputSparseArray.length][3];
		symmetricTransposeArray=transposeArrayOpertion(inputSparseArray);
		return Arrays.deepEquals(inputSparseArray, symmetricTransposeArray);
		
	}
	
	
	
	public static int[][] addMatrices(int inputSparseArrayFirst[][],int inputSparseArraySecond[][])
	{
		int rowNumber=0,columnNumber=0,value=0;int k=0;
		int startRow=0,startColumn=0;
	int resultAdd[][]=new int[inputSparseArrayFirst.length+inputSparseArraySecond.length][3];
	System.out.println("F LEN "+inputSparseArrayFirst.length);
	
	for(int i=0;i<inputSparseArrayFirst.length;i++)
	{	rowNumber=inputSparseArrayFirst[i][0];
	columnNumber=inputSparseArrayFirst[i][1];
	value=inputSparseArrayFirst[i][2];
	k=0;
System.out.print("ROW "+rowNumber+" ");

System.out.print("COL "+columnNumber+" ");
System.out.print("val "+value+" ");
System.out.println();
	for(int j=0;j<inputSparseArraySecond.length;j++)
		{
		if((inputSparseArraySecond[j][0]==rowNumber) && (inputSparseArraySecond[j][1]==columnNumber) )	
		{k=1;
			resultAdd[startRow][0]=rowNumber;
					resultAdd[startRow][1]=columnNumber;
							resultAdd[startRow][2]=value+inputSparseArraySecond[j][2];
									startRow++;
		}
		}
	    /*if(k==0)
		{
		resultAdd[][0]
		resultAdd[][1]
		resultAdd[][2]=
		}
			*/	
		if(k==0)
		{
			System.out.println("HERE "+startRow);
		resultAdd[startRow][0]=inputSparseArrayFirst[i][0];
			resultAdd[startRow][1]=inputSparseArrayFirst[i][1];
			resultAdd[startRow][2]=inputSparseArrayFirst[i][2];
			startRow++;
	}}
	
	for(int i=0;i<inputSparseArraySecond.length;i++)
	{	rowNumber=inputSparseArraySecond[i][0];
	columnNumber=inputSparseArraySecond[i][1];
	value=inputSparseArraySecond[i][2];
	k=0;
System.out.print("ROW "+rowNumber+" ");

System.out.print("COL "+columnNumber+" ");
System.out.print("val "+value+" ");
System.out.println();
	for(int j=0;j<inputSparseArrayFirst.length;j++)
		{
		if((inputSparseArrayFirst[j][0]==rowNumber) && (inputSparseArrayFirst[j][1]==columnNumber) )	
		{k=1;
			
		}
		}
		if(k==0)
		{
			System.out.println("HERE "+startRow);
		resultAdd[startRow][0]=inputSparseArraySecond[i][0];
			resultAdd[startRow][1]=inputSparseArraySecond[i][1];
			resultAdd[startRow][2]=inputSparseArraySecond[i][2];
			startRow++;
	}}
return resultAdd;
	}
			
	
	
	
	
	
	
	

	
	
	public static int[][] multiplyMatrices(int inputSparseArrayFirst[][],int inputSparseArraySecond[][])
	{
		int rowNumber=0,columnNumber=0,value=0;int k=0;
		int startRow=0,startColumn=0;
	int resultMultiply[][]=new int[inputSparseArrayFirst.length+inputSparseArraySecond.length][3];
	//System.out.println("F LEN "+inputSparseArrayFirst.length);
		if(inputSparseArrayFirst[0].length!=inputSparseArraySecond.length)
		{
			System.out.println("NOT PSSIBLE");
		}
		return resultMultiply;
	}
	
	
	
		

	public static void main(String[] args) {
		SparseMatrix s=new SparseMatrix();
		int td[][]=new int[][]{{0,0,0,4,0},{0,0,5,1,0},{0,0,0,0,3},{0,1,0,0,0}};
		int td1[][]=new int[][] {{1,2,3},{2,1,4},{3,4,3}};
		int td2[][]=new int[][] {{0,3,4},{1,2,5},{1,3,1},{2,4,3},{3,1,1}};
		int td3[][]=new int[][] {{0,0,4},{0,1,1},{0,2,2},{0,3,5},{0,4,2},{1,0,1},{1,1,5},{2,0,2},
			{2,2,3},{3,0,5},{3,3,6},{4,0,2},{4,4,16}};
		
		int td4[][]=new int[][]{{0,3,4},{0,4,10},{1,2,5},{1,3,1},{2,4,3},{3,1,1},{2,0,15}};

		int td5[][]=new int[][]{{0,4,9},{1,1,8},{2,0,4},{2,3,2},{3,1,2},{3,4,5}};
		int td6[][]=new int[12][3];
			//td6=addMatrices(td4,td5);
			td6=multiplyMatrices(td4,td5);
			
			
		//td1=addMatrices(td1,td2);
		//int siz=countElementSparse(td);
		//int tdd[][]=new int[siz][3];
			//	tdd=representSparseMatrix(td);
			//	int tdd1[][]=new int[3][siz];
				//tdd1=transposeArrayOpertion(tdd);
		//int td3[][]=new int[td2.length][3];
		td3=transposeArrayOpertion(td3);
		for(int i=0;i<td6.length;i++)
		{
			for(int j=0;j<td6[i].length;j++)
			{ 
				System.out.print(td6[i][j]+" ");
			}
			System.out.println();
	}
		
		//System.out.println(symmetricArrayOperation(td3));
	}}
interface ArrOperationInterface
{int largestMirror(int inputArray[], int noOfElement);
int numberOfClumps(int inputArray[]);	
public int[] arrangeXY(int inputArray[], int x, int y);
int indexOfSplit(int inputArray[]);
}
//import java.util.*;
/*This class performs certain operations on the array*/
/*The array in the following program is assumed to be containing positive integer only*/
public class ArrOperation implements ArrOperationInterface {
/**
 * This method helps in finding the size of largest mirror section found in the array.
 * A mirror section Mirror section in an array is a group of contiguous elements such
 * that somewhere in the array, the same group appears in reverse order 
 * @param inputArray is the array in which mirror section is to be found. 
 * @param noOfElement is the length of inputArray
 * @return the size of largest mirror section in inputArray[]
 */
	public int largestMirror(int inputArray[], int noOfElement){
		if(inputArray==null || inputArray.length==0)
		{
		throw new AssertionError("Array is empty");
		}
		int reversedArray[] = new int[noOfElement];
		for (int i = 0; i < noOfElement; i++) {
			reversedArray[i] = inputArray[noOfElement - 1 - i];
		}
		int findingMirror[][] = new int[noOfElement + 1][noOfElement + 1];
		int result = 0; // To store length of the longest mirror
		for (int i = 0; i <= noOfElement; i++) {
			for (int j = 0; j <= noOfElement; j++) {
				if (i == 0 || j == 0)
					findingMirror[i][j] = 0;
				else if (inputArray[i - 1] == reversedArray[j - 1]) {
					findingMirror[i][j] = findingMirror[i - 1][j - 1] + 1;
					result = (int) Math.max(result, findingMirror[i][j]);
				} else
					findingMirror[i][j] = 0;
			}
		}
		return result;
	}
/**
 * This method helps in finding the number of clumps present in the array
 * Clump in an array is a series of 2 or more adjacent elements of the same value	
 * @param inputArray is the array in which no of clumps is to be found
 * @return an integer value containing the total number of clumps
 */
	public int numberOfClumps(int inputArray[])throws AssertionError {
		int current = -1;
		int count = 0;
			if(inputArray==null || inputArray.length==0)
			{
			throw new AssertionError("Array is empty");
			}
			for (int i = 0; i < inputArray.length - 1; i++) {
			if (inputArray[i] == inputArray[i + 1] && current != inputArray[i]) {
				count++;
				// System.out.println("Hello World in here"+count);
				current = inputArray[i];
			} else if (inputArray[i] != inputArray[i + 1]
					&& current != inputArray[i]) {
				current = -1;
			}
		}
		return count;
	}
/**
 * This method helps in finding the array that contains exactly the same numbers as the input array, 
 * but rearranged so that every X is immediately followed by a Y.	
 * @param inputArray is the array on which operation is to be performed
 * @param x is an integer containing value of X
 * @param y is an integer containing value of Y
 * @return an array such that every X is followed by Y
 */
	public int[] arrangeXY(int inputArray[], int x, int y) {
		int temporary = 0;
		if(inputArray==null || inputArray.length==0)
		{
		throw new AssertionError("Array is empty");
		}
		int sizeX = 0, sizeY = 0;
		int xLocation[] = new int[inputArray.length];
		int yLocation[] = new int[inputArray.length];
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == x) {
				xLocation[sizeX] = i;
				sizeX++;
			} else if (inputArray[i] == y) {
				yLocation[sizeY] = i;
				sizeY++;
			}
		}
		if((sizeX!=sizeY))
		{
		throw new AssertionError("Unequal number of X and Y");	
		}
		if((xLocation[sizeX-1]==inputArray.length-1))
		{
		throw new AssertionError("X occurs at the last position ");	
		}
		for(int j=0;j<sizeX;j++)
		{    try{
			if((xLocation[j+1]-xLocation[j])==1)
					{
				throw new AssertionError("Adjacent values of X found");
					}
		}
		catch(Error e)
		{
			System.out.println("Adjacent values found");
		}
		
		}
		for (int i = 0; i < sizeX; i++) {
			if (yLocation[i] != xLocation[i]) {
				temporary = inputArray[xLocation[i] + 1];
				inputArray[xLocation[i] + 1] = inputArray[yLocation[i]];
				inputArray[yLocation[i]] = temporary;
			}
		}
		return inputArray;
	}
/**
 * This method helps in finding an index if there is a place to 
 * split the input array so that the sum of the numbers on one side is equal
 *  to the sum of the numbers on the other side else return -1
 * @param inputArray is the array on which operation is to be performed
 * @return an integer of index if there is place to split otherwise returns -1
 */
	public int indexOfSplit(int inputArray[])throws AssertionError {
		if(inputArray==null || inputArray.length==0)
		{
		throw new AssertionError();
		}
		int counter=0;
		int leftSumArray = 0;
		int totalSum = 0;
		int index = 0;
		int length = inputArray.length;
		for (int i = 0; i < length; i++) {
			totalSum += inputArray[i];
		}
		for (int j = 0; j < length; j++) {
			leftSumArray += inputArray[j];
			totalSum = totalSum - inputArray[j];
			if (leftSumArray == totalSum) {
				counter=1;
				index = j;
				break;
			}
		}
		if(counter!=0)
		{
		return (index + 1);
		}
		else
		{
			return -1;
		}
	}
}

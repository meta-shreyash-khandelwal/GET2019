package varunk;
public class Search {
/**
 * This method performs linear search on the array	
 * @param inputArray is the array in which element is to be searched
 * @param elementSearch is the element which is to be searched
 * @return the last index of element if found in array otherwise returns -1 
 */
	public int linearSearch(int inputArray[],int elementSearch)
	{
		int indexOfElement=-1;
		try{
		if(inputArray.length==0)
		{	
		System.out.println("Empty array passed ");
		throw new Exception("Empty array");
		}
		}catch(Exception e)
		{
			System.out.println("Empty array passed ");
		}
		for(int i=0;i<inputArray.length;i++)
		{
			if(inputArray[i]==elementSearch)
			{
				indexOfElement=i;
			}
		}
		return indexOfElement;
	}
/**
 * This element returns the index of element present by using Binary Searching
 * The array is assumed to be sorted and containing positive integers	
 * @param inputArray is the array in which element is to be searched 
 * @param elementSearch is the element to be searched in array
 * @return the i
 */
	public int binarySearch(int inputArray[],int elementSearch)
	{ try{
		if(inputArray.length==0)
		{	
		System.out.println("Empty array passed ");
		throw new Exception("Empty array");
		}
		}catch(Exception e)
		{
			System.out.println("Empty array passed ");
		}
		int lowerBound=0;
		int upperBound=inputArray.length-1;
		int middle=(lowerBound+upperBound)/2;
		while(lowerBound<=upperBound && inputArray[middle]!=elementSearch)
		{
			middle=(lowerBound+upperBound)/2;
			if(elementSearch<inputArray[middle])
			{
				upperBound=middle-1;
			}
			else
			{
				lowerBound=middle+1;
			}
		}
		if(elementSearch==inputArray[middle])
		{
			return middle;
		}
		else
		{
			return -1;
		}
		
	}}
class MainClass
{
public static void main(String[] args) {
		// TODO Auto-generated method stub
int arr[]={5,4,1,2,4,8};
int arrs[]={1,2,6,6,6,8,9};
Search s1=new Search();
System.out.println("HEY"+s1.linearSearch(arr,74));
System.out.println("HI"+s1.binarySearch(arrs,6));
}

}

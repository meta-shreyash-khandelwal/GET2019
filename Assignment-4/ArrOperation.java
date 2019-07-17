package varunk;
import java.util.*;
public class ArrOperation {
public static int largestMirror(int inputArray[],int noOfElement)
{		
		int reversedArray[]=new int[noOfElement];
		for(int i=0;i<noOfElement;i++)
		{
			reversedArray[i]=inputArray[noOfElement-1-i];
		}
				
		int findingMirror[][] = new int[noOfElement + 1][noOfElement + 1]; 
				int result = 0; // To store length of the longest mirror 
				for (int i = 0; i <= noOfElement; i++) 
				{ 
					for (int j = 0; j <= noOfElement; j++) 
					{ 
						if (i == 0 || j == 0) 
							findingMirror[i][j] = 0; 
						else if (inputArray[i - 1] == reversedArray[j - 1]) 
						{ 
							findingMirror[i][j] = findingMirror[i - 1][j - 1] + 1; 
							result = (int)Math.max(result, findingMirror[i][j]); 
						} 
						else
							findingMirror[i][j] = 0; 
					} 
				} 
				return result; 
} 
	
	public static int numberOfClumps(int inputArray[]) {
	    int current=-1;
	    int count=0;
	    for(int i=0;i<inputArray.length-1;i++)
	    {
	        if(inputArray[i]==inputArray[i+1] && current!=inputArray[i])
	        {
	            count++;
	            	//System.out.println("Hello World in here"+count);
	            current=inputArray[i];
	        }
	        else if(inputArray[i]!=inputArray[i+1] &&  current!=inputArray[i])
	        {
	           current=-1;
	           
	        }
	        
	    }
		//System.out.println("Hello World "+count);
	return count;
	}

	
public static int[] fixXY(int inputArray[],int x,int y)
{
		//    int count=0;
		    int temporary=0;
		  //  int x=4;
		    //int y=5;
		    int k1=0,k2=0;
		    int xLocation[]=new int[inputArray.length];
		    int yLocation[]=new int[inputArray.length];
		    for(int i=0;i<inputArray.length;i++)
		    {
		    if(inputArray[i]==x)
		    {
		    	xLocation[k1]=i;
		        k1++;

		    }
		    else if(inputArray[i]==y)
		    {
		    	yLocation[k2]=i;
		    k2++;
		    }
		    }
		    
		    for(int i=0;i<k1;i++)
		    {
		        if(yLocation[i]!=xLocation[i])
		        {
		        	temporary=inputArray[xLocation[i]+1];
		        	inputArray[xLocation[i]+1]=inputArray[yLocation[i]];
		        	inputArray[yLocation[i]]=temporary;
		        }
		        
		    }
		   
//		    for(int z=0;z<arr.length;z++)
	//		System.out.print(arr[z]+" ");
		
return inputArray;
	}

	
	
public static int indexOfSplit(int inputArray[]) {
//int arr[]={6,1,1,1,3};
int leftSumArray=0;;int totalSum=0;
int index=0;
int length=inputArray.length;
for(int i=0;i<length;i++)
{
totalSum+=inputArray[i];
}

for(int j=0;j<length;j++)
{
	leftSumArray+=inputArray[j];
	totalSum=totalSum-inputArray[j];
if(leftSumArray==totalSum)
{
index=j;
//System.out.println(index);
break;
}

}

return(index+1);	


}

	
						 
	public static void main(String[] args) 
	{ 
		 int arr[]={1,1,1,1,1,2,3,3,4,4,1,1};
		 int X[]={7,1,4,9,7,4,1};
     	 int m = X.length; 
     	int arr4[]={1,1,1,2,1};
     	int arr3[]={1,4,1,5,5,4,1};
    	 	 int res[]=fixXY(arr3,4,5);
		System.out.println("Length is "
				+ largestMirror(X,m)); 
		System.out.println("Length is clump "
				+ numberOfClumps(arr)); 
		System.out.println("Length of split "
				+ indexOfSplit(arr4)); 
 for(int i=0;i<res.length;i++) {
		System.out.print(res[i]+" "); 
 }
	
	}	
	
}
	
	
	
	
	
	
	


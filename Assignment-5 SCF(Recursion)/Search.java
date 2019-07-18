public class Search {
	/**
	 * This method performs linear search on the array
	 * @param inputArray is the array in which element is to be searched
	 * @param elementSearch is the element which is to be searched
	 * @return the last index of element if found in array otherwise returns -1
	 */
	public int linearSearch(int inputArray[], int elementSearch) {
		try {
			if (inputArray.length == 0) {
				System.out.println("Empty array passed ");
				throw new Exception("Empty array");
			}
		} catch (Exception e) {
			System.out.println("Empty array passed ");
		}
		return linearSearchRecursion(inputArray, elementSearch,
				inputArray.length - 1);
	}
	/**
	 * This method performs the recursion for linear searching 
	 * @param inputArray is the array in which element is to be searched
	 * @param elementSearch is the element which is to be searched
	 * @param indexOfElement is used for recursion
	 * @return the index at which element is found otherwise returns -1
	 */
	public int linearSearchRecursion(int inputArray[], int elementSearch,
			int indexOfElement) {
		if (indexOfElement == -1) {
			return -1;
		} // Element not found
		else if (inputArray[indexOfElement] == elementSearch) {
			return indexOfElement;
		} else {
			return linearSearchRecursion(inputArray, elementSearch,
					indexOfElement - 1);
		}
	}
	/**
	 * This element returns the index of element present by using Binary
	 * Searching The array is assumed to be sorted and containing positive
	 * integers 
	 * @param inputArray is the array in which element is to be searched
	 * @param elementSearch is the element to be searched in array
	 * @return the index at which element is found else return -1
	 */

	public int binarySearch(int inputArray[], int elementSearch) {
		try {
			if (inputArray.length == 0) {
				System.out.println("Empty array passed ");
				throw new Exception("Empty array");
			}
		} catch (Exception e) {
			System.out.println("Empty array passed ");
		}
		return binarySearchRecursion(inputArray, 0,inputArray.length - 1,elementSearch);
	}
    /**
     * This method performs the recursion for purpose of binary Search		
     * @param inputArray is the array in which element is to be searched
     * @param lowerBound is the lower index of array
     * @param upperBound is higher index of array
     * @param elementSearch is the element to be searched in array
     * @return the index at which element is present otherwise returns -1
     */
	
	public int binarySearchRecursion(int inputArray[], int lowerBound,
			int upperBound, int elementSearch) {
		try {
			if (inputArray.length == 0) {
				System.out.println("Empty array passed ");
				throw new Exception("Empty array");
			}
		} catch (Exception e) {
			System.out.println("Empty array passed ");
		}
		int middle = (lowerBound + upperBound) / 2;
		if (elementSearch < inputArray[middle]) {
			return binarySearchRecursion(inputArray, lowerBound, middle - 1,
					elementSearch);
		} else if (elementSearch > inputArray[middle]) {
			return binarySearchRecursion(inputArray, middle + 1, upperBound,
					elementSearch);
		} else if (elementSearch == inputArray[middle]) {
			return middle;
		} else {
			return -1;
		}

	}
}

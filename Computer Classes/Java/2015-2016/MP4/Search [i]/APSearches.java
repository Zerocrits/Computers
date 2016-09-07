// Mr. Ascione
// AP Searches
// Spec: This combines the binary search and sequential search as defined in the APCS course definition
//	 into a utility class that we will use to analyze the relative efficiency of binary and sequential searches.

public class APSearches
{
	/**
	* Finds the index of a value in an array of integers.
	*
	* @param elements an array containing the items to be searched.
	* @param target the item to be found in elements.
	* @return an index of target in elements if found; -1 otherwise.
	*/
	public static int sequentialSearch(int[] elements, int target)
	{
		for (int j = 0; j < elements.length; j++)
		{
			if (elements[j] == target)
			{
				return j;
			}
		}

		return -1;
	}

	/**
	* Find the index of a value in an array of integers sorted in ascending order.
	*
	* @param elements an array containing the items to be searched.
	* Precondition: items in elements are sorted in ascending order.
	* @param target the item to be found in elements.
	* @return an index of target in elements if target found; * -1 otherwise.
	*/
	public static int binarySearch(int[] elements, int target)
	{
		int left = 0;
		int right = elements.length - 1;

		while (left <= right)
		{
			int middle = (left + right) / 2;
			if (target < elements[middle])
			{
				 right = middle - 1;
			}
			else if (target > elements[middle])
			{
				 left = middle + 1;
			}
			else
			{
				 return middle;
			}
		}

		return -1;
	}
}
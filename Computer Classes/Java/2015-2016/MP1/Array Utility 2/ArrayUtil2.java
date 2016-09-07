// Bill Joseph
// Array Utility 2
// Spec: Build Array Util 2

import java.util.Arrays;

public class ArrayUtil2
{
	/** swaps the values at index1 and index2 in the array arr
	*	Note: this will affect the values of the array parameter arr
	*/
	public static void swap(int index1, int index2, int[] arr)
	{
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;

	}

	/** swaps the values at index1 and index2 in the array arr
	*	Note: this will affect the values of the array parameter arr
	*/
	public static void swap(int index1, int index2, double[]arr)
	{
		double temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	/** @return an array that consists of all the elements of array x
	*	followed by all the elements of array y
	*/
	public static int[] appendArrays(int[] x, int[]y)
	{
		int total = 0;
		total += x.length + y.length;
		int[] append = new int[total];
		int i = 0;
		while(i < total)
		{
			for(int j = 0; j < x.length; j++)
			{
				append[i] = x[j];
				i++;
			}
			for(int j = 0; j < y.length; j++)
			{
				append[i] = y[j];
				i++;
			}
		}
		return append;
	}

	/** @return a new array with the first x values removed */
	public static int[] removeFirstXValues(int[] nums, int x)
	{
		int[] remove = new int[nums.length-x];
		for(int i = 0; i < remove.length; i++)
		{
			remove[i] += nums[x];
			x++;
		}
		return remove;
	}

	/** @return a new array with the last x values removed */
	public static int[] removeLastXValues(int[] nums, int x)
	{
		int[] remove = new int[nums.length-x];
		for(int i = 0; i < remove.length; i++)
		{
			remove[i] += nums[i];
		}
		return remove;
	}

	/** @return an array with all the evens removed
	*	ie odd values only */
	public static int[] removeEvens(int[] arr)
	{
		int j = 0;
		int odd = 0;
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] % 2 != 0)
				odd++;
		}
		int[] remove = new int[odd];
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] % 2 != 0)
			{
				remove[j] = arr[i];
				j++;
			}
		}
		return remove;
	}

	/** @return an array with all the odds removed
	*	ie even values only */
	public static int[] removeOdds(int[] arr)
	{
		int j = 0;
		int even = 0;
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] % 2 == 0)
				even++;
		}
		int[] remove = new int[even];
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] % 2 == 0)
			{
				remove[j] = arr[i];
				j++;
			}
		}
		return remove;
	}

	/** @return the number of unique ints in the array arr
	*	Good idea to sort the array first
	*	Our approach: while we are not at the length...
	*				  and while the current number is the same...
	*				  advance the index
	*				  keep a counter and return it
	*/
	public static int numUniqueInts(int[] arr)
	{
		Arrays.sort(arr);
		int total = 0;
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 1; j < arr.length; j++)
			{
				if(arr[i] != arr[j] && arr[j] != 0 && arr[i] != 0)
				{
					total++;
					arr[j] = 0;
				}
			}
		}
		return total;
	}

}




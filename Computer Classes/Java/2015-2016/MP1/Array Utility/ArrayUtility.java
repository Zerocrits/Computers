//Bill Joseph
//Array Utility
//Spec: Build an Array Utility with methods


// Utility File to practice working with arrays

public class ArrayUtility
{
	/** Calculates and returns the sum of the nums array
	*   @param nums the int array to be added
	*   @return the sum of the nums array */
	//  Note: We have two versions of getSum - this is an example of Method Overloading
	// 			They have different signatures - the type and / or sequence of parameters
	public static int getSum(int[] nums)
	{
		int sum = 0;
		for(int i = 0; i < nums.length; i++)
			sum += nums[i];
		return sum;
	}

	/** Calculates and returns the sum of the nums array
	*   @param nums the double array to be added
	*	@return the sum of the nums array*/
	public static double getSum(double[] nums)
	{
		double sum = 0;
		for(int i = 0; i < nums.length; i++)
			sum += nums[i];
		return sum;
	}

	/** Calculates and returns the product of the nums array
	*   @param nums the int array to create a product from
	*	@return the product of each element in the nums array */
	public static long getProduct(int[] nums)
	{
		long sum = 0;
		for(int i = 0; i < nums.length; i++)
			if(i == 0)
				sum = nums[i];
			else
				sum = sum * nums[i];
		return sum;
	}

	/** Builds and returns a reverse order version of the nums array
	*   @param nums the int array to be added
	*	@return a reverse order version of the nums array */
	public static int[] reverseArray(int[] nums)
	{
    	int[] reversed = new int[nums.length];
    	for (int i=0; i<nums.length; i++)
    		reversed[i] = nums[nums.length - 1 - i];
    	return reversed;
	}

	/** Searches the nums array for the maximum value
	*   @param nums the array to be searched
	*	@return the maximum value in the array */
	public static int findMax(int[] nums)
	{
		int max = nums[0];
		for(int i = 1; i < nums.length; i++)
			if(nums[i] > max)
				max = nums[i];
		return max;

	}

	/** Searches the nums array for the minimum value
	*   @param nums the array to be searched
	*	@return the minimum value in the array */
	public static int findMin(int[] nums)
	{
		int min = nums[0];
		for(int i = 1; i > nums.length; i++)
			if(nums[i] < min)
				min = nums[i];
		return min;
	}

	/** Searches the String word for an occurence of the target char
	*   @param word the String to be searched
	*	@param target the char to search for
	*	@return true if the target char is found, false otherwise */
	public static boolean contains(String word, char target)
	{
		boolean answer = false;
		for(int i = 0; i < word.length(); i++)
			if(word.charAt(i) == target)
				return true;
		return false;
	}

	/** Searches the nums array for an occurence of the int target
	*   @param nums the array to be searched
	*	@param target the int to search for
	*	@return true if the target int is found, false otherwise */
	public static boolean contains(int[] nums, int target)
	{
		boolean answer = false;
		for(int i = 0; i < nums.length; i++)
			if(nums[i] == target)
				return true;
		return false;
	}

	/** "poor-mans Encryption"... add 44 to the ascii value of each char in a String
	*   @param word the String to be encrypted
	*	@return an 'encrypted' version of the original String */
	public static String pmEncrypt(String word)
	{
		String phrase = "";
		for(int i = 0; i < word.length(); i++)
			phrase += (char) (word.charAt(i) + 44);
		return phrase;
	}

	/** Reverses the pmEncrypt process... builds a new String by subtacting 44 from each char value in an encrypted String
	*   @param word a pmEncrypted String
	*	@return a 'decrypted' version of the pmEncrypted String */
	public static String pmDecrypt(String word)
	{
		String phrase = "";
		for(int i = 0; i < word.length(); i++)
			phrase += (char) (word.charAt(i) - 44);
		return phrase;
	}

	/** Formats an array of Strings for console output with tabs (\t) in-between each value*/
	// Note: Arrays have a built-in 'toString() method that does a decent job of this already
	public static String arrayToString(int[] nums)
	{
		String word = "";
		for(int i = 0; i < nums.length; i++)
			word += nums[i] + "\t";
		return word;
	}

	/** Formats an array of Strings for console output with tabs (\t) in-between each value*/
	// Note: Arrays have a built-in 'toString() method that does a decent job of this already
	public static String arrayToString(double[] nums)
	{
		String word = "";
		for(int i = 0; i < nums.length; i++)
			word += nums[i] + "\t";
		return word;
	}
}
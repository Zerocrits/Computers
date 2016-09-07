// Mr. A
// Pig Latin
// Spec: To create the Pig Latin form of an English word
//       the initial consonant sound is transposed to the end of the word and an ay is affixed
//       Ex.: "banana" would yield anana-bay). Read Wikipedia for more information on rules.
//		 This is an Object Oriented version that allows a client to build a PigLatin object.

public class PigLatin
{
	private String piggyVersion;

	/** Default constructor initializes piggyVersion to the empty String
	*/

	public PigLatin()
	{
		piggyVersion = "";
	}

	/** @param words the String used to initialize piggyVersion
	/*  Constructor that initializes based on words.
	/*  In this case, the constructor will initialize by calling the convertExpression() method.
	*/

	public PigLatin(String words)
	{
		piggyVersion = "";
		convertExpression(words);
	}

	/** @param original the original word which will be transformed to Pig Latin as per spec
	/*  @return the Pig Latin version of the original String
	/*  This method is used to convert each word individually
	/*  utilizes String methods .substring() and .charAt to build piggyVersion
	*/

	public String convertWord(String original)
	{
		int split = firstVowel(original);
		String result = "";

		if(split == 0)
		{
			result = original + "-yay ";
		}
		else if(split != 0)
		{
			result = original.substring(split) + "-" + original.substring(0, split) + "ay ";
		}

    	return result;
	}

	/** @expression the original expression with spaces included
	/*  This method sets the value of piggyVersion
	/*  Utilizes the String method .split() to create an array of Strings
	/*  Approach: 1) declare and initilize an array of strings using .split(" ")
	/*  		  2) step thru the array of words and use the helper method convertWord()
	/* 				 to convert each word and add it to piggyVersion... the Pig Latin version
	*/

	public void convertExpression(String expression)
	{
		expression.toLowerCase();
		String total[] = {};
		total = expression.split(" ");
		for(int i = 0; i < total.length; i++)
		{
			piggyVersion += convertWord(total[i]);
		}
	}

	public int firstVowel(String original)
	{
		original = original.toLowerCase();
		for (int i = 0; i < original.length(); i++)
		if (original.charAt(i)=='a' || original.charAt(i)=='e' ||
			original.charAt(i)=='i' || original.charAt(i)=='o' ||
			original.charAt(i)=='u')
			{
				return i;
			}
		return 0;
	}

	/** @return piggyVersion... it is already a String */
	public String toString()
	{
		piggyVersion.toLowerCase();
		return piggyVersion;
	}
}
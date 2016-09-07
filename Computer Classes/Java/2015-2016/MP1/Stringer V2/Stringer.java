//Bill Joseph
public class Stringer
{
	private String phrase;

	/** Default Constructor
	* 	Set your Instance Variable to a reasonable default
	* 	The empty string in this case
	*/
	public Stringer()
	{
		phrase = "";
	}

	/** Initialization Constructor
	* 	Set the Instance Variable to the parameter provided by the user when instantiated
	*/
	public Stringer(String input)
	{
		phrase = input;
	}

	/**	Sets the Instance Variable to the parameter provided by the user
	*	Note  mutator method... it modifies the state of the object
	*/
	public void setPhrase(String input)
	{
		phrase = input;
	}

	/** @return the count of "the" in this Stringer
	* 	Note: the counts by itself, as well as if it is part of a word
	*			ie String Therapy contains "the" for our purposes
	*	Hint: use indexOf()
	*/
	public int getTheCount()
	{
		int number = 0;

		for(int i = 0; i < phrase.length(); i++)
		{
			if(phrase.indexOf("the", i) == i)
			{
				number++;
			}
		}
		return number;
	}

	/** @return the number of occurrences of searchPhrase in this Stringer
	*	Hint: this is just a general case of getTheCount() above
	*/
	public int getCountOf(String searchFor)
	{
		int number = 0;

		for(int i = 0; i < phrase.length(); i++)
		{
			if(phrase.indexOf(searchFor, i) == i)
			{
				number++;
			}
		}
		return number;
	}

	/** This Stringer will be manipulated such that the last 3 letters move to the front
	*	of the String, the rest of the letters then follow.
	*	Note: this is a mutator method... the state of the object itself is changed
	*	Hint: substring() is your friend!
	*/
	public void moveLastThree()
	{
		phrase = phrase.substring(phrase.length()-3) + phrase.substring(0, phrase.length()-3);
	}

	/** This Stringer will be manipulated such that the first 3 letters move to the back
	*	of the String, the rest of the letters move forward.
	*	Note: this is a mutator method... the state of the object itself is changed
	*	Hint: substring() is still your friend!
	*/
	public void moveFirstThree()
	{
		phrase = phrase.substring(3, phrase.length()) + phrase.substring(0,3);
	}

	/** @return a String that consists of the first 3 letters, skip three, then the next three letters etc.
	*	until the end of this Stringer is reached.
	*	Hint: substring(from, to) maybe some substring(from)... and a loop
	*/
	public String everyOtherThree()
	{
		String str = "";
		for(int i = 0; i < phrase.length(); i++)
		{
			if((i / 3) % 2 == 0)
			{
				str += phrase.charAt(i);
			}
		}
		return str;
	}
	/** @return the state of this Stringer object as a String...
	*	... and it's already a String... so just return it :)
	*/
	public String toString()
	{
		return phrase;
	}
}

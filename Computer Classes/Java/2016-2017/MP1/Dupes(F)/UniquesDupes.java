//Bill Joseph
//Dupe Program
//Spec: Use Treeset to create a program showing unique numbers and duped numbers

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.ArrayList;


public class UniquesDupes
{
	Set<String> uniques = new TreeSet<String>();
	String input = "";
	/** @param input a list of words separated by spaces
	*	@return  a Set that contains only the unique words from the input
	*	Note: This is the built-in behavior of a Set
	*/

	public static Set<String> getUniques(String input)
	{
		String[] words = input.split(" ");
		Set<String> uniques = new TreeSet<String>(Arrays.asList(words)); // A Set to store the uniques

		return uniques;
	}

	/** @param input a list of words separated by spaces
	*	@return  a Set that contains only the words that are duplicates in the original list
	*	Note: Take a look at the API for the add() method in Set... it returns a boolean
	*	Hint: Consider creating 2 sets and use the behavior of Sets to simplify the task
	*/
	public static Set<String> getDupes(String input)
	{
		String[] words = input.split(" ");
		Set<String> uniques = new TreeSet<String>();
		Set<String> dupes = new TreeSet<String>();

		for(int i = 0; i < words.length; i++)
		{
			if(!uniques.add(words[i]))
				dupes.add(words[i]);
		}

		return dupes;
	}
}
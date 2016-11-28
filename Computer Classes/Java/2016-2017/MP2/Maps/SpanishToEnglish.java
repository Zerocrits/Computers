// Name - Bill Joseph
// Prog - Read in a list of Spanish words with English equivalents
// Date - 11/28/16

import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;


public class SpanishToEnglish
{
	private Map<String,String> pairs;

	public SpanishToEnglish()
	{
		Scanner input = new Scanner("spantoeng.dat");
		int numKey = input.nextInt();
		String dictionary = input.nextLine();
		String[] doc = dictionary.split(" ");
		for(int i = 0; i < numKey*2; i = i+2)
		{
			pairs.put(doc[i], doc[i+1]);
		}


	}

	public void putEntry(String entry)
	{
		String[] list = entry.split(" ");





	}

	public String translate(String sent)
	{
		Scanner chop = new Scanner(sent);
		String output ="";






		return output;
	}

	public String toString()
	{
		return pairs.toString().replaceAll("\\,","\n");
	}
}
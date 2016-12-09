// Name - Bill Joseph
// Prog - Read in a list of Spanish words with English equivalents
// Date - 11/28/16

import java.io.*;
import java.util.*;
import java.util.Map;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.Scanner;


public class SpanishToEnglish
{
	private Map<String,String> pairs;
	private int numKey = 0;

	public SpanishToEnglish()
	{
		pairs = new TreeMap<String,String>();
		Scanner sc = new Scanner(System.in);
		try {
		    File file = new File("spantoeng.dat");
		    sc = new Scanner(file);
		    numKey = sc.nextInt();
		    sc.nextLine();
			while(sc.hasNextLine() && numKey > 0)
			{
				numKey--;
				putEntry(sc.nextLine());
			}
		}catch (FileNotFoundException e)
		{
		    e.printStackTrace();
		}

	}

	public void putEntry(String entry)
	{
		String[] list = entry.split(" ");
		pairs.put(list[0], list[1]);
	}

	public String translate(String sent)
	{
		String output = "";
		String[] list = sent.split(" ");
		for(int i = 0; i < list.length; i++)
		{
			if(pairs.containsKey(list[i]));
				output += pairs.get(list[i]) + " ";

		}
		return output;
	}

	public String toString()
	{
		return pairs.toString().replaceAll("\\,","\n");
	}
}
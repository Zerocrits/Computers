// Name - Bill Joseph
// Prog - Read in a list of Spanish words with English equivalents
// Date - 11/28/16

import java.io.*;
import java.util.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;


public class SpanishToEnglish
{
	private Map<String,String> pairs;
	private int numKey = 0;

	public SpanishToEnglish()
	{
		Map pairs = new TreeMap();
		Scanner sc = new Scanner(System.in);
		try {
		    File file = new File("spantoeng.dat");
		    sc = new Scanner(file);
		    numKey = sc.nextInt();
		    sc.nextLine();
			while(sc.hasNextLine() && numKey != 0)
			{
				numKey--;
				putEntry(sc.nextLine());
			}
			while(sc.hasNextLine())
			{
				System.out.println(translate(sc.nextLine()));
			}
		}catch (FileNotFoundException e)
		{
		    e.printStackTrace();
		}

	}

	public void putEntry(String entry)
	{
		String[] list = entry.split(" ");
		pairs = new TreeMap();
		pairs.put(list[0], list[1]);

		Set set = pairs.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext())
		{
			Map.Entry mentry = (Map.Entry)iterator.next();
			System.out.println(mentry.getKey() + "=" + mentry.getValue());
		}

	}

	public String translate(String sent)
	{
		String output = "";
		String[] list = sent.split(" ");
		for(int i = 0; i < list.length-1; i++)
		{
			if(pairs.containsKey(list[i]));
				//System.out.println(list[i] + " " + pairs.values());
				output += pairs.get(list[i]);
				//output += list[i].get(pairs);

		}
		return output;
		//http://docs.oracle.com/javase/7/docs/api/java/util/TreeMap.html
	}

	public String toString()
	{
		return "";
		//return pairs.toString().replaceAll("\\,","\n");
	}
}
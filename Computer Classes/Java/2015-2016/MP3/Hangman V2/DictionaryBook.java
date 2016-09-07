// textfile to string, in arraylist, find random word
<<<<<<< HEAD
//Arjun Guramoon
//Revised and Debugged by Madison Miatke and Billy Joseph
=======
>>>>>>> origin/master

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
<<<<<<< HEAD

public class DictionaryBook implements IDictionary
=======
import java.io.File;
import java.io.FileNotFoundException;

public class DictionaryBook
>>>>>>> origin/master
{
	private ArrayList<String> word;

	public DictionaryBook()
	{
		ArrayList word = new ArrayList<String>();
	}

	public String getRandomWord()
	{
		makeList();
		int r = (int)(Math.random() * word.size());
		return word.get(r);
	}

	public void makeList()
	{
		word = new ArrayList<String>();

		try
		{
			Scanner fileScanner = new Scanner(new File("words.txt"));
			while(fileScanner.hasNextLine())
			{
				word.add(new String(fileScanner.nextLine()));
			}
		}

		catch(FileNotFoundException x)
		{
			word.add("nope");
		}
	}
}
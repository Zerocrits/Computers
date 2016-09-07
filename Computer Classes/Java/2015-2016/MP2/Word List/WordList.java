// Bill Joseph
// WordsList
// Spec: Main code of program

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class WordList
{
	private ArrayList<Word> words;

	public WordList()
	{
		setWords("");
	}

	public WordList(String listOfWords)
	{
		setWords(listOfWords);
	}

	public void setWords(String listOfWords)
	{
		words = new ArrayList();

		String[] word = listOfWords.split(" ");

		for(int i = 0; i < word.length; i++)
			words.add(new Word(word[i]));
	}

	public int countWordsWithXChars(int size)
	{
		int count = 0;
		for(int i = 0; i < words.size(); i++)
		{
			if(words.get(i).getLength() == size)
				count++;
		}
		return count;
	}

	//this method will remove all words with a specified size / length
	//this method will also return the sum of the vowels in all words removed
	public int removeWordsWithXChars(int size)
	{
		int totalVowels = 0;

		for(int i = words.size()-1; i >= 0; i--)
		{
			if(words.get(i).getLength() == size)
			{
				totalVowels += words.get(i).getNumVowels();
				words.remove(i);
				i--;
			}
		}
		return totalVowels;
	}

	public int countWordsWithXVowels(int numVowels)
	{
		int count = 0;
		for(int i = 0; i < words.size(); i++)
		{
			if(words.get(i).getNumVowels() == numVowels)
				count++;
		}
		return count;
	}

	public String toString()
	{
	   return "";
	}
}
<<<<<<< HEAD
import javax.swing.ImageIcon;
=======
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;
>>>>>>> origin/master

//Max Paul
//Hangman
//Revised and Debugged by Madison Miatke and Billy Joseph
public class HangMan implements IHangMan
{
	private String word, wrong, reveal;
	private char letter;
	private int timesWrong;
	private DictionaryBook dict;
	private DrawHangMan draw;


	public HangMan()
	{
		dict = new DictionaryBook();
		draw = new DrawHangMan();
		wrong = "";
		reveal = "";
		letter = ' ';
		timesWrong = 0;
		newWord();
	}

	public void guessLetter(char guess)//checks the letter and either adds it to the wordSoFar or adds it to the incorrect guesses
	{
		String updated = "";
		boolean letterWithin = false;
		char[] chars = reveal.toCharArray();
		for(int i = 0; i<word.length(); i++)
		{
			if(word.charAt(i) == guess)
			{
			    chars[i] = word.charAt(i);
			    letterWithin = true;
			}
		}

		if(!letterWithin)
		{
			wrong+=guess;
			timesWrong++;
		}
		reveal = String.valueOf(chars);
	}

	public String getIncorrectLetters()
	{
		return wrong;
	}
	public void newWord()//gets a new word and then changes it to dashes (computer becomes --------)
	{
		word = dict.getRandomWord();
		reveal = "";
		for(int i = 0; i<word.length(); i++)
		{
			reveal+= "-";
		}
		timesWrong = 0;
	}
	public String getWordSoFar()
	{
		return reveal;
	}
	public String getWord()
	{
		return word;
	}
	public int getAmtIncorrectGuesses()
	{
		return timesWrong;
	}
	public boolean lose()
	{
		if(timesWrong >= 6)
			return true;
		return false;
	}
	public boolean win()
	{
		if(reveal.equals(word))
		{
			return true;
		}
		return false;
	}

	public String consoleDrawing()
	{
		return draw.getStringDrawing(timesWrong);
	}
	public ImageIcon guiDrawing()
	{
		return draw.getImage(timesWrong);
	}



}
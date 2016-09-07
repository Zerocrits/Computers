//Bill joseph
//Hangman Runner(Console)

import java.util.Scanner;

public class HangmanRunner
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		HangMan man = new HangMan();
		String result;
		String guess = "";
		String title = "\t\t\t\t~~HangMan~~";
		String dashes;
		String incorrect;
		String word = man.getWord();
		String drawing;
		int incorrectGuesses = 0;
		boolean hasWon = false;
		while(hasWon == false)
		{
			result = "";
			dashes = man.getWordSoFar();
			incorrect = man.getIncorrectLetters();
			drawing = man.consoleDrawing();
			incorrectGuesses = man.getAmtIncorrectGuesses();
			hasWon = man.win();
			result += title + "\nWord: " + dashes + "\nIncorrect Letters: " + incorrect;
			result += "\t\t\t\t\tNumber Incorrect: " + incorrectGuesses + "\n" + drawing + "\nYour Guess: " ;
			System.out.print(result);
			guess = sc.nextLine();

			if(guess.length() == 0)
				guess = "z";

			man.guessLetter(guess.charAt(0));
			for(int i = 0; i < 100; i++)
				System.out.println();

			if(incorrectGuesses == 6)
				hasWon = true;
			if(word.equals(dashes))
				hasWon = true;
		}
		if(hasWon == true && incorrectGuesses < 6)
			System.out.println("***You Win***\nWord Was: " + word);
		else
			System.out.println("***You Lose***\nWord Was: " + word);
		System.out.println();

	}

}
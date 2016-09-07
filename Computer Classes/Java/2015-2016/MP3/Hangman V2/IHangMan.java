//Madison Miatke - Group Leader/Interface Integrater/GUI Guru

import javax.swing.ImageIcon;

public interface IHangMan
{
	void guessLetter(char guess);
	String getIncorrectLetters();
	void newWord();
	String getWordSoFar();
	String getWord();
	int getAmtIncorrectGuesses();
	boolean lose();
	boolean win();
	String consoleDrawing();
	ImageIcon guiDrawing();
}






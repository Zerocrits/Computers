//Paolo R
//Draws ascii hangman or returns a graphic depending on the amount of wrong guesses
import javax.swing.ImageIcon;

public class DrawHangMan implements IDrawHangMan
{
	//guesses will be 0-6, with 6 being losing state
	public String getStringDrawing(int wrongGuesses)
	{
		String res = "";
		if(wrongGuesses>0) res += "  ,-----.\n /       \\\n(         )\n \\       /\n  `--.--'\n"; //drawhead
		if(wrongGuesses>3)
			res += "   ,'|`,\n  ,' | `,\n /   |   \\\n<    '    >\n"; //both arms + torso
		else if(wrongGuesses>2)
			res += "   ,'|\n  ,' |\n /   |\n<    '\n"; //left arm + torso
		else if(wrongGuesses>1)
			res += "     |\n     |\n     |\n     |\n"; //just torso
		else if(wrongGuesses>5)
		    res += "     X\n    / \\\n   /   \\\n  /     \\\n /       \\\n/         \\"; //both legs
		else if(wrongGuesses>4)
			res +="     X\n    /\n   /\n  /\n /\n/"; //just left leg
		return res;
	}
	/*
  ,-----.
 /       \
(         )
 \       /
  `--.--'
   ,'|`,
  ,' | `,
 /   |   \
<    '    >
     X
    / \
   /   \
  /     \
 /       \
/         \
	*/
	public ImageIcon getImage(int wrongGuesses)
	{
		ImageIcon man = null;

		man = new ImageIcon("./man" + wrongGuesses + ".jpg"); //returns man0.jpg to man6.jpg
		return man;

	}
}
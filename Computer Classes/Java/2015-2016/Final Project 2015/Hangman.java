import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.lang.String;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

public class Hangman extends JFrame implements ActionListener
{
	private JTextField wordbox, guessbox, guesslet, chances;
	private String word, wrongletters, starstring;
	private char[] stars;
	private int lengword, tries;
	private JRadioButton tletter,tword;
	private JPanel pickpanel;


	public Hangman()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5,2));
		panel.add(new JLabel("Word: "));
		wordbox = new JTextField(5);
		wordbox.setEditable(false);
		panel.add(wordbox);
		panel.add(new JLabel("Guessed Letters: "));
		guesslet = new JTextField(5);
		guesslet.setEditable(false);
		guesslet.setText("None");
		panel.add(guesslet);
		tletter = new JRadioButton("Letter", true);
		tword = new JRadioButton("Word");
		ButtonGroup gr = new ButtonGroup();
		gr.add(tletter);
		gr.add(tword);
		panel.add(tletter);
		panel.add(tword);

		JButton button = new JButton("Click to Guess");
		button.addActionListener(this);
		panel.add(button);
		guessbox = new JTextField(5);
		panel.add(guessbox);
		panel.add(new JLabel("Chances: "));
		chances = new JTextField(5);
		chances.setEditable(false);
		chances.setText("None");
		panel.add(chances);

		pickpanel = new JPanel();
		pickpanel.setLayout(new GridLayout(1,1));

		Container c = getContentPane();
		c.add(panel, BorderLayout.NORTH);
		c.add(pickpanel, BorderLayout.CENTER);
		setup();

		setSize(900,900);
		setVisible(true);
		setResizable(false);
	}

	public static void main(String[] args)
	{
		Hangman foo = new Hangman();
	}
	public void actionPerformed(ActionEvent e)
	{
		String t, f = "";
		t = guessbox.getText().trim().toLowerCase();
		if(tletter.isSelected())
		{
			int i;
			char letter;
			boolean found = false;
			letter = t.charAt(0);

			for (i = 0; i < lengword; i++)
			{
				if(letter == word.charAt(i))
				{
					stars[i] = letter;
					found = true;
				}
				repaint();
			}
			if(found == false)
			{
				if(tries > 0)
				{
					wrongletters += letter;
					tries--;
					repaint();
				}
			}
			if(tries == 0)
			{
				guessbox.setText("You Lose");
				guessbox.setEditable(false);
				wordbox.setText(word);
				chances.setText("" + tries);
				repaint();
			}
			else
			{
				starstring = String.copyValueOf(stars);
				wordbox.setText(starstring);
				guesslet.setText(wrongletters);
				guessbox.setText("");
				chances.setText("" + tries);
				repaint();
			}
		}
		else // word.isSelected
		{
			if (t.equals(word))
			{
				guessbox.setText("You Win");
				guessbox.setEditable(false);
				wordbox.setText(word);
			}
			else
			{
				guessbox.setText("You Lose");
				guessbox.setEditable(false);
				wordbox.setText(word);
			}
			repaint();
		}
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		int y = pickpanel.getY();
		int w = pickpanel.getWidth();
		int h = pickpanel.getHeight();
		int midw = w/2;
		int midh = h/2 + 140;

		g.setColor(Color.black);
		g.drawLine(midw, midh-131, midw, midh-161);
		g.fillRect(midw, midh-161, 100, 10);
		g.drawLine(midw+50, midh-161, midw+100, midh-111);
		g.fillRect(midw+100, midh-161, 10, 321);
		g.fillRect(midw, midh+150, 200, 10);
		g.setColor(Color.black);
		switch(tries)
		{
			case 0: g.drawLine(midw, midh+70, midw+40, midh+120); // leg
			case 1: g.drawLine(midw, midh+70, midw-40, midh+120); // leg
			case 2: g.drawLine(midw, midh, midw-40, midh-60); // arm
			case 3: g.drawLine(midw, midh, midw+40, midh-60); // arm
			case 4: g.drawLine(midw, midh+70, midw, midh-80); // body
			case 5:	g.drawLine(midw-13, midh-95, midw+13, midh-95); // mouth
			case 6:	g.drawOval(midw+9, midh-115,10,10);// right eye
			case 7:	g.drawOval(midw-13, midh-115,10,10);// left eye
			case 8:	g.drawOval(midw-25, midh-130, 50, 50); // head
		} //switch
	}
	public void setup()
	{
		int i;
		tries = 9;

		try
		{
			word = getaword();
		}
		catch(Exception e){}

		lengword = word.length();
		stars = new char[lengword];
		wrongletters = "";
		for (i = 0; i < lengword; i++)
		{
			stars[i] = '*';
			starstring = String.copyValueOf(stars);
			wordbox.setText(starstring);
			chances.setText("" + tries);
			repaint();
		}
	}
	public String getaword()
	{
		Random r = new Random();
		String[] word = new String[1000000];
		int i = 0;
		int count = 0;
		String filename = "words.txt";
		try
		{
			Scanner file = new Scanner(new File(filename));

			while(file.hasNext())
			{
				word[i] = file.nextLine();
				i++;
			}
		}
		catch(Exception e){}

		int num = (int) (Math.random()*i) + 1;

		return word[num];
	}
}

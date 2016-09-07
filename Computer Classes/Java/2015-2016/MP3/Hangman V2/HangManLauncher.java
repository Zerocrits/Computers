//Madison Miatke
<<<<<<< HEAD
//HangMan Launcher
//Spec: Play Hangman
=======
//Car Lot Launcher
//Spec: Utilizes car lot in a gui program
>>>>>>> origin/master

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
<<<<<<< HEAD
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class HangManLauncher extends JFrame implements ActionListener
{
	//Objects
	private HangMan game;
	private ImageIcon icon;
=======
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.border.Border;



public class HangManLauncher extends JFrame implements ActionListener
{
	private HangMan game;
>>>>>>> origin/master

	//Buttons and labels
	private JLabel guessedWord;
	private JButton newWord;
	private JButton giveUp;
	private JLabel drawingSpace;
	private JButton[] letters;
<<<<<<< HEAD
=======
	private ImageIcon icon;
>>>>>>> origin/master

	public static void main(String[] args)
	{
		new HangManLauncher();
	}

	public HangManLauncher()
	{
<<<<<<< HEAD
		//Objects for use
		game = new HangMan();
		Border blkBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
		Border redBorder = BorderFactory.createLineBorder(Color.RED, 3);
		Color bg =  new Color(102, 204, 51);

		//Make main window
		JFrame window = new JFrame("Hang Man");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Hang Man");
		window.setSize(800,600);
		window.setLocationRelativeTo(null);

		//Main Panel
		JPanel userInterface = new JPanel();
		userInterface.setLayout(new BorderLayout());

		//Button Panel - Right Side Window
		JPanel east = new JPanel();
=======
		game = new HangMan();
		Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
		JFrame window = new JFrame("Hang Man");
		window.setBackground(new Color(255,0,0));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Hang Man");
		window.setSize(800,600);

		Color bg =  new Color(102, 204, 51);



		//Center on Screen
		window.setLocationRelativeTo(null);

		JPanel userInterface = new JPanel();
		userInterface.setLayout(new BorderLayout());

		JPanel east = new JPanel();
		east.setOpaque(true);
      	east.setBackground(bg);
>>>>>>> origin/master
		east.setLayout(new GridLayout(9,2));
		letters = new JButton[26];
		for(int i = 0; i < 26; i++)
		{
			letters[i] = new JButton(Character.toString ((char) (i+65)));
			letters[i].addActionListener(this);
<<<<<<< HEAD
			letters[i].setBorder(blkBorder);
			east.add(letters[i]);
		}
		newWord = new JButton("New Word");
		newWord.setBorder(redBorder);
		newWord.addActionListener(this);
		east.setOpaque(true);
		east.setBackground(bg);
		east.add(newWord);

		//Word Lable - Top of Window
		JPanel north = new JPanel();
=======
			east.add(letters[i]);
		}
		newWord = new JButton("New Word");
		newWord.addActionListener(this);
		east.add(newWord);

		JPanel north = new JPanel();
		north.setOpaque(true);
      	north.setBackground(bg);
>>>>>>> origin/master
		guessedWord = new JLabel(game.getWordSoFar(),SwingConstants.CENTER);
		guessedWord.setFont(new Font("Times Roman", Font.PLAIN, 60));
		guessedWord.setOpaque(true);
		guessedWord.setBackground(bg);
<<<<<<< HEAD
		north.setOpaque(true);
		north.setBackground(bg);
      	north.add(guessedWord);

		//Picture Lable - Center/Left of Window
		JPanel center = new JPanel();
		drawingSpace = new JLabel("", SwingConstants.CENTER);
		drawingSpace.setIcon(game.guiDrawing());
		center.setOpaque(true);
		center.setBackground(bg);
		center.setLayout(new GridLayout(0,1));
		center.add(drawingSpace);

		//Add Panels to Main Panel
=======
		north.add(guessedWord);

		JPanel center = new JPanel();
		center.setOpaque(true);
      	center.setBackground(bg);
		center.setLayout(new GridLayout(0,1));
		icon = new ImageIcon("imageTest.jpg");
		drawingSpace = new JLabel("", SwingConstants.CENTER);
		drawingSpace.setIcon(game.guiDrawing());
		center.add(drawingSpace);

>>>>>>> origin/master
		userInterface.add(center, BorderLayout.CENTER);
		userInterface.add(north, BorderLayout.NORTH);
		userInterface.add(east, BorderLayout.EAST);

<<<<<<< HEAD
		//Create Window and make Visable
		window.add(userInterface);
=======
		window.add(userInterface);

>>>>>>> origin/master
		window.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
<<<<<<< HEAD
		//Listen To Buttons
=======
>>>>>>> origin/master
		for(int i = 0; i < 26; i++)
		{
			if(e.getSource() == letters[i])
			{
				letters[i].setEnabled(false);
				game.guessLetter((char) (i+97));
			}
		}

<<<<<<< HEAD
		//Listen To New Word
=======
>>>>>>> origin/master
		if(e.getSource() == newWord)
		{
			for(int i = 0; i < 26; i++)
				letters[i].setEnabled(true);
			game.newWord();
		}

<<<<<<< HEAD
		//Refresh Picture and Word Labels
		guessedWord.setText(game.getWordSoFar());
		drawingSpace.setIcon(game.guiDrawing());

		//Check For Winner or Loser
		if(game.win())
=======
		guessedWord.setText(game.getWordSoFar());
		drawingSpace.setIcon(game.guiDrawing());


		if(game.win())
		{
>>>>>>> origin/master
			JOptionPane.showMessageDialog(new JFrame(),
			    "YOU WIN CONGRATS!",
			    "Winner",
   				JOptionPane.PLAIN_MESSAGE);
<<<<<<< HEAD

=======
		}
>>>>>>> origin/master
		if(game.lose())
		{
			guessedWord.setText(game.getWord());
			JOptionPane.showMessageDialog(new JFrame(),
				"YOU GOT HUNG! THE WORD WAS '" + game.getWord() + "'!",
				"Loser",
				JOptionPane.PLAIN_MESSAGE);
		}
	}
}

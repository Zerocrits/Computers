import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JFrame
{
	private JLabel lblName,lblTitle;
	private JButton btnHowto;
	private JButton btnStart1, btnStart2, btnStart3;
	final int APPLET_WIDTH = 500, APPLET_HEIGHT = 300;
	private ButtonListener listener;
	private Game game;

	public MainMenu()
	{
		Container cp = getContentPane();
		cp.setBackground(Color.cyan);
		cp.setLayout(new GridLayout(0,1,10,10));

		lblName = new JLabel("Running Man", JLabel.CENTER);
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		btnHowto = new JButton("How To Play");
		btnHowto.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		btnStart3 = new JButton("Insane");
		btnStart3.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnStart2 = new JButton("Hard");
		btnStart2.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnStart1 = new JButton("Easy");
		btnStart1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));

		cp.add(lblName);
		cp.add(btnHowto);
		cp.add(btnStart1);
		cp.add(btnStart2);
		cp.add(btnStart3);

		listener = new ButtonListener();
		btnHowto.addActionListener(listener);
		btnStart1.addActionListener(listener);
		btnStart2.addActionListener(listener);
		btnStart3.addActionListener(listener);

		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		MainMenu menu = new MainMenu();
	}

	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			// find out what object was pressed:
			Object source = new Object();
			source = event.getSource();

			if(source == btnStart1)
			{
				Game game = new Game("Running Man", 1000,600,3); //Insane
				game.start();
			}
			else if(source == btnStart2)
			{
				Game game = new Game("Running Man", 1000,600,2); //Hard
				game.start();
			}
			else if(source == btnStart3)
			{
				Game game = new Game("Running Man", 1000,600,1); //Easy
				game.start();
			}
			else if(source == btnHowto)
			{
				JOptionPane.showMessageDialog(null, "It's an easy to play game, press the up arrow to jump");
			}
		}
	}
}
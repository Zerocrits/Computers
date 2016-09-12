import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;

public class Game extends JFrame
{
	public int width, height;
	public String title;
	private JFrame frame;
	private JLabel lblTitle;
	private Player player1, player2;
	private int score1, score2;
	private Graphics g;
	private ButtonListener listener;

	public static void main(String[] args)
	{
		Game game = new Game("Family Feud", 600, 600);
	}

	public Game(String title, int width, int height)
	{
		// Get window and set layout
		setLayout(new BorderLayout());
		add(new JLabel("Family1: " + score1 + " Family2: " + score2), BorderLayout.NORTH);
		add(new Button("Type Answers Here"), BorderLayout.SOUTH);
		add(new Button("Player2"), BorderLayout.EAST);
		add(new Button("Player1"), BorderLayout.WEST);
		add(new Button("harvey/game"), BorderLayout.CENTER);

		this.width = width;
		this.height = height;
		this.title = title;

		listener = new ButtonListener();

		setSize(1200,800);
		setVisible(true);

	}

	// private inner class for handling button events
	// action listener requires actionPerformed method
	private class ButtonListener implements ActionListener
	{
		String strNum = "";
		public void actionPerformed(ActionEvent event)
		{
			Object source = new Object();
			source = event.getSource();

			/*if(source == btnSoda)
			{
				restaurant.addSoda();
			}
			else if (source == btnCompleteorder)
			{
				restaurant.getTotal();
				JOptionPane.showMessageDialog(null,"Total Comes to: $" + numberFormat.format(restaurant.getTotal()) + "!");
				restaurant.clearOrder();
			}
			lblTotal.setText(restaurant.toString());
			lblTotalfood.setText(restaurant.getFood());
			// Add code to randomly play sounds based on a button click*/
		}
	}
}
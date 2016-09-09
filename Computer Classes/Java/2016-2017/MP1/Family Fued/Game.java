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
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.setBackground(Color.gray);

		this.width = width;
		this.height = height;
		this.title = title;

		lblTitle = new JLabel("test");

		cp.add(lblTitle);

		listener = new ButtonListener();

		setSize(550,560);
		setVisible(true);
		setResizable(false);
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
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
	private JPanel panel1, panel2, panel3, panel4;
	private JLabel lblTitle;
	private Player player1, player2;
	private BufferStrategy bs;
	private int score1, score2;
	private Graphics g;
	private ButtonListener listener;

	public static void main(String[] args)
	{
		Game game = new Game("Family Feud", 1200, 800);
	}

	public Game(String title, int width, int height)
	{
		// Get window and set layout
		setLayout(new BorderLayout());

		// Init
		player1 = new Player();

		// West Player 1
		panel1 = new JPanel();
		panel1.setBackground(Color.gray);
		panel1.add(player1.render(g));
		add(panel1, BorderLayout.WEST);

		// East Player 2
		panel2 = new JPanel();
		panel2.setBackground(Color.gray);
		add(panel2, BorderLayout.EAST);

		// Center Harvey/Screen
		panel3 = new JPanel();
		panel3.setBackground(Color.red);
		add(panel3, BorderLayout.CENTER);

		// Type Answer
		panel4 = new JPanel();
		panel4.setBackground(Color.gray);
		add(panel4, BorderLayout.SOUTH);



		add(new JLabel("Family1: " + score1 + " Family2: " + score2), BorderLayout.NORTH);

		this.width = width;
		this.height = height;
		this.title = title;

		listener = new ButtonListener();

		setSize(width,height);
		setVisible(true);

	}

	private void render()
	{
		bs = getBufferStrategy();
		try {
			 imgBackground = ImageIO.read(new File("Character.JPG"));
		}catch (IOException e) {

			e.printStackTrace();
			System.exit(1);
		}

		g.drawImage(Character,0,0,null);

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
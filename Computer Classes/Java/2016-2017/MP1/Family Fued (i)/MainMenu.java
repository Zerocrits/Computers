import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JFrame
{
	private JLabel lblName,lblTitle;
	private JButton btnHowto;
	private JButton btnStart;
	final int APPLET_WIDTH = 500, APPLET_HEIGHT = 300;
	private ButtonListener listener;
	private Game game;

	public MainMenu()
	{
		Container cp = getContentPane();
		cp.setBackground(Color.cyan);
		cp.setLayout(new GridLayout(0,1,10,10));

		lblName = new JLabel("Family Feud", JLabel.CENTER);
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		btnHowto = new JButton("How To Play");
		btnHowto.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		btnStart = new JButton("Play");
		btnStart.setFont(new Font("Comic Sans MS", Font.BOLD, 16));

		cp.add(lblName);
		cp.add(btnHowto);
		cp.add(btnStart);

		listener = new ButtonListener();
		btnHowto.addActionListener(listener);
		btnStart.addActionListener(listener);

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

			if(source == btnStart)
			{
				Game game = new Game("Family Feud", 1000,600);
				game.start();
			}
			else if(source == btnHowto)
			{
				JOptionPane.showMessageDialog(null, "I need to add this wait...");
			}
		}
	}
}
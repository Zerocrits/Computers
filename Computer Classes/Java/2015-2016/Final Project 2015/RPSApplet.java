// Bill Joseph
// Rock Paper Scissors
// Spec: Rock Paper Scissors

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;// for AudioClip
import java.util.Random;

public class RPSApplet extends JFrame
{
	private JButton btnGo;
	private JLabel lblTotal, lblTitle, lblRPS, lblOutput;
	private JRadioButton rdoRock, rdoPaper, rdoScissors;
	private ImageIcon icoRPS;
	private RPS game;
	private JTextField txtGame;
	private ButtonGroup grpButtons;
	private ButtonListener listener;

	public static void main(String[] args)
	{
		RPSApplet foo = new RPSApplet();
	}

	public RPSApplet()
	{
		// Get window and set layout
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());

		// Instantiate ALL of the objects
		lblTitle = new JLabel("          Rock Paper Scissors          ");
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblTotal = new JLabel();
		icoRPS = new ImageIcon("RPS.png");
		btnGo = new JButton("          Play!          ");
		rdoRock = new JRadioButton("Rock                   ");
		rdoPaper = new JRadioButton("Paper                   ");
		rdoScissors = new JRadioButton("Scissors                   ");
		grpButtons = new ButtonGroup();
		lblRPS = new JLabel();
		// Create button Listener
		listener = new ButtonListener();
		game = new RPS();

		// Set the icon for our label (display the icoPig picture)
		lblRPS.setIcon(icoRPS);

		// Add the ActionListener to each of the buttons
		//rdoRock.addActionListener(listener);
		//rdoPaper.addActionListener(listener);
		//rdoScissors.addActionListener(listener);
		//btnGo.addActionListener(listener);

		// Add all the objects to the window in the order you want them to appear
		cp.add(lblTitle);
		cp.add(lblTotal);
		cp.add(lblRPS);
		cp.add(rdoRock);
		cp.add(rdoPaper);
		cp.add(rdoScissors);
		cp.add(btnGo);

		btnGo.addActionListener(listener);

		grpButtons.add(rdoRock);
		grpButtons.add(rdoPaper);
		grpButtons.add(rdoScissors);

		// Set size of window and make it visible
		setSize(550,300);
		setVisible(true);
		setResizable(false);
	}

	// private inner class for handling button events
    // action listener requires actionPerformed method
	private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
			// find out what object was pressed:
			Object source = new Object();
			source = event.getSource();
			if(source == btnGo)
			{
				if(rdoRock.isSelected())
				{
					game.setUser("Rock");
				}
				else if(rdoPaper.isSelected())
				{
					game.setUser("Paper");
				}
				else if(rdoScissors.isSelected())
				{
					game.setUser("Scissors");
				}
				game.setResultCPU();
				game.getResult();
				lblTotal.setText(game.getTotal());
				JOptionPane.showMessageDialog(null,game.toString());
			}
		}
	}
}

//Program is dedicated to Mr. A, This would not have been possible without him.
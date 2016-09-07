//Bill Joseph
//Java Application Pack
//Spec: Build A Java Program Pack with several different programs

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;// for AudioClip
import java.util.Random;
import javax.swing.JApplet;

public class Javaloader extends JApplet
{
	private JButton btnenter;
	private JLabel lblTitle;
	private ButtonListener listener;
	private Hangman game;
	private JRadioButton rone, rtwo, rthree;

	public void init()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5,1));

		lblTitle = new JLabel("Program Selector");
		lblTitle.setFont(new Font("Comic Sans MC", Font.BOLD, 26));
		panel.add(lblTitle);
		rone = new JRadioButton(" Hang Man ");
		rtwo = new JRadioButton(" Rock Paper Scissors ");
		rthree = new JRadioButton(" Food Order ");
		ButtonGroup gr = new ButtonGroup();
		gr.add(rone);
		gr.add(rtwo);
		gr.add(rthree);
		panel.add(rone);
		panel.add(rtwo);
		panel.add(rthree);
		btnenter = new JButton(" Enter ");
		panel.add(btnenter);

		listener = new ButtonListener();

		btnenter.addActionListener(listener);

		Container c = getContentPane();
		c.add(panel, BorderLayout.NORTH);

		setSize(550,175);
		setVisible(true);
	}

	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Object source = new Object();
			source = event.getSource();


			if(rone.isSelected())
			{
				Hangman game = new Hangman();
			}
			else if(rtwo.isSelected())
			{
				RPSApplet foo = new RPSApplet();
			}
			else if(rthree.isSelected())
			{
				FoodOrderApplet foos = new FoodOrderApplet();
			}
		}
	}
}



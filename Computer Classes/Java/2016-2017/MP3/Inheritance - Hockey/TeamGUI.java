//Bill Joseph
//Hockey Team
//Spec: Build A Inheritance Hockey Team

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TeamGUI extends JFrame
{
	private int APPLET_WIDTH = 300, APPLET_HEIGHT = 470;
	private JLabel lblTitle;
	//private JLabel;
	//private ImageIcon;
	//private JButton;
	private ButtonListener listener;

	public TeamGUI()
	{
		Container cp = getContentPane();
		cp.setBackground(Color.gray);
		cp.setLayout(new FlowLayout());

		lblTitle = new JLabel("  Hockey Team Creator"  );
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		//btnPull = new JButton ("     Pull Me!     ");
		//btnPull.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		//btnPull.addActionListener( new ButtonListener());

		//icoDice = new ImageIcon("lblDice.PNG");

		//slot = new SlotMachine();
		//lblTitle = new JLabel("    Slot Machine    ");
		//lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 26));

		listener = new ButtonListener();

		//lblDice.setIcon(icoDice);

		//cp.add(lblTitle);

		//lblBlank.setText("                     ");

		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		TeamGUI gui = new TeamGUI();
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

			//if(source == btnPull)
			{
				//word1 = getDelay();

				//switch(word1)
				//{
				//}

				//lblCoins.setText("Coins: $" + coins);
			}//if
		}//actionPerformed()
	}//inner class
}
//Bill Joseph
//Slot Machine
//Spec: Build A Slot Machine

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SlotGUI extends JFrame
{
	private int APPLET_WIDTH = 300, APPLET_HEIGHT = 220;
	private int coins = 0;
	private JLabel lblCoins, lblTitle, lblString;
	private JButton btnPull;
	private SlotMachine slot;
	private ButtonListener listener;

	public SlotGUI()
	{
		Container cp = getContentPane();
		cp.setBackground(Color.red);
		cp.setLayout(new FlowLayout());

		coins = 0;

		btnPull = new JButton ("     Pull Me!     ");
		btnPull.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		btnPull.addActionListener( new ButtonListener());

		slot = new SlotMachine();
		lblTitle = new JLabel("    Slot Machine    ");
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblCoins = new JLabel("Coins: 0");
		lblCoins.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblString = new JLabel();
		lblString.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		listener = new ButtonListener();

		cp.add(lblTitle);
		cp.add(btnPull);
		cp.add(lblString);
		cp.add(lblCoins);

		btnPull.addActionListener(listener);

		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		SlotGUI gui = new SlotGUI();
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
			if(source == btnPull)
			{
				slot.spinAll();
				lblString.setText(slot.toString());
				coins = coins + slot.getPayout();
				lblCoins.setText("Coins: " + coins);
			}
		}
	}
}
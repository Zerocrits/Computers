//Bill Joseph
//Slot Machine
//Spec: Build A Slot Machine

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SlotGUI extends JFrame
{
	private int APPLET_WIDTH = 300, APPLET_HEIGHT = 470;
	private int coins = 0;
	private int i = 0;
	private String word1 = "";
	private String word2 = "";
	private String word3 = "";
	private JLabel lblCoins, lblTitle, lblDice, lblCherry, lblSeven, lblBar, lblBlank1, lblBlank2, lblBlank3;
	private JLabel lblInfo1, lblInfo2, lblInfo3, lblInfo4, lblBlank;
	private ImageIcon icoDice, icoCherry, icoSeven, icoBar, icoBlank1, icoBlank2, icoBlank3;
	private JButton btnPull;
	private SlotMachine slot;
	private ButtonListener listener;

	public SlotGUI()
	{
		Container cp = getContentPane();
		cp.setBackground(Color.cyan);
		cp.setLayout(new FlowLayout());

		coins = 0;

		btnPull = new JButton ("     Pull Me!     ");
		btnPull.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		btnPull.addActionListener( new ButtonListener());

		icoDice = new ImageIcon("lblDice.PNG");
		icoCherry = new ImageIcon("lblCherry.PNG");
		icoSeven = new ImageIcon("lblSeven.PNG");
		icoBar = new ImageIcon("lblBar.PNG");
		icoBlank1 = new ImageIcon("lblBlank.PNG");
		icoBlank2 = new ImageIcon("lblBlank.PNG");
		icoBlank3 = new ImageIcon("lblBlank.PNG");

		slot = new SlotMachine();
		lblDice = new JLabel();
		lblCherry = new JLabel();
		lblSeven = new JLabel();
		lblBar = new JLabel();
		lblBlank1 = new JLabel();
		lblBlank2 = new JLabel();
		lblBlank3 = new JLabel();
		lblTitle = new JLabel("    Slot Machine    ");

		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblCoins = new JLabel("Coins: 0");
		lblCoins.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblInfo1 = new JLabel();
		lblInfo1.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblInfo2 = new JLabel();
		lblInfo2.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblInfo3 = new JLabel();
		lblInfo3.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblInfo4 = new JLabel();
		lblInfo4.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblBlank = new JLabel();
		lblBlank.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		listener = new ButtonListener();

		lblDice.setIcon(icoDice);
		lblCherry.setIcon(icoCherry);
		lblSeven.setIcon(icoSeven);
		lblBar.setIcon(icoBar);
		lblBlank1.setIcon(icoBlank1);
		lblBlank2.setIcon(icoBlank2);
		lblBlank3.setIcon(icoBlank3);

		cp.add(lblTitle);
		cp.add(lblBlank1);
		cp.add(lblBlank2);
		cp.add(lblBlank3);
		cp.add(btnPull);
		cp.add(lblCoins);
		cp.add(lblBlank);
		cp.add(lblInfo1);
		cp.add(lblInfo2);
		cp.add(lblInfo3);
		cp.add(lblInfo4);

		lblBlank.setText("                     ");
		lblInfo1.setText("Bar = $100");
		lblInfo2.setText("Cherry = $500");
		lblInfo3.setText("Dice = $1,000");
		lblInfo4.setText("Seven = $10,000");

		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		SlotGUI gui = new SlotGUI();
	}
	public String getDelay()
	{
		String word = "";
		while(i <= 4)
		{
			Thread.sleep(250);
			switch(i)
			{
				case 1: word = "Bar"; break;
				case 2: word = "Cherry"; break;
				case 3: word = "Dice"; break;
				case 4: word = "7"; break;
			}
			i++;
			return word;
		}
		return word;
	}

	// private inner class for handling button events
    // action listener requires actionPerformed method
	private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)  catch InterruptedException
        {
			// find out what object was pressed:
			Object source = new Object();
			source = event.getSource();

			if(source == btnPull)
			{
				word1 = getDelay();
				word2 = slot.spin2();
				word3 = slot.spin3();
				switch(word1)
				{
					case "Bar": lblBlank1.setIcon(icoBar); break;
					case "Cherry": lblBlank1.setIcon(icoCherry); break;
					case "Dice": lblBlank1.setIcon(icoDice); break;
					case "7": lblBlank1.setIcon(icoSeven); break;
				}
				switch(word2)
				{
					case "Bar": lblBlank2.setIcon(icoBar); break;
					case "Cherry": lblBlank2.setIcon(icoCherry); break;
					case "Dice": lblBlank2.setIcon(icoDice); break;
					case "7": lblBlank2.setIcon(icoSeven); break;
				}
				switch(word3)
				{
					case "Bar": lblBlank3.setIcon(icoBar); break;
					case "Cherry": lblBlank3.setIcon(icoCherry); break;
					case "Dice": lblBlank3.setIcon(icoDice); break;
					case "7": lblBlank3.setIcon(icoSeven); break;
				}
				coins = coins + slot.getPayout();
				lblCoins.setText("Coins: $" + coins);
			}//if
		}//actionPerformed()
	}//inner class
}
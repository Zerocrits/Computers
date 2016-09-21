import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorGUI extends JFrame
{
	private int APPLET_WIDTH = 300, APPLET_HEIGHT = 220;
	private JLabel lblString;
	private JButton btnEnter;
	private JTextField txtInsert;
	private BinaryConverter binary;
	private ButtonListener listener;

	public CalculatorGUI()
	{
		Container cp = getContentPane();
		cp.setBackground(Color.red);
		cp.setLayout(new FlowLayout());

		btnEnter = new JButton ("     Enter!     ");
		btnEnter.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		btnEnter.addActionListener( new ButtonListener());

		binary = new BinaryConverter();
		txtInsert = new JTextField(8);
		lblString = new JLabel();
		listener = new ButtonListener();

		cp.add(lblString);
		cp.add(txtInsert);
		cp.add(btnEnter);

		btnEnter.addActionListener(listener);

		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		CalculatorGUI gui = new CalculatorGUI();
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
			if(source == btnEnter)
			{
				String phrase = txtInsert.getText();
				lblString.setText(binary.getValue(phrase));
			}
		}
	}
}
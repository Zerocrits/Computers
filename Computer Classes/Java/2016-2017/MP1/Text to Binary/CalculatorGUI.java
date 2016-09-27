import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorGUI extends JFrame
{
	private int APPLET_WIDTH = 900, APPLET_HEIGHT = 800, choice = 0;
	private JLabel lblBinary, lblOctal, lblDecimal, lblHex, lblTitle, lblBox1;
	private JButton btnEnter;
	private JTextField txtInsert, txtBinary, txtOctal, txtDecimal, txtHex;
	private JRadioButton rdoBinary1, rdoBinary2, rdoChoice1, rdoChoice2, rdoChoice3, rdoChoice4;
	private BinaryConverter binary;
	private ButtonGroup grpButtons1, grpButtons2;
	private ButtonListener listener;

	public CalculatorGUI()
	{
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());

		btnEnter = new JButton ("     Enter!     ");
		btnEnter.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnEnter.addActionListener( new ButtonListener());

		binary = new BinaryConverter();
		txtBinary = new JTextField(50);
		txtBinary.setEditable(false);
		txtOctal = new JTextField(50);
		txtOctal.setEditable(false);
		txtDecimal = new JTextField(50);
		txtDecimal.setEditable(false);
		txtHex = new JTextField(50);
		txtHex.setEditable(false);
		txtInsert = new JTextField(15);
		lblBinary = new JLabel("  Binary Conversion:");
		lblBinary.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblOctal = new JLabel("   Octal Conversion:");
		lblOctal.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblDecimal = new JLabel("Decimal Conversion:");
		lblDecimal.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblHex = new JLabel("    Hex Conversion:");
		lblHex.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblTitle = new JLabel("                    Conversions                    ");
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
		lblBox1 = new JLabel("Select Binary Type:");
		lblBox1.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		listener = new ButtonListener();

		Box box1 = Box.createVerticalBox();
		grpButtons1 = new ButtonGroup();
		rdoBinary1 = new JRadioButton("Numerical");
		rdoBinary2 = new JRadioButton("ASCII");

		rdoBinary1.setEnabled(false);
		rdoBinary2.setEnabled(false);
		btnEnter.setEnabled(false);

		box1.add(lblBox1);
		box1.add(rdoBinary1);
		box1.add(rdoBinary2);

		grpButtons1.add(rdoBinary1);
		grpButtons1.add(rdoBinary2);

		Box box2 = Box.createVerticalBox();
		grpButtons2 = new ButtonGroup();
		rdoChoice1 = new JRadioButton("Binary");
		rdoChoice2 = new JRadioButton("Octal");
		rdoChoice3 = new JRadioButton("Decimal");
		rdoChoice4 = new JRadioButton("Hex");

		box2.add(rdoChoice1);
		box2.add(rdoChoice2);
		box2.add(rdoChoice3);
		box2.add(rdoChoice4);

		grpButtons2.add(rdoChoice1);
		grpButtons2.add(rdoChoice2);
		grpButtons2.add(rdoChoice3);
		grpButtons2.add(rdoChoice4);

		cp.add(lblTitle);
		cp.add(lblBinary);
		cp.add(txtBinary);
		cp.add(lblOctal);
		cp.add(txtOctal);
		cp.add(lblDecimal);
		cp.add(txtDecimal);
		cp.add(lblHex);
		cp.add(txtHex);
		cp.add(box1);
		cp.add(box2);
		cp.add(txtInsert);
		cp.add(btnEnter);

		btnEnter.addActionListener(listener);
		rdoChoice1.addActionListener(listener);
		rdoChoice2.addActionListener(listener);
		rdoChoice3.addActionListener(listener);
		rdoChoice4.addActionListener(listener);

		grpButtons1.add(rdoBinary1);
		grpButtons1.add(rdoBinary2);

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
			if(!(txtInsert.getText().equals("")))
			{
				btnEnter.setEnabled(true);

				if(source == btnEnter)
				{
					String phrase = txtInsert.getText();
					txtBinary.setText(binary.getValue(phrase, choice));
				}
				if(rdoChoice2.isSelected())
				{
					rdoBinary1.setEnabled(false);
					rdoBinary2.setEnabled(false);

				}

				if(rdoChoice3.isSelected())
				{
					rdoBinary1.setEnabled(false);
					rdoBinary2.setEnabled(false);

				}

				if(rdoChoice4.isSelected())
				{
					rdoBinary1.setEnabled(false);
					rdoBinary2.setEnabled(false);

				}
			}
			if(rdoChoice1.isSelected())
			{
				rdoBinary1.setEnabled(true);
				rdoBinary2.setEnabled(true);
				if(rdoBinary1.isSelected())
				{
					choice = 1;
				}
				else
				{
					choice = 2;
				}
			}
		}
	}
}
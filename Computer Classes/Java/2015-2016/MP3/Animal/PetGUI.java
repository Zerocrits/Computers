//Bill Joseph
//Pet GUI
//Spec: Build A PetGUI

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PetGUI extends JFrame
{
	private int APPLET_WIDTH = 350, APPLET_HEIGHT = 470;
	private JLabel lblTitle, lblDog, lblLoudDog, lblCat, lblName;
	private ImageIcon icoDog, icoLoudDog, icoCat;
	private JButton btnDog, btnLoudDog, btnCat, btnAllSpeak;
	private JTextField txtInput;
	private JTextArea txtAllSpeak;
	//private SlotMachine slot;
	private ButtonListener listener;

	public PetGUI()
	{
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());

		btnDog = new JButton ("   Dog   ");
		btnDog.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnLoudDog = new JButton ("  Loud Dog ");
		btnLoudDog.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnAllSpeak = new JButton ("                       Speak                       ");
		btnAllSpeak.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnCat = new JButton ("   Cat   ");
		btnCat.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnDog.addActionListener( new ButtonListener());
		btnLoudDog.addActionListener( new ButtonListener());
		btnCat.addActionListener( new ButtonListener());
		btnAllSpeak.addActionListener( new ButtonListener());

		icoDog = new ImageIcon("lblDog.PNG");
		icoLoudDog = new ImageIcon("lblLoudDog.PNG");
		icoCat = new ImageIcon("lblCat.PNG");

		lblDog = new JLabel();
		lblLoudDog = new JLabel();
		lblCat = new JLabel();
		lblName = new JLabel();

		txtInput = new JTextField(20);
		txtAllSpeak = new JTextArea();
		txtAllSpeak.setEditable(false);
		lblTitle = new JLabel("       Pet GUI       ");
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		listener = new ButtonListener();

		lblDog.setIcon(icoDog);
		lblLoudDog.setIcon(icoLoudDog);
		lblCat.setIcon(icoCat);
		lblName.setText("Name: ");

		cp.add(lblTitle);
		cp.add(lblDog);
		cp.add(lblLoudDog);
		cp.add(lblCat);
		cp.add(lblName);
		cp.add(txtInput);
		cp.add(btnDog);
		cp.add(btnLoudDog);
		cp.add(btnCat);
		cp.add(btnAllSpeak);
		cp.add(txtAllSpeak);

		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		PetGUI gui = new PetGUI();
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
			String name = "";
			Kennel kennel = new Kennel();

			if(source == btnDog)
			{
				name = txtInput.getText();
				Dog dog = new Dog(name);
				kennel.addPet(dog);
				txtAllSpeak.append(kennel.allSpeak());
			}

			else if(source == btnLoudDog)
			{
				name = txtInput.getText();
				LoudDog loud = new LoudDog(name);
				kennel.addPet(loud);
				txtAllSpeak.append(kennel.allSpeak());
			}

			else if(source == btnCat)
			{
				name = txtInput.getText();
				Cat cat = new Cat(name);
				kennel.addPet(cat);
				txtAllSpeak.append(kennel.allSpeak());
			}

			else if(source == btnAllSpeak)
			{
				Dog dog = new Dog("Ruby");
				LoudDog loud = new LoudDog("Buddy");
				Cat cat = new Cat("John");

				kennel.addPet(dog);
				kennel.addPet(loud);
				kennel.addPet(cat);

				txtAllSpeak.append(kennel.allSpeak());

			}
			txtInput.setText("");
		}//actionPerformed()
	}//inner class
}
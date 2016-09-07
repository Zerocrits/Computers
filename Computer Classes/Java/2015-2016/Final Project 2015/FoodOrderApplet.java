// Bill Joseph
// PiggyBankApplet
// Spec: 	GUI front end for PiggyBank class
//			Has buttons, labels, and randomized audioclips on click event

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Random;

public class FoodOrderApplet extends JFrame
{
	DecimalFormat numberFormat = new DecimalFormat("#.00");
	private JButton btnSoda, btnPizza, btnFries, btnSalad, btnBread, btnClearorder, btnCompleteorder;
	private JLabel lblTotal, lblFood, lblTitle, lblTotalfood;
	private ImageIcon icoFood;
	private FoodOrder restaurant;
	private JTextField txtCompleteorder;
	private ButtonListener listener;

	public static void main(String[] args)
	{
		FoodOrderApplet foo = new FoodOrderApplet();
	}
	public FoodOrderApplet()
	{
		// Get window and set layout
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());

		// Instantiate ALL of the objects
		lblTitle = new JLabel("     White Castle     ");
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblTotal = new JLabel();
		lblTotalfood = new JLabel();
		icoFood = new ImageIcon("Food.png");
		btnPizza = new JButton("Pizza");
		btnFries = new JButton("Fries");
		btnSalad = new JButton("Salad");
		btnBread = new JButton("Bread");
		btnSoda = new JButton("Soda");
		btnClearorder = new JButton("Clear Order");
		btnCompleteorder = new JButton("Complete Order");
		txtCompleteorder = new JTextField();
		lblFood = new JLabel();
		// Create button Listener
		listener = new ButtonListener();

		// Set the icon for our label (display the icoPig picture)
		lblFood.setIcon(icoFood);

		// Add the ActionListener to each of the buttons
		btnSoda.addActionListener(listener);
		btnPizza.addActionListener(listener);
		btnFries.addActionListener(listener);
		btnSalad.addActionListener(listener);
		btnBread.addActionListener(listener);
		btnClearorder.addActionListener(listener);
		btnCompleteorder.addActionListener(listener);

		// Add all the objects to the window in the order you want them to appear
		cp.add(lblTitle);
		cp.add(lblTotal);
		cp.add(lblTotalfood);
		cp.add(lblFood);
		cp.add(btnClearorder);
		cp.add(btnSoda);
		cp.add(btnPizza);
		cp.add(btnFries);
		cp.add(btnSalad);
		cp.add(btnBread);
		cp.add(btnCompleteorder);

		// Set size of window and make it visible
		setSize(550,560);
		setVisible(true);
		setResizable(false);
	}

	// private inner class for handling button events
    // action listener requires actionPerformed method
	private class ButtonListener implements ActionListener
    {
		FoodOrder restaurant = new FoodOrder();
		String strNum = "";
        public void actionPerformed(ActionEvent event)
        {
			Object source = new Object();
			source = event.getSource();

			if(source == btnSoda)
			{
				restaurant.addSoda();
			}
			else if (source == btnPizza)
			{
				restaurant.addPizza();
			}
			else if (source == btnFries)
			{
				restaurant.addFries();
			}
			else if (source == btnSalad)
			{
				restaurant.addSalad();
			}
			else if (source == btnBread)
			{
				restaurant.addBread();
			}
			else if (source == btnClearorder)
			{
				restaurant.clearOrder();
			}
			else if (source == btnCompleteorder)
			{
				restaurant.getTotal();
				JOptionPane.showMessageDialog(null,"Total Comes to: $" + numberFormat.format(restaurant.getTotal()) + "!");
				restaurant.clearOrder();
			}
			lblTotal.setText(restaurant.toString());
			lblTotalfood.setText(restaurant.getFood());
			// Add code to randomly play sounds based on a button click
		}
	}
}

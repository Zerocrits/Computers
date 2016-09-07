import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Random;

public class restaurantApplet extends JFrame
{
	DecimalFormat numberFormat = new DecimalFormat("#.00");
	private JButton btnClearorder, btnCompleteorder;
	private JLabel lblTotal, lblFood, lblTitle, lblTotalfood, lblMeals;
	private ImageIcon icoFood;
	private Inventory restaurant;
	private JTextField txtOrder, txtMeals;
	private ButtonListener listener;

	String burgers, dogs, soda, salad, total, word;
	int burgerNum, dogsNum, sodaNum, saladNum, totalNum;

	public static void main(String[] args)
	{
		restaurantApplet foo = new restaurantApplet();
	}
	public restaurantApplet()
	{
		burgerNum = dogsNum = sodaNum = saladNum = totalNum = 0;
		dogs = "Hot-Dogs: " + dogsNum;
		burgers = "Burgers: " + burgerNum;
		salad = "Salads: " + saladNum;
		soda = "Sodas: " + sodaNum;
		totalNum = sodaNum + saladNum + burgerNum + dogsNum;
		total = "Total: " + totalNum;

		// Get window and set layout
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());

		// Instantiate ALL of the objects
		lblTitle = new JLabel("     White Castle     ");
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblTotal = new JLabel();
		lblTotalfood = new JLabel();
		icoFood = new ImageIcon("fastfood.png");
		txtOrder = new JTextField(40);
		btnClearorder = new JButton("                    Restart                    ");
		btnCompleteorder = new JButton("                    Enter                    ");
		lblMeals = new JLabel("<html>" + burgers + "<br>" + dogs + "<br>" + soda + "<br>" + salad + "<br>" + "-------------" + "<br>" + total + "</html>");
		lblMeals.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblFood = new JLabel();
		// Create button Listener
		listener = new ButtonListener();

		// Set the icon for our label (display the icoPig picture)
		lblFood.setIcon(icoFood);

		// Add the ActionListener to each of the buttons
		btnClearorder.addActionListener(listener);
		btnCompleteorder.addActionListener(listener);

		lblFood.setIcon(icoFood);

		// Add all the objects to the window in the order you want them to appear
		cp.add(lblTitle);
		cp.add(lblTotal);
		cp.add(lblTotalfood);
		cp.add(lblFood);
		cp.add(txtOrder);
		cp.add(btnCompleteorder);
		cp.add(btnClearorder);
		cp.add(lblMeals);
		cp.add(btnClearorder);

		// Set size of window and make it visible
		setSize(550,560);
		setVisible(true);
		setResizable(false);
	}

	// private inner class for handling button events
    // action listener requires actionPerformed method
	private class ButtonListener implements ActionListener
    {
		Inventory restaurant = new Inventory();
		String strOrder = "";
        public void actionPerformed(ActionEvent event)
        {
			Object source = new Object();
			source = event.getSource();
			strOrder = txtOrder.getText();

			if(source == txtOrder)
			{
				restaurant.getOrder(strOrder);
			}

			else if (source == btnCompleteorder)
			{
				restaurant.getOrder(strOrder);
				restaurant.Chosen();
			}
			lblMeals.setText(restaurant.toString());
			//lblTotalfood.setText(restaurant.getFood());
			// Add code to randomly play sounds based on a button click
		}
	}
}

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainMenu extends JFrame
{
	private JFrame frame;
	private JLabel lblTitle;
	private JButton btnStart;
	private Display display;
	private ButtonListener listener;

	public MainMenu()
	{
		Container cp = getContentPane();
		cp.setBackground(Color.red);
		cp.setLayout(new FlowLayout());

		lblTitle = new JLabel("Midi Hero Client");
		btnStart = new JButton("   Start   ");

		listener = new ButtonListener();
		btnStart.addActionListener(listener);

		btnStart.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 40));

		cp.add(lblTitle);
		cp.add(btnStart);

		setSize(400, 200);
		setVisible(true);
		setFocusable(false);
		setResizable(false);
	}

	public static void main(String[] args)
	{
		new MainMenu();
	}

	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
        {
			// find out what object was pressed:
			Object source = new Object();
			source = event.getSource();

			if(source == btnStart)
			{
				//dispose();
				display = new Display(800, 500, "eyeoftiger");
				//String[] args = {};
				//Display.main(args);
			}
		}
	}
}
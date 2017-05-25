import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends JFrame
{
	private JLabel lblTitle;
	private JButton btnStart;
	private MidiHeroGUI gui;

	public MainMenu()
	{
		Container cp = getContentPane();
		cp.setBackground(Color.red);
		cp.setLayout(new FlowLayout());

		lblTitle = new JLabel("Midi Hero Client");
		btnStart = new JButton("   Start   ");

		btnStart.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 40));

		cp.add(lblTitle);
		cp.add(btnStart);

		btnStart.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent me)
			{
				startProgram();
			}
		});


		setSize(400, 200);
		setVisible(true);
		setResizable(false);
	}

	public static void main(String[] args)
	{
		MainMenu menu = new MainMenu();

		//Game game = new Game(800, 500, "Songs/sample.WAV");
		//game.start(); //this works...?
	}

	public void startProgram()
	{
		dispose();
		Game game = new Game(800, 500, "Songs/sample.WAV");
		game.start();
	}
}
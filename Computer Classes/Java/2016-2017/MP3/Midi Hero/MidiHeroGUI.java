import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.*;

/*public class MidiHeroGUI
{
	public static void main(String[] args)
	{
		Display display = new Display("Midi Hero",800,500);
		display.restart();
    }
*/


public class MidiHeroGUI extends JFrame
{

	//private ImageIcon imgMidiHero = new ImageIcon("MidiHero.PNG");
	private JLabel lblTitle;
	private JButton btnStart;
	private ButtonListener listener;
	private Game game;

	public MidiHeroGUI()
	{
		Container cp = getContentPane();
		cp.setBackground(Color.red);
		cp.setLayout(new FlowLayout());

		lblTitle = new JLabel("Midi Hero Client");
		btnStart = new JButton("   Start   ");

		btnStart.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 40));

		listener = new ButtonListener();

		btnStart.addActionListener(listener);

		cp.add(lblTitle);
		cp.add(btnStart);

		setSize(400, 200);
		setVisible(true);
		setResizable(false);
	}

	public static void main(String[] args)
	{
		MidiHeroGUI gui = new MidiHeroGUI();
	}

	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Object source = new Object();
			source = event.getSource();
			if(source == btnStart)
			{
				Display display = new Display("Midi Hero",800,500);
				display.restart();
			}
		}
	}
}
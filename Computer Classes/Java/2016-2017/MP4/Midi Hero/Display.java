import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;

public class Display
{
	public JFrame frame;
	private Canvas canvas;
	private String title;
	private int width, height;

	public Display(int width, int height)
	{
		title = "Midi Hero";
		this.width = width;
		this.height = height;

		createDisplay();
	}

	private void createDisplay()
	{
		//Creates frame
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		//Creates canvas
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);

		//adds canvas to frame
		frame.add(canvas);
		frame.pack();
	}

	public Canvas getCanvas()
	{
		return canvas;
	}

	public JFrame getFrame()
	{
		return frame;
	}

	public void youLose()
	{
		JOptionPane.showMessageDialog(frame, "You Have lost!\nPress OK to restart!", "You Lose!", JOptionPane.ERROR_MESSAGE);
		frame.setVisible(true);
		restart();
	}

	public void restart()
	{
		frame.dispose();
		Game game = new Game(800, 500, "sample");
		game.start();
	}
}
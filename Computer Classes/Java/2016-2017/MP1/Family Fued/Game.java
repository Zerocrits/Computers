import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;

public class Game
{
	private Display display;
	public int width, height;
	public String title;
	private boolean running;
	private Thread thread;
	private Player player1, player2;
	private int score1, score2;
	private BufferStrategy bs;
	private Graphics g;
	private BufferedImage imgBackground;

	public Game(String title, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.title = title;
	}

	private void reset()
	{
		display.getFrame().dispose();
		score1=score2=0;
		init();
	}
	private void init()
	{
		display = new Display(title, width, height);

		display.getFrame();
	}

	public Display getDisplay()
	{
		return display;
	}

	public void render()
	{
		//canvas
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();

		//reset screen
		g.clearRect(0,0,width,height);

		//draws background, player, wall
		try {
			 imgBackground = ImageIO.read(new File("Background.PNG"));
		}catch (IOException e) {

			e.printStackTrace();
			System.exit(1);
		}

		g.drawImage(imgBackground,0,0,null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Serif", Font.BOLD, 50));

		bs.show();
		g.dispose();
	}
	public void start()
	{
		render();
	}
}
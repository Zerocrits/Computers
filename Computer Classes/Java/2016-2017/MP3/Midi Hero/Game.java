import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;

public class Game implements Runnable
{
	private Display display;
	public int width, height, highscore;
	public String title;
	private boolean isPlaying;
	private Thread thread;
	private ArrowLogic logic;
	private Arrow arrow;
	private Marker marker;
	private int score;
	private BufferStrategy bs;
	private Graphics g;
	private BufferedImage imgBackground;

	public Game(int width, int height)
	{
		isPlaying = false;
		this.width = width;
		this.height = height;
		title = "MidiHero";
		arrow = new Arrow();
		marker = new Marker();
		score = highscore = 0;
	}

	private void init()
	{
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(arrow);
	}

	public Display getDisplay()
	{
		return display;
	}

	public void tick()
	{
		arrow.tick();
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

		//draws background, arrow,
		try {
			 imgBackground = ImageIO.read(new File("pictures/Background.PNG"));
		}catch (IOException e) {

			e.printStackTrace();
			System.exit(1);
		}

		g.drawImage(imgBackground,0,0,null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Serif", Font.BOLD, 20));

		g.drawString("Score: " + addScore(), 10, 50);
		marker.render(g);
		arrow.render(g);

		//displays image(buffered image)
		bs.show();
		g.dispose();
	}

	public void run()
	{
		init();

		//timer with frames
		final double fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();

		while(isPlaying)
		{
			now = System.nanoTime();
			delta +=(now - lastTime) / timePerTick;
			lastTime = now;
			if(delta >= 1)
			{
				tick();
				render();
				delta--;
			}
		}
		stop();
	}

	/*START THREAD*/
	public synchronized void start()
	{
		if(isPlaying)
			return;
		isPlaying = true;
		thread = new Thread(this);
		thread.start();
	}

	/*STOP THREAD SAFELY*/
	public synchronized void stop()
	{
		if(!isPlaying)
			return;
		isPlaying = false;
		try{
			thread.join();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public int getHighScore()
	{
		if(highscore < getScore())
			highscore = getScore();
		return highscore;
	}

	public int addScore()
	{
		return arrow.getScore();
	}
	public int getScore()
	{
		//add streak
		if(score<2)
			return 0;
		else
			return score-1;
	}
}
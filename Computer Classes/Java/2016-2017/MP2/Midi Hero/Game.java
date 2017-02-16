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
	private boolean moving;
	private Thread thread;
	private Arrow arrow;
	private Marker marker;
	private int score;
	private BufferStrategy bs;
	private Graphics g;
	private BufferedImage imgBackground;

	public Game(int width, int height)
	{
		this.width = width;
		this.height = height;
		title = "MidiHero";
		arrow = new Arrow(this);
		marker = new Marker(this);
		score = highscore = 0;
	}

	private void init()
	{
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(marker);
	}

	public Display getDisplay()
	{
		return display;
	}

	public void tick()
	{
		arrow.tick(); //timers for arrow
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

		g.drawString("Score: " + getScore(), 10, 50);
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

		while(moving)
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
		if(moving)
			return;
		moving = true;
		thread = new Thread(this);
		thread.start();
	}

	/*STOP THREAD SAFELY*/
	public synchronized void stop()
	{
		if(!moving)
			return;
		moving = false;
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
		score += 4;
		return score;
	}
	public int getScore()
	{
		//add streak
		if(score<2)
			return 0;
		else
			return score-1;
	}

	public Arrow getArrow()
	{
		return arrow;
	}
}
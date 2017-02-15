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
	public int width, height, gamesetting, highscore;
	public String title;
	private boolean running;
	private Thread thread;
	private Player player;
	private Wall wall;
	private int score;
	private BufferStrategy bs;
	private Graphics g;
	private BufferedImage imgBackground;

	public Game(String title, int width, int height, int gamesetting)
	{
		running = false;
		this.width = width;
		this.height = height;
		this.title = title;
		this.gamesetting = gamesetting;
		player = new Player(this);
		wall = new Wall(this, gamesetting);
		score = highscore = 0;
	}

	private void reset()
	{
		display.getFrame().dispose();
		player = new Player(this);
		wall = new Wall(this, gamesetting);
		score=0;
		init();
	}
	private void init()
	{
		display = new Display(title, width, height);

		display.getFrame().addKeyListener(player);
	}

	public Display getDisplay()
	{
		return display;
	}

	public void tick()
	{
		//timers for player and wall
		player.tick();
		wall.tick();
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

		g.drawString("Score: " + getScore(), 100, 100);
		g.drawString("High Score: " + getHighScore(), 550, 100);
		player.render(g);
		wall.render(g);

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

		while(running)
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
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	/*STOP THREAD SAFELY*/
	public synchronized void stop()
	{
		if(!running)
			return;
		running = false;
		try{
			thread.join();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void addScore()
	{
		score++;
	}

	public int getHighScore()
	{
		if(highscore < getScore())
			highscore = getScore();
		return highscore;
	}

	public int getScore()
	{
		if(score<2)
			return 0;
		else
			return score-1;
	}

	public void hitDetect()
	{
		if(player.getFrame().intersects(wall.getFrame()))
		{
			int input = JOptionPane.showOptionDialog(null, "You have died, Want to try again?", "YOU LOSE!", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

			if(input == JOptionPane.YES_OPTION)
			{
				reset();
			}
			else
			{
				display.getFrame().dispose();
				System.exit(0);
				stop();
			}
   		}
	}
}
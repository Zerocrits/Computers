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
		score = highscore = 0;
	}

	private void reset()
	{
		display.getFrame().dispose();
		arrow = new Arrow(this);
		score=0;
		init();
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
		//timers for arrow and wall
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

		//reset screen
		g.clearRect(0,0,width,height);

		//draws background, arrow,
		try {
			 imgBackground = ImageIO.read(new File("Background.PNG"));
		}catch (IOException e) {

			e.printStackTrace();
			System.exit(1);
		}

		g.drawImage(imgBackground,0,0,null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Serif", Font.BOLD, 20));

		g.drawString("Score: " + getScore(), 10, 50);
		arrow.render(g);

		//displays image(buffered image)
		bs.show();
		g.dispose();
		hitDetect();
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
				//System.out.println(delta);
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

	public int getScore()
	{
		score = arrow.getScore();
		if(score<2)
			return 0;
		else
			return score-1;
	}

	public void hitDetect()
	{
		//if(arrow.getFrame().intersects(wall.getFrame()))
		//{
			/*int input = JOptionPane.showOptionDialog(null, "You have died, Want to try again?", "YOU LOSE!", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

			if(input == JOptionPane.YES_OPTION)
			{
				reset();
			}
			else
			{
				display.getFrame().dispose();
				System.exit(0);
				stop();
			}*/
   		//}
	}
}
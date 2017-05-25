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
	public String title, song;
	private boolean isPlaying;
	private Thread thread;
	private ArrowLogic logic;
	private Arrow arrow;
	private Marker marker;
	private PlayMusic music;
	private int score;
	private BufferStrategy bs;
	private Graphics g;

	public Game(int width, int height, String song)
	{
		isPlaying = false;
		this.width = width;
		this.height = height;
		arrow = new Arrow();
		marker = new Marker();
		music = new PlayMusic();
		score = highscore = 0;
		this.song = "Songs/" + song + ".WAV";
	}

	private void init()
	{
		display = new Display(width, height);
		display.getFrame().addKeyListener(arrow);
		display.getFrame().addKeyListener(marker);
	}

	public Display getDisplay()
	{
		return display;
	}

	public void tick()
	{
		arrow.tick();
		render();
		gameLost();
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

		g.setColor(Color.WHITE);
		g.setFont(new Font("Serif", Font.BOLD, 20));

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
		music.startSong(song);
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

	public void gameLost()
	{
		if(arrow.checkWon() == false)
		{
			isPlaying = false;
			music.stopSong();
			display.youLose();
		}
	}
}
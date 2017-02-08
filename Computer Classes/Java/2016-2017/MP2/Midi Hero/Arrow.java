import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.lang.*;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.event.KeyListener;
import java.awt.Rectangle;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.io.FileReader;

public class Arrow implements KeyListener
{
	private int y, upY, downY, leftY, rightY;
	private int x, upX, downX, leftX, rightX;
	private int score, speed, multiplyer;
	public int global, spot, length, print;
	public int[][] keys;
	public int[] keysY, side;
	private BufferedImage imgLeft, imgRight, imgDown, imgUp;
	private boolean upPressed, downPressed, leftPressed, rightPressed;

    public Arrow(Game game)
    {
		try {
			 imgLeft = ImageIO.read(new File("leftArrow.PNG"));
			 imgRight = ImageIO.read(new File("rightArrow.PNG"));
			 imgUp = ImageIO.read(new File("upArrow.PNG"));
			 imgDown = ImageIO.read(new File("downArrow.PNG"));
		}catch (IOException e) {

			e.printStackTrace();
			System.exit(1);
		}

		keys = new int[getLength()][2]; //may need to be 1?
		keysY = new int[keys.length];
		side = new int[keys.length];

		setDefault();
		readKeys();

		print = 0;
		global = 0;
		length = 0;
		spot = 0;
		y = 30;
        upX = 190;
        downX = 260;
        leftX = 120;
        rightX = 330;
    }

    public int getLength()
    {
		String filename = "Song-keys/sample.txt";
		System.out.println("getLength()");
		try
		{
			LineNumberReader size = new LineNumberReader(new FileReader(new File(filename)));
			Scanner file = new Scanner(new File(filename));
			size.skip(Long.MAX_VALUE);
			length = (size.getLineNumber()/2)+1;
			size.close(); //prevent resource leak
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return length;
	}

    public void readKeys()
    {
		String filename = "Song-keys/sample.txt";
		System.out.println("readKeys()");
		try
		{
			LineNumberReader size = new LineNumberReader(new FileReader(new File(filename)));
			Scanner file = new Scanner(new File(filename));
			size.skip(Long.MAX_VALUE);
			length = (size.getLineNumber()/2)+1;

			for(int i = 0; i < length-2; i++)
			{
				System.out.println(spot);
				keys[i][0] = file.nextInt();//needs to only get next once
				keys[i][1] = file.nextInt();

				System.out.println(keys[i][0] + "this is 0"); //delete
				System.out.println(keys[i][1] + "this is 1");

			}
			size.close(); //prevent resource leak
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void placeKeys()
	{
		System.out.println("******************"+spot+"*********************");
		if(setTime(keys[spot][1]) == true)
		{
			side[spot] = setSide(keys[spot][0]);
			System.out.println(keys[spot][0]);
			System.out.println(keys[spot][1]);
			spot++;
		}
	}
	public boolean setTime(int tick)
	{
		boolean timer = false;
		if(timer == false)
		{
			if(tick == global)//cant access keys
			{
				System.out.println("time got" + tick + "time needed:"+global);
				return true;
			}
		}
		return timer;
	}

	public int setSide(int side)
	{
		System.out.println("Side: " + side);
		return side;
	}

	public void setSpot()
	{
		System.out.println("length: " + length);
		for(int i = 0; i < length-1; i++)
		{
			keysY[i] += -3;
		}
	}

	public void setDefault()//make so as this is called it sets it
	{
		for(int i = 0; i < length-1; i++)
		{
			keysY[i] = 300;
		}
	}

	//checks location and uses timer
	public void tick()
	{
		global++;
		System.out.println("Global: " + global);
		placeKeys();
		setSpot();
	}

	public void render(Graphics g)
	{
		System.out.println("got to render" + keysY[0]);
		for(int i = 0; i <= spot; i++)
		{
			if(side[i] == 0)
				g.drawImage(imgUp,upX,keysY[spot],null);
			else if(side[i] == 1)
				g.drawImage(imgDown,downX,keysY[spot],null);
			else if(side[i] == 2)
				g.drawImage(imgLeft,leftX,keysY[spot],null);
			else if(side[i] == 3)
				g.drawImage(imgRight,rightX,keysY[spot],null);
		}
	}

    public void keyPressed(KeyEvent e)
    {
		for(int i = 0; i < keys.length; i++)
		{
			if (e.getKeyCode() == KeyEvent.VK_UP)
			{

			}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN)
			{

			}
			else if (e.getKeyCode() == KeyEvent.VK_LEFT)
			{

			}
			else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			{

			}
		}
    }

    public void keyReleased(KeyEvent e)
    {
		if (e.getKeyCode() == KeyEvent.VK_UP)
        {
			upPressed=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			downPressed=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			leftPressed=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			rightPressed=false;
        }
    }
    public void keyTyped(KeyEvent e)
	{
	}
}
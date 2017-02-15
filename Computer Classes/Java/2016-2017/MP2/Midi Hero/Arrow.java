import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.lang.*;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.Rectangle;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.io.FileReader;

public class Arrow
{
	private int x;
	private int score, speed, multiplyer, spot;
	private int global, length, min;
	private int[][] keys;
	private int[] keysY, side;
	private BufferedImage imgLeft, imgRight, imgDown, imgUp;
	private boolean upPressed, downPressed, leftPressed, rightPressed;

	public Arrow()
	{
	}

    public Arrow(Game game)
    {
		try {
			 imgLeft = ImageIO.read(new File("pictures/leftArrow.PNG"));
			 imgRight = ImageIO.read(new File("pictures/rightArrow.PNG"));
			 imgUp = ImageIO.read(new File("pictures/upArrow.PNG"));
			 imgDown = ImageIO.read(new File("pictures/downArrow.PNG"));
		}catch (IOException e) {

			e.printStackTrace();
			System.exit(1);
		}

		spot = 1;
		keys = new int[getLength()][2]; //may need to be 1?
		keysY = new int[keys.length];
		side = new int[keys.length];

		readKeys();
		x = 120;
    }

    public int getLength()
    {
		String filename = "Song-keys/sample.txt";
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
		System.out.println("****"+global+"****");
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

	public int sideHere()
	{
		int test = 55;
		return test;

	}

	public void setSpot()
	{
		System.out.println("length: " + length);
		for(int i = min; i < spot; i++)
		{
			if(keysY[min] < -110) //decreases size of for loops
			{
				keysY[min] = -500;
				min++;
			}
			if(i == spot-1)
				keysY[i] = 300;
			else
				keysY[i] += -3;
		}
	}

	public int getSpot()
	{
		//keysY[0] = 555;
		System.out.println(length+"hello"+spot);
		return spot;
	}

	public void setLocation()
	{
		keysY[getSpot()] = -110;
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
		for(int i = min; i < spot; i++)
		{
			if(side[i] == 0)
				g.drawImage(imgLeft,x,keysY[i],null);
			else if(side[i] == 1)
				g.drawImage(imgUp,x+70,keysY[i],null);
			else if(side[i] == 2)
				g.drawImage(imgDown,x+140,keysY[i],null);
			else if(side[i] == 3)
				g.drawImage(imgRight,x+210,keysY[i],null);
		}
	}
}
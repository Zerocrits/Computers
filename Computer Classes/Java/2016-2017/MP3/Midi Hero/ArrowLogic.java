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

public class ArrowLogic
{
	private int spot = 1;
	private int global, length;
	private int min = 0;;
	private int[][] keys;
	private int[] keysY, side;

    public ArrowLogic(Game game)
    {
		keys = new int[getLength()][2]; //may need to be 1?
		keysY = new int[keys.length];
		side = new int[keys.length];

		readKeys();
    }

    public ArrowLogic(){}

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
				//System.out.println(spot);
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
		//System.out.println("******************"+spot+"*********************");
		//System.out.println("****"+global+"****");
		if(setTime(keys[spot][1]) == true)
		{
			side[spot] = getSide(keys[spot][0]);
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
				//System.out.println("time got" + tick + "time needed:"+global);
				return true;
			}
		}
		return timer;
	}

	public void setSpot()
	{
		//System.out.println("length: " + length);
		//System.out.println(spot+"THISISSPOTA");
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
		//System.out.println(length+"hello"+spot);
		return spot;
	}

	public int getGlobal()
	{
		return global;
	}

	public void setLocation()
	{
		keysY[getSpot()] = -110;
	}

	public int getKeys(int i, int j)
	{
		return keys[i][j];
	}

	public int getKeysY(int i)
	{
		System.out.println(keysY[i]);
		return keysY[i];
	}

	public int getSide(int i)
	{
		//System.out.println("Side: " + side[i]);
		return side[i];
	}

	public int getMin()
	{
		return min;
	}

	//checks location and uses timer
	public void tick()
	{
		global++;
		//System.out.println("Global: " + global);
		placeKeys();
		setSpot();
		System.out.println(getKeysY(0));
	}
}
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
	private int min = 0;
	public int[][] keys;
	public int[] keysY, side;

    public ArrowLogic()
    {
		keys = new int[getLength()][2]; //may need to be 1?
		keysY = new int[getLength()];
		side = new int[getLength()];
		readKeys();
    }

    //public ArrowLogic(){}

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
				keysY[i] = 600;
				side[i] = -1;
				keys[i][0] = file.nextInt();
				keys[i][1] = file.nextInt();
				System.out.println(keys[i][0]);
				System.out.println(keys[i][1]);
				System.out.println(keysY[i]);
				System.out.println(side[i]);
			}
			size.close(); //prevent resource leak
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void placeKeys()
	{
		if(setTime(keys[spot][1]) == true)
		{
			side[spot] = getSide(keys[spot][0]);
			System.out.println(keys[spot][0]);
			spot++;
			//System.out.println(spot+"spot went up");
		}
	}
	public boolean setTime(int tick)
	{
		boolean timer = false;
		if(timer == false)
		{
			//System.out.println(tick+"got em"+global);
			if(tick == global)
				return true;
		}
		return timer;
	}

	public void setSpot()
	{
		for(int i = min; i <= spot; i++)
		{
			if(keysY[i] < -110) //decreases size of forloop
			{
				//System.out.println(min+"got here"+spot);
				keysY[i] = -500;
				min++;
			}
			else
			{
				System.out.println(i+"hello?" + keysY[i]);
				keysY[i] += -3;
			}
		}
	}

	public int getSpot()
	{
		return spot;
	}

	public int getGlobal()
	{
		return global;
	}

	public int getKeysY(int i)
	{
		int key = keysY[i];
		return key;
	}

	public int getSide(int i)
	{
		int direction = side[i];
		return direction;
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
		//System.out.println(getKeysY(min));
	}
}
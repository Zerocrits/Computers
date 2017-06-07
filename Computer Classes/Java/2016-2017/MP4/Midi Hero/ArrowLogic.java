import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
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

public class ArrowLogic extends ImageChooser
{
	private int spot = 0;
	public int global = -191;
	private int length;
	private int min = 0;
	public String filename;
	public int[][] keys;
	public int[] keysY, side, keyTime;
	public boolean devMode = false;
	private File file;
	private PrintWriter bw;
	private FileWriter fw;
	public int k = 0;
	public int o = 0;
	public int temp = 0;

    public ArrowLogic()
    {
		if(devMode == false)
		{
			keys = new int[getLength()][2];
			keysY = new int[getLength()];
			side = new int[getLength()];
			keyTime = new int[getLength()];
			super.getLength(getLength());
			readKeys();
		}
		if(devMode == true)
		{
			side = new int[5000];
			keyTime = new int[5000];
		}

    }

    public int getLength()
    {
		filename = "Song-keys/eyeofthetiger.txt";
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
		filename = "Song-keys/eyeofthetiger.txt";
		try
		{
			LineNumberReader size = new LineNumberReader(new FileReader(new File(filename)));
			Scanner file = new Scanner(new File(filename));
			size.skip(Long.MAX_VALUE);
			length = (size.getLineNumber()/2)+1;

			for(int i = 0; i < length-2; i++)
			{
				keys[i][0] = file.nextInt();
				keys[i][1] = file.nextInt();//-190;
				side[i] = keys[i][0];
				keyTime[i] = keys[i][1];
				keysY[i] = 600;
				System.out.println(keys[i][0]);
				System.out.println(keys[i][1]);
			}
			size.close(); //prevent resource leak
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void placeKeys()
	{
		if(setTime(keyTime[spot]) == true)
			spot++;
	}
	public boolean setTime(int tick)
	{
		if(tick == global)
			return true;
		return false;
	}

	public int setSpot()
	{
		for(int i = min; i < spot; i++)
		{
			if(keysY[i] <= -3) //decreases size of forloop
			{
				keysY[i] = -100;
				noteHit(-1);
				min++;
			}
			else
				keysY[i] += -3;
			if(i > 0)
				getpos(i);
		}
		return min;
	}

	public boolean checkWon()
	{
		boolean game = true;

		if(lives < 0)
			game = false;

		getResult(game);
		return game;
	}

	public int getKeysY(int i)
	{
		int num = keysY[i];
		return num;
	}

	public int getSide(int i)
	{
		int direction = side[i];
		return direction;
	}

	public int getSpot()
	{
		return spot;
	}

	public int getMin()
	{
		return min;
	}

	//checks location and uses timer
	public void tick()
	{
		global++;
		System.out.println("Global: " + global);
		if(devMode == false)
		{
			placeKeys();
			setSpot();
		}
	}

	public void devModeTime(int length)
	{
		int i = length;
		if(i != -1)
		{
			keyTime[i] = global;
			temp = i;
		}
		else
			startDevMode(temp);

	}

	public void startDevMode(int i)
	{
		//creator = new SongCreator(side, keyTime, "Song-keys/devtest1.txt");
		String filename = "Song-keys/eyeofthetiger.txt";

		try {

			bw = new PrintWriter(new FileWriter(filename, true));
			while(k <= i)
			{
				if(keyTime[k] != 0)
				{
					bw.println(side[k]);
					bw.println(keyTime[k]+-190);
					System.out.println(side[k] + "\nhi" + keyTime[k]+-190 + "\n");
					k++;
				}
			}
			bw.close();


		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
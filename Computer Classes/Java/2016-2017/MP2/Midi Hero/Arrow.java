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
	private int[][] keys;
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

		String[][] keys = new String[readKeys()][1];

		y = 30;
        upX = 190;
        downX = 260;
        leftX = 120;
        rightX = 330;
    }

    public int readKeys()
    {
		String filename = "Song-keys/sample.txt";
		int[][] keys;
		int length = 0;;
		System.out.println("Made it herelol");
		try
		{
			LineNumberReader size = new LineNumberReader(new FileReader(new File(filename)));
			Scanner file = new Scanner(new File(filename));
			size.skip(Long.MAX_VALUE);
			length = (size.getLineNumber()/2)+1;
			keys = new int[length][2];

			for(int i = 0; i < length-2; i++)
			{
				keys[i][0] = file.nextInt();
				keys[i][1] = file.nextInt();
				System.out.println(keys[i][0]);
				System.out.println(keys[i][1]);
			}

			size.close(); //prevent resource leak
		}
		catch(Exception e){
			e.printStackTrace();
		}

		return length;
	}

	//checks location and uses timer
	public void tick()
	{

	}

	public void render(Graphics g)
	{
		//for(int i = 0; i < keys.length; i++)
		//{
			//int side = whatSide(false,i);
			/*if(side == 0)
				g.drawImage(imgUp,upX,y2[i],null);
			else if(side == 1)
				g.drawImage(imgDown,downX,y2[i],null);
			else if(side == 2)
				g.drawImage(imgLeft,leftX,y2[i],null);
			else if(side == 3)
				g.drawImage(imgRight,rightX,y2[i],null);*/
		//}
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
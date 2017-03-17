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
import java.awt.event.KeyListener;

public class Arrow extends ArrowLogic implements KeyListener
{
	private int score, speed, multiplyer, x;
	private int spot, min;
	private BufferedImage imgLeft, imgRight, imgDown, imgUp;
	private boolean upPressed, downPressed, leftPressed, rightPressed;

    public Arrow()
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

		x = 120;
    }

	public void tick()
	{
		super.tick();
	}

	public int getScore()
	{
		return score;
	}

	public void render(Graphics g)
	{
		spot = getSpot();
		min = getMin();
		for(int i = min; i < spot; i++)
		{
			System.out.println("\n*****Side: " + side[i]);
			System.out.println("***KeysY: " + keysY[i]);

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

    public void keyPressed(KeyEvent e)
    {
		spot = getSpot();
		min = getMin();

		if(e.getKeyCode() == KeyEvent.VK_W)
			upPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_A)
			leftPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_S)
			downPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_D)
			rightPressed == true;

















		for(int i = min; i <= spot; i++)
		{
			if(e.getKeyCode() == KeyEvent.VK_W)
			{
				if(side[i] == 1)
				{
					if(e.getKeyCode() == KeyEvent.VK_ENTER)
					{
						if((keysY[i] > 0) && (keysY[i] < 60))
						{
							score++;
							keysY[i] = -100;
						}
					}
				}
			}
			else if (e.getKeyCode() == KeyEvent.VK_S)
			{
				if(side[i] == 2)
				{
					if((keysY[i] > 0) && (keysY[i] < 60))
					{
						score++;
						keysY[i] = -100;
					}
				}
			}
			else if (e.getKeyCode() == KeyEvent.VK_A)
			{
				if(side[i] == 0)
				{
					if((keysY[i] > 0) && (keysY[i] < 60))
					{
						score++;
						keysY[i] = -100;
					}
				}
			}
			else if (e.getKeyCode() == KeyEvent.VK_D)
			{
				if(side[i] == 3)
				{
					if((keysY[i] > 0) && (keysY[i] < 60))
					{
						score++;
						keysY[i] = -100;
					}
				}
			}
			System.out.println(getKeysY(i));
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
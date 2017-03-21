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
	private int score, speed, streak, x;
	private int spot, i;
	private BufferedImage imgLeft, imgRight, imgDown, imgUp;
	private boolean upPressed, downPressed, leftPressed, rightPressed;

    public Arrow()
    {
		try {
			 imgLeft = ImageIO.read(new File("pictures/arrows/leftArrow.PNG"));
			 imgRight = ImageIO.read(new File("pictures/arrows/rightArrow.PNG"));
			 imgUp = ImageIO.read(new File("pictures/arrows/upArrow.PNG"));
			 imgDown = ImageIO.read(new File("pictures/arrows/downArrow.PNG"));
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

	public int getStreak()
	{
		return streak;
	}

	public void render(Graphics g)
	{
		spot = getSpot();
		int min = getMin();
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
		//spot = getSpot();
		i = getMin();

		if(e.getKeyCode() == KeyEvent.VK_W)
			upPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_A)
			leftPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_S)
			downPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_D)
			rightPressed = true;


		if(side[i] == 1)
		{
			if((keysY[i] > 0) && (keysY[i] < 60))
			{
				if(e.getKeyCode() == KeyEvent.VK_SPACE)
				{
					score++;
					streak++;
					keysY[i] = -100;
				}
			}
		}
		if(side[i] == 2)
		{
			if((keysY[i] > 0) && (keysY[i] < 60))
			{
				if(e.getKeyCode() == KeyEvent.VK_SPACE)
				{
					score++;
					streak++;
					keysY[i] = -100;
				}
			}
		}
		if(side[i] == 0)
		{
			if((keysY[i] > 0) && (keysY[i] < 60))
			{
				if(e.getKeyCode() == KeyEvent.VK_SPACE)
				{
					score++;
					streak++;
					keysY[i] = -100;
				}
			}
		}
		if(side[i] == 3)
		{
			if((keysY[i] > 0) && (keysY[i] < 60))
			{
				if(e.getKeyCode() == KeyEvent.VK_SPACE)
				{
					score++;
					streak++;
					keysY[i] = -100;
				}
			}
		}

		if(keysY[i] < -10 && keysY[i] > -30)
			streak = 0;

		System.out.println(getKeysY(i));
    }

    public void keyReleased(KeyEvent e)
    {
		if (e.getKeyCode() == KeyEvent.VK_W)
        {
			upPressed=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S)
		{
			downPressed=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A)
		{
			leftPressed=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D)
		{
			rightPressed=false;
        }
    }
    public void keyTyped(KeyEvent e)
	{

	}
}
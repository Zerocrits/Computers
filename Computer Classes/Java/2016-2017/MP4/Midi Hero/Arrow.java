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
	private int spot, i, x;
	private BufferedImage imgLeft, imgRight, imgDown, imgUp, imgBar;
	private boolean upPressed, downPressed, leftPressed, rightPressed, spacePressed;
	private SongCreator sc;

    public Arrow()
    {
		try {
			 imgLeft = ImageIO.read(new File("pictures/arrows/leftArrow.PNG"));
			 imgRight = ImageIO.read(new File("pictures/arrows/rightArrow.PNG"));
			 imgUp = ImageIO.read(new File("pictures/arrows/upArrow.PNG"));
			 imgDown = ImageIO.read(new File("pictures/arrows/downArrow.PNG"));
			 imgBar = ImageIO.read(new File("pictures/arrows/barArrows.PNG"));
		}catch (IOException e) {

			e.printStackTrace();
			System.exit(1);
		}

		x = 200;
    }

	public void tick()
	{
		super.tick();

		if(devMode == false)
		{
			i = getMin();
			if(keysY[i] < 0 && keysY[i] > -10)
			{
				keysY[i] = -100;
				missNote();
				setMultiplyer();
			}
		}
	}

	public void render(Graphics g)
	{
		super.render(g);
		spot = getSpot();
		int min = getMin();
		for(int i = min; i < spot; i++)
		{
			System.out.println("\n*****Side: " + side[i]);
			System.out.println("***KeysY: " + keysY[i]);

			if(side[i] == 0)
				g.drawImage(imgLeft,x,keysY[i],65,65,null);
			else if(side[i] == 1)
				g.drawImage(imgUp,x+70,keysY[i],65,65,null);
			else if(side[i] == 2)
				g.drawImage(imgDown,x+140,keysY[i],65,65,null);
			else if(side[i] == 3)
				g.drawImage(imgRight,x+210,keysY[i],65,65,null);
			else if(side[i] == 4)
				g.drawImage(imgBar,x,keysY[i],null);
		}
	}

    public void keyPressed(KeyEvent e)
    {
		i = getMin();

		if(e.getKeyCode() == KeyEvent.VK_A)
			leftPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_W)
			upPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_D)
			rightPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_S)
			downPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
			spacePressed = true;

		if(devMode == false)
		{
			if(side[i] == 0 && leftPressed == true)
			{
				if((keysY[i] > 0) && (keysY[i] < 60))
				{
					if(spacePressed == true)
					{
						setStreak();
						setScore();
						keysY[i] = -100;
						spacePressed = false;

					}
				}
			}
			if(side[i] == 1 && upPressed == true)
			{
				if((keysY[i] > 0) && (keysY[i] < 60))
				{
					if(spacePressed == true)
					{
						setStreak();
						setScore();
						keysY[i] = -100;
						spacePressed = false;
					}
				}
			}
			if(side[i] == 2 && downPressed == true)
			{
				if((keysY[i] > 0) && (keysY[i] < 60))
				{
					if(spacePressed == true)
					{
						setStreak();
						setScore();
						keysY[i] = -100;
						spacePressed = false;
					}
				}
			}
			if(side[i] == 3 && rightPressed == true)
			{
				if((keysY[i] > 0) && (keysY[i] < 60))
				{
					if(spacePressed == true)
					{
						setStreak();
						setScore();
						keysY[i] = -100;
						spacePressed = false;
					}
				}
			}
			if(side[i] == 4)
			{
				if((keysY[i] > 0) && (keysY[i] < 60))
				{
					if(spacePressed == true)
					{
						setStreak();
						setScore();
						keysY[i] = -100;
						spacePressed = false;
					}
				}
			}

			System.out.println(getKeysY(i));
		}

		if(devMode == true)
		{
			int j = 0; //note count
			if(leftPressed == true)
			{
				if(spacePressed == true)
				{
					side[j] = 0;
					devModeTime(j);
					j++;
				}
			}
			else if(upPressed == true)
			{
				if(spacePressed == true)
				{
					side[j] = 1;
					devModeTime(j);
					j++;
				}
			}
			else if(downPressed == true)
			{
				if(spacePressed == true)
				{
					side[j] = 2;
					devModeTime(j);
					j++;
				}
			}
			else if(rightPressed == true)
			{
				if(spacePressed == true)
				{
					side[j] = 3;
					devModeTime(j);
					j++;
				}
			}
			else if(spacePressed == true)
			{
				if(spacePressed == true)
				{
					side[j] = 4;
					devModeTime(j);
					j++;
				}
			}
		}
    }

    public void keyReleased(KeyEvent e)
    {
		if(e.getKeyCode() == KeyEvent.VK_W)
			upPressed = false;

        if(e.getKeyCode() == KeyEvent.VK_S)
			downPressed = false;

        if(e.getKeyCode() == KeyEvent.VK_A)
			leftPressed = false;

        if(e.getKeyCode() == KeyEvent.VK_D)
			rightPressed = false;

        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        	spacePressed = false;
    }
    public void keyTyped(KeyEvent e)
	{

	}
}
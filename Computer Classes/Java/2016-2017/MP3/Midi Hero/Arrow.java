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

public class Arrow extends ArrowLogic
{
	private int score, speed, multiplyer, spot, x;
	private int length, min;
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
}
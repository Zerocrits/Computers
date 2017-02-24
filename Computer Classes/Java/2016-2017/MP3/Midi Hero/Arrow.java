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
	private int score, speed, multiplyer, spot, x;
	private int length, min;
	private BufferedImage imgLeft, imgRight, imgDown, imgUp;
	private ArrowLogic logic;
	private boolean upPressed, downPressed, leftPressed, rightPressed;

    public Arrow(Game game)
    {
		logic = new ArrowLogic();

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

	public void render(Graphics g)
	{
		spot = logic.getSpot();
		min = logic.getMin();
		for(int i = min; i < spot; i++)
		{
			System.out.println("KeysY: " + logic.getKeysY(i));
			System.out.println("min: " + logic.getMin());
			System.out.println("Spot: " + logic.getSpot());
			if(logic.getSide(i) == 0)
				g.drawImage(imgLeft,x,logic.getKeysY(i),null);
			else if(logic.getSide(i) == 1)
				g.drawImage(imgUp,x+70,logic.getKeysY(i),null);
			else if(logic.getSide(i) == 2)
				g.drawImage(imgDown,x+140,logic.getKeysY(i),null);
			else if(logic.getSide(i) == 3)
				g.drawImage(imgRight,x+210,logic.getKeysY(i),null);
		}
	}
}
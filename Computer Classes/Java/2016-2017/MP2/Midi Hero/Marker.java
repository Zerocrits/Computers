import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.*;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.event.KeyListener;
import java.awt.Rectangle;

public class Marker implements KeyListener
{
	private int score, speed, multiplyer;
	private int y, x, upX, downX, leftX, rightX;
	private BufferedImage imgUpHit, imgDownHit, imgLeftHit, imgRightHit;
	private Arrow arrow;
	private boolean upPressed, downPressed, leftPressed, rightPressed;

    public Marker(Game game)
    {
		try {
			 imgUpHit = ImageIO.read(new File("upHit.PNG"));
			 imgDownHit = ImageIO.read(new File("downHit.PNG"));
			 imgLeftHit = ImageIO.read(new File("leftHit.PNG"));
			 imgRightHit = ImageIO.read(new File("rightHit.PNG"));
		}catch (IOException e) {

			e.printStackTrace();
			System.exit(1);
		}

		y = 30;
		upX = 190;
		downX = 260;
		leftX = 120;
        rightX = 330;

    }

	public void render(Graphics g)
	{
		g.drawImage(imgUpHit,upX,y,null); //white hitboxes
		g.drawImage(imgDownHit,downX,y,null);
		g.drawImage(imgLeftHit,leftX,y,null);
		g.drawImage(imgRightHit,rightX,y,null);
	}

    public void keyPressed(KeyEvent e)
    {
		int spot = arrow.getSpot();
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			if(arrow.keysY[spot] > 30 && arrow.keysY[spot] < 60) //get rid of loop do minimum then you can just delete it from loop to save data
				arrow.setLocation();
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			/*if(downX == 260)
			{
				game.addScore;
			}*/
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			/*if(leftX == 120)
			{
				game.addScore;
			}*/
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			/*if(rightX == 330)
			{
				game.addScore;
			}*/
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
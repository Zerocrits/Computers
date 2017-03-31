import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.*;
import java.awt.*;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.*;
import java.awt.Rectangle;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Marker implements KeyListener
{
	private int score, speed, multiplyer;
	private int y, x, upX, downX, leftX, rightX, center;
	private int spot, min;
	private boolean upPressed, downPressed, leftPressed, rightPressed;
	private BufferedImage imgUpHit, imgDownHit, imgLeftHit, imgRightHit, imgBackground,
			imgUpSelect, imgRightSelect, imgDownSelect, imgLeftSelect;

    public Marker()
    {
		try {
			 imgBackground = ImageIO.read(new File("pictures/Background.JPG"));
			 imgUpHit = ImageIO.read(new File("pictures/arrows/upHit.PNG"));
			 imgDownHit = ImageIO.read(new File("pictures/arrows/downHit.PNG"));
			 imgLeftHit = ImageIO.read(new File("pictures/arrows/leftHit.PNG"));
			 imgRightHit = ImageIO.read(new File("pictures/arrows/rightHit.PNG"));
			 imgUpSelect = ImageIO.read(new File("pictures/arrows/upSelect.PNG"));
			 imgRightSelect = ImageIO.read(new File("pictures/arrows/rightSelect.PNG"));
			 imgDownSelect = ImageIO.read(new File("pictures/arrows/downSelect.PNG"));
			 imgLeftSelect = ImageIO.read(new File("pictures/arrows/leftSelect.PNG"));
		}catch (IOException e) {

			e.printStackTrace();
			System.exit(1);
		}


		y = 30;
		center = 60;
		leftX = 200;
		upX = leftX+70;
		downX = upX+70;
        rightX = downX+70;

    }

	public void render(Graphics g)
	{
		g.drawImage(imgBackground,0,0,800,600,null); //background

		if(leftPressed == true)
			g.drawImage(imgLeftSelect,leftX,y,65,65,null); //hitboxes
		else
			g.drawImage(imgLeftHit,leftX,y,65,65,null);

		if(upPressed == true)
			g.drawImage(imgUpSelect,upX,y,65,65,null);
		else
			g.drawImage(imgUpHit,upX,y,65,65,null);

		if(downPressed == true)
			g.drawImage(imgDownSelect,downX,y,65,65,null);
		else
			g.drawImage(imgDownHit,downX,y,65,65,null);

		if(rightPressed == true)
			g.drawImage(imgRightSelect,rightX,y,65,65,null);
		else
			g.drawImage(imgRightHit,rightX,y,65,65,null);
	}
    public void keyPressed(KeyEvent e)
    {
		if(e.getKeyCode() == KeyEvent.VK_A)
			leftPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_W)
			upPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_D)
			rightPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_S)
			downPressed = true;
    }

    public void keyReleased(KeyEvent e)
    {
		if(e.getKeyCode() == KeyEvent.VK_A)
			leftPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_W)
			upPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_D)
			rightPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_S)
			downPressed = false;
    }
    public void keyTyped(KeyEvent e)
	{

	}
}
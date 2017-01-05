import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.event.KeyListener;
import java.awt.Rectangle;

public class Arrows implements KeyListener
{
	private int y;
	private int x;
	private int airTime;
	private BufferedImage imgLeft, imgRight, imgDown, imgUp;
	private boolean upPressed, downPressed, leftPressed, rightPressed;

    public Arrow(Game game)
    {
		try {
			 imgLeft = ImageIO.read(new File("leftArrow.PNG"));
			 imgRight = ImageIO.read(new File("leftArrow.PNG"));
			 imgUp = ImageIO.read(new File("leftArrow.PNG"));
			 imgDown = ImageIO.read(new File("leftArrow.PNG"));
		}catch (IOException e) {

			e.printStackTrace();
			System.exit(1);
		}

		x = 40;
        y = 506;
        upPressed=downPressed=leftPressed=rightPressed=false;
    }

    public int getY()
    {
        return y;
    }

    public int getX()
    {
		return x;
	}

	//checks location and uses timer
	public void tick()
	{
		if(upPressed)
		{
			airTime=20;
			jumping=true;
		}

		if(downPressed)
		{
			y-=airTime;
			airTime--;
		}

		if(leftPressed)
		{
			jumping=false;
			falling=true;
			airTime=20;
		}

		if(rightPressed)
		{
			y+=airTime;
			airTime--;
		}
	}

	public Rectangle getFrame() //hitbox
	{
		return new Rectangle(x,y,25,25);
	}

	public void render(Graphics g) //draws player
	{
		g.drawImage(imgPlayer,x,y,null);
	}

    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
			upPressed=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			downPressed=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			leftPressed=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			rightPressed=true;
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
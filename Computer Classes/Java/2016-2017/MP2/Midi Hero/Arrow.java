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

public class Arrow implements KeyListener
{
	private int y, upY, downY, leftY, rightY;
	private int[] y2 = new int[10];
	private int x, upX, downX, leftX, rightX;
	private int score, speed, multiplyer;
	private int[] side = new int[10];
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

		/*for(int i = 0; i < y2.length; i++)
		{
			for(int j = 0; j < y2.length; j++)
			{
				int random = (int) (Math.random()*200)+800;
				y2[j] = random;
				random = (int) (Math.random()*200)+800;
				if((y2[j] > y2[i] && y2[j] - 65 > y2[i]) || (y2[j] < y2[i] && y2[j] + 65 < y2[i]))
					System.out.println("test1111111");
				else
					y2[j] = random;
			}
		}*/
		getLocation();

		y = 30;
        upX = 190;
        downX = 260;
        leftX = 120;
        rightX = 330;
    }

	public Rectangle getFrame() //hitbox
	{
		int side = 0;

		for(int i = 0; i < y2.length; i++)
		{
			if(getSide() == 0)
				side = upX;
			else if(getSide() == 1)
				side = downX;
			else if(getSide() == 2)
				side = leftX;
			else if(getSide() == 3)
				side = rightX;
		}

		return new Rectangle(side,y2[i],80,80);
	}

	public int getSide()
	{
		int side = -1;
		for(int i = 0; i < y2.length; i++)
		{
			int random = (int) (Math.random()*y2.length);
			side = random;
		}
		return side;
	}

	public void getLocation()
	{
		for(int i = 0; i < y2.length; i++)
		{
			if(y2[i] < -60)
			{
				for(int j = 0; j < y2.length; j++)
				{
					int random = (int) (Math.random()*200)+800;
					if((y2[j] > y2[i] && y2[j] - 65 > y2[i]) || (y2[j] < y2[i] && y2[j] + 65 < y2[i]))
						System.out.println("test");
					else
						y2[j] = random;
				}
			}
			else
				y2[i] = y2[i] - 3;
		}
	}

	//checks location and uses timer
	public void tick()
	{
		getLocation();
	}

	public void render(Graphics g)
	{
		for(int i = 0; i < y2.length; i++)
		{
			if(getSide() == 0)
				g.drawImage(imgUp,upX,y2[i],null);
			else if(getSide() == 1)
				g.drawImage(imgDown,downX,y2[i],null);
			else if(getSide() == 2)
				g.drawImage(imgLeft,leftX,y2[i],null);
			else if(getSide() == 3)
				g.drawImage(imgRight,rightX,y2[i],null);
		}
	}

    public void keyPressed(KeyEvent e)
    {
		for(int i = 0; i < y2.length; i++)
		{
			int random = (int) (Math.random()*200)+800;
			System.out.println("end: " + random);
			if (e.getKeyCode() == KeyEvent.VK_UP)
			{
				if(y2[i]<50 && y2[i]>0 && upX == 190)
				{
					y2[i] = -50;
				}
			}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				if(y2[i]<50 && y2[i]>0 && downX == 260)
				{
					y2[i] = -50;
				}
			}
			else if (e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				if(y2[i]<50 && y2[i]>0 && leftX == 120)
				{
					y2[i] = -50;
				}
			}
			else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				if(y2[i]<50 && y2[i]>0 && rightX == 330)
				{
					y2[i] = -50;
				}
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
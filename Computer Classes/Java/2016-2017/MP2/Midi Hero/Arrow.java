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
	private int[] whatSide = new int[10];
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
		for(int i = 0; i < y2.length; i++)
		{
			whatSide(true,i);
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

	public int getSide()
	{
		int random = (int) (Math.random()*4);
		return random;
	}

	public int whatSide(boolean change, int side)
	{
		for(int i = 0; i < y2.length; i++)
		{
			if(change == true && side == i)
			{
				whatSide[i] = getSide();
				return whatSide[i];
			}
			else if(change == false && side == i)
			{
				return whatSide[i];
			}
		}
		return -1;
	}

	public int getY()
	{
		int y = 0;

		for(int i = 0; i < y2.length; i++)
		{

		}

		return y;
	}

	public void getLocation()
	{
		for(int i = 0; i < y2.length; i++)
		{
			int random = (int) (Math.random()*400)+600;
			if(i == 0)
			{
				if(y2[i] - y2[y2.length-1] > 65)
				{
					y2[i] += -3;
					System.out.println(y2[0] + "   asdasASdsadasSDASDAS   " + y2[1]);
				}
				else
				{
					y2[i] = random;
					i--;
				}
			}
			else if(y2[i] > y2[i-1] && i > 0)
			{
				if(y2[i] - y2[i-1] > 65)
				{
					//System.out.println("y2[i-1] - y2[i] > 65");
					System.out.println(y2[i] + "   asdas   " + y2[i-1]);
					y2[i] += -3;
				}
			}
			else if(y2[i-1] > 935 && i > 0)
			{
				//System.out.println("OOPS");
				y2[i-1] = random;
				i--;
			}
			else
			{
				/*if(i == y2.length-1)
				{
					y2[i] = random;
					random = (int) (Math.random()*400)+600;
				}*/
				y2[i] = random;
				i--;
			}
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
			int side = whatSide(false,i);
			if(side == 0)
				g.drawImage(imgUp,upX,y2[i],null);
			else if(side == 1)
				g.drawImage(imgDown,downX,y2[i],null);
			else if(side == 2)
				g.drawImage(imgLeft,leftX,y2[i],null);
			else if(side == 3)
				g.drawImage(imgRight,rightX,y2[i],null);
		}
	}

    public void keyPressed(KeyEvent e)
    {
		for(int i = 0; i < y2.length; i++)
		{
			if (e.getKeyCode() == KeyEvent.VK_UP)
			{
				if(y2[i]<50 && y2[i]>0)
				{
					y2[i] = -50;
					whatSide(true,i);
				}
			}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				if(y2[i]<50 && y2[i]>0)
				{
					y2[i] = -50;
					whatSide(true,i);
				}
			}
			else if (e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				if(y2[i]<50 && y2[i]>0)
				{
					y2[i] = -50;
					whatSide(true,i);
				}
			}
			else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				if(y2[i]<50 && y2[i]>0)
				{
					y2[i] = -50;
					whatSide(true,i);
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
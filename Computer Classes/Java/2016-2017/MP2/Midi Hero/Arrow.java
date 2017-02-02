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
	private int[] y2 = new int[10]; //Y axis for each side
	private int[] whatSide = new int[10]; //chooses side for each arrow
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

	public void getLocation()
	{
		boolean once = false;
		int k = 0;

		while(once == false)
		{
			int random = (int) (Math.random()*400)+700;
			y2[k] = random;
			if(k == y2.length-1)
				once = true;
			k++;
		}
		for(int i = 0; i < y2.length; i++)
		{
			int random = (int) (Math.random()*500)+600;
			if(i == 0)
			{
				if(y2[y2.length-1] > 920)
				{
					System.out.println(i + "     " + y2[i] + "   END IS BIGGER THEN 920 -->  " + y2[y2.length-1]);
					y2[y2.length-1] = random;
					whatSide(true,i);
					i--;
				}
				else if(((y2[i]+1000) - (y2[y2.length-1]+1000)) > 65 && (y2[i] > -300))
				{
					y2[i] += -3;
					System.out.println(i + "     " + ((y2[i]+1000) - (y2[y2.length-1]+1000)));
					System.out.println(i + "     " + y2[i] + "   <-- i=0 SUBTRACT 3   " + y2[y2.length-1]);
				}
				else if(y2[i] > -300)
				{
					System.out.println(i + "     " + y2[i] + "   <-- RANDOM 0   " + y2[y2.length-1]);
					y2[i] = random;
					whatSide(true,i);
					i--;
				}
			}
			/*else if(y2[i-1] > 920)
			{
				System.out.println(i + "     " + y2[i] + "   ABOVE 920 -->   " + y2[i-1]);
				y2[i-1] = random;
				whatSide(true,i);
				i--;
			}
			*/else if(((y2[i]+1000) - (y2[i-1]+1000))> 65 && (y2[i] > -300))
			{
				y2[i] += -3;
				System.out.println(i + "     " + ((y2[i]+1000) - (y2[i-1]+1000)));
				System.out.println(i + "     " + y2[i] + "   <--- SUBTRACT 3   " + y2[i-1]);
			}
			else if(y2[i] < -300)
			{
				System.out.println(i + "     " + y2[i] + "   <--- LESS THAN -300 Y2 RESET   " + y2[i-1]);
				y2[i] = random;
				whatSide(true,i); //check?
				i--;
			}
			/*else
			{
				System.out.println(i + "     " + y2[i] + "  <--- NOT ENOUGH SPACE BETWEEN   " + y2[i-1]);
				y2[i] = random;
				whatSide(true,i);
				i--;
			}*/
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
					y2[i] += -100;
				}
			}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				if(y2[i]<50 && y2[i]>0)
				{
					y2[i] += -100;
				}
			}
			else if (e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				if(y2[i]<50 && y2[i]>0)
				{
					y2[i] += -100;
				}
			}
			else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				if(y2[i]<50 && y2[i]>0)
				{
					y2[i] += -100;
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
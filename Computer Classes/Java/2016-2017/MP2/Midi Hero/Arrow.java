import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.event.KeyListener;
import java.awt.Rectangle;

public class Arrow implements KeyListener
{
	private int y, upY, downY, leftY, rightY;
	private int[] y2 = new int[4];
	private int x, upX, downX, leftX, rightX;
	private int score, speed, multiplyer;
	private String[] side = new String[4];
	private BufferedImage imgLeft, imgRight, imgDown, imgUp, imgUpHit, imgDownHit, imgLeftHit, imgRightHit;
	private boolean upPressed, downPressed, leftPressed, rightPressed;

    public Arrow(Game game)
    {
		try {
			 imgLeft = ImageIO.read(new File("leftArrow.PNG"));
			 imgRight = ImageIO.read(new File("rightArrow.PNG"));
			 imgUp = ImageIO.read(new File("upArrow.PNG"));
			 imgDown = ImageIO.read(new File("downArrow.PNG"));
			 imgUpHit = ImageIO.read(new File("upHit.PNG"));
			 imgDownHit = ImageIO.read(new File("downHit.PNG"));
			 imgLeftHit = ImageIO.read(new File("leftHit.PNG"));
			 imgRightHit = ImageIO.read(new File("rightHit.PNG"));
		}catch (IOException e) {

			e.printStackTrace();
			System.exit(1);
		}

		for(int i = 0; i < y2.length; i++)
		{
			int random = (int) (Math.random()*200)+800;
			y2[i] = random;
		}
		y = 30;
        upX = 190;
        downX = 260;
        leftX = 120;
        rightX = 330;
    }

	public int getScore()
	{
		return score;
	}

	//checks location and uses timer
	public void tick()
	{
		for(int i = 0; i < y2.length; i++)
		{
			if(y2[i] < -60)
			{
				int random = (int) (Math.random()*200)+800;
				y2[i] = random;
			}
			else
				y2[i] = y2[i] - 3;
		}



		/*if(upY < -60)
			upY = random;
		if(downY < -60)
			downY = random;
		if(leftY < -60)
			leftY = random;
		if(rightY < -60)
			rightY = random;*/
		/*upY = upY - 5;
		downY = downY - 5;
		leftY = leftY - 5;
		rightY = rightY - 5;*/
	}

	public void render(Graphics g) //draws player
	{
		g.drawImage(imgUpHit,upX,y,null); //white hitboxes
		g.drawImage(imgDownHit,downX,y,null);
		g.drawImage(imgLeftHit,leftX,y,null);
		g.drawImage(imgRightHit,rightX,y,null);

		for(int i = 0; i < y2.length; i++)
		{
			int random = (int) (Math.random()*2);
			System.out.println("Start: " + random + y2[i]);
			switch(random)
			{
				case 0: side[i] = "left";
				case 1: side[i] = "down";
				case 2: side[i] = "right";
				case 3: side[i] = "up";
			}
			if(side[i] == "up")
				g.drawImage(imgUp,upX,y2[i],null);
			else if(side[i] == "down")
				g.drawImage(imgDown,downX,y2[i],null);
			else if(side[i] == "left")
				g.drawImage(imgLeft,leftX,y2[i],null);
			else if(side[i] == "right")
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
					y2[i] = random;
					score += 10;
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				if(y2[i]<50 && y2[i]>0 && downX == 260)
				{
					y2[i] = random;
					score += 10;
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				if(y2[i]<50 && y2[i]>0 && leftX == 120)
				{
					y2[i] = random;
					score += 10;
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				if(y2[i]<50 && y2[i]>0 && rightX == 330)
				{
					y2[i] = random;
					score += 10;
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
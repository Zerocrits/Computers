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
	private int x, upX, downX, leftX, rightX;
	private int score, speed, multiplyer;
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

		upY = 450;
		downY = 430;
		leftY = 410;
		rightY = 400;
		y = 30;
        upX = 190;
        downX = 260;
        leftX = 120;
        rightX = 330;
        upPressed = downPressed = leftPressed = rightPressed = false;
    }

	public int getScore()
	{
		return score;
	}

	//checks location and uses timer
	public void tick()
	{
		int random = (int) (Math.random()*200)+800;
		if(upY < -60)
			upY = random;
		if(downY < -60)
			downY = random;
		if(leftY < -60)
			leftY = random;
		if(rightY < -60)
			rightY = random;
		upY = upY - 3;
		downY = downY - 3;
		leftY = leftY - 3;
		rightY = rightY - 3;
	}

	public void render(Graphics g) //draws player
	{
		g.drawImage(imgUpHit,upX,y,null); //white hitboxes
		g.drawImage(imgDownHit,downX,y,null);
		g.drawImage(imgLeftHit,leftX,y,null);
		g.drawImage(imgRightHit,rightX,y,null);

		g.drawImage(imgUp,upX,upY,null); //arrows
		g.drawImage(imgDown,downX,downY,null);
		g.drawImage(imgLeft,leftX,leftY,null);
		g.drawImage(imgRight,rightX,rightY,null);

	}

    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
			if(upY<50 && upY>0)
			{
				upY = 700;
				score += 10;
			}
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			if(downY<50 && downY>0)
			{
				downY = 700;
				score += 10;
			}
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if(leftY<50 && leftY>0)
			{
				leftY = 700;
				score += 10;
			}
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if(rightY<50 && rightY>0)
			{
				rightY = 700;
				score += 10;
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
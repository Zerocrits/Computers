import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.event.KeyListener;
import java.awt.Rectangle;

public class Player //implements KeyListener
{
	//private BufferedImage imgPlayer;
	//private boolean upPressed, jumping, falling;
	private int score;

    public Player(Game game)
    {
		score = 0;
    }

    public int getScore()
    {
        return score;
    }

  /*  public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
			upPressed=true;
        }
    }

    public void keyReleased(KeyEvent e)
    {
		if (e.getKeyCode() == KeyEvent.VK_UP)
        {
			upPressed=false;
        }
    }

    public void keyTyped(KeyEvent e)
	{

	}*/ //make it enter
}
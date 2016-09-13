import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.event.KeyListener;
import java.awt.Rectangle;

public class Player
{
	private int score;
	private BufferedImage imgPlayer;

    public Player(Game game)
    {
		try {
			 imgPlayer = ImageIO.read(new File("Character.JPG"));
		}catch (IOException e) {

			e.printStackTrace();
			System.exit(1);
		}
		score = 0;
    }

    public int getScore()
    {
        return score;
    }
	public void render(Graphics g) //draws player
	{
		g.drawImage(imgPlayer,0,0,null);
	}
}
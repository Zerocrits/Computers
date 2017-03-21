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

public class Marker
{
	private int score, speed, multiplyer;
	private int y, x, upX, downX, leftX, rightX, center;
	private int spot, min;
	private BufferedImage imgUpHit, imgDownHit, imgLeftHit, imgRightHit;

    public Marker()
    {
		try {
			 imgUpHit = ImageIO.read(new File("pictures/arrows/upHit.PNG"));
			 imgDownHit = ImageIO.read(new File("pictures/arrows/downHit.PNG"));
			 imgLeftHit = ImageIO.read(new File("pictures/arrows/leftHit.PNG"));
			 imgRightHit = ImageIO.read(new File("pictures/arrows/rightHit.PNG"));
		}catch (IOException e) {

			e.printStackTrace();
			System.exit(1);
		}


		y = 30;
		center = 60;
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
}
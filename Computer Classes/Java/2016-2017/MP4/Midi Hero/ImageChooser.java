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

public class ImageChooser extends MakeScore
{
	private int y, x;
	private BufferedImage imgBoard0, imgBoard1, imgBoard2, imgBoard3, imgBoard4,
			imgBoard5, imgBoard6, imgBoard7, imgBoard8, imgHealth, imgBar;

    public ImageChooser()
    {
		try {
			 imgBoard0 = ImageIO.read(new File("pictures/scoreboard/board00.PNG"));
			 imgBoard1 = ImageIO.read(new File("pictures/scoreboard/board01.PNG"));
			 imgBoard2 = ImageIO.read(new File("pictures/scoreboard/board02.PNG"));
			 imgBoard3 = ImageIO.read(new File("pictures/scoreboard/board03.PNG"));
			 imgBoard4 = ImageIO.read(new File("pictures/scoreboard/board04.PNG"));
			 imgBoard5 = ImageIO.read(new File("pictures/scoreboard/board05.PNG"));
			 imgBoard6 = ImageIO.read(new File("pictures/scoreboard/board06.PNG"));
			 imgBoard7 = ImageIO.read(new File("pictures/scoreboard/board07.PNG"));
			 imgBoard8 = ImageIO.read(new File("pictures/scoreboard/board08.PNG"));
			 imgHealth = ImageIO.read(new File("pictures/scoreboard/health.PNG"));
			 imgBar = ImageIO.read(new File("pictures/scoreboard/line.PNG"));

		}catch (IOException e) {

			e.printStackTrace();
			System.exit(1);
		}
    }

	public void render(Graphics g)
	{
		g.drawImage(imgHealth, 525, 400, 275, 100, null);
		if(lives > 1 && lives < 268)
			g.drawImage(imgBar, 525 + (int)lives, 410, 6, 75, null);
		else if(lives < 1)
			g.drawImage(imgBar, 525, 410, 6, 75, null);
		else if(lives >= 268)
			g.drawImage(imgBar, 525 + 268, 410, 6, 75, null);


		if(streak == 0 || streak == 9 || streak == 18 || streak == 27)
			g.drawImage(imgBoard0, 523, 3, 275, 275, null);
		else if(streak == 1 || streak == 10 || streak == 19 || streak == 28)
			g.drawImage(imgBoard1, 523, 3, 275, 275, null);
		else if(streak == 2 || streak == 11 || streak == 20 || streak == 29)
			g.drawImage(imgBoard2, 523, 3, 275, 275, null);
		else if(streak == 3 || streak == 12 || streak == 21 || streak == 30)
			g.drawImage(imgBoard3, 523, 3, 275, 275, null);
		else if(streak == 4 || streak == 13 || streak == 22 || streak == 31)
			g.drawImage(imgBoard4, 523, 3, 275, 275, null);
		else if(streak == 5 || streak == 14 || streak == 23 || streak == 32)
			g.drawImage(imgBoard5, 523, 3, 275, 275, null);
		else if(streak == 6 || streak == 15 || streak == 24 || streak == 33)
			g.drawImage(imgBoard6, 523, 3, 275, 275, null);
		else if(streak == 7 || streak == 16 || streak == 25 || streak == 34)
			g.drawImage(imgBoard7, 523, 3, 275, 275, null);
		else if(streak == 8 || streak == 17 || streak == 26 || streak >= 35)
			g.drawImage(imgBoard8, 523, 3, 275, 275, null);

		g.drawString("Score: " + score, 10, 50);
		g.drawString("Streak: " + streak, 10, 80);
		g.drawString("Multiplyer: " + multiplyer, 10, 110);
		g.drawString("Lives: " + lives, 10, 130);

		g.setFont(new Font("Impact", Font.PLAIN, 100));
		g.drawString("" + multiplyer, 650,198);
		g.setFont(new Font("Impact", Font.PLAIN, 35));
		g.setColor(Color.BLACK);
		g.drawString("Streak: " + streak, 550,270);
		g.setFont(new Font("Impact", Font.PLAIN, 45));
		g.setColor(Color.WHITE);

		if(score < 10)
			g.drawString(""+score, 770,50);
		else if(score < 100)
			g.drawString(""+score, 750,50);
		else if(score < 1000)
			g.drawString(""+score, 730,50);
		else if(score < 10000)
			g.drawString(""+score, 710,50);
		else if(score < 100000)
			g.drawString(""+score, 690,50);
		else if(score < 1000000)
			g.drawString(""+score, 670,50);
		else if(score < 10000000)
			g.drawString(""+score, 650,50);
	}
}
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

public class ImageChooser
{
	private int score, streak, multiplyer;
	private int y, x;
	private BufferedImage imgBoard0, imgBoard1, imgBoard2, imgBoard3, imgBoard4, imgBoard5, imgBoard6, imgBoard7, imgBoard8;

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

		}catch (IOException e) {

			e.printStackTrace();
			System.exit(1);
		}
    }

    public void setStreak(int streak)
    {
		this.streak = streak;
	}

	public void setMultiplyer(int multiplyer)
	{
		this.multiplyer = multiplyer;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

	public void render(Graphics g)
	{
		if(streak == 0 || streak == 9 || streak == 18 || streak == 27)
			g.drawImage(imgBoard0, 523, 223, 275, 275, null);
		else if(streak == 1 || streak == 10 || streak == 19 || streak == 28)
			g.drawImage(imgBoard1, 523, 223, 275, 275, null);
		else if(streak == 2 || streak == 11 || streak == 20 || streak == 29)
			g.drawImage(imgBoard2, 523, 223, 275, 275, null);
		else if(streak == 3 || streak == 12 || streak == 21 || streak == 30)
			g.drawImage(imgBoard3, 523, 223, 275, 275, null);
		else if(streak == 4 || streak == 13 || streak == 22 || streak == 31)
			g.drawImage(imgBoard4, 523, 223, 275, 275, null);
		else if(streak == 5 || streak == 14 || streak == 23 || streak == 32)
			g.drawImage(imgBoard5, 523, 223, 275, 275, null);
		else if(streak == 6 || streak == 15 || streak == 24 || streak == 33)
			g.drawImage(imgBoard6, 523, 223, 275, 275, null);
		else if(streak == 7 || streak == 16 || streak == 25 || streak == 34)
			g.drawImage(imgBoard7, 523, 223, 275, 275, null);
		else if(streak == 8 || streak == 17 || streak == 26 || streak >= 35)
			g.drawImage(imgBoard8, 523, 223, 275, 275, null);

		g.drawString("Streak: " + streak, 10, 80);
		g.setFont(new Font("Impact", Font.PLAIN, 100));
		g.drawString(""+multiplyer, 650,415);
		g.setFont(new Font("Impact", Font.PLAIN, 45));
		if(score >= 0)
			g.drawString(""+score, 770,271);
		else if(score > 9)
			g.drawString(""+score, 770,231);
		else if(score > 99)
			g.drawString(""+score, 770,201);
		else if(score > 999)
		g.drawString(""+score, 770,271);
		else if(score > 9999)
		g.drawString(""+score, 770,271);
		else if(score > 99999)
			g.drawString(""+score, 770,271);
		else if(score > 999999)
			g.drawString(""+score, 770,271);
	}
}
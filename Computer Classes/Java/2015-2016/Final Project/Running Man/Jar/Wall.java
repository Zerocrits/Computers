import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.event.KeyListener;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

public class Wall
{
	private int y, x, height, num, gamesetting;
	private double speed;
	private Game game;

    public Wall(Game game, int gamesetting)
    {
        x = 900;
        y = 490;
        speed = 10;
        num = 0;
        this.gamesetting = gamesetting;
        this.game = game;
    }

    public int getY()
    {
        return y;
    }

    public int getX()
    {
		return x;
	}

	public void tick()
	{
		if(x < 0)
		{
			x = 1000;
			height= (int) (Math.random() * 120) + 30;

			//chooses Gamemode
			if(gamesetting == 1)//Random
				speed = (int) (Math.random() * 18) + 10;

			else if(gamesetting == 2)//Hard
			{
				if(game.getScore()<25)
				speed+=.5;
			}

			else if(gamesetting == 3)//Easy
			{
				if(game.getScore()%5==0 && game.getScore()<125)
					speed+=.5;
			}

			game.addScore();
		}
		x-=(int)speed;
	}

	public Rectangle getFrame()
	{
		return new Rectangle(x,537-height,15,height);
	}

	public void render(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		g2.fill(new Rectangle(x,537-height,15,height));
	}
}



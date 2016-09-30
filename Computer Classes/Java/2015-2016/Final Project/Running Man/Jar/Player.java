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

public class Player implements KeyListener
{
	private int y;
	private int x;
	private int airTime;
	private BufferedImage imgPlayer;
	private boolean upPressed, jumping, falling;

    public Player(Game game)
    {
		try {
			 imgPlayer = ImageIO.read(new File("Character.PNG"));
		}catch (IOException e) {

			e.printStackTrace();
			System.exit(1);
		}

		x = 40;
        y = 506;
        upPressed=jumping=falling=false;
        airTime = 0;
    }

    public int getY()
    {
        return y;
    }

    public int getX()
    {
		return x;
	}

	//checks location and uses timer
	public void tick()
	{
		if(upPressed && !jumping && !falling)
		{
			airTime=20;
			jumping=true;
		}

		if(airTime > 0 && jumping)
		{
			y-=airTime;
			airTime--;
		}

		if(airTime == 0 && jumping)
		{
			jumping=false;
			falling=true;
			airTime=20;
		}

		if(airTime > 0 && falling)
		{
			y+=airTime;
			airTime--;
		}

		if(airTime == 0 && falling)
		{
			falling=false;
		}
	}

	public Rectangle getFrame() //hitbox
	{
		return new Rectangle(x,y,25,25);
	}

	public void render(Graphics g) //draws player
	{
		g.drawImage(imgPlayer,x,y,null);
	}

    public void keyPressed(KeyEvent e)
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

	}
}
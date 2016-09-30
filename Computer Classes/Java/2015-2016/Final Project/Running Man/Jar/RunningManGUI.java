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

public class RunningManGUI
{
	public static void main(String[] args)
	{
		Game game = new Game("Running Man", 1000,600,3); //sample easy 1=insane 2=hard 3=easy
		game.start();
    }
}



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

public class Display
{
	private JFrame frame;
	private Canvas canvas;
	private String title;
	private int width, height;

	public Display(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;

		createDisplay();
	}

	private void createDisplay()
	{
		//Creates frame
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		//Creates canvas
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);

		//adds canvas to frame
		frame.add(canvas);
		frame.pack();
	}

	public Canvas getCanvas()
	{
		return canvas;
	}

	public JFrame getFrame()
	{
		return frame;
	}
}



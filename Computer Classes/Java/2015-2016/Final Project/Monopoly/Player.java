import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import java.util.*;

public class Player extends JComponent
{
	private String name;
	private int money;
	private int plan = 1;
	private ArrayList<Place> owns = new ArrayList<Place>();
	private TexturePaint build;
	private Rectangle rect;
	private boolean rounded = false;
	boolean haveJC = false; //jail card
	boolean isinJail = false; //check if in jail

	public Player(String name, int money, BufferedImage bi)
	{
		this.name = name;
		this.money = money;
		rect = new Rectangle(0, 0, 30, 30);
		build = new TexturePaint(bi, rect);
		setToolTipText(name);
	}

	public void setPlan(int i)
	{
		int temp = 0;
		plan += i;

		if(plan > 36)
		{
			temp = plan - 36;
			plan = temp;
			rounded = true;
		}
		else
			rounded = false;
	}

	public void setPosition(int x, int y)
	{
		setBounds(x,y,30,30);
	}

	public void setDirectPosition(int i)
	{
		plan = i;
	}

	public boolean hasRounded()
	{
		return rounded;
	}

	public TexturePaint getBuild()
	{
		return build;
	}

	public int getPlan()
	{
		return plan;
	}

	public String getName()
	{
		return name;
	}

	public int getMoney()
	{
		return money;
	}

	public int getIncome()
	{
		int cash = 0;
		for(Place p : owns)
		{
			if(p instanceof ResourcePlace)
			{
				ResourcePlace rp = (ResourcePlace) p;
				cash += rp.getResource();
			}
		}
		return cash;
	}

	public boolean buyProperty(Place p)
	{
		if(owns.contains(p))
			return false;
		owns.add(p);
		return true;
	}

	public boolean sellProperty(Place p)
	{
		if(!owns.contains(p))
			return false;
		owns.remove(p);
		return true;
	}

	public boolean propertyExists(Place p)
	{
		if(owns.contains(p))
			return true;
		else
			return false;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setPaint(build);
		g2d.fill(rect);
	}

	public ArrayList getProperty()
	{
		return new ArrayList(owns);
	}

	public void setMoney(int i)
	{
		money += i;
	}
}


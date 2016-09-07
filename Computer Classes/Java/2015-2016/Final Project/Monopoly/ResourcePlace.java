import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.*;

//These are the buildings, they are like streets but it adds more pah-zas

public class ResourcePlace extends Place
{
	protected String name;
	protected int cost;

	public ResourcePlace(int n, int x, int y, String a, String name, int cost)
	{
		super(n, x, y, a);
		this.name = name;
		this.cost = cost;
		setToolTipText(name);
	}

	public String getName()
	{
		return name;
	}

	public int getCost()
	{
		return cost;
	}

	public int getResource()
	{
		double doubleCost = cost * 0.1;
		int roundCost = (int) doubleCost;
		return roundCost;
	}

	public Color getColor()
	{
		return Color.white;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D graphics = (Graphics2D)g;
		graphics.setPaint(borderColor);

		if(align.equals("up") || align.equals("down"))
			rect = new Rectangle2D.Double(0, 0, x2, y2);
		else if(align.equals("left") || align.equals("right"))
			rect = new Rectangle2D.Double(0, 0, x2, y2);

		graphics.draw(rect);
		graphics.setPaint(Color.black);
		setFont(new Font("Goudy Handtooled BT", Font.PLAIN, 8));
		if(align.equals("right"))
		{
			graphics.drawString(name, 10, 25);
			graphics.drawString(String.valueOf(cost), 10, 35);
		}
		else if(align.equals("down"))
		{
			graphics.drawString(name, 10, 30);
			graphics.drawString(String.valueOf(cost), 10, 40);
		}
		else
		{
			graphics.drawString(name, 4, 25);
			graphics.drawString(String.valueOf(cost), 4, 35);
		}
		if(!players.isEmpty())
		{
			int z = 10;
			int v = 5;
			for(Player p : players)
			{
				add(p);
				p.setPosition(z, v);
				if(align.equals("up") || align.equals("down"))
					v += 20;
				else if(align.equals("left") || align.equals("right"))
					z += 20;
			}
		}

	}
	public String toString()
	{
		return name;
	}
}



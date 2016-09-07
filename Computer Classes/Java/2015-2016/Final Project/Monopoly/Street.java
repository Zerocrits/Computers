import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

//This is the purchaseable STREETS

public class Street extends Place
{
	protected String name;
	protected String[] splited;
	protected int cost;
	protected Color color;

	public Street(int n, int x, int y, String a, String name, int cost, Color c)
	{
		super(n, x, y, a);
		this.name = name;
		this.cost = cost;
		color = c;
		splited = name.split("\\s+");

		setToolTipText(name + "($" + cost + ")");
	}

	public String getName()
	{
		return name;
	}

	public int getCost()
	{
		return cost;
	}

	public Color getColor()
	{
		return color;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D graphics2d = (Graphics2D)g;
		graphics2d.setPaint(borderColor);
		if(align.equals("up") || align.equals("down"))
			rect = new Rectangle2D.Double(0, 0, x2, y2);
		else if(align.equals("left") || align.equals("right"))
			rect = new Rectangle2D.Double(0, 0, x2, y2);
		graphics2d.draw(rect);
		graphics2d.setPaint(color);
		Rectangle2D.Double rect2 = new Rectangle2D.Double(1, 1, 1, 1);
		if(align.equals("down"))
		{
			rect = new Rectangle2D.Double(2, 2, 58, 19);
			rect2 = new Rectangle2D.Double(0, 0, 59, 20);
		}
		else if(align.equals("up"))
		{
			rect = new Rectangle2D.Double(2, 2, 58, 19);
			rect2 = new Rectangle2D.Double(0, 0, 59, 20);
		}
		else if(align.equals("left"))
		{
			rect = new Rectangle2D.Double(98, 2, 19, 58);
			rect2 = new Rectangle2D.Double(98, 0, 20, 59);
		}
		else if(align.equals("right"))
		{
			rect = new Rectangle2D.Double(2, 2, 19, 58);
			rect2 = new Rectangle2D.Double(0, 0, 20, 59);
		}
		graphics2d.setPaint(color);
		graphics2d.fill(rect);
		graphics2d.setPaint(Color.black);
		graphics2d.draw(rect2);
		setFont(new Font("Goudy Handtooled BT", Font.PLAIN, 17)); //look for a bolder version of font so it stands out better
		for(int i = 0; i < splited.length; i++)
		{
			int j = i*14;
			if(align.equals("right"))
			{
				graphics2d.drawString(splited[i], 25, j+20);
				if(i == splited.length-1)
					graphics2d.drawString("$" + String.valueOf(cost), 25, (j+14)+30);
			}
			else if(align.equals("down"))
			{
				graphics2d.drawString(splited[i], 3, j+40);
				if(i == splited.length-1)
					graphics2d.drawString("$" + String.valueOf(cost), 3, (j+14)+50);
			}
			else if(align.equals("up"))
			{
				graphics2d.drawString(splited[i], 3, j+40);
				if(i == splited.length-1)
					graphics2d.drawString("$" + String.valueOf(cost), 3, (j+14)+50);
			}
			else if(align.equals("left"))
			{
				graphics2d.drawString(splited[i], 5, j+20);
				if(i == splited.length-1)
					graphics2d.drawString("$" + String.valueOf(cost), 5, (j+14)+30);
			}
		}
		if(!players.isEmpty())
		{
			int px = 10; //pixels on X
			int py = 5; //pixels on Y
			for(Player p : players) //for each
			{
				add(p);
				p.setPosition(px, py);
				if(align.equals("up") || align.equals("down"))
					py+=20;
				else if(align.equals("left") || align.equals("right"))
					px+=20;
			}
		}
	}

	public String toString()
	{
		return name;
	}
}





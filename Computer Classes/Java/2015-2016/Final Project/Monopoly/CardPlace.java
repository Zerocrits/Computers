import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.image.*;

//Question/Treasure spots (Community and chance cards)


public class CardPlace extends Place
{
	protected String typeCard;
	private BufferedImage bi;

	public CardPlace(int n, int x, int y, String a, String name, BufferedImage bi)
	{
		super(n, x, y, a);
		typeCard = name;
		if(align.equals("right") || align.equals("left"))
			setBounds(x, y, 120, 60);
		else if(align.equals("down") || align.equals("up"))
			setBounds(x, y, 60, 120);
		this.bi = bi;
	}

	public String getName()
	{
		return typeCard;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D graphics2d = (Graphics2D)g;
		graphics2d.setPaint(Color.black);
		if(align.equals("up") || align.equals("down"))
			rect = new Rectangle2D.Double(0, 0, 60, 120);
		else if(align.equals("left") || align.equals("right"))
			rect = new Rectangle2D.Double(0, 0, 120, 60);
		graphics2d.drawImage(bi, 0, 0, this);
		graphics2d.setPaint(Color.black);
		if(!players.isEmpty())
		{
			int px = 10;
			int py = 5;
			for(Player p : players)
			{
				add(p);
				p.setPosition(px, py);
				if(align.equals("up") || align.equals("down"))
					py += 20;
				else if(align.equals("left") || align.equals("right"))
					px += 20;
			}
		}
	}
}




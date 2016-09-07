import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.image.*;

//These are the corner pieces on the board

public class Corner extends Place
{
	protected String type;
	private BufferedImage bi;

	public Corner(int n, int x, int y, String a, String type, BufferedImage bi)
	{
		super(n, x, y, a);
		setBounds(x, y, 120, 120);
		this.type = type;
		this.bi = bi;
	}

	public String getName()
	{
		return type;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D graphics2d = (Graphics2D)g;
		graphics2d.setPaint(Color.black);
		rect = new Rectangle2D.Double(0, 0, 120, 120);
		graphics2d.drawImage(bi, 0, 0, this);
		graphics2d.setPaint(Color.black);
		setFont(new Font("Goudy Handtooled BT", Font.PLAIN, 24));
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


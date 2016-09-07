import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.*;

public class MiniMap extends JPanel
{
	private HashMap<Integer, Color> shapeColors = new HashMap<Integer, Color>();
	private HashMap<Integer, Rectangle2D.Double> shapes = new HashMap<Integer, Rectangle2D.Double>();

	public MiniMap()
	{
		shapeColors.put(1, Color.green);
		shapeColors.put(2, Color.white);
		shapeColors.put(3, Color.orange);
		shapeColors.put(4, Color.white);
		shapeColors.put(5, Color.white);
		shapeColors.put(6, Color.white);
		shapeColors.put(7, Color.orange);
		shapeColors.put(8, Color.white);
		shapeColors.put(9, Color.white);
		shapeColors.put(10, Color.green);

		shapeColors.put(11, Color.white);
		shapeColors.put(12, Color.white);
		shapeColors.put(13, Color.white);
		shapeColors.put(14, Color.white);
		shapeColors.put(15, Color.white);
		shapeColors.put(16, Color.white);
		shapeColors.put(17, Color.white);
		shapeColors.put(18, Color.orange);

		shapeColors.put(19, Color.green);
		shapeColors.put(20, Color.white);
		shapeColors.put(21, Color.orange);
		shapeColors.put(22, Color.white);
		shapeColors.put(23, Color.white);
		shapeColors.put(24, Color.white);
		shapeColors.put(25, Color.white);
		shapeColors.put(26, Color.white);
		shapeColors.put(27, Color.white);
		shapeColors.put(28, Color.green);

		shapeColors.put(29, Color.white);
		shapeColors.put(30, Color.orange);
		shapeColors.put(31, Color.white);
		shapeColors.put(32, Color.orange);
		shapeColors.put(33, Color.white);
		shapeColors.put(34, Color.white);
		shapeColors.put(35, Color.white);
		shapeColors.put(36, Color.white);
		addRects();
	}

	public Color getColor(int i)
	{
		Color c = Color.black;
		Set<Map.Entry<Integer, Color>> s = shapeColors.entrySet();
		for(Map.Entry<Integer, Color> m : s)
			if(i == m.getKey())
				c = m.getValue();
		return c;
	}

	public void addRects()
	{
		shapes.put(1, new Rectangle2D.Double(99,90,20,10));
		shapes.put(2, new Rectangle2D.Double(89,90,10,10));
		shapes.put(3, new Rectangle2D.Double(79,90,10,10));
		shapes.put(4, new Rectangle2D.Double(69,90,10,10));
		shapes.put(5, new Rectangle2D.Double(59,90,10,10));
		shapes.put(6, new Rectangle2D.Double(49,90,10,10));
		shapes.put(7, new Rectangle2D.Double(39,90,10,10));
		shapes.put(8, new Rectangle2D.Double(29,90,10,10));
		shapes.put(9, new Rectangle2D.Double(19,90,10,10));
		shapes.put(10, new Rectangle2D.Double(1,90,20,10));

		shapes.put(11, new Rectangle2D.Double(1,79,20,10));
		shapes.put(12, new Rectangle2D.Double(1,69,20,10));
		shapes.put(13, new Rectangle2D.Double(1,59,20,10));
		shapes.put(14, new Rectangle2D.Double(1,49,20,10));
		shapes.put(15, new Rectangle2D.Double(1,39,20,10));
		shapes.put(16, new Rectangle2D.Double(1,29,20,10));
		shapes.put(17, new Rectangle2D.Double(1,19,20,10));
		shapes.put(18, new Rectangle2D.Double(1,9,20,10));

		shapes.put(19, new Rectangle2D.Double(1,0,20,10));
		shapes.put(20, new Rectangle2D.Double(19,0,10,10));
		shapes.put(21, new Rectangle2D.Double(29,0,10,10));
		shapes.put(22, new Rectangle2D.Double(39,0,10,10));
		shapes.put(23, new Rectangle2D.Double(49,0,10,10));
		shapes.put(24, new Rectangle2D.Double(59,0,10,10));
		shapes.put(25, new Rectangle2D.Double(69,0,10,10));
		shapes.put(26, new Rectangle2D.Double(79,0,10,10));
		shapes.put(27, new Rectangle2D.Double(89,0,10,10));
		shapes.put(28, new Rectangle2D.Double(99,0,20,10));

		shapes.put(29, new Rectangle2D.Double(99,9,20,10));
		shapes.put(30, new Rectangle2D.Double(99,19,20,10));
		shapes.put(31, new Rectangle2D.Double(99,29,20,10));
		shapes.put(32, new Rectangle2D.Double(99,39,20,10));
		shapes.put(33, new Rectangle2D.Double(99,49,20,10));
		shapes.put(34, new Rectangle2D.Double(99,59,20,10));
		shapes.put(35, new Rectangle2D.Double(99,69,20,10));
		shapes.put(36, new Rectangle2D.Double(99,79,20,10));
	}

	public void setColorOnBrick(int i, Color c)
	{
		shapeColors.put(i, c);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setPaint(new Color(78,157,78));
		Rectangle2D.Double rect = new Rectangle2D.Double(0,0,120,120);
		g2d.fill(rect);
		Set<Map.Entry<Integer, Rectangle2D.Double>> s = shapes.entrySet();
		for(Map.Entry<Integer, Rectangle2D.Double> m : s)
		{
			g2d.setPaint(getColor(m.getKey()));
			g2d.fill(m.getValue());
			g2d.setPaint(Color.black);
			g2d.draw(m.getValue());
		}
		repaint();
	}
}



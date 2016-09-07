import java.awt.*;
import javax.swing.*;

public class BuildPanel extends JPanel
{
	Image build;

	public BuildPanel(Image fill)
	{
		setLayout(null);
		build = fill;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(build, 0, 0, this);
		repaint();
	}
}
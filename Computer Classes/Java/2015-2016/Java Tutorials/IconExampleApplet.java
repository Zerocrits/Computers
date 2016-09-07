// Mr. Ascione
// Graphics Example for Applets & GUI Apps
// Spec: The idea here is to create a JLabel and an ImageIcon
//		 We will then use the .setIcon() method of JLabel to
//		 display our imageIcon.
//		 Be sure to save the graphic in the same folder, or else

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IconExampleApplet extends JApplet
{
    private JLabel lblCountPic;
    private ImageIcon icoCount;

    public void init()
    {
        //super("Icon Example");

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

		//instantiate objects
        lblCountPic = new JLabel();
        icoCount = new ImageIcon("count.jpg");
        lblCountPic.setIcon(icoCount);

        //add buttons to the window (container)
        cp.add(lblCountPic);

        setSize(200,250);
        setVisible(true);
    }
}




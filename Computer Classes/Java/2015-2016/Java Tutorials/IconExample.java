
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IconExample extends JFrame
{
    private JLabel lblCountPic;
    private ImageIcon icoCount;

    public IconExample()
    {
        super("Icon Example");

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


    public static void main(String[] args)
    {
        IconExample application = new IconExample();
    }


}




import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.*;

public class MidiHeroGUI
{
	public MidiHeroGUI()
	{
		Game game = new Game(800, 500, "eyeofthetiger"); //game starting, when finished you rock! notes hit% , duration
		game.start();
    }

    public static void main(String[] args)
    {
		MidiHeroGUI gui = new MidiHeroGUI();
	}
}
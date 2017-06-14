import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.*;

public class MidiHeroGUI
{
	public MidiHeroGUI()
	{
	}

	public MidiHeroGUI(int width, int height, String song)
	{
		Game game = new Game(width, height, song); //game starting, when finished you rock! notes hit% , duration //when it goes past 0 it needs to take away a hit on the counter
		game.start();
    }

    public static void main(String[] args)
    {
		MidiHeroGUI gui = new MidiHeroGUI(800, 500, "eyeofthetiger");
	}
}
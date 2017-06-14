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
		Game game = new Game(width, height, song);
		game.start();
    }

    public static void main(String[] args)
    {
		MidiHeroGUI gui = new MidiHeroGUI(800, 500, "eyeofthetiger");
	}
}
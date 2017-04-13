import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.*;

public class MidiHeroGUI
{
	public MidiHeroGUI()
	{
		Game game = new Game(800, 500, "Songs/sample");
		game.start();
    }

    public static void main(String[] args)
    {
		MidiHeroGUI gui = new MidiHeroGUI();
	}
}
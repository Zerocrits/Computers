import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.*;

public class MidiHeroGUI
{
	public MidiHeroGUI()
	//public static void main(String[] args)
	{
		//Display display = new Display(800,500);
		//display.restart();
		Game game = new Game(800, 500, "Songs/sample.WAV");
		game.start();

    }
}
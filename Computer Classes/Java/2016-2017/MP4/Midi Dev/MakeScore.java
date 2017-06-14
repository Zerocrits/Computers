import java.io.*;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class MakeScore
{
	public int score, streak, multiplyer;
	public double lives;

    public MakeScore()
    {
		score = streak = 0;
		multiplyer = 1;
		lives = 137.5;
    }

    public void setStreak()
    {
		streak++;
		setMultiplyer();
	}

	public void setScore()
	{
		score += multiplyer*125;
		if(lives >= 272.25)
			lives = 275;
		else
			lives += 2.75;
	}

	public void missNote()
	{
		streak = 0;
		if(lives < 11 && lives > 0)
			lives += -lives;
		else if(lives == 0.0)
			lives += -1;
		else
			lives += -11;
	}

	public void setMultiplyer()
	{
		if(streak < 8)
			multiplyer = 1;
		else if(streak < 17)
			multiplyer = 2;
		else if(streak < 26)
			multiplyer = 3;
		else if(streak > 26)
			multiplyer = 4;
	}

	public int getScore()
	{
		return score;
	}

	public int getStreak()
	{
		return streak;
	}

	public int getMultiplyer()
	{
		return multiplyer;
	}
}
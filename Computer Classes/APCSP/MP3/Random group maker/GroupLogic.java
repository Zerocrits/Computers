import java.lang.*;
import java.io.*;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.io.FileReader;

public class GroupLogic
{
	private int groupSize, classSize;
	private String[] roster;
	private String[][] groups;

    public GroupLogic(int groupSize)
    {
		this.groupSize = groupSize;
		classSize = getLength();
		roster = new String[classSize];
		groups = new String[classSize/groupSize][groupSize];
		makeGroups();
    }

	public int getLength()
    {
		String filename = "roster.txt";
		int length = 0;
		try
		{
			LineNumberReader size = new LineNumberReader(new FileReader(new File(filename)));
			Scanner file = new Scanner(new File(filename));
			size.skip(Long.MAX_VALUE);
			length = (size.getLineNumber())+1;
			size.close(); //prevent resource leak
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return length;
	}


    public void classSize()
    {
		String filename = "roster.txt";
		int length = 0;
		try
		{
			LineNumberReader size = new LineNumberReader(new FileReader(new File(filename)));
			Scanner file = new Scanner(new File(filename));
			size.skip(Long.MAX_VALUE);
			length = (size.getLineNumber()+1);
			for(int i = 0; i < length; i++)
			{
				roster[i] = file.nextLine();
			}
			size.close(); //prevent resource leak
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void makeGroups()
	{
		int random = (int)(Math.random() * classSize-1);
		for(int i = 0; i < classSize/groupSize; i++)
		{
			for(int j = 0; j < groupSize; j++)
			{
				if(roster[random] != "")
				{
					groups[i][j] = roster[random];
					roster[random] = "";
				}
				else
				{
					j--;
				}
			}
		}
	}

	public String toString()
	{
		String result = "";
		for(int i = 0; i < classSize/groupSize; i++)
		{
			for(int j = 0; j < groupSize; j++)
			{
				result += groups[i][j] + "\n";
			}
			result += "\n";
		}
		return result;
	}
}
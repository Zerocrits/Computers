//Bill Joseph
//Histogram
//Histogram source code run

import java.util.Scanner;

public class Histogram
{
	private int[] numCount;

	public Histogram(String line)
	{
		line = line.replaceAll("\\s+","");
		numCount = new int[10];
		setList(line);
	}

	// setList() goes through the line and makes use of the fact
	// that the numbers correspond to the indices in the numCount array
	// When a number appears it increments that value in the numCount array
	public void setList(String line)
	{
		for(int i = 0; i < line.length(); i++)
		{
			switch(line.charAt(i))
			{
				case 48: numCount[0]++; break;
				case 49: numCount[1]++; break;
				case 50: numCount[2]++; break;
				case 51: numCount[3]++; break;
				case 52: numCount[4]++; break;
				case 53: numCount[5]++; break;
				case 54: numCount[6]++; break;
				case 55: numCount[7]++; break;
				case 56: numCount[8]++; break;
				case 57: numCount[9]++; break;
			}
		}
	}

	// getData() returns a String with the numbers 0 to 9 along with the occurences of each
	public String getData()
	{
		String data = "";
		for(int i = 0; i < numCount.length; i++)
			data += i + " - " + numCount[i] + "\n";
		return data;
	}

	// getHistogram() returns a String with the numbers 0 to 9
	//					and a visual representation with *'s
	public String getHistogram()
	{
		String histogram = "";
		int stars = 0;
		for(int i = 0; i < numCount.length; i++)
		{
			stars = numCount[i];
			histogram += i + ":" + getStars(stars) + "\n";
		}
		return histogram;
	}

	// getStars returns a String with x number of *'s
	// this is a helper method for getHistogram
	public String getStars(int x)
	{
		String stars = "";
		for(int i = 0; i < x; i++)
			stars += "*";
		return stars;
	}

	// toString() returns a String representation of Histogram
	//			 based on the numArray.  Essentially it just calls
	//			 getHistogram and makes this the default action for printing state
	public String toString()
	{
		return getHistogram();
	}
}
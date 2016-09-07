// Name:Bill Joseph
// Prog:FancyWord 2
// Spec:Fancy Word Code

import java.util.Arrays;

public class FancyWordTwo
{
	private String[][] mat;

	public FancyWordTwo()
	{
		mat = new String[0][0];
	}

   	public FancyWordTwo(String s)
	{
		int size = s.length();
		int temp = s.length()-1;
		mat = new String[size][size];

		for(String[] row : mat)
			Arrays.fill(row," ");

		for(int i = 0; i < size; i++)
		{
			for(int j = size-1; j >= 0; j--)
			{
				if(i == 0)
				{
					mat[i][j] = "" + s.charAt(j);
					mat[j][i] = "" + s.charAt(j);
				}
			}
		}
		for(int i = size-1; i >= 0; i--)
		{
			temp = 0;
			for(int j = size-1; j >= 0; j--)
			{
				if(i == size-1)
				{
					mat[i][j] = "" + s.charAt(temp);
					mat[j][i] = "" + s.charAt(temp);
					temp++;

				}
			}
		}


		// size the matrix
		// use Arrays.fill() to fill in the matrix with spaces
		// use a for loop to load in the letters into the matrix
	}

	public String toString()
	{
		String output = "";

		for(int i = 0; i < mat.length; i++)
		{
			for(int j = 0; j < mat.length; j++)
			{
				output += mat[i][j];
			}
			output += "\n";
		}
		// use nested for loops to build a String from the matrix

		return output + "\n";
	}
}
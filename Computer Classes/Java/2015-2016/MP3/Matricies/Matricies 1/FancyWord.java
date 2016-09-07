// Name:Bill Joseph
// Prog:FancyWord
// Spec:Fancy Word Code

import java.util.Arrays;

public class FancyWord
{
	private String[][] mat;

	public FancyWord()
	{
		mat = new String[0][0];
	}

   	public FancyWord(String s)
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
				if(i == 0 || i == size-1)
					mat[i][j] = "" + s.charAt(j);
				mat[j][j] = "" + s.charAt(j);
			}
			mat[temp][i] = "" + s.charAt(i);
			temp--;
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
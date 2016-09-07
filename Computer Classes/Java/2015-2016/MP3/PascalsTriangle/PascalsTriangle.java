// Bill Joseph
// Pascal's Triangle
// Spec: Simple PascalsTriangle

import java.util.Scanner;

public class PascalsTriangle
{
	private int[][] mat;

	/** Makes a 0x0 matrix*/
	public PascalsTriangle()
	{
		mat = new int[0][0];
	}

	/** Makes a square matrix dimensioned size x size */
	public PascalsTriangle(int size)
	{
		mat = new int[size][size];
	}

	/** Constructs a Pascal's Triangle for this matrix */
	public void createTriangle()
	{
		int num = 1;
		for(int i = 0; i < mat.length; i++)
		{
			for(int j = 0; j < mat.length; j++)
			{
				mat[i][0] = 1;
				if(i > 0)
				{
					mat[i][j] += mat[i-1][j];
					if(j > 0)
					{
						mat[i][j] += mat[i-1][j-1];
					}
				}
			}
		}
	}

	/** @return a matrix with tabs between items and newlines for each row */
	public String toString()
	{
		String output="";

		for(int i = 0; i < mat.length; i++)
		{
			for(int j = 0; j < mat.length; j++)
			{
				if(mat[i][j] != 0)
				{
					output += mat[i][j] + "\t";
				}
			}
			output += "\n";
		}

		return output;
	}
}
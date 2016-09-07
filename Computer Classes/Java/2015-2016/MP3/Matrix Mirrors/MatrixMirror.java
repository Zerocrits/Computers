// Bill Joseph
// Matrix Mirror Class
// Spec: Allows client to construct a matrix of any size
//		 and perform various matrix mirroring operations
// Note: A diagonal mirror requires a square matrix as a pre-condition

import java.util.Arrays;

public class MatrixMirror
{
	private int[][] mat;

	/** Construct a square 3x3 matrix by default
	/*  and invoke populateMatrixSequentially() to fill it
	*/
	public MatrixMirror()
	{
		mat = new int[3][3];
		populateMatrixSequentially();
	}

	/** Construct a matrix with size rows x cols
	/*  and invoke populateMatrixSequentially() to fill it
	*/
	public MatrixMirror(int rows, int cols)
	{
		mat = new int[rows][cols];
		populateMatrixSequentially();
	}

	/** Fills mat with numbers starting with 1 in the upper left
	/*  and continuing from left to right, row by row
	/*  Ex 1:  	mat
	/*			1  2  3  4  5
	/*			6  7  8  9  10
	/*			11 12 13 14 15
	*/
	public void populateMatrixSequentially()
	{
		int temp = 1;
		for(int i = 0; i < mat.length; i++)
		{
			for(int j = 0; j < mat[i].length; j++)
			{
				mat[i][j] = temp;
				temp++;
			}
		}

	}

	/** Use a vertical mirror down the center of a matrix to reflect the left half
	/*  of the matrix onto the right.
	/*  Ex 1:  	mat					mat (after mirroring)
	/*			1  2  3  4  5		1  2  3  2  1
	/*			6  7  8  9  10		6  7  8  7  6
	/*			11 12 13 14 15		11 12 13 12 11
	/*
	/*	Ex 2: 	mat					mat (after mirroring)
	/*			1  2  3  4			1  2  2  1
	/*			5  6  7  8 			5  6  6  5
	/*			9  10 11 12			9  10 10 9
	*/
	public void mirrorVerticalLeftToRight()
	{
		int temp = 1;
		int temp2 = 0;
		int temp3 = 1;
		for(int i = 0; i < mat.length; i++)
		{
			temp = temp3;
			for(int j = 0; j < mat[i].length; j++)
			{
				temp2 = mat[i].length/2;

				if(j>=temp2)
				{
					temp--;
					mat[i][j] = temp;
				}
				else if(j<temp2)
				{
					mat[i][j] = temp;
					temp++;
				}
				temp3++;
			}
		}

	}

	/** Use a horizontal mirror across the center of a matrix to reflect the top half
	/*  of the matrix onto the bottom half.
	/*  Ex 1:  	mat					mat (after mirroring)
	/*			1  2  3  4  5		1  2  3  4  5
	/*			6  7  8  9  10		6  7  8  9  10
	/*			11 12 13 14 15		1  2  3  4  5
	/*
	/*	Ex 2: 	mat					mat (after mirroring)
	/*			1  2  3  4			1  2  3  4
	/*			5  6  7  8 			5  6  7  8
	/*			9  10 11 12			5  6  7  8
	/*			13 14 15 16			1  2  3  4
	*/
	public void mirrorHorizontalTopToBottom()
	{
		int temp = 1;
		int temp2 = mat.length-1;
		for(int i = 0; i <= mat.length/2; i++)
		{
			for(int j = 0; j < mat[i].length; j++)
			{
				mat[i][j] = temp;
				mat[temp2][j] = temp;
				temp++;
			}
			temp2--;
		}
	}

	/** Extra: Use a mirror across the major diagonal (top-left to bottom-right)
	/*  and reflect the elements from left to right across this diagonal
	/*		mat						mat (after mirroring)
	/*		1	2	3	4			1	5	9	13
	/*		5	6	7	8			5	6	10	14
	/*		9	10	11	12			9	10	11	15
	/*		13	14	15	16			13	14	15	16
	/*	Precondition: Must be a square matrix
	*/
	public void mirrorMajorDiagonalLeftToRight()
	{
		int temp;
		for(int i = 0; i < mat.length; i++)
		{
			for(int j = mat[i].length-1; j >= 0; j--)
			{
				mat[i][j] = mat[j][i];
			}
		}
	}

	/** Extra: Use a mirror across the minor diagonal (top-right to bottom-left)
	/*	and reflect the elements from left to right across this diagonal
	/*		mat						mat (after mirroring)
	/*		1	2	3	4			1	2	3	4
	/*		5	6	7	8			5	6	7	3
	/*		9	10	11	12			9	10	6	2
	/*		13	14	15	16			13	9	5	1
	/*	Precondition: Must be a square matrix
	*/
	public void mirrorMinorDiagonalLeftToRight()
	{
		int temp;
		for(int i = 0; i < mat.length; i++)
		{
			for(int j = mat[i].length-1; j >= 0; j--)
			{
				mat[j][i] = mat[i][j];
			}
		}
	}

	/** @return the matrix with tabs between elements
	/*  and a new line at the end of each row
	*/
	public String toString()
	{
		String result = "";
		for(int i = 0; i < mat.length; i++)
		{
			for(int j = 0; j < mat[i].length; j++)
			{
				result += mat[i][j] + "\t";
			}
			result += "\n";
		}

		return result;
	}
}
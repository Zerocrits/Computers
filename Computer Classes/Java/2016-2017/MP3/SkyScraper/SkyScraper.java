import java.lang.Object;
import java.util.Random;

public class SkyScraper
{
	public int[][] grid;
	public int[] left, right, top, bottom;
	public int size;

	public SkyScraper(String input)
	{
		String[] height = input.split(",");
		left = new int[height.length-2];
		right = new int[height.length-2];
		top = new int[height.length-2];
		bottom = new int[height.length-2];
		grid = new int[height.length-2][height.length-2];
		size = grid.length;


		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				if(i == 0)
					top[j] = Integer.parseInt(height[0].substring(j,j+1));
				else if(i == size)
					bottom[j] = Integer.parseInt(height[size].substring(j,j+1));

				left[i] = Integer.parseInt(height[i+1].substring(0,1));
				right[i] = Integer.parseInt(height[i+1].substring(1,2));
			}
		}
		makeGridMax();
	}

	public void makeGridMax()
	{
		int k = 1;
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				if(top[i] == size)
					grid[j][i] = j+1;
				if(left[i] == size)
					grid[i][j] = j+1;
			}
			for(int j = size-1; j >= 0; j--)
			{
				if(bottom[i] == size)
					grid[j][i] = k;
				if(right[i] == size)
					grid[i][j] = k;
				k++;
			}
			k = 1;
		}
		System.out.println(toString() + "HELLO");
		makeGrid();
	}

	public void makeGrid()
	{
		Random rand = new Random();
		int num = rand.nextInt(size-1) + 1;
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				num = rand.nextInt(size-1) + 1;
				if(grid[i][j] == 0)
				{
					if((checkCol(i,num) == true) && (checkRow(j,num) == true))
						grid[i][j] = num;
					else
						j--;
					System.out.println(checkCol(i,num) + "" +checkRow(j,num));
				}
			}
			if(blockedAmountCol(i) == false)
			{
				for(int j = 0; j < size; j++)
				{
					grid[j][i] = 0;
				}
				i--;
			}
			if(blockedAmountRow(i) == false)
			{
				for(int j = 0; j < size; j++)
				{
					grid[i][j] = 0;
				}
				i--;
			}
		}
		System.out.println(toString() + "HELLO");
	}

	public boolean checkCol(int col, int num)
	{
		for(int i = 0; i < size; i++)
		{
			if(grid[col][i] == num)
				return false;
		}
		return true;
	}

	public boolean checkRow(int row, int num)
	{
		for(int i = 0; i < size; i++)
		{
			if(grid[i][row] == num)
				return false;
		}
		return true;
	}

	public boolean blockedAmountCol(int col)
	{
		boolean booCol = false;
		int count = 1;
		int lastNum = 0;

		lastNum = grid[col][0];
		for(int j = 0; j < size; j++)
		{
			for(int i = 1; i < size; i++)
			{
				if(grid[col][i] > lastNum)
				{
					count++;
					lastNum = grid[col][i];
				}
				if(size-1 == i)
				{
					if(count == left[j])
						booCol = true; //blocks right amount
					else
						booCol = false;
				}
			}
		}

		count = 1;
		lastNum = grid[col][size-1];
		for(int j = 0; j < size; j++)
		{
			for(int i = size-2; i >= 0; i--)
			{
				if(grid[col][i] > lastNum)
				{
					count++;
					lastNum = grid[col][i];
				}
				if(0 == i)
				{
					if(count == right[j])
						booCol = true; //blocks right amount
					else
						booCol = false;
				}
			}
		}

		return booCol;
	}

	public boolean blockedAmountRow(int row)
	{
		boolean booRow = false;
		int count = 1;
		int lastNum = 0;

		lastNum = grid[0][row+1];
		for(int i = 1; i < size; i++)
		{
			if(grid[i][row+1] > lastNum)
			{
				count++;
				lastNum = grid[i][row+1];
			}
			if(size-1 == i)
			{
				if(count == top[row+1])
					booRow = true; //blocks right amount
				else
					booRow = false;
			}
		}

		count = 1;
		lastNum = grid[size-1][row+1];
		for(int i = size-2; i >= 0; i--)
		{
			if(grid[i][row+1] > lastNum)
			{
				count++;
				lastNum = grid[i][row+1];
			}
			if(0 == i)
			{
				if(count == bottom[row+1])
					booRow = true; //blocks right amount
				else
					booRow = false;
			}
		}

		return booRow;
	}

	public String toString()
	{
		String answer = "";
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				answer += ""+grid[i][j];
			}
			answer += "\n";
		}
		return answer;
	}
}
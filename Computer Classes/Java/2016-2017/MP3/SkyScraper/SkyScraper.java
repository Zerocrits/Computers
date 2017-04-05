public class SkyScraper
{
	public int[][] grid, grid2;
	public int[] left, right, top, bottom;

	public SkyScraper(String input)
	{
		String[] height = input.split(",");
		left = new int[height.length-2];
		right = new int[height.length-2];
		top = new int[height.length-2];
		bottom = new int[height.length-2];
		grid = new int[height.length-2][height.length-2];
		grid2 = new int[height.length-2][height.length-2];


		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid.length; j++)
			{
				if(i == 0)
					top[j] = Integer.parseInt(height[0].substring(j,j+1));
				else if(i == grid.length)
					bottom[j] = Integer.parseInt(height[grid.length].substring(j,j+1));

				left[i] = Integer.parseInt(height[i+1].substring(0,1));
				right[i] = Integer.parseInt(height[i+1].substring(1,2));
			}
		}
		makeGridMax();
	}

	public void makeGridMax()
	{
		int k = 1;
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid.length; j++)
			{
				if(top[i] == grid.length)
				{
					grid[j][i] = j+1;
					grid2[j][i] = j+1;
				}
				if(left[i] == grid.length)
				{
					grid[i][j] = j+1;
					grid2[i][j] = j+1;
				}
			}
			for(int j = grid.length-1; j >= 0; j--)
			{
				if(bottom[i] == grid.length)
				{
					grid[j][i] = k;
					grid2[j][i] = k;
				}
				if(right[i] == grid.length)
				{
					grid[i][j] = k;
					grid2[i][j] = k;
				}
				k++;
			}
			k = 1;
		}
		makeGrid();
	}

	public void makeGrid()
	{
		int num = 1;
		int var = 1;
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid.length; j++)
			{
				if(grid[i][j] == 0)
				{
					if(checkCol(i,num) == true && checkRow(j,num) == true)
						grid[i][j] = num;
					else
					{
						num+= var;
						j--;
					}
				}
			}
			if(blockedAmountCol(i) == true)
			{
				for(int j = 0; j < grid.length; j++)
				{
					grid2[i][j] = grid[i][j];
				}
				num = 0;
				var = 1;
			}
			if(blockedAmountCol(i) == false)
			{
				for(int j = 0; j < grid.length; j++)
				{
					grid[i][j] = grid2[i][j];
				}
				i--;
				num = grid.length-1;
				var = -1;
			}
			if(blockedAmountRow(i) == true)
			{
				for(int j = 0; j < grid.length; j++)
				{
					grid2[j][i] = grid[i][j];
				}
				num = 0;
				var = 1;
			}
			if(blockedAmountRow(i) == false)
			{
				for(int j = 0; j < grid.length; j++)
				{
					grid[j][i] = grid2[i][j];
				}
				i--;
				num = grid.length-1;
				var = -1;
			}
		}
		System.out.println(toString());
	}

	public boolean checkCol(int col, int num)
	{
		for(int i = 0; i < grid.length; i++)
		{
			if(grid[col][i] == num)
				return false;
		}
		return true;
	}

	public boolean checkRow(int row, int num)
	{
		for(int i = 0; i < grid.length; i++)
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
		for(int j = 0; j < grid.length; j++)
		{
			for(int i = 1; i < grid.length; i++)
			{
				if(grid[col][i] > lastNum)
				{
					count++;
					lastNum = grid[col][i];
				}
				if(grid.length-1 == i)
				{
					if(count == left[j])
						booCol = true; //blocks right amount
					else
						return false;
				}
			}
		}

		count = 1;
		lastNum = grid[col][grid.length-1];
		for(int j = 0; j < grid.length; j++)
		{
			for(int i = grid.length-2; i >= 0; i--)
			{
				if(grid[col][i] > lastNum)
				{
					count++;
					lastNum = grid[col][i];
				}
				if(0 == i)
				{
					if(count == right[i])
						booCol = true; //blocks right amount
					else
						return false;
				}
			}
		}

		return false;
	}

	public boolean blockedAmountRow(int row)
	{
		boolean booRow = false;
		int count = 1;
		int lastNum = 0;

		lastNum = grid[0][row];
		for(int j = 0; j < grid.length; j++)
		{
			for(int i = 1; i < grid.length; i++)
			{
				if(grid[i][row] > lastNum)
				{
					count++;
					lastNum = grid[i][row];
				}
				if(grid.length-1 == i)
				{
					if(count == top[j])
						booRow = true; //blocks right amount
					else
						return false;
				}
			}
		}

		count = 1;
		lastNum = grid[grid.length-1][row];
		for(int j = 0; j < grid.length; j++)
		{
			for(int i = grid.length-2; i >= 0; i--)
			{
				if(grid[i][row] > lastNum)
				{
					count++;
					lastNum = grid[i][row];
				}
				if(0 == i)
				{
					if(count == bottom[i])
						booRow = true; //blocks right amount
					else
						return false;
				}
			}
		}

		return false;
	}

	public String toString()
	{
		String answer = "";
		for(int i = 0; i < grid2.length; i++)
		{
			for(int j = 0; j < grid2.length; j++)
			{
				answer += ""+grid2[i][j];
			}
			answer += "\n";
		}
		return answer;
	}
}
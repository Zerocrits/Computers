public class LightsOut
{
	private boolean[][] grid;
	private boolean[][] nextGrid;
	private String[] hex;
	private String hexi;
	private String binary;
	private int gridNum;

	public LightsOut(String hexi, int gridNum)
	{
		grid = new boolean[8][8];
		nextGrid = new boolean[8][8];
		String[] hex = hexi.split(" ");
		binary = "";
		this.gridNum = gridNum;

		for(int i = 0; i < 4; i++)
		{
			binary += hexToBinary(hex[i]) + " ";
		}
		hexi = binary + "\n";

		if(gridNum == 1)
			gridOne(binary);
		else if(gridNum == 2)
			gridTwo(binary);

		binary = hexi;
	}

	public String hexToBinary(String hex)
	{
		int dec = Integer.parseInt(hex, 16);
		return String.format("%16s", Integer.toBinaryString(dec)).replace(' ', '0');
	}

	public void gridOne(String binary)
	{
		int k = 0;
		binary = binary.replaceAll("\\s","");
		for(int i = 7; i >= 0; i--)
		{
			for(int j = 0; j < 8; j++)
			{
				if(binary.charAt(k) != '0')
					grid[i][j] = true;
				else
					grid[i][j] = false;
				k++;
			}
		}
		System.out.println(showGrid(gridNum));
	}

	public void gridTwo(String binary)
	{
		int k = 0;
		binary = binary.replaceAll("\\s","");
		for(int i = 7; i >= 0; i--)
		{
			for(int j = 0; j < 8; j++)
			{
				if(binary.charAt(k) != '0')
					nextGrid[i][j] = true;
				else
					nextGrid[i][j] = false;
				k++;
			}
		}
		System.out.println(showGrid(gridNum));
		System.out.println(testBoard());
	}

	public String showGrid(int num)
	{
		String output = "";
		int gridNum = num;
		binary = binary.replaceAll("\\s","");
		int k = 0;
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				if(gridNum == 1)
				{
					if(grid[i][j] == false)
						output += 0;
					else
						output += 1;
				}
				else if(gridNum == 2)
				{
					if(nextGrid[i][j] == false)
						output += 0;
					else
						output += 1;
				}
				k++;
			}
			output += "\n";
		}
		return output;
	}

	public String testBoard()
	{
		String answer = "";
		boolean notIt = false;
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				if(grid[i][j] == true)
				{
					if((i < 6 && i > 1) && (j < 6 && j > 1))
					{
						if(grid[i+1][j] == nextGrid[i+1][j]) //do opposite
							notIt = true;
						if(grid[i+2][j] == nextGrid[i+2][j])
							notIt = true;
						if(grid[i+1][j+1] == nextGrid[i+1][j+1])
							notIt = true;
						if(grid[i][j+1] == nextGrid[i][j+1])
							notIt = true;
						if(grid[i][j+2] == nextGrid[i][j+2])
							notIt = true;
						if(grid[i-1][j+1] == nextGrid[i-1][j+1])
							notIt = true;
						if(grid[i-1][j] == nextGrid[i-1][j])
							notIt = true;
						if(grid[i-2][j] == nextGrid[i-2][j])
							notIt = true;
						if(grid[i-1][j-1] == nextGrid[i-1][j-1])
							notIt = true;
						if(grid[i-1][j] == nextGrid[i-1][j])
							notIt = true;
						if(grid[i-2][j] == nextGrid[i-2][j])
							notIt = true;
						if(grid[i-1][j+1] == nextGrid[i-1][j+1])
							notIt = true;

						if(notIt == false)
							answer += i + "jjjjjjj" + j;
					}
				}
			}
		}
		return answer;
	}
	public String toString()
	{
		return binary;
	}

}



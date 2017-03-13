public class LightsOut
{
	private boolean[][] grid = new boolean[8][8];
	private boolean[][] nextGrid = new boolean[8][8];
	private String[] hex;
	private String hexi;
	private String binary;
	private int gridNum;

	public LightsOut(String hexi, int gridNum)
	{
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
		{
			gridTwo(binary);
			System.out.println(testBoard());
		}

		binary = hexi;
		System.out.println(testBoard());
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

					System.out.println("wat " + notIt);
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



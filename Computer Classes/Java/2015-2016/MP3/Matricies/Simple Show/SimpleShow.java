// Bill Joseph
// Simple Show
// Spec: A seat could / should have more information (be it's own object), but here it is either taken or not taken only.
//		 Default hall is a small 50 seat venue.
//		 The first 5 rows go for $40 each... yes cheap by today's standards... but I remember prices like that :)
//		 subsequent rows are just $20 each

public class SimpleShow
{
	private boolean[][] seat;

	/** Creates a concert hall with 10 rows and 5 seats in each row
	*/
	public SimpleShow()
	{
		seat = new boolean[10][5];
	}

	/** Creates a concert hall with the size specified by rows and cols
	*/
	public SimpleShow(int rows, int cols)
	{
		seat = new boolean[rows][cols];
	}

	/** If the seat is not already occupied then it makes it occupied and returns true
	/*  If it is already occupied the method will return false
	*/
	public boolean reserveSeat(int row, int col)
	{
		for(int i = 0; i < seat.length; i++)
		{
			for(int j = 0; j < seat[i].length; j++)
			{
				if(seat[row][col] == false)
				{
					seat[row][col] = true;
					return false;
				}
			}
		}
		return false;
	}

	/** Makes the seat at row, col empty
	*/
	public void clearSeat(int row, int col)
	{
		seat[row][col] = false;
	}

	/**	Resets all seats to available.
	*/
	public void clearAllSeats()
	{
		for(int i = 0; i < seat.length; i++)
		{
			for(int j = 0; j < seat[i].length; j++)
			{
				seat[i][j] = false;
			}
		}
	}

	/** @return the number of seats still available in the hall
	*/
	public int numSeatsAvailable()
	{
		int total = 0;
		for(int i = 0; i < seat.length; i++)
		{
			for(int j = 0; j < seat[i].length; j++)
			{
				if(seat[i][j] == false)
				{
					total++;
				}
			}
		}
		return total;
	}

	/** @return the total revenue for the show based upon tickets sold
	/*  The first 5 rows go for $40 each
	/*  The next 5 rows are just $20 each
	*/
	public int getTotalRevenue()
	{
		int total = 0;
		for(int i = 0; i < seat.length; i++)
		{
			for(int j = 0; j < seat[i].length; j++)
			{
				if(i < 5 && seat[i][j] == true)
				{
					total += 40;
				}
				else if(i >= 5 && seat[i][j] == true)
				{
					total += 20;
				}
			}
		}

		return total;
	}

	/** Reserve the first 2 adjacent seats and return true if successful
	/*	If two adjacent seats could not be found, leave the state of the show unchanged
	/*  and return false.
	/*  return true if two adjacent seats were found, false otherwise
	*/
	public boolean getTwoTogether()
	{
		for(int i = 0; i < seat.length; i++)
		{
			for(int j = 0; j < seat[i].length; j++)
			{
				if(j < seat[i].length)
				{
					if(seat[i][j] == false && seat[i][j+1] == false)
					{
						return true;
					}
				}
			}
		}
		return false;
	}

	/** Return the lowest seat number in the specified row for a block
	/*  of adjacent seats.  If no such block exists, return -1.
	/*  @param row the row number to check
	/*  @param seatsNeeded the number of adjacent empty seats needed
	/*  @return lowest seat number for a block of contiguous adjacent seats of the given size
	/*  or -1 if no such block exists
	*/
	public int findAdjacent(int row, int seatsNeeded)
	{
		int index = 0, count = 0, lowIndex = 0;

		for(int i = 0; i < seat[i].length; i++)
		{
			if(i == 0 && seat[row][i] == false)
			{
				index = i;
				count++;
			}
			else if(i < seat[row].length && i > 0)
			{
				if(seat[row][i] == false && seat[row][i-1] == true)
				{
					index = i;
					count++;
				}
				else if(seat[row][i] == false)
					count++;
				else if(seat[row][i] == true)
					index = count = 0;
			}
			if(count == seatsNeeded)
				return index;
			else if(i == seat[row].length-1 && count != seatsNeeded)
				return -1;
		}
		return -1;
	}

	/** If a seat is available show a 'O', if occumpied show an 'X'
	/* 	return a String with one row per line
	*/
	public String toString()
	{
		String result = "AP Concert Hall - Simplified\n";
		for(int i = 0; i < seat.length; i++)
		{
			for(int j = 0; j < seat[i].length; j++)
			{
				if(seat[i][j] == true)
					result += "X \t";
				else if(seat[i][j] == false)
					result += "O \t";
			}
			result += "\n";
		}

		return result;
	}
}




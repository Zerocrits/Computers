public class TTT
{
	String user, cpu;
	String[] board;
	public TTT()
	{
		user = getUser();
		cpu = getCPU();
		board = getBoard(user, cpu);

	}
	public String getUser()
	{
		String user = "d";

		return user;
	}
	public String getCPU()
	{
		String cpu = "f";

		return cpu;
	}
	public String[] getBoard(String user, String cpu)
	{
		String[] board = new String[12];
		for(int i = 0; i < 12; i++)
		{
			if(i == 4 || i == 8 || i == 12)
				board[i] = "/n";
			else if(i%2 == 0

			else if(i%2 != 0
		}

		return board;
	}
	public String toString()
	{
		return "" + board;
	}
}

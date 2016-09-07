//bill joseph
//build Rock Paper Scissors
//spec: Build Rock Paper Scissors
import java.util.Random;

public class RPS
{
	private String cpu, result, total, user;
	private int win, lose, tie;

	public RPS()
	{
		win = lose = tie = 0;
		result = user = cpu = total = "";
	}
	public void setUser(String value)
	{
		user = value;
	}
	public String setResultCPU()
	{
		int number = (int) (Math.random()*3) + 1;
		if(number == 1)
		{
			cpu = "Rock";
		}
		else if(number == 2)
		{
			cpu = "Paper";
		}
		else if(number == 3)
		{
			cpu = "Scissors";
		}
		return cpu;
	}
	public String getTotal()
	{
		if(user == "Rock" && cpu == "Scissors" || user == "Paper" && cpu == "Rock" || user == "Scissors" && cpu == "Paper")
		{
			win++;
		}
		else if(user == cpu)
		{
			tie++;
		}
		else if(user == "Rock" && cpu != "Scissors" || user == "Paper" && cpu != "Rock" || user == "Scissors" && cpu != "Paper")
		{
			lose++;
		}
		total = "\nWins: " + win + " Loses: " + lose + " Ties: " + tie;
		return total;
	}
	public void getResult()
	{
		if(user == "Rock" && cpu == "Scissors" || user == "Paper" && cpu == "Rock" || user == "Scissors" && cpu == "Paper")
		{
			result = "You Won!";
		}
		else if(user == cpu)
		{
			result = "It's A Tie!";
		}
		else if(user == "Rock" && cpu != "Scissors" || user == "Paper" && cpu != "Rock" || user == "Scissors" && cpu != "Paper")
		{
			result = "You Lost!";
		}
	}
	public String toString()
	{
		String output="";
		output+="\nPlayer: " + user;
		output+="\nComputer: " + cpu;
		output+="\nResult: " + result;
		return output;
	}
}
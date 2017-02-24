public class Player
{
	private String team, position, name;
	private int gamesPlayed, PIM, years;

	public Player(String team, String position, String name, int gamesPlayed, int PIM, int years)
	{
		this.team = team;
		this.position = position;
		this.name = name;
		this.gamesPlayed = gamesPlayed;
		this.PIM = PIM;
		this.years = years;

	}

	public String getTeam(String team)
	{
		this.team = team;
		return team;
	}

	public String getPosition(String position)
	{
		this.position = position;
		return position;
	}

	public String getName(String name)
	{
		this.name = name;
		return name;
	}

	public int getGamesPlayed(int gamesPlayed)
	{
		this.gamesPlayed = gamesPlayed;
		return gamesPlayed;
	}

	public int getPIM(int PIM)
	{
		this.PIM = PIM;
		return PIM;
	}

	public int getYears(int years)
	{
		this.years = years;
		return years;
	}
}
public class Player
{
	private String team, position, name;
	private int gamesPlayed, PIM, rating;

	public Player(String team, String position, String name, int rating, int gamesPlayed, int PIM)
	{
		this.team = team;
		this.position = position;
		this.name = name;
		this.gamesPlayed = gamesPlayed;
		this.PIM = PIM;
		this.rating = rating;

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

	public int getRating(int rating)
	{
		this.rating = rating;
		return rating;
	}

	public String toString()
	{
		String result = "Player: " + name
					   +"\nTeam: " + team
					   +"\nPosition: " + position
					   +"\nRating: " + rating
					   +"\nGames Played: " + gamesPlayed
					   +"\nPenalties in Minutes: " + PIM;
		return result;
	}
}
public class Defender extends Skater
{
	private int takeAways, blockedShots, hits;

	public Defender(String team, String position, String name, int rating, int gamesPlayed, int PIM, int goals, int assists,
				  int points, int pointsPerGame, int shots, int shortHandedGoals, int shortHandedPoints, int overtimeGoals,
				  double shotPercent, int takeAways, int blockedShots, int hits)
	{
		super(team, position, name, rating ,gamesPlayed, PIM, goals, assists, points, pointsPerGame, shots, shortHandedGoals, shortHandedPoints, overtimeGoals, shotPercent);
		this.takeAways = takeAways;
		this.blockedShots = blockedShots;
		this.hits = hits;
	}

	public int getTakeAways(int takeAways)
	{
		this.takeAways = takeAways;
		return takeAways;
	}

	public int getBlockedShots(int blockedShots)
	{
		this.blockedShots = blockedShots;
		return blockedShots;
	}

	public int getHits(int hits)
	{
		this.hits = hits;
		return hits;
	}

	public String toString()
	{
		String result = super.toString();

		result += "\nTakeaways: " + takeAways
		+"\nBlocked Shots: " + blockedShots;

		return result;
	}
}
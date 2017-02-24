public class Defender extends Skater
{
	private int takeAways, blockedShots, hits;

	public Defender(String team, String position, String name, int gamesPlayed, int PIM, int years, int goals, int assists,
				  int points, int pointsPerGame, int shots, int shortHandedGoals, int shortHandedPoints, int overtimeGoals,
				  double shotPercent, int takeAways, int blockedShots, int hits)
	{
		takeAways = blockedShots = hits = 0;
		super(team, position, name, gamesPlayed, PIM, years);
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
}
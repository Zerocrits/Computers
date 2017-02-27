public class Goalie extends Player
{
	private int saves, goalsAgainst, shutouts;
	private double savePercent, goalsAgainstAverage;

	public Goalie(String team, String position, String name, int rating, int gamesPlayed, int PIM,
				  int saves, int goalsAgainst, int shutouts, double savePercent, double goalsAgainstAverage)
	{
		super(team, position, name, rating ,gamesPlayed, PIM);
		this.saves = saves;
		this.goalsAgainst = goalsAgainst;
		this.shutouts = shutouts;
		this.savePercent = savePercent;
		this.goalsAgainstAverage = goalsAgainstAverage;
	}

	public int getSaves(int saves)
	{
		this.saves = saves;
		return saves;
	}

	public int getGoalsAgainst(int goalsAgainst)
	{
		this.goalsAgainst = goalsAgainst;
		return goalsAgainst;
	}

	public int getShutouts(int shutouts)
	{
		this.shutouts = shutouts;
		return shutouts;
	}

	public double getSavePercent(double savePercent)
	{
		this.savePercent = savePercent;
		return savePercent;
	}

	public double getGoalsAgainstAverage(double goalsAgainstAverage)
	{
		this.goalsAgainstAverage = goalsAgainstAverage;
		return goalsAgainstAverage;
	}

	public String toString()
	{
		String result = super.toString();

		result += "\nSaves: " + saves
		+"\nGoals Against: " + goalsAgainst
		+"\nShutouts: " + shutouts
		+"\nSave Percentage: " + savePercent
		+"\nGoals Against Average: " + goalsAgainstAverage;

		return result;
	}
}
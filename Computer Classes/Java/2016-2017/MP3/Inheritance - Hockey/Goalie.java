public class Goalie extends Player
{
	private int saves, goalsAgainst, shutouts;
	private double savePercent;

	public Goalie(String z, String x, String y, int gp, int pim, int years)
	{
		saves = goalsAgainst = shutouts = 0;
		savePercent = 0.0;
		super.getName(z);
		super.getTeam(x);
		super.getPosition(y);
		super.getGamesPlayed(gp);
		super.getPIM(pim);
		super.getYears(years);
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

	public double savePercent(double savePercent)
	{
		this.savePercent = savePercent;
		return savePercent;
	}
}
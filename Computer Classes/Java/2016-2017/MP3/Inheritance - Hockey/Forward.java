public class Forward extends Skater
{
	private double faceoffPercent, shootoutPercent;

	public Forward(String x, String y, String z, int gp, int pim, int years, int g, int a, int p,
				   int pg, int s, int ppg, int ppp, int shg, int shp, int otg, double sp)
	{
		faceoffPercent = shootoutPercent = 0.0;
		super(name,
		super.getTeam(x);
		super.getPosition(y);
		super.getGamesPlayed(gp);
		super.getPIM(pim);
		super.getYears(years);
		super.getGoals(g);
		super.getAssists(a);
		super.getPoints(p);
		super.getPointsPerGame(pg);
		super.getShots(s);
		super.getPowerPlayGoals(ppg);
		super.getPowerPlayPoints(ppp);
		super.getShortHandedGoals(shg);
		super.getShortHandedPoints(shp);
		super.getOvertimeGoals(otg);
		super.getShotPercent(sp);
	}

	public double getFaceoffPercent(double faceoffPercent)
	{
		this.faceoffPercent = faceoffPercent;
		return faceoffPercent;
	}

	public double getShootoutPercent(double shootoutPercent)
	{
		this.shootoutPercent = shootoutPercent;
		return shootoutPercent;
	}
}
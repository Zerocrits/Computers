public class Forward extends Skater
{
	private double faceoffPercent;

	public Forward(String team, String position, String name, int rating, int gamesPlayed, int PIM, int goals, int assists,
				   int points, int shots, int shortHandedGoals, int shortHandedPoints, int overtimeGoals,
				   double shotPercent, double faceoffPercent, double pointsPerGame)
	{
		super(team, position, name, rating, gamesPlayed, PIM, goals, assists, points, pointsPerGame, shots, shortHandedGoals, shortHandedPoints, overtimeGoals, shotPercent);
		this.faceoffPercent = faceoffPercent;
	}

	public double getFaceoffPercent(double faceoffPercent)
	{
		this.faceoffPercent = faceoffPercent;
		return faceoffPercent;
	}

	public String toString()
	{
		String result = super.toString();

		result += "\nFaceoff Percent: " + faceoffPercent;

		return result;
	}
}
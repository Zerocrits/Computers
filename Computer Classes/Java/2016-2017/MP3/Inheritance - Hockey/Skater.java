public class Skater extends Player
{
	private int goals, assists, points, powerPlayGoals,
				powerPlayPoints, shortHandedGoals, shortHandedPoints,
				overtimeGoals, shots;
	private double shotPercent, pointsPerGame;


	public Skater(String team, String position, String name, int rating, int gamesPlayed, int PIM, int goals, int assists,
				  int points, double pointsPerGame, int shots, int shortHandedGoals, int shortHandedPoints, int overtimeGoals, double shotPercent)
	{
		super(team, position, name, rating, gamesPlayed, PIM);
		this.goals = goals;
		this.assists = assists;
		this.points = points;
		this.pointsPerGame = pointsPerGame;
		this.shots = shots;
		this.powerPlayGoals = powerPlayGoals;
		this.powerPlayPoints = powerPlayPoints;
		this.overtimeGoals = overtimeGoals;
		this.shortHandedGoals = shortHandedGoals;
		this.shortHandedPoints = shortHandedPoints;
		this.shotPercent = shotPercent;
	}

	public int getGoals(int goals)
	{
		this.goals = goals;
		return goals;
	}

	public int getAssists(int assists)
	{
		this.assists = assists;
		return assists;
	}

	public int getPoints(int points)
	{
		this.points = points;
		return points;
	}

	public double getPointsPerGame(double pointsPerGame)
	{
		this.pointsPerGame = pointsPerGame;
		return pointsPerGame;
	}

	public int getShots(int shots)
	{
		this.shots = shots;
		return shots;
	}

	public int getPowerPlayGoals(int powerPlayGoals)
	{
		this.powerPlayGoals = powerPlayGoals;
		return powerPlayGoals;
	}

	public int getPowerPlayPoints(int powerPlayPoints)
	{
		this.powerPlayPoints = powerPlayPoints;
		return powerPlayPoints;
	}

	public int getOvertimeGoals(int overtimeGoals)
	{
		this.overtimeGoals = overtimeGoals;
		return overtimeGoals;
	}

	public int getShortHandedGoals(int shortHandedGoals)
	{
		this.shortHandedGoals = shortHandedGoals;
		return shortHandedGoals;
	}

	public int getShortHandedPoints(int shortHandedPoints)
	{
		this.shortHandedPoints = shortHandedPoints;
		return shortHandedPoints;
	}

	public double getShotPercent(double shotPercent)
	{
		this.shotPercent = shotPercent;
		return shotPercent;
	}

	public String toString()
	{
		String result = super.toString();

		result += "\nGoals: " + goals
	    +"\nAssists: " + assists
	    +"\nPoints: " + points
	    +"\nPoints Per Game: " + pointsPerGame
	    +"\nShots Taken: " + shots
	    +"\nPowerplay Goals: " + powerPlayGoals
	    +"\nPowerplay Points: " + powerPlayPoints
	    +"\nOvertime Goals: " + overtimeGoals
	    +"\nShorthanded Goals: " + shortHandedGoals
	    +"\nShorthanded Points: " + shortHandedPoints
	    +"\nShot Percent: " + shotPercent;

		return result;
	}
}
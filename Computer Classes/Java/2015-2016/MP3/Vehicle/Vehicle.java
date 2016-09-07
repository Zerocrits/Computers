//Bill Joseph
//vehicle

public class Vehicle
{
	private double speed, cost, wheel;
	private String fuel, name;

	public Vehicle()
	{
		speed=0.0;
		cost=0.0;
		fuel="";
		name="";
	}

		public double getCost()
		{
			return cost;
		}
		public double getSpeed()
		{
			return speed;
		}
		public String getFuel()
		{
			return fuel;
		}
		public String getName()
		{
			return name;
		}

		public void setP (double speed, double cost, String fuel, String name)
		{
			this.speed=speed;
			this.cost=cost;
			this.fuel=fuel;
			this.name=name;
		}

}

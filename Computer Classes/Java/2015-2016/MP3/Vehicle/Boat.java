//Bill Joseph
//Boat

public class Boat extends Vehicle
{
	public void set (double speed, double cost, String fuel, String name)
	{
		super.setP(speed,cost,fuel,name);
	}

	public String toString()
	{
		return "name: " + super.getName() + "\ncost: $" + super.getCost() + "\nfuel: " + super.getFuel() + "\nspeed(mph): " + super.getSpeed();
	}
}
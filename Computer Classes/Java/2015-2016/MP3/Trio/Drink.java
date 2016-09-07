//Bill Joseph
//Trio Lunch Combo
//Build a combo taking 2 largest prices for 3 items

public class Drink implements MenuItem
{
	private String name;
	private double price;

	public Drink(String name, double price)
	{
		this.name = name;
		this.price = price;
	}

	/** @return the name of the Drink  */
	public String getName()
	{
		return name;
	}

	/** @return the price of the Drink  */
	public double getPrice()
	{
		return price;
	}
}
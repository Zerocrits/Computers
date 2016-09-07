//Bill Joseph
//Trio Lunch Combo
//Build a combo taking 2 largest prices for 3 items

public class Salad implements MenuItem
{
	private String name;
	private double price;

	public Salad(String name, double price)
	{
		this.name = name;
		this.price = price;
	}

	/** @return the name of the Salad  */
	public String getName()
	{
		return name;
	}

	/** @return the price of the Salad  */
	public double getPrice()
	{
		return price;
	}
}
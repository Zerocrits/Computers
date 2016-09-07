//Bill Joseph
//Trio Lunch Combo
//Build a combo taking 2 largest prices for 3 items

public class Trio implements MenuItem
{
	private Sandwich sandwich;
	private Salad salad;
	private Drink drink;

	public Trio(Sandwich aSandwich, Salad aSalad, Drink aDrink)
	{
		sandwich = aSandwich;
		salad = aSalad;
		drink = aDrink;
	}

	public String getName()
	{
		String name = sandwich.getName();
		name += " / " + salad.getName() + " / " + drink.getName();
		return name;
	}

	public double getPrice()
	{
		double smallest = sandwich.getPrice();
		double total = 0;
		if(smallest > salad.getPrice())
		{
			total += smallest;
			smallest = salad.getPrice();
		}
		else
		{
			total += salad.getPrice();
		}


		if(smallest > drink.getPrice())
		{
			total += smallest;
			smallest = drink.getPrice();
		}
		else
		{
			total += drink.getPrice();
		}

		return total;
	}

	public String toString()
	{
		String result = "";
		result = getName() + " Trio for: $" + getPrice();
		return result;
	}
}



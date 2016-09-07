//Bill Joseph
//Trio Lunch Combo
//Build a combo taking 2 largest prices for 3 items

public class TrioRunner
{
	public static void main(String[] args)
	{
		Sandwich cheeseBurger = new Sandwich("Cheese Burger", 3.50);
		Sandwich club = new Sandwich("Club Sandwich", 2.75);
		Salad spinach = new Salad("Spinach Salad", 1.25);
		Salad slaw = new Salad("Coleslaw", 1.25);
		Drink orange = new Drink("Orange Soda", 1.25);
		Drink cappuccino = new Drink("Cappuccino", 3.50);

		Trio trio1 = new Trio(cheeseBurger, slaw, orange);
		Trio trio2 = new Trio(club, spinach, cappuccino);

		System.out.println(trio1);
		System.out.println(trio2);
	}
}

/*

Cheese Burger / Coleslaw / Orange Soda Trio for: $4.75
Club Sandwich / Spinach Salad / Cappuccino Trio for: $6.25
Press any key to continue . . .

*/
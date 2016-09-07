import java.util.Scanner;

public class Inventory
{
	boolean burgerIt, hotDogsIt, friesIt, sodaIt, saladIt;
	int burgerInv, hotDogsInv, friesInv, sodaInv, saladInv;
	String result;

	int numOrder;
	String Order, input;

	public Inventory()
	{
		burgerInv = hotDogsInv = friesInv = sodaInv = saladInv = numOrder = 0;
		Order = "";
		result = "";
	}

	public void setInventories()
	{
		burgerInv = 0;
		hotDogsInv = 0;
		friesInv = 0;
		sodaInv = 0;
		saladInv = 0;
	}

	private int getOrdernum(String Order)
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("How many ");
		System.out.println(Order);
		System.out.print(" would you like to order?");

		numOrder = sc.nextInt();
		return numOrder;
	}

	public void Chosen()
	{
		Order = getOrder(input);
		if(Order == "burger")
			burgerInv++;
		else if(Order == "hotdog")
			hotDogsInv++;
		else if(Order == "fries")
			hotDogsInv++;
		else if(Order == "soda")
			sodaInv++;
		else if(Order == "salad")
			saladInv++;
	}

	public String toString()
	{
		result += Order + " " + numOrder + "\n";
		return "" + result;
	}

	public String getOrder(String input)
	{
		String order = input;

		return order;
	}

}


//bill joseph
//build a piggy bank
//spec: Build a piggy bank
import java.text.DecimalFormat;

public class FoodOrder
{
	DecimalFormat numberFormat = new DecimalFormat("#0.00");
	private double total, completeOrder, clearOrder;
	private int soda, pizza, fries, salad, bread;

	public FoodOrder()
	{
		clearOrder();
	}
	public void clearOrder()
	{
		soda = 0;
		pizza = 0;
		fries = 0;
		salad = 0;
		bread = 0;
		total = 0.00;
	}
	public int getSoda()
	{
		return soda;
	}
	public int getPizza()
	{
		return pizza;
	}
	public int getFries()
	{
		return fries;
	}
	public int getSalad()
	{
		return salad;
	}
	public int getBread()
	{
		return bread;
	}
	public double getTotal()
	{
		double total = 0.00;
		total += soda*0.99;
		total += pizza*2.78;
		total += fries*1.15;
		total += salad*3.23;
		total += bread*1.59;
		return total;
	}
	public void addSoda()
	{
		soda++;
	}
	public void addPizza()
	{
		pizza++;
	}
	public void addFries()
	{
		fries++;
	}
	public void addSalad()
	{
		salad++;
	}
	public void addBread()
	{
		bread++;
	}
	public String toString()
	{
		String result = "Total: ";
		result += "$" + numberFormat.format(getTotal()) + "  Soda: " + soda + "  Pizza: " + pizza + "  Fries: " + fries + "  Salad: " + salad + "  Bread: " + bread;
		return result;
	}
	public String getFood()
	{
		int i = 0;
		String food = "Amount of Food Ordered: ";
		i = soda + pizza + fries + salad + bread;
		food += i;
		return food;
	}
}
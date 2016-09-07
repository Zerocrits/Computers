//Bill Joseph
//Car Object
//Holds Car Information

public class Car implements Comparable<Car>
{
	private String make, model;
	private int year, cylinders, mileage, price;
	private boolean manual;

	public Car()
	{
		make = "";
		model = "";
		year = 0;
		cylinders = 0;
		mileage = 0;
		price = 0;
		manual = true;
	}

	public Car(String newMake, String newModel, int newYear, int newCylinders, int newMileage, int newPrice, boolean newManual)
	{
		make = newMake;
		model = newModel;
		year = newYear;
		cylinders = newCylinders;
		mileage = newMileage;
		price =  newPrice;
		manual = newManual;
	}

	public int compareTo(Car r)
	{
		int result = 0;
		if(price > r.getPrice())
			result = 1;
		else if(price < r.getPrice())
			result = -1;
		return result;
	}

	public int getPrice()
	{
		return price;
	}

	public String getMake()
	{
		return make;
	}

	public String getModel()
	{
		return model;
	}

	public String toString()
	{
		String result = "";
		result += make + ", " + model + " " + year;
		result += "\nMileage: " + mileage;
		result += "\nCylinders: " + cylinders;
		result += "\nPrice: " + price;
		if(manual)
			result += "\nManual";
		else
			result += "\nAutomatic";

		return result;
	}

}
//Bill Joseph
//Car Lot Object
//Holds Parking Lot Information

import java.util.ArrayList;
import java.util.Collections;

public class CarLot
{
	private ArrayList<Car> carLot;

	public CarLot()
	{
		carLot = new ArrayList<Car>();
	}

	public void addCar(Car newCar)
	{
		carLot.add(newCar);
	}

	public void insertCar(Car newCar, int pos)
	{
		carLot.add(pos,newCar);
	}

	public void removeCar(int index)
	{
		carLot.remove(index);
	}

	public int getAmtCars()
	{
		return carLot.size();
	}

	public int getLotValue()
	{
		int total=0;
		for(int i = 0; i < carLot.size(); i++)
			total += carLot.get(i).getPrice();
		return total;
	}
	public Car viewCar(int index)
	{
		return carLot.get(index);
	}

	public void sortLot()
	{
		Collections.sort(carLot);
	}

	public String viewLot()
	{
		String lot = "";

		for(int i = 0; i < carLot.size(); i++)
		{
			lot+="Spot Number: " + i + "\n";
			lot+=carLot.get(i) + "\n";
		}

		return lot;
	}
}
//Bill Joseph
//Car Lot Runner
//Organize Parking Lot
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CarLotRunner
{
	public static void main ( String[] args )
	{
		CarLot lot = new CarLot();
		int cmd = 0;
		String make, model, ans;
		int year, cylinders, mileage, price, index;
		boolean manual;
		Car newCar = new Car();
		Scanner sc =  new Scanner(System.in);

		while(cmd < 8)
		{
			System.out.println("1. Add or Insert Car");
			System.out.println("2. Remove Car");
			System.out.println("3. Amount of Cars On Lot");
			System.out.println("4. Value of Cars On Lot");
			System.out.println("5. View Car In Certain Parking Spot");
			System.out.println("6. Sort Parking Lot By Price");
			System.out.println("7. View Entire Lot");
			System.out.println("8. Quit");
			System.out.print("Choice: ");

			cmd = Integer.parseInt(sc.nextLine());

			if(cmd == 1)
			{
				System.out.print("\nMake: ");
				make = sc.nextLine();
				System.out.print("\nModel: ");
				model = sc.nextLine();
				System.out.print("\nYear: ");
				year = Integer.parseInt(sc.nextLine());
				System.out.print("\nCylinders: ");
				cylinders = Integer.parseInt(sc.nextLine());
				System.out.print("\nMileage: ");
				mileage = Integer.parseInt(sc.nextLine());
				System.out.print("\nPrice: ");
				price = Integer.parseInt(sc.nextLine());
				System.out.print("\nIs it Manual?(y/n): ");
				ans = sc.nextLine();
				if(ans.equals("y"))
					manual = true;
				else
					manual = false;
				System.out.println("Would you like to add the car to the next parking spot?(y/n)");
				ans = sc.nextLine();
				newCar =  new Car(make, model, year, cylinders, mileage, price, manual);
				if(ans.equals("n"))
				{
					System.out.println("What # parking spot would you like to park the car?");
					index = Integer.parseInt(sc.nextLine());
					lot.insertCar(newCar, index);
				}
				else
					lot.addCar(newCar);
			}
			else if(cmd == 2)
			{
				System.out.println("\nWhat parking spot would like to remove?");
				index = Integer.parseInt(sc.nextLine());
				lot.removeCar(index);
				System.out.println("Remove Complete!");
			}

			else if(cmd == 3)
			{
				System.out.println("\nLot Total: " + lot.getAmtCars());
			}
			else if(cmd == 4)
			{
				System.out.println("\nLot Value: " + lot.getLotValue());
			}
			else if(cmd == 5)
			{
				System.out.println("\nWhat spot is the car you would like to see?");
				index = Integer.parseInt(sc.nextLine());
				System.out.println("\n" + lot.viewCar(index));
			}
			else if(cmd == 6)
			{
				lot.sortLot();
				System.out.println("\nParking Lot Sorted!");
			}
			else if(cmd == 7)
			{
				System.out.println("\n" + lot.viewLot());
			}

			System.out.println("\n");
		}


	}
}

/*
1. Add or Insert Car
2. Remove Car
3. Amount of Cars On Lot
4. Value of Cars On Lot
5. View Car In Certain Parking Spot
6. Sort Parking Lot By Price
7. View Entire Lot
8. Quit
Choice: 1

Make: Chevy

Model: Comaro

Year: 2010

Cylinders: 6

Mileage: 47000

Price: 15500

Is it Manual?(y/n): y
Would you like to add the car to the next parking spot?(y/n)
y


1. Add or Insert Car
2. Remove Car
3. Amount of Cars On Lot
4. Value of Cars On Lot
5. View Car In Certain Parking Spot
6. Sort Parking Lot By Price
7. View Entire Lot
8. Quit
Choice: 7

Spot Number: 0
Chevy, Comaro 2010
Mileage: 47000
Cylinders: 6
Price: 15500
Manual



1. Add or Insert Car
2. Remove Car
3. Amount of Cars On Lot
4. Value of Cars On Lot
5. View Car In Certain Parking Spot
6. Sort Parking Lot By Price
7. View Entire Lot
8. Quit
Choice: 8


Press any key to continue . . .
*/

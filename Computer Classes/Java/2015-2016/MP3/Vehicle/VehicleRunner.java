//Bill joseph
//Vehicle Runner

import java.util.Scanner;

public class VehicleRunner
{
	public static void main(String[] args)
	{
		Vehicle vehicle = new Vehicle();
		Train train= new Train();
		Plane plane= new Plane();
		Motorcycle cycle= new Motorcycle();
		Boat boat= new Boat();
		Auto auto= new Auto();

		train.set(120.5,1500000.51,"Diesel","Train");
		System.out.println(train.toString());

		plane.set(600.9,3200000.37,"Ultra","Plane");
		System.out.println("\n" + plane.toString());

		boat.set(67.1,87500.21,"Regular","Boat");
		System.out.println("\n" + boat.toString());

		auto.set(180.5,35600.92,"Premium","Car");
		System.out.println("\n" + auto.toString());

		cycle.set(600.9,53000.27,"Regular","Motorcycle");
		System.out.println("\n" + cycle.toString());

	}

}
/*

name: Train
cost: $1500000.51
fuel: Diesel
speed(mph): 120.5

name: Plane
cost: $3200000.37
fuel: Ultra
speed(mph): 600.9

name: Boat
cost: $87500.21
fuel: Regular
speed(mph): 67.1

name: Car
cost: $35600.92
fuel: Premium
speed(mph): 180.5

name: Motorcycle
cost: $53000.27
fuel: Regular
speed(mph): 600.9
Press any key to continue . . .

*/
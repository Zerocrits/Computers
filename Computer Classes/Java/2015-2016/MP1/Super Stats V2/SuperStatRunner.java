//Bill Joseph
//Super Stat Runner
//Class to run main code


public class SuperStatRunner
{
	public static void main(String[] args)
	{
		System.out.println("\t\t\t***Super Stat***");
		SuperStat nums = new SuperStat("10,20,30,40,50,60,70,80,90,100");
		System.out.println(nums);

		nums = new SuperStat("60,50,40,30,20,10");
		System.out.println(nums);


		nums = new SuperStat("10,10,10,20,20,80,85,90,96,32");
		System.out.println(nums);

		nums = new SuperStat("12,38,24,44,66,77,38,44,38,51,44,99");
		System.out.println(nums);

	}
}

/*

                        ***Super Stat***
Number of Values: 10
Arithmetic Mean: 55.00
Geometric Mean: 45.29
Median: 55.0
Mode: null
Min: 10
Max: 100
Range: 90
Standard Deviation: 62.05

Number of Values: 6
Arithmetic Mean: 35.00
Geometric Mean: 29.94
Median: 35.0
Mode: null
Min: 10
Max: 60
Range: 50
Standard Deviation: 38.94

Number of Values: 10
Arithmetic Mean: 45.30
Geometric Mean: 30.73
Median: 26.0
Mode: 10
Min: 10
Max: 96
Range: 86
Standard Deviation: 57.50

Number of Values: 12
Arithmetic Mean: 47.92
Geometric Mean: NaN
Median: 44.0
Mode: 38,44
Min: 12
Max: 99
Range: 87
Standard Deviation: 52.87

Press any key to continue . . .

*/
//ArrayList of User-defined Classes runner

import java.util.ArrayList;
import java.util.Collections;

public class HerdRunner
{
	public static void main (String[] args)
	{
		Herd bunch = new Herd();
		bunch.add(33);
		bunch.add(115);
		bunch.add(16);
		bunch.add(83);
		bunch.add(45);
		bunch.add(96);
		System.out.println(bunch);
		bunch.sortHerd();
		System.out.println("Sorted Big One count = " + bunch);
		System.out.println("Big One count = " + bunch.countBigOnes());
 	}
}
/*

[33, 115, 16, 83, 45, 96]
Sorted Big One count = [16, 33, 45, 83, 96, 115]
Big One count = 3
Press any key to continue . . .

*/
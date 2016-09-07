//Bill Joseph
//Slot Machine
//Spec: Build A Slot Machine

import java.util.Scanner;

public class SlotRunner
{
	public static void main(String[] args)
	{
		String again = "yes";
		Scanner sc = new Scanner(System.in);
		SlotMachine slot = new SlotMachine();
		while(again.equalsIgnoreCase("yes"))
		{
			slot.spinAll();
			System.out.println(slot.toString());
			System.out.print("\nWould You Like to Spin Again?: ");
			again = sc.nextLine();
			System.out.println("");
		}
		System.out.println("Thanks For Using Slot Machine!");
	}
}
/*
|C|C|B|

Would You Like to Spin Again?: Yes

|B|C|D|

Would You Like to Spin Again?: No

Thanks For Using Slot Machine!
Press any key to continue . . .
*/

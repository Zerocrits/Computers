//Bill Joseph
//Bit String Runner
//Runner for Bit string program

import java.util.Stack;
import java.util.Scanner;

public class BitStringRunner
{
	public static void main (String[] args)
	{
		// Make a simple loop to accept bit string expressions as a String
		String choice = "yes";
		String equation = "";
		BitString bit = new BitString();
		Scanner sc = new Scanner(System.in);
		while(choice.equalsIgnoreCase("yes"))
		{
			System.out.println("***Bit String***");

			System.out.println("Hint: LSHIFT-2 010001");
			System.out.print("\nEnter Equation: ");
			equation = sc.nextLine();
			bit = new BitString(equation);
			System.out.println(bit.toString());


			System.out.print("Again? ");
			choice = sc.nextLine();
			System.out.println("\n\n");
		}
		System.out.println("Thanks For Using Bit-String!");
	}
}
/*

***Bit String***
Hint: LSHIFT-2 010001

Enter Equation: LSHIFT-2 010001
Side: L
Index: 2
Action: SHIFT
Bits: 010001
Answer: 000100
Again? Yes



***Bit String***
Hint: LSHIFT-2 010001

Enter Equation: RSHIFT-2 010001
Side: R
Index: 2
Action: SHIFT
Bits: 010001
Answer: 000100
Again? Yes



***Bit String***
Hint: LSHIFT-2 010001

Enter Equation: LCIRC-2 010001
Side: L
Index: 2
Action: CIRC
Bits: 010001
Answer: 000101
Again? Yes



***Bit String***
Hint: LSHIFT-2 010001

Enter Equation: RCIRC-2 010001
Side: R
Index: 2
Action: CIRC
Bits: 010001
Answer: 010100
Again? No



Thanks For Using Bit-String!
Press any key to continue . . .

*/
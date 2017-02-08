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

			System.out.println("Hint: LCIRC-2 00001");
			System.out.print("\nEnter Equation: ");
			equation = sc.nextLine();
			bit = new BitString(equation);
			System.out.println(bit.toString());


			System.out.print("Again? ");
			choice = sc.nextLine();
		}
		System.out.println("Thanks For Using Bit-String!");
	}
}
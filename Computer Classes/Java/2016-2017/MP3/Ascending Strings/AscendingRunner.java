//Bill Joseph
//AscendingStrings
//Spec: Ascending Strings

import java.util.*;
import java.util.Scanner;

public class AscendingRunner
{
	public static void main (String[] args)
	{
		String choice = "yes";
		String phrase = "";
		Scanner sc = new Scanner(System.in);

		while(choice.equalsIgnoreCase("yes"))
		{
			System.out.println("\t\t**Ascending Strings**");
			System.out.print("\nInput a String: ");
			phrase = sc.nextLine();
			AscendingStrings string = new AscendingStrings(phrase);
			System.out.println(string);

			System.out.print("Again? ");
			choice = sc.nextLine();
		}
		System.out.println("Thanks For Using Ascending Runner Program!");
	}
}

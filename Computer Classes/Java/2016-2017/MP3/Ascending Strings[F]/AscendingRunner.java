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
/*

                **Ascending Strings**

Input a String: 31415926538
3 8 14 35 159
Again? Yes
                **Ascending Strings**

Input a String: 314159265
3 5 14 62 159
Again? Yes
                **Ascending Strings**

Input a String: 201617
2 7 16
Again? Yes
                **Ascending Strings**

Input a String: 123456789
1 9 23 87 456
Again? Yes
                **Ascending Strings**

Input a String: 1223334444
1 4 22 44 333
Again? No
Thanks For Using Ascending Runner Program!
Press any key to continue . . .

*/


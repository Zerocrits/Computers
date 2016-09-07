import java.util.Scanner;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class MagpieRunner3
{

	/**
	 * Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args)
	{
		Magpie3 maggie = new Magpie3();

		System.out.println (maggie.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();

		while (!statement.equals("Bye"))
		{
			System.out.println (maggie.getResponse(statement));
			statement = in.nextLine();
		}
	}

}
/*

iteration|psn|before|after
1		 |9  | " "  | ""
2		 |0  | ""   | " "
3		 |8  | " "  | "c"
4		 |19 | " "  | "s"
5		 |3  | "k"  | "w"
6		 |7  | " "  | "t"
7		 |22 | "s"  | "w"



*/

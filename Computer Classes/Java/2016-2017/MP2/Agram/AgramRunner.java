import java.util.*;

public class AgramRunner
{
	public static void main (String[] args)
	{
		boolean choice = true;
		Scanner sc = new Scanner(System.in);
		while(choice == true)
		{
			System.out.println("~~~~Agram Card Game~~~~");
			String deck = "";
			System.out.print("Please Enter Cards: ");
			deck = sc.nextLine();
			Agram game = new Agram(deck);
			System.out.println("Players Lead: " + game.getPlayer());
			System.out.println("The best card to pick is: " + game.toString());
			System.out.print("Would you Like to play again: ");
			if(sc.nextLine() == "yes");
				choice = true;
			System.out.println("\n\n");
		}
		System.out.println("Thanks for playing Agram!");
	}

}
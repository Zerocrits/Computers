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
			if(sc.nextLine() != "yes");
				choice = false;
			System.out.println("\n\n");
		}
		System.out.println("Thanks for playing Agram!");
	}

}

/*

~~~~Agram Card Game~~~~
Please Enter Cards: 5D, 2D, 6H, 9D, TD, 6H
Players Lead: 5D
The best card to pick is: 9D
Would you Like to play again: Yes



~~~~Agram Card Game~~~~
Please Enter Cards: TC, AC, KC, QH, JS, TD
Players Lead: TC
The best card to pick is: KC
Would you Like to play again: Yes



~~~~Agram Card Game~~~~
Please Enter Cards: 3D, 4H, 5C, 6S, 2D, 7H
Players Lead: 3D
The best card to pick is: 2D
Would you Like to play again: Yes



~~~~Agram Card Game~~~~
Please Enter Cards: KS, TH, QC, 3D, 9H, 3H
Players Lead: KS
The best card to pick is: 3D
Would you Like to play again: Yes



~~~~Agram Card Game~~~~
Please Enter Cards: AC, AD, KH, AS, KS, QS
Players Lead: AC
The best card to pick is: AD
Would you Like to play again: No



Thanks for playing Agram!

*/
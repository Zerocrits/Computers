import java.util.*;

public class AgramRunner
{
	public static void main (String[] args)
	{
		System.out.println("~~~~Agram Card Game~~~~");
		String deck = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Cards: ");
		deck = sc.nextLine();
		Agram game = new Agram(deck);
		System.out.println("Players Lead: " + game.getPlayer());
		System.out.println("The best card to pick is: " + game.toString());
	}


}
import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;

public class War
{
	private Players player = new Players();
	private Deck deck;

	int p1 = 0; //card score
	int p2 = 0;
	int d1 = 0; //discard spot
	int d2 = 0;
	int l1 = 0; //deck location
	int l2 = 0;
	int cardsDown = 0;

	private String Player1 = "Bob";
	private String Player2 = "Paul";
	String[] deck1, deck2;
	String[] discard1, discard2;
	private String[] ranks = {"2","3","4","5","6","7","8","9","1","J","Q","K","A"};

	public War()
	{
		Players p1 = new Players(Player1);
		deck1 = p1.playersDeck().split(", ");

		Players p2 = new Players(Player2, deck1);
		deck2 = p2.otherPlayersDeck().split(", ");

		discard1 = new String[52];
		discard2 = new String[52];

		l1 = deck1.length-1;
		l2 = deck2.length-1;
		playRound();
	}

	public void placeCards() //use this to see each players cards****
	{
		for(int i = 1; i < deck1.length; i++)
			System.out.println(i + " P1: " + deck1[i]);

		for(int i = 1; i < deck2.length; i++)
			System.out.println(i + " P2: " + deck2[i]);
	}

	public void playRound()
	{
		String anotherWar = "y";
		String again = "y";
		Scanner sc = new Scanner(System.in);

		while(again.equalsIgnoreCase("y"))
		{
			for(int i = 0; i < ranks.length; i++)
			{
				if(ranks[i].charAt(0) == deck1[l1].charAt(0))
					p1 = i;
				if(ranks[i].charAt(0) == deck2[l2].charAt(0))
					p2 = i;
			}

			System.out.println("[" + l1 + "] Player1: " + deck1[l1]); //prefix is # cards in hand remaining
			System.out.println("[" + l2 + "] Player2: " + deck2[l2]);

			if(getWinner(p1, p2) == "p1")
			{
				System.out.println("\n\n*******************");
				System.out.println("***Player1 Wins!***");
				System.out.println("*******************");
				discard1[d1] = deck1[l1];
				d1++;
				discard1[d1] = deck2[l2];
				d1++;
			}

			else if(getWinner(p1, p2) == "p2")
			{
				System.out.println("\n\n*******************");
				System.out.println("***Player2 Wins!***");
				System.out.println("*******************");
				discard2[d2] = deck1[l1];
				d2++;
				discard2[d2] = deck2[l2];
				d2++;
			}

			if(l1 == 1) //time to shuffffffffffle
				startShuffle(false, 0, "Player1");
			if(l2 == 1)
				startShuffle(false, 0, "Player2");

			else if(getWinner(p1, p2) == "same")
			{
				while(anotherWar.equalsIgnoreCase("y"))
				{
					anotherWar = "n";
					cardWar(p1, p2, d1, d2, l1, l2); //happens  before shuffle

					if(getWinner(p1, p2) == "same") //p is not changing so infinite loop
						anotherWar = "y";
					else
						anotherWar = "n";
				}
			}
			l1--;
			l2--;

			System.out.print("\n***Ready to Continue? (y/n): ");
			again = sc.nextLine();
			System.out.println("\n\n\n\n");
		}
		if((l1 > 0 || l2 > 0) && (d1 > 0 || d2 > 0))
		{
			System.out.println("Too bad");
			playRound();
		}
		else
			System.out.println("Good Game!");
	}



	public String getWinner(int player1, int player2)
	{
		if(player2 > player1)
			return "p2";
		if(player2 == player1)
			return "same";
		if(player1 > player2)
			return "p1";
		return "no winner";
	}




	public void cardWar(int p1, int p2, int d1, int d2, int l1, int l2)
	{
		String deck = "";
		boolean middleWar = false;

		if((l1 <= 4 || l2 <= 4) || (l1 <= 4 && l2 <= 4)) //time to shuffffffffffle
		{
			middleWar = true;

			if(l1 <= 4)
				startShuffle(middleWar, l1, "Player1");
			if(l2 <= 4)
				startShuffle(middleWar, l2, "Player2");
		}

		System.out.println("\n**Player1 Cards Sent to War: ");
		for(int i = 1; i <= 3; i++)
		{
			System.out.println(i+". "+ deck1[l1-i]);
		}

		System.out.println("\n****Player2 Cards Sent to War: ");
		for(int i = 1; i <= 3; i++)
		{
			System.out.println(i+". "+ deck2[l2-i]);
		}

		cardsDown += -3;

		System.out.println("\nPlayer1: " + deck1[l1-4]);
		System.out.println("Player2: " + deck2[l2-4]);

		cardsDown += -1;

		for(int i = 0; i < ranks.length; i++)
		{
			if(ranks[i].charAt(0) == deck1[l1+cardsDown].charAt(0))
				p1 = i;
			if(ranks[i].charAt(0) == deck2[l2+cardsDown].charAt(0))
				p2 = i;
		}

		if(getWinner(p1, p2) == "p1")
		{
			System.out.println("Player1 Wins!");
			for(int i = 0; i < 3+cardsDown; i++)
			{
				discard1[d1] = deck1[l1];
				d1++;
				l1--;
				discard1[d1] = deck2[l2];
				d1++;
				l2--;
			}
		}

		else if(getWinner(p1, p2) == "p2")
		{
			for(int i = 0; i < 3+cardsDown; i++)
			{
				System.out.println("Player2 Wins!");
				discard2[d2] = deck1[l1];
				d2++;
				l1--;
				discard2[d2] = deck2[l2];
				d2++;
				l2--;
			}
		}

		else if(getWinner(p1, p2) == "Same")
			cardWar(p1,p2,d1,d2,l1,l2);
	}




	public void startShuffle(boolean midwar, int num, String player)
	{
		String[] tdeck;
		if(player == "Player1")
		{
			tdeck = new String[discard1.length + num];
			for(int i = 0; i < tdeck.length-num; i++)
			{
				if(i < num)
				{
					tdeck[i] = deck1[l1];
					l1--;
				}
				tdeck[i+num] = discard1[i];
			}
			deck1 = new String[tdeck.length];
			for(int i = 0; i < deck1.length; i++)
			{
				deck1[i] = tdeck[i];
			}
			Collections.shuffle(Arrays.asList(deck1));
		}
		if(player == "Player2")
		{
			tdeck = new String[discard2.length + num];
			for(int i = 0; i < tdeck.length-num; i++)
			{
				if(i < num)
				{
					tdeck[i] = deck2[l1];
					l2--;
				}
				tdeck[i+num] = discard2[i];
			}
			deck2 = new String[tdeck.length];
			for(int i = 0; i < deck2.length; i++)
			{
				deck2[i] = tdeck[i];
			}
			Collections.shuffle(Arrays.asList(deck2));
		}
	}
}

import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;

public class War
{
	private Players player = new Players();
	private Deck deck;

	private int p1 = 0; //card score
	private int p2 = 0;
	private int d1 = 0; //discard spot
	private int d2 = 0;
	private int l1 = 0; //deck location
	private int l2 = 0;
	private int cardsDown = 0;
	private int rollover = 0;

	private String result = "";
	private String Player1 = "Bob";
	private String Player2 = "Paul";
	private String[] deck1, deck2;
	private String[] discard1, discard2;
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
			System.out.println("made it" +l1);
			if(l1 == 1) //time to shuffle
				startShuffle(false, 0, "Player1");
			if(l2 == 1)
				startShuffle(false, 0, "Player2");

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

			if(getWinner(p1, p2) == "same")
			{
				while(anotherWar.equalsIgnoreCase("y"))
				{
					anotherWar = "n";
					result = cardWar(p1, p2, d1, d2, l1, l2);

					if(result == "same")
						anotherWar = "y";
					else
						anotherWar = "n";

					for(int i = 0; i < 4*rollover; i++)
					{
						if(result == "p1")
						{
							discard1[d1] = deck1[l1];
							d1++;
							l1--;
							discard1[d1] = deck2[l2];
							d1++;
							l2--;
						}
						if(result == "p2")
						{
							discard2[d2] = deck1[l1];
							d2++;
							l1--;
							discard2[d2] = deck2[l2];
							d2++;
							l2--;
						}
						if(result == "same")
							rollover += 1;
					}
				}
				rollover = 0;
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




	public String cardWar(int p1, int p2, int d1, int d2, int l1, int l2)
	{
		String deck = "";
		boolean middleWar = false;
		cardsDown = 0;

		if((l1 <= 4 || l2 <= 4) || (l1 <= 4 && l2 <= 4)) //time to shuffle
		{
			middleWar = true;

			if(l1 <= 4)
				startShuffle(middleWar, l1, "Player1");
			if(l2 <= 4)
				startShuffle(middleWar, l2, "Player2");
		}

		middleWar = false;

		System.out.println("\n**Player1 Cards Sent to War: ");
		for(int i = 1; i <= 3; i++)
		{
			l1--;
			System.out.println("[" + (l1) + "]" + i + ". " + deck1[l1]);
		}

		System.out.println("\n****Player2 Cards Sent to War: ");
		for(int i = 1; i <= 3; i++)
		{
			l2--;
			System.out.println("[" + (l2) + "]" + i + ". " + deck2[l2]);
		}

		l1--;
		l2--;

		System.out.println("\n[" + (l1) + "]Player1: " + deck1[l1]);
		System.out.println("[" + (l2) + "]Player2: " + deck2[l2]);


		for(int i = 0; i < ranks.length; i++)
		{
			if(ranks[i].charAt(0) == deck1[l1].charAt(0))
				p1 = i;
			if(ranks[i].charAt(0) == deck2[l2].charAt(0))
				p2 = i;
		}
		return getWinner(p1, p2);
	}




	public void startShuffle(boolean midwar, int num, String player)
	{
		int temp = 0;
		String[] tdeck;

		System.out.println("*******SHUFFLING " + player);

		if(player == "Player1")
		{
			for(int i = 0; i < discard1.length; i++)
			{
				if(discard1[i] != null)
					temp++;
			}

			tdeck = new String[temp + num];
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
			l1 = deck1.length-1;
			discard1 = new String[temp*2];
			d1 = 0;
		}
		if(player == "Player2")
		{
			for(int i = 0; i < discard2.length; i++)
			{
				if(discard2[i] != null)
					temp++;
			}

			tdeck = new String[temp + num];
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
			l2 = deck2.length-1;
			discard2 = new String[temp*2];
			d2 = 0;
		}
	}
}

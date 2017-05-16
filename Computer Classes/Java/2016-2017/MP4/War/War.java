public class War
{
	private Players player = new Players();
	private Deck deck;
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

		//placeCards();
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
		int p1 = 0;
		int p2 = 0;
		int d1 = 0;
		int d2 = 0;
		int l1 = deck1.length-1;
		int l2 = deck2.length-1;

		for(int i = 0; i < ranks.length; i++)
		{
			if(ranks[i].charAt(0) == deck1[l1].charAt(0))
				p1 = i;
			if(ranks[i].charAt(0) == deck2[l2].charAt(0))
				p2 = i;
		}

		System.out.println("Player1: " + deck1[l1]);
		System.out.println("Player2: " + deck2[l2]);

		if(getWinner(p1, p2) == "p1")
		{
			System.out.println("Player1 Wins!");
			discard1[d1] = deck1[l1];
			d1++;
			discard1[d1] = deck2[l2];
			d1++;
		}

		else if(getWinner(p1, p2) == "p2")
		{
			System.out.println("Player2 Wins!");
			discard2[d2] = deck1[l1];
			d2++;
			discard2[d2] = deck2[l2];
			d2++;
		}

		else if(getWinner(p1, p2) == "same")
		{
			System.out.println("\n**Player1 Cards Sacrificed: ");
			for(int i = 1; i <= 3; i++)
			{
				System.out.println(i+". "+ deck1[l1-i]);
			}

			System.out.println("\n****Player2 Cards Sacrificed: ");
			for(int i = 1; i <= 3; i++)
			{
				System.out.println(i+". "+ deck2[l2-i]);
			}

			System.out.println("Player1: " + deck1[l1-4]);
			System.out.println("Player2: " + deck2[l2-4]);
		}

		l1--;
		l2--;
	}

	public String getWinner(int player1, int player2)
	{
		if(player2 > player1)
			return "p2";
		if(player2 == player1)
			return "same";
		else
			return "p1";
	}

	public String cardWar()
	{

		return "";
	}
}

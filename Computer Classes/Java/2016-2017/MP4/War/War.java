public class War
{
	private Players player = new Players();
	private Deck deck;
	private String Player1 = "Bob";
	private String Player2 = "Paul";
	String[] deck1, deck2;

	public War()
	{
		Players p1 = new Players(Player1);

		deck1 = p1.playersDeck().split(", ");

		Players p2 = new Players(Player2, deck1);

		deck2 = p2.otherPlayersDeck().split(", ");

		placeCards();
	}

	public void placeCards()
	{
		for(int i = 1; i < deck1.length; i++)
			System.out.println(i + " P1: " + deck1[i]);

		for(int i = 1; i < deck2.length; i++)
			System.out.println(i + " P2: " + deck2[i]);
	}
}

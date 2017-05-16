public class Players
{
	public String deck, otherDeck, player;
	private Deck card = new Deck();
	String hand;
	String[] handarr;
	String cards;

	public Players()
	{

	}

	public Players(String player)
	{
		card = new Deck();
		this.player = player;
	}

	public Players(String player, String[] hand)
	{
		card = new Deck();
		this.player = player;
		handarr = hand;
	}

	public String playersDeck()
	{
		for(int i = 1; i < 27; i++)
		{
			hand += card.deal();
			if(hand.equals("null"))
				return hand;
			if(i != 26)
				hand += ", ";
		}
		return hand;
	}

	public String otherPlayersDeck()
	{
		//card.shuffle();
		cards = "";
		for(int i = 1; i <= handarr.length; i++)
		{
			cards = ""+card.deal();

			for(int j = 1; j < handarr.length; j++)
			{
				if(cards.equals(handarr[j]))
				{
					i--;
					j=handarr.length;
				}
				if(j == handarr.length-1)
				{
					otherDeck += ""+cards;
					otherDeck += ", ";
				}
			}
		}
		return otherDeck;
	}
}
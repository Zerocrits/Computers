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
		cards = "";
		for(int i = 1; i < handarr.length; i++)
		{
			for(int j = 1; j < handarr.length; j++)
			{
				cards = ""+card.deal();
				System.out.println(card.size() + "   " + handarr[j]);
				if(cards.equals(handarr[j]))
				{
					i++;
					j=-0;
				}
				if(j == handarr.length-1)
				{
					//j = handarr.length-1;
					otherDeck += ""+cards;

					if(i != (card.size()-1))
						otherDeck += ", ";
				}
			}
		}
		return otherDeck;
	}
}
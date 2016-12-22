import java.util.*;

public class AgramCard
{
	String[] deck;
	String lead;

	public AgramCard()
	{
		deck = new String[5];
		lead = "";
	}
	public AgramCard(String[] cards, String lead)
	{
		deck = cards;
		lead = this.lead;
		//System.out.println(deck[0] + " " + deck[4] + " " + cards[0]);
	}
	public boolean getValue(String value)
	{
		String ranks = "A23456789TJQK";

		if(ranks.indexOf(value.substring(0,1)) > ranks.indexOf(lead.substring(0,1)))//null
		{
			return true;//returns place in array if deck is > lead
		}

		return false;
	}
	public String getSuit()
	{
		String ranks = "CDHS"; //clubs diamonds hearts spades
		for(int i = 0; i < deck.length; i++)
		{
			System.out.println("made it here");
			if(ranks.indexOf(deck[i].charAt(1)) >= ranks.indexOf(lead.charAt(1)))//null
			{
				if(getValue(deck[i]) == true)
				{
					return deck[i];
				}
			}
		}
		return "No Winnable Card";
	}
}
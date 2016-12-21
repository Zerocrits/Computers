import java.util.*;

public class AgramCard
{
	String[] deck;
	String lead;

	public AgramCard(String[] cards, String lead)
	{
		deck = cards;
		lead = this.lead;
	}
	public boolean getValue(String value)
	{
		String ranks = "A23456789TJQK";

		if(ranks.indexOf(value.charAt(0)) > ranks.indexOf(lead.charAt(0)))
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
			if(ranks.indexOf(deck[i].charAt(1)) >= ranks.indexOf(lead.charAt(1))) //TRY SUBSTRING
			{
				if(getValue(deck[i]) == true)
					return deck[i];
			}
			/*else if(ranks.indexOf(deck[i].charAt(0)) == ranks.indexOf(lead.charAt(1)))
			{
				if(getValue(deck[i]) == true)
					return deck[i];
			}*/
		}
		return "No Winnable Card";
	}
}
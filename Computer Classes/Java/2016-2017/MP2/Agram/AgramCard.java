import java.util.*;
import java.io.*;

public class AgramCard
{
	String[] deck, Zcards;
	String lead;

	public AgramCard()
	{
		deck = new String[5];
		lead = "";
	}
	public AgramCard(String[] cards, String leader)
	{
		deck = cards;
		lead = leader;
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
		String ranked = "A23456789TJQK";
		String lowest = "KS";
		for(int i = 0; i < deck.length; i++)
		{
			if(ranks.indexOf(deck[i].substring(1)) == ranks.indexOf(lead.substring(1)))//same suit
			{
				if(getValue(deck[i]) == true)
				{
					return deck[i];
				}
			}
		}
		for(int i = 0; i < deck.length; i++)
		{
			if(ranks.indexOf(deck[i].substring(1)) == ranks.indexOf(lead.substring(1)))//same suit
			{
				if(getValue(deck[i]) == false)
				{
					if(ranked.indexOf(lowest.substring(0,1)) > ranked.indexOf(deck[i].substring(0,1)))
					{
						lowest = deck[i];
					}
					if(i == deck.length-1)
					{
						return lowest;
					}
				}
			}
		}
		for(int i = 0; i < deck.length; i++)
		{
			if(ranked.indexOf(deck[i].substring(0,1)) < ranked.indexOf(lead.substring(0,1)))
			{
				if(ranked.indexOf(lowest.substring(0,1)) > ranked.indexOf(deck[i].substring(0,1)))
					lowest = deck[i];
				if(i == deck.length-1)
				{
					return lowest;
				}
			}
		}
		return "No Winnable Card(error)";
	}
}
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
		for(int i = 0; i < deck.length; i++)
		{
			if(ranks.indexOf(deck[i].substring(1)) == ranks.indexOf(lead.substring(1)))//null
			{
				if(getValue(deck[i]) == true)
				{
					return deck[i];
				}
			}//add so if its not the same card type it can still find it
		}
		return "No Winnable Card";
	}
}
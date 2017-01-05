import java.util.*;

public class Agram
{
	String[] deck;
	String playerLead;
	String[] dealerCard;

	public Agram(String tdeck)
	{
		deck = tdeck.split(", ");
		dealerCard = new String[5];
		setPlayer();
		setDealer();
	}
	public void setPlayer()
	{
		playerLead = deck[0];
	}
	public String getPlayer()
	{
		return playerLead;
	}
	public void setDealer()
	{
		for(int i = 0; i < deck.length-1; i++)
		{
			dealerCard[i] = deck[i+1];
		}
	}
	public String[] getDealer()
	{
		return dealerCard;
	}
	public String toString()
	{
		AgramCard suit = new AgramCard(dealerCard, playerLead);
		String result = suit.getSuit();
		return result;
	}
}
//ArrayList of User-defined Classes

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Herd
{
	private List<Creature> list;

	public Herd()
	{
		list = new ArrayList<Creature>();
	}

	public void add(int creatureSize)
	{
		list.add(new Creature(creatureSize));
		//add a new Creature to the list with the size given
	}

	/* method countBigOnes should return the count of
	    big creatures - use the isBig() Creature method
	*/
	public int countBigOnes()
	{
		int total = 0;
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).isBig() == true)
				total++;
		}
		return total;
	}

	/** sorts this list of Creatures (Herd)
	*	Note: compareTo() is already implemented and Creature implements Comparable
	*		  There may be a built in sort ready to go... use it!
	*/
	public void sortHerd()
	{
		Collections.sort(list);
	}

	public String toString()
	{
		return "" + list;
	}
}
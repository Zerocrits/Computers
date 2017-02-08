//Bill Joseph
//AscendingStrings
//Spec: Ascending Strings

import java.util.Scanner;
import java.util.*;

public class AscendingStrings
{
	ArrayList<String> list;
	String string;
	int lastNum;


	public AscendingStrings()
	{
		list = new ArrayList<String>();
		string = "";
		lastNum = 0;
	}

	/** Uses setExpression to set the state of the object
	*	Note: expression should be converted to uppercase
	*/
	public AscendingStrings(String string)
	{
		this.string = string;
		list = new ArrayList<String>();
		lastNum = 0;
		solve();
	}

	public void solve()
	{
		list.add(string.substring(0)); //first point
		lastNum = Integer.parseInt(list.get(0));
		int newNum = 10;

		for(int i = 1; i < list.size(); i++)
		{
			if(isBigger(newNum, lastNum))
			{
				if(i%2 != 0)
				{
					for(int j = string.length(); j >= string.length()-1; j--)
					{
						list.add(string.substring(j));
						newNum += Integer.parseInt(list.get(j));
					}
				}
				else
				{
					for(int j = list.get(i-2).length(); j < list.get(i-1).length(); j++)
					{
						list.add(string.substring(j));
					}
				}
				lastNum = newNum;
			}
		}
	}

	public boolean isBigger(int spot, int lastNum)
	{
		if(spot > lastNum)
			return true;
		return false;

	}
	public String toString()
	{
		return Arrays.toString(list.toArray());
	}
}

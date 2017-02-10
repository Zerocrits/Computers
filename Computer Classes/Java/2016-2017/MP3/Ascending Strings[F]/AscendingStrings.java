//Bill Joseph
//AscendingStrings
//Spec: Ascending Strings

import java.util.Scanner;
import java.util.*;

public class AscendingStrings
{
	ArrayList<String> list;
	String sNums;

	/** Uses setExpression to set the state of the object
	*	Note: expression should be converted to uppercase
	*/
	public AscendingStrings(String string)
	{
		sNums = string;//remove first num frim string
		list = new ArrayList<String>();
		list.add(string.substring(0,1)); //first point
		sNums = sNums.substring(1);
		solve();
	}

	private void solve()
	{
		boolean cont = true;
		int spot = 1;

		while(cont)
		{
			if(spot % 2 == 0)
				cont = numStart();
			else
				cont = numEnd();
			spot++;
		}
	}

	private boolean numStart()
	{
		int i = 1;
		while(i <= sNums.length() && Integer.parseInt(list.get(list.size()-1)) >= Integer.parseInt(sNums.substring(0,i)))
			i++;
		if(i > sNums.length())
			return false;

		if(Integer.parseInt(sNums.substring(0,i)) > Integer.parseInt(list.get(list.size()-1)))
		{
			if(sNums.substring(0,1) == "0")
				sNums = sNums.substring(1);
			list.add(sNums.substring(0,i));
		}

		sNums = sNums.substring(i);

		return true;
	}

	public boolean numEnd()
	{
		String num = "";
		if(sNums.length() != 0)
		{
			num	= sNums.substring(sNums.length()-1);
			sNums = sNums.substring(0, sNums.length()-1);
		}
		else
			return false;

		while(sNums.length() != 0 && Integer.parseInt(num) <= Integer.parseInt(list.get(list.size()-1)))
		{
			num += sNums.substring(sNums.length()-1);
			sNums = sNums.substring(0, sNums.length()-1);
		}

		if(Integer.parseInt(num) > Integer.parseInt(list.get(list.size()-1)))
		{
			if(num.substring(0,1) == "0")
				num = num.substring(1);
			list.add(num);
		}

		return true;
	}

	public String toString()
	{
		String end = "";
		for(int i = 0; i < list.size(); i++)
			end += Integer.parseInt(list.get(i)) + " ";
		return end;
	}
}

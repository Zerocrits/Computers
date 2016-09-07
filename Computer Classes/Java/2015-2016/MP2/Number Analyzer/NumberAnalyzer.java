// Name:
// Prog:
// Spec:

import java.util.ArrayList;
import java.util.Scanner;

public class NumberAnalyzer
{
	private ArrayList<Number> list;

	public NumberAnalyzer()
	{
		list = new ArrayList<Number>();
	}

	public NumberAnalyzer(String numbers)
	{
		String[] strNums = numbers.split(" ");
		list = new ArrayList<Number>();

		for(int i = 0; i < strNums.length; i++)
			list.add(new Number(Integer.parseInt(strNums[i])));
	}

	public void setList(String numbers)
	{
		String[] strNums = numbers.split(" ");
		list.clear();

		for(int i = 0; i < strNums.length; i++)
			list.add(new Number(Integer.parseInt(strNums[i])));
	}

	public int countOdds()
	{
		int oddCount = 0;
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).isOdd())
				oddCount++;
		}
		return oddCount;
	}
	public int countEvens()
	{
      	int evenCount = 0;
      	boolean num;
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).isOdd() == false)
				evenCount++;
		}
      	return evenCount;
	}

	public int countPerfects()
	{
		int perfectCount = 0;
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).isPerfect() == true)
				perfectCount++;
		}
      	return perfectCount;
	}

	public String toString()
	{
		String listString = "[";

		for (int i = 0; i < list.size(); i++)
		{
			if(i == list.size()-1)
		    	listString += (list.get(i) + "");
		    else
		    	listString += (list.get(i) + " ");

		}
		listString += "]";

		return listString;
	}
}
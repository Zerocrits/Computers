//Name: Bill Joseph
//Spec: Build a program the demonstrates Linked List
//Build a program using Linked List with the given test cases

import java.util.LinkedList;


public class JavaLinkedList
{
	private LinkedList<Integer> list;

	public JavaLinkedList()
	{
		list = new LinkedList<Integer>();
	}

	public JavaLinkedList(int[] nums)
	{
		list = new LinkedList<Integer>();
		for(int num : nums)
		{
			list.add(num);
		}
	}

	public int getSum()
	{
		int total = 0;
		for(int n : list)
		{
			total += n;
		}
		return total;
	}

	public double getAvg()
	{
		double avg = 0.0;
		int counter = 0;
		for(int n : list)
		{
			avg += n;
			counter++;
		}
		return avg / counter;
	}

	public int getLargest()
	{
		int largest =Integer.MIN_VALUE;
		for(int n : list)
		{
			if(largest < n)
				largest = n;
		}

		return largest;
	}

	public int getSmallest()
	{
		int smallest = smallest=Integer.MAX_VALUE;
		for(int n : list)
		{
			if(smallest > n)
				smallest = n;
		}

		return smallest;
	}

	public String toString()
	{
		String result = "Test Case: " + list;
		result += "\nSum: " + getSum();
		result += "\nAverage: " + getAvg();
		result += "\nMinimum: " + getSmallest();
		result += "\nMaximum: " + getLargest() + "\n\n";
		return result;
	}
}
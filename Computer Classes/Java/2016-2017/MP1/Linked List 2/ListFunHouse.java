// Name - Bill Joseph
// Prog - List Fun House
// Spec - Practice with Linked Lists

public class ListFunHouse
{
	//this method will print the entire list on the screen
	public static void print(ListNode list)
	{
		System.out.println(list);
	}

	//this method will return the number of nodes present in list
	public static int nodeCount(ListNode list)
	{
   		int count = 0;
   		if(list.getNext() != null)
   		{
			count++;
		}
		return count;
	}

	//this method will create a new node with the same value as the first node and add this
	//new node to the list.  Once finished, the first node will occur twice.
	public static void doubleFirst(ListNode list)
	{
		String first = list.getNext();
		list.setValue(first);
	}

	//this method will create a new node with the same value as the last node and add this
	//new node at the end.  Once finished, the last node will occur twice.
	public static void doubleLast(ListNode list)
	{
   		ListNode prev=null;
	}

	//method skipEveryOther will remove every other node
	public static void skipEveryOther(ListNode list)
	{
	}

	//this method will set the value of every xth node in the list
	public static void setXthNode(ListNode list, int x, Comparable value)
	{
		int count=1;
	}

	//this method will remove every xth node in the list
	public static void removeXthNode(ListNode list, int x)
	{
		int count = 0;
		while(list.getNext != null)
		{
			count++;
			if(count == x)
				list.setValue(null);
		}
	}
}
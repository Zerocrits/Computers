// Name - Bill Joseph
// Prog - List Fun House
// Spec - Practice with Linked Lists

public class ListFunHouse
{
	//this method will print the entire list on the screen
	public static void print(ListNode list)
	{
		while(list != null)
		{
			System.out.print(list.getValue() + " ");
			list = list.getNext();
	    }
	}

	//this method will return the number of nodes present in list
	public static int nodeCount(ListNode list)
	{
   		int count = 0;
   		while(list != null)
   		{
			count++;
			list = list.getNext();
		}
		return count;
	}

	//this method will create a new node with the same value as the first node and add this
	//new node to the list.  Once finished, the first node will occur twice.
	public static void doubleFirst(ListNode list)
	{
		ListNode temp = new ListNode(list.getValue(),list);
		print(temp);
	}

	//this method will create a new node with the same value as the last node and add this
	//new node at the end.  Once finished, the last node will occur twice.
	public static void doubleLast(ListNode list)
	{
		ListNode temp = new ListNode(list.getValue(),list);
		while(temp == null)
			temp.setNext(list);
		print(temp);
	}

	//method skipEveryOther will remove every other node
	public static void skipEveryOther(ListNode list)
	{
		int length = nodeCount(list);
		ListNode temp = new ListNode();
		//for(int i = 0; i < length; i++)
		//{
			//if(i%2 == 0)
				//temp.getNext(list);
		//}
	}

	//this method will set the value of every xth node in the list
	public static void setXthNode(ListNode list, int x, Comparable value)
	{
		int count = 0;
		int length = nodeCount(list);
		ListNode temp = new ListNode();
		for(int i = 0; i < length; i++)
		{
			if(count == x)
			{
				count = 0;
				temp = new ListNode(i, list);
			}
			else
			{
				temp = new ListNode(i, list);
				count++;
			}
		}
	}

	//this method will remove every xth node in the list
	public static void removeXthNode(ListNode list, int x)
	{
		int count = 0;
		int length = nodeCount(list);
		ListNode temp = new ListNode();
		for(int i = 0; i < length; i++)
		{
			if(count == x)
			{
				count = 0;
			}
			else
			{
				temp = new ListNode(i, list);
				count++;
			}
		}
	}
}
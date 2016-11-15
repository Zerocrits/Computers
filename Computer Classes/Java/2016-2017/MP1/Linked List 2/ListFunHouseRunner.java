// Name - Bill Joseph
// Prog - List Fun House
// Spec - Practice with Linked Lists

import java.util.*;

public class ListFunHouseRunner
{
	public static void main(String[] args)
	{
		ListNode z = new ListNode("go",
			 		new ListNode("on",
		      		new ListNode("at",
		       		new ListNode("34",
			 		new ListNode("2.1",
		      		new ListNode("-a-2-1",
		       		new ListNode("up",
			 		new ListNode("over",null))))))));

		System.out.println("Lab15b Test Code\n\n");

		System.out.println("Original list values\n");
		ListFunHouse.print(z);
		System.out.println("\n");

		System.out.println("num nodes = " + ListFunHouse.nodeCount(z));

		System.out.println("\nList values after calling nodeCount\n");
		ListFunHouse.print(z);
		System.out.println();

		ListFunHouse.doubleFirst(z);
		System.out.println("\nList values after calling doubleFirst\n");
		ListFunHouse.print(z);
		System.out.println();

		ListFunHouse.doubleLast(z);
		System.out.println("\nList values after calling doubleLast\n");
		ListFunHouse.print(z);
		System.out.println();

		ListFunHouse.removeXthNode(z,2);
		System.out.println("\nList values after calling removeXthNode(2)\n");
		ListFunHouse.print(z);
		System.out.println();

		ListFunHouse.setXthNode(z,2,"one");
		System.out.println("\nList values after calling setXthNode(2,one)\n");
		ListFunHouse.print(z);
		System.out.println();
	}
}
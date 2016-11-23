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

		System.out.println("**Lab 15b Test Code**\n");

		System.out.println("Original list values:");
		ListFunHouse.print(z);
		System.out.println("\n");

		System.out.println("num nodes = " + ListFunHouse.nodeCount(z));

		System.out.println("\nList values after calling nodeCount:");
		ListFunHouse.print(z);
		System.out.println();

		System.out.println("\nList values after calling doubleFirst:");
		ListFunHouse.doubleFirst(z);
		System.out.println();

		System.out.println("\nList values after calling doubleLast:");
		ListFunHouse.doubleLast(z);
		System.out.println();

		System.out.println("\nList values after calling removeXthNode(2):");
		ListFunHouse.removeXthNode(z,2);
		System.out.println();

		System.out.println("\nList values after calling setXthNode(2,one):");
		ListFunHouse.setXthNode(z,2,"one");
		System.out.println();
	}
}
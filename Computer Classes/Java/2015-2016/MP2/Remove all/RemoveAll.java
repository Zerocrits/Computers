//Bill Joseph
//Arraylist program chooser
//ArrayList remove() exercise

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveAll
{
	public static void main(String args[])
	{
		int again = 0;
		Scanner sc = new Scanner(System.in);
		String[] words = new String[10];
		while(again != 5)
		{
			words[0]=("all");
			words[1]=("all");
			words[2]=("fun");
			words[3]=("dog");
			words[4]=("bat");
			words[5]=("cat");
			words[6]=("all");
			words[7]=("dog");
			words[8]=("all");
			words[9]=("all");

			System.out.println("Which Program?");
			System.out.println("1. For Loop Forwards");
			System.out.println("2. For Loop Backwards");
			System.out.println("3. While Loop Forwards");
			System.out.println("4. While Loop Backwards");
			System.out.println("5. Exit");
			System.out.print("Which Program?: ");
			again = sc.nextInt();
			if(again == 1)
				forForward(words);
			else if(again == 2)
				forBackward(words);
			else if(again == 3)
				whileForward(words);
			else if(again == 4)
				whileBackward(words);
			else
				again = 5;
			System.out.println("***************************\n");

		}
		System.out.println("\n***Thanks for Using Remove All!***");
	}
	//While Loop Forwards
	public static void whileForward(String[] words)
	{
		ArrayList<String> ray;
		ray = new ArrayList<String>();

		for(int i = 0; i < words.length; i++)
			ray.add(words[i]);
		int i = 0;
		while(i < ray.size())
		{
			if(ray.get(i).equals("all"))
			{
				ray.remove(i);
				i--;
			}
			i++;
		}
		System.out.println("***************************");
		System.out.println("While Loop Forwards:");
		System.out.println(ray);
		System.out.println(ray.size());
	}
	//While loop backwards
	public static void whileBackward(String[] words)
	{
		ArrayList<String> ray;
		ray = new ArrayList<String>();
		for(int i = 0; i < words.length; i++)
			ray.add(words[i]);
		int i = ray.size()-1;
		while(i >= 0)
		{
			if(ray.get(i).equals("all"))
				ray.remove(i);
			i--;
		}
		System.out.println("***************************");
		System.out.println("While Loop Backwards:");
		System.out.println(ray);
		System.out.println(ray.size());

	}
	//For loop forwards
	public static void forForward(String[] words)
	{
		ArrayList<String> ray;
		ray = new ArrayList<String>();
		for(int i = 0; i < words.length; i++)
			ray.add(words[i]);
		for(int i = 0; i < ray.size(); i++)
		{
			if(ray.get(i).equals("all"))
			{
				ray.remove(i);
				i--;
			}
		}
		System.out.println("***************************");
		System.out.println("For Loop Forwards:");
		System.out.println(ray);
		System.out.println(ray.size());

	}
	//For loop backwards
	public static void forBackward(String[] words)
	{
		ArrayList<String> ray;
		ray = new ArrayList<String>();
		for(int i = 0; i < words.length; i++)
			ray.add(words[i]);
		for(int i = ray.size()-1; i >= 0; i--)
		{
			if(ray.get(i).equals("all"))
				ray.remove(i);
		}
		System.out.println("***************************");
		System.out.println("For Loop Forwards:");
		System.out.println(ray);
		System.out.println(ray.size());

	}
}
/*

Which Program?
1. For Loop Forwards
2. For Loop Backwards
3. While Loop Forwards
4. While Loop Backwards
5. Exit
Which Program?: 1
***************************
For Loop Forwards:
[fun, dog, bat, cat, dog]
5
***************************

Which Program?
1. For Loop Forwards
2. For Loop Backwards
3. While Loop Forwards
4. While Loop Backwards
5. Exit
Which Program?: 2
***************************
For Loop Forwards:
[fun, dog, bat, cat, dog]
5
***************************

Which Program?
1. For Loop Forwards
2. For Loop Backwards
3. While Loop Forwards
4. While Loop Backwards
5. Exit
Which Program?: 3
***************************
While Loop Forwards:
[fun, dog, bat, cat, dog]
5
***************************

Which Program?
1. For Loop Forwards
2. For Loop Backwards
3. While Loop Forwards
4. While Loop Backwards
5. Exit
Which Program?: 4
***************************
While Loop Backwards:
[fun, dog, bat, cat, dog]
5
***************************

Which Program?
1. For Loop Forwards
2. For Loop Backwards
3. While Loop Forwards
4. While Loop Backwards
5. Exit
Which Program?: 5
***************************


***Thanks for Using Remove All!***
Press any key to continue . . .

*/
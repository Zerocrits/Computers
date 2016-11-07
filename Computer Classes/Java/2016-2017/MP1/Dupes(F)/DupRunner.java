//Bill Joseph
//Dupe Program
//Spec: Use Treeset to create a program showing unique numbers and duped numbers

import java.util.*;

public class DupRunner
{
	public static void main( String args[] )
	{
		String list = "a b c d e f g h a b c d e f g h i j k";
		System.out.println("Original List : " + list);
		System.out.println("Uniques : " + UniquesDupes.getUniques(list));
		System.out.println("Dupes : " + UniquesDupes.getDupes(list) + "\n\n");

		list = "one two three one two three six seven one two";
		System.out.println("Original List : " + list);
		System.out.println("Uniques : " + UniquesDupes.getUniques(list));
		System.out.println("Dupes : " + UniquesDupes.getDupes(list) + "\n\n");

		list = "1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6";
		System.out.println("Original List : " + list);
		System.out.println("Uniques : " + UniquesDupes.getUniques(list));
		System.out.println("Dupes : " + UniquesDupes.getDupes(list) + "\n\n");
	}
}
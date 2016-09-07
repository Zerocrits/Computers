//********************************************************************
//  Mr. A
//  SortClient for Sort Analysis Project
//  Spec: analysis and comparison of sorting algorithms
//  Driver for testing a numeric selection sort.
//********************************************************************

import java.util.Scanner;
import java.io.File;

public class SortClient
{
   //-----------------------------------------------------------------
   //  Creates an array of grades, sorts them, then prints stats on them
   //-----------------------------------------------------------------
   public static void main (String[] args) throws Exception
   {
		String[] filenames = {"100SortedInts.txt","10000SortedInts.txt","100ReversedInts.txt","10000ReversedInts.txt","100RandomInts.txt","10000RandomInts.txt"};
		int choice, n=0, num;
		Scanner file;
		SortResult rslt = new SortResult();

		for(int i=0; i<filenames.length; i++)
		{
			file = new Scanner(new File(filenames[i]));

		 	if(i%2 == 0)
		 		n = 100;
		 	else
		 		n = 10000;

			int[] a1 = new int[n];
			int[] a2 = new int[n];
			int[] a3 = new int[n];

			// Read the elements into each array
			for(int j=0; j<n; j++)
			{
				num = file.nextInt();
			  	a1[j] = num;
			  	a2[j] = num;
			  	a3[j] = num;
			}

			System.out.println("\n\t\t\t\t" + filenames[i]+ "\n");

			APSorts.selectionSort(a1);

			APSorts.insertionSort(a2);

			APSorts.mergeSort(a3);
		}
	}
}

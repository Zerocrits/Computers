// Bill Joseph
// Array Utility 2
// Spec: Build Array Util 2

import java.util.Arrays;

public class ArrayUtil2Runner
{
	public static void main(String[]args)
	{
		int[] intArr1 = {5,-6,8,-12,-17,4};
		int[] intArr2 = {3,1,4,1,5,9,9,1,6};
		double[] doubleArr = {3.2, 4.1, 9.6};
		int[] result;

		ArrayUtil2.swap(2,4,intArr1);
		System.out.print("Arr1 swap: ");
		System.out.println(Arrays.toString(intArr1));
		System.out.print("Double swap: ");
		ArrayUtil2.swap(0,2,doubleArr);
		System.out.println(Arrays.toString(doubleArr));

		result = ArrayUtil2.appendArrays(intArr1,intArr2);
		System.out.print("Appended: ");
		System.out.println(Arrays.toString(result));
		System.out.print("Sans First 6: ");
		System.out.println(Arrays.toString(ArrayUtil2.removeFirstXValues(result,6)));
		System.out.print("Sans Last 8: ");
		System.out.println(Arrays.toString(ArrayUtil2.removeLastXValues(result,8)));
		System.out.print("Arr1 Sans Evens: ");
		System.out.println(Arrays.toString(ArrayUtil2.removeEvens(intArr1)));
		System.out.print("Arr2 Sans Evens: ");
		System.out.println(Arrays.toString(ArrayUtil2.removeEvens(intArr2)));
		System.out.print("Arr1 Sans Odds: ");
		System.out.println(Arrays.toString(ArrayUtil2.removeOdds(intArr1)));
		System.out.print("Arr2 Sans Odds: ");
		System.out.println(Arrays.toString(ArrayUtil2.removeOdds(intArr2)));
		Arrays.sort(intArr2);
		System.out.print("Arr2 Sorted: ");
		System.out.println(Arrays.toString(intArr2));
		System.out.print("Num Uniques in Arr2: ");
		System.out.println(ArrayUtil2.numUniqueInts(intArr2));
	}
}

/*

Arr1 swap: [5, -6, -17, -12, 8, 4]
Double swap: [9.6, 4.1, 3.2]
Appended: [5, -6, -17, -12, 8, 4, 3, 1, 4, 1, 5, 9, 9, 1, 6]
Sans First 6: [3, 1, 4, 1, 5, 9, 9, 1, 6]
Sans Last 8: [5, -6, -17, -12, 8, 4, 3]
Arr1 Sans Evens: [5, -17]
Arr2 Sans Evens: [3, 1, 1, 5, 9, 9, 1]
Arr1 Sans Odds: [-6, -12, 8, 4]
Arr2 Sans Odds: [4, 6]
Arr2 Sorted: [1, 1, 1, 3, 4, 5, 6, 9, 9]
Num Uniques in Arr2: 6
Press any key to continue . . .

*/


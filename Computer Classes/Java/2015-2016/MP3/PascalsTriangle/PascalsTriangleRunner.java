// Bill Joseph
// Pascal's Triangle Runner
// Spec: Simple client to test out the functionality of PascalsTriangle

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PascalsTriangleRunner
{
	public static void main(String[] args)
	{
		PascalsTriangle pt = new PascalsTriangle(2);

		System.out.println("Size 2:");
		pt.createTriangle();
		System.out.println(pt);

		pt = new PascalsTriangle(3);
		System.out.println("Size 3:");
		pt.createTriangle();
		System.out.println(pt);

		pt = new PascalsTriangle(4);
		System.out.println("Size 4:");
		pt.createTriangle();
		System.out.println(pt);

		pt = new PascalsTriangle(5);
		System.out.println("Size 5:");
		pt.createTriangle();
		System.out.println(pt);
	}
}
/*

Size 2:
1
1       1

Size 3:
1
1       1
1       2       1

Size 4:
1
1       1
1       2       1
1       3       3       1

Size 5:
1
1       1
1       2       1
1       3       3       1
1       4       6       4       1

Press any key to continue . . .

*/




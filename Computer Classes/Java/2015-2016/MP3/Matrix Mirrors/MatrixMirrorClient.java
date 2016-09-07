// Bill Joseph
// Matrix Mirrors Client
// Spec: Simple client to test

public class MatrixMirrorClient
{
	public static void main(String[] args)
	{
		MatrixMirror mm = new MatrixMirror(5,4);

		mm.mirrorVerticalLeftToRight();
		System.out.println(mm);

		mm.populateMatrixSequentially();
		mm.mirrorHorizontalTopToBottom();
		System.out.println(mm);

		//**** Uncomment if you have implemented the extra diagonal mirrors
		mm = new MatrixMirror(4,4);
		mm.mirrorMajorDiagonalLeftToRight();
		System.out.println(mm);

		//mm = new MatrixMirror(4,4);
		//mm.mirrorMinorDiagonalLeftToRight();
		//System.out.println(mm);
	}
}

/*

1       2       2       1
5       6       6       5
9       10      10      9
13      14      14      13
17      18      18      17

1       2       3       4
5       6       7       8
9       10      11      12
5       6       7       8
1       2       3       4

1       5       9       13
5       6       10      14
9       10      11      15
13      14      15      16

Press any key to continue . . .

*/

// Name:Bill Joseph
// Prog:FancyWordTwoRunner
// Spec:Fancy Word Two Code

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class FancyWordTwoRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner( new File("fancyword2.dat") );
		int numValues = file.nextInt();
		file.nextLine(); // clear /n from the buffer

		for( int i = 0; i < numValues; i++)
		{
			String line = file.nextLine();
			FancyWordTwo one = new FancyWordTwo(line);
			System.out.println(one);
		}
	}
}
/*

PATRIOTS
A      T
T      O
R      I
I      R
O      T
T      A
STOIRTAP


BEN
E E
NEB


FRANKLIN
R      I
A      L
N      K
K      N
L      A
I      R
NILKNARF


TOMMY
O   M
M   M
M   O
YMMOT


J


PAINE
A   N
I   I
N   A
ENIAP


HENRY
E   R
N   N
R   E
YRNEH


USA
S S
ASU


Press any key to continue . . .

*/
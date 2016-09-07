//Bill Joseph
//Sound Runner
//Build a Sound Runner program

import java.util.*;

public class SoundRunner
{
    public static void main(String[] args)
    {
    	int[] vals = {40, 2532, 17, -2300, -17, -4000, 2000, 1048, -420, 33, 15, -32, 2030, 3223};
		Sound fun = new Sound(vals);
		int count;

		System.out.println("\t\t\t***Digital Sound Program***\n");
		System.out.println("Original Sound File Values:");
		System.out.println(fun);

		count = fun.limitAmplitude(2000);
		System.out.println("\nAfter amplitude is limited to 2000:");
		System.out.println(fun);
		System.out.println("Number of values affected: " + count);

		int[] vals2 = {0, 0, 0, 0, 0, 0, 592, 128, -33, 60};
		fun = new Sound(vals2);
		System.out.println("\nSound file with silence in the beginning:");
		System.out.println(fun);
		fun.trimSilenceFromBeginning();
		System.out.println("\nSound file with lead silence removed:");
		System.out.println(fun);
    }
}

/*

                        ***Digital Sound Program***

Original Sound File Values:
40, 2532, 17, -2300, -17, -4000, 2000, 1048, -420, 33, 15, -32, 2030, 3223

After amplitude is limited to 2000:
40, 2000, 17, -2000, -17, -2000, 2000, 1048, -420, 33, 15, -32, 2000, 2000
Number of values affected: 5

Sound file with silence in the beginning:
0, 0, 0, 0, 0, 0, 592, 128, -33, 60

Sound file with lead silence removed:
592, 128, -33, 60
Press any key to continue . . .

*/

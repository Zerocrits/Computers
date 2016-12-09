// Name - Bill Joseph
// Prog - Read in a list of Spanish words with English equivalents
// Date - 11/28/16

import java.io.File;
import java.io.*;
import java.io.IOException;
import java.util.Scanner;


public class SpanRunner
{
	public static void main( String args[] ) throws IOException
	{
		System.out.println("\t\t\t====  MAP CONTENTS  ====");

		SpanishToEnglish dictionary = new SpanishToEnglish();
		System.out.println(dictionary);

		Scanner sc = new Scanner(System.in);
		try {
			File file = new File("spantoeng.dat");
			sc = new Scanner(file);
			int numKey = sc.nextInt();
			sc.nextLine();
			for(int i = 0; i < numKey; i++)
			{
				sc.nextLine();
			}
		}catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		System.out.println("\n\n\t\t\t====  READ LINES  ====\n\n");
		while(sc.hasNextLine())
		{
			System.out.println(dictionary.translate(sc.nextLine()));
		}

	}
}
/*

                        ====  MAP CONTENTS  ====
{a=to
 antes=before
 barco=ship
 borrar=delete
 cafe=brown
 casa=house
 comprar=buy
 con=with
 contaminado=corrupt
 de=of
 despues=after
 dos=two
 el=the
 en=in
 energia=power
 es=is
 fallo=bug
 hambre=hunger
 interno=internal
 la=the
 los=the
 memoria=memory
 mi=my
 mitad=half
 muchachos=boys
 necesita=necessary
 nosotros=we
 ordenador=computer
 pantalla=screen
 papel=paper
 pelo=hair
 quieres=want
 quiero=want
 rearrancar=reboot
 su=your
 tarde=afternoon
 texto=text
 tienen=have
 tinta=ink
 todas=all
 tu=you
 una=a
 vacio=empty
 vamos=go
 virus=virus
 yo=i}


                        ====  READ LINES  ====


i want a computer virus
all of the boys have internal memory
my hair is brown
you want ink with your paper
reboot the computer to empty the screen
Press any key to continue . . .

*/
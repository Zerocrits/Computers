/**
 * A program to allow students to try out different
 * String methods.
 * @author Laurie White
 * @version April 2012
 */
public class StringExplorer
{

	public static void main(String[] args)
	{
		String sample = "The quick brown fox jumped over the lazy dog.";

		//  Demonstrate the indexOf method.
		int position = sample.indexOf("quick");
		System.out.println ("sample.indexOf(\"quick\") = " + position);

		//  Demonstrate the toLowerCase method.
		String lowerCase = sample.toLowerCase();
		System.out.println ("sample.toLowerCase() = " + lowerCase);
		System.out.println ("After toLowerCase(), sample = " + sample);

		//  Try other methods here:
		String word = "I think i saw fthe dog ran over to see a cat.";
		int Psn = word.indexOf("the");
		System.out.println("word.indexOf(\"the\") = " + Psn);
	}

}

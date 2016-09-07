//Bill Joseph
public class StringerRunner
{
	public static void main(String[] args)
	{
		Stringer str = new Stringer("the fox the hen the sheep the foxie dog thetheythex");

		System.out.println(str.getTheCount());
		System.out.println(str.getCountOf("the"));
		System.out.println(str.getCountOf("fox"));

		str.setPhrase("football");
		str.moveLastThree();
		System.out.println(str);
		str.moveFirstThree();
		System.out.println(str);
		str.setPhrase("abcdefghijklmnopqrstuvwxyz");
		System.out.println(str.everyOtherThree());

	}
}
/*

7
7
2
allfootb
football
abcghimnostuyz
Press any key to continue . . .

*/
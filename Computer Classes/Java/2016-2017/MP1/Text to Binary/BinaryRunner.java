import java.util.Scanner;

public class BinaryRunner
{
	private BinaryConverter core;

	public static void main(String args[])
	{
		BinaryRunner runner = new BinaryRunner();
	}

	public BinaryRunner()
	{
		String phrase = "";
		Scanner sc = new Scanner(System.in);

		System.out.println("***Text To Binary***");
		System.out.print("Please Type What You Want To Convert: ");
		phrase = sc.nextLine();
		getPhrase(phrase);

	}
	public void getPhrase(String phrase)
	{
		core = new BinaryConverter();
		int choice = 1;
		System.out.println("\nConverted to Binary: " + core.getValue(phrase, choice));

	}
}
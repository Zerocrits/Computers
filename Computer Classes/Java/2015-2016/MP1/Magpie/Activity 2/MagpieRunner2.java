import java.util.Scanner;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class MagpieRunner2
{

	/**
	 * Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args)
	{
		Magpie2 maggie = new Magpie2();

		System.out.println (maggie.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();

		while (!statement.equals("Bye"))
		{
			System.out.println (maggie.getResponse(statement));
			statement = in.nextLine();
		}
		System.out.println("Good-Bye!");
	}

}
/*
Hello, let's talk.
ascione
Did you just say my lord and savior mr. ascione's name in a sentence??? how dare
 you.

Say something, please.
how
No i don't know 'how' please stop asking
dog
Tell me more about these pets you humans have...
cat
Tell me more about these pets you humans have...
Do you know my brother?
Do I look like i care?
My mother and I talked last night.
Cool Story, tell it again...
I said no!
Why are you being so salty right now?
The weather is nice.
It's almost like im a WINDOW...
hello
hey
pet
I have 1 bird that just stares at a window all day...
leave
I was here first...
Who are you
I am Magpie, creater of this conversation
yes
Why so positive?
problem
Hmm, i dont know the answer to this problem... ERROR 404
mother
Tell me more about your family.
father
Tell me more about your family.
sister
Tell me more about your family.
brother
Tell me more about your family.
no
Why so negative?
asdsa
Do you really think so?
asda
Interesting, tell me more.
asdsa
You don't say.
asdsa
Do you really think so?
*/
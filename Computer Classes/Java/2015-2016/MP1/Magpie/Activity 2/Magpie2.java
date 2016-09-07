//Bill Joseph

/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
	/**
	 * Get a default greeting
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}

	public String getResponse(String statement)
	{
		String response = "";

		if (statement.indexOf("ascione") >= 0)
		{
			response = "Did you just say my lord and savior mr. ascione's name in a sentence??? how dare you.";
		}
		else if (statement.trim().length() == 0)
		{
     		response = "Say something, please.";
		}
		else if (statement.indexOf("how") >= 0)
		{
			response = "No i don't know 'how' please stop asking";
		}
		else if (statement.indexOf("dog") >= 0
				|| statement.indexOf("cat") >=0)
		{
			response = "Tell me more about these pets you humans have...";
		}
		else if (statement.indexOf("Do you know my brother?") >= 0)
		{
			response = "Do I look like i care?";
		}
		else if (statement.indexOf("My mother and I talked last night.") >= 0)
		{
			response = "Cool Story, tell it again...";
		}
		else if (statement.indexOf("I said no!") >= 0)
		{
			response = "Why are you being so salty right now?";
		}
		else if (statement.indexOf("The weather is nice.") >= 0)
		{
			response = "It's almost like im a WINDOW...";
		}
		else if(statement.indexOf("hello") >=0)
		{
			response = "hey";
		}
		else if(statement.indexOf("pet") >=0)
		{
			response = "I have 1 bird that just stares at a window all day...";
		}
		else if(statement.indexOf("leave") >=0)
		{
			response = "I was here first...";
		}
		else if(statement.indexOf("Who are you") >=0)
		{
			response = "I am Magpie, creater of this conversation";
		}
		else if(statement.indexOf("yes") >=0)
		{
			response = "Why so positive?";
		}
		else if(statement.indexOf("problem") >=0)
		{
			response = "Hmm, i dont know the answer to this problem... ERROR 404";
		}
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
		else if (statement.indexOf("no") >= 0)
		{
			response = "Why so negative?";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}

		return response;
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

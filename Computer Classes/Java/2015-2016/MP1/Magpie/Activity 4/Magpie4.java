//Bill Joseph
//period 4

public class Magpie4
{
	//Get a default greeting
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	//Gives a response to a user statement
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.length() == 0)
		{
			response = "Say something, please.";
		}

		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (findKeyword(statement, "mother") >= 0
				|| findKeyword(statement, "father") >= 0
				|| findKeyword(statement, "sister") >= 0
				|| findKeyword(statement, "brother") >= 0)
		{
			response = "Tell me more about your family.";
		}

		// Responses which require transformations
		else if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "I want", 0) >= 0)
		{
			response = transformIWantStatement(statement);
		}
		// Look for a two word (you <something> me) pattern
		else
		{
			int psn = findKeyword(statement, "you", 0);
			int psn2 = findKeyword(statement, "i", 0);

			if (psn >= 0 && findKeyword(statement, "me", psn) >= 0)
			{
				response = transformYouMeStatement(statement);
			}
			else if	(psn2 >= 0 &&findKeyword(statement, "me", psn) >= 0)
			{
				response = transformIYouStatement(statement);
			}
			else
			{
				response = getRandomResponse();
			}
		}
		return response;
	}


	private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "What would it mean to " + restOfStatement + "?";
	}


	private String transformYouMeStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement.length() - 1);
		}

		int psnOfYou = findKeyword (statement, "you", 0);
		int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);

		String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
		return "What makes you think that I " + restOfStatement + " you?";
	}

	private String transformIWantStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Would you really be happy if you had " + restOfStatement + "?";
	}

	private String transformIYouStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement.length() - 1);
		}

		int psnOfI = findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "You", psnOfI + 3);

		String restOfStatement = statement.substring(psnOfI + 3, psnOfYou).trim();
		return "Why do you " + restOfStatement + " me?";
	}


	private int findKeyword(String statement, String goal, int startPos)
	{
		String phrase = statement.trim();
		//  The only change to incorporate the startPos is in the line below
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);

		//  Refinement--make sure the goal isn't part of a word
		while (psn >= 0)
		{
			//  Find the string of length 1 before and after the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring (psn - 1, psn).toLowerCase();
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
			}

			//  If before and after aren't letters, we've found the word
			if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
					&& ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
			{
				return psn;
			}

			//  The last position didn't work, so let's find the next, if there is one.
			psn = phrase.indexOf(goal.toLowerCase(), psn + 1);

		}

		return -1;
	}

	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}

	//Random Response
	private String getRandomResponse()
	{
		String response = "";
		int number = (int) (Math.random()*4) + 1;
		switch(number)
		{
			case 1: response = "Interesting, tell me more."; break;
			case 2: response = "Hmmm."; break;
			case 3: response = "Do you really think so?"; break;
			case 4: response = "You don't say."; break;
		}
		return response;
	}

}

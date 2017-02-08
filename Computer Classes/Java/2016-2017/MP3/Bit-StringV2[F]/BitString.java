//Bill Joseph
// BitString Flick
// Spec: Build an object capable of evaluating BitString Flicks

import java.util.Scanner;

public class BitString
{
	private String leftRight;
	private String circShift;
	private int index;
	private String bits;
	private String answer;

	/** Calls setExpression with default values */
	public BitString()
	{
		leftRight = "";
		circShift = "";
		index = 0;
		bits = "";
		answer = "";
	}

	/** Uses setExpression to set the state of the object
	*	Note: expression should be converted to uppercase
	*/
	public BitString(String expression)
	{
		expression.toUpperCase();
		setExpression(expression);
	}

	/** Sets the instance data based upon the given expression and calls solve() */
	public void setExpression(String expression)
	{
		leftRight = expression.substring(0,1);
		if(expression.substring(1,5).equals("CIRC"))
			circShift = "CIRC";
		else if(expression.substring(1,6).equals("SHIFT"))
			circShift = "SHIFT";
		int num = expression.indexOf("-")+1;
		index = Integer.parseInt(expression.substring(num,num+1));

		num = expression.indexOf(" ")+1;
		bits = expression.substring(num,expression.length());
	}

	/** Performs an l-shift operation on the bits - the result is stored in String answer */
	public void lShift()
	{
		for(int i = 0; i < bits.length()-1; i++)
		{
			answer += bits.charAt(i+index);
		}
		for(int i = 0; i < index; i++)
		{
			answer += "0";
		}
	}

	/** Performs an r-shift operation on the bits - the result is stored in String answer */
	public void rShift()
	{
		for(int i = 0; i < index; i++)
		{
			answer += "0";
		}
		for(int i = 0; i < bits.length()-1+index; i++)
		{
			answer += bits.charAt(i);
		}
	}

	/** Performs an l-circ operation on the bits - the result is stored in String answer */
	public void lCirc()
	{
		answer = "";
		for(int i = index; i < bits.length()-1; i++)
		{
			answer += bits.charAt(i);
		}
		for(int i = 0; i < index; i++)
		{
			answer += bits.charAt(i);
		}
	}

	/** Performs an r-circ operation on the bits - the result is stored in String answer */
	public void rCirc()
	{
		for(int i = bits.length()-1+index; i >= 0; i--)
		{
			answer += bits.charAt(i);
		}
		for(int i = 0; i < bits.length()-1+index; i++)
		{
			answer += bits.charAt(i);
		}
	}

	/** Calls the appropriate method based upon the values of leftRight and circShift */
	public void solve()
	{
		if(leftRight == "L")
		{
			if(circShift == "CIRC")
				lCirc();
			else
				lShift();
		}
		else if(leftRight == "R")
		{
			if(circShift == "CIRC")
				rCirc();
			else
				rShift();
		}
	}

	/* @return the whole expression along with the answer */
	public String toString()
	{
		return "Side: " + leftRight + "\nAction: " + circShift + "\nBits: " + bits + "\nAnswer: " + answer;
	}
}
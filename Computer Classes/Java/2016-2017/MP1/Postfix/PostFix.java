//Name - Bill Joseph
//Prog - PostFix
//Spec - Main body for PostFix

import java.util.Stack;
import java.util.Scanner;


public class PostFix
{
	private Stack<Double> stack;
	private String expression;

	public PostFix()
	{
		Stack<Integer> stack = new Stack<Integer>();
		expression = "";
	}

	public PostFix(String exp)
	{
		Stack<Integer> stack = new Stack<Integer>();
		expression = exp;
	}

	public void setExpression(String exp)
	{
		expression = exp;
	}

	public double calc(double one, double two, char op)
	{
		if(op == '+')
			return one + two;
		if(op == '-')
			return one - two;
		if(op == '*')
			return one * two;
		if(op == '/')
			return one / two;
		if(op == '%')
			return one % two;
		return 0.0;
	}

	public void solve()
	{
		double num1 = 0;
		double num2 = 0;

		while(!stack.empty())
		{
			for(int i = 0; i < expression.length(); i++)
			{
				int t = Character.getNumericValue(expression.charAt(i))
				if(expression.charAt(i) <= 57 || expression.charAt(i) >= 48 && stack.peek() !=)
					num1 = stack.push();
				else if(((int)((stack.peek()).charAt(i)) != 32))
					num2 = stack.pop();
			}
		}
	}

	public String toString()
	{
		return null;
	}

	//add a toString
}
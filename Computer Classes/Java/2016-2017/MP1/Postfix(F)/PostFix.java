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
		stack = new Stack<Double>();
		expression = "";
	}

	public PostFix(String exp)
	{
		stack = new Stack<Double>();
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
		else if(op == '-')
			return one - two;
		else if(op == '*')
			return one * two;
		else if(op == '/')
			return one / two;
		else if(op == '%')
			return one % two;

		return 0.0;
	}

	public void solve()
	{
		double num1 = 0;
		double num2 = 0;

		for(int i = 0; i < expression.length(); i++)
		{
			if(expression.charAt(i) >= 48 && expression.charAt(i) <= 57)
			{
				stack.push((double)Character.getNumericValue(expression.charAt(i)));
			}
			else if(expression.charAt(i)!= ' ')
			{
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(calc(num1,num2,expression.charAt(i)));
			}
		}
	}

	public String toString()
	{
		return expression + " = " + stack.peek();
	}
}
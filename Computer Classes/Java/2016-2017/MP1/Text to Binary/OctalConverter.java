import java.io.*;
import java.lang.*;

public class OctalConverter
{
	private DecimalConverter decimal;
	public OctalConverter()
	{
		String value = "";
		decimal = new DecimalConverter();
	}

	public String getValue(String value)
	{
		value = value;
		String decimalVal = "";
		String octal = "";
		decimalVal = decimal.getValue(value);
		octal = toOctal(decimalVal);

		return octal;
	}

	public String toOctal(String decimal)
	{
	    String[] values = decimal.split("\\s+");
	    int n, r;
	    String s = "";

		for(int i = 0; i < values.length; i++)
		{
	    	n = Integer.parseInt(values[i]);
			s=""; //variable for storing the result

			//array storing the digits (as characters) in the octal number system
			char dig[]={'0','1','2','3','4','5','6','7'};

			while(n>0)
			{
				r=n%8; //finding remainder by dividing the number by 8
				s += dig[r]+s+" "; //adding the remainder to the result and reversing at the same time
				n=n/8;
			}
		}
        return s;
    }
}
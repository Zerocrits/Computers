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
	        int inputNumber = Integer.parseInt(decimal);
	        int copyOfInputNumber = inputNumber;
	        String octal = "";
	        int remainder = 0;

	        while (inputNumber > 0)
	        {
	            remainder = inputNumber%8;

	            octal =  remainder + octal;

	            inputNumber = inputNumber/8;
	        }

	        return octal;
    }
}
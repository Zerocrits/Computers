import java.io.*;
import java.lang.*;

public class HexConverter
{
	private DecimalConverter decimal;
	public HexConverter()
	{
		String value = "";
		decimal = new DecimalConverter();
	}

	public String getValue(String value)
	{
		value = value;
		String decimalVal = "";
		String hex = "";
		decimalVal = decimal.getValue(value);
		hex = toHex(decimalVal);

		return hex;
	}

    public String toHex(String decimal)
	{
        int inputNumber = Integer.parseInt(decimal);
        int copyOfInputNumber = inputNumber;
        String hex = "";
        char hexaDecimals[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        int remainder = 0;
        while (inputNumber > 0)
        {
            remainder = inputNumber%16;
            hex =  hexaDecimals[remainder] + hex;
            inputNumber = inputNumber/16;
        }

        return hex;
    }
}


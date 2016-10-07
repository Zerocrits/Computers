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
		String[] phrase = {};
		decimalVal = decimal.getValue(value);
		for(int i = 0; i < decimalVal; i++)
		{
			if(decimalVal.charAt(i) != 48 < 58)
				phrase[i] += "" + decimalVal.charAt(i);
			else
				phrase[i] += decimalVal.charAt(i);
//fix
		}

		int no = Integer.parseInt(value);
		String hex = Integer.toHexString(no);

		return hex;
	}

    /*public String toHex(String decimal)
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
    }*/
}


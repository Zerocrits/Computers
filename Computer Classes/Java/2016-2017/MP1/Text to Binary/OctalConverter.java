import java.io.*;
import java.lang.*;

public class OctalConverter
{
	public OctalConverter()
	{
		String value = "";
	}

	public String getValue(String value)
	{
		value = value;
		String test = "";
		String binary = "";
		binary = toBinary(value);
		test = getNum(binary);

		return binary;
	}

	public String toBinary(String value)
	{
		String phrase = "";
		byte[] bytes = value.getBytes();
		byte space = 32;
		StringBuilder binary = new StringBuilder();
		for(byte b : bytes)
		{
			int val = b;
			for (int i = 0; i < 9; i++)
			{
				if(b == space && i == 0)
					phrase += " ";
				else if(b != space)
				{
					binary.append((val & 128) == 0 ? 0 : 1);
					val <<= 1;
					phrase += binary;
					if(i == 2 || i == 5)
						phrase += " ";
					binary.setLength(0);
				}
			}
			phrase += " ";
		}
		return phrase;
	}

	public String getNum(String phrase)
	{
		String values = "";
		int quot, binary, i=1;
		int[] octal = new int[phrase.length()];

		quot = Integer.parseInt(phrase);

		while(quot != 0)
		{
			octal[i++] = quot%8;
			quot = quot/8;
        }

        for(int j = i-1; j > 0; j--)
		{
			values += octal[j];
        }
        return values;
        //replace binary to octal
	}

	/*public String toOctal(String value)
	{
		int[] binary;
		int y = 0;
		String phrase = "";
		while(value.length() % 3 != 0)
			phrase+="0";
		phrase+=value;
		int num = Integer.parseInt(phrase);

		for(int i = 0; i < phrase.length(); i++)
		{
			binary[y] += phrase.charAt[i];
			y++;

		}


		return phrase;
	}*/
}
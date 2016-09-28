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

		return test;
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
			for (int i = 0; i < 4; i++)
			{
				if(b == space && i == 0)
					phrase += " ";
				else if(b != space)
				{
					binary.append((val & 128) == 0 ? 0 : 1);
					val <<= 1;
					phrase += binary;
					if(i == 3)
						phrase += " ";
					binary.setLength(0);
				}
			}
		}
		return phrase;
	}

	public String getNum(String phrase)
	{
		int number = 0;
		String Octal = "";

		for(int i = 0; i < phrase.length(); i++)
		{
			for(int j = 0; j < 4; j++)
			{
				if(phrase.charAt(i) != 0)
				{
					switch(j)
					{
						case 0: number += 8; break; //**should never trigger this, just 4th 0 just for effect**
						case 1: number += 4; break;
						case 2: number += 2; break;
						case 3: number += 1; break;
					}
				}

			}
			Octal += number + " ";
			number = 0;
		}
		return Octal;
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
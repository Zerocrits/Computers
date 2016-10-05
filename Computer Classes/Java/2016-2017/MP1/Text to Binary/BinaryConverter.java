import java.io.*;
import java.lang.*;

public class BinaryConverter
{
	public BinaryConverter()
	{
		String value = "";
		int choice = 0;
	}

	public String getValue(String value, int choice)
	{
		choice = choice;
		value = value;
		String binary = "";
		if(choice == 1)
			binary = toNumericalBinary(value);
		else
			binary = toAsciiBinary(value);

		return binary;
	}

	public String toAsciiBinary(String value)
	{
		String phrase = "";
		byte[] bytes = value.getBytes();
		byte space = 32;
		StringBuilder binary = new StringBuilder();
		for(byte b : bytes)
		{
			int val = b;
			for (int i = 0; i < 8; i++)
			{
				if(b == space && i == 0)
					phrase += " ";
				else if(b != space)
				{
					binary.append((val & 128) == 0 ? 0 : 1);
					val <<= 1;
					phrase += binary;
					if(i == 7)
						phrase += "";
					binary.setLength(0);
				}
			}
		}
		return phrase;
	}
	public String toNumericalBinary(String value)
	{
		String phrase = "";

		for(int i = 0; i < value.length(); i++)
		{
			switch(value.charAt(i))
			{
				case 48: phrase += "0000 "; break;
				case 49: phrase += "0001 "; break;
				case 50: phrase += "0010 "; break;
				case 51: phrase += "0011 "; break;
				case 52: phrase += "0100 "; break;
				case 53: phrase += "0101 "; break;
				case 54: phrase += "0110 "; break;
				case 55: phrase += "0111 "; break;
				case 56: phrase += "1000 "; break;
				case 57: phrase += "1001 "; break;
			}

		}

		return phrase;
	}
}
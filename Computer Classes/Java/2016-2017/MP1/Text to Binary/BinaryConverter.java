import java.io.*;
import java.lang.*;

public class BinaryConverter
{
	public BinaryConverter()
	{
		String value = "";
	}

	public String getValue(String value)
	{
		value = value;
		String binary = "";
		binary = toBinary(value);

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
						phrase += " ";
					binary.setLength(0);
				}
			}
		}
		return phrase;
	}
}
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
		byte[] bytes = value.getBytes();
		StringBuilder binary = new StringBuilder();
		for(byte b : bytes)
		{
			int val = b;
			for (int i = 0; i < 8; i++)
			{
				binary.append((val & 128) == 0 ? 0 : 1);
				val <<= 1;
			}
		}
		return ""+binary;
	}
}
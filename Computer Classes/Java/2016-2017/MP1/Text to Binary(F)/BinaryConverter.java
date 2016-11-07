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

		for(int i = 0; i < value.length(); i++)
			binary += Integer.toBinaryString(value.charAt(i)) + " ";

		return binary;
	}
}
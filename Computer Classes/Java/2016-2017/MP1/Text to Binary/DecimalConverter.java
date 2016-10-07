import java.io.*;
import java.lang.*;

public class DecimalConverter
{
	private BinaryConverter bin;
	public DecimalConverter()
	{
		String value = "";
	}

	public String getValue(String value)
	{
		bin = new BinaryConverter();
		value = value;

		String decimal = "";
		for(int i = 0; i < value.length(); i++)
		{
		    decimal += (int)value.charAt(i) + " ";
		}

		return decimal;
	}
}
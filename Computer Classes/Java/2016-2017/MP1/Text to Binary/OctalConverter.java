import java.io.*;
import java.lang.*;

public class OctalConverter
{
	private DecimalConverter decimal;
	public OctalConverter()
	{
		String value = "";
	}

	public String getValue(String value)
	{
		value = value;
		String octal = "";

		for(int i = 0; i < value.length(); i++)
			octal += Integer.toOctalString(value.charAt(i)) + " ";
		return octal;
	}
}
import java.io.*;
import java.lang.*;

public class HexConverter
{
	private DecimalConverter decimal;
	public HexConverter()
	{
		String value = "";
	}

	public String getValue(String value)
	{
		value = value;
		String hex = "";

		for(int i = 0; i < value.length(); i++)
			hex += Integer.toHexString(value.charAt(i)) + " ";
		return hex;
	}
}


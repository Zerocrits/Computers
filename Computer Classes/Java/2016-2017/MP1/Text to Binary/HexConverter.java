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
		decimal = new DecimalConverter();

		String hex = "";
		int num = 0;

		for(int i = 0; i < value.length(); i++)
		{
			num = value.charAt(i);
			hex += Integer.parseInt(num, 16);

		}

		return hex;
	}

}


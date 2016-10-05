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

		String binary = bin.toAsciiBinary(value);
		String decimal = ""+Long.parseLong(binary.trim());
		decimal = ""+Long.parseLong(decimal, 2);

		return decimal;
	}
}
import java.io.*;
import java.lang.*;

public class BinaryConverter
{
	public BinaryConverter()
	{
		String value = "";
		String binary = "";
	}

	public String getValue(String value)
	{
		value = value;
		String binary = "";
		binary = toBinary(value, binary);

		return binary;
	}

	public String toBinary(String value, String binary)
	{
		int val = 0;
		for(int i = 0; i < value.length(); i++)
		{
			val = value.charAt(i);
			if(val == 32)
				binary += " ";
			else
				binary += convertBinary(val, binary);
		}
		return binary;
	}

	public String convertBinary(int val, String binary)
	{
		String value = String.valueOf(val);
		int digit = 0;
		for(int i = 0; i < value.length(); i++)
		{
			digit = Character.digit(value.charAt(i), 10);
			switch(digit)
			{
				case 0: binary += "0000"; break;
				case 1: binary += "0001"; break;
				case 2: binary += "0010"; break;
				case 3: binary += "0011"; break;
				case 4: binary += "0100"; break;
				case 5: binary += "0101"; break;
				case 6: binary += "0110"; break;
				case 7: binary += "0111"; break;
				case 8: binary += "1000"; break;
				case 9: binary += "1001"; break;
				default: binary += "null"; break;
			}
		}
		return binary;
	}
}
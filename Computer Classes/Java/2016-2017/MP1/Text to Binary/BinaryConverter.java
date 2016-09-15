import java.io.*;
import java.awt.*;

public class BinaryConverter
{
	public BinaryConverter()
	{
		String value = "";
		toBinary(value);
	}

	public void getValue(String value)
	{
		System.out.println(value + "test");
		value = value;
		toBinary(value);
	}

	public void toBinary(String value)
	{
		String binary = "";
		int val = 0;
		for(int i = 0; i < value.length(); i++)
		{
			val = value.charAt(i);
			if(val == 32)
				binary += " ";
			else
			System.out.println(val + "testss");
				binary += convertBinary(val);
		}
		System.out.println(binary + "testbb");
	}

	public int convertBinary(int val)
	{
		switch(val)
		{
			case 0: return 0000;
			case 1: return 0001;
			case 2: return 0010;
			case 3: return 0011;
			case 4: return 0100;
			case 5: return 0101;
			case 6: return 0110;
			case 7: return 0111;
			case 8: return 1000;
			case 9: return 1001;
		}
		return 2;
	}

	public String sendBinary(String binary)
	{
		System.out.println(binary + "test");
		return binary;
	}
}
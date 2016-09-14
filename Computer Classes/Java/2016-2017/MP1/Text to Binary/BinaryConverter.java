public class BinaryConverter
{
	public BinaryConverter()
	{
		String value = "";
		int binary = 0;
	}

	public void getValue(String value)
	{
		value = value;
	}

	public void getBinary(int binary)
	{
		binary = binary;
	}

	public void toBinary(String value, String binary)
	{
		for(int i = 0; i < value.length(); i++)
		{
			int val = value.charAt(i);
			binary += convertBinary(val);
		}
	}

	public int convertBinary(int val)
	{
		switch(val)
		{
			case 48: return 000001;
		}
		return 789;
	}

	public int sendBinary(int binary)
	{
		return binary;
	}
}
public class Result
{
	private int index;
	private int iterations;
	private boolean found;

	public Result()
	{
		index = -1;
		iterations = 0;
		found = false;
	}

	public int getIndex() { return index; }
	public int getIterations() { return iterations; }
	public boolean isFound() { return found; }

	public void setIndex(int value)
	{
		index = value;
	}

	public void increment()
	{
		iterations++;
	}

	public void setFound()
	{
		found = true;
	}

	public String toString()
	{
		String result = "";
		for(int i = 0; i <

	}

}
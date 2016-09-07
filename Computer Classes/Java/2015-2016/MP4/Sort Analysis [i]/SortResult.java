
public class SortResult
{
	private String sortName;
	private long start, end, millis;
	private int comparisons, swaps;

	public SortResult()
	{

	}

	public void addSwap()
	{

	}

	public void addComp()
	{

	}

	public void setName(String name)
	{
		sortName = name;
	}

	public void startTimer()
	{
		start = System.currentTimeMillis();
	}

	public void stopTimer()
	{
		end = System.currentTimeMillis();
		millis = end - start;
	}

	/** Returns a String with:
	*  - The name of the Sort
	*  - The Milliseconds, Comparisons and Swaps labeled with their values
	*/
	public String toString()
	{

	}

}
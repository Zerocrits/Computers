//Name: Bill Joseph
//Prog: Toy Store
//Spec: Create a Toy Store

public class Toy
{
	private String name;
	private int count;

	/** creates a generic toy named 'toy' with a count of 1 */
	public Toy()
	{
		name = "toy";
		count = 1;
	}

	/** assigns the name given with a count of 1*/
	public Toy( String nm )
	{
		name = nm;
		count = 1;
	}

	public int getCount()
	{
		return count;
	}

	public void setCount( int cnt )
	{
		count = cnt;
	}

	public String getName()
	{
		return name;
	}

	public void setName( String nm )
	{
		name = nm;
	}

	public String toString()
	{
	   return "" + name + " " + count;
	}
}
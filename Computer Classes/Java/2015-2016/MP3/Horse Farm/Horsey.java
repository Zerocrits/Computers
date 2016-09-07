//Bill Joseph
//Horsey
//Horsey object holds info impements horse

public class Horsey implements Horse
{
	private String name;
	private int weight;

	/** Default Constructor - empty name and 0 weight */
	public Horsey()
	{
		name = "";
		weight = 0;
	}

	/** Initialization Constructor - sets name and weight */
	public Horsey(String horseName, int horseWeight)
	{
		name = horseName;
		weight = horseWeight;
	}

	public String getName()
	{
		return name;
	}

	public int getWeight()
	{
		return weight;
	}
	// This class implements the Horse interface
	// Look at that interface and add any methods
	// that need to be implemented here...
	// an interface is a contract! :)

	/** @return a String with the name of the horse
	*		followed by a tab, followed by it's weight */
	public String toString()
	{
		return name + "\t" + weight;
	}
}

// The Pet class is fully coded
// The class itself must be declared abstract
// since it contains an abstract method 

public abstract class Pet
{
	private String myName;

	public Pet(String name)
	{
		myName = name;
	}

	public String getName()
	{
		return myName;
	}

	public abstract String speak();
}

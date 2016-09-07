// Name: Bill Joseph
// Prog: Monster
// Spec: Build a Monster Program

public class Monster implements Monsterable, Comparable<Monster>
{
	private int myHeight;
	private int myWeight;
	private int myAge;

	//Default Constructor
	public Monster()
	{
		setMonster(0, 0, 0);
	}

	//Initialization  Constructor
	public Monster(int ht)
	{
		setMonster(ht, 0, 0);
	}
	 //Initialization  Constructor
	public Monster(int ht, int wt)
	{
		setMonster(ht, wt, 0);
	}

	public Monster(int ht, int wt, int age)
	{
		setMonster(ht, wt, age);
	}

	public void setMonster(int ht, int wt, int age)
	{
		myHeight = ht;
		myWeight = wt;
		myAge = age;
	}

	//Modifiers - These methods change the Object's values
	public void setHeight(int ht)
	{
		myHeight = ht;
	}

	public void setWeight(int wt)
	{
		myWeight = wt;
	}

	public void setAge(int age)
	{
		myAge = age;
	}

	//Accessors - These methods can only look at the Object's values
	public int getHeight()
	{
		return myHeight;
	}

	public int getWeight()
	{
		return myWeight;
	}

	public int getAge()
	{
		return myAge;
	}

	//creates a new copy of this Object
	public Object clone()
	{
		return new Monster(getHeight(), getWeight(), getAge());
	}

	// returns true if height, weight and age are equal, otherwise false
	public boolean equals(Object o)
	{
		Monster x = (Monster)o;
		int i = getHeight() - x.getHeight();
		int j = getWeight() - x.getWeight();
		int k = getAge() - x.getAge();

		if(1 == 0 && j == 0 && k == 0)
			return true;
		return false;
	}

	public int compareTo(Monster monster)
	{
		Monster x = monster;
		int i = getHeight() - x.getHeight();
		int j = getWeight() - x.getWeight();
		int k = getAge() - x.getAge();

		if(i<0)
			return -1;
		else if(i == 0)
			if(j < 0)
				return -1;
			else if(j == 0)
				if(k < 0)
					return -1;
				else if(k == 0)
					return 0;
				else if(k > 0)
					return 1;
			else if(j > 0)
				return 1;
		else if(i > 0)
			return 1;

		return 1;
	}

	// Label and display the height, weight and age of this monster
	public String toString( )
	{
		String result = "";
		result += "Height = " + getHeight() + " Weight = " + getWeight() + " Age = " + getAge();
		return result;
	}
}
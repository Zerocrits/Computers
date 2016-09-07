// Name: Bill Joseph
// Prog: Monsterable
// Spec: Build a Monster Program

public interface Monsterable
{
	/** sets the height, weight and age for this Monster*/
	public void setMonster(int ht, int wt, int age);
	/** sets the height for this Monster */
	public void setHeight(int ht);
	/** sets the weight for this Monster */
	public void setWeight(int wt);
	/** sets the age for this Monster */
	public void setAge(int age);
	/** gets the height for this Monster */
	public int getHeight();
	/** gets the weight for this Monster */
	public int getWeight();
	/** gets the age for this Monster */
	public int getAge();
	/** creates a new copy of this Object */
	public Object clone();
	/** returns true if height, weight and age are equal, otherwise false */
	public boolean equals(Object o);
	/** returns a value based on the criteria of height, weight and age */
	public String toString();
}
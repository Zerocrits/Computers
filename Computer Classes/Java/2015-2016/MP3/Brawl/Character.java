//Bill Joseph
//Character

public abstract class Character
{
	private int level;
	private int health;

	/** Default Constructor
	*	Sets the level and health to reasonable defaults
	*/
	public Character()
	{
		level = 0;
		health = 0;
	}

	/** Initialization Constructor
	*	Sets level and health based on the parameters l and h
	*/
	public Character(int l, int h)
	{
		level = l;
		health = h;
	}

	public int getHealth()
	{
		return health;
	}

	public void setHealth(int value)
	{
		health = value;
	}

	public int getLevel()
	{
		return level;
	}

	/** @return true if health is still greater than 0, otherwise false */
	public boolean isNotDefeated()
	{
		if(health > 0)
			return true;
		return false;
	}

	/**	@return a String that shows "Damage: " and the amount of damage this creature caused to Character c
	*	Character c has their health decreased by a random amount from 1 to the level of this Character
	*/
	public String attacks(Character c)
	{
		int r =(int) (Math.random() * level)+1;
		c.decreaseHealth(r);
		return "Damage: " + r;

	}

	/**	reduces health for this Character by amount */
	public void decreaseHealth(int amount)
	{
		health = health - amount;
	}

	/** @return a random attack from a list appropriate to the particular Character */
	public abstract String getNameOfAttack();

	/**	@return a String with an ASCII picture of the particular Character */
	public abstract String displayCharacter();

	/** @return the level and health of this particular Character */
	public abstract String toString();

}
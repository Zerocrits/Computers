//Bill Joseph
//Player

public class Player extends Character
{
	public Player()
	{
		super(5,15);
	}

	public String getNameOfAttack()
	{
		int r = (int) (Math.random() * 4)+1;

		switch(r)
		{
			case 1 : return "You sneak up and stab him!";
			case 2 : return "You do a round-house kick!";
			case 3 : return "You swipe out his legs!";
			case 4 : return "You command your to dog attack!";
		}
		return "Attack Error";
	}

	public String displayCharacter()
	{
		String character = "";

		character+="            _,,,,,,,_";
		character+="\n          ,88888888888,";
		character+="\n        ,888'       `888,";
		character+="\n        888' 0     0 `888";
		character+="\n       888      0      888";
		character+="\n       888             888";
		character+="\n       888    ,000,    888";
		character+="\n        888, 0     0 ,888";
		character+="\n        '888,       ,888'";
		character+="\n          '8JGS8888888'";
		character+="\n            ````````";

		return character;
	}

	public String toString()
	{
		return "\nYour Level: " + getLevel() + "\nYour Health: " + getHealth();
	}
}
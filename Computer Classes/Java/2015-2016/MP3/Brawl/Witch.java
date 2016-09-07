//Bill Joseph
//Witch

public class Witch extends Character
{
	public Witch()
	{
		super(6,15);
	}

	public String getNameOfAttack()
	{
		int r = (int) (Math.random() * 4)+1;

		switch(r)
		{
			case 1 : return "Witch puts a curse on you";
			case 2 : return "Witch boils you in a pot of potion";
			case 3 : return "Witch stares at you with an ugly face";
			case 4 : return "Witch's mole attacks you";
		}
		return "Attack Error";
	}

	public String displayCharacter()
	{
		String character = "";

		character+="            _____";
		character+="\n          .-'  ,  '-.";
		character+="\n        .'   _/(_    '.";
		character+="\n       /     {\\\\   ^^  \\";
		character+="\n      |      /;_)       |";
		character+="\n      |   =='/ <===<<<  |";
		character+="\n       \\     \\__\\      /";
		character+="\n        '.     ``    .'";
		character+="\n          '-._____.-'";

		return character;
	}

	public String toString()
	{
		return "\n*Witch's Level: " + getLevel() + "\n*Witch's Health: " + getHealth();
	}
}
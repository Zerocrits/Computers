//Bill Joseph
//Goblin

public class Goblin extends Character
{
	public Goblin()
	{
		super(4,20);
	}

	public String getNameOfAttack()
	{
		int r = (int) (Math.random() * 4)+1;

		switch(r)
		{
			case 1 : return "Goblin Throws Dynamite at you!";
			case 2 : return "Goblin Screams loudly";
			case 3 : return "Goblin pushed you into a pit of snakes";
			case 4 : return "Goblin bit down on your leg";
		}
		return "Attack Error";
	}

	public String displayCharacter()
	{
		String character = "";
		character +="             ,      , ";
		character +="\n            /(.-''-.)\\ ";
		character +="\n        |\\  \\/      \\/  /| ";
		character +="\n        | \\ \\/ =.  .= \\ / | ";
		character +="\n        \\( \\   o\\/o   / )/ ";
		character +="\n         \\_, '-/  \\-' ,_/ ";
		character +="\n           /   \\__/   \\ ";
		character +="\n           \\ \\__/\\__/ / ";
		character +="\n         ___\\ \\|--|/ /___ ";
		character +="\n       /`    \\      /    `\\ ";
        character +="\n      /       '----'       \\ ";

		return character;
	}

	public String toString()
	{
		return "\n*Goblin's Level: " + getLevel() + "\n*Goblin's Health: " + getHealth();
	}
}
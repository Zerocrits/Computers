//Bill Joseph
//Vampire

public class Vampire extends Character
{
	public Vampire()
	{
		super(4,32);
	}

	public String getNameOfAttack()
	{
		int r = (int) (Math.random() * 4)+1;

		switch(r)
		{
			case 1 : return "Vampire Sucks your blood";
			case 2 : return "Vampire eats your dog:( ";
			case 3 : return "Vampire mutilates your body";
			case 4 : return "Vampire punches you in the gut";
		}
		return "Attack Error";
	}

	public String displayCharacter()
	{
		String character = "";

		character+="          _..._";
		character+="\n        .'     '.";
		character+="\n       ; __   __ ;";
		character+="\n       |/  \\ /  \\|";
		character+="\n     |\\| -- ' -- |/|";
		character+="\n     |(| \\o| |o/ |)|";
		character+="\n     _\\|     >   |/_";
		character+="\n  .-'  | ,.___., |  '-.";
		character+="\n  \\    ;  V'-'V  ;    /";
		character+="\n   `\\   \\       /   /`";
		character+="\n     `\\  '-...-'  /`";
		character+="\n       `\\  / \\  /`";
		character+="\n         `\\\\_//`";

		return character;
	}

	public String toString()
	{
		return "\n*Vampire's Level: " + getLevel() + "\n*Vampires's Health: " + getHealth();
	}
}
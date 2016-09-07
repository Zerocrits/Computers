//Bill Joseph
//Ghost

public class Ghost extends Character
{
	public Ghost()
	{
		super(2,25);
	}

	public String getNameOfAttack()
	{
		int r = (int) (Math.random() * 4)+1;

		switch(r)
		{
			case 1 : return "Ghost Haunts you";
			case 2 : return "Ghost summons your nightmare";
			case 3 : return "Ghost scares you half to death";
			case 4 : return "Ghost chases you into a ditch";
		}
		return "Attack Error";
	}

	public String displayCharacter()
	{
		String character = "";
        character+="                 .-.";
        character+="\n               .'   `.";
        character+="\n               :g g   :";
        character+="\n               : o    `.";
        character+="\n              :         ``.";
        character+="\n             :             `.";
        character+="\n            :  :         .   `.";
        character+="\n            :   :          ` . `.";
        character+="\n             `.. :            `. ``;";
        character+="\n                `:;             `:'";
        character+="\n                   :              `.";
        character+="\n                    `.              `.     .";
        character+="\n                      `'`'`'`---..,___`;.-'";

		return character;
	}

	public String toString()
	{
		return "\n*Ghost's Level: " + getLevel() + "\n*Ghost's Health: " + getHealth();
	}
}
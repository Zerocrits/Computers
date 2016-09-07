//Bill Joseph
//Slot Machine
//Spec: Build A Slot Machine

import java.util.Random;

public class Wheel
{

	private String face;
	int value;

	/** Default constructor spins the wheel */
	public Wheel()
	{
		spin();
	}

	/** Generates a random value for the wheel
	*	and calls setFace to assign a face based on the value generated */
	public void spin()
	{
		value = (int)(Math.random() * 12) + 1;
		setFace(value);
	}

	/** Sets the face of the wheel based upon the current value
	*	Outcomes are weighted so that some faces are more likely than others
	*	Hint: Use a switch here!
	*/
	public void setFace(int value)
	{
		switch(value)
		{
			case 1:
			case 2:
			case 3:
			case 4:
			case 5: face = "B"; break;
			case 6:
			case 7:
			case 8:
			case 9: face = "C"; break;
			case 10:
			case 11: face = "D"; break;
			case 12: face = "7"; break;
			default: face = "error"; break;
		}

	}

	/** @return the face of this wheel */
	public String getFace()
	{
		return face;
	}

	/** @return true if wheel arg is the same as this wheel
	*	*Note: the FACES must be the same
	*/
	public boolean equals(Wheel arg)
	{
		if(face.equals(arg.getFace()))
		{
			return true;
		}
		return false;
	}

	/** @return the face of this wheel as a String */
	public String toString()
	{
		return face;
	}
}

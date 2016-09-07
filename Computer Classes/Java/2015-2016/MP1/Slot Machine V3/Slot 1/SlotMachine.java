//Bill Joseph
//Slot Machine
//Spec: Build A Slot Machine

public class SlotMachine
{
	private Wheel w1,w2,w3;
	// Note: additional instance variables can be added here

	/** Instantiates the three wheels */
	public SlotMachine()
	{
		w1 = new Wheel();
		w2 = new Wheel();
		w3 = new Wheel();
	}

	/** @return true if all three wheels are the same, false otherwise */
	public boolean testWin()
	{
		if(w1.equals(w2) && w2.equals(w3))
		{
			return true;
		}
		return false;
	}

	/** @return a payout based on the type of wheel face
	*	Precondition: testWin() has been called to identify a win
	*/
	public int getPayout()
	{
		int payout = 0;
		if(testWin() == true)
		{
			if(w1.equals("B"))
			{
				payout += 100;
			}
			else if(w1.equals("C"))
			{
				payout += 500;
			}
			else if(w1.equals("D"))
			{
				payout += 500;
			}
			else if(w1.equals("7"))
			{
				payout += 1000;
			}
			else
				payout += 0;
		}
		return payout;
	}

	/** Spins all 3 wheels */
	public void spinAll()
	{
		w1 = new Wheel();
		w2 = new Wheel();
		w3 = new Wheel();
	}

	/** Spins wheel 1 */
	public void spin1()
	{
		w1 = new Wheel();
	}

	/** Spins wheel 2 */
	public void spin2()
	{
		w2 = new Wheel();
	}

	/** Spins wheel 3 */
	public void spin3()
	{
		w3 = new Wheel();
	}

	/** return a String version of all 3 wheels w a separator around each
	*	Ex: |w1|w2|w3|
	*/
	public String toString()
	{
		int payout = getPayout();
		return "|"+w1+"|"+w2+"|"+w3+"|";
	}
}
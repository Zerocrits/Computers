//Bill Joseph
//Slot Machine
//Spec: Build A Slot Machine
public class SlotMachine
{
	private Wheel w1,w2,w3;
	private int payout;
	private int coins;
	private String word;
	// Note: additional instance variables can be added here

	/** Instantiates the three wheels */
	public SlotMachine()
	{
		w1 = new Wheel();
		w2 = new Wheel();
		w3 = new Wheel();
		payout = 0;
		coins = 0;
		word = "";
	}

	/** @return true if all three wheels are the same, false otherwise */
	public boolean testWin()
	{
		if(w1.equals(w2) && w2.equals(w3))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/** @return a payout based on the type of wheel face
	*	Precondition: testWin() has been called to identify a win
	*/
	public int getPayout()
	{
		if(testWin() == true)
		{
			if(w1.getFace().equals("Bar"))
				payout = 100;
			else if(w1.getFace().equals("Cherry"))
				payout = 500;
			else if(w1.getFace().equals("Dice"))
				payout = 1000;
			else if(w1.getFace().equals("7"))
				payout = 10000;
		}
		else
		{
			payout = 0;
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
	public String spin1()
	{
		w1 = new Wheel();
		word = w1 + "";
		return word;
	}

	/** Spins wheel 2 */
	public String spin2()
	{
		w2 = new Wheel();
		word = w2 + "";
		return word;
	}

	/** Spins wheel 3 */
	public String spin3()
	{
		w3 = new Wheel();
		word = w3 + "";
		return word;
	}
	public String toString()
	{
		return "      |"+w1+"|"+w2+"|"+w3+"|      ";
	}
}
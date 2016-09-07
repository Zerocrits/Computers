//Bill Joseph
//Sound Runner
//Build a Sound Runner program

public class Sound
{
	/** the array of values in this sound; guaranteed not to be  null */
	private int[] samples;

	public Sound(int[] vals)
	{
		samples = new int[vals.length];
		for(int i = 0; i < vals.length; i++)
			samples[i] = vals[i];
		toString();
	}


	/** Changes those values in this sound that have an amplitude greater than  limit.
	*	Values greater than  limit are changed to  limit.
	*	Values less than  -limit are changed to  -limit.
	*	@param limit the amplitude limit
	*	Precondition:  limit >=  0
	*	@return the number of values in this sound that this method changed  */
	//PART A
	public int limitAmplitude(int limit)
	{
		int cnt = 0;
		if(limit >= 0)
		{
			for(int i = 0; i < samples.length; i++)
			{
				if(samples[i] > limit)
				{
					samples[i] = limit;
					cnt++;
				}
				else if(samples[i] < -limit)
				{
					samples[i] = -limit;
					cnt++;
				}
			}
		}
		return cnt;
	}



	/** Removes all silence from the beginning of this sound.
	*	Silence is represented by a value of 0.
	*	Precondition:  samples contains at least one nonzero value
	*	Postcondition: the length of  samples reflects the removal of starting silence  */
	//PART B
	public void trimSilenceFromBeginning()
	{
		int[] trim;
		int removal = 0;
		for(int i = 0; i < samples.length; i++)
		{
			if(samples[i] == 0)
				removal++;
			else
				i = samples.length;
		}
		trim = new int[(samples.length)-removal];
		for(int i = 0; i < trim.length; i++)
		{
			trim[i] = samples[removal];
			removal++;
		}
		samples = new int[trim.length];
		for(int i = 0; i < trim.length; i++)
			samples[i] = trim[i];
	}

	public String toString()
	{
		String s = "";
		for(int i = 0; i < samples.length; i++)
		{
			if(i < samples.length-1)
				s += samples[i] + ", ";
			else
				s += samples[i];
		}
		return s;
	}
}

/*

                        ***Digital Sound Program***

Original Sound File Values:
40, 2532, 17, -2300, -17, -4000, 2000, 1048, -420, 33, 15, -32, 2030, 3223

After amplitude is limited to 2000:
40, 2000, 17, -2000, -17, -2000, 2000, 1048, -420, 33, 15, -32, 2000, 2000
Number of values affected: 5

Sound file with silence in the beginning:
0, 0, 0, 0, 0, 0, 592, 128, -33, 60

Sound file with lead silence removed:
592, 128, -33, 60
Press any key to continue . . .

*/
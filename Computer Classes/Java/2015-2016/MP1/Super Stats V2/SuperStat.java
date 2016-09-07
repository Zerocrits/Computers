//Bill Joseph
//SuperStat Source
//Main Class of SuperStat


import java.util.Arrays;

public class SuperStat
{
	private String[] strNums;
	private int[] intNums;

	/** Default / No arg Constructor - instantiates both strNums and intNums arrays to zero length */
	public SuperStat()
	{
		strNums = new String[0];
		intNums = new int[0];
	}

	/** Constructor that takes a String nums and builds both a String[] and an int[] from it */
	public SuperStat(String nums)
	{
		strNums = nums.split(",");
		intNums = new int[strNums.length];
		for(int i = 0; i < strNums.length; i++)
			intNums[i] = Integer.parseInt(strNums[i]);
	}

	/** Calculates the Min for this intNums array */
	public int getMin()
	{
		int min = intNums[0];
		for(int i = 1; i < intNums.length; i++)
			if(i > intNums[i])
				min = intNums[i];
		return min;
	}

	/** Calculates the Max for this intNums array */
	public int getMax()
	{
		int max = intNums[0];
		for(int i = 1; i < intNums.length; i++)
			if(i < intNums[i])
				max = intNums[i];
		return max;
	}

	/** Calculates the Range for this intNums array
	/*  Note: You should make use of getMax() and getMin() here, don't re-implement code you already have */
	public int getRange()
	{
		int max = getMax();
		int min = getMin();
		int range = 0;
		range = max-min;
		return range;

	}

	/** Calculates the Arithmetic Mean for this intNums array */
	public double getMean()
	{
		double mean = intNums[0];
		for(int i = 1; i < intNums.length; i++)
			mean += intNums[i];
		mean = mean / intNums.length;
		return mean;
	}

	/** Calculates the Geometric Mean for this intNums array */
	public double getGeometricMean()
	{
		long product=1;
		for(int i = 0; i < intNums.length; i++)
			product = product * intNums[i];
		return Math.pow(product, 1.0/intNums.length);
	}

	/** Calculates the median for this intNums array */
	public double getMedian()
	{
		double median = 0;
		int i=0;
		int j=0;
		Arrays.sort(intNums);

		if(intNums.length % 2 == 1)
		{
			median = intNums[intNums.length / 2];
		}
		else
		{
			i = intNums[intNums.length / 2];
			j = intNums[(intNums.length / 2)-1];

			median = (j+i)/2;
		}

		return median;
	}

	/** Populates an int[] with a mode or modes from the intNums array
	/*  Returns null if no mode found
	/*  Note: 	Be sure to first sort the array (built-in method in Java)
	/*			Consider using nested for loops (and several vars) to track potential modes */
	public String getMode()
	{
		int testMode=0;
		int testOccur=0;
		int mode=0;
		int occur=0;
		String modeList="";

		for(int i = 0; i < intNums.length; i++)
		{
			testMode = intNums[i];


			for(int j = 0; j < intNums.length; j++)
			{
				if(testMode == intNums[j]&&testMode != mode)
				{
					testOccur++;
				}
			}

			if(testOccur > occur)
			{
				mode = testMode;
				occur = testOccur;
				modeList =  "" + mode;
			}

			else if(testOccur == occur)
			{
				mode = testMode;
				occur = testOccur;
				modeList += "," + mode;
			}

			testOccur=0;
		}
		if(occur == 1)
			return "null";
		else
			return modeList;
	}

	/** Standard Deviation is calculated
	/*		std dev = Square root of the sum of the square differences
	/*					from the mean divided by the number of values */
	public double getStdDev()
	{
		double dev = 0;
		double mean = getMean();
		double variance = 0;

		for(int i = 0; i < intNums.length; i++)
			variance += intNums[i] * intNums[i];
		variance = variance / intNums.length;
		dev = Math.sqrt(variance);
		return dev;
	}

	/** Returns a String with each of the Stats on a separate line
	/*  ie. Number of Values, Mean, Median, Mode, Min, Max, Range and Standard Deviation  */
	public String toString()
	{
		String result = "";

		result += "Number of Values: " + intNums.length;
		result += "\nArithmetic Mean: " + String.format("%.2f", getMean());
		result += "\nGeometric Mean: " + String.format("%.2f", getGeometricMean());
		result += "\nMedian: " + getMedian();
		result += "\nMode: " + getMode();
		result += "\nMin: " + getMin();
		result += "\nMax: " + getMax();
		result += "\nRange: " + getRange();
		result += "\nStandard Deviation: " + String.format("%.2f", getStdDev()) + "\n";

		return result;
	}
}

/*

                        ***Super Stat***
Number of Values: 10
Arithmetic Mean: 55.00
Geometric Mean: 45.29
Median: 55.0
Mode: null
Min: 10
Max: 100
Range: 90
Standard Deviation: 62.05

Number of Values: 6
Arithmetic Mean: 35.00
Geometric Mean: 29.94
Median: 35.0
Mode: null
Min: 10
Max: 60
Range: 50
Standard Deviation: 38.94

Number of Values: 10
Arithmetic Mean: 45.30
Geometric Mean: 30.73
Median: 26.0
Mode: 10
Min: 10
Max: 96
Range: 86
Standard Deviation: 57.50

Number of Values: 12
Arithmetic Mean: 47.92
Geometric Mean: NaN
Median: 44.0
Mode: 38,44
Min: 12
Max: 99
Range: 87
Standard Deviation: 52.87

Press any key to continue . . .

*/
// Bill Joseph
// Word
// Spec: ArrayList Parameter

public class Word
{
	private String word;

	public Word()
	{
		word = "";
	}

	public Word(String wrd)
	{
		word = wrd;
	}

	public void setWord(String wrd)
	{
		word = wrd;
	}

	public int getNumVowels()
	{
		int count=0;
		String vowels = "AEIOUaeiou";
		for(int i = 0; i < word.length(); i++)
		{
			for(int j = 0; j < vowels.length(); j++)
			{
				if(word.charAt(i) == vowels.charAt(j))
					count++;
			}
		}
		return count;
	}

	public int getLength()
	{
		int length = word.length();
		return length;
	}

	public String toString()
	{
	   return "";
	}
}
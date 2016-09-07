import java.util.ArrayList;

public class Kennel
{
    private ArrayList <Pet> petList;

    public Kennel()
    {
		petList = new ArrayList();
    }

    // Part C (Modified from original AP by Mr A)
    // Write method allSpeak.  For each Pet in the kennel, allSpeak
    // returns a String w/ the name of the Pet followed by
    // the result of a call to its speak method - each on its own line.

    public String allSpeak()
    {
		String speak = "";
		for(Pet p : petList)
		{
			speak += p.getName() + ": " + p.speak() + "\n";
		}
		return speak;
    }

    // added this method to add Pets to petList
    public void addPet(Pet fred)
    {
		petList.add(fred);
    }
}
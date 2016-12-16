// Class that models a maze of caves for the "Hunt the Wumpus" game.

import java.util.Scanner;
import java.io.File;

public class CaveMaze
{
	private Cave currentCave;
	private Cave[] caves;
	private int numGrenades;
	private int numWumpi;

	/**
	* Constructs a CaveMaze from the data found in a file.  Initially, there is 1 pit, 1 swarm of bats, and
	* between 1 and 3 wumpi randomly placed in the maze.  The player starts out in the cave numbered 0 with
	* three times as many grenades as there are wumpi.
	*   @param filename the name of the cave data file
	*/
	public CaveMaze(String filename) throws java.io.FileNotFoundException
	{
		Scanner infile = new Scanner(new File(filename));
		int num1, num2, num3, num; // Location of room and 3 adjacent room locations from the file
		int numCaves = infile.nextInt();
		int randomCave = 0;
		caves = new Cave[numCaves];

		for (int i = 0; i < numCaves; i++)
		{
			num = infile.nextInt();
			num1 = infile.nextInt();
			num2 = infile.nextInt();
			num3 = infile.nextInt();
			String name = infile.nextLine().trim();
			caves[num] = new Cave(name, num, num1, num2, num3);
		}
		// Determine the number of Wumpi and Grenades as specified above
		numWumpi = 3;
		numGrenades = numWumpi*3;



		//**** Place each Wumpi
		// Note: They should be placed randomly - however you also need to ensure that they
		//	are only placed in an empty cave... continue to check cave location contents
		//  until you find an available cave.
		for(int i = 0; i < numWumpi; i++)
		{
			randomCave = ((int)(Math.random() * caves.length));
			if(caves[randomCave].getContents() == CaveContents.EMPTY && randomCave != 0)
				caves[randomCave].setContents(CaveContents.WUMPUS);
			else
				i--;
		}


		//*** Place a Bat
		// Note: Same procedure, but there is just one bat to place.
		for(int i = 0; i < 1; i++)
		{
			randomCave = ((int)(Math.random() * numCaves-1)+1);
			if(caves[randomCave].getContents() == CaveContents.EMPTY && randomCave != 0)
				caves[randomCave].setContents(CaveContents.BATS);
			else
				i--;
		}


		//*** Place the pit
		// Note: Same procedure that you used for placing a bat
		for(int i = 0; i < 1; i++)
		{
			randomCave = ((int)(Math.random() * numCaves-1)+1);
			if(caves[randomCave].getContents() == CaveContents.EMPTY && randomCave != 0)
				caves[randomCave].setContents(CaveContents.PIT);
			else
				i--;
		}


		// 1 - set starting location ie currentCave to location 0
		// and 2 - mark it as visited
		currentCave = caves[0];
		currentCave.markAsVisited();
	}

	/**
	* Moves the player from the current cave along the specified tunnel.  The new location becomes the currentCave
	* and must be marked as visited and the appropriate action taken if the new location is not empty.
	* Note: if the tunnel # is not 1-3, then an error message should be returned.
	*   @param tunnel the number of the tunnel to be traversed (1-3)
	*   @return a status message describing the result of the move attempt
	*/
	public String move(int tunnel)
	{
		if(tunnel < 4 && tunnel > 0)
		{
			currentCave = caves[currentCave.getAdjNumber(tunnel)];
			if(currentCave.getContents() == CaveContents.BATS)
			{
				currentCave = caves[(int)(Math.random()*caves.length)];
				currentCave.markAsVisited();
				return "There is a bat in this room, you have been moved.";
			}
			if(currentCave.getContents() == CaveContents.WUMPUS)
				return "Oops there was a wumpus here, you have died.";
			if(currentCave.getContents() == CaveContents.PIT)
				return "You just fell into an endless pit.";
			else
				return "Bug in code, no content here.";
		}
		return "ERROR: INVALID PATH" + tunnel;
  	}

	/**
	* Tosses a grenade (only if the player has any) through the specified tunnel.
	* numGrenades is reduced by one.
	* If there is a wumpus in the corresponding cave, it is killed.
	* The message returned should tell the user the result of the toss... ie. a hit or a miss.
	* However, any remaining wumpi adjacent to the player are alerted by the explosion and may move as a result.
	* Note: if the tunnel # is not 1-3, then an error message should be returned.
	*   @param tunnel the number of the tunnel to be bombed (1-3)
	*   @return a status message describing the result of the toss attempt
	*/
	public String toss(int tunnel)
	{
		Cave target = caves[currentCave.getAdjNumber(tunnel)];
		String result = "";
		int randomCave = (int)(Math.random()*caves.length)+1;
		if(numGrenades > 0)
		{
			if(target.getContents() == CaveContents.WUMPUS)
			{
				numGrenades--;
				numWumpi--;
				target.setContents(CaveContents.EMPTY);
				result = "You Just Killed a Wumpus!";
			}
			else
			{
				numGrenades--;
				result = "You Didn't Hit Anything";
			}
		}
		return result;
	}

  /**
   * Returns the current cave name and the names of adjacent caves (if those caves have been visited).
   * Caves that have not yet been visited are identified as "unknown".  Also, warning messages are
   * included if the player is adjacent to a wumpi, bats, or a pit.
   *   @return a message containing the location information and warnings
   */
	public String showLocation()
	{
		String message = "You are currently in " + currentCave.getCaveName();
		boolean wumpusNearby = false, batsNearby = false, pitNearby = false;
		//Cave adj = caves[(int)(Math.random()*caves.length)+1];

		// Show the 3 adjacent rooms (the name of the room if visited, "unknown" otherwise)
		// Update the boolean flags (above) based on the CaveContents for each adjacent room
		//	the adjacent rooms
		// Likewise, update the message to add a warning about a Wumpus, Bats or Draft nearby

		for(int i = 1; i <= 3; i++)
		{
			Cave adjCave = caves[currentCave.getAdjNumber(i)];
			message += "\nCave " + i + ": ";
			if(adjCave.hasBeenVisited() == true)
				message += adjCave.getCaveName();
			else
				message += "Unknown!";
			if(adjCave.getContents() == CaveContents.PIT)
				pitNearby = true;
			if(adjCave.getContents() == CaveContents.BATS)
				batsNearby = true;
			if(adjCave.getContents() == CaveContents.WUMPUS)
				wumpusNearby = true;
		}
		if(batsNearby == true)
			message += "\nI smell a wumpus";
		if(wumpusNearby == true)
			message += "\nBats nearby";
		if(pitNearby == true)
			message += "\nI feel a draft";

		return message;
	}

	/**
	* Reports whether the player is still alive.
	*   @return true if alive, false otherwise
	* Note: This is more than an accessor method at this point...
	*	Meaning you need to evaluate the CaveContents of the current cave
	*	If there is a Wumpus or a Pit here... then our poor player is dead :(
	*/
	public boolean stillAlive()
	{
		if(currentCave.getContents() == CaveContents.WUMPUS || currentCave.getContents() == CaveContents.PIT)
			return false;
		else
			return true;
	}

	/**
	* Reports whether there are any wumpi remaining.
	*   @return true if there are wumpi remaining in the maze, false otherwise
	*	Note: Just evaluate this based on the current number of wumpi
	*/
	public boolean stillWumpi()
	{
		if(numWumpi > 0)
			return true;
		return false;
	}
}
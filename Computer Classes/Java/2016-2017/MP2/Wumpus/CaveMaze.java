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
		numWumpi = 5;
		numGrenades = numWumpi*3;
		//**** Place each Wumpi
		// Note: They should be placed randomly - however you also need to ensure that they
		//	are only placed in an empty cave... continue to check cave location contents
		//  until you find an available cave.
		for(int i = 0; i < numCaves; i++)
		{
			randomCave = ((int)(Math.random() * numCaves));
			if(caves[randomCave].getContents() == CaveContents.EMPTY)
				caves[randomCave].setContents(CaveContents.WUMPUS);
			else
				i--;
		}


		//*** Place a Bat
		// Note: Same procedure, but there is just one bat to place.
		for(int i = 0; i < 1; i++)
		{
			randomCave = ((int)(Math.random() * numCaves+1));
			if(caves[randomCave].getContents() == CaveContents.EMPTY)
				caves[randomCave].setContents(CaveContents.BATS);
			else
				i--;
		}


		//*** Place the pit
		// Note: Same procedure that you used for placing a bat
		for(int i = 0; i < 1; i++)
		{
			randomCave = ((int)(Math.random() * numCaves+1));
			if(caves[randomCave].getContents() == CaveContents.EMPTY)
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
		currentCave = caves[tunnel];
		if(tunnel < 4 || tunnel > 0)
		{
			if(caves[tunnel].getContents() == CaveContents.WUMPUS)
				return "I smell a wumpus";
			else if(caves[tunnel].getContents() == CaveContents.BATS)
				return "Bats nearby";
			else if(caves[tunnel].getContents() == CaveContents.PIT)
				return "I feel a draft";
		}
		return "ERROR: INVALID PATH";
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
		String result = "";
		if(tunnel < 4 || tunnel > 0 && numGrenades > 0)
		{
			if(caves[tunnel].getContents() == CaveContents.WUMPUS)
			{
				numGrenades--;
				numWumpi--;
				caves[tunnel].setContents(CaveContents.EMPTY);
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

		// Show the 3 adjacent rooms (the name of the room if visited, "unknown" otherwise)
		// Update the boolean flags (above) based on the CaveContents for each adjacent room
		//	the adjacent rooms
		// Likewise, update the message to add a warning about a Wumpus, Bats or Draft nearby

		for(int i = 1; i <= 3; i++)
		{
			Cave adjCave = caves[currentCave.getAdjNumber(i)];
			if(adjCave.getContents == CaveContents.PIT)
			{
				pitNearby = true;
				message += "\nI feel a draft";

			}
			if(adjCave.getContents == CaveContents.BATS)
			{
				batsNearby = true;
				message += "\nBats nearby";
			}
			if(adjCave.getContents == CaveContents.WUMPUS)
			{
				wumpusNearby = true;
				message += "\nI smell a wumpus";
			}

		}

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
		for(int i = 0; i < caves.length; i++)
		{
			if(caves[i].getContents() == CaveContents.WUMPUS)
				return true;
		}
		return false;
	}
}
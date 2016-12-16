public class Cave
{
	private String caveName;
	private int caveNumber, adj1, adj2, adj3;
	private CaveContents caveContents;
	private boolean visited;

	/** Constructs a cave with the specified characteristics.
	*	By default, the cave is unvisited and empty (you need to set this).
	*	@param name - the name of the cave
	*	@param num - the cave number
	*	@param adj1 - the number of the adjacent cave (through tunnel 1)
	*	@param adj2 - the number of the adjacent cave (through tunnel 2)
	*	@param adj3 - the number of the adjacent cave (through tunnel 3)
	*/
	public Cave(String name, int num, int adj1, int adj2, int adj3)
    {
		visited = false;
		caveName = name;
		caveNumber = num;
		caveContents = caveContents.EMPTY;
		adj1 = this.adj1;
		adj2 = this.adj2;
		adj3 = this.adj3;
	}


	/**Accesses the number of an adjacent cave.
	*	@param tunnel - the tunnel numbers (1-3)
	*	@return the number of the adjacent cave through that tunnel (or -1 if the tunnel number is not 1-3)*/
	public int getAdjNumber(int tunnel)
	{
		if(tunnel == 1)
			return adj1;
		else if(tunnel == 2)
			return adj2;
		else if(tunnel == 3)
			return adj3;
		else
			return -1;
	}

	/**	Accesses the name of the cave.
	*	@return	the cave name */
	public String getCaveName()
	{
		return caveName;
	}

	/** Accesses the number of the cave.
	*	@return	the cave number */
	public int getCaveNumber()
	{
		return caveNumber;
	}

	/** Accesses the contents of the contents (CaveContents.EMPTY, CaveContents.WUMPUS, CaveContents.BATS, or CaveContents.PIT).
	*	@return	the cave contents */
	public CaveContents getContents()
	{
		return caveContents;
	}

	/** Accessor Method - used to find out whether this cave has been visited previously.
	*	@return	true if it has been visited, otherwise false */
	public boolean hasBeenVisited()
	{
		if(visited == true)
			return true;
		else
			return false;
	}

	/** Marks the cave as having been visited.*/
	public void markAsVisited()
	{
		visited = true;
	}

	/** Sets the contents of the cave (CaveContents.EMPTY, CaveContents.WUMPUS, CaveContents.BATS, or CaveContents.PIT).
	*	@param contents - the new contents*/
	public void setContents(CaveContents contents)
	{
		caveContents = contents;
	}
}


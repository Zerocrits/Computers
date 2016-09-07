// Part B - Write a complete class declaration for the class LoudDog
// including implementations of its constructor and method(s)
// if the String dog-sound is returned by the Dog method speak,
// then the LoudDog method speak returns a String containing
// dog-sound repeated two times.

// Class Hierarchy:
//           ______
//          |     |
//          | Pet |
//          |_____|
//          /     \
//         /        \
//      __/___    ___\___
//      |     |   |      |
//      | Cat |   |  Dog |
//      |_____|   |______|
//                   |
//             ______|______
//             |            |
//             |  LoudDog   |
//             |____________|

public class LoudDog extends Pet
{
	public LoudDog(String name)
	{
		super(name);
	}
	public String speak()
	{
		return "woofwoof";
	}
}
// Part A - Write a complete class declaration for the class Cat
// including implementations of its constructor and method(s)
// the Cat method speak returns "meow" when it is invoked.

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

public class Cat extends Pet
{
	public Cat(String name)
	{
		super(name);
	}
	public String speak()
	{
		return "meow";
	}
}
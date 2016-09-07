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

public class Dog extends Pet
{
	public Dog(String name)
	{
		super(name);
	}
	public String speak()
	{
		return "woof";
	}
}
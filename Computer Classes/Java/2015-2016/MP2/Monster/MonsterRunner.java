// Name: Bill Joseph
// Prog: Monster Runner
// Spec: Build a Monster Program

public class MonsterRunner
{
   public static void main(String[] args)
   {
		Monster zero = new Monster();
		Monster one = new Monster(8);
		Monster sam = new Monster(9, 4);
		Monster harry = new Monster(1, 2, 3);
		System.out.println("\nMonster zero: \n" + zero);
		System.out.println("\nMonster one: \n" + one);
		System.out.println("\nMonster sam: \n" + sam);
		System.out.println("\nMonster harry: \n" + harry);

		System.out.println("\nChanging harry's properties... ");
		harry.setHeight(7);
		harry.setWeight(6);
		harry.setAge(5);
		System.out.println("\nMonster harry: \n" + harry);

		System.out.println("\nCloning sam into harry...");
		sam = (Monster)harry.clone();
		System.out.println("\nMonster sam: \n" + sam);

		Monster mOne = new Monster(33,33,11);
		Monster mTwo = new Monster(55,33,11);

		System.out.println("\nMonster 1: \n" + mOne);
		System.out.println("\nMonster 2: \n" + mTwo);

		System.out.print("\nmOne.equals(mTwo) = ");
		System.out.println(mOne.equals(mTwo));

		System.out.print("\nmOne.compareTo(mTwo) = ");
		System.out.println(mOne.compareTo(mTwo));
		System.out.print("\nmTwo.compareTo(mOne) = ");
		System.out.println(mTwo.compareTo(mOne));
	}
}
/*


Monster zero:
Height = 0 Weight = 0 Age = 0

Monster one:
Height = 8 Weight = 0 Age = 0

Monster sam:
Height = 9 Weight = 4 Age = 0

Monster harry:
Height = 1 Weight = 2 Age = 3

Changing harry's properties...

Monster harry:
Height = 7 Weight = 6 Age = 5

Cloning sam into harry...

Monster sam:
Height = 7 Weight = 6 Age = 5

Monster 1:
Height = 33 Weight = 33 Age = 11

Monster 2:
Height = 55 Weight = 33 Age = 11

mOne.equals(mTwo) = false

mOne.compareTo(mTwo) = -1

mTwo.compareTo(mOne) = 1
Press any key to continue . . .

*/
//Bill Joseph
//PetRunner
//PetRunner

import java.util.ArrayList;

public class PetRunner
{
	public static void main(String[] args)
	{
		Kennel kennel = new Kennel();
		Dog dog = new Dog("Dog");
		LoudDog loud = new LoudDog("LoudDog");
		Cat cat = new Cat("Cat");

		kennel.addPet(dog);
		kennel.addPet(loud);
		kennel.addPet(cat);

		System.out.println(kennel.allSpeak());
	}
}

/*

Dog: woof
LoudDog: woofwoof
Cat: meow

Press any key to continue . . .

*/

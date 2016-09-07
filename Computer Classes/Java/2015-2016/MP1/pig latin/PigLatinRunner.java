// Mr. A
// PigLatinRunner
// Spec: Simple client to test out the PigLatin object code

public class PigLatinRunner
{
	public static void main(String[] args)
	{
		PigLatin wd = new PigLatin("we hold these truths to be self evident");
		System.out.println(wd);

		System.out.println("\n");
		wd = new PigLatin("may the force be with you");
		System.out.println(wd);

		System.out.println("\n");
		wd = new PigLatin("once upon a time there were three little pigs");
		System.out.println(wd);
		System.out.println("\n");
	}
}
/*

e-way old-hay ese-thay uths-tray o-tay e-bay elf-say evident-yay


ay-may e-thay orce-fay e-bay ith-way ou-yay


once-yay upon-yay a-yay ime-tay ere-thay ere-way ee-thray ittle-lay igs-pay


Press any key to continue . . .

*/
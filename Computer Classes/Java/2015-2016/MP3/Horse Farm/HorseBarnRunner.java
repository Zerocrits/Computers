//Bill Joseph
//HorseBarnRunner
//Runs the HorseBarn Object

public class HorseBarnRunner
{
	public static void main(String[] args)
	{
		Horse trigger = new Horsey("Trigger", 1340);
		Horse one = null;
		Horse silver = new Horsey("Silver", 1210);
		Horse lady = new Horsey("Lady", 1575);
		Horse four = null;
		Horse patches = new Horsey("Patches", 1350);
		Horse duke = new Horsey("Duke", 1410);

		Horse[] horses = {trigger, one, silver, lady, four, patches, duke};

		HorseBarn mrAsFarm = new HorseBarn(horses);

		System.out.println("Trigger is in slot number " + mrAsFarm.findHorseSpace("Trigger"));
		System.out.println("Patches is in slot number " + mrAsFarm.findHorseSpace("Patches"));

		System.out.println("\nMr A's Horse Farm BEFORE Consolidation:");
		System.out.println(mrAsFarm);
		System.out.println("\nMr A's Horse Farm AFTER Consolidation:");
		mrAsFarm.consolidate();
		System.out.println(mrAsFarm);
	}
}
/*

Trigger is in slot number 0
Patches is in slot number 5

Mr A's Horse Farm BEFORE Consolidation:
Horses on the farm:


Trigger 1340
Empty Stall
Silver  1210
Lady    1575
Empty Stall
Patches 1350
Duke    1410

Mr A's Horse Farm AFTER Consolidation:
Horses on the farm:


Trigger 1340
Silver  1210
Lady    1575
Patches 1350
Duke    1410
Empty Stall
Empty Stall
Press any key to continue . . .

*/
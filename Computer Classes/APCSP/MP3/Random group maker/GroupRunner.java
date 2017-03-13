import java.util.*;

public class GroupRunner
{
	public static void main (String[] args)
	{
		boolean choice = true;
		Scanner sc = new Scanner(System.in);
		while(choice == true)
		{
			System.out.println("~~~~Random Group Runner~~~~");
			System.out.print("Group Size: ");
			int groupSize = sc.nextInt();
			GroupLogic logic = new GroupLogic(groupSize);
			logic.toString();


			System.out.print("Would you Like to make more groups?: ");
			if(sc.nextLine() != "yes");
				choice = false;
			System.out.println("\n\n");
		}
	}

}
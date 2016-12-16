// Simple, text-based interface for playing "Hunt the Wumpus"
// Note: This is complete as is - your job is to complete the other classes.
import java.util.Scanner;

public class HuntTheWumpusRunner
{

    public static void main(String[] args) throws java.io.FileNotFoundException
    {
        CaveMaze maze = new CaveMaze("caves.txt");
        String command;
        char action;
        int target;

        System.out.println("HUNT THE WUMPUS:  Your mission is to explore the maze of caves");
        System.out.println("and destroy all of the wumpi (without getting yourself killed).");
        System.out.println("To move to an adjacent cave, enter 'm' and the tunnel number.");
        System.out.println("To toss a grenade into a cave, enter 't' and the tunnel number.");
        System.out.println();

        Scanner input = new Scanner(System.in);
        while (maze.stillAlive() && maze.stillWumpi())
        {
            System.out.println(maze.showLocation());

            command = input.next().trim().toLowerCase();
            action = command.charAt(0);

            try
            {
                target = Integer.parseInt(command.substring(1));
            }
            catch (java.lang.NumberFormatException e)
            {
                target = input.nextInt();
            }

            if(action == 't')
            {
                System.out.println(maze.toss(target));
            }
            else if(action == 'm')
            {
                System.out.println(maze.move(target));
            }
            else
            {
                System.out.println("Unrecognized command.");
            }
        }
        if(maze.stillWumpi()== false)
        	System.out.println("You won!!!");
        System.out.println("GAME OVER");
    }
}

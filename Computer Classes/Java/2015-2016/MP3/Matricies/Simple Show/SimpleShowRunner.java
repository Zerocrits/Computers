// Bill Joseph
// Simple Show Runner
// Spec: A simple client to test out the SimpleShow object

import java.util.*;

public class SimpleShowRunner
{
	public static void main(String[] args)
	{
		SimpleShow show = new SimpleShow();
		int seatNum;

		show.reserveSeat(0,0);
		show.reserveSeat(0,1);
		show.reserveSeat(0,2);
		show.reserveSeat(0,4);
		show.reserveSeat(1,0);
		show.reserveSeat(1,1);
		show.reserveSeat(2,2);
		show.reserveSeat(3,2);
		show.reserveSeat(4,2);
		show.reserveSeat(5,1);
		show.getTwoTogether();

		System.out.println(show);
		System.out.println("Seats Still Available: " + show.numSeatsAvailable());
		System.out.println("Total Revenue: $" + show.getTotalRevenue());

		System.out.println("\nLooking for 3 adjacent seats in row 2 (third row)... ");
		seatNum = show.findAdjacent(2,3);
		if(seatNum == -1)
			System.out.println("\t\tNot available");
		else
			System.out.println("\t\tAvailable in row 3 beginning with seat number " + seatNum);

		System.out.println("Looking for 3 adjacent seats in row 6... ");
		seatNum = show.findAdjacent(6,3);
		if(seatNum == -1)
			System.out.println("\t\tNot available");
		else
			System.out.println("\t\tAvailable in row 6 beginning with seat number " + seatNum);

		System.out.println("Looking for 8 adjacent seats in row 7 (third row)... ");
		seatNum = show.findAdjacent(7,8);
		if(seatNum == -1)
			System.out.println("\t\tNot available");
		else
		System.out.println("\t\tAvailable in row 7 beginning with seat number " + seatNum);

		System.out.println("Looking for 3 adjacent seats in row 5 (third row)... ");
		seatNum = show.findAdjacent(5,3);
		if(seatNum == -1)
			System.out.println("\t\tnot available");
		else
		System.out.println("\t\tAvailable in row 5 beginning with seat number " + seatNum);

		show.clearAllSeats();
		System.out.println("\nNew Show\nSeats Still Available: " + show.numSeatsAvailable());
		System.out.println("Total Revenue: $" + show.getTotalRevenue());

		show = new SimpleShow(2,4);
		System.out.println(show);
	}
}
/*

AP Concert Hall - Simplified
X       X       X       O       X
X       X       O       O       O
O       O       X       O       O
O       O       X       O       O
O       O       X       O       O
O       X       O       O       O
O       O       O       O       O
O       O       O       O       O
O       O       O       O       O
O       O       O       O       O

Seats Still Available: 40
Total Revenue: $380

Looking for 3 adjacent seats in row 2 (third row)...
                Not available
Looking for 3 adjacent seats in row 6...
                Available in row 6 beginning with seat number 0
Looking for 8 adjacent seats in row 7 (third row)...
                Not available
Looking for 3 adjacent seats in row 5 (third row)...
                Available in row 5 beginning with seat number 2

New Show
Seats Still Available: 50
Total Revenue: $0
AP Concert Hall - Simplified
O       O       O       O
O       O       O       O

Press any key to continue . . .

*/
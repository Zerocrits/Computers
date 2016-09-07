// Bill Joseph
// CourseRunner

public class CourseRunner
{
	public static void main(String[] args)
	{
		Course per4 = new Course("APCS");

		per4.addStudent("Bugs", "Bunny", new int[] {90,88,100,100,88} );
		per4.addStudent("Sylvester", "Cat", new int[] {45,23,62,99} );
		per4.addStudent("Taz", "Devil", new int[] {84,99,77,100} );
		per4.addStudent("Tweety", "Bird", new int[] {66,54,21,98,88} );
		per4.addStudent("Lola", "Bunny", new int[] {95,100,100,98,87} );


		System.out.println(per4);
	}
}
/*

APCS
        Bird, Tweety     Grades: [66, 54, 21, 98, 88]    Average: 65.0
        Bunny, Bugs      Grades: [90, 88, 100, 100, 88]  Average: 93.0
        Bunny, Lola      Grades: [95, 100, 100, 98, 87]  Average: 96.0
        Cat, Sylvester   Grades: [45, 23, 62, 99]        Average: 57.0
        Devil, Taz       Grades: [84, 99, 77, 100]       Average: 90.0
Class Average: 80.0
Press any key to continue . . .

*/
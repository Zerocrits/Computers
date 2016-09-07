// Bill Joseph

import java.util.ArrayList;

public class Student implements Comparable<Student>
{
	private String first, last;
	private ArrayList <Integer> grades;

	public Student()
	{
		first = "";
		last = "";
	}

	public Student(String x, String y, int[] arrGrades)
	{
		grades = new ArrayList<Integer>();
		first = x;
		last = y;
		for(int i : arrGrades)
		grades.add(new Integer(i));
	}

	/**	@return the average for this student */
	public double getAverage()
	{
		int count = 0;
		int sum = 0;
		for(int i : grades)
		{
			count++;
			sum += i;
		}
		return sum/count;
	}

	/** @return the correct comparison of last name and first name
	*	Hint: check to see if the last names are the same
	*			if so -> compare first names
	*			otherwise compare last names
	*	Extra Hint: You don't need to re-invent the wheel here...
	*				The underlying data type is String
	*/
	public int compareTo(Student rhs)
	{
		int i = last.compareTo(rhs.last);

		if(i != 0)
			return i;
		else
			return first.compareTo(rhs.first);
	}

	/** @return LastName, FirstName followed by the student's grades and their average
	*			with a tab in-between.
	*	Ex: Bunny, Bugs     Grades: [90, 88, 100, 100, 88]  Average: 93.2
	*/
	public String toString()
	{
		return last + ", " + first + "\t Grades: " + grades.toString() + "\t Average: " + getAverage();
	}
}


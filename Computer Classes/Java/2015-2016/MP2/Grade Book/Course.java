// Bill Joseph

import java.util.ArrayList;
import java.util.Collections;

public class Course
{
	private String courseName;
	private ArrayList<Student> students;

	public Course()
	{
		students = new ArrayList<Student>();
	}

	public Course(String x)
	{
		students = new ArrayList<Student>();
		courseName = x;
	}

	public void addStudent(String x, String y, int[] grades)
	{
		students.add(new Student(x, y, grades));
	}

	/** @return The class average... ie. the average of each student average */
	public double getClassAverage()
	{
		int count = 0;
		int sum = 0;
		for(Student s : students)
		{
			count++;
			sum += s.getAverage();
		}
		return sum/count;
	}

	/** Hint: Use the built in sort here */
	public void sortStudents()
	{
		Collections.sort(students);
	}

	/** @return the output as shown */
	public String toString()
	{
		sortStudents();
		String output = courseName;
		for(Student s : students)
			output += "\n\t" + s;
		output += "\nClass Average: " + getClassAverage();
		return output;
	}
}
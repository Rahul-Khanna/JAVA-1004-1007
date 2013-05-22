
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * A Class which is a list of all courses used in the program
 * @author R_K
 */

public class CourseList {

	/**
	 * The ArrayList used to store the courses used
	 */
	private ArrayList<Course> courseList= new ArrayList<Course>();
	/**
	 * The location of the course in the list
	 */
	private int courseLocation;

	/**
	 * Constructs a CourseList object that is used to store all courses
	 */
	public CourseList()
	{
	}
	/**
	 * Fills the ArrayList used to store the courses with the courses from the file
	 * @param courses the file with all the courses
	 * @throws FileNotFoundException error when no file is give to the method
	 */
	public void createList(File courses) throws FileNotFoundException
	{
		Scanner input= new Scanner(courses);

		while(input.hasNext())// scans through the file, taking the first input as the course ID and the second as the course size
		{
			int courseID= input.nextInt();
			int courseSize = input.nextInt();
			courseList.add(new Course(courseID, courseSize));// adds the course to the ArrayList
		}
	}
	/**
	 * Checks if a course is in the course list, and returns false if it is, and true if it is not.
	 * @param aCourseID the name of the course to be found
	 * @return false if the course is found, true if the course isn't found
	 */
	public boolean courseInCourseList(int aCourseID)
	{
		boolean notFound=true;
		for(int i = 0; i<courseList.size(); i++)
		{
			if(courseList.get(i).getCourseID()==aCourseID)
			{
				notFound=false;
				courseLocation=i;
				break;
			}			
		}

		return notFound;
	}
	/**
	 * Returns the most recent found course
	 * @return the most recent found course
	 */
	public Course getFoundCourse()
	{
		return courseList.get(courseLocation);
	}
	/**
	 * Returns the course list in a String form so the user can choose what to do with it
	 * @return the course list in a String form
	 */
	public String getCourseList()// this isn't used anywhere, but I thought in case I ever need it again, it would be good to have
	{
		String courseListString= courseList.toString();
		return courseListString;
	}

}

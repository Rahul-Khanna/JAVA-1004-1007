
import java.util.ArrayList;
/**
 * A class that is created to act as a course
 * @author R_K
 */

public class Course {
	/**
	 * The name of the course
	 */
	private int courseID;
	/**
	 * The size of a course
	 */
	private int courseSize;
	/**
	 * An arraylist of students in the course
	 */
	private ArrayList<Student> rollBook= new ArrayList<Student>();
	/**
	 * The number of students in a course
	 */
	private int enrollement;
	/**
	 * The error message to be outputed to the screen, if there is an error while adding a student
	 */
	private String addErrorMessage;

	/**
	 * Constructs a Course object that has a name, size and starts of with zero students
	 * @param aCourseID the name of the course
	 * @param aCourseSize the size of the course
	 */
	public Course (int aCourseID, int aCourseSize)
	{
		courseID= aCourseID;
		courseSize= aCourseSize;
		enrollement=0;
	}
	/**
	 * Returns the name of the course
	 * @return the name of the course
	 */
	public int getCourseID()
	{
		return courseID;
	}
	/**
	 * Returns the size of the course
	 * @return the size of the course
	 */
	public int getCourseSize()
	{
		return courseSize;
	}
	/**
	 * Allows the administrator to change the course size
	 * @param newCourseSize the size the course is changed to
	 */
	public void adminChangeCourseSize(int newCourseSize)
	{
		courseSize=newCourseSize;
	}
	/**
	 * Adds a student to the rollBook of a course
	 * @param aStudent the student to be added
	 * @return if the student is added returns true, else creates the error message and returns false
	 */
	public boolean addStudent(Student aStudent)
	{
		if(enrollement < courseSize && !(rollBook.contains(aStudent)))// checks it there is space in the course, and if the student is already registered for the course
		{
			rollBook.add(aStudent);
			enrollement++;
			return true;
		}


		else
		{
			if(rollBook.contains(aStudent))
				addErrorMessage= "You are already registered for this course.";
			else
				addErrorMessage= "Sorry this course is either full.\nContact the Administrator for further help.";

			return false;
		}

	}
	/**
	 * Returns the error message generated when adding a student to a course
	 * @return the error message
	 */
	public String getAddErrorMessage()// Since there were two reasons why a student wouldn't be able to join a class I wanted to make the user knew which one it was.
	{								//So I made it create an error message for each case, but since the add message was already returning a boolean I had to create this method.
		return addErrorMessage;
	}
	/**
	 * Allows the Admin to add a student to a course, overriding the class capacity.
	 * @param aStudent the student to be added
	 * @return true if the student was added, false if there was a problem
	 */
	public boolean addStudentAdmin(Student aStudent)
	{
		if(!(rollBook.contains(aStudent)))// still checks to see if the student is already registered for the course
		{
			rollBook.add(aStudent);
			enrollement++;
			return true;
		}

		else
			return false;

	}
	/**
	 * Removes a student from a course
	 * @param aStudent the student to be dropped
	 */
	public void dropStudent(Student aStudent)
	{
		rollBook.remove(rollBook.indexOf(aStudent));
	}
	/**
	 * My own toString method which only returns the course name
	 */
	public String toString()
	{
		String courseName= ""+ courseID;
		return courseName;
	}
	/**
	 * Returns the rollBook of a course
	 * @return the rollBook of a course
	 */
	public ArrayList<Student> getRollBook()// I needed it to return an arraylist since I wanted to check if the arraylist was empty in AdminRegistration.
	{
		return rollBook;
	}

}



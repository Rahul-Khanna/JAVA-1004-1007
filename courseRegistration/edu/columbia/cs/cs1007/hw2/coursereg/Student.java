
import java.util.ArrayList;
/**
 * A class that is created to act as a Student
 * @author R_K
 */

public class Student {
	/**
	 * The students ID number
	 */
	private int studentID;
	/**
	 * The students password
	 */
	private String studentPassword;
	/**
	 * The schedule of classes of the student
	 */
	private ArrayList<Course> schedule= new ArrayList<Course>();
	/**
	 * The location of a course in the students schedule
	 */
	private int courseLocation;
	
	/**
	 * Constructs a Student object that has a ID number and a password, along with a schedule
	 * @param aStudentID the students ID number
	 * @param aPassword the students password
	 */
	public Student(int aStudentID, String aPassword)
	{
		studentID= aStudentID;
		studentPassword= aPassword;
	}
	/**
	 * Returns the students ID
	 * @return the students ID
	 */
	public int getStudentID()
	{
		return studentID;
	}
	/**
	 * Returns the students password
	 * @return the students password
	 */
	public String getStudentPassword()
	{
		return studentPassword;
	}
	/**
	 * Adds a course to the students schedule
	 * @param aCourse the course to be added
	 */
	public void addCourse(Course aCourse)
	{
		schedule.add(aCourse);
	}
	/**
	 * Finds a course in the schedule in the students, and returns true if found, or false if not found
	 * @param aCourseID the courseID of the course to be found
	 * @return true if the course is found, false if not found
	 */
	public boolean findCourseInSchedule(int aCourseID)
	{
		boolean notFound=true;
		for(int i = 0; i<schedule.size(); i++)
		{
			if(schedule.get(i).getCourseID()==aCourseID)// checks to see if the course is in schedule
			{
				notFound=false;
				courseLocation=i;
				break;//stops the iteration if the course is found
			}			
		}
		return notFound;
	}
	/**
	 * Drops a course in the students schedule, if the course is found in the schedule
	 */
	public void dropCourse()
	{
		schedule.remove(courseLocation);
	}
	/**
	 * Returns the course that has been most recently dropped by the student
	 * @return the course the has been most recently dropped by the student
	 */
	public Course getDroppedCourse()
	{
		return schedule.get(courseLocation);
	}
	/**
	 * Returns the students schedule
	 * @return the students schedule
	 */
	public ArrayList<Course> getSchedule()// I needed the arraylist for StudentRegistration
	{
		return schedule;
	}
	/**
	 * My own toString method which only returns the student ID
	 */
	public String toString()
	{
		String nameOfStudent= ""+ studentID;
		return nameOfStudent;
	}
}

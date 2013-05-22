
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * A Class which is the directory of all the students.
 * @author R_K
 */
public class StudentDirectory {
	/**
	 * The ArrayList which stores all the students
	 */
	private ArrayList<Student> studentDirectory= new ArrayList<Student>();
	/**
	 * The location of a student in the directory
	 */
	private int studentLocation;
	
	/**
	 * Constructs a StudentDirectory object
	 */
	public StudentDirectory()
	{
	}
	/**
	 * Fills the ArrayList used to store the students with the student from the file
	 * @param students the file with all the students
	 * @throws FileNotFoundException error when no file is found
	 */
	public void createDirectory(File students) throws FileNotFoundException
	{
		Scanner input= new Scanner(students);
	
		while(input.hasNext())// scans through the file, taking the first input as the student ID and the second as the password
		{
			int studentID= input.nextInt();
			String password = input.next();
			studentDirectory.add(new Student(studentID, password));//adds the student to the directory
		}
	}
	/**
	 * Checks to see if a student is in the directory, returns false if he/she is and true if he/she isn't
	 * @param aStudentID the student that needs to be checked
	 * @return false if found, true if not
	 */
	public boolean studentInStudentDirectory(int aStudentID)
	{
		boolean notFound=true;
		for(int i = 0; i<studentDirectory.size(); i++)
		{
			if(studentDirectory.get(i).getStudentID()==aStudentID)
			{
				notFound=false;
				studentLocation=i;
				break;
			}			
		}

		return notFound;
	}
	/**
	 * Returns the most recent found student
	 * @return the most recent found student
	 */
	public Student getFoundstudent()
	{
		return studentDirectory.get(studentLocation);
	}
	/**
	 * Returns a String version of the student directory
	 * @return a String version of the student directory
	 */
	public String getStudentDirectory()// this isn't used anywhere, but I thought in case I ever need it again, it would be good to have
	{
		String studentDirectoryString= studentDirectory.toString();
		return studentDirectoryString;
	}
	
}

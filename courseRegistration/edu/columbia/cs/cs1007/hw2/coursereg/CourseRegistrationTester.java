
import java.io.File;
import java.io.IOException;
/**
 * A class to test the Course Registration program
 * @author R_K
 *
 */

public class CourseRegistrationTester {

	/**
	 * Creates a Course Registration system
	 * @param args the files needed to create the student directory and the course list.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			File studentFile= new File(args[0]);
			File coursesFile= new File(args[1]);
			StudentDirectory students = new StudentDirectory();
			CourseList courses= new CourseList();
			students.createDirectory(studentFile);
			courses.createList(coursesFile);
			RegistrationUnit telephone= new RegistrationUnit(students, courses);
			telephone.operate();
		}

		catch (IOException e)  // tells the user that files inputed are not valid
		{
			System.out.println("\nPlease try again with a correct file name. Also remember that the file with the students goes first then the file with the courses.\n The student file should be formatted with one and only one student's student ID and password, seperated by a space, on one line." +
					"\n The course file should be formatted with one and only one course's course ID and class size, sperated by a spcae, on one line.");
		}

		catch(ArrayIndexOutOfBoundsException e) //tell the user that he hasn't given enough information
		{
			System.out.println("You must enter two files, and only two files.");
		}

	}
}




import java.util.Scanner;
/**
 * A class that is used as the connection to the AdminRegistration and the StudentRegistration menus, (like the telephone)
 * @author R_K
 */

public class RegistrationUnit {
	/**
	 * The directory of all students
	 */
	private StudentDirectory students = new StudentDirectory();
	/**
	 * The list of all courses
	 */
	private CourseList courses=new CourseList();
	/**
	 * The boolean which keeps the system on
	 */
	private boolean operate;
	/**
	 * The boolean which allows the user to retry things instead of going back to the main menu
	 */
	private boolean again;
	/**
	 * The hard-coded administrator user
	 */
	private Admin administrator= new Admin();
	/**
	 * The scanner, which reads the user's input
	 */
	private Scanner input= new Scanner(System.in);
	
	/**
	 * Constructs the RegistrationUnit, which has a directory of students, a list of classes, and starts the switches the boolean operate and again to true.
	 * @param aCourseList a list of courses
	 * @param aDirectory a directory of students
	 */
	public RegistrationUnit(StudentDirectory aDirectory, CourseList aCourseList)
	{
		students=aDirectory;
		courses=aCourseList;
		operate=true;
		again=true;
	}
	/**
	 * The method which brings up the main menu and allows the user to access StudentRegistration and AdminRegistration
	 */
	public void operate()
	{
		while(operate)
		{
			System.out.println("\nHello and Welcome to this course registraion system.\nAre you an admin or a student? Please enter admin or student.\nIf you want to shudown the system enter quit.");
			String type= input.next();
			if(type.equalsIgnoreCase("student"))// the block of code associated with accessing the StudentRegistration
			{
				again=true;
				while(again)
				{
					System.out.println("\nPlease enter your student ID number: ");
					int studentID= input.nextInt();
					if(!(students.studentInStudentDirectory(studentID)))//checks if student exits
					{
						Student user= students.getFoundstudent();
						System.out.println("\nPlease enter your password: ");
						if(user.getStudentPassword().equals(input.next()))//check if password is correct
						{
							StudentRegistration studentRegistar= new StudentRegistration(courses, user);
							studentRegistar.register();
							again=false;
						}
						else
						{
							System.out.println("Your password was incorrect");
							yesOrNoMessage();
						}
							
					}
					else
					{
						System.out.println("Your student ID was incorrect");
						yesOrNoMessage();
					}
						
				}
			}

			if(type.equalsIgnoreCase("admin"))// the block of code associated with accessing the AdminRegistration
			{
				again=true;
				while(again)
				{
					System.out.println("\nPlease enter the admin ID number: ");
					if(input.nextInt()==administrator.getAdminID())//checks if adminID is correct
					{
						System.out.println("\nPlease enter the password: ");
						if(input.next().equals(administrator.getAdminPassword()))//check if password is correct
						{
							AdminRegistration adminRegistar= new AdminRegistration(courses, students);
							adminRegistar.register();
							again=false;
						}
						else
						{
							System.out.println("The password was incorrect.");
							yesOrNoMessage();
						}
							
					}
					else
					{
						System.out.println("The admin ID was incorrect.");
						yesOrNoMessage();
					}	
				}
			}
			if(type.equalsIgnoreCase("quit"))
			{
				System.out.println("\nGoodbye.");
				operate=false;
			}	
		}
	}
	/**
	 * A method which asks the user whether they want to repeat an action, it also the user to make a mistake in typing without the program shutting down.
	 */
	public void yesOrNoMessage()// the point of this was to clean up my code and make the code more user friendly, so that the code wouldn't shut down
	{
		boolean yesOrNo=true;
		System.out.println("Do you want to try again? Enter yes or no.");
		while(yesOrNo)
		{
			String yesNo= input.next();
			if(yesNo.equalsIgnoreCase("no")||yesNo.equalsIgnoreCase("yes"))//checks if user entered yes or no
			{
				yesOrNo=false;
				if(yesNo.equalsIgnoreCase("no"))
					again=false;
			}
			else
				System.out.println("\nSorry I couldn't read that. Do you want to try again? Enter yes or no.");// makes sure the user types in yes or no
		}
	}
}

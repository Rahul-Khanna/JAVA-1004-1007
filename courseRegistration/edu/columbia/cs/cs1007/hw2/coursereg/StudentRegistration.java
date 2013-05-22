
import java.util.Scanner;
/**
 * A class that is used to be the interface for the Student user
 * @author R_K
 */

public class StudentRegistration {
	/**
	 * An arraylist of courses
	 */
	private CourseList courses;
	/**
	 * The student using the system
	 */
	private Student user;
	/**
	 * The boolean that allows the user to not quit after an action
	 */
	private boolean operate;
	/**
	 * The scanner, used to read input from the user
	 */
	private Scanner input= new Scanner(System.in);	
	/**
	 * The boolean that allows the user to repeat an action
	 */
	private boolean again;
	/**
	 * The string that stores the users input
	 */
	private String key;
	
	/**
	 * Constructs the StudentRegistration object that allows a student user to use the course registration system
	 * @param aCourseList the ArrayList of courses from the course file
	 * @param aStudent the student using the system
	 */
	public StudentRegistration(CourseList aCourseList, Student aStudent)
	{
		courses=aCourseList;
		user=aStudent;
		operate=true;
	}
	/**
	 * The main method for the student. It provides the user with all the different actions available and responds accordingly to the input supplied by the user
	 */
	public void register()
	{
		boolean firstTime=true;
		while(operate)
		{

			if(firstTime)// changes the message after the first time
				System.out.println("\nHello, what would you like to do right now? \nYou can either add a courses, drop a courses or view your courses.");
			System.out.println("\nIf you want to add a courses enter add.");
			System.out.println("If you want to drop a courses enter drop.");
			System.out.println("If you want to view your courses enter view.");
			System.out.println("If you would like to exit enter exit.");
			key=input.next();

			if(key.equalsIgnoreCase("add"))
			{
				again= true;
				while(again)//allows the user to repeat action without having to go back to the menu
				{
					System.out.println("\nPlease enter the course number you would like to add.");
					int courseID= input.nextInt();

					if(!(courses.courseInCourseList(courseID)))//checks to see if the course is in the course list 
					{

						if(courses.getFoundCourse().addStudent(user))//checks to see if the student can be added to the course
						{
							user.addCourse(courses.getFoundCourse());
							System.out.println("\nYou have succesfully added course " + courseID);
						}
						else
							System.out.println("\n"+courses.getFoundCourse().getAddErrorMessage());
					}
					else
						System.out.println("\nSorry this course doesn't exist.");
					yesOrNoMessage();
				}

			}	

			if(key.equalsIgnoreCase("drop"))
			{
				again=true;
				while(again)//allows the user to repeat action without having to go back to the menu
				{
					System.out.println("\nPlease enter the course number you would like to drop.");
					int courseID=input.nextInt();
					if(!(courses.courseInCourseList(courseID)))//checks to see if the course is in the course list
					{
						if(!(user.findCourseInSchedule(courseID)))//checks to see if the student is registered for the course
						{
							user.getDroppedCourse().dropStudent(user);
							user.dropCourse();
							System.out.println("\nYou have succesfully droped course " + courseID);	
						}
						else
							System.out.println("\nSorry you are not registered for this class");
					}
					else
						System.out.println("\nSorry this course doesn't exist.");
					yesOrNoMessage();
				}
			}

			if(key.equalsIgnoreCase("view"))
			{
				if(!(user.getSchedule().isEmpty()))//check if the student is registered for any classes
				{
					System.out.println("\nHere are your classes: ");
					System.out.println(user.getSchedule());
				}

				else
					System.out.println("\nYou are not registered for any classes.\n");
			}

			if(key.equalsIgnoreCase("exit"))//allows the user to quit by changing operate to false
			{
				System.out.println("\nGoodbye.\n");
				operate=false;	
			}
			firstTime=false;
		}
	}
	/**
	 * A method which asks the user whether they want to repeat an action, it also the user to make a mistake in typing without the program shutting down.
	 */
	public void yesOrNoMessage()// the point of this was to clean up my code and make the code more user friendly, so that the code wouldn't shut down
	{
		boolean yesOrNo=true;
		System.out.println("\nWould you like to " + key + " another course? Enter yes or no.");
		while(yesOrNo)
		{
			String yesNo= input.next();
			if(yesNo.equalsIgnoreCase("no")||yesNo.equalsIgnoreCase("yes"))
			{
				yesOrNo=false;
				if(yesNo.equalsIgnoreCase("no"))
					again=false;
			}
			else
				System.out.println("\nSorry I couldn't read that. Would you like to " + key + " another course? Enter yes or no.");
		}
	}
}

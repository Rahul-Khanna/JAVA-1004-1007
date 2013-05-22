
import java.util.Scanner;
/**
 * A class that is used to be the interface for the Administrator user
 * @author R_K
 */

public class AdminRegistration {
	/**
	 * An arraylist of courses
	 */
	private CourseList courses=new CourseList();
	/**
	 * An arraylist of students
	 */
	private StudentDirectory students = new StudentDirectory();
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
	 * Constructs the AdminRegistration object that allows the Administrator user to use the course registration system
	 * @param aCourseList the ArrayList of courses from the course file
	 * @param aDirectory the ArrayList of students from the student file
	 */
	public AdminRegistration(CourseList aCourseList, StudentDirectory aDirectory)
	{
		courses=aCourseList;
		students=aDirectory;
		operate=true;
	}

	/**
	 * The main method for the Administrator. It provides the user with all the different actions available and responds accordingly to the input supplied by the user
	 */
	public void register()
	{
		boolean firstTime= true;
		while(operate)
		{
			if(firstTime)// changes the message after the first time
				System.out.println("\nHello Admin. What would you like to do?");
			firstTime=false;
			System.out.println("\nIf you want to view the students in a course, enter view.");
			System.out.println("If you want to add a student to a course, enter add.");
			System.out.println("If you want to drop a student from a course, enter drop.");
			System.out.println("If you want to change the size of a course, enter size.");
			System.out.println("If you would like to exit, enter exit");
			key=input.next();

			if(key.equalsIgnoreCase("view"))
			{
				again=true;
				while(again)//allows the user to repeat action without having to go back to the menu
				{
					System.out.println("\nEnter the course number of the course you would like to view: ");
					int courseID= input.nextInt();

					if(!(courses.courseInCourseList(courseID)))// checks if the course is in the arraylist of courses
					{
						if(!(courses.getFoundCourse().getRollBook().isEmpty()))//checks to see if the class is empty
							System.out.println("\nHere are the students in this course.\n" + courses.getFoundCourse().getRollBook());
						else
							System.out.println("\nThere are currently no students in this course.");
					}
					else
						error1();
					yesOrNoMessage("\nWould you like to view another course? Enter yes or no.");
				}
			}

			if(key.equalsIgnoreCase("add"))
			{
				again=true;
				while(again)//allows the user to repeat action without having to go back to the menu
				{
					System.out.println("\nEnter the student ID number you would like to add: ");
					int studentID= input.nextInt();

					if(!(students.studentInStudentDirectory(studentID)))//checks if the student is in the arraylist of students
					{
						Student user= students.getFoundstudent();
						System.out.println("\nPlease enter the course number you would like to add the student to.");
						int courseID= input.nextInt();

						if(!(courses.courseInCourseList(courseID)))//checks if the course is in the courselist
						{
							if(courses.getFoundCourse().addStudentAdmin(user))//checks to see if the student is already registered for the desired course
							{
								user.addCourse(courses.getFoundCourse());
								System.out.println("\nYou have added student " +studentID+ " to course "+ courseID);
							}
							else
								System.out.println("\nThis student is already registered for this class.");
						}
						else
							error1();
					}
					else
						error2();
					yesOrNoMessage("\nWould you like to add another student to another class? Enter yes or no.");
				}
			}

			if(key.equalsIgnoreCase("drop"))
			{
				again=true;
				while(again)//allows the user to repeat action without having to go back to the menu
				{
					System.out.println("\nEnter the student ID number you would like to remove: ");
					int studentID= input.nextInt();
					if(!(students.studentInStudentDirectory(studentID)))//checks if the student is in the student directory
					{
						Student user= students.getFoundstudent();
						System.out.println("\nPlease enter the course number you would like to remove the student from.");
						int courseID= input.nextInt();
						if(!(courses.courseInCourseList(courseID)))//checks to see if course is in courselist, I did this so that the user can know what the exact problem is
						{
							if(!(user.findCourseInSchedule(courseID)))// checks to see if the student is registered for the course
							{
								user.getDroppedCourse().dropStudent(user);
								user.dropCourse();
								System.out.println("\nYou have dropped student " +studentID+ " from course "+ courseID);
							}
							else
								System.out.println("\nSorry,the student is not registered for this course.");
						}
						else
							error1();
					}
					else
						error2();
					yesOrNoMessage("\nWould you like to drop another student from another class? Enter yes or no.");
				}

			}

			if (key.equalsIgnoreCase("size"))
			{
				again=true;
				while(again)//allows the user to repeat action without having to go back to the menu
				{
					System.out.println("\nEnter the course number of the course you would like to change the size of: ");
					int courseID= input.nextInt();

					if(!(courses.courseInCourseList(courseID)))//checks to see if course is in courselist
					{
						System.out.println("\nEnter the new size of the course: ");
						courses.getFoundCourse().adminChangeCourseSize(input.nextInt());
						System.out.println("\nCourse " + courseID+ " now has a capacity of: " +courses.getFoundCourse().getCourseSize());
					}
					else
						error1();	
					yesOrNoMessage("\nWould you like to change another course's size? Enter yes or no");
				}
			}

			if (key.equalsIgnoreCase("exit"))//allows the user to get out of the Administrator interface by making operate false
			{
				System.out.println("\nGoodbye.\n");
				operate=false;	
			}
		}
	}
	/**
	 * A method that just prints out a common message
	 */
	public void error1()// I wanted to clean up my code a bit, and so I decided to just make this a method
	{
		System.out.println("\nSorry this course doesn't exist.");
	}
	/**
	 * A method that just prints out a common message
	 */
	public void error2()// same reasoning as above
	{
		System.out.println("\nSorry this student is not in the directory.");
	}
	
	/**
	 * A method which asks the user whether they want to repeat an action, it also the user to make a mistake in typing without the program shutting down.
	 * @param yesOrNoString the message that is asked to the user
	 */
	public void yesOrNoMessage(String yesOrNoString)// the point of this was to clean up my code and make the code more user friendly, so that the code wouldn't shut down
	{
		boolean yesOrNo=true;
		System.out.println(yesOrNoString);
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
				System.out.println("\nSorry I couldn't read that." + yesOrNoString);// makes sure the user types in yes or no
		}
	}
}



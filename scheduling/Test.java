//***************
//Test.java
//Test Class for Scheduling program
//Rahul Khanna
//***************

import java.io.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		try 		//processing the information from the user, builds a schedule and then prints out the schedule
		{
			File inFile= new File(args[0]);
			Builder scheduleBuilder = new Builder(inFile);
			scheduleBuilder.Schedule();
			System.out.println(scheduleBuilder);
			System.out.println("Thank You");
		}
		
		catch(IOException e)  // tells the user that files inputed are not valid
		{
			System.out.println("Please try again with correct input file name. Try again.");
		}
		
		catch(ArrayIndexOutOfBoundsException e) //tell the user that he hasn't given enough information
		{
			System.out.println("You must give me at least one file, and NO MORE than one file with classes. Try again.");
		}
		
		catch(NumberFormatException e) // tells the user that the file is not properly formatted
		{
			System.out.println("Your file doesn't have formating. Each entry should look similar to this: " +
					"\n\nJava \n10:00 \n12:00 \n\nWith ONE space between each entry. Try again.");
		}
	}

}

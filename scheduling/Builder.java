//***************
//Builder.java
//Builder Class for Scheduling program
//Rahul Khanna
//***************
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Builder { //creating my IVs

	private ArrayList<Lecture> lectures;
	private ArrayList<Lecture> schedule;
	private final int smallestHour = 0;
	private final int greatestHour = 24;
	private final int smallestMinute= 0;
	private final int greatestMinute=59;
	private final int openingTime = 800;
	private final int closingTime = 1700;

	public Builder(File listOfLectures) throws FileNotFoundException, NumberFormatException{
		//takes in the input file and breaks it down into each entry, while making sure the file is properly formatted. adds each entry into an array
		Scanner input= new Scanner(listOfLectures);
		lectures = new ArrayList<Lecture> ();
		schedule = new ArrayList<Lecture>();

		while(input.hasNextLine())
		{
			String name= input.nextLine();
			String startTime= input.nextLine();
			String endTime=input.nextLine();

			if(startTime.length()!=5 || endTime.length()!=5)
				throw new NumberFormatException();

			startTime= startTime.substring(0,2) + startTime.substring(3,5);
			endTime=endTime.substring(0, 2) + endTime.substring(3,5);

			int hoursStartTime=Integer.parseInt(startTime.substring(0,2));
			int hoursEndTime=Integer.parseInt(endTime.substring(0,2));
			if(hoursStartTime < smallestHour || hoursStartTime > greatestHour 
					|| hoursEndTime< smallestHour || hoursEndTime> greatestHour)
				throw new NumberFormatException();

			int minutesStartTime= Integer.parseInt(startTime.substring(2,4));
			int minutesEndTime=Integer.parseInt(endTime.substring(2,4));
			if (minutesStartTime< smallestMinute|| minutesStartTime >greatestMinute 
					|| minutesEndTime< smallestMinute || minutesEndTime> greatestMinute)
				throw new NumberFormatException();

			Lecture newLecture= new Lecture(name, startTime, endTime);
			lectures.add(newLecture);
			if(input.hasNextLine())
				input.nextLine();
		}
	}
	public void Schedule() throws NumberFormatException {
		// creates the actual schedule, by looking at end times and making sure that all times work within the room constraints
		Collections.sort(lectures);
		int currentEndTime=openingTime;
		for(Lecture lecture: lectures)
		{
			if(lecture.getStartTime() > openingTime || lecture.getStartTime() < closingTime 
					|| lecture.getEndTime() > openingTime || lecture.getEndTime() <closingTime)
			{
				if(lecture.getEndTime()<= closingTime && lecture.getStartTime()>= currentEndTime)
				{
					schedule.add(lecture);
					currentEndTime=lecture.getEndTime();
				}
			}	
		}
	}
	public String toString(){
		//creates a string of the schedule so that the user can view the schedule 
		String actSchedule = "This is the optimal schedule for the room : \n\n";
		for(Lecture lecture : schedule)
		{
			actSchedule += lecture.toString() + "\n\n";
		}
		return actSchedule;
	}
}


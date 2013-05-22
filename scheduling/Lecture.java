//***************
//Lecture.java
//Lecture Class for Scheduling program
//Rahul Khanna
//***************

public class Lecture implements Comparable <Lecture> { //creating my IVs and allowing me to compare lectures by a criteria

	private int startTime;
	private int endTime;
	private String name;
	private String formatedStartTime;
	private String formatedEndTime;
	
	public Lecture(String inputName, String inputStartTime, String inputEndTime) //creating the object Lecture
	{
		name=inputName;
		startTime= Integer.parseInt(inputStartTime) ;
		endTime= Integer.parseInt(inputEndTime);
		formatedStartTime=inputStartTime;
		formatedEndTime= inputEndTime;
	}
	
	public int getEndTime() //the next three methods allow other classes to access aspects of the Lecture
	{
		return endTime;
	}
	
	public int getStartTime()
	{
		return startTime;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void formatTimes() //needed to reformat the times so that the colon would come back
	{
		formatedStartTime= formatedStartTime.substring(0,2) + ":" + formatedStartTime.substring(2);
		formatedEndTime= formatedEndTime.substring(0,2) + ":" + formatedEndTime.substring(2);
	}
	
	public String toString() //put the entries back together in their original format
	{
		formatTimes();
		return name + "\n" + formatedStartTime  + "\n" + formatedEndTime;
	}
	
	public int compareTo(Lecture input)  // established how lectures would be compared, by end times.
	{
		if(endTime>input.getEndTime())
			return 1;
		else if(endTime<input.getEndTime())
			return -1;
		return 0;
	}
	
}

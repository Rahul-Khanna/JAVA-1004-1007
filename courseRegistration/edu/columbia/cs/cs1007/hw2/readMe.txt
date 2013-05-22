Rahul Khanna
rk2658

How to run and compile the code:
Compile all the java files in the base directory using package protocols.
In the command line first put the file containing the students and then the file containing the courses. The files should be in the format as designated by the assignment.

CourseRegistrationTester:
This is just a tester class for my program. It takes in two files, creates the student directory from the first and the course list from the second and then creates an instance of the RegistrationUnit Class, which then lets the program start.

Student:
This class is made so that I can create Student objects which can use the course registration system. Each student has a student ID and a password. Each student also has an ArrayList of courses, which acts as his/her schedule. 

StudentDirectory:
This class is made to store all the students from the text file. It constructs an ArrayList of type student and scans through the file and adds students to the ArrayList.

Course:
This class is made so that I can create Course objects which are the foci of the course registration system. Each course has a course ID and a size. Each course also has an ArrayList of students, which acts as its roll book.

CourseList:
This class is made to store all the courses from the text file. It constructs an ArrayList of type course and scans through the file and adds students to the ArrayList.

Admin:
The hard-coded admin user, which has an ID number and a password. The object of this class is used to access the object of the AdminRegistration class.

RegistrationUnit:
The "telephone" class. It connects the user to either the StudentRegistration class or the AdminRegistration class depending on what type of user logged into the system. This class keeps the program running, allowing multiple users to log in and out of the system.

AdminRegistration:
The interface for the admin user. The class allows the admin to perform the various functions the admin is allowed to do.

StudentRegistration:
The interface for the student user. The class allows the student to perform the various functions the student is allowed to do.

Summery of How the Program Works:

When designing this code what I had in mind was to make it as user friendly as possible, not let the program quit and still keep the coding to a minimum. I tried to make it as real as possible. The way the program works is that at first the CourseRegistrationTester, takes into the the two files from the command line and  creates the student directory, StudentDirectory from the first and the course list,CourseList, from the second and then creates an instance of the RegistrationUnit Class, which then lets the program start. The user is greeted by the main menu, which is supplied by the RegistrationUnit, asking the user whether he/she is an admin or a student, or if the user would like to shutdown the program. After the user indicates whether he/she is an admin,Admin object, or student, Student object, the interface asks for username and password and makes sure that the two lineup. In the case of a student, the program must go through the directory of students that the program has already generated from the first file. Going down the student path, once the student has logged in, he/she is greeted with another menu, supplied by StudentRegistration that gives the student his/her options of what he/she can do. A student can either add a course, Course object, if he/she is not already registered for it or if the course is not full. He/she can also drop a course if he/she is registered for it, view his/her courses, if he/she is enrolled in any, or quit. With the add and drop options a student can keep adding/dropping classes without having to go back to the options menu. Also the program always checks to see if the desired course is in the course list, which is created from the file. If there is any fault by the student, the program will tell the student the exact problem. Also if the student mistypes yes or no when the program asks whether he/she would like to continue with an option, the program will prompt the user to retype his/her answer. This yes/no aspect is true throughout the program. When the student quits, the program goes back to the main menu, ready to be used by the next person. Now going down the admin path, after the admin uses the hard coded admin ID and password, the admin is greeted by a different menu, supplied by AdminRegistration. The admin can view students in a course if the course has students, add a student to a course as long as the student is not already in it, drop a student from a course as long as the student is registered for it, change the size of the course or quit. When adding or dropping students from a course, the program makes sure the student and the course exists. When viewing a course or changing the size of a course the program checks to see if the course exists. When the admin quits, the main menu reappears and the program is ready to be used by the next user. The only way that the program is terminated, assuming a semi-friendly user, is if at the main menu, the user types quit and then the program ends. The only real error that can occur is if the user inputs a non integer value when asked for a course ID, student ID, admin ID or the new size of a course, as these are supposed to be integers. Hopefully all other errors are handled/ don't cause the program to quit. 




Rahul Khanna
rk2658

How to run and compile the code:
Compile all the java files in the base directory using package protocols.
Run the CarGameTester.java file
For some reason the game works better the second time you play it.

MoveableShape:
An interface which allows the CarShape to move around the screen.

CarShape:
The class that actually draws out the car and has the translate method. It implements MoveableShape. It also returns key features about the CarShape, such as its coordinates.

CarComponent:
This class is an extension of JComponent and basically is a component where the the two CareShape objects are placed on. It can calculate how far the cars are and has an ActionListner which sends out the "BOOM" message and the asks the user whether he/she would like to repeat. This class also contains the key booleans collide and exit which allow the program to repeat or exit.

Game:
This class is the main class of the program. It constructs the GUI game board and then allows the user to play the game. It also includes the instructions on how the computer's car should move. I tried to make the game slightly changeling so I made the computer's car bounce of the wall so that it could somewhat avoid cornering. This class also is responsible for having the buttons to control the human's car and make the human's car move according to what the user wants. It also restarts the game or exits the program depending on the user's choice. For some reason I couldn't stop the timer of the computer's car so that it would stop moving. Apart from that I am happy with this class.

CarGameTester:
Just a tester class for the program which constructs a new game and then calls on the play method for the game.

Summery of How the Program Works:
Basically the Tester class creates a game and then calls the play method. The play method calls the constructBoard method which creates the GUI for the user to play on. The play method then starts moving the computer's car around depending on where the user's car is and the user must move his car, using the buttons on the bottom, and bang into the computer's car.( I tried to estimate the number of pixels away the cars had to be for the cars to actually be on top of each other, since the rectangles the cars were in are  actually bigger than the cars.) When that happens the message "BOOM" appears and then the user is asked if he/she would like to play again, if the answer is yes, the play method calls the restartGame method which resets the game and starts the whole play method over again. If the answer is no or cancel then the game ends and the program quits.

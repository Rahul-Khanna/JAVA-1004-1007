Rahul Khanna
rk2658

How to run and compile the code:
javac edu/columbia/cs/cs1007/hw4/problem2/*.java
java edu/columbia/cs/cs1007/hw4/problem2/SceneEditor

StopSign:
The design of the stop sign shape. It also includes the STOP text.

The rest of the classes were adapted from Object-Oriented Design and Patterns by Cay Horstman, but here are brief summaries of them.

CarShape:
The design of the car shape.

HouseShape:
The design of the house shape.

SceneShape:
An interface class that holds the methods for SelectableShape.

SelectableShape:
An abstract class that defines methods for CompoundShape.

CompoundShape:
An abstract class the defines methods for CarShape, HouseShape, StopSign.

SceneComponent:
The component where all the shapes are placed into.

SceneEditor:
The class the builds the GUI and has the buttons to make the program work.


Summery:
The same as what is in the textbook, but I added a Stop Sign  that can be added and removed to the screen.  Also the placement of the stop sign is done by finding the corner with least amount of objects and placing it there. 

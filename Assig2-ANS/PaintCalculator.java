/* Code for COMP 102 Assignment 2 2011
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;

/** Program for calculating amount of paint required
   to paint a room*/

public class PaintCalculator{

    static final double doorHeight = 2.1;  // Height of the doors
    static final double doorWidth = 0.8;   // Width of the doors
    static final double SqMetersPerLitre = 15;   // Area covered by 1 litres of paint

    /** Calculates and prints litres of paint needed to paint a room
	with four walls (excluding the doors, floor, and ceiling)
     */
    public void calculatePaintCore(){
    // YOUR CODE HERE
	UI.printf("Paint Calculator Core\n");
	UI.printf("Please enter the following in meters\n\n");
	double length = UI.askDouble("Length of room: ");
        double width = UI.askDouble("Width of room: ");
        double height = UI.askDouble("Height of room: ");
	double numDoors = UI.askDouble("Number of doors in the room: ");

        double doorsArea = doorHeight * doorWidth * numDoors;
	double roomArea = 2 * height * (width + length) - doorsArea;
	double paintRoom = roomArea / SqMetersPerLitre;

	UI.printf("You will need " + paintRoom + " litres of paint for the room\n\n");
    }

    /** Calculates and prints litres of paint needed to paint a room with four walls
	(excluding the doors and windows), and windows and ceiling separately.
     */
    public void calculatePaintCompletion(){

	UI.printf("---------------------------------\n");
	UI.printf("Paint Calculator Completion\n");
	UI.printf("Please enter the following in meters\n\n");
	double length = UI.askDouble("Length of room: ");
        double width = UI.askDouble("Width of room: ");
        double height = UI.askDouble("Height of room: ");

	double numDoors = UI.askDouble("Number of doors in the room: ");
        double doorsArea = doorWidth * doorHeight * numDoors;

	double heightW = UI.askDouble("Height of window: ");
	double widthW = UI.askDouble("Width of window: ");
	double numWindows = UI.askDouble("Number of windows in the room: ");
	double windowsArea = heightW * widthW * numWindows;

	double roomArea = 2 * height * (width + length) - doorsArea - windowsArea;
	double paintRoom = roomArea / SqMetersPerLitre;
	UI.printf("You will need " + paintRoom + " litres of paint for the walls\n\n");
 
	double paintCeiling = (length*width)/15;
	UI.printf("You will need " + paintCeiling + " litres of paint for the ceiling\n\n");

   // END OF YOUR CODE
    }



}


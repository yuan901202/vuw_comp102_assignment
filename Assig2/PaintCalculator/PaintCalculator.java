/* Code for COMP 102 Assignment 2 2011
 * Name: Tianfu Yuan
 * Usercode: yuantian
 * ID: 300228072
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
        UI.println("Paint Calculator Core");
        UI.println("Please enter the following in meters");
        UI.println(" ");
        double roomLength = UI.askDouble("Length of room: ");
        double roomWidth = UI.askDouble("Width of room: ");
        double roomHeight = UI.askDouble("Height of room: ");
        double doorNum = UI.askDouble("Number of doors in the room: ");
        double wallArea = 2*(roomLength*roomHeight + roomWidth*roomHeight);
        double doorArea = doorHeight*doorWidth*doorNum;
        double paintArea = wallArea - doorArea;
        UI.println("You will need " + paintArea / SqMetersPerLitre + " litres of paint for the room");
    }

    public void calculatePaintCompletion(){
        UI.println("Paint Calculator Completion");
        UI.println("Please enter the following in meters");
        UI.println(" ");
        double roomLength = UI.askDouble("Length of room: ");
        double roomWidth = UI.askDouble("Width of room: ");
        double roomHeight = UI.askDouble("Height of room: ");
        double doorNum = UI.askDouble("Number of doors in the room: ");
        double windowHeight = UI.askDouble("Height of window: ");
        double windowWidth = UI.askDouble("Width of window: ");
        double windowNum = UI.askDouble("Number of windows in the room: ");
        double wallArea = 2 * (roomLength * roomHeight + roomWidth * roomHeight);
        double doorArea = doorHeight*doorWidth*doorNum;
        double windowArea = windowHeight * windowWidth * windowNum;
        double wallPaint = wallArea - doorArea - windowArea;
        double ceilingArea = roomLength * roomWidth;
        UI.println("You will need " + wallPaint / SqMetersPerLitre + " litres of paint for the walls");
        UI.println(" ");
        UI.println("You will need " + ceilingArea / SqMetersPerLitre + " litres of paint for the ceiling");
        
    }

    public void calculatePaintChallenge(){
        UI.println("Paint Calculator Challenge");
        UI.println("Please enter the following in meters with numbers of windows");
        UI.println("For example: 2@340*1250 ");
        UI.println("Format: numbers of windows @ Height of window * Width of window");
        double windowArea = UI.askDouble("How many windows you have? ");
        
        
    }
}


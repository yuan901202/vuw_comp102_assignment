/* Code for COMP102 Assignment
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.awt.Color;
import java.util.*;
import java.io.*;


/** Exercise
    The program lets the user draw circles and move them around.
    The program has fields to store
     - an array of Circle objects
     - whether it is currently drawing new circles or moving them around
     - the index of the Circle the mouse was last pressed on.
    If the program is drawing new circles, then releasing the mouse
     on the graphics pane will create a new circle at that point and add
     it to the collection.
    If the program is moving circles around, then if the mouse was pressed on
     top of a circle, it will then be moved to the position the mouse is released.
 */

public class Exercise implements UIButtonListener, UIMouseListener{
    // Fields
    
    private Circle[] circles = new Circle[100];   // the collection of circles
    private int circleCount = 0;

    private String currentAction = "Circle";  // what the program should do next
    private int currentCircleIndex = -1;         // index of the Circle the mouse was pressed on
                                            // -1 if it wasn't pressed on any Circle

    /** Construct a new Exercise object and set up the GUI
	 - set the mouselistener
	 - make two buttons - "Draw" and "Move"
     */
    public Exercise(){
	// YOUR CODE HERE
	UI.setMouseListener(this);
	UI.addButton("Circle", this);
	UI.addButton("Move", this);
	// END OF YOUR CODE
    }

    /** Respond to button presses */
    public void buttonPerformed(String button){
	this.currentAction = button;   // either "Circle" or "Move"
    }

    /** Respond to mouse events
     *  if "pressed", find and record the index of the circle it was pressed on (if any)
     *    in the currentCircleIndex field, using the findCircleIndex method
     *	if "released", then depends on whether the program is drawing or moving
     *	  if drawing, and there is room in the array, then create a new Circle.
     *	  if moving, and the currentCircleIndex is not -1, then move that Circle to a new place.
     *      (by calling the setPos(..) method on the circle)
     *  After each "released" action, redraw the collection of shapes.
    */
    public void mousePerformed(String action, double x, double y) {
	if (action.equals("pressed")){
	    this.currentCircleIndex = this.findCircleIndex(x, y);
	}
	if (action.equals("released")){
	    // YOUR CODE HERE
	    if (this.currentAction.equals("Circle") && this.circleCount<100){
		Circle c = new Circle(x, y);
		this.circles[this.circleCount++] = c;
	    }
	    else if (this.currentAction.equals("Move") && this.currentCircleIndex>-1){
		this.circles[this.currentCircleIndex].setPos(x, y);
		
	    }
	    // END OF YOUR CODE

	    this.redrawCircles();
	}
    }

    /** Clear the graphics pane,
	redraw all the circles, (callng the redraw method on each circle)
	repaint the graphics pane.
     */
    public void redrawCircles(){
	// YOUR CODE HERE
	UI.clearGraphics(false);
	for (int i=0; i<this.circleCount; i++){
	    this.circles[i].redraw();
	}
	UI.repaintGraphics();
	// END OF YOUR CODE
    }


    /** Search through the circles array for a Circle that the point x,y is on
     *   by calling the on(..) method on each circle 
     * If there is such a Circle, return the index.
     * if there is no such circle, return -1.
    */
    public int findCircleIndex(double x, double y){
	// YOUR CODE HERE
	for (int i=this.circleCount-1; i>=0; i--){
	    if (this.circles[i].on(x, y)){
		return i;
	    }
	}
	return -1;
	// END OF YOUR CODE
    }


    // Main
    public static void main(String[] arguments){
	new Exercise();
    }	


}

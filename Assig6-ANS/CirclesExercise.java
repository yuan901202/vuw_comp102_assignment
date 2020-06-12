/* Exercise for Assignment 6
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.awt.Color;


/** The Circles program is a very simple program that lets the user place small 
    and large circles on the graphics pane using the mouse.
    It has three buttons: Small, Large, and Clear.
    The "Small" button should change the "current size" to 10, and the "Large" button
    should change the current size to 30. The current size should be stored in a field.
    The Clear button should clear the graphis pane.
    When the user releases the mouse at any point on the canvas, the program
    should draw a blue circle at that point.
    Note that the Circles class must implement both the UIButtonListener interface
    and the UIMouseListener interface, and must also have the
    buttonPerformed method and the mousePerformed method defined.
*/ 

public class CirclesExercise implements UIButtonListener, UIMouseListener{

    //field to record the current size of the circles (10 or 30)
    //initial size should be 10
    // YOUR CODE HERE
    private int size = 10;
    // END OF YOUR CODE

    
    // Constructor
    /** Construct a new Circles object  and set up the GUI:
        - set the mouse listener
	- add three buttons
	In all cases, the listener will be 'this' object (the one that is being constructed)
    */
    public CirclesExercise(){
	// YOUR CODE HERE
	UI.setMouseListener(this);
	UI.addButton("Large", this);
	UI.addButton("Small", this);
	UI.addButton("Clear", this);
	// END OF YOUR CODE
    }


    /** Respond to button presses
        the Large button should set the current size to 30
	the Small button should set the current size to 10
	the Clear button should clear the canvas.
	Note that Large and Small do not draw anything!!
    */
    public void buttonPerformed(String button){
	// YOUR CODE HERE
	if (button.equals("Large") ){this.size = 30;}
	else if (button.equals("Small") ){this.size = 10;}
	else if (button.equals("Clear") ){UI.clearGraphics();}
	// END OF YOUR CODE
    }

    /** Respond to mouse events.
	This program only does something on a released event - it draws a
	circle of the current size centered at the position the mouse was released
        */
    public void mousePerformed(String action, double x, double y) {
	if (action.equals("released")){
	// YOUR CODE HERE
	    UI.setColor(Color.blue);
	    UI.fillOval(x-this.size/2, y-this.size/2, this.size, this.size);
	}
	// END OF YOUR CODE
    }

    // Main: call the constructor, which will set up the interface
    public static void main(String[] arguments){
	new CirclesExercise();
	UI.println("Click the mouse in the graphics pane");
    }	

}

/* Code for COMP102 Assignment 6
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.awt.Color;
import javax.swing.JColorChooser;


/** Lets the user draw "stars" - lots of lines from a center point.
 * After clicking the "Set Center" button, the user can set (or reset)
 *  the center of a new star using the mouse.
 *  (Note, nothing happens directly in response to the button -
 *   the program just remembers that the user is about to change the center point.)
 * After clicking the "Set Tips" button, the user can click anywhere to
 *  add a new tip to the star:
 *  the program will draw a line from the current center to the new point.
 *  (Note, nothing happens directly in response to the button - the program just
 *   remembers that the user is about to set the positions of tips of the star.)
 * Note that neither of the buttons will draw anything directly - they
 *  just record whether user is about to choose the center or a tip.
 * The user can click the "Clear" button to clear the graphics pane or
 *  click the "Set Color" button to change the color
 *  (using the JColorChooser.showDialog(...) method).
 */
public class StarExercise implements UIButtonListener, UIMouseListener{

    //three fields to record current state:
    //  position of current center, and
    //  whether the user is currently choosing the center or a point
    // YOUR CODE HERE
    private double centerX = 0;
    private double centerY = 0;
    private boolean choosingCenter = true;
    // END OF YOUR CODE

    /** Set up the user interface: set mouse listener and four buttons*/
    public StarExercise(){
	// YOUR CODE HERE
	UI.setMouseListener(this);
	UI.addButton("Clear", this);
	UI.addButton("Set Color", this);
	UI.addButton("Set Center", this);
	UI.addButton("Set Tips", this);
	// END OF YOUR CODE
    }
	
    /** Respond to buttons.
     *  "Set Color" and "Clear" cause an immediate action (changing the color of the UI or
     *  clearing the pane).
     *  "Set Center" and "Set Tips" do not draw anything. They only record what state
     *  the user is now in - choosing a center point or not.
     */
    public void buttonPerformed(String button){
	if (button.equals("Set Color")){
	    UI.setColor(JColorChooser.showDialog(null, "Choose Color", null));
	}
	// YOUR CODE HERE
	else if (button.equals("Clear")){
	    UI.clearGraphics();
	}
	else if (button.equals("Set Center")){
	    this.choosingCenter = true;
	}
	else if (button.equals("Set Tips")){
	    this.choosingCenter = false;
	}
	// END OF YOUR CODE
    }

    /** Respond to mouse released events.
	If currently choosing a center, then remember the position and draw a small
	circle at the point.
	Othewise, draw a line from the current center to this point
    */
    public void mousePerformed(String action, double x, double y){
	if (action.equals("released")){
	// YOUR CODE HERE
	    if (this.choosingCenter){
		this.centerX = x;
		this.centerY = y;
		UI.fillOval(x-2, y-2, 4, 4);
	    }
	    else{
		UI.drawLine(centerX, centerY, x, y);
	    }
	}
	// END OF YOUR CODE
    }


    public static void main(String[] args){
        StarExercise obj = new StarExercise();
    }	

}

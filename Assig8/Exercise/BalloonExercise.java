/* Code for COMP102 Assignment 8
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.awt.Color;
import java.util.*;
import java.io.*;


/** Creates two Balloon objects at positions (200,200)  and (400,250), and
    stores them in an array (of size 2).
    Whenever the user clicks on (releases the mouse in) a balloon, then
       it expands that balloon.
       and checks if the balloons are now touching,
       if so, then
          it pops both balloons and
	  reports the total area of the two balloons (in the text pane).
	  and (after a pause) restarts the game.
*/

public class BalloonExercise implements UIMouseListener{

    Balloon[] balloons = new Balloon[2];

    /** Construct a new BalloonExercise object:
     *	make the BalloonExercise object listen to the mouse
     *  and restart the game.  */
    public BalloonExercise(){
	// YOUR CODE HERE
    }

    /** Clear graphics pane, create two new Balloons in the balloons array,
     and draw them.*/
    public void restart(){
	// YOUR CODE HERE
    }

	
    /** If the user releases the mouse in a balloon, make it expand, then check if touching.
     If it is touching the other balloon, then pop them both, report the total
    area of the two balloons, then (after a pause) restart the game.
    This can be inside the mousePerformed method, or it could call another method.*/
    public void mousePerformed(String action, double x, double y){
	if (action.equals("released")){
	    // YOUR CODE HERE
	}
    }



}

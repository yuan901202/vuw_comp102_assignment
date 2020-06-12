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
	UI.setMouseListener(this);
	this.restart();
	// END OF YOUR CODE
    }

    /** Clear graphics pane, create two new Balloons in the balloons array,
     and draw them.*/
    public void restart(){
	// YOUR CODE HERE
	UI.clearGraphics();
	balloons[0] = new Balloon(200, 200);
	balloons[0].draw();
	balloons[1] = new Balloon(400, 250);
	balloons[1].draw();
	// END OF YOUR CODE
    }

	
    /** If the user releases the mouse in a balloon, make it expand, then check if touching.
     If it is touching the other balloon, then pop them both, report the total
    area of the two balloons, then (after a pause) restart the game.
    This can be inside the mousePerformed method, or it could call another method.*/
    public void mousePerformed(String action, double x, double y){
	if (action.equals("released")){
	    // YOUR CODE HERE
	    for (int i = 0; i<2; i++){
		if (balloons[i].on(x, y)){
		    balloons[i].expand();
		    break;
		}
	    }
	    if (balloons[0].touches(balloons[1])){
		balloons[0].pop();
		balloons[1].pop();
		UI.printf("Total Size = %2.0f\n", balloons[0].size()+balloons[1].size());
		UI.sleep(1000);
		restart();
	    }
	    // END OF YOUR CODE
	}
    }



}

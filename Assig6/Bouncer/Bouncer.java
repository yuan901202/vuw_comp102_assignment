/* Code for COMP102 Assignment 6
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.awt.Color;


/** Runs a simulation of balls bouncing.
    Sets up a window with a DrawingCanvas
    Then repeatedly
      creates a new BouncingBall object,
      specifying its initial height, x position, and speed to the right
      repeatedly makes the ball move until it has got to the edge of the window
      then erases the ball and starts the outer loop again.
    For the Completion version, it keeps two BouncingBalls going all the time.
 */

public class Bouncer{


    public void bounceTwoBalls(){
	
	UI.drawLine(0,451,600,451);    // the ground
	
	BouncingBall ballA = this.makeNewBall();
	BouncingBall ballB = this.makeNewBall();
	ballA.draw();
	ballB.draw();
	UI.repaintGraphics();

	while (true){
	    UI.clearGraphics(false);            // clear the graphics pane
	    UI.setColor(Color.black);
	    UI.drawLine(0,451,600,451, false);  // draw the ground

	    ballA.move();
	    ballB.move();
	    if (ballA.getX() > 600) {      // if at right edge, make new one
		ballA = this.makeNewBall();
	    }
	    if (ballB.getX() > 600) {      // if at right edge, make new one
		ballB = this.makeNewBall();
	    }

	    // redraw the balls in their new position and pause
	    ballA.draw();
	    ballB.draw();
	    UI.repaintGraphics();
	    UI.sleep(40); // pause of 40 milliseconds
	}
    }

    /** Helper method that makes a new BouncingBall with random initial values */
    public BouncingBall makeNewBall(){
	double initHeight = 100 + Math.random()*300; // random height between 100 and 400.
	double xSpeed = 1.0 + Math.random()*4;       // random step size between 1 and 4.
	return new BouncingBall(0, initHeight, xSpeed);
    }	


// Main
	/** Create a new Bouncer object and call bounceAround */
	public static void main(String[] arguments){
	    Bouncer bouncer = new Bouncer();
	    bouncer.bounceTwoBalls();
	}	

}

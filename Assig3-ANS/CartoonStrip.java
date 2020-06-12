/* Code for COMP 102 Assignment 3 2012
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;

/** Program to create simple animated cartoon strips using the
 *  CartoonFigure class.  
 */

public class CartoonStrip{

    /** animate creates two cartoon figures and places them on the window.
     *  Then animates them according to a fixed script by calling a series
     *  of methods on the figures.
     */
    public void animate(){
	// YOUR CODE HERE
	CartoonFigure face1 = new CartoonFigure("yellow", 150, 100);

	face1.turnRight();
	face1.turnLeft();
	face1.frown();
	face1.talk("Is anyone here?");

	CartoonFigure face2 = new CartoonFigure("blue", 450, 100);
	face2.smile();
	face2.turnLeft();
	face2.talk("Hello");
	face1.turnRight();
	face1.smile();
	face1.talk("Hi there, I'm Jim");
	face2.talk("I'm Jan");
	face2.move(50);
	face1.turnLeft();
	face1.frown();
	face1.turnRight();
	face1.talk("What's that thing?");
	face2.talk("Just my robot mower!");
	face1.talk("Don't let it mow me!");
	face1.turnLeft();
	face1.talk("I'm off");
	face1.move(80);
	face1.move(80);
	face1.move(80);
	face2.talk("Bye!");
	face1.turnRight();
	face2.talk("Come on Robby");
	face2.move(50);
	face2.move(50);
	face2.move(50);
	face2.move(50);
	face2.move(50);
	face2.move(50);
	face2.move(50);
	// END OF YOUR CODE
    }

    /** dance creates a cartoon figure and places it on the window.
     *  Then makes the figure dance by calling two different dance step methods
     *  several times. 
     */
    public void dance(){
	// YOUR CODE HERE
	CartoonFigure face = new CartoonFigure("rico", 300,100);
	face.frown();
	this.leftDance(face);
	this.rightDance(face);
	this.leftDance(face);
	this.rightDance(face);
	face.talk("Once again now,");
	this.rightDance(face);
	this.leftDance(face);
    }
    
    /** makes the figure smile, then turn left and move two steps, 
     *  then turn right and move two steps to return to original position
     */
    public void leftDance(CartoonFigure face){
	face.turnLeft();
	face.talk("you like to move it");
	face.move(30);
	face.talk("move it");
	face.move(30);
	face.turnRight();
	face.talk("I like to...");
	face.move(30);
	face.talk("MOVE it!");
	face.move(30);
    }

    /** makes the figure smile, then turn right and move two steps, 
     *  then turn right and move two steps to return to original position
     */
    public void rightDance(CartoonFigure face){
	face.turnRight();
	face.talk("you like move it");
	face.move(30);
	face.talk("move it");
	face.move(30);
	face.turnLeft();
	face.talk("I like to...");
	face.move(30);
	face.talk("MOVE it!");
	face.move(30);
	// END OF YOUR CODE
    }

    /* this method is here to make it easy to restart the UI window from bluej*/
    public void restartUI(){
        UI.initialise();
	UI.clearGraphics();
    }



}


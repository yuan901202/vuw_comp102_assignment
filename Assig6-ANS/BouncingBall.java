/* Code for COMP 102 Assignment 6
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.awt.Color;


/** BouncingBall represents a ball that falls towards the ground and bounces up again.
    Each time the move() method is called, it will take one step.  
    The ball must store its current position and the state, and the canvas it is drawn on.
    The state must include the current position, and its current speed
    (ie, the size of step in x and y directions that it will take in each move) 
    For the extension, it needs to store its colour, size, or whatever you choose to change each time.

    It has a method to make it move from its current position.
    For the extension, every time it moves, it will change its size,
    shape, or colour a little
 */

public class BouncingBall{
    // Fields to store
    //   the state of the ball:  x, y stepX, stepY
    //   other constants for the ball: colour, size, position of the ground
    // YOUR CODE HERE
    private double x;     // x position of the ball
    private double y;     // y position of the bottom of the ball
                          // (not the same as the height above the ground!!!)
    private double stepX;    //size of the horizontal step (positive to the right)
    private double stepY = 0;  // size of the vertical step (positive down)

    private int size = 30;
    private Color col;
    // END OF YOUR CODE
    static final int ground = 450;   // ground level.

    // Constructor
    /** Construct a new BouncingBall object.
	Parameters are the initial x position, the height above the ground, and the initial
	speed to the right (ie, the horizontal step size)
	Stores the parameters into fields (computing the y position from the height)
	and initialises the other fields,
    */
    public BouncingBall(double x, double h, double s){
	// YOUR CODE HERE
	this.x = x;
	this.y = ground - h;
	this.stepX = s;
	this.col = Color.getHSBColor((float)Math.random(),1,1);
	// END OF YOUR CODE
    }


    // Methods

    /** Move the shape one step.
	changes its height and x position using the vertical and horizonal steps
	If it would go below ground, then it "bounces":
	  sets its y position to ground level, and reverses the vertical step size.
	It then adds 0.3 to its vertical step size
        (because gravity is making its downward speed greater each step) */
    public void move(){
	// YOUR CODE HERE

	this.y = this.y + this.stepY;
	this.x = this.x + this.stepX;

	if (this.y > ground){
	    this.y = ground;
	    this.stepY = - (this.stepY * 0.9);
	}

	this.stepY = this.stepY + 0.3;

	// END OF YOUR CODE
    }

    /** Return the current x position of the ball */
    public double getX(){
	// YOUR CODE HERE
	return this.x;
	// END OF YOUR CODE
    }
    

    /** Draw the shape on the canvas in its current position.
    */
    public void draw(){
	// YOUR CODE HERE
	UI.setColor(this.col);
	UI.fillOval(this.x, this.y-this.size, this.size, this.size, false);
	//UI.setColor(Color.black);
	//UI.drawOval(this.x, y, this.size, this.size, false);
	// END OF YOUR CODE
    }


    /** A method to test your code.
        Can be called from BlueJ */
    public static void test(){
	BouncingBall ball = new BouncingBall(100, 150, 2);
	ball.draw();
	UI.repaintGraphics();
	UI.setColor(Color.black);
	UI.drawString("position = "+ ball.getX()+" / "+ball.y, 10, 20);
	UI.drawLine(0, ground, 600, ground);
	UI.askBoolean("Ball should be on the window\nposition should be 100/300\nNow move it?");
	
	for (int i=0; i<10; i++){
	    ball.move();
	    UI.clearGraphics();
	    ball.draw();
	    UI.drawLine(0, ground, 600, ground);
	    UI.repaintGraphics();
	    UI.sleep(50);
	}
	UI.setColor(Color.black);
	UI.drawString("position = "+ ball.getX()+" / "+ball.y, 10, 20);
	UI.askBoolean("Ball should have moved down and over\n\nposition should be as 120/313.5\n now make it bounce?");
	for (int i=0; i<60; i++){
	    ball.move();
	    UI.clearGraphics();
	    ball.draw();
	    UI.drawLine(0, ground, 600, ground);
	    UI.repaintGraphics();
	    UI.sleep(50);
	}
	UI.println("Ball should have bounced on the ground once and \nbe falling again");
    }

    public static void main(String[] args){
	test();
    }


}

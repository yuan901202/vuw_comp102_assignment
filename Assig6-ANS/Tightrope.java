/* Code for Assignment 6
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.awt.Color;


/** A Tightrope object represents an acrobat's tightrope strung between two poles.
    A Tightrope is drawn using two tall thin rectangles representing the two poles
    and a straight line between the poles.
    The poles go from the top of the pane (y = 0) to the ground (y=400).
      They should be 5 units wide.
      (Note, it is fine for this exercise to use thes constants (0, 5, 400) in your code,
       though good practice would define constants for them.)
    The tightrope can be raised, one end at a time.
    The Tightrope object needs to remember
      - the horizontal positions of the two poles (which don't change), and
      - the heights of each end of the "tightrope" line above the
        base (which do change)
    (Therefore, it needs at four fields, there are quite a lot of choices)
    The constructor requires two arguments:
       the horizontal position (mid point between the the two poles), and
       the width of the tightrope.
    Both ends of the tightrope are initially 20 units above the base
      of the poles.
    The constructor will draw the poles, and draw the tightrope in
      its initial position
    |           |
    |           |
    |-----------|
    |           |
    |    mid    |

    The class has two methods:
      raiseLeft(double d),  which changes the height of the left end by the distance d
      raiseRight(double d), which changes the height of the right end by the distance d
    Both methods
      - erase the line from its current position, [UI.eraseLine(....)]
      - change the height of one end,
      - redraw the line   [UI.drawLine(....)]
      They don't need to redraw the poles.
      Note, for this exercise, it doesn't matter if the tightrope goes off
      the top of the poles!
 */
public class Tightrope{

    //fields
    // YOUR CODE HERE
    private double left;         //the x position of the left end of the tightrope
    private double right;        //the x position of the right end of the tightrope
    private double leftHeight=20; //the height of the left end above the base
    private double rightHeight=20;//the height of the right end above the base
    // END OF YOUR CODE

    //Constructor: passed the horizontal middle of the tightrope and its width
    // YOUR CODE HERE
    public Tightrope(double midX, double width){
	this.left = midX-width/2;
	this.right = midX+width/2;
	UI.setColor(new Color(120, 80, 0));   // dark brown,
	UI.fillRect((this.left-6), 0, 5, 400);
	UI.fillRect(this.right+1, 0, 5, 400);
	UI.setColor(Color.black);
	UI.drawLine(this.left, (400-leftHeight), this.right, (400-rightHeight));
    }
    // END OF YOUR CODE

    // raiseLeft method: left left end of tightrope by the specified distance.
    // YOUR CODE HERE
    public void raiseLeft(double d){
	UI.eraseLine(this.left, (400-leftHeight), this.right, (400-rightHeight));
	this.leftHeight = this.leftHeight + d;
	UI.drawLine(this.left, (400-leftHeight), this.right, (400-rightHeight));
    }	
    // END OF YOUR CODE

    // raiseRight method: right right end of tightrope by the specified distance.
    // YOUR CODE HERE
    public void raiseRight(double d){
	UI.eraseLine(this.left, (400-leftHeight), this.right, (400-rightHeight));
	this.rightHeight = this.rightHeight + d;
	UI.drawLine(this.left, (400-leftHeight), this.right, (400-rightHeight));
    }	
    // END OF YOUR CODE


}

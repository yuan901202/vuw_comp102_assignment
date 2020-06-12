/* Code for Assignment 6
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.awt.Color;


/** A PartyBalloon object represents a small round balloon on the graphics pane.
    It remembers its current position and its color.
    Its initial position and its color are set when it is constructed
    The diameter of a balloon should be 30.
    It has two methods:
      riseLeft(),  which makes the balloon rise up by 20, and move 5 to the left
      riseRight(), which makes the balloon rise up by 20, and move 5 to the right
    Both methods
      - erase the balloon from its current position, [UI.eraseOval(....)]
      - change the position,
      - redraw the balloon   [UI.fillOval(....)]
 */
public class PartyBalloon{

    //fields
    // YOUR CODE HERE
    private Color color;
    private double xPos;
    private double yPos;
    private double size = 30;
    // END OF YOUR CODE

    //Constructor: passed the intial position and color.
    // YOUR CODE HERE
    public PartyBalloon(double x, double y, Color col){
	this.xPos = x;
	this.yPos = y;
	this.color = col;
	UI.setColor(col);
	UI.fillOval(this.xPos, this.yPos, this.size, this.size);
    }
    // END OF YOUR CODE

    // riseLeft method
    // YOUR CODE HERE
    public void riseLeft(){
	UI.eraseOval(this.xPos, this.yPos, this.size, this.size);
	this.xPos = this.xPos - 5;
	this.yPos = this.yPos - 20;
	UI.setColor(this.color);
	UI.fillOval(this.xPos, this.yPos, this.size, this.size);
    }	
    // END OF YOUR CODE

    // riseRight method
    // YOUR CODE HERE
    public void riseRight(){
	UI.eraseOval(this.xPos, this.yPos, this.size, this.size);
	this.xPos = this.xPos + 5;
	this.yPos = this.yPos - 20;
	UI.setColor(this.color);
	UI.fillOval(this.xPos, this.yPos, this.size, this.size);
    }	
    // END OF YOUR CODE


}

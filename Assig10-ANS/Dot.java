/* Code for COMP102 Assignment 10
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.io.*;
import java.util.*;
import java.awt.Color;

/** Dot represents a small circle shape of a fixed size (5 pixels).
 *  Implements the Shape interface.
 *  Needs fields to record the position, and colour.
 */

// YOUR CODE HERE
public class Dot implements Shape{
    // fields
    private double x;
    private double y;
    private Color col = Color.white;

    /** Constructor with explicit values
	Arguments are the x and y of the center,
	the width and height, and the color.
    */
    public Dot (double x, double y, Color col){
	this.x = x;
	this.y = y;
	this.col = col;
    }

    /** Constructor which reads values from a file (scanner)
	The argument is a Scanner that contains the specification of the dot.
	The next 2 numbers specify the position and the 3 following ints
	specify the color.
    */
    public Dot (Scanner data){
	this.x = data.nextDouble();
	this.y = data.nextDouble();
	int red = data.nextInt();
	int green = data.nextInt();
	int blue = data.nextInt();
	this.col = new Color(red, green, blue);
    }
    

    /** Returns true if the point (u, v) is on top of the shape */
    public boolean on(double u, double v){
	return (Math.hypot(u-this.x, v-this.y) < 3);
    }

    /** Changes the position of the shape by dx and dy.
	If it was positioned at (x, y), it will now be at (x+dx, y+dy)
    */
    public void moveBy(double dx, double dy){
	x += dx;
	y += dy;
    }

    /** Renders the dot. It draws a black border and
	fills it with the color of the dot.
	It uses the drawing methods with the extra last argument of "false"
	so that the shape will not actually appear until the 
	graphics pane is redisplayed later. This gives much smoother redrawing.
    */
    public void redraw(){
	UI.setColor(col);
	UI.fillOval(this.x-2, this.y-2, 5, 5, false);
    }

  /** The Dot cannot be resized, since the size is fixed.  */
    public void resize(double changeWd, double changeHt){
    }


    /** Returns a string description of the dot in a form suitable for
	writing to a file in order to reconstruct the dot later
    */
    public String toString(){
	return ("Dot "+this.x+" "+this.y+" "+ this.col.getRed()+" "+this.col.getGreen()+" "+this.col.getBlue());
    }


}
    // END OF YOUR CODE

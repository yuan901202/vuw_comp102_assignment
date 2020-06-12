/* Code for COMP102 Assignment 10
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.io.*;
import java.util.*;
import java.awt.Color;


/** Oval represents an oval shape
   Implements the Shape interface.
   Needs fields to record the position, size, and colour
 */

public class Oval 
  // YOUR CODE HERE
  implements Shape{
  
  // fields
  private double x;
  private double y;
  private double wd;
  private double ht;
  private Color col = Color.white;

  private double sqwd;   // square of the width and height,
  private double sqht;   //  precomputed for on calculation
  // END OF YOUR CODE

  /** Constructor with explicit values
   *      Arguments are the x and y of the top left corner,
   *  the width and height, and the color.  
   */
  public Oval (double x, double y, double wd, double ht, Color col){
    // YOUR CODE HERE
    this.x = x;
    this.y = y;
    this.wd = wd;
    this.ht = ht;
    this.col = col;

    this.sqwd = this.wd*this.wd;
    this.sqht = this.ht*this.ht;
    // END OF YOUR CODE
  }

  /** [Completion] Constructor which reads values from a file (scanner)
   *      The argument is a Scanner that contains the specification of the Oval.
   *  The next 7 integers specify the position, the size and three ints
   *  specifying the color.
   */
  public Oval (Scanner data){
    // YOUR CODE HERE
    this.x = data.nextDouble();
    this.y = data.nextDouble();
    this.wd = data.nextDouble();
    this.ht = data.nextDouble();
    int red = data.nextInt();
    int green = data.nextInt();
    int blue = data.nextInt();
    this.col = new Color(red, green, blue);
    this.sqwd = this.wd*this.wd;		// square of the width
    this.sqht = this.ht*this.ht;		// square of the height
    // END OF YOUR CODE
  }
    

  /** Returns true if the point (u, v) is on top of the shape */
  public boolean on(double u, double v){
    // An easy approximation is to pretend it is the enclosing rectangle.
    // It is nicer to do a little bit of geometry and get it right
    // YOUR CODE HERE
    double dx = u - (this.x+this.wd/2);     // horizontal distance from center to point (u,v)
    double dy = v - (this.y+this.ht/2);	    // vertical distance from center to point (u,v)
    return (4*dx*dx/this.sqwd + 4*dy*dy/this.sqht  <= 1.0);
    // END OF YOUR CODE
  }

  /** Changes the position of the shape by dx and dy.
   *   If it was positioned at (x, y), it will now be at (x+dx, y+dy)
   */
  public void moveBy(double dx, double dy){
    // YOUR CODE HERE
    this.x += dx;
    this.y += dy;
    // END OF YOUR CODE
  }

  /** Draws the oval on the graphics pane. It draws a black border and
   *  fills it with the color of the oval.
   *  It uses the drawing methods with the extra last argument of "false"
   *  so that the shape will not actually appear until the 
   *  graphics pane is redisplayed later. This gives much smoother redrawing.
   */
  public void redraw(){
    // YOUR CODE HERE
    UI.setColor(col);
    UI.fillOval(this.x, this.y, this.wd, this.ht, false);
    UI.setColor(Color.black);
    UI.drawOval(this.x, this.y, this.wd, this.ht, false);
    // END OF YOUR CODE
  }

  /** [Completion] Changes the width and height of the shape by the
   *      specified amounts.
   *  The amounts may be negative, which means that the shape
   *  should get smaller, at least in that direction.
   *  The shape should never become smaller than 1 pixel in width or height
   *  The center of the shape should remain the same.
   */
    public void resize(double changeWd, double changeHt){
	// YOUR CODE HERE
	if (this.wd + changeWd < 2) {
	    changeWd = 2 - this.wd;
	}
	if (this.ht + changeHt < 2) {
	    changeHt = 2 - this.ht;
	}
	this.x = this.x - changeWd/2;
	this.y = this.y - changeHt/2;
	this.wd += changeWd;
	this.ht += changeHt;
	this.sqwd = this.wd*this.wd;
	this.sqht = this.ht*this.ht;
	// END OF YOUR CODE
    }


  /** Returns a string description of the oval in a form suitable for
   * writing to a file in order to reconstruct the oval later
   *  The first word of the string must be Oval 
   */
  public String toString(){
    // YOUR CODE HERE
    return ("Oval "+this.x+" "+this.y+" "+this.wd+" "+this.ht+" "+
	    this.col.getRed()+" "+this.col.getGreen()+" "+this.col.getBlue());
    // END OF YOUR CODE
  }

      
}

/* Code for COMP102 Assignment 10
 * Name: Tianfu Yuan
 * Usercode: yuantian
 * ID: 300228072
 */

import comp102.*;
import java.io.*;
import java.util.*;
import java.awt.Color;


/** Rectangle represents a solid rectangle shape
 *    Implements the Shape interface.
 *  Needs fields to record the position, size, and colour.
 */

public class Rectangle implements Shape {
    //fields
    // YOUR CODE HERE
    private double x;
    private double y;
    private double wd;
    private double ht;
    private Color col;

    /** Constructor with explicit values
     *  Arguments are the x and y of the top left corner,
     *  the width and height, and the colour.
     */
    public Rectangle(double x, double y, double wd, double ht, Color col) {
    // YOUR CODE HERE
        this.x = x;
        this.y = y;
        this.wd = wd;
        this.ht = ht;
        this.col = col;
    }

    /** [Completion] Constructor which reads values from a file (scanner)
     *  The argument is a Scanner that contains the specification of the 
     *  Rectangle. The next 7 integers specify the position of the top
     *  left corner, and the width and height, and three ints specifying the 
     *  colour.
     */
    public Rectangle(Scanner data) {
    // YOUR CODE HERE
        this.x = data.nextDouble();
        this.y = data.nextDouble();
        this.wd = data.nextDouble();
        this.ht = data.nextDouble();
        int red = data.nextInt();
        int green = data.nextInt();
        int blue = data.nextInt();
        this.col = new Color(red, green, blue);
    }


    /** Returns true if the point (u, v) is on top of the shape */
    public boolean on(double u, double v) {
    // YOUR CODE HERE     
       return(u >= this.x) && (v >= this.y) && (u <= this.x + this.wd) && (v <= this.y + this.ht); // here to allow the template file to compile - please change
    }

    /** Changes the position of the shape by dx and dy.
     *  If it was positioned at (x, y), it will now be at (x+dx, y+dy)
     */
    public void moveBy(double dx, double dy) {
    // YOUR CODE HERE
        this.x += dx;
        this.y += dy;
    }

    /** Draws the rectangle on the graphics pane. It draws a black border and
     *  fills it with the color of the rectangle.
     *  It uses the drawing methods with the extra last argument of "false"
     *  so that the shape will not actually appear until the 
     *  graphics pane is redisplayed later. This gives much smoother redrawing.
     */
    public void redraw() {
    // YOUR CODE HERE
        UI.setColor(col);
        UI.fillRect(this.x, this.y, this.wd, this.ht, false);
        UI.setColor(Color.black);
        UI.drawRect(this.x, this.y, this.wd, this.ht, false);
    }


    /** [Completion] Changes the width and height of the shape by the
     *  specified amounts.
     *  The amounts may be negative, which means that the shape
     *  should get smaller, at least in that direction.
     *  The shape should never become smaller than 1 pixel in width or height
     *  The center of the shape should remain the same.
     */
    public void resize (double changeWd, double changeHt) {
    // YOUR CODE HERE
        if(this.wd + changeWd < 2){
            changeWd = 2 - this.wd;
        }
        
        if(this.ht + changeHt < 2){
            changeHt = 2 - this.ht;
        }
        
        this.x = this.x - changeWd/2;
        this.y = this.y - changeHt/2;
        this.wd += changeWd;
        this.ht += changeHt;
    }


    /** Returns a string description of the rectangle in a form suitable for
     *  writing to a file in order to reconstruct the rectangle later
     *  The first word of the string must be Rectangle 
     */
    public String toString() {
    // YOUR CODE HERE
    return("Rectangle " + this.x + " " + this.y + " " + this.wd + " " + this.ht + " " +
            this.col.getRed() + " " + this.col.getGreen() + " " + this.col.getBlue()); // here to allow the template file to compile - please change
    }

}

/* Code for COMP 102 Assignment 10
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.io.*;
import java.util.*;
import java.awt.Color;


/** Tree represents a nice-looking tree with branches.
 *  The base of its trunk is at (x, y), and its size field governs 
 *    the size of the tree.
 *  Since each tree is different, in a random way, it has
 *    has a seed, which starts the random number generator in the same
 *    place every time it is drawn.
 *  Implements the Shape interface.
 *  Needs fields, constructors, and all the methods specified in the interface.
 */

// YOUR CODE HERE
public class Tree implements Shape {
    //fields
    private double x;
    private double y;
    private double width;
    private double height;
    private Color col = Color.white;
    private long seed;
    private Random random = new Random();



    /** Arguments are the position (x,y) of the root, width and height,
	and the color. */
    public Tree (double x, double y, double width, double height, Color col) {
	this.x = x;   
	this.y = y;
	this.width = width;
	this.height = height;
	this.col = col;
	this.seed = random.nextLong();
    }

    /** Argument is a scanner that contains the specification of the line.
	The next 4 numbers should be the x and y of the first end
	the x and y of the other end, and the 3 following integers that specify the color. */

    public Tree (Scanner data) {
	this.x = data.nextDouble();
	this.y = data.nextDouble();
	this.width = data.nextDouble();
	this.height = data.nextDouble();
	int red = data.nextInt();
	int green = data.nextInt();
	int blue = data.nextInt();
	this.col = new Color(red, green, blue);
	this.seed = data.nextLong();

    }
    
    /** Returns true if the point (u, v) is near enough to the tree  */
    
    public boolean on(double u, double v) {
	return ( u >= this.x-this.width/2) && (u <= this.x + this.width/2 ) &&
	    (v<=y ) && (v >= this.y - this.height);
    }


    /** Changes the position of the shape by dx and dy.
	If it was positioned at (x, y), it will now be at (x+dx, y+dy)*/
    public void moveBy(double dx, double dy){
	this.x += dx;
	this.y += dy;
    }

    /** Draws the Tree on the graphics pane. 
	It does not redisplay the graphics pane - this must be done afterwards
	in order to make the triangle appear*/

    public void redraw() {
	UI.setColor(this.col);
	this.random = new Random(this.seed);
	int levels = 3+random.nextInt(3);
	double levelHt = this.height /levels;
	this.redraw(this.x, this.y, this.x, levelHt, this.width/4, levels);
    }

    private void redraw(double baseX, double baseY, double topX,
			double levelHt, double spread, int levels){
	double topY = baseY - levelHt;
	UI.drawLine(baseX, baseY, topX, topY, false);
	if ( levels > 1){
	    double left = topX - (3 + this.random.nextInt(6)) * spread / 12;
	    double ltHt = levelHt - 4 + this.random.nextInt(8);
	    double mid =  topX - (3 - this.random.nextInt(6)) * spread / 12;
	    double mdHt = levelHt - 4 + this.random.nextInt(8);
	    double right = topX + (3 + this.random.nextInt(6)) * spread / 12;
	    double rtHt = levelHt - 4 + this.random.nextInt(8);
	    this.redraw(topX, topY, left, ltHt, spread - 2, levels - 1);
	    this.redraw(topX, topY, mid, mdHt, spread - 2, levels - 1);
	    this.redraw(topX, topY, right, rtHt, spread - 2, levels - 1);
	}
    }


    /** Changes the size of the tree by the specified amounts
	(except the changeHt should be halved for a tree)
	The base of the shape should remain the same.
    */
    public void resize(double changeWd, double changeHt){
	changeHt = changeHt/2; 
	if (this.width + changeWd < 2) {
	    changeWd = 2 - this.width;
	}
	if (this.height + changeHt < 2) {
	    changeHt = 2 - this.height;
	}
	this.width +=  changeWd;
	this.height += changeHt;
    }




    /** Returns a string description of the line in a form suitable for
	writing to a file in order to reconstruct the line later */

    public String toString(){
	return ("Tree "+this.x+" "+this.y+" "+this.width+" "+this.height+" "+
		col.getRed()+" "+col.getGreen()+" "+col.getBlue()+
		" " + this.seed);
    }



}
// END OF YOUR CODE

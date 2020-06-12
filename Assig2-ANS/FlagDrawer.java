/* Code for Assignment 2, COMP102, 2012
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.awt.Color;


/** Draws flags of various countries.
    The correct dimensions of the official flags varies from country to country,
    But you may assume that they are 2/3 as high as they are wide.
    The exact colours of the flags will also be difficult to match;
    It is fine to use the standard colours: red, green, blue, orange.
    You can find lots of details, including the correct dimensions and colours, of flags from
    http://www.crwflags.com/fotw/flags/    
 */
public class FlagDrawer{

    public static final double top = 100;
    public static final double left = 200;

    /** The flag for Norway is a red rectangle with
     * a blue cross with a white border, slightly off-set to the left-hand side;
     */
    public void norwayFlag(){
        UI.initialise();      // not necessary, but avoids some problems when debugging
        // YOUR CODE HERE
	double width = UI.askDouble("How wide");
	double height = width*2/3;
	double grid = width/9;

	double xValue = 100;
	double yValue = 100;
	UI.clearGraphics();
	//red background
	UI.setColor(Color.red);
	UI.fillRect(xValue,yValue, width, height);

	//white off-set cross
	UI.setColor(Color.white);
	UI.fillRect(xValue+2*grid,yValue,2*grid,height);//vertical
	UI.fillRect(xValue,yValue+2*grid,width,2*grid); //horizontal

	//blue off-set cross
	UI.setColor(Color.blue);
	UI.fillRect(xValue+2.5*grid,yValue,grid,height);//vertical
	UI.fillRect(xValue,yValue+2.5*grid,width,grid);//horizontal
	UI.setColor(Color.black);
	UI.drawRect(xValue,yValue, width, height);
        // END OF YOUR CODE
    }


    /** The flag for Maldives is a red rectangle with
     * a smaller green rectangle in the middle and a white crescent in the center;
     */
    public void maldivesFlag(){
	// YOUR CODE HERE
	double width = UI.askDouble("How wide");
	double height = width*2/3;
	double grid = width/9;
	UI.clearGraphics();

	double xValue = 100;
	double yValue = 100;
	//red background
	UI.setColor(Color.red);
	UI.fillRect(xValue, yValue, width, height);

	//smaller green rectangle
	UI.setColor(Color.green);
	UI.fillRect(xValue+2*grid, yValue+1.5*grid,5*grid, 3*grid);

	//white crescent in center
	UI.setColor(Color.white);
	UI.fillOval(xValue+4*grid,yValue+2*grid,2*grid,2*grid);
	UI.setColor(Color.green);
	UI.fillOval(xValue+4.5*grid,yValue+2*grid,2*grid,2*grid);
	// END OF YOUR CODE
    }

    /** The flag for Greenland is a rectangle whose top half is white
     * and bottom half is red. There is a circle in the middle (off-set to left) 
     * which is also half white/red but on the opposite sides.
     */
    public void greenlandFlag(){
	// YOUR CODE HERE
	double width = UI.askDouble("How wide");
	double height = width*2/3;
	double grid = width/9;
	UI.clearGraphics();

	double xValue = 100;
	double yValue = 100;
	//white top background
	UI.setColor(Color.white);
	UI.fillRect(xValue,yValue, width, height/2);

	//red bottom background
	UI.setColor(Color.red);
	UI.fillRect(xValue,yValue+height/2, width, height/2);

	//red top semi-circle
	UI.fillArc(xValue+1.5*grid,yValue +grid, 4*grid, 4*grid, 0, 180);

	//blue bottom semi-circle
	UI.setColor(Color.white);
	UI.fillArc(xValue+1.5*grid,yValue +grid, 4*grid, 4*grid, 0, -180);

	UI.setColor(Color.black);
	UI.drawRect(xValue,yValue, width, height);
    // END OF YOUR CODE
    }

    /** The challenge:  The Jamaican flag has a yellow diagonal cross with 
      green triangles top and bottom, and black triangles left and right.
      There is no fillTriangle method in the UI class!
    */
    public void jamaicaFlag(){
	// YOUR CODE HERE
	double width = UI.askDouble("How wide");
	double height = width*2/3;
	UI.clearGraphics();

	double left = 100;
	double top = 100;
	//yellow background
	UI.setColor(Color.yellow);
	UI.fillRect(left,top, width, height);

	//Draw the triangles using arcs:	
	double offset = width/20;
	double arcScale = Math.sqrt(2)-0.1;
	double aleft = left - width/2*(arcScale-1);
	double atop = top - height/2*(arcScale-1);
	double awidth = width *arcScale;
	double aheight = height *arcScale;
	UI.setColor(Color.black);
	UI.fillArc(aleft,atop-offset, awidth, aheight, 45, 90);
	UI.fillArc(aleft,atop+offset, awidth, aheight, 225, 90);
	UI.setColor(Color.green);
	UI.fillArc(aleft+offset,atop, awidth, aheight, -45, 90);
	UI.fillArc(aleft-offset,atop, awidth, aheight, 135, 90);

	//Cover up the excess arc
	UI.setColor(Color.white);
	UI.fillRect(aleft-offset, atop, (left-aleft+offset+1),aheight);
	UI.fillRect(left+width, atop, (left-aleft+offset),aheight);
	UI.fillRect(aleft, atop-offset, awidth, (top-atop+offset+1));
	UI.fillRect(aleft, top+height, awidth, (top-atop+offset));

        // Outline
	UI.setColor(Color.black);
	UI.drawRect(left,top, width, height);
	// END OF YOUR CODE
	
    }



}

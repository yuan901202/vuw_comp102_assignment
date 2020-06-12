/* Code for Assignment 2, COMP102, 2012.
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.awt.Color;


/** Draws flags of various countries.
    The correct dimensions of the official flags varies from country to country.
    Many flags are 2/3 as high as they are wide.
    It is fine to make it 1/2 as high as they are wide.
    It is also fine on the flags of Bangladesh, Japan, etc to make the circles
    exactly half the height of the flags.
    The exact colours of the flags will also be difficult to match;
    It is fine to use the standard colours: red, green, blue, orange.
    You can find lots of details, including the correct dimensions and colours, of flags from
    http://www.crwflags.com/fotw/flags/    
 */
public class FlagExercise{

    public static final double top = 100;
    public static final double left = 200;

    /** The flag for France has three vertical stripes;
     * the left is blue, the right is red and the middle is white.
     */
    public void franceFlag(){
	// YOUR CODE HERE
	double width = UI.askDouble("How wide");
	double height = width*2/3;
	UI.clearGraphics();
	UI.setColor(Color.blue);
	UI.fillRect(left, top, width/3, height);
	UI.setColor(Color.red);
	UI.fillRect(left+width*2/3, top, width/3, height);
	UI.setColor(Color.black);
	UI.drawRect(left, top, width, height);
    }
    /** The flag for Indonesia has two horizontal stripes;
     * the top is red and the bottom is white.
     */
    public void indonesiaFlag(){
	double width = UI.askDouble("How wide");
	double height = width*2/3;
	UI.clearGraphics();
	UI.setColor(Color.red);
	UI.fillRect(left, top, width, height/2);
	UI.setColor(Color.black);
	UI.drawRect(left, top, width, height);
    }

    /** The flag for Austria has three horizontal stripes;
     * the top and bottom are red and the middle is white.
     */
    public void austriaFlag(){
	double width = UI.askDouble("How wide");
	double height = width*2/3;
	UI.clearGraphics();
	UI.setColor(Color.red);
	UI.fillRect(left, top, width, height/3);
	UI.fillRect(left, top+height*2/3, width, height/3);
	UI.setColor(Color.black);
	UI.drawRect(left, top, width, height);
    }


    /** The flag for Bangladesh has a green background and
     * a red circle in the middle.
     * 
     */
    public void bangladeshFlag(){
	double width = UI.askDouble("How wide");
	double height = width*3/5;
	double circle = width*2/5;
	UI.clearGraphics();
	UI.setColor(Color.green);
	UI.fillRect(left, top, width, height);
	UI.setColor(Color.red);
	UI.fillOval(left+width/2-circle/2, top+height/2-circle/2, circle, circle);
	UI.setColor(Color.black);
	UI.drawRect(left, top, width, height);
    }


    /** The flag for Japan has a white background and
     * a red circle in the middle.
     * 
     */
    public void japanFlag(){
	double width = UI.askDouble("How wide");
	double height = width*2/3;
	double circleDiam = height*3/5;
	UI.clearGraphics();
	UI.setColor(Color.red);
	UI.fillOval(left+width/2-circleDiam/2, top+height/2-circleDiam/2, circleDiam, circleDiam);
	UI.setColor(Color.black);
	UI.drawRect(left, top, width, height);
    }


    /** The flag for Niger has three horizontal stripes,
     * orange at the top, white in the middle, green at the bottom,
     * and an orange circle in the middle of the middle stripe.
     * 
     */
    public void nigerFlag(){
	double width = UI.askDouble("How wide");
	double height = width*2/3;
	double diam = height/3-4;
	UI.clearGraphics();
	UI.setColor(Color.orange);
	UI.fillRect(left, top, width, height/3);
	UI.setColor(Color.green);
	UI.fillRect(left, top+height*2/3, width, height/3);
	UI.setColor(Color.orange);
	UI.fillOval(left+width/2-diam/2, top+height/2-diam/2, diam, diam);
	UI.setColor(Color.black);
	UI.drawRect(left, top, width, height);
	// END OF YOUR CODE
    }


}

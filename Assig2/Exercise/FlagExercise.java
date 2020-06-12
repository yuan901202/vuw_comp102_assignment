/* Code for Assignment 2, COMP102, 2012.
 * Name: Tianfu Yuan
 * Usercode: yuantian  
 * ID: 300228072
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
        double wide = UI.askDouble("How wide:");
        double height = 0.667 * wide;
        UI.clearGraphics();
        UI.setColor(Color.black);
        UI.drawRect(left,top,wide,height);
        UI.setColor(Color.blue);
        UI.fillRect(left,top,0.333*wide,height);
        UI.setColor(Color.red);
        UI.fillRect(0.666*wide+left,top,0.333*wide,height);
    }
    



}

/* Code for Assignment 2, COMP102, 2012
 * Name: Tianfu Yuan
 * Usercode: yuantian
 * ID: 300228072
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
        double wide = UI.askDouble("How wide:");
        double height = 0.667 * wide;
        UI.clearGraphics();
        UI.setColor(Color.red);
        UI.fillRect(left,top,wide,height);
        UI.setColor(Color.white);
        UI.fillRect(left,top+height*3/8,wide,height/4);
        UI.fillRect(left+wide*3/11,top,wide*2/11,height);
        UI.setColor(Color.blue);
        UI.fillRect(left,top+height*7/16,wide,height/8);
        UI.fillRect(left+wide*7/22,top,wide/11,height);
        UI.setColor(Color.black);
        UI.drawRect(left,top,wide,height);
        
    }


    /** The flag for Maldives is a red rectangle with
     * a smaller green rectangle in the middle and a white crescent in the center;
     */
    public void maldivesFlag(){
        UI.initialise();
        double wide = UI.askDouble("How wide:");
        double height = 0.667 * wide;
        UI.clearGraphics();
        UI.setColor(Color.red);
        UI.fillRect(left,top,wide,height);
        UI.setColor(Color.green);
        UI.fillRect(left+wide/6,top+height/4,wide*2/3,height/2);
        UI.setColor(Color.white);
        UI.fillOval(left+wide*31/72,top+height/3,wide*2/9,height/3);
        UI.setColor(Color.green);
        UI.fillOval(left+wide*17/36,top+height/3,wide*2/9,height/3);
        UI.setColor(Color.black);
        UI.drawRect(left,top,wide,height);
        
    }

    /** The flag for Greenland is a rectangle whose top half is white
     * and bottom half is red. There is a circle in the middle (off-set to left) 
     * which is also half white/red but on the opposite sides.
     */
    public void greenlandFlag(){
        UI.initialise();
        double wide = UI.askDouble("How wide:");
        double height = 0.667 * wide;
        UI.clearGraphics();     
        UI.setColor(Color.red);
        UI.fillRect(left,top+height/2,wide,height/2);        
        UI.setColor(Color.red);
        UI.fillArc(left+wide/6,top+height/6,wide*4/9,height*2/3,0,180);
        UI.setColor(Color.white);
        UI.fillArc(left+wide/6,top+height/6,wide*4/9,height*2/3,180,180);
        UI.setColor(Color.black);
        UI.drawRect(left,top,wide,height);  
        
    }

    /** The challenge:  The Jamaican flag has a yellow diagonal cross with 
      green triangles top and bottom, and black triangles left and right.
      There is no fillTriangle method in the UI class!
    */
    public void jamaicaFlag(){
        UI.initialise();
        double wide = UI.askDouble("How wide:");
        double height = 0.667 * wide;
        
        double topStartAng = 30;
        double topEndAng = 120;
        double bottomSatrtAng = 210;
        double bottomEndAng = 120;
        double leftStartAng = 150;
        double leftEndAng = 60;
        double rightStartAng = 330;
        double rightEndAng = 60;
        
        UI.clearGraphics();
        UI.setColor(Color.yellow);
        UI.fillRect(left,top,wide,height);
        UI.setColor(Color.green);
        UI.fillArc(left+wide/70,top-height/3.4,wide,height*1.2,topStartAng,topEndAng);
        UI.fillArc(left+wide/70,top+height/8.9,wide,height*1.2,bottomSatrtAng,bottomEndAng);
        UI.setColor(Color.black);
        UI.fillArc(left-wide/15,top-height/10,wide,height*1.2,leftStartAng,leftEndAng);
        UI.fillArc(left+wide/13,top-height/10,wide,height*1.2,rightStartAng,rightEndAng);
        UI.setColor(Color.white);
        UI.fillRect(left,top-height,wide,height);
        UI.fillRect(left,top+height,wide,height);
        UI.fillRect(left-wide,top,wide,height);
        UI.fillRect(left+wide,top,wide,height);
        UI.setColor(Color.black);
        UI.drawRect(left,top,wide,height);
                                                                                                                                                                                         
}



}

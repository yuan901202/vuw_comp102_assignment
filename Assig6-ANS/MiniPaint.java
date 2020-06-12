/* Code for COMP 102 Assignment 6
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.awt.Color;
import javax.swing.JColorChooser;

public class MiniPaint implements UIButtonListener, UIMouseListener{

    // fields to remember
    //  the current shape that will be drawn when the mouse is next released.
    //  whether filled or not
    //  the position the mouse was pressed, 
    //  the name of the image file
    // YOUR CODE HERE
    private String shape = "Line";
    private boolean fill = false;
    private double lastX;
    private double lastY;
    private String imageFileName = "rose.jpg";
    // END OF YOUR CODE

    //Constructor
    /** Sets up the user interface - mouselistener and buttons */
    public MiniPaint(){
	// YOUR CODE HERE
	UI.setMouseListener(this);
	UI.addButton("Line", this);
	UI.addButton("Rect", this);
	UI.addButton("Oval", this);
	UI.addButton("Image", this);
	UI.addButton("Bubbles", this);
	UI.addButton("Clear", this);
	UI.addButton("Color", this);
	UI.addButton("Fill/Nofill", this);
	// END OF YOUR CODE
    }


    /* Respond to button presses */
    public void buttonPerformed(String cmd){
	// YOUR CODE HERE
	if (cmd.equals("Line") ){
	    this.shape = "Line";
	}
	else if (cmd.equals("Rect") ){
	    this.shape = "Rect";
	}
	else if (cmd.equals("Oval") ){
	    this.shape = "Oval";
	}
	else if (cmd.equals("Image") ){
	    
            // javax.swing.JOptionPane.showMessageDialog(this.frame, "Demo always loads rose.jpg\nYour program should let the user choose.");
	    // END OF DRAFT CODE
	    this.imageFileName =  UIFileChooser.open("Select image file");
	    this.shape = "Image";
	}
	else if (cmd.equals("Fill/Nofill") ){
	    this.fill = !this.fill;
	}
	else if (cmd.equals("Bubbles") ){
	    this.shape = "Bubbles";
	}
	else if (cmd.equals("Clear") ){
	    UI.clearGraphics();
	}
	else if (cmd.equals("Color") ){
	    UI.setColor(JColorChooser.showDialog(null,"Choose Color for new shapes", null));
	}
    }

    //Alternative version which is a bit neater
    public void buttonPerformedALT(String cmd){
	if (cmd.equals("Fill/Nofill") ){
	    this.fill = !this.fill;
	}
	else if (cmd.equals("Clear") ){
	    UI.clearGraphics();
	}
	else if (cmd.equals("Color") ){
	    UI.setColor(JColorChooser.showDialog(null,"Choose Color for new shapes", null));
	}
	else {
	    this.shape = cmd;
	}
	// END OF YOUR CODE
    }



    /** Respond to mouse events */
    public void mousePerformed(String action, double x, double y) {
	// YOUR CODE HERE
	if (action.equals("pressed")){
	    this.lastX = x;
	    this.lastY = y;
	}
	else if (action.equals("released")){
	    if (this.shape.equals("Line")){
		UI.drawLine(lastX, lastY, x, y);
	    }
	    else if (this.shape.equals("Image")){
		UI.drawImage(this.imageFileName, x, y);
	    }
	    else if (this.shape.equals("Bubbles")){
		this.drawBubbles(x, y);
	    }
	    else {// this does not need to be a separate method, but it is nicer this way.
		this.drawShape(x, y);
	    }
	    // END OF YOUR CODE
	}
    }

  
    /* Helper methods for drawing the shapes, if you choose to define them */
    // YOUR CODE HERE
    
    public void drawShape(double x, double y){
	double left= Math.min(lastX, x);
	double top= Math.min(lastY, y);
	double width= Math.abs(lastX - x);
	double height= Math.abs(lastY - y);
	if (this.shape.equals("Rect")){
	    this.drawRectangle(left, top, width, height);
	}
	else if (this.shape.equals("Oval")){
	    this.drawOval(left, top, width, height);
	}
    }

    public void drawRectangle(double left, double top, double width, double height){
	if (this.fill)
	    UI.fillRect(left, top, width, height);
	else 
	    UI.drawRect(left, top, width, height);
    }

    public void drawOval(double left, double top, double width, double height){
	if (this.fill)
	    UI.fillOval(left, top, width, height);
	else 
	    UI.drawOval(left, top, width, height);
    }


    public void drawImage(double left, double top){
	
	// javax.swing.JOptionPane.showMessageDialog(this.frame, "Demo always loads rose.jpg\nYour program should let the user choose.");
	// String this.imageFileName = "rose.jpg";
	// END OF DRAFT CODE
	if (imageFileName.equals("")){
	    this.imageFileName =  UIFileChooser.open("Select image file");
	}
    }

    public void drawBubbles(double x, double y){
	double size = 10;
	while (y > size/2){
	    this.drawOval(x-size/2, y-size/2, size, size);
	    size = size + 4;
	    y = y - (size *1.2);
	}
    }

    // END OF YOUR CODE

  // Main:  constructs new MiniPaint object
  public static void main(String[] arguments){
    MiniPaint ob = new MiniPaint();
  }	


}

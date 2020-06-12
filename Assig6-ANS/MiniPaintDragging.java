/* Code for COMP 102 Assignment 6
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.awt.Color;
import javax.swing.JColorChooser;

public class MiniPaintDragging implements UIButtonListener, UITextFieldListener, UIMouseListener{

    // fields to remember
    //  the current shape that will be drawn when the mouse is next released.
    //  whether filled or not
    //  the position the mouse was pressed, 
    //  the name of the image file
    //  the text string to draw.
    // YOUR CODE HERE
    private String shape = "Line";
    private boolean fill = false;
    private double pressedX;  // where the mouse was pressed
    private double pressedY;  
    private double dragX;     // where the mouse was last dragged to
    private double dragY;
    private String imageFileName = "rose.jpg";
    private String text = "Pumpkin";
    // END OF YOUR CODE

    //Constructor
    /** Sets up the user interface - mouselistener and buttons */
    public MiniPaintDragging(){
	UI.setMouseMotionListener(this);
	UI.addButton("Line", this);
	UI.addButton("Rect", this);
	UI.addButton("Oval", this);
	UI.addButton("Image", this);
	UI.addTextField("Text", this);
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

    /** Responds to the textField, recording the text in it */
    public void textFieldPerformed(String field, String value){
	// YOUR CODE HERE
	if (field.equals("Text")){
	    this.shape = "Text";
	    this.text = value;
	    UI.printMessage("text is now "+value);
	}
	// END OF YOUR CODE
    }


    /** Respond to mouse events */
    public void mousePerformed(String action, double x, double y) {
	// YOUR CODE HERE
	if (action.equals("pressed")){
	    this.pressedX = x;
	    this.pressedY = y;
	    if (this.shape.equals("Line")||this.shape.equals("Rect")||this.shape.equals("Oval")){
		this.startDrag(x,y);
	    }
	}
	else if (action.equals("released")){
	    if (this.shape.equals("Line")||this.shape.equals("Rect")||this.shape.equals("Oval")){
		this.endDrag(x, y);
	    }
	    else if (this.shape.equals("Text")){
		UI.drawString(this.text, x, y);
	    }
	    else if (this.shape.equals("Image")){
		UI.drawImage(this.imageFileName, x, y);
	    }
	    else if (this.shape.equals("Bubbles")){
		this.drawBubbles(x, y);
	    }
	    // END OF YOUR CODE
	}
	else if (action.equals("dragged")){
	    if (this.shape.equals("Line")||this.shape.equals("Rect")||this.shape.equals("Oval")){
		this.extendDrag(x, y);
	    }
	}
    }

  
    /* Helper methods for drawing the shapes, if you choose to define them */
    // YOUR CODE HERE
    
    public void startDrag(double x, double y){
	Trace.printf("startDrag: %4.0f, %4.0f\n", x, y);
	this.dragX = x;
	this.dragY = y;
	if (this.shape.equals("Line")){
	    UI.invertLine(this.pressedX, this.pressedY, this.dragX, this.dragY);
	}
	else if (this.shape.equals("Rect")){
	    this.doRectangle(this.pressedX, this.pressedY, this.dragX, this.dragY, true);
	}
	else if (this.shape.equals("Oval")){
	    this.doOval(this.pressedX, this.pressedY, this.dragX, this.dragY, true);
	}
    }

    /** Invert the previous outline shape, then change the drag point, and
	invert the new outline shape */
    public void extendDrag(double x, double y){
	Trace.printf("extndDrag: %4.0f, %4.0f from %4.0f, %4.0f \n", x, y, this.dragX, this.dragY);
	if (this.shape.equals("Line")){
	    UI.invertLine(this.pressedX, this.pressedY, this.dragX, this.dragY);
	    this.dragX = x;
	    this.dragY = y;
	    UI.invertLine(this.pressedX, this.pressedY, this.dragX, this.dragY);
	}
	else if (this.shape.equals("Rect")){
	    this.doRectangle(this.pressedX, this.pressedY, this.dragX, this.dragY, true);
	    this.dragX = x;
	    this.dragY = y;
	    this.doRectangle(this.pressedX, this.pressedY, this.dragX, this.dragY, true);
	}
	else if (this.shape.equals("Oval")){
	    this.doOval(this.pressedX, this.pressedY, this.dragX, this.dragY, true);
	    this.dragX = x;
	    this.dragY = y;
	    this.doOval(this.pressedX, this.pressedY, this.dragX, this.dragY, true);
	}
    }

    /** Invert the previous outline shape, then draw the shape at the new point */
    public void endDrag(double x, double y){
	Trace.printf("endDrag:   %4.0f, %4.0f from %4.0f, %4.0f \n", x, y, this.dragX, this.dragY);
	if (this.shape.equals("Line")){
	    UI.invertLine(this.pressedX, this.pressedY, this.dragX, this.dragY);
	    UI.drawLine(this.pressedX, this.pressedY, x, y);
	}
	else if (this.shape.equals("Rect")){
	    this.doRectangle(this.pressedX, this.pressedY, this.dragX, this.dragY, true);
	    this.doRectangle(this.pressedX, this.pressedY, x, y, false);
	}
	else if (this.shape.equals("Oval")){
	    this.doOval(this.pressedX, this.pressedY, this.dragX, this.dragY, true);
	    this.doOval(this.pressedX, this.pressedY, this.dragX, this.dragY, false);
	}
    }

    public void doRectangle(double x1, double y1, double x2, double y2, boolean invert){
	double left= Math.min(x1, x2);
	double top= Math.min(y1, y2);
	double width= Math.abs(x1 - x2);
	double height= Math.abs(y1 - y2);
	if (invert)         { UI.invertRect(left, top, width, height); }
	else if (this.fill) { UI.fillRect(left, top, width, height); }
	else                { UI.drawRect(left, top, width, height); }
    }

    public void doOval(double x1, double y1, double x2, double y2, boolean invert){
	double left= Math.min(x1, x2);
	double top= Math.min(y1, y2);
	double width= Math.abs(x1 - x2);
	double height= Math.abs(y1 - y2);
	if (invert)         { UI.invertOval(left, top, width, height); }
	else if (this.fill) { UI.fillOval(left, top, width, height); }
	else                { UI.drawOval(left, top, width, height); }
    }


    public void drawImage(double left, double top){
	if (imageFileName.equals("")){
	    this.imageFileName =  UIFileChooser.open("Select image file");
	}
    }

    public void drawBubbles(double x, double y){
	double size = 10;
	while (y > size/2){
	    if (this.fill) { UI.fillOval(x-size/2, y-size/2, size, size); }
	    else           { UI.drawOval(x-size/2, y-size/2, size, size); }
	    size = size + 4;
	    y = y - (size *1.2);
	}
    }

    // END OF YOUR CODE

  // Main:  constructs new MiniPaintDragging object
  public static void main(String[] arguments){
    MiniPaintDragging ob = new MiniPaintDragging();
  }	


}

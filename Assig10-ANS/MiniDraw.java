/* Code for COMP102 Assignment 10
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.io.*;
import java.awt.Color;
import java.util.Scanner;
import javax.swing.JColorChooser;


/** The MiniDraw program allows the user to create, save, and reload files
    specifying drawings consisting of a list of simple shapes.
    The program allows the user to
      - add a new shape to the drawing
      - remove a shape from the drawing
      - move a shape to a different position
      - set the colour for the next shape
      - save the current drawing to a file
      - load a previous drawing from a file.
    The shapes include lines, rectangles, ovals, and dots
	
    Classes
      The MiniDraw class handles all the user interaction:
        buttons, mouse actions, file opening and closing.
	It stores the current drawing in an array of Shape .

      The Shape interface specifies the Shape type
      The shape classes all implement Shape and represent different kinds of shapes.

    Files:
      A drawing is stored in a file containing one line for each shape,
        Each line has the name of the type of shape,
	 followed by a specification of the shape,
	 including the position (x and y) and the
	 colour (three integers for red, blue, and green).
	 The other values will depend on the shape.
	
    User Interface:
        There are buttons for dealing with the whole drawing (New, Load, Save),
	 buttons for specifying the next shape to draw, and
	 buttons for moving and removing shapes, and setting the color.
 */

public class MiniDraw implements UIButtonListener, UIMouseListener {

    // Fields
    private static final int maxShapes = 200;
    private Shape[] shapes = new Shape[maxShapes];    // the collection of shapes
    private int count = 0;

    // Fields to store mouse positions, current action, current shape, current colour, etc


  
    /** Constructor sets up the GUI:
     *	sets the mouse listener and adds all the buttons
     */
    public MiniDraw() {
	// YOUR CODE HERE
	UI.setMouseListener(this);
	UI.addButton("New", this);
	UI.addButton("Open", this);
	UI.addButton("Save", this);
	UI.addButton("Line", this);
	UI.addButton("Rect", this);
	UI.addButton("Oval", this);
	UI.addButton("Dot", this);
	UI.addButton("Tree", this);
	UI.addButton("Color", this);   
	UI.addButton("Move", this);
	UI.addButton("Delete", this);
	UI.addButton("Resize", this);
	// END OF YOUR CODE
    }

    /** Respond to button presses
     * For New, Open, Save, and Color, call the appropriate method (see below)
     *  to perform the action immediately.
     * For other buttons, store the button name in the currentAction field
     */
    public void buttonPerformed(String button) {
	// YOUR CODE HERE
	if (button.equals("New") )        { this.newDrawing(); }
	else if (button.equals("Open") )  { this.openDrawing(); }
	else if (button.equals("Save") )  { this.saveDrawing(); }
	else if (button.equals("Color") ) { this.selectColor(); }
	else{ 
	    this.currentAction = button;   
	}
	// END OF YOUR CODE
    }

    // Respond to mouse events 


    /** When mouse is pressed, remember the position in fields
     *	 and  work out the index of the shape it is on (if any)
     *   and store this in a  field (use the findShapeIndex(..) method)
     *  When the Mouse is released, depending on the currentAction,
     *  - perform the action (move, delete, or resize).
     *    move and resize are done on the shape  where the mouse was pressed,
     *    delete is done on the shape where the mouse was released 
     *  - construct the shape and add to the shapes array.
     *  It is easiest to call other methods (see below) to actually do the work,
     *  otherwise this method gets too big!
     */
    public void mousePerformed(String mouseAction, double x, double y) {
	// YOUR CODE HERE
	if (mouseAction.equals("pressed")){
	    this.pressedX = x;
	    this.pressedY = y;
	    this.currentShapeIndex = this.findShapeIndex(x, y);
	}
	if (mouseAction.equals("released")){
	    if (this.currentAction.equals("Move"))
		this.moveShape(x-this.pressedX, y-this.pressedY);
	    else if (this.currentAction.equals("Delete"))
		this.deleteShape(x, y);
	    else if (this.currentAction.equals("Resize"))
		this.resizeShape(x-this.pressedX, y-this.pressedY);
	    else // it is one of the shape 
		this.addShape(this.pressedX, this.pressedY, x, y); 
	}
	// END OF YOUR CODE
    }


    // -----------------------------------------------------
    // Methods that actually do the work  
    // -----------------------------------------------------

    /** Draws all the shapes in the list on the graphics pane
     *        First clears the graphics pane, then draws each shape,
     *  Finally repaints the graphics pane
     */
    public void drawDrawing() {
        UI.clearGraphics(false);
        // YOUR CODE HERE
        for (int i=0; i<this.count; i++){
            this.shapes[i].redraw();
        }
        // END OF YOUR CODE

        UI.repaintGraphics();
    }   

  
    /** Checks each shape in the list to see if the point (x,y) is on the shape.
     *   It returns the index of the topmost shape for which this is true.
     *  Returns -1 if there is no such shape.
     */
    public int findShapeIndex(double x, double y) {
        // YOUR CODE HERE
        for (int i=this.count-1; i>= 0; i--){
            if (this.shapes[i].on(x, y))
                return i;
        }
        // failed to find any shape that the point was over 
        // END OF YOUR CODE
     
	return -1;  
    }


    /** Sets the current color.
     * Asks user for a new color using a JColorChooser (see MiniPaint, Assig 6)
     * As long as the color is not null, it remembers the color */
    private void selectColor() {
	// YOUR CODE HERE
	Color newColor = JColorChooser.showDialog(null,"Choose new Color", this.currentColor);
	if (newColor!=null){
	    this.currentColor=newColor;
	}
	// END OF YOUR CODE
    }


    /** Start a new drawing -
     *	initialise the shapes array and clear the graphics pane. 
     */
    public void newDrawing() {
	// YOUR CODE HERE
	this.shapes = new Shape[this.maxShapes];
	this.count = 0;
	UI.clearGraphics();
	// END OF YOUR CODE
    }


    /** If there is no room in the array, do nothing.
	Otherwise, 
	Construct a new Shape object of the appropriate kind
	  (depending on currentAction) using the appropriate constructor
	  of the Line, Rectangle, Oval, or Dot classes.
	Adds the shape to the end of the collection of shapes in the drawing, and
	Re-draws the drawing */
    public void addShape(double x1, double y1, double x2, double y2) {
	Trace.printf("Drawing shape %s, at (%.2f, %.2f)-(%.2f, %.2f)\n",
			  this.currentAction, x1, y1, x2, y2);  //for debugging
	// YOUR CODE HERE
        if (this.count>=this.maxShapes) {
	    return;}
	Shape shape = null;   
	if (this.currentAction.equals("Line"))
	    shape = new Line(x1, y1, x2, y2, this.currentColor);
	else if (this.currentAction.equals("Dot"))
	    shape = new Dot(x2, y2, this.currentColor);
	else{
	    double left= Math.min(x1, x2);
	    double top= Math.min(y1, y2);
	    double width= Math.abs(x1-x2);
	    double height= Math.abs(y1-y2);
	    if (this.currentAction.equals("Rect"))
		shape = new Rectangle(left, top, width, height, this.currentColor);
	    else if (this.currentAction.equals("Oval"))
		shape =new Oval(left, top, width, height, this.currentColor);
	    else if (this.currentAction.equals("Tree"))
		shape = new Tree(left+width/2, top+height,
				 width, height, this.currentColor);
	}
	this.shapes[this.count] = shape;
	this.count++;
	    
	// END OF YOUR CODE
	this.drawDrawing();
    }



    /** Moves the current shape (if there is one)
     *	to where the mouse was released.
     *	Ie, change its position by (toX-fromX) and (toY-fromY)
     */
    public void moveShape(double changeX, double changeY) {
	Trace.printf("Moving shape by (%.2f, %.2f)\n", changeX, changeY);  //for debugging
	// YOUR CODE HERE
	if (this.currentShapeIndex >= 0){
	    this.shapes[this.currentShapeIndex].moveBy((changeX), (changeY));
	}
	this.drawDrawing();
	// END OF YOUR CODE
    }

    /** Finds the shape that was under the mouseReleased position (x, y)
     *	and then removes it from the array of shapes, moving later shapes down. 
     */
    public void deleteShape(double x, double y) {
	Trace.printf("Deleting shape under (%.2f, %.2f)\n", x, y);  //for debugging
	//Find the index of the shape that (pressedX, pressedY) is on.
	//and remove the shape from the drawing, then draw the drawing again
	//If not pressed on any shape, then do nothing.
	// YOUR CODE HERE
	int index = this.findShapeIndex(x, y);
	if (index >= 0){
            for (int i=index +1; i<this.count; i++){
                this.shapes[i-1] = this.shapes[i];
            }
            this.count = this.count-1;
	}
	this.drawDrawing();
	// END OF YOUR CODE
    }


    // METHODS FOR THE COMPLETION PART

    /** Resizes the current shape. A simple way of doing it is to
	resize the shape by the amount that the mouse was moved
	(ie from (fromX, fromY) to (toX, toY)). 
	If the mouse is moved to the right, the shape should
	  be made that much wider on each side; if the mouse is moved to
	  the left, the shape should be made that much narrower on each side
	If the mouse is moved up, the shape should be made
	  that much higher top and bottom; if the mouse is moved down, the shape 
	  should be made that much shorter top and bottom.
	The effect is that if the user drags from the top right corner of
	  the shape, the shape should be resized to whereever the dragged to.
    */
    public void resizeShape(double changeX, double changeY) {
	Trace.printf("Changing size of shape by (%.2f, %.2f) \n", changeX, changeY);  //for debugging
	// YOUR CODE HERE
	if (this.currentShapeIndex >= 0){
	    this.shapes[this.currentShapeIndex].resize(2*(changeX), -2*(changeY));
	}
	this.drawDrawing();
	// END OF YOUR CODE
    }



    /** Ask the user to select a file and save the current drawing to the file. */
    public void saveDrawing() {
	// YOUR CODE HERE
	String fname = UIFileChooser.save();
	if (fname==null) return;
	try {
	    PrintStream f = new PrintStream(new File(fname));
	    for (int i=0; i<this.count; i++){
		f.println(this.shapes[i].toString());
	    }
	    f.close();
	}
	catch(IOException e) {UI.println("File Saving failed: "+e);}
	// END OF YOUR CODE
    }
  
    /** Ask the user for a file to open,
     *	then read all the shape descriptions into the current drawing. 
     */
    public void openDrawing() {
	// YOUR CODE HERE
	String fname = UIFileChooser.open();
	if (fname==null) return;
	try {
	    Scanner f = new Scanner(new File(fname));
	    UI.printf("Opening file %s\n", fname);
	    this.shapes = new Shape[this.maxShapes];
	    this.count=0;
	    this.readShapes(f);
	    this.drawDrawing();
	}
	catch(IOException e) {UI.println("File loading failed: "+e);}
    }

    /** Read the shapes from a file in to the shapes array
        Uses the second constructor in the shapes classes.
    */
    public void readShapes(Scanner scan){
        while (scan.hasNext()){
            String shapetype = scan.next();
	    Shape shape = null;
            if (shapetype.equalsIgnoreCase("Oval"))
                shape = new Oval(scan);
            else if (shapetype.equalsIgnoreCase("Rectangle"))
                shape = new Rectangle(scan);
            if (shapetype.equalsIgnoreCase("Line"))
                shape = new Line(scan);
	    else if (shapetype.equalsIgnoreCase("Tree"))
                shape = new Tree(scan);
            else if (shapetype.equalsIgnoreCase("Dot"))
                shape = new Dot(scan);

	    if (this.count<this.maxShapes && shape != null){
		Trace.println("Loaded "+shapetype+shape);
		this.shapes[this.count] = shape;
		this.count++;
	    }
	    
        }
	
        // END OF YOUR CODE
    }

    public static void main(String args[]) {
	new MiniDraw();
    }

}
 

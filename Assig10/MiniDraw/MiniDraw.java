/* Code for COMP102 Assignment 10
 * Name: Tianfu Yuan
 * Usercode: yuantian
 * ID: 3002280872
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
    private String currentAction = "Line";   // current action ("Move", etc) or shape ("Line" etc)
    // YOUR CODE HERE
    private double pressedX;
    private double pressedY;
    private int currentShapeIndex = -1;
    private Color currentColor = Color.red;

  
    /** Constructor sets up the GUI:
     *  sets the mouse listener and adds all the buttons
     */
    public MiniDraw() {
    // YOUR CODE HERE
        UI.setMouseListener(this);
        UI.addButton("New", this);
        UI.addButton("Open", this);
        UI.addButton("Save", this);
        UI.addButton("Line", this);
        UI.addButton("Rectangle", this);
        UI.addButton("Oval", this);
        UI.addButton("Dot", this);
        UI.addButton("Tree", this);
        UI.addButton("Color", this);
        UI.addButton("Move", this);
        UI.addButton("Delete", this);
        UI.addButton("Resize", this);
    }

    /** Respond to button presses
     * For New, Open, Save, and Color, call the appropriate method (see below)
     *  to perform the action immediately.
     * For other buttons, store the button name in the currentAction field
     */
    public void buttonPerformed(String button) {
    // YOUR CODE HERE
        if(button.equals("New")){
            this.newDrawing();
        }
        
        else if(button.equals("Open")){
            this.openDrawing();
        }
        
        else if(button.equals("Save")){
            this.saveDrawing();
        }
        
        else if(button.equals("Color")){
            this.selectColor();
        }
        
        else{
            this.currentAction = button;
        }
               
    }

    // Respond to mouse events 


    /** When mouse is pressed, remember the position in fields
     *   and  work out the index of the shape it is on (if any)
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
        if(mouseAction.equals("pressed")){
            pressedX = x;
            pressedY = y;
            currentShapeIndex = this.findShapeIndex(x, y);
        }
        
        else if(mouseAction.equals("released")){
            if(currentAction.equals("Line") || currentAction.equals("Rectangle") || currentAction.equals("Oval") || currentAction.equals("Dot")){
                this.addShape(pressedX, pressedY, x, y);
            }
            
            else if(currentAction.equals("Move") && currentShapeIndex != -1){
                this.moveShape(x, y);
            }
            
            else if(currentAction.equals("Delete") && currentShapeIndex != -1){
                this.deleteShape(x, y);
            }
            
            else if(currentAction.equals("Resize") && currentShapeIndex != -1){
                this.resizeShape(x, y);
            }
            
        }
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
        for(int i=0; i<this.count; i++){
            this.shapes[i].redraw();
        }

        UI.repaintGraphics();
    }   

  
    /** Checks each shape in the list to see if the point (x,y) is on the shape.
     *   It returns the index of the topmost shape for which this is true.
     *  Returns -1 if there is no such shape.
     */
    public int findShapeIndex(double x, double y) {
        // YOUR CODE HERE
        for(int i=this.count-1; i>=0; i--){
            if(this.shapes[i].on(x, y)){
                return i;
            }
        }
        return -1;  
    }


    /** Sets the current color.
     * Asks user for a new color using a JColorChooser (see MiniPaint, Assig 6)
     * As long as the color is not null, it remembers the color */
    private void selectColor() {
    // YOUR CODE HERE
        Color newColor = JColorChooser.showDialog(null, "Choose new color", this.currentColor);
        if(newColor != null){
            this.currentColor = newColor;
        }
    }


    /** Start a new drawing -
     *  initialise the shapes array and clear the graphics pane. 
     */
    public void newDrawing() {
    // YOUR CODE HERE
        UI.clearGraphics();
        for(int n=0; n<shapes.length; n++){
            shapes[n] = null;
        }
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
    //the following code get extra help from tutor
        if(this.count>=this.maxShapes){
            return;
        }
        
        Shape shape = null;
        
        if(this.currentAction.equals("Line")){
            shape = new Line(x1, y1, x2, y2, this.currentColor);
        }
        else if(this.currentAction.equals("Dot")){
            shape = new Dot(x2, y2, this.currentColor);
        }
        else{
            double left = Math.min(x1, x2);
            double top = Math.min(y1, y2);
            double wd = Math.abs(x1 - x2);
            double ht = Math.abs(y1 - y2);
            if(this.currentAction.equals("Rectangle")){
                shape = new Rectangle(left, top, wd, ht, this.currentColor);
            }
            else if(this.currentAction.equals("Oval")){
                shape = new Oval(left, top, wd, ht, this.currentColor);
            }
            else if(this.currentAction.equals("Tree")){
                
            }
        }
        this.shapes[this.count] = shape;
        this.count++;
       
        this.drawDrawing();
    }



    /** Moves the current shape (if there is one)
     *  to where the mouse was released.
     *  Ie, change its position by (toX-fromX) and (toY-fromY)
     */
    public void moveShape(double changeX, double changeY) {
    Trace.printf("Moving shape by (%.2f, %.2f)\n", changeX, changeY);  //for debugging
    // YOUR CODE HERE
        if(this.currentShapeIndex>=0){
            this.shapes[this.currentShapeIndex].moveBy(changeX, changeY);
        }
        this.drawDrawing();
    }

    /** Finds the shape that was under the mouseReleased position (x, y)
     *  and then removes it from the array of shapes, moving later shapes down. 
     */
    public void deleteShape(double x, double y) {
    Trace.printf("Deleting shape under (%.2f, %.2f)\n", x, y);  //for debugging
    //Find the index of the shape that (pressedX, pressedY) is on.
    //and remove the shape from the drawing, then draw the drawing again
    //If not pressed on any shape, then do nothing.
    // YOUR CODE HERE
        int index = this.findShapeIndex(x, y);
        if(index>=0){
            for(int i=index+1; i<this.count; i++){
                this.shapes[i-1] = this.shapes[i];
            }
            this.count = this.count - 1;
        }
        this.drawDrawing();
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
        if(this.currentShapeIndex>=0){
            this.shapes[this.currentShapeIndex].resize(2*changeX, -2*changeY);
        }
        this.drawDrawing();
    }



    /** Ask the user to select a file and save the current drawing to the file. */
    public void saveDrawing() {
    // YOUR CODE HERE
        String file = UIFileChooser.save();
        if(file == null){
            return;
        }
        
        try{
            PrintStream out = new PrintStream(new File(file));
            for(int i=0; i<this.count; i++){
                out.println(this.shapes[i].toString());
            }
            out.close();
        }catch(IOException e){UI.printf("Error: %s\n", e);}
    }
  
    /** Ask the user for a file to open,
     *  then read all the shape descriptions into the current drawing. 
     */
    public void openDrawing() {
    // YOUR CODE HERE
        String file = UIFileChooser.open();
        if(file == null){
            return;
        }
        
        try{
            Scanner scan = new Scanner(new File(file));
            this.shapes = new Shape[this.maxShapes];
            this.count = 0;
            while(scan.hasNext()){
                String shapetype = scan.next();
                Shape shapes = null;
                if(shapetype.equalsIgnoreCase("Oval")){
                    shapes = new Oval(scan);
                }
                else if(shapetype.equalsIgnoreCase("Rectangle")){
                    shapes = new Rectangle(scan);
                }
                else if(shapetype.equalsIgnoreCase("Line")){
                    shapes = new Line(scan);
                }
                else if(shapetype.equalsIgnoreCase("Dot")){
                    shapes = new Dot(scan);
                }
                if (this.count<this.maxShapes && shapes != null){
                    Trace.println("Loaded "+shapetype+shapes);
                    this.shapes[this.count] = shapes;
                    this.count++;
                }
                
            }
            this.drawDrawing();
        }catch(IOException e){UI.printf("Error: %s\n", e);}
    }

    public static void main(String args[]) {
        new MiniDraw();
    }

}
 

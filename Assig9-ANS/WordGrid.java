/* Code for COMP102 Assignment 9
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.util.*;
import java.io.*;
import java.awt.Color;


/** WordGrid
 */
public class WordGrid implements UIButtonListener, UITextFieldListener, UIMouseListener{
    // Fields
    private int selectedRow = 0;  // selected cell
    private int selectedCol = 0;
    
    private String currentWord = "-";

    private int left =50;  // position of left top corner of table
    private int top = 20;
    private int wd = 60;   // size of cells
    private int ht = 20;

    private String[][] wordGrid = new String[10][8];


    /** Construct a new WordGrid object and set up the GUI
     */
    public WordGrid(){
	UI.setMouseListener(this);
	UI.addTextField("Word", this);
	UI.addButton("Set Entry", this);
        UI.addButton("Delete Entry", this);
	UI.addButton("Load Words", this);
	UI.addButton("Save Words", this);
	this.redisplay();
    }

    /** Display the grid of words.
     *  Draw a rectangle for every element, but only draw the string
     *  if it is not null
     *  Redrawing will be smoother if you use the optional false argument for
     *   the drawing commands
     */
    public void redisplay(){
	UI.clearGraphics(false);
	UI.setColor(Color.black);
	// YOUR CODE HERE
	for (int row=0; row<this.wordGrid.length; row++){
	    int y = this.top+row*this.ht;
	    for (int col=0; col<this.wordGrid[row].length; col++){
		int x = this.left+col*this.wd;
		UI.drawRect(x, y, this.wd, this.ht, false);
		if (this.wordGrid[row][col]!=null){
		    UI.drawString(this.wordGrid[row][col], x+4, y+this.ht-5, false);
		}
	    }
	}
	// END OF YOUR CODE
	
	//highlights the selected cell
	UI.setColor(Color.red);
	UI.drawRect(this.left+this.selectedCol*this.wd,
		    this.top+this.selectedRow*this.ht,
		    this.wd, this.ht, false);
	UI.repaintGraphics();
    }
    


    /* Load file into the array of words
     *  File represented as a sparse array:
     *  first line has size (number of rows and cols)
     *  other lines have row, col, entry for each non-null element
     */
    public void loadSparse(){
	// open file
	// read number of rows and cols and create array.
	// for each line of file read the row, col, and entry, and put entry at the
	//    [row][col] position in the array
        // close the file
	try{
	    Scanner sc = new Scanner(new File(UIFileChooser.open()));
	    // YOUR CODE HERE
	    int rows = sc.nextInt();
	    int cols = sc.nextInt();
	    this.wordGrid = new String[rows][cols];
	    while (sc.hasNext()){
		int row = sc.nextInt();
		int col = sc.nextInt();
		this.wordGrid[row][col] = sc.next();
	    }
	    // END OF YOUR CODE
	    sc.close();
	}
	catch(IOException e){UI.println("Fail: " + e);}
    }

    /** Saves the grid as a sparse array.
     *  - open file
     *  - print rows and cols
     *  - for each non-null entry, write the row, col, and entry 
     *  - close the file
     */
    public void saveSparse(){
	try{
	    PrintStream out = new PrintStream(new File(UIFileChooser.save()));
	    // YOUR CODE HERE
	    out.println( this.wordGrid.length + " " +this.wordGrid[0].length);
	    for (int row=0; row<this.wordGrid.length; row++){
		for (int col=0; col<this.wordGrid[row].length; col++){
		    if (this.wordGrid[row][col]!=null){
			out.println(row+" "+col+" "+this.wordGrid[row][col]);
		    }
		}
	    }
	    // END OF YOUR CODE
	    out.close();
	}
	catch(IOException e){UI.println("Fail: " + e);}
    }



    // GUI Methods



    /** Respond to button presses */
    public void buttonPerformed(String button){
        if (button.equals("Set Entry") ){
            this.wordGrid[this.selectedRow][this.selectedCol] = this.currentWord;
            this.redisplay();
        }
        else if (button.equals("Delete Entry") ){
            this.wordGrid[this.selectedRow][this.selectedCol] = null;
            this.redisplay();
        }
        else if (button.equals("Load Words") ){
            this.loadSparse();
            this.redisplay();
        }
        else if (button.equals("Save Words") ){
            this.saveSparse();
            UI.println("Saved");
        }
    }

    /** Respond to textField entries */
    public void textFieldPerformed(String field, String value){
	if (field.equals("Word") ){
	    this.currentWord = value;
	    this.redisplay();
	}
    }

    /** Respond to mouse events */
    public void mousePerformed(String action, double x, double y) {
	if (action.equals("released")){
	    int c = ((int)x - this.left)/ this.wd;
	    int r = ((int)y - this.top)/ this.ht;
	    if (r >= 0 && r < this.wordGrid.length && c >=0 && c < this.wordGrid[0].length){
		this.selectedRow = r;
		this.selectedCol = c;
		this.redisplay();
	    }
	}
    }



    // Main
    public static void main(String[] arguments){
	new WordGrid ();
    }	


}

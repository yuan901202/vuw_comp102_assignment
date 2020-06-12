/* Code for COMP102 Assignment 9
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.util.*;
import java.io.*;
import java.awt.Color;


/** NumberTable
 */
public class NumberTable implements UIButtonListener{
    // Fields

    private int left =50;  // position of table
    private int top = 20;
    private int wd = 50;   // size of cells
    private int ht = 20;

    private double[][] table = new double[][]{{ 5.0, 3.3, 7.2},{4.5, 2.6, 0.9}};

    /** Construct a new NumberTable object and set up the GUI
     */
    public NumberTable(){
	UI.addButton("Row Sums", this);
	UI.addButton("Column Sums", this);
	UI.addButton("Grand Total", this);
	UI.addButton("Ask", this);
	UI.addButton("Load", this);
    }


    // GUI Methods

    /** Respond to button presses */
    public void buttonPerformed(String button){
	if (button.equals("Row Sums") ){
	    this.rowSums();
	}
	else if (button.equals("Column Sums") ){
	    this.colSums();
	}
	else if (button.equals("Grand Total") ){
	    this.total();
	}
	else if (button.equals("Ask") ){
	    this.askTable();
	    this.redisplay();
	}
	else if (button.equals("Load") ){
	    this.loadTable(UIFileChooser.open());
	    this.redisplay();
	}
    }

    /** Display the table. */
    public void redisplay(){
	UI.clearGraphics(false);
	for (int row=0; row<this.table.length; row++){
	    int y = this.top+row*this.ht;
	    for (int col=0; col<this.table[row].length; col++){
		int x = this.left+col*this.wd;
		UI.drawRect(x, y, this.wd, this.ht, false);
		UI.drawString(""+this.table[row][col], x+4, y+this.ht-5, false);
	    }
	}
	UI.repaintGraphics();
    }
    

    /** Prints out (to the text pane), the sums of the values in each row */
    public void rowSums(){
	// YOUR CODE HERE
    }
	
    /** Prints out (to the text pane), the sums of the values in each column */
    public void colSums(){
	// YOUR CODE HERE
    }


    /** Prints out (to the text pane), the sums of all the values */
    public void total(){
	// YOUR CODE HERE
    }


    /** Ask the user for numbers for the table.*/
    public void askTable(){
	// ask for the number of rows and columns
	// create the array
	// ask for each value and put into table
	// YOUR CODE HERE
    }

    /** Load the table from a file.
     *  First two entries in the file will be the number of rows and columns,
     *   followed by table values in row order (all values in row 0, then
     *   all values in row 1, etc)
     */
    public void loadTable(String filename){
        // Ask the user for the name of the file
        // Read the size of the table and create the array
        // Read each value into the table
        // Close the file
	try{
	    Scanner sc = new Scanner(new File(filename));
	    // YOUR CODE HERE
	    sc.close();
	}
	catch(IOException e){UI.println("Fail: " + e);}
    }


    // Main
    public static void main(String[] arguments){
	new NumberTable ();
    }	


}

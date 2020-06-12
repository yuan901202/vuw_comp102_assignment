/* Code for COMP102 Assignment 7 
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/** Six methods that use arrays:
 * readAndReverse(): read tokens from file into array of Strings and then access values.
 *  uses an array and a count.
 *
 * cartoonCrowd(): read values from file, create an array of objects, call methods on objects
 *  uses an array and a count.
 *
 * plotNumbers(): read numbers from file into array of numbers then access values.
 *  uses an array and a count.
 *
 * sentenceGame(): construct array of objects, move them around
 *  uses a fixed size array.
 *
 * duckGame(): construct array of objects, call methods on them, remove them
 *  uses an array with nulls.
 *
 * countScores(): read integers from file and construct an array of counts
 *  uses an array of counts and a count.
 */

public class Exercise implements UIButtonListener, UIMouseListener{


    /** Asks the user for a file, and reads up to 100 tokens from the file, storing
	them in an array.
        It prints out the number of tokens it read and then
	prints the tokens in reverse order.
    */
    public void readAndReverse(){
	int maxCount= 100;                      // maximum number of tokens it will read
	String[] tokens = new String[maxCount]; // the array of tokens
	int count = 0;                          // the number of tokens read so far.
	try{
	    Scanner sc = new Scanner(new File(UIFileChooser.open()));
	    // read tokens until end of file or read maxCount tokens.
	    // YOUR CODE HERE
	} catch(IOException e){UI.println("File reading failed");}
    }


    /** Parameter is the name of a file.
        Reads a file specifying a collection of cartoonFigures, where
	each line contains an string, and an x and y value.
	For each line of the file, it should
	  read the values,
	  create a new CartoonFigure with those values and store it in an array
	make each cartoonFigure turn left and frown
	and then make each cartoonFigure move 40 units
    */
    public void cartoonCrowd (String filename){
	int maxCount= 10;                      // maximum number of cartoonFigures it will read
	CartoonFigure[] figs = new CartoonFigure[maxCount]; // the array of figures
	int count = 0;                          // the number of figures in the array
	try{
	    Scanner sc = new Scanner(new File(filename));
	    // YOUR CODE HERE
	} catch(IOException e){UI.println("File reading failed");}
    }


    /** Reads a sequence of numbers from the file "numbers.txt" into an array,
	keeping track of how many numbers have been read.
	The file will not have more than 100 numbers
	Finds the number half way through the sequence of numbers
	[if there are count numbers, then the middle number is at index (count-1)/2 ]
	Then plots the numbers as a sequence of rectangles hanging from the top
	of the graphics pane, width = 5, height = the number being plotted,
	color green if the number is less than the middle number, and red otherwise.
*/
    public void plotNumbers(){
	double[] nums = new double[100]; // the array of figures
	int count = 0;                   // the number of figures in the array
	try{
	    Scanner sc = new Scanner(new File("numbers.txt"));
	    // YOUR CODE HERE
	} catch(IOException e){UI.println("Fail: " + e);}

    }

    
    /** Sentence Game:
     * Constructs an array of words,
     * User has to incrementally reorder words into a sentence:
     * The method repeatedly
     *  - prints the words out on one line (using a loop to print each word in turn)
     *  - ask the user for the index of a word to move to the left.
     *  - quits if the user enters 0
     *  - swap the word at that index with the word at the previous index
     */
    public void sentenceGame(){
	UI.println("Target:  Jane saw the man with a telescope");
	UI.println();
	String[] words = new String[]{"telescope", "the", "a", "saw", "Jane", "with", "man"};
	while(true){
	// YOUR CODE HERE
	}
	UI.println("Done");
    }


    /** Simple duck shooting game
     *  Uses the Duck class, which has a constructor and two methods:
     *   - To construct a duck, specify its horizontal position: eg new Duck(100);
     *   - shuffle() makes the duck move across the screen to the left
     *   - shoot() turns it upside down. You can't shuffle a duck after you have shot it.
     * 
     * The duckGame method should
     * - Construct an array of 5 Ducks,
     * - Fill the array with Ducks placed across the screen (at 200, 300, 400, 500, 600)
     * - Have a loop that repeats 5 times:
     *   - shuffle all the remaining ducks (each array element that isn't null)
     *   - Ask the user for the number of a duck to shoot ( 0 to 4)
     *   - IF the answer is valid and that element of the array contains a duck, THEN
     *      shoot the duck (call the shoot method on the duck), 
     *      remove it from the array (put null in the array element)
     */
    public void duckGame(){
	Duck[] ducks = new Duck[5];
	// YOUR CODE HERE

	UI.println("That's all your shots");
    }


    /** Reads and counts a sequence of scores from a file.
	The scores are all numbers between 1 and 10, inclusive.
	The method keeps a count for each score in an array:
        count[n] has the count of the number of n's.
        When it reads a score, it increments that count for that score
	At the end, it prints the counts for each score.  */
    public void countScores(){
	int[] counts = new int[11]; // the array of counts
	try{
	    Scanner sc = new Scanner(new File("scores.txt"));
	    // YOUR CODE HERE
	} catch(IOException e){UI.println("Fail: " + e);}
    }




    /** 	 */
    public Exercise(){
	UI.addButton("ReadAndReverse", this);
	UI.addButton("Little crowd", this);
	UI.addButton("Big crowd", this);
	UI.addButton("Plot Numbers", this);
	UI.addButton("Duck Game", this);
	UI.addButton("Sentence Game", this);
	UI.addButton("Scores", this);
	UI.addButton("Show file", this);
    }

    public void buttonPerformed(String button){
	UI.clearGraphics(); UI.clearText();
	if (button.equals("ReadAndReverse")) { this.readAndReverse(); }
	else if (button.equals("Little crowd")) { this.cartoonCrowd("little-crowd.txt"); }
	else if (button.equals("Big crowd")) { this.cartoonCrowd("big-crowd.txt"); }
	else if (button.equals("Plot Numbers")) {this.plotNumbers(); }
	else if (button.equals("Duck Game")) {this.duckGame(); }
	else if (button.equals("Sentence Game")) {this.sentenceGame(); }
	else if (button.equals("Scores")) {this.countScores(); }
	else if (button.equals("Show file")) {this.showFile(); }
    }

    public void showFile(){
	String fname = UIFileChooser.open();
	UI.println("Contents of " + fname+":\n----------------");
	Scanner sc=null; 
	try{sc = new Scanner(new File(fname));}
	catch(Exception e){System.out.printf("Fail: %s\n", e);}

	while (sc.hasNextLine()) { UI.println(sc.nextLine()); }
	sc.close();
	UI.println("--------------");
    }

    public void mousePerformed(String action, double x, double y){
    }

    public static void main(String[] args){
        Exercise obj = new Exercise();
    }	

}

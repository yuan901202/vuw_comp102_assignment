/* Code for Assignment 6
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;


/** A Surprise object remembers the word it was given when it was constructed
    and has one method that says "Boo " followed by the word.
    It is a totally useless class!!!
 */
public class Surprise{

    //field
    // YOUR CODE HERE
    private String word;
    // END OF YOUR CODE

    //Constructor: stores the word it is passed in the field
    // YOUR CODE HERE
    public Surprise(String wd){
	this.word = wd;
    }
    // END OF YOUR CODE

    // sayBoo method
    // YOUR CODE HERE
    public void sayBoo(){
        UI.println("Boo " + this.word);
    }	
    // END OF YOUR CODE

}

/* Code for COMP 102 Assignment 8  
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.util.*;
import java.awt.Color;


/** Program for a simple game in which the player has to blow up balloons
     on the screen.
    The game starts with a collection of randomly placed small balloons
      (coloured circles) on the graphics pane.
    The player then clicks on balloons to blow them up by a small amount
     (random increase in the radius between 2 and 6 pixels).
    If two balloons ever touch, then they "burst" and disappear.
    At any time, the player may choose to stop and "lock in" their score.
    The goal is to get the largest score. The score is the total of the
     sizes (areas) of all the balloons left on the screen at the end, minus
     the sizes of the balloons that burst.
    At each step, the current score is recalculated and displayed,
     along with the highest score that the player has achieved so far.

    The BalloonGame class uses an array containing Balloon objects
    to represent the current set of Balloons on the screen.

    The Lock Score button should finish the current game and start a new one

    Clicking (ie, releasing) the mouse on the graphics pane should do the following
      Find out if the mouse was clicked on top of any unpopped balloon.
      If so,
        Make the balloon a bit larger
        Check whether the balloon is touching any other balloon.
        If so
           pop the balloons (which will make them disappear from the graphics pane)
           add the sizes of the popped balloons to the penalty
           remove the popped Balloons from the array
        Recalculate and redisplay the score
     If all the balloons are gone, the game is over.
    
     To start a game, the program should
         Clear the graphics pane
         Initialise the penalty
         Make a new set of Balloons at random positions
         Report the score

     If the game is over, the program should
        Remember the current score if it is higher than the high score,
        Report the score,
        Start a new game.
        
    Note, the Balloon class is written for you. Make sure that you know
     all its methods.
    
 */
public class BalloonGame implements UIButtonListener, UIMouseListener{
    // Fields
    // Store the collection of balloons, and information for the current penalty and the highscore
    // YOUR CODE HERE
    private final int maxBalloons = 20;
    private Balloon[] balloons = new Balloon[maxBalloons];

    private double penalty;  // the total area of the balloons that have been burst.
    private double highScore;  // highest score in game.
    // END OF YOUR CODE



    // Constructors
    /** Construct a new BalloonGame object
     * and set up the GUI
     */
    public BalloonGame(){
	// YOUR CODE HERE
        UI.setMouseListener(this);
        UI.addButton("Lock Score", this);
        this.start();
	// END OF YOUR CODE
    }


    /** Respond to button presses */
    public void buttonPerformed(String cmd){
	// YOUR CODE HERE
        if (cmd.equals("Lock Score") ){
            this.gameOver();
        }
	// END OF YOUR CODE
    }


    /** Start the game, with no overlaps
        Clear the graphics pane
        Initialise the score information (the total penalty so far)
        Make a new set of Balloons at random positions
        Report the score
    */
    public void start(){
        UI.clearGraphics();
        this.penalty = 0;
        for (int i=0; i<this.maxBalloons; i++){
        // YOUR CODE HERE
	    Balloon b = null;            // This is the completion version that avoids overlaps
	    boolean foundPlace = false;  // have I found a place for the new balloon.
	    while (!foundPlace){         
		double x = 30 + Math.random()*600;  //try a place
		double y = 30 + Math.random()*500;
		b = new Balloon(x, y);
		foundPlace = true; 
		for (int j=0; j<i; j++){   // check place against all the previous balloons
		    if ( b.touches(this.balloons[j]) ) {
			foundPlace = false;
			break;
		    }
		}
	    }
            this.balloons[i] = b;  // if is wasn't touching any of them, put it in the array
            this.balloons[i].draw();
        }
        this.reportScore(); 
    }

    /** Start the game:
        Clear the graphics pane
        Initialise the score information (the total penalty so far)
        Make a new set of Balloons at random positions
        Report the score
    */
    public void startCore(){
        UI.clearGraphics();
        this.penalty = 0;
        for (int i=0; i<this.maxBalloons; i++){
            double x = 30 + Math.random()*600;
            double y = 30 + Math.random()*500;
            this.balloons[i] = new Balloon(x, y);
            this.balloons[i].draw();
        }
        // END OF YOUR CODE
        this.reportScore(); 
    }


    /** Find the balloon at (x,y) if any,
        Expand it 
        Check whether it is touching another balloon,
        If so, update the penalty, pop both balloons, and remove them from the array
        Report the current score.
        If there are no balloons left, this game is over.
    */
    public void mousePerformed(String action, double x, double y) {
	// YOUR CODE HERE
        if (action.equals("released")){
	    int b=0;
	    while ( b<this.maxBalloons){
		if (this.balloons[b]!=null && this.balloons[b].on(x, y) )
		    break;
		b++;
	    }
	    if (b==this.maxBalloons)    // no balloon at (x,y)
		return;

	    // b must be the index of a balloon at the point (x,y). Expand it
	    this.balloons[b].expand();

	    // check if it is touching any other balloon (but not itself)
	    for (int i=0; i<this.maxBalloons; i++){
		if ( b!=i && this.balloons[i]!=null && this.balloons[b].touches(this.balloons[i]) ){
		    //
		    this.penalty = penalty+ this.balloons[b].size() + this.balloons[i].size();
		    this.balloons[b].pop();
		    this.balloons[b] = null;
		    this.balloons[i].pop();
		    this.balloons[i] = null;
		    break;
		}
	    }

	    // Report the score
	    this.reportScore();

	    // If no balloons left, then game is over.
	    if (this.countBalloons()==0)
		this.gameOver();
	}
        // END OF YOUR CODE
    }
    
    /** Compute and return the current score:
        Sum of the sizes for the remaining ballons, minus the penalty
        (total area of burst balloons) */
    public double score(){
        double ans = 0;
        // YOUR CODE HERE
        for (int i=0; i<this.maxBalloons; i++)
            if (this.balloons[i]!=null)
                ans = ans + this.balloons[i].size();
        // END OF YOUR CODE
        return (ans - this.penalty)/100;
    }

    /** Count and return the number of Balloons in the array */
    public int countBalloons(){
        // YOUR CODE HERE
        int count = 0;
        for (int b=0; b<this.maxBalloons; b++){
            if (this.balloons[b]!=null)
                count++;
        }
        return count;
        // END OF YOUR CODE
    }

    /** Report the Score
        Remember score if greater than current highScore),
        Pop all the balloons, clear the screen, and start again */
    public void gameOver(){
        double finalScore = Math.round(this.score());
        UI.printMessage("Score was "+finalScore);
        if (finalScore > this.highScore)
            this.highScore = finalScore;
        this.start();
    }

    /** Report the score in the scoreArea at the bottom of the window */
    public void reportScore(){
        UI.printMessage("Score = "+Math.round(this.score())+"    High score = "+this.highScore);
    }

    // Main
    public static void main(String[] arguments){
        BalloonGame ob = new BalloonGame();
    }   


} 

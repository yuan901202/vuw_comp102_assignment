/* Code for COMP 102 Assignment 8  
 * Name: Tianfu Yuan
 * Usercode: yuantian
 * ID: 300228072
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
    Balloon[] balloons = new Balloon[20];
    private double penalty;
    private double score;
    private double highScore;
    
    // Constructors
    /** Construct a new BalloonGame object
     * and set up the GUI
     */
    public BalloonGame(){
    // YOUR CODE HERE
        UI.initialise();
        UI.addButton("Lock Score", this);
        UI.setMouseListener(this);
    }


    /** Respond to button presses */
    public void buttonPerformed(String cmd){
    // YOUR CODE HERE
        if(cmd.equals("Lock Score")){
            this.gameOver();
        }
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
        for (int i=0; i<balloons.length; i++){
        // YOUR CODE HERE
            balloons[i] = new Balloon(Math.random()*500, Math.random()*450);
            balloons[i].draw();
        }
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
        //the following code get help from tutors
        int a = 0;
        for(int i=1; i<balloons.length; i++){
            if(balloons[i] != null){
                if(balloons[i].on(x, y)){
                    balloons[i].expand();
                    a = i;
                }
                
                for(int n=0; n<balloons.length; n++){
                    if(balloons[n] != null && balloons[a] != null && a != n){
                        if((balloons[a].touches(balloons[n]) == true)){
                            penalty = penalty + (balloons[a].size() + balloons[n].size());
                            balloons[a].pop();
                            balloons[n].pop();
                            balloons[a] = null;
                            balloons[n] = null;
                        }
                    }
                }
            }
            
            this.reportScore();
            if(this.countBalloons() == 0){
                this.gameOver();
            }
        
        }
    }
    
    /** Compute and return the current score:
        Sum of the sizes for the remaining ballons, minus the penalty
        (total area of burst balloons) */
    public double score(){
        double ans = 0;
        // YOUR CODE HERE
        for(int n=0; n<balloons.length; n++){
            if(balloons[n] == null){
                n++;
            }
            else{
                ans += balloons[n].size();
            }
        }
        return (ans - this.penalty)/100;
    }

    /** Count and return the number of Balloons in the array */
    public int countBalloons(){
        // YOUR CODE HERE
        int count = 0;
        for(int n=0; n<balloons.length; n++){
            if(balloons[n] != null){
                count++;
            }
        }
        return count;
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

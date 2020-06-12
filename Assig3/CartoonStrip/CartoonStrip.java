/* Code for COMP 102 Assignment 3 2012
 * Name: Tianfu Yuan
 * Usercode: yuantian
 * ID: 300228072
 */

import comp102.*;

/** Program to create simple animated cartoon strips using the
 *  CartoonFigure class.  
 */

public class CartoonStrip{
    
    /** animate creates two cartoon figures and places them on the window.
     *  Then animates them according to a fixed script by calling a series
     *  of methods on the figures.
     */
    public void animate(){
        CartoonFigure my = new CartoonFigure("blue", 50, 100);
        CartoonFigure you = new CartoonFigure("green", 500, 100);
        my.turnRight();
        you.turnLeft();
        my.move(10);
        you.frown();
        you.move(10);
        my.talk("Why are you crying?");
        you.talk("Because I'm stupid!");
        my.talk("That's no reason to cry.");
        my.talk("One cries because one is sad.");
        my.talk("For example,");
        my.talk("I cry because others are stupid,");
        my.talk("and that makes me sad.");
        you.talk("- -!");
        you.frown();
        you.move(10);
        you.smile();
        my.talk("I wouldn't tell you the secret.");
        you.talk("What secret? Tell me the secret.");
        my.move(10);
        my.talk("Mom smokes in the car.");
        my.talk("Jesus is okay with it,");
        my.talk("but we can't tell dad.");
        you.frown();
        you.talk("Not that secret, the other secret.");
        my.talk("I'M BATMAN!!! SHHH!!!");
        you.smile();
        you.talk("Oh my god. You are the BATMAN!");
        my.talk("Yeah, I know that.");
        you.talk("OK. See you batman.");
        my.talk("See you later, normal people.");
        you.frown();
        you.turnRight();
        you.move(10);
        you.move(10);
        you.move(10);
        you.move(10);
        you.move(10);
        you.move(10);
        you.move(10);
        you.move(10);
        you.move(10);
        you.move(10);
        
    }

    /** dance creates a cartoon figure and places it on the window.
     *  Then makes the figure dance by calling two different dance step methods
     *  several times. 
     */
    public void dance(){
        CartoonFigure dance = new CartoonFigure("rico", 200, 150);
        dance.turnLeft();
        dance.talk("Let's dance !");
        dance.smile();
        dance.turnRight();
        dance.talk("I like to move it");
        dance.move(10);
        dance.talk("move it");
        dance.move(10);
        dance.move(10);
        dance.talk("She likes to move it");
        dance.move(10);
        dance.talk("move it");
        dance.turnLeft();
        dance.move(10);
        dance.talk("He likes to move it");
        dance.move(10);
        dance.talk("move it");
        dance.turnRight();
        dance.turnLeft();
        dance.talk("You like to");
        dance.move(10);
        dance.talk("move it");
        dance.turnRight();
        dance.talk("I like to move it");
        dance.move(10);
        dance.talk("move it");
        dance.move(10);
        dance.move(10);
        dance.talk("She likes to move it");
        dance.move(10);
        dance.talk("move it");
        dance.turnLeft();
        dance.move(10);
        dance.talk("He likes to move it");
        dance.move(10);
        dance.talk("move it");
        dance.turnRight();
        dance.turnLeft();
        dance.talk("You like to");
        dance.move(10);
        dance.talk("move it");
        
    }

    /* this method is here to make it easy to restart the UI window from bluej*/
    public void restartUI(){
        UI.initialise();
        UI.clearGraphics();
    }



}


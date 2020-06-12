/* Code for Assignment 4
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.util.*;
import java.io.*;
import java.awt.Color;


/** 
 */
public class ExerciseConditionals{

    //    Conditionals:  

    /** Ask user for an integer between 1 and 10
        if the number is out of range (number<1 or number>10), then it reports this
	otherwise it prints  "that number is odd" or  "that number is even"
	depending on whether the number is odd or even.
	Note, if a number is even, then the remainder when dividing by 2 (number % 2) is zero.
    */
    public void oddOrEven(){
	//YOUR CODE HERE
	int num = UI.askInt("Enter a number between 1 and 10");
	if (num > 10 || num <1) {
	    UI.println("That number wasn't between 1 and 10!");
	}
	else if (num%2 == 0){
	    // or (num==2||num==4||num==6||num==8||num==10)
	    UI.println("That number is even");
	}
	else {
	    UI.println("That number is odd");
	}
	//END OF YOUR CODE
    }

    /** Asks the user to enter a word.
	Says "Yes, that fits" if the word starts with "p" and is 7 characters long,
	and "Sorry, that word won't work" otherwise.
    */
    public void wordGame(){
	//YOUR CODE HERE
	String word = UI.askString("Guess the word:");
	String firstLetter = word.substring(0,1);
	if (firstLetter.equalsIgnoreCase("p") && word.length()==7){
	    UI.println("Yes, that fits");
	}
	else {
	    UI.println("Sorry, that word won't work");
	}
	//END OF YOUR CODE
    }



    /**  Asks the user to enter the name of a country, and
	 draws the appropriate flag (by calling one of the
	 methods below).
	 Recognises france, indonesia, austria and bangladesh.
    */
    public void drawAFlag(){
	//YOUR CODE HERE
	String name = UI.askString("Which country");
	if (name.equalsIgnoreCase("france")){
	    this.drawFranceFlag();
	}
	else if (name.equalsIgnoreCase("indonesia")){
	    this.drawIndonesiaFlag();
	}
	else if (name.equalsIgnoreCase("austria")){
	    this.drawAustriaFlag();
	}
	else if (name.equalsIgnoreCase("bangladesh")){
	    this.drawBangladeshFlag();
	}
	else{
	    UI.println("Sorry, I don't know about that country");
	}
	//END OF YOUR CODE
    }

    
    /** Asks the user to enter three words and prints out the longest one.
	(if two words are equally long, it doesn't matter which it prints).
	You can call the length() method on a string to find out how long it is.
	Note that there are three possible cases to check for.
    */
    public void longestWord(){
	//YOUR CODE HERE
	String word1 = UI.askString("First word:");
	String word2 = UI.askString("Second word:");
	String word3 = UI.askString("Third word:");
	if (word1.length() >= word2.length() && word1.length() >= word3.length()) {
	    UI.println("The longest word is " + word1);
	}
	else if (word2.length() >= word1.length() && word2.length() >= word3.length()) {
	    UI.println("The longest word is " + word2);
	}
	else {
	    UI.println("The longest word is " + word3);
	}
	//END OF YOUR CODE
    }

    // The flag methods called by drawAFlag.


    /** Draws the French flag */
    public void drawFranceFlag(){
	double width = UI.askDouble("How wide");
	double height = width*2/3;
	UI.clearGraphics();
	UI.setColor(Color.blue);
	UI.fillRect(100,100, width/3, height);
	UI.setColor(Color.red);
	UI.fillRect(100+width*2/3,100, width/3, height);
	UI.setColor(Color.black);
	UI.drawRect(100,100, width, height);
    }
    /** Draws the Indonesian flag */
    public void drawIndonesiaFlag(){
	double width = UI.askDouble("How wide");
	double height = width*2/3;
	UI.clearGraphics();
	UI.setColor(Color.red);
	UI.fillRect(100,100, width, height/2);
	UI.setColor(Color.black);
	UI.drawRect(100,100, width, height);
    }

    /** Draws the Austrian flag */
    public void drawAustriaFlag(){
	double width = UI.askDouble("How wide");
	double height = width*2/3;
	UI.clearGraphics();
	UI.setColor(Color.red);
	UI.fillRect(100,100, width, height/3);
	UI.fillRect(100,100+height*2/3, width, height/3);
	UI.setColor(Color.black);
	UI.drawRect(100,100, width, height);
    }


    /** Draws the Bangladeshi flag  */
    public void drawBangladeshFlag(){
	double width = UI.askDouble("How wide");
	double height = width*3/5;
	double circle = width*2/5;
	UI.clearGraphics();
	UI.setColor(Color.green);
	UI.fillRect(100,100, width, height);
	UI.setColor(Color.red);
	UI.fillOval(100+width/2-circle/2,100+height/2-circle/2, circle, circle);
	UI.setColor(Color.black);
	UI.drawRect(100,100, width, height);
    }


}

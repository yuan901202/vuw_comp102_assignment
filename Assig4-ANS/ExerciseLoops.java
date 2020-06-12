/* Code for Assignment 4
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.util.*;
import java.io.*;
import java.awt.Color;


/** <description of class ExerciseLoops>
 */
public class ExerciseLoops{

    /*
loops for reading sequence of numbers and processing them, and 

loops to call some other method n times, 

loops to draw lots of lines, 


    */
    /* Asks user for an integer, then add up all the integers
       from 1 to that number (using a loop) and print the sum.
       For example, if the user enters 10, it should add up
       1+2+3+4+5+6+7+8+9+10 and print out the sum: 55
    */
    public void sumOneToN(){
	//YOUR CODE HERE
	int n = UI.askInt("Maximum number:");
	int sum = 0;
	int i=1;
	while (i<=n){
	    sum = sum + i;
	    i=i+1;
	}
	UI.printf("Sum of numbers from 1 to %d = %d\n", n, sum);	
	//END OF YOUR CODE

    }
	    

        /* Asks user for an integers, then draws that many blue bubbles
	   in a vertical line.
    */
    public void drawBubbles(){
	//YOUR CODE HERE
	int count = UI.askInt("Number of bubbles: ");
	double x = 100+Math.random()*400;
	double y = 400;
	UI.setColor(Color.blue);
	while (count > 0){
	    UI.fillOval(x, y, 30, 30);
	    y = y - 40;
	    count = count - 1;
	}
	//END OF YOUR CODE
    }



    /* Tell the user to enter a sequence of numbers, ending with the word 'done'
       then read all the numbers in a loop, adding them up as it goes.
       Then print the sum 
    */
    public void sumNumbers(){
	//YOUR CODE HERE
	UI.print("Enter some numbers, ending with 'done': ");
	double sum = 0;
	while (UI.hasNextDouble()){
	    double num = UI.nextDouble();
	    sum = sum + num;
	}
	UI.printf("Sum of those numbers is %4.2f\n", sum);
	//END OF YOUR CODE
    }

    /* Tell the user to enter a sentence, followed by the token #
       then read all the tokens (words) and print out the number of
       words in the sentence.
       eg, if they enter
         I am happy today #
       it should print out
         Sentence has 4 words
       You should use a "while(true)" loop with a break, and the UI.next() method
    */
    public void countWords(){
	//YOUR CODE HERE
	int count = 0;
	UI.print("Enter a sentence, followed by a # :");
	while (true){
	    String word = UI.next();
	    if (word.equals("#")) { break; }
	    count = count + 1;
	}
	UI.println ("Sentence had " + count + " words");
	//END OF YOUR CODE
    }


    /* Tell the user to enter a sequence of numbers, ending with the word 'done'
       then read all the numbers in a loop, printing out 8 times each number as it goes.
       eg, if they enter 4 21 20 9 done
       it should print   32 168 160 72    (either on one line or on separate lines)
    */
    public void multiplyNumbers(){
	//YOUR CODE HERE
	UI.print("Enter some numbers, ending with 'done': ");
	while (UI.hasNextDouble()){
	    double num = UI.nextDouble();
	    UI.println(num*8);
	}
	//END OF YOUR CODE
    }



    public static void main(String[] args){
        new Exercise();
    }	

}

/* Code for COMP102 Assignment 5
 * Name: Tianfu Yuan
 * Usercode: yuantian
 * ID: 300228072
 */

import comp102.*;
import java.util.Scanner;
import java.io.*;
import java.awt.Color;

/** Exercises for programs that read data from files.
 */

public class FilesExercise{



    /** This method lets you read the contents of a file.
    It is written for you, and may be helpful when working on
    the exercises
    */
    public void printFile(){
        String fileName = UIFileChooser.open("Choose a file");
        UI.println("Printing contents of "+ fileName);
        UI.println("--------------------------------------");
        try {
            Scanner scan = new Scanner(new File(fileName));
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                UI.println(line);
            }
        }
        catch(IOException e){UI.println("File reading failed");}
        UI.println("--------------------------------------");
    }




    /** Read numbers from a file called "numbers.txt" which contains only numbers
    adding them up, and printing the total at the end. (The total should be 2174)
    */
    public void sumNumbers(){
    // YOUR CODE HERE
        UI.println("--------------------------------------");
        try {
            Scanner scan = new Scanner(new File("numbers.txt"));
            int sum = 0;
            while (scan.hasNextLine()){
                int num
                String line = scan.nextLine();
                UI.println(line);
                sum = num + sum;
            }
            
        }
        catch(IOException e){UI.println("File reading failed");}
        UI.println("--------------------------------------");
    }

    /** read a file of pairs of numbers, and draw a circle of radius 20 at each position.
    eg, if a line of the file has 120 350 on it, then draw a circle centered at
    (120, 350). You can make them all the same colour or random colours
    */
    public void drawCircles(){
    // YOUR CODE HERE
    }


    /** read a file of names and positions, and draw them on the graphics pane.
    each line of the file has two numbers (x and y) a one word name, followed by three
    integers specifying the color to draw the name.
    For each line, it sets the color, then draws the name at the position.
    If the three colour integers are in r, g, and b, then you can set the colour
    using  UI.setColor(new Color(r, g, b)));
    */
    public void drawNames(){
    // YOUR CODE HERE
    }





    /** Read a file called "text.txt" and print out just the first token (word) on each line.
     */
    public void firstWords(){
    // DRAFT YOUR HERE
    try {
        Scanner scan = new Scanner(new File("text.txt"));
        while (scan.hasNext()){
        String word = scan.next();
        String rest = scan.nextLine();
        UI.println(word);
        }
        scan.close();
    }
    catch(IOException e){UI.println("File reading failed");}
    // END OF YOUR CODE
    }

    /** Read words from a file and print out the longest word.
     */
    public void longestWord(){
    // YOUR CODE HERE
    }

    /** Read coursecodes and course sizes (number of students) from file and
    count how many courses have more than 100 students
    */
    public void largeCourses(){
    // YOUR CODE HERE
    }



    /** Read order file consisting of lines with:
    item  count  unit-price,
    and then print total cost of order
    */
    public void totalOrder(){
    // YOUR CODE HERE
    }




}

/* Code for COMP102 Assignment 5
 * Name:
 * Usercode:
 * ID:
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
	double sum = 0;
	try {
	    Scanner scan = new Scanner(new File("numbers.txt"));
	    while (scan.hasNext()){
		double num = scan.nextDouble();
		sum = sum + num;
	    }
	}
	catch(IOException e){UI.println("File reading failed");}
	UI.println("Total = " + sum);
	// END OF YOUR CODE
    }

    /** read a file of pairs of numbers, and draw a circle of radius 20 at each position.
	eg, if a line of the file has 120 350 on it, then draw a circle centered at
	(120, 350). You can make them all the same colour or random colours
    */
    public void drawCircles(){
	// YOUR CODE HERE
	try {
	    Scanner scan = new Scanner(new File("circle-positions.txt"));
	    while (scan.hasNext()){
		int x = scan.nextInt();
		int y = scan.nextInt();
		UI.setColor(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
		UI.fillOval(x-10, y-10, 20, 20);
	    }
	    scan.close();
	}
	catch(IOException e){UI.println("File reading failed");}
	// END OF YOUR CODE
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
	try {
	    Scanner scan = new Scanner(new File("names.txt"));
	    while (scan.hasNext()){
		int x = scan.nextInt();
		int y = scan.nextInt();
		String name = scan.next();
		int r = scan.nextInt();
		int g = scan.nextInt();
		int b = scan.nextInt();
		UI.setColor(new Color(r, g, b));
		UI.drawString(name, x, y);
	    }
	    scan.close();
	}
	catch(IOException e){UI.println("File reading failed");}
	// END OF YOUR CODE
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
	String longestWord = "";
	try {
	    Scanner scan = new Scanner(new File("text.txt"));
	    while (scan.hasNext()){
		String word = scan.next();
		if (word.length() > longestWord.length()){
		    longestWord = word;
		}
	    }
	    scan.close();
	}
	catch(IOException e){UI.println("File reading failed");}
	UI.println("Longest word was " + longestWord);
	// END OF YOUR CODE
    }

    /** Read coursecodes and course sizes (number of students) from file and
	count how many courses have more than 100 students
    */
    public void largeCourses(){
	// YOUR CODE HERE
	int courseCount = 0;
	try {
	    Scanner scan = new Scanner(new File("course-counts.txt"));
	    while (scan.hasNext()){
		String course = scan.next();
		int size = scan.nextInt();
		if (size > 100){
		    courseCount = courseCount+1;
		}
	    }
	}
	catch(IOException e){UI.println("File reading failed");}
	UI.printf("There were %d courses with more than 100 students", courseCount);
	// END OF YOUR CODE
    }



    /** Read order file consisting of lines with:
	item  count  unit-price,
	and then print total cost of order
    */
    public void totalOrder(){
	// YOUR CODE HERE
	double totalCost = 0;
	try {
	    Scanner scan = new Scanner(new File("order.txt"));
	    while (scan.hasNext()){
		String item = scan.next();
		int count = scan.nextInt();
		double unitCost = scan.nextDouble();
		totalCost = totalCost + (count * unitCost);
	    }
	    scan.close();
	}
	catch(IOException e){UI.println("File reading failed");}
	UI.printf("Total cost of order is $%4.2f", totalCost);
	// END OF YOUR CODE
    }




}

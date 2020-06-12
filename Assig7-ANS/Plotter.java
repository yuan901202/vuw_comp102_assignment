/* Code for COMP102 Assignment 7 
 * Name: 
 * Usercode:
 * ID:
 */

import comp102.*;
import java.util.*;
import java.io.*;
import java.awt.Color;



/** This is an extension of the TemperatureAnalyser program from assignment 4
    which plots a sequence of temperature and prints some statistics.
    However, instead of reading data from the user, it reads the data from
    a file into an array, which means that it can analyse the numbers
    more easily and in more different ways.
    It can also cope with much larger sets of numbers.
    It plots the data in two different ways.
  
    The constructor sets up three buttons and the buttonPerformed
    method should respond to them:
    Read Data: Reads numbers from a file into an array (stored
               in a field) and prints statistics of the data.
	       It should assume that all the values are integers.
    Plot:      Plots a line graph (not a bar graph) of all the numbers
    Histogram: [completion] Computes and plots a histogram of the numbers
               (the number of times each possible number occurs in the list)

    There are 7 methods you are to complete, all focusing on the array of data.
    readData:  asks user for file and reads numbers (integers) into an array
    minValue:  returns the smallest value in the array 
    maxValue:  returns the largest value in the array 
    mean:      returns the mean of the values in the array
    drawPlot:  plots a line graph of all the values in the array
               (partly completed for you)
    histogram: [completion] computes and draws a histogram of the numbers. 
    arrayOfCounts:  used by histogram.
  */

public class Plotter implements UIButtonListener{
    // Fields
    private int maxCount = 2000; // the maximum number of numbers it will ever read
    private int[] data;   // the array of data
    private int count;    // the number of numbers

    // Constant fields holding the dimensions of the graph for the plotData method
    private final int graphLeft = 10;
    private final int graphTop = 10;
    private final int graphWd = 500;
    private final int graphHt = 450;
    private final int graphRight = graphLeft+graphWd;
    private final int graphBot = graphTop+graphHt;

    /** Set up the three buttons */
    public Plotter(){
	UI.addButton("Read Data", this);
	UI.addButton("Plot", this);
	UI.addButton("Histogram", this);
    }

    /** Respond to button presses */
    public void buttonPerformed(String button){
	if (button.equals("Read Data") ){
	    UI.clearGraphics(); UI.clearText();
	    this.readData();
	    this.reportStats();
	}
	else if (button.equals("Plot") ){
	    this.plotData();
	}
	else if (button.equals("Histogram") ){
	    this.histogram();
	}
    }

    /** Asks user for the file (using UIFileChooser.open() and
	reads data from the file into an array stored in a field
	Assumes all data is positive
    */
    public void readData(){
	// clear the text area, ready to append new strings.
	// Initialise the array 
	// read the data from the file into the array
	// YOUR CODE HERE
	String fname = UIFileChooser.open();
	this.data = new int[this.maxCount];
	this.count = 0;
	try {
	    Scanner input = new Scanner(new File(fname));
	    UI.println("Reading data from " + fname);
	    while ( input.hasNextInt() && this.count < this.data.length) {
		data[this.count] = input.nextInt();
		this.count++;
	    }
	    input.close();
	} catch (IOException e) {UI.println("Error: Can't open file " + fname);}

	UI.println("Read all data");
	// END OF YOUR CODE
    }


    /** Computes and writes out the min, max, mean, standard deviation, and median of the data.
	Appends the data to the textArea.
     */
    public void reportStats(){
	if (this.data==null){ //there is no data to analyse
	    UI.println("No data to report on");
	    return;
	}
	UI.println("\n\nStatistics:\n-------------");
	UI.printf("Count:  %d\n", this.count);
	UI.printf("Min:    %d\n", this.minValue());
	UI.printf("Max:    %d\n", this.maxValue());
	UI.printf("Mean:   %4.3f\n", this.mean());
	
	UI.printf("SD:     %4.3f\n", this.standardDeviation());
	UI.printf("median: %4.1\n", this.median());
	
    }

    /** Returns the smallest value in the data array. 
	Assumes there is at least one value 
    */
    public int minValue(){
	// YOUR CODE HERE
	int ans = this.data[0];
	for (int i=1; i<this.count; i++)
	    if ( this.data[i]<ans )  ans = this.data[i];
	return ans;
	// END OF YOUR CODE
    }

    /** Returns the largest value in the data array. 
	Assumes there is at least one value 
     */
    public int maxValue(){
	// YOUR CODE HERE
	int ans = this.data[0];
	for (int i=1; i<this.count; i++)
	    if ( this.data[i]>ans )  ans = this.data[i];
	return ans;
	// END OF YOUR CODE
    }

    /** Returns the mean of the values in the data array. 
	Assumes there is at least one value
    */
    public double mean(){
	// YOUR CODE HERE
	double sum = 0;
	for (int i=0; i<this.count; i++){
	    sum = sum + this.data[i];
	}
	return sum / this.count;
	// END OF YOUR CODE
    }


    /** Returns the standard deviation of the values in the data array. 
	Assumes there is at least one value
    */
    public double standardDeviation(){
	// YOUR CODE HERE
	double sum = 0;
	double sumsquares = 0;
	for (int i=0; i<this.count; i++){
	    sum += this.data[i];
	    sumsquares += (this.data[i]*this.data[i]);
	}
	double mean =  sum/this.count;
	return Math.sqrt(sumsquares/this.count - mean*mean);
    }

    /** Returns the median value in the data array. 
	Assumes there is at least one value 
    */
    public double median(){
	int[] countArray = this.arrayOfCounts();
	if (this.count%2 ==1) {  // odd number of numbers, so there is a middle number
	    double halfWay = (this.count+1)/2;
	    int total = 0;
	    for (int num=0; num<countArray.length; num++){
		total = total+countArray[num];
		if (total >= halfWay) {   // the middle number is in this bucket.
		    return num;
		}
	    }
	}
	else {  // even number of numbers: we need the average of the two numbers at
	        // count/2 and count/2+1
	    double halfWay = (this.count)/2;
	    int total = 0;
	    for (int num=0; num<countArray.length; num++){
		total = total+countArray[num];
		if (total > halfWay) { //both middle numbers are in this bucket
		    return num;
		}
		else if (total == halfWay){  // the middle numbers are in this and the next bucket
		    for (int next=num+1; next<countArray.length; next++){
			if (countArray[next]> 0){  //there is something in this bucket
			    return (num+next)/2.0;
			}
		    }
		}
	    }
	}
	return -1;   // This should never happen, but is required for compilation
	// END OF YOUR CODE
    }


    /** Plots a line graph of the data
	Core version: assume all data values are positive and fewer than 500 values.
	Draws the x and y axis,
	Plots a line graph of all the points with a blue line between each pair of points
	Uses the graphLeft, graphTop, etc fields for the dimensions and positions of the graph.
    */
    public void plotData(){
	if (this.data==null || this.count<2){ //there is no data to analyse
	    UI.println("No data to plot");
	    return;
	}
	UI.clearGraphics();

	// draw axes
	UI.setColor(Color.black);
	UI.drawLine(this.graphLeft, this.graphTop, this.graphLeft, this.graphBot); 
	UI.drawLine(this.graphLeft, this.graphBot, this.graphRight, this.graphBot);

	// plot points: line between each pair of values
	// YOUR CODE HERE
	UI.setColor(Color.blue);
	for (int i=1; i<this.count; i++){
	    double x1 = graphLeft + i-1;
	    double x2 = graphLeft + i;
	    double y1 = graphBot - this.data[i-1];
	    double y2 = graphBot - this.data[i];
	    UI.drawLine(x1, y1, x2, y2);
	}
	// END OF YOUR CODE

    }

    /** Draw histogram
	Assumes all values are between 0 and 450, and
	also that the count of any single value is less than 450.
	Plots a (green) vertical line for each possible value.
	Height of line is 5 times the count of that value.
	Uses the arrayOfCounts method to construct the data for the
	histogram.
    */
    public void histogram(){
	if (this.data==null){ //there is no data to analyse
	    UI.println("No data to plot histogram");
	    return;
	}
	UI.clearGraphics();

	// Plots a (green) vertical line for each possible value.
	// Height of line is 5 times the count of that value.
	// YOUR CODE HERE
	int[] countArray = this.arrayOfCounts();
	UI.setColor(Color.green);
	for (int i=0; i<countArray.length; i++){
	    int x = this.graphLeft+i;
	    int y = this.graphBot-countArray[i]*5;
	    UI.drawLine(x, this.graphBot, x, y);
	}
	// END OF YOUR CODE


	// draw axes
	UI.setColor(Color.black);
	UI.drawLine(this.graphLeft, this.graphTop, this.graphLeft, this.graphBot); 
	UI.drawLine(this.graphLeft, this.graphBot, this.graphRight, this.graphBot);

    }

    /** Constructs and returns an array of counts of each value.
	(the "count array")
        Assumes that all values are non-negative.
        The count array will have a count for each integer from 0
	to the maximum value in the data
    */
    public int[] arrayOfCounts(){
	// YOUR CODE HERE
	int[] countArray = new int[this.maxValue()+1];
	for (int i=0; i< this.count; i++){
	    if (this.data[i] >= 0)          // this just checks the assumption
		countArray[this.data[i]]++;
	}
	return countArray;
	// END OF YOUR CODE
    }

    // Main
    public static void main(String[] arguments){
	new Plotter();
    }	

}

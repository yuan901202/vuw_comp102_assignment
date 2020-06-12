/* Code for COMP 102 Assignment 4 2012
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.awt.Color;


/** The class contains two methods for analysing a sequence of temperature
  *  readings from the monitor on a temperature-controlled food-storage device.
  *  Both methods read a sequence of temperatures from
  *  the user, terminated by any non-number such as "done" or "end".
  * 
  *  analyseTemps method computes and prints out the six numbers of interest:
  *    maximum, minimum, and average temperatures.
  *    initial and final temperatures
  *    number of readings over the threshold
  *    The absolute value of the largest rise or fall between readings.
  *
  *  plotTemps plots the temperatures through the day as a simple bar graph.
  *
  * The core and completion versions of the program should not use arrays or lists -
  *  they should process each number as it is read.
  */

public class TemperatureMonitor{

  /** analyseTemps asks the user for a sequence of temperatures,
    * It computes and prints out several statistics 
    *   the maximum, minimum, and average
    *   the initial and final 
    *   the number of readings over the threshold,
    *   the largest rise or fall.
    */

  public void analyseTemps() {
      UI.clearText();
      // Abstract Algorithm:
      //  Ask user for threshold value (completion only)
      //  Initialise variables
      //  Prompt for input
      //  Loop, reading numbers and updating variables
      //  Compute and print out the analysis

      // YOUR CODE HERE

      double max = -Double.MAX_VALUE;
      double min = Double.MAX_VALUE;
      double sum = 0.0;
      int count = 0;

      // Loop, reading values and updating variables
      UI.print("Analysis (core)\n Enter temperatures; end with 'done': ");
      while (UI.hasNextDouble()) {
	  double value = UI.nextDouble();
	  count = count + 1;
	  sum = sum + value;
	  if (value > max) {max = value;}
	  if (value < min) {min = value;}
      }
      double mean = sum / count;
      UI.println("-------Analysis-------");
      UI.printf("Minimum value was:  %7.2f\n", min);
      UI.printf("Maximum value was:  %7.2f\n", max);
      UI.printf("Average value was:  %7.2f\n", mean);
      // END OF YOUR CODE
  }


  /** Reads a sequence of values (integers) from the user and plots a bar graph
   *  of them, using narrow rectangles whose heights are equal to the value.
   * The sequence is terminated by any word (non-number) such as "close" or "end".
   */
  public void plotTemps() {
      UI.clearText();
      UI.clearGraphics();
      // Draw x axis
      // Prompt for numbers
      // Loop, reading numbers and drawing bars
      // YOUR CODE HERE
      double base = 350;              //base of the graph
      double left = 50;               //left of the graph
      double step = 25;               //distance between plotted points
      UI.drawLine(left, base, (left + (20 * step) + 20),  base);// x axis

      //Prompt for input
      UI.print("Plot (core)\nEnter values, end with 'done': ");

      //Loop, reading values and drawing bars
      double x = left;
      while (UI.hasNextDouble()) {
	  double value = UI.nextDouble();
	  UI.fillRect(x, base - value, step - 2, value);
	  x = x + step;
      }
      // END OF YOUR CODE
  }

  public void analyseTempsCompletion() {

      UI.clearText();
      // Ask user for threshold value
      double threshold = UI.askDouble("What is the threshold temperature:");
      // Initialise variables
      double max = -Double.MAX_VALUE;
      double min = Double.MAX_VALUE;
      double sum = 0.0;
      int count = 0;
      int countOverThresh = 0;
      double value = -1000;       // start it off with an impossible value.
      double previousValue = -1000;
      double firstValue = -1000;
      double largestChange = 0;

      // prompt, Loop, reading values and updating variables
      UI.print("Analysis (Completion)\n Enter temperatures; end with 'done': ");
      while (UI.hasNextDouble()) {
	  previousValue = value;
	  value = UI.nextDouble();
	  if (previousValue == -1000) {
	      firstValue = value;
	  }
	  count = count + 1;
	  if (value > threshold){
	      countOverThresh = countOverThresh + 1;
	  }
	  sum = sum + value;
	  if (value > max) {
	      max = value;
	  }
	  if (value < min) {
	      min = value;
	  }
	  if (previousValue != -1000){
	      double change = Math.abs(value-previousValue);
	      if (change > largestChange){
		  largestChange = change;
	      }
	  }
      }
      // Compute and print out the analysis
      if (count == 0){
	  UI.println("There were no readings to analyse");
      }
      else{
	  double mean = sum / count;
	  UI.println("-------Analysis-------");
	  UI.printf("Initial value was:    %5.2f\n", firstValue);
	  UI.printf("Final value was:     %5.2f\n", value);
	  UI.printf("Minimum value was:  %5.2f\n", min);
	  UI.printf("Maximum value was:  %5.2f\n", max);
	  UI.printf("Average value was:  %7.2f\n", mean);
	  UI.printf("There were %d readings over the %7.2f threshold\n", countOverThresh, threshold);
	  if (count>1){
	      UI.printf("Largest change was:  %7.2f\n", largestChange);
	  }
      }

  }

  public void plotTempsCompletion() {

      UI.clearText();
      UI.clearGraphics();

      // initialise variables
      double base = 350;              //base of the graph
      double step = 25;               //distance between plotted points
      double left = 50;               //left of the graph
      int count = 0;
      int maxCount = 20;
      double right = (left + (maxCount * step) + 10);
      UI.setColor(Color.black);
      UI.drawLine(left, base, right,  base);// x axis

      // Ask user for threshold value
      double threshold = UI.askDouble("What is the threshold temperature:");
      //Prompt for input
      UI.print("Plot (Completion)\nEnter values, end with 'done': ");

      //Loop, reading values and drawing bars
      double x = left;
      double value = -1;
      while (UI.hasNextDouble() && count < maxCount) {
	  value = UI.nextDouble();
	  count = count + 1;
	  if (value > 300){
	      UI.setColor((Color.red).darker());
	      value = 300;
	  }
	  else if (value > threshold){
	      UI.setColor(Color.red);
	  }
	  else {
	      UI.setColor(Color.green);
	  }
	  UI.fillRect(x, base - value, step - 2, value-1);
	  x = x + step;
      }

  }




}

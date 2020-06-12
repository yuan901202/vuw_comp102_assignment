/* Code for COMP 102 Assignment 4 2012
 * Name: Tianfu Yuan
 * Usercode: yuantian
 * ID: 300228072
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
      UI.println("Analysis (core)");
      // Abstract Algorithm:
      //  Ask user for threshold value (completion only)
      //  Initialise variables
      //  Prompt for input
      //  Loop, reading numbers and updating variables
      //  Compute and print out the analysis

      // YOUR CODE HERE
      UI.print("Enter temperatures; end with 'done': ");
      int count = 0;
      double sum = 0;
      
      double min = Double.MAX_VALUE; /**Get minimum value */
      double max = Double.MIN_VALUE; /**Get maximum value */
      
      while (UI.hasNextDouble()){ /**Enter next variable */
          double temp = UI.nextDouble();
          count = count + 1; /**Calculate the count */
          sum = sum + temp; /**Calculate the total */
          
          if (temp < min){
              min = temp;
          }
          
          if (temp > max){
              max = temp;
          }
          
      }
      
      UI.println("--------Analysis--------");
      UI.println("Minimum value was: " + min);
      UI.println("Maximum value was: " + max);
      UI.println("Average value was: " + (sum/count));
      
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
      
      double left = 80;
      double top = 500;
      int count = 0;
      
      UI.print("Enter temperatures; end with 'done': ");
      UI.drawLine(left,top,800,top); /**draw axes */
      
      while (UI.hasNextDouble()){
          double temp = UI.nextDouble();         
          UI.fillRect(left + count * 30,top-temp,20,temp);
          count = count + 1;
      }
      
  }

  public void analyseTempsCompletion() {
      UI.println("Analysis (completion)");
      
      double threshold = UI.askDouble ("Enter threshold: ");
      UI.print("Enter temperatures; end with 'done': ");
      int count = 0;
      double sum = 0;
      
      double min = Double.MAX_VALUE;
      double max = Double.MIN_VALUE;
      double initialTemp = 0;
      double temp = 0;
      int overThreshold = 0;
      double pre = 0;
      double largestChange = Double.MIN_VALUE;
      
      while (UI.hasNextDouble()){
          temp = UI.nextDouble();
          count++;
          sum = sum + temp;
          
          if (temp > threshold){
              overThreshold = overThreshold + 1;
          }
          
          if (temp < min){
              min = temp;
          }
          
          if (temp > max){
              max = temp;
          }
          
          if (count == 1){
              initialTemp = temp;
              pre = temp;
          }
          
          if (count > 1){
              double change = Math.abs(temp - pre);
              if (change > largestChange){
                  largestChange = change;
              }
              pre = temp;
          }
          
      }
      
      UI.println();
      UI.println("--------Analysis--------");
      UI.println("Minimum value was: " + min);
      UI.println("Maximum value was: " + max);
      UI.println("Average value was: " + (sum/count));
      UI.println("Initial value was: " + initialTemp);
      UI.println("Final value was: " + temp);
      UI.printf("There were %d readings over the %.2f threshold \n" ,overThreshold, threshold);
      UI.printf("Largest change was: %.2f \n" , largestChange);
  }

  public void plotTempsCompletion() {
      UI.clearText();
      UI.clearGraphics();
      
      double threshold = UI.askDouble ("What is the threshold temperature: ");
      int count = 0;
      double left = 80;
      double top = 500;
      UI.drawLine(left,top,800,top); /**draw axes */
      
      
      while (count < 20 && UI.hasNextDouble()){
          double temp = UI.nextDouble();
          
          if (temp > threshold){ /**Any values greater than the threshold should be plotted with a red bar */
              UI.setColor(Color.red);
              UI.fillRect(left + count * 30,top-temp,20,temp);
          }          
          
          else if (temp > 300){ /**Any values greater than 300 should be plotted as if it were just 300 and with dark red bar */
              UI.setColor((Color.red).darker());
              UI.fillRect(left + count * 30,top-temp,20,300);
          }
          
          else if (temp < threshold){ /**Other values should be plotted with a green bar */
              UI.setColor(Color.green);
              UI.fillRect(left + count * 30,top-temp,20,temp);
          }
          
          count = count + 1;
      }

  }
}

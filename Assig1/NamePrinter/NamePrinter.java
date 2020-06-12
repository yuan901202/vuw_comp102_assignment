/* Code for Assignment 1, COMP 102
 * Name: Tianfu Yuan
 * Usercode: yuantian
 * ID: 300228072
 */

import comp102.*;
import java.awt.Color;

/** A very simple program that prints out a name in two different ways*/
public class NamePrinter {

  /** Print a nametag with a name inside a box made of asterisks */
  public void printNameTag() {
      String name = UI.askString("What is your name");
      UI.println("*********************************");
      UI.println("*                               *");
      UI.println("*  Hi I'm                       *");
      UI.println("*                               *");
      UI.println("*          " + name + "         *");
      UI.println("*                               *");
      UI.println("*********************************");
      UI.println();
     
  }


  /** Draw a nametag on the graphics pane
   *  The rectangular nametag is 300 units wide and 150 units high
   *  and the left edge is 100 units over and the top is 70 units down
   */
    public void drawNameTag(){
	String first_name = UI.askString("What first name do you want on your tag?");
	String last_name = UI.askString("What last name do you want on your tag?");
	UI.clearGraphics();                 // clears the graphics pane
	UI.setColor(Color.red);
	UI.drawOval(100, 70, 300, 150);      // draws the outline of a oval
	UI.setColor(Color.green);
	UI.drawString("Hi I'm", 120, 135);  // puts the string near the top
	UI.setColor(Color.black);
	UI.drawString(first_name + " " + last_name,  200, 170);     // puts the name near the center
	
    }


}

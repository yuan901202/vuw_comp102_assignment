/* Code for Assignment 3, COMP102 2012
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/** The NewObjectsExercise class has several simple methods
 that involve creating new objects and calling methods on those objects.
  - flowers() should create two or three Flower objects and
     make them grow and bloom
  - balloons() should create two Balloon objects and
     make them expand and pop
  - bankAccounts() should create two BankAccount objects and
     deposit to, withdraw from, and print statements of them
  - cars() should create two Car objects and make them
     drive towards each other then turn to the side and drive some more
  - studentMarks() should create two StudentMarkRecord objects and record
     several marks for each student and display their current assignment status
*/


public class NewObjectsExercise {

    /** Creates two or three Flower objects and makes them grow and bloom */
    public void flowers(){
	// YOUR CODE HERE
	Flower f1 = new Flower(100, 400);
	Flower f2 = new Flower(500, 350);
	f1.grow(20);
	f1.grow(20);
	f2.grow(50);
	f1.bloom();
	Flower f3 = new Flower(300, 300);
	f3.grow(20);
	f3.bloom();
	// END OF YOUR CODE
    }

    /** Creates two Balloon objects and makes them expand and pop */
    public void balloons(){
	// YOUR CODE HERE
	Balloon b1 = new Balloon(100,300);
	b1.expand();
	b1.expand();
	b1.expand();
	Balloon b2 = new Balloon(400,200);
	b2.expand();
	b2.expand();
	b1.expand();
	b1.pop();
	b2.expand();
	// END OF YOUR CODE
    }


    /** Creates two BankAccount objects and deposits to, withdraws from, and
	prints statements of them
    */
    public void bankAccounts(){
	// YOUR CODE HERE
	BankAccount b1 = new BankAccount("Justin");
	b1.deposit(1000);
	b1.statement();
	b1.withdraw(500);
	b1.statement();
	BankAccount b2 = new BankAccount("Janine");
	b2.deposit(2000);
	b2.deposit(500);
	b2.withdraw(20);
	b1.deposit(20);
	b1.statement();
	b2.statement();
	// END OF YOUR CODE
    }
 
    /**  Creates two Car objects and makes them	 drive towards
	 each other then turn to the side and drive some more.
    */
    public void cars(){
	// YOUR CODE HERE
	Car c1 = new Car(100,300, Color.red);
	Car c2 = new Car(400,300, Color.blue);
	c2.left();
	c2.left();
	c1.drive(20);
	c2.drive(20);
	c1.drive(20); 
	c2.drive(20);
	c1.drive(20);
	c2.drive(20);
	c1.drive(20);
	c2.drive(20);
	c1.drive(20);
	c2.drive(20);
	c1.drive(20);
	c2.drive(20);
	c1.right();
	c2.right();
	c1.drive(20);
	c2.drive(20);
	c1.drive(20);
	c2.drive(20);
	// END OF YOUR CODE
    }

    /** Creates two StudentMarkRecord objects and records several marks
	for each student and displays their current assignment status.
     */
    public void studentMarks(){
	// YOUR CODE HERE
	StudentMarkRecord s1 = new StudentMarkRecord("Justin");
	StudentMarkRecord s2 = new StudentMarkRecord("Janine");
	s1.recordMark(65);
	s2.recordMark(80);
	s1.display();
	s2.display();
	s1.recordMark(75);
	s1.display();
	s2.display();
	s1.recordMark(80);
	s2.recordMark(82);
	s1.display();
	s2.display();
	// END OF YOUR CODE
    }

}

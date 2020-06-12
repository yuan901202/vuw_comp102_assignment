/* Code for COMP102 Assignment 8 
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.util.*;


/**  A person has a name and the names of their mother and father.
 */
public class Person{
    // Fields
    private int ID;
    private String name;
    private int dob;      
    private int motherID;   
    private int fatherID;   

    // Constructors
    /** Construct a new Person object */
    public Person(int ID, String n, int dob, int m, int f){
	this.ID = ID;
	this.name = n;
	this.dob = dob;
	this.motherID = m;
	this.fatherID = f;
    }

    /** Construct a new Person object, reading field values from a scanner */
    public Person(Scanner scan){
	this.ID = scan.nextInt();
	this.name = scan.next();
	this.dob = scan.nextInt();
	this.motherID = scan.nextInt();
	this.fatherID = scan.nextInt();
    }

    // Methods
    /** Returns the ID of the person */
    public int getID(){
	return this.ID;
    }

    /** Returns the name of the person */
    public String getName(){
	return this.name;
    }

    /** Returns the ID of the mother of the person (-1 if not known) */
    public int getMotherID(){
	return this.motherID;
    }

    /** Returns the ID of the father of the person (-1 if not known) */
    public int getFatherID(){
	return this.fatherID;
    }

    public String toString(){
	return this.name+", born:"+this.dob;
    }

}

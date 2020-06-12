/* Code for COMP 102 Assignment 8 
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.util.*;
import java.io.*;


/** Reads a genealogy database from a file, and allows the user
     to display information about people in the database.
    Each line of the file (except the first) contains information
     about one person:
      - an ID number (an integer from 0 to 1 less than the number of persons)
      - their name
      - the year of their birth
      - the ID of their mother (or -1 if the mother is unknown)
      - the ID of their father (or -1 if the father is unknown)
    The first line in the file contains the number of Persons in the file
    Note, the entries are not necessarily in ID order.

    The program will read the data into an array of Person objects.
     Note, since the file specifies the number of people, and the
     program does not add or delete people, we do not need a count
     field - we can construct an array of the right size.

    The program then allows the user to print out
      - the names of all the people in the database
        (note, names are just the first name - no spaces)
      - date of birth of a given person
      - parents of a person (if known) and their dates of birth
      - the number of (known) children of a person and all their names
        and dates of birth.

 */

public class Genealogy implements UIButtonListener, UITextFieldListener{
    // Fields
    private Person[] db;  // array of Person objects recording the parents of a person
    private int currentID = -1;  // default is no selected person.

    /** Construct a new Genealogy object
     * and set up the GUI
     */
    public Genealogy(){
        UI.addButton("Reload DB", this);
        UI.addButton("All Names", this);
        UI.addTextField("Name", this);
        UI.addButton("Birth", this);
        UI.addButton("Parents", this);
        UI.addButton("Children", this);
        UI.addButton("GrandChildren", this);
        UI.addButton("Clear", this);
	this.loadDatabase("database.txt");
    }


    // GUI Methods

    /** Respond to button presses */
    public void buttonPerformed(String action){
        if (action.equals("Reload DB") ){
 	    this.loadDatabase(UIFileChooser.open("Choose database file"));
	}
        else if (action.equals("All Names") )     { this.printAllNames(); }
        else if (action.equals("Birth") )         { this.printPerson(); }
        else if (action.equals("Parents") )       { this.printParents(); }
        else if (action.equals("Children") )      { this.printChildren(); }
        else if (action.equals("GrandChildren") ) { this.grandChildren(); }
        else if (action.equals("Clear") )         { UI.clearText(); }
    }

    public void textFieldPerformed(String field, String value){
	if (field.equals("Name")){
	    this.setCurrentID(value);
	    UI.println("----------------------");
	}
    }


    /** Reads the data from the database file into an array.
        First reads the maximum ID from the file then
        creates an array of the right size.
        Then reads the data on each line,
        constructs a Person object, and
        puts the Person object into the correct cell of the array
        (specified by the person's ID number).
        The method may assume that the database is correctly formatted,
        and does not need to do any checking of the input.
    */
    public void loadDatabase(String filename){
	UI.printf("Reading Database from %s ....\n", filename);
        // YOUR CODE HERE
	File file = new File(filename);
        try{
            Scanner scan = new Scanner(file);
            int count = scan.nextInt();
            this.db = new Person[count];
            while (scan.hasNext()){
                Person p = new Person(scan);
                this.db[p.getID()] = p;
            }
            // END OF YOUR CODE
            scan.close();
            UI.println("Database loaded");
        }
        catch(IOException e){UI.println("Error while reading database file");}
    }

    /** Print out names of all the people in the database */
    public void printAllNames(){
	UI.println("All names:");
        // YOUR CODE HERE
        for (int id=0; id<this.db.length; id++){
	    UI.println(this.db[id].getName());
        }
        // END OF YOUR CODE
    }


    /** Looks for the ID of a person with the given name in the database.
        sets currentID to the index,
	if not found, prints message and sets currentID to -1.*/
    public void setCurrentID(String name){
        // YOUR CODE HERE
        for (int index=0; index<this.db.length; index++){
            if (this.db[index].getName().equalsIgnoreCase(name) ){
                this.currentID = index;
		return;
	    }
        }
        UI.println(name + " not in database");
	this.currentID = -1;
        // END OF YOUR CODE
    }

    /** Prints the name and year of birth of the currently selected person.
        [Note, the toString() method of the Person class returns a string
        containing the name and year of birth of the person.]
        If it doesn't find the name, prints a message.
    */
    public void printPerson(){
        // YOUR CODE HERE
        if (this.currentID>-1){
            UI.println(this.db[currentID].toString());
        }
        // END OF YOUR CODE
    }

    /** Prints the names of the mother and the father if they are known
        (or appropriate messages if they are unknown).
    */
    public void printParents(){
        // YOUR CODE HERE
        if (this.currentID>-1){
            Person p = this.db[this.currentID];
            int motherID = p.getMotherID();
            int fatherID = p.getFatherID();
      
            UI.println("Parents of "+p.getName()+ ":");
            if ( motherID >-1)
                UI.println("  mother = "+this.db[motherID].getName());
            else
                UI.println("  mother unknown");
            if ( fatherID >-1)
                UI.println("  father = "+this.db[fatherID].getName());
            else
                UI.println("  father unknown");
        }
        // END OF YOUR CODE
    }


    /** Prints the number of children of the given person,
        followed by the names and years of birth all the children.
        Searches the array for Persons who have the currently specified person as one of their parents.
        Any such person is added to an array.
        It then prints out the information from the array of children.
        [You may assume that no person has more than 20 children.]
      
    */
    public void printChildren(){
        // YOUR CODE HERE
        if (this.currentID>-1){
            Person[] children = new Person[20];
            int childCount = 0;
            for (int childID=0; childID<this.db.length; childID++){
                Person child = this.db[childID];
                if (child.getMotherID()==this.currentID  || child.getFatherID()==this.currentID){
                    children[childCount++]=child;
                }
            }
	    String name = this.db[this.currentID].getName();
	    if (childCount==1) { UI.printf("%s has 1 child:\n", name); }
	    else { UI.printf("%s has %d children:\n", name, childCount); }
            for (int c=0; c<childCount; c++){
                UI.println("  "+children[c].toString());
            }
        }
        // END OF YOUR CODE
    }

    /** Completion: Prints (to textArea) names of all grandchildren (if any) 
        of the currently specified person */
    public void grandChildren(){
        // YOUR CODE HERE
        if (this.currentID>-1){
	    Person p = this.db[this.currentID];
	    UI.printf("Grandchildren of %s:\n", p.getName());
	    for (Person ch : this.db){
		if (ch.getMotherID()==p.getID()  || ch.getFatherID()==p.getID()){
		    for  (Person gc : this.db){
			if (gc.getMotherID()==ch.getID()  || gc.getFatherID()==ch.getID()){
			    UI.println("" + gc.getName());
			}
		    }
		}
	    }
	    UI.println("-------------");
	    // END OF YOUR CODE
	}
    }


    // Main
    public static void main(String[] arguments){
        Genealogy g = new Genealogy();
    }   


}

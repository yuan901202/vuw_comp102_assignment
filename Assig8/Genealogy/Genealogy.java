/* Code for COMP 102 Assignment 8 
 * Name: Tianfu Yuan
 * Usercode: yuantian
 * ID: 300228072
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
        try{
            Scanner scan = new Scanner(new File(filename));
            db = new Person[scan.nextInt()];
            for(int n=0; n<db.length; n++){
                int ID = scan.nextInt();
                String name = scan.next();
                int birth = scan.nextInt();
                int mother = scan.nextInt();
                int father = scan.nextInt();
                db[ID] = new Person(ID, name, birth, mother, father);
            }
            scan.close();
            UI.println("Database loaded");
        }
        catch(IOException e){UI.println("Error while reading database file");}
    }

    /** Print out names of all the people in the database */
    public void printAllNames(){
    UI.println("All names:");
        // YOUR CODE HERE
        for(int n=0; n<db.length; n++){
            
            if(db[n] != null){
                UI.printf("%s\n", db[n].getName());
            }
        }
        UI.print("\n\nDone.");
    }


    /** Looks for the ID of a person with the given name in the database.
        sets currentID to the index,
    if not found, prints message and sets currentID to -1.*/
    public void setCurrentID(String name){
        // YOUR CODE HERE
        for(int n=0; n<db.length; n++){
            if(db[n].getName().equalsIgnoreCase(name)){
                currentID = db[n].getID();
                break;
            }
        }
    }

    /** Prints the name and year of birth of the currently selected person.
        [Note, the toString() method of the Person class returns a string
        containing the name and year of birth of the person.]
        If it doesn't find the name, prints a message.
    */
    public void printPerson(){
        // YOUR CODE HERE
        UI.println(db[currentID].toString());
    }

    /** Prints the names of the mother and the father if they are known
        (or appropriate messages if they are unknown).
    */
    public void printParents(){
        // YOUR CODE HERE
        int m = db[currentID].getMotherID();
        int f = db[currentID].getFatherID();
        if(m == -1){
            UI.println("Mother is unknown.");
        }
        
        if(f == -1){
            UI.println("Father is unknown.");
        }
    
        for(int n=0; n<db.length; n++){
            if(m == db[n].getID()){
                UI.printf("Mother: %s\n.", db[n].getName());
            }
            
            if(m == db[n].getID()){
                UI.printf("Father: %s\n.", db[n].getName());
            }
        }
        
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
        Person[] children = new Person[19];
        int count = 0;
        for(int n=0; n<db.length; n++){
            if(db[n].getMotherID() == currentID || db[n].getFatherID() == currentID){
                children[count] = db[n];
                count++;
            }
        }
        
        for(int n=0; n<children.length; n++){
            if(children[n] == null){
                break;
            }
            else{
                UI.println(children[n].toString());
            }
        }
    }

    /** Completion: Prints (to textArea) names of all grandchildren (if any) 
        of the currently specified person */
    public void grandChildren(){
        // YOUR CODE HERE
        //the follwoing code get help from tutors
        Person[] children = new Person[19];
        int count = 0;
        for(int n=0; n<db.length; n++){
            if(db[n].getMotherID() == currentID || db[n].getFatherID() == currentID){
                children[count] = db[n];
                count++;
            }
        }
        
        Person[] grandChildren = new Person[399];
        int count_2 = 0;
        for(int n=0; n<db.length; n++){
            for(int i=0; i<children.length; i++){
                if(children[i] == null){
                    break;
                }
                
                if(children[i].getID() == db[n].getMotherID() || children[i].getID() == db[n].getFatherID()){
                    grandChildren[count_2] = db[n];
                    count_2++;
                }
            }
        }
        
        for(int n=0; n<grandChildren.length; n++){
            if(grandChildren[n] == null){
                break;
            }
            else{
                UI.println(grandChildren[n].toString());
            }
        }
    }

    // Main
    public static void main(String[] arguments){
        Genealogy g = new Genealogy();
    }   


}

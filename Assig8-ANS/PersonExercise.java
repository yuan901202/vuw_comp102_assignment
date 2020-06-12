/* Code for COMP102 Assignment 8
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.util.*;
import java.io.*;


/** Creates an array that holds Person objects, with data read from the
    file "family.txt".
    Then allows the user to ask four questions about the people:
      What are their names
      Who is the mother of Catherine
      Who is the mother of Michael
      Who are the children of Michael
    Note: The family tree represented in the file has five people:
      Carole and Michael are the parents of Catherine, Philippa and James.
*/

public class PersonExercise implements UIButtonListener{

    Person[] data;

    /** Construct a new PersonExercise object:
     *	add the appropriate buttons to the UI */
    public PersonExercise(){
	UI.addButton("Load DB", this);
	UI.addButton("All Names", this);
	UI.addButton("Mother of Catherine", this);
	UI.addButton("Mother of Michael", this);
	UI.addButton("Children of Michael", this);
    }

    public void buttonPerformed(String button){
	if (button.equals("Load DB")) {
	    this.load();
	}
	else if (button.equals("All Names")) {
	    this.allNames();
	}
	else if (button.equals("Mother of Catherine")){
	    this.findMotherOf("Catherine");
	}
	else if (button.equals("Mother of Michael")){
	    this.findMotherOf("Michael");
	}
	else if (button.equals("Children of Michael")){
	    this.findChildrenOfFather("Michael");
	}
	UI.println("---------");
    }

	
    /** Read the first line of the file "family.txt" to find out how big to make the array.
     * make the array object in the field data.
     * Read each remaining line of the file, (id, name, dob, motherID, fatherID)
     *   constructing a Person object for the line
     *   and putting it in the data array at the appropriate index
     * Close the file and print "Loaded" when finished.
     * Note: the Person class has two constructors; you can choose to use either one
     */
    public void load(){
        try{
            Scanner scan = new Scanner(new File("family.txt"));
	    // YOUR CODE HERE
	    int count = scan.nextInt();
	    this.data = new Person[count];
	    while (scan.hasNext()){
		int id = scan.nextInt();
		String name = scan.next();
		int dob = scan.nextInt();
		int mID = scan.nextInt();
		int fID = scan.nextInt();
                Person p = new Person(id, name, dob, mID, fID);
		this.data[id] = p;
	    }
            scan.close();
	    UI.println("Loaded");
	// END OF YOUR CODE
        }
        catch(IOException e){UI.println("Error while reading database file");}
    }

    /** Print out the name and year of birth of each person in the array.
        Note, the Person class has a toString method that is useful.
    */
    public void allNames(){
	// YOUR CODE HERE
	for (int id=0; id<this.data.length; id++){
	    Person p = this.data[id];
	    UI.println(p.toString());
	}
	// END OF YOUR CODE
    }

    /** Steps through the array to find a person with the specified name
     *  Then print out that person's mother, if the mother is in the database
     *  otherwise print out "Mother unknown"
     */
    public void findMotherOf(String name){
	// YOUR CODE HERE
	for (int id=0; id<this.data.length; id++){
	    if ( this.data[id].getName().equals(name)) {
		int mID = this.data[id].getMotherID();
		if (mID > -1 ){
		    UI.println (this.data[mID]);
		}
		else {
		    UI.println ("Mother unknown");
		}
	    }
	}
	// END OF YOUR CODE
    }

    /** Steps through the array to find each person whose father has the specified name
     *  Prints out the name of each such person
     *  Note, for each person in the array, you need to get their father's id, and if
     *  it isn't -1, look up that id and see if their name is the specified one. */
    public void findChildrenOfFather(String name){
	// YOUR CODE HERE
	for (int id=0; id<this.data.length; id++){
	    Person p =this.data[id]; 
	    int fID = p.getFatherID();
	    if (fID > -1 && this.data[fID].getName().equals(name) ){
		UI.println (p.getName());
	    }
	}
	// END OF YOUR CODE
    }

}

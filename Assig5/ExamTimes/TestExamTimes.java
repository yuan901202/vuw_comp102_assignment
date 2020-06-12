/* Code for COMP 102 Assignment 5 
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.util.*;
import java.io.*;


/** For the demo and for testing the ExamTimes program. */

public class TestExamTimes implements UIButtonListener {

    private ExamTimes et = new ExamTimes();

    public TestExamTimes(){
	UI.addButton("Print file", this);
	UI.addButton("Course", this);
	UI.addButton("Session", this);
	UI.addButton("Possible Exams", this);
	UI.addButton("Daily Lists", this);
    }


    public void buttonPerformed(String button){
	UI.clearText();
	if (button.equals("Course") ){
	    String code = UI.askString("Enter course code (eg ACCY111):").toUpperCase();
	    et.printCourse(code);
	}
	else if (button.equals("Session") ){
	    int day = UI.askInt("Enter day (eg 18): ");
	    et.printSession(day);
	}
	else if (button.equals("Possible Exams") ){
	    int day = UI.askInt("Enter day (eg 20): ");
	    String name = UI.askString("Enter student's family name : ").toUpperCase();
	    et.printPossibleExams(day, name);
	}
	else if (button.equals("Daily Lists") ){
	    et.dailyLists();
	}
	else if (button.equals("Print file") ){
	    this.printFile();
	}
    }

    

    public void printFile(){
	try{
	    Scanner sc = new Scanner(new File("examdata.txt"));
	    while (sc.hasNextLine()){UI.println(sc.nextLine());}
	    sc.close();
	}
	catch(IOException e){UI.println("File reading failed: "+e);}
    }


  
    public static void main(String[] args){
	new TestExamTimes();
    }


}

/* Code for COMP 102 Assignment 5 
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.util.*;
import java.io.*;


/** Extracts and prints information from a file of exam timetable data.
    The timetable file is called "examdata.txt"
    Each line of the file specifies an exam room for a course.
    The format of the lines is the following:
      The first token is the course code
      The second token is the exam room
      The third token is the date (day of the month).
      The fourth token is the number of students in the room.
      The last two tokens give the range of names of students in that room.
        (ie,  students whose name is alphabetically between the first name
	 and the second name, inclusive)
    Where a course is too big to fit all the students in one room, there will be
    several lines for the course, one for each room.  The date and time of the
    exam will be the same on each line.

 */

public class ExamTimes {


    /** Reads the timetable file, printing out all the lines that involve
	the specified course
	(ie, all the lines whose first token matches the course)
    */
    public void printCourse(String targetCourse){
	// YOUR CODE HERE
	UI.printf("Exam room data for %s:\n",targetCourse);
	try{
	    Scanner fileScan = new Scanner(new File("examdata.txt"));
	    while (fileScan.hasNext()){
		String code = fileScan.next();
		String restOfLine = fileScan.nextLine();
		if (code.equals(targetCourse))
		    UI.println(code+"\t"+restOfLine);
	    }
	    fileScan.close();
	}
	catch(IOException e){UI.println("File reading failed: "+e);}
	UI.println("-----------------------");
	// END OF YOUR CODE
    }

    /** Reads the timetable file, printing out (to the UI window) all the
	course codes, rooms, and name ranges for exams on the specified date
	It will be best to read the six tokens on each line individually.
    */
    public void printSession(int targetDate){
	// YOUR CODE HERE
	UI.printf("\nExams on %d:\n\n", targetDate);
	try{
	    Scanner fileScan = new Scanner(new File("examdata.txt"));
	    while (fileScan.hasNext()){
		String code = fileScan.next();
		String room = fileScan.next();
		int date = fileScan.nextInt();
		int count = fileScan.nextInt();
		String startName = fileScan.next();
		String endName = fileScan.next();

		if ( date==targetDate ){
		    UI.printf("%s is in %s \t(%s to %s)\n", code, room, startName, endName);
		}
	    }
	    fileScan.close();
	}
	catch(IOException e){UI.println("File reading failed: "+e);}
	UI.println("-----------------------");
	// END OF YOUR CODE
    }


    /** Reads the timetable file and prints out all the exams (course
	and room) that the specified student could possibly be on the specified date
	(taking into account the range of names in the rooms).
    */
    public void printPossibleExams(int targetDate, String name){
	// YOUR CODE HERE
	UI.println("Possible rooms that "+ name + "  might be in:");

	try{
	    Scanner fileScan = new Scanner(new File("examdata.txt"));
	    boolean found = false;
	    while (fileScan.hasNext()){
		String code = fileScan.next();
		String room = fileScan.next();
		int date = fileScan.nextInt();
		int count = fileScan.nextInt();
		String startName = fileScan.next();
		String endName = fileScan.next();

		if ( date==targetDate && name.compareTo(startName)>=0 && name.compareTo(endName)<=0 ){
		    found = true;
		    UI.println(code +" in " + room);
		}
	    }
	    if (!found){
		UI.println("There are no exams that student could be in on that date");
	    }
	    fileScan.close();
	}
	catch(IOException e){UI.println("File reading or writing failed: "+e);}
	// END OF YOUR CODE
    }

    /** (Completion - harder)
	dailyLists writes a file listing, for each date, all the course codes with
	an exam on that date, along with the number of students in the course, and
	also the total number of students expected that date.
	It may assume that the dates (which are all in the same month) go from 1 to 22.
	It may also assume that the examdata.txt file is sorted by course code.*/
    public void dailyLists(){
	// YOUR CODE HERE
	try{
	    PrintStream fileOut = new PrintStream(new File("exams-by-session.txt"));
	    int targetDate = 1;
	    while (targetDate <= 22){
		Scanner fileScan = new Scanner(new File("examdata.txt"));
		int total = 0;
		int courseCount = 0;
		String lastCode = "";
		fileOut.printf("=============================\nExams on date %d:\n",
			       targetDate);
		UI.printf("=============================\nExams on date %d:\n",
				  targetDate);
		while (fileScan.hasNext()){
		    String code = fileScan.next();
		    String room = fileScan.next();
		    int date = fileScan.nextInt();
		    int count = fileScan.nextInt();
		    String names = fileScan.nextLine();
    
		    if (date==targetDate) {
			if (!code.equals(lastCode)){
			    if (!lastCode.equals("")){
				fileOut.println(lastCode+", "+ courseCount);
				UI.println(lastCode+", "+ courseCount);
			    }
			    courseCount = 0;
			    lastCode = code;
			}
			total = total + count;
			courseCount = courseCount + count;
		    }
		}
		if (total > 0){
		    fileOut.println(lastCode+", "+ courseCount);
		    UI.println(lastCode+", "+ courseCount);
		    
		    fileOut.printf("Total students expected = %d\n", total);
		    UI.printf("Total students expected = %d\n", total);
		}
		else {
		    fileOut.println("No exams");
		    UI.println("No exams");
		}
		fileScan.close();

		targetDate = targetDate+1;
	    }
	    fileOut.close();
	}
	catch(IOException e){UI.println("File reading or writing failed: "+e);}
	// END OF YOUR CODE
    }

    
 

    // main method, primarily for the markers.
    // Please don't modify this method.
    // You may call it if you wish, but you don't need to.
    public static void main(String[] args){
	TestExamTimes.main(null);
    }


}

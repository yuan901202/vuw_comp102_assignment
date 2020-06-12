/* Code for COMP 102 Assignment 5 
 * Name: Tianfu Yuan
 * Usercode: yuantian
 * ID: 300228072
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
        try{
            Scanner scan = new Scanner(new File("examdata.txt"));
            UI.println();
            UI.println("Exam room data for " + targetCourse);
            while (scan.hasNext()){
                String course = scan.next();
                if (course.equalsIgnoreCase(targetCourse)){
                    String nextLine = scan.nextLine();
                    UI.println(targetCourse + " " + nextLine);
                }
            }
        }catch(IOException e){UI.printf("File failure %s\n" , e);}
        UI.println("----------------------------------------");
    }

    /** Reads the timetable file, printing out (to the UI window) all the
    course codes, rooms, and name ranges for exams on the specified date
    It will be best to read the six tokens on each line individually.
    */
    public void printSession(int targetDate){
    // YOUR CODE HERE
        try{
            Scanner scan = new Scanner(new File("examdata.txt"));
            UI.println();
            UI.println("Exams on " + targetDate);
            UI.println();
            while (scan.hasNext()){
                String course = scan.next();
                String room = scan.next();
                int date = scan.nextInt();
                int number = scan.nextInt();
                String startName = scan.next();
                String endName = scan.next();
                if (date == targetDate){
                    UI.println(course + " is in " + room + "\t(" + startName + " to " + endName + ")");
                }
            }
        }catch(IOException e){UI.printf("File failure %s\n" , e);}
        UI.println("----------------------------------------");
    }


    /** Reads the timetable file and prints out all the exams (course
    and room) that the specified student could possibly be on the specified date
    (taking into account the range of names in the rooms).
    */
    public void printPossibleExams(int targetDate, String name){
    // YOUR CODE HERE
        try{
            Scanner scan = new Scanner(new File("examdata.txt"));
            UI.println();
            UI.println("Possible rooms that " + name + " might be in: ");
            while (scan.hasNext()){
                String course = scan.next();
                String room = scan.next();
                int date = scan.nextInt();
                int number = scan.nextInt();
                String startName = scan.next();
                String endName = scan.next();
                if (date == targetDate){
                    if (name.compareTo(startName) >= 0 && name.compareTo(endName) <= 0){
                        UI.println(course + " in " + room);
                    }
                }
            }
        }catch(IOException e){UI.printf("File failure %s\n" , e);}
        UI.println("----------------------------------------");
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
            String lastCourse = "";
            int firstDate = 0;
            PrintStream out = new PrintStream(new File("exams-by-session.txt"));

            for(int countDate = 1; countDate < 23; countDate++){
                int totalNumber = 0;
                int realNumber = 0;
                Scanner scan = new Scanner(new File("examdata.txt"));

                UI.println("========================================");
                UI.println("Exams on day " + countDate + ":");

                out.println("=======================================");
                out.println("Exams on day " + countDate + ":");            
                   //the following code get help from Zhihen Sun and tutors
                while (scan.hasNext()){
                    String course = scan.next();
                    scan.next();
                    int date = scan.nextInt();
                    int number = scan.nextInt();
                    scan.next();
                    scan.next();

                    if (date == countDate){
                        totalNumber = totalNumber + number;

                        if (course.equals(lastCourse)){
                            realNumber = realNumber + number;
                        } else {

                            if (firstDate != 0){
                                UI.println(lastCourse + ", " + realNumber);

                                out.println(lastCourse + ", " + realNumber);
                            }

                            lastCourse = course;
                            realNumber = number;
                            firstDate = date;
                        }
                    }
                }
                UI.println(lastCourse + ", " + realNumber);
                UI.println("Total students expected = " + totalNumber);

                out.println(lastCourse + ", " + realNumber);
                out.println("Total students expected = " + totalNumber);

                firstDate = 0;
            }    
            out.close();  
        }catch(IOException e){UI.printf("File failure %s\n" , e);}
        UI.println("=======================================");
    }

    // main method, primarily for the markers.
    // Please don't modify this method.
    // You may call it if you wish, but you don't need to.
    public static void main(String[] args){
        TestExamTimes.main(null);
    }

}

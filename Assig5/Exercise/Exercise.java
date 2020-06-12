/* Code for COMP102 Assignment 5
 * Name: pondy
 */

import comp102.*;

/** Class for the demo and to help you test the methods in your Exercise
    Note that you do not need to understand or modify this code.
*/
public class Exercise implements UIButtonListener{

    private FilesExercise fe = new FilesExercise();

    public Exercise(){
	UI.addButton("Print File", this);
	UI.addButton("sum numbers", this);
	UI.addButton("draw circles", this);
	UI.addButton("draw names", this);
	UI.addButton("large courses", this);
	UI.addButton("first words", this);
	UI.addButton("longest word", this);
	UI.addButton("total Order", this);
    }	

    public void buttonPerformed(String b){
	UI.clearText(); UI.clearGraphics();
	if (b.equals("print file")){fe.printFile();}
	else if (b.equals("sum numbers")){fe.sumNumbers();}
	else if (b.equals("draw circles")){fe.drawCircles();}
	else if (b.equals("draw names")){fe.drawNames();}
	else if (b.equals("large courses")){fe.largeCourses();}
	else if (b.equals("first words")){fe.firstWords();}
	else if (b.equals("longest word")){fe.longestWord();}
	else if (b.equals("total Order")){fe.totalOrder();}
    }

    public static void main(String[] args){
        Exercise ex = new Exercise();
    }


}

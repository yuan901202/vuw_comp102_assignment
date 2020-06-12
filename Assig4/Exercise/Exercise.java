/* Code for COMP102 2011T2 Assignment 4
 * Name: pondy
 */

import comp102.*;

/** Class for the demo and to help you test the methods in your Exercise
    Note that you do not need to understand or modify this code.
*/
public class Exercise implements UIButtonListener{

    private ExerciseConditionals ec = new ExerciseConditionals();
    private ExerciseLoops el = new ExerciseLoops();

    public Exercise(){
	UI.addButton("oddOrEven", this);
	UI.addButton("wordGame", this);
	UI.addButton("drawAFlag", this);
	UI.addButton("longestWord", this);
	UI.addButton("sumOneToN", this);
	UI.addButton("drawBubbles", this);
	UI.addButton("sumNumbers", this);
	UI.addButton("countWords", this);
	UI.addButton("multiplyNumbers", this);
    }	


    public void buttonPerformed(String b){
	UI.clearText(); UI.clearGraphics();
	if (b.equals("oddOrEven")){ec.oddOrEven();}
	if (b.equals("wordGame")){ec.wordGame();}
	if (b.equals("drawAFlag")){ec.drawAFlag();}
	if (b.equals("longestWord")){ec.longestWord();}
	if (b.equals("sumOneToN")){el.sumOneToN();}
	if (b.equals("drawBubbles")){el.drawBubbles();}
	if (b.equals("sumNumbers")){el.sumNumbers();}
	if (b.equals("countWords")){el.countWords();}
	if (b.equals("multiplyNumbers")){el.multiplyNumbers();}
    }

    public static void main(String[] args){
	new Exercise();
    }

}

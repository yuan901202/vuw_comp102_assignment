import comp102.*;

/** Program MazeMouse for COMP102  
 * Author:  pondy  <P>
 * Original Date: Jan 26, 1998  <P>
 * Revision: Feb 2006, Feb 2011  <P>
 * Description: Simulates a robot mouse in a maze.  <P>
 * The mouse can move forward (one step), turn left, or turn right  <P>
 * It can sense the cell in front of it and the cell on each side  <P>
 * The user can specify the behaviour of the mouse by listing sequences
 * of actions to respond to each of five events:  <P>
 * Space-ahead, space-to-left, space-to-right space-both-sides dead-end  <P>
 * The actions are specified by a string of M, L, R, and ?  <BR>
 * M is for "move forward"  <BR>
 * L is for "turn left"     <BR>
 * R is for "turn right"    <BR>
 * ? is for do a random choice of one of the other three actions  <BR>
 */

public class MazeMouse implements UIMouseListener, UIButtonListener, UISliderListener, UITextFieldListener {

    public static void main(String[] args){
        new MazeMouse();
    }

    private Maze maze = new Maze(13, 13);
    private Mouse mouse = new Mouse(maze);

    public MazeMouse(){
        UI.setMouseListener(this);

        UI.addButton("Restart", this);
        UI.addButton("Step", this);
        UI.addButton("Run", this);

        //The text fields and sliders
        UI.addTextField("Space ahead", this);
        UI.addTextField("Space only on left", this);
        UI.addTextField("Space only on right", this);
        UI.addTextField("Space on both sides", this);
        UI.addTextField("At dead end",  this);
        UI.addSlider("Speed", 1, 10, 9, this);
        UI.addSlider("Run for", 10, 200, 100, this);
        maze.draw();
        mouse.reset(); 
    }


    public void  mousePerformed(String action, double x, double y){
	if (action.equals("clicked")){maze.changeCell((int)x,(int)y);}
    }

    public void buttonPerformed(String b){
	if (b.equals("Restart")) {
	    mouse.reset();
	}
	else 	if (b.equals("Step")) {
	    mouse.step();
	}
	else 	if (b.equals("Run")) {
	    mouse.go();
	}
    }


    public void textFieldPerformed(String n, String cmd){
	if (n.equals("Space ahead")){
	    UI.printMessage("'Space ahead' is now "+cmd.toUpperCase());
	    mouse.setOnSpaceAhead(cmd);
	}
	else if (n.equals("Space only on left")){
	    UI.printMessage("'Space only on left' is now "+cmd.toUpperCase());
	    mouse.setOnSpaceToLeft(cmd);
	}
	else if (n.equals("Space only on right")){
	    UI.printMessage("'Space only on right' is now "+cmd.toUpperCase());
	    mouse.setOnSpaceToRight(cmd);
	}
	else if (n.equals("Space on both sides")){
	    UI.printMessage("'Space on both sides' is now "+cmd.toUpperCase());
	    mouse.setOnSpaceBothSides(cmd);
	}
	else if (n.equals("At dead end")){
	    UI.printMessage("'At dead-end' is now "+cmd.toUpperCase());
	    mouse.setOnDeadEnd(cmd);
	}
    }

    public void sliderPerformed(String name, double value){
	if (name.equals("Speed")){
	    mouse.setSpeed(value);
	}
	else if (name.equals("Run for")){
	    mouse.setSteps(value);
	}
    }

}

import comp102.*;

/** Mouse Class
   * Author:  pondy
   * Date: Modified Feb 2006, Feb 2011
   * Description: Provides a mouse that lives in a maze
   * The mouse contains strings that specify its behaviour in response to
   * starting, having a wall ahead, having a space ahead.
   * The mouse will move around the maze in response to a step or go method
   */

public class Mouse {

    private Maze maze;
    private Direction dir;
    private Coord posn;
    private double delay= 50;       // in milliseconds.
    private double stepsToRun= 100;
  
    private String onSpaceAhead;
    private String onSpaceToLeft;
    private String onSpaceToRight;
    private String onSpaceBothSides;
    private String onDeadEnd;
  
    public Mouse(Maze m){
	maze = m;
    }

    public void reset(){
	if (posn != null)
	    maze.drawCell(posn);
	posn = maze.startingPoint();
	dir = Direction.EAST;
	//Trace.printf("Mouse.reset: Resetting mouse at (%d, %d)@%s\n", posn.row, posn.col, dir);
	maze.drawMouse(posn, dir);
    }
  
    public void setOnSpaceAhead (String s){
	//Trace.printf("Mouse setOnSpaceAhead: %s\n", s);
	onSpaceAhead = s.toUpperCase();
    }

    public void setOnSpaceToLeft (String s){
	//Trace.printf("Mouse setOnSpaceToLeft: %s\n", s);
	onSpaceToLeft = s.toUpperCase();
    }

    public void setOnSpaceToRight (String s){
	//Trace.printf("Mouse setOnSpaceToRight: %s\n", s);
	onSpaceToRight = s.toUpperCase();
    }

    public void setOnSpaceBothSides (String s){
	//Trace.printf("Mouse setOnSpaceBothSides: %s\n", s);
	onSpaceBothSides = s.toUpperCase();
    }

    public void setOnDeadEnd (String s){
	//Trace.printf("Mouse setOnDeadEnd: %s\n", s);
	onDeadEnd = s.toUpperCase();
    }
  
  
    public void setSpeed (double num){
	//System.out.format("Mouse setSpeed: %d\n", num);
	if (num <1)
	    delay = 500;
	else if (num > 10)
	    delay = 0;
	else delay = 50 * (10 -num);
    }
  
    public void setSteps (double num){
	//System.out.format("Mouse setSteps: %d\n", num);
	stepsToRun =  num;
    }
  
    public void doAction(char act){
	// erase from current position
	maze.drawCell(posn);
	if (act == '?') {
	    double r = Math.random();
	    if (r < 0.3)
		act = 'L';
	    else if (r > 0.7)
		act = 'R';
	    else
		act = 'M';
	}
	//System.out.format("Mouse doAction: %c\n", act);
	if ((act == 'M')||(act == 'F')) {
	    if (maze.isSpace(posn.next(dir)))
		posn = posn.next(dir);
	}
	else if (act == 'L') dir = dir.left();
	else if (act == 'R') dir = dir.right();
	maze.drawMouse(posn, dir);
	if (delay>0) UI.sleep((int)delay);
    }
    
    public void step(){
	// check nose and choose action
	//Trace.printf("Mouse step: |%c|%c|%c|\n",
	//	     maze.isSpace(posn.next(dir.left()))?'_':'W',
	//	     maze.isSpace(posn.next(dir))?'_':'W',
	//	     maze.isSpace(posn.next(dir.right()))?'_':'W');
	String actionString;
	if (maze.isSpace(posn.next(dir))){
	    actionString = onSpaceAhead;
	    //System.out.format("Mouse step: space ahead: %s\n", actionString);
	}
	else if (maze.isSpace(posn.next(dir.left()))) {
	    if (maze.isSpace(posn.next(dir.right()))) {
		actionString = onSpaceBothSides;
		//System.out.format("Mouse step: space both sides: %s\n", actionString);
	    }
	    else {
		actionString = onSpaceToLeft;
		//System.out.format("Mouse step: space on left: %s\n", actionString);
	    }
	}
	else if (maze.isSpace(posn.next(dir.right()))) {
	    actionString = onSpaceToRight;
	    //System.out.format("Mouse step: space on right: %s\n", actionString);
	}
	else {
	    actionString = onDeadEnd;
	    //System.out.format("Mouse step: dead end: %s\n", actionString);
	}


	//System.out.format("Mouse step: do \"%s\"\n", actionString);
      
	// do each element of the action
	if (actionString != null) {
	    for (int i=0; i< actionString.length(); i++){
		this.doAction(actionString.charAt(i));
	    }
	}
    }

    public void go(){
	//System.out.format("Delay = %0.2f\n", delay);
	int steps = 0;
	while ((steps < stepsToRun) && !(maze.isOutside(posn)) ) {
	    this.step();
	    steps++;
	}
    }

    public static void main(String[] args){new MazeMouse();}

}



/* Code for COMP102 Assignment
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.awt.Color;
import java.util.*;
import java.io.*;


/** GoGame: Lets users play Go on a 19x19 board.
    The real Go board has a grid of 18x18 squares, and the stones are played on the
    corners of the squares.
    The code is slightly simpler if you have a 19x19 grid of squares and play the stones
    in the middle of the squares.
    */

public class GoGame
// YOUR CODE HERE
    implements UIButtonListener, UIMouseListener{

    private Color[][] board = new Color[19][19];
    
    private Color turn = Color.black;

    private static final Color boardColor = new Color(230, 120, 0);
    private static final double boardLeft = 50;
    private static final double boardTop = 20;
    private static final double gridSize = 25;
    private static final double numCells = 19;
    private static final double boardDim = gridSize*numCells;


    /** Construct a new GoGame object */
    public GoGame(){
	UI.addButton("Restart", this);
	UI.setMouseListener(this);
	this.redraw();
    }

    public void buttonPerformed(String button){
	if (button.equals("Restart")) {
	    this.board = new Color[19][19];
	    this.turn = Color.white;
	    this.redraw();
	}
    }

    public void mousePerformed(String action, double x, double y){
	if (action.equals("released") && x > boardLeft && y > boardTop){
	    int col = (int) ((x - boardLeft)/gridSize);
	    int row = (int) ((y - boardTop)/gridSize);
	    if (col < numCells && row < numCells){
		if (this.board[row][col] == null) {
		    this.board[row][col] = this.turn;
		    if (this.turn==Color.white){this.turn = Color.black;}
		    else                       {this.turn = Color.white;}
		}
		else {
		    this.board[row][col] = null;
		}
	    }
	}
	this.redraw();
    }

    public void drawStone(int row, int col, Color color){
	double x = boardLeft + col *gridSize;
	double y = boardTop + row *gridSize;
	UI.setColor(color);
	UI.fillOval(x+2, y+2, gridSize-4, gridSize-4, false);
	UI.setColor(Color.black);
	UI.drawOval(x+2, y+2, gridSize-4, gridSize-4, false);
    }

    public void redraw(){
	UI.setColor(boardColor);
	UI.fillRect(boardLeft, boardTop, boardDim, boardDim, false);
	UI.setColor(Color.black);
	for (int i=0; i<numCells-1; i++){
	    double x=boardLeft+gridSize*(i+0.5);
	    for (int j=0; j<numCells-1; j++){
		double y=boardTop+gridSize*(j+0.5);
		UI.drawRect(x, y, gridSize+1, gridSize+1, false);
	    }
	}
	for (int row=0; row<numCells; row++){
	    for (int col=0; col<numCells; col++){
		if (this.board[row][col] != null) {
		    drawStone(row, col, this.board[row][col]);
		}
	    }
	    
	}
	this.drawStone(0, -1, this.turn);
	UI.repaintGraphics();
    }

    public static void main(String[] arguments){
       GoGame obj = new GoGame();
    }	


}
// END OF YOUR CODE

/* Code for COMP102 Assignment 9
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.awt.Color;
import java.util.*;
import java.io.*;


/** Skipgo:  a game of chance with two kinds of win.
 * A Skipgo board is a 5 x 8 grid of cells that can be full or empty (black or white)
 * The board is represented by a 2D array of booleans.
 * You can win if the top row is completely empty
 * or if a column is completely full.
 * Each time you click the button, you get a new random board
 * The program should draw the board, and check for the two kinds of win.
 *
 * Much of the program is written for you; you should complete three methods:
 *   drawBoard:   draws a grid of black (full) and white (empty) squares
 *   topRowEmpty: returns true iff all the elements in the 0th row are false
 *   fullColumn:  returns true iff there is a column where all the elements are true
 */

public class Skipgo implements UIButtonListener{

    private int rows = 5;   // dimensions of board.
    private int cols = 8;
    private static final int boardLeft = 50;  // position of board
    private static final int boardTop = 20;
    private static final int cellSize = 30;  // size of each square.


    /** Construct a new Skipgo object */
    public Skipgo(){
	UI.addButton("New Skipgo Board", this);
    }

    /** Respond to the 'New Board' button
     *  (Completed for you)                 */
    public void buttonPerformed(String button){
	if (button.equals("New Skipgo Board")){
	    this.playBoard();
	}
    }

    /* Plays one round of Skipgo.
       creates a new board,
       draws the board
       checks for a top row empty win and for a full column win.
    */
    public void playBoard(){
	UI.clearText(); UI.clearGraphics();
	boolean[][] board = this.newBoard();
	this.drawBoard(board);
	if (this.topRowEmpty(board)){
	    this.reportTopRow();
	}
	int col = this.fullColumn(board);
	if (col > -1){
	    this.reportColumn(col);
	}
    }


    /* Draws the board
     *  Black square if the array element contains true;
     *  White square if the array element contains false.
     *  Cell (row,col) should be drawn at position
     *    (boardLeft+col*cellSize, boardTop+row*cellSize)
     */
    public void drawBoard(boolean[][] board){
	// YOUR CODE HERE
	for (int row=0; row<board.length; row++){
	    int y = boardTop + row * cellSize;
	    for (int col=0; col<board[row].length; col++){
		int x = boardLeft + col * cellSize;
		if (board[row][col]){
		    UI.fillRect(x, y, cellSize, cellSize, false);
		}
		else {
		    UI.drawRect(x, y, cellSize, cellSize, false);
		}
	    }
	}
	// END OF YOUR CODE
	UI.repaintGraphics();
    }

    /* Returns true if all the cells in the top row of 
     *  the board are false.  Otherwise, returns true.
     */
    public boolean topRowEmpty(boolean[][] board){
	// YOUR CODE HERE
	for (int col=0; col<board[0].length; col++){
	    if (board[0][col]) return false;
	}
	// END OF YOUR CODE
	return true;
    }

    /* If there is a column of the board that is all true,
     * then it returns the number of the column.
     * Otherwise, returns -1.
     * Note, if it finds a full column, it does not need to
     * check the remaining columns.
     */
    public int fullColumn(boolean[][] board){
	// YOUR CODE HERE
	for (int col=0; col<board[0].length; col++){
	    boolean ans = true;
	    for (int row=0; row<board.length; row++){
		if (!board[row][col]) { ans = false; }
	    }
	    if (ans) { return col; }
	}
	// END OF YOUR CODE
	return -1;
    }

    // THE FOLLOWING METHODS ARE ALREADY COMPLETED FOR YOU.
    
    /* Constructs a new random board.
       Cells in first row are black with 25% probability
       Cells in remaining rows are black with 50% probability
    */
    public boolean[][] newBoard(){
	boolean[][] ans = new boolean[rows][cols];
	for (int col=0; col<cols; col++){
	    ans[0][col] = (Math.random()< 0.25);
	}
	for (int row=1; row<rows; row++){
	    for (int col=0; col<cols; col++){
		ans[row][col] = (Math.random()< 0.5);
	    }
	}
	return ans;
    }

    /* Reports a top row win, and highlights the top row */
    public void reportTopRow(){
	UI.println("Top Row Win");
	UI.setColor(Color.red);
	UI.drawRect(boardLeft, boardTop, this.cols*cellSize, cellSize);
	UI.setColor(Color.black);
    }


    /* Reports a column win, and highlights the column */
    public void reportColumn(int col){
	UI.println("Column "+col+" Win");
	UI.setColor(Color.red);
	UI.drawRect(boardLeft+cellSize*col, boardTop, cellSize, this.rows*cellSize);
	UI.setColor(Color.black);
    }


    public static void main(String[] arguments){
	new Skipgo();
    }	


}

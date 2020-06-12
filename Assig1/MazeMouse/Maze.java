import comp102.*;
//import java.util.*;
//import javax.swing.*;
//import java.awt.event.*;
//import java.io.*;

/** Maze Class
 * Author:  pondy
 * Date:  Updated Feb 2006, Feb 2011
 * Description: Provides a maze consisting of a rectangular grid
 * of cells, each can be empty or full.
 */

public class Maze {

    /** walls is a two dimensional grid of cells. Currently, a cell can be a wall or a space.
     * True means that the cell has a wall in it *
     */

    private int numRows;
    private int numCols;
    private Cell[][] walls;
    private Coord startCoord;

    /**  variables controlling the display of the maze */
    private static int CellSize = 33;
    private static int MouseWd=12;
    private static int MouseHt=32;
    private static int MazeX = 50;
    private static int MazeY = 30;

    public Maze(int rows, int cols) {
        this.numRows = rows;
        this.numCols = cols;
        this.walls = new Cell[numRows][numCols];
        int r;
        int c;

        for (r = 0; r < numRows; r++)
            for (c = 0; c < numCols; c++)
                this.walls[r][c] = Cell.WALL;

        startCoord = new Coord(1, 1);

        // the exit:
        walls[numRows / 2][numCols-1] = Cell.SPACE;

        for (r = 1; r < numRows-1; r++) {
            walls[r][1] = Cell.SPACE;
            walls[r][numCols / 2] = Cell.SPACE;
            walls[r][numCols-2] = Cell.SPACE;
        }
        for (c = 1; c < numCols-1; c++) {
            walls[1][c] = Cell.SPACE;
            walls[numRows / 2][c] = Cell.SPACE;
            walls[numRows-2][c] = Cell.SPACE;
        }
        walls[numRows / 2][numCols / 2] = Cell.WALL;
    }

    private Coord cellCoord(int x, int y) {
        int row = (int)((y-MazeY) / CellSize);
        int col = (int)((x-MazeX) / CellSize);
        if (y < MazeY || x < MazeX || row >= numRows || col >= numCols)
            return null;
        else
            return new Coord(row, col);
    }

    private int cellX(Coord p) {
        if (p == null)
            return Integer.MAX_VALUE;
        else
            return MazeX+(p.col * CellSize);
    }

    private int cellY(Coord p) {
        if (p == null)
            return Integer.MAX_VALUE;
        else
            return MazeY+(p.row * CellSize);
    }

    public void invertCell(Coord p) {
        if (!this.isOutside(p))
            walls[p.row][p.col] = walls[p.row][p.col].invert();
    }

    public void draw() {
        Coord p = new Coord(0, 0);
        for (p.row = 0; (p.row < this.numRows); p.row++) {
            for (p.col = 0; (p.col < this.numCols); p.col++) {
                this.drawCell(p);
            }
        }
    }

    public void drawCell(Coord p) {
        if (p == null){}
        //System.out.println("Drawing null cell");
        else {
            int x = cellX(p);
            int y = cellY(p);
            if (this.isOutside(p) || (this.walls[p.row][p.col] == Cell.SPACE)){
                //System.out.format("Clearing cell(%d,%d) at (%d, %d) size %d\n", p.row, p.col, x, y, this.CellSize-1);
                UI.eraseRect(x, y, this.CellSize, this.CellSize);
            }
            else if (this.walls[p.row][p.col] == Cell.WALL){
                //System.out.format("Drawing cell(%d,%d) at (%d, %d) size %d\n", p.row, p.col, x, y, this.CellSize-1);
                UI.fillRect(x, y, this.CellSize, this.CellSize);
            }
        }
    }

    public void drawMouse(Coord p, Direction d) {
        if (p == null){
            //Trace.printf("Maze.drawMouse: Drawing mouse at null cell\n");
        }
        else if (d == null){
            //Trace.printf("Maze.drawMouse: Drawing mouse in null direction\n");
        }
        else {
            //Trace.printf("Maze.drawMouse: Drawing mouse at (%d, %d) @%s\n",p.col,p.row, d);
            int x = this.cellX(p);
            int y = this.cellY(p);
            if (d == Direction.NORTH) {
                UI.drawImage("mouse-north.jpg", x+this.CellSize/2-this.MouseWd/2, y, this.MouseWd, this.MouseHt);
            }
            else if (d == Direction.SOUTH) {
                UI.drawImage("mouse-south.jpg", x+this.CellSize/2-this.MouseWd/2, y, this.MouseWd, this.MouseHt);
            }
            else if (d == Direction.EAST) {
                UI.drawImage("mouse-east.jpg", x, y+this.CellSize/2-this.MouseWd/2,this.MouseHt, this.MouseWd);
            }
            else if (d == Direction.WEST) {
                UI.drawImage("mouse-west.jpg", x, y+this.CellSize/2-this.MouseWd/2,this.MouseHt, this.MouseWd);
            }
        }
        //Trace.printf("Maze.drawMouse: done\n");
    }

    public Coord startingPoint() {
        return startCoord;
    }

    public void changeCell(int x, int y) {
        Coord p = cellCoord(x, y);
        this.invertCell(p);
        this.drawCell(p);
    }

    public boolean isOutside(Coord p) {
        return (p == null) || (p.row < 0) || (p.row >= numRows) || 
        (p.col < 0) || (p.col >= numCols);
    }

    public boolean isSpace(Coord p) {
        return (this.isOutside(p) || (walls[p.row][p.col] == Cell.SPACE));
    }

    public static void main(String[] args){
        new MazeMouse();
    }

}

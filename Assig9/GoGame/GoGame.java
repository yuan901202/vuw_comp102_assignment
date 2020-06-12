/* Code for COMP102 Assignment
 * Name: Tianfu Yuan
 * Usercode: yuantian
 * ID: 300228072
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

public class GoGame implements UIMouseListener, UIButtonListener{
// YOUR CODE HERE
    private Color [][] board = new Color [19][19];
    private Color current = Color.black;
    private final int size = 22;
    private final int top = 50;
    private final int left = 50;
    private final int stone = 20;
    
    public GoGame(){
        UI.setMouseListener(this);
        UI.addButton("Restart", this);
        this.drawGrid();
    }
    
    public void mousePerformed(String action, double x, double y){
        if(action.equals("released")){            
            int x2 = (int)((x-this.left)/this.size);
            int y2 = (int)((y-this.top)/this.size);
            if(x2>0 && y2>0){
                int cols = (int)x2;
                int row = (int)y2;
                
                if(cols<19 && row<19){
                    if(this.board[row][cols] != null){
                        this.board[row][cols] = null;
                        this.drawGrid();
                    }
                    else{
                        if(this.current == Color.black){
                            this.current = Color.white;
                        }
                        else{
                            this.current = Color.black;
                        }
                        this.board[row][cols] = this.current;
                        this.drawGrid();
                    }
                }
            }
        }
    }
    
    public void buttonPerformed(String button){
        
        if(button.equals("Restart")){
            this.board = new Color [19][19];
            this.current = Color.black;
            this.drawGrid();
        }
               
    }
    
    //The following code get help from Zhihen Sun and tutors
    public void drawGrid(){
        //Draw the board
        UI.clearGraphics();
        UI.setColor(Color.orange);
        UI.fillRect(this.left, this.top, this.size*19, this.size*19, false);
            
        //Draw lines in the board
        UI.setColor(Color.black);
        for(int i=0; i<this.board.length; i++){
            UI.drawLine((this.left+this.size/2), (this.top+this.size/2+this.size*i), (this.left+this.size*19-this.size/2), (this.top+this.size/2+this.size*i), false);
            UI.drawLine((this.left+this.size/2+this.size*i), (this.top+this.size/2), (this.left+this.size/2+this.size*i), (this.top+this.size*19-this.size/2), false);
        }
        
        //Draw stones on the board
        for(int j=0; j<this.board.length; j++){
            for(int n=0; n<this.board[j].length; n++){
                if(this.board[j][n] != null){
                    UI.setColor(this.board[j][n]);
                    UI.fillOval((this.left+this.size*n+2), (this.top+this.size*j+2), this.stone, this.stone, false);
                }
            }
        }
        
        //Showing current color on the left-top of the board
        if(this.current == Color.black){
            UI.setColor(Color.white);
        }
        else{
            UI.setColor(Color.black);
        }
        
        UI.fillOval((this.left-this.size), this.top, this.stone, this.stone, false);
        UI.setColor(Color.black);
        UI.drawOval((this.left-this.size), this.top, this.stone, this.stone, false);
        UI.repaintGraphics();
            
    }
    
    public void restart(){
        UI.clearGraphics();
        this.drawGrid();
    }
}


/* Code for COMP102 Assignment 10
 * Name: Tianfu Yuan
 * Usercode: yuantian
 * ID: 300228072
 */

import comp102.*;
import java.io.*;
import java.util.*;
import java.awt.Color;

/** Dot represents a small circle shape of a fixed size (5 pixels).
 *  Implements the Shape interface.
 *  Needs fields to record the position, and colour.
 */

// YOUR CODE HERE
public class Dot implements Shape{
    private double x;
    private double y;
    private Color col;
    
    public Dot(double x, double y, Color col){
        this.x = x;
        this.y = y;
        this.col = col;
    }
    
    public Dot(Scanner data){
        this.x = data.nextDouble();
        this.y = data.nextDouble();
        int red = data.nextInt();
        int green = data.nextInt();
        int blue = data.nextInt();
        this.col = new Color(red, green, blue);
    }
    
    public boolean on(double u, double v){
        return(Math.hypot(u-this.x, v-this.y) < 3);
    }
    
    public void moveBy(double dx, double dy){
        this.x += dx;
        this.y += dy;
    }
    
    public void resize (double changeWd, double changeHt){
    }
    
    public void redraw(){
        UI.setColor(col);
        UI.fillOval(this.x-2, this.y-2, 5, 5, false);
    }
    
    public String toString(){
        return("Dot " + this.x + " " + this.y + " " + this.col.getRed() + " " + this.col.getGreen() + " " + this.col.getBlue());
    }
}
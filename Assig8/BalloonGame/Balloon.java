/* Code for COMP 102 Assignment 8
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.util.*;
import java.awt.Color;
import java.io.*;


/** Represents a balloon that can grow until it bursts.
 */
public class Balloon{
    // Fields
    private double radius = 10;
    private double centerX, centerY;
    private Color color;


    // Constructors
    /** Construct a new Balloon object. 
	Parameters are the coordinates of the center of the balloon 
    */
    public Balloon(double x, double y){
	this.centerX = x;
	this.centerY = y;
	this.color = Color.getHSBColor((float)Math.random(), 1.0f, 1.0f);
    }

    public void draw(){
	UI.setColor(color);
	UI.fillOval(centerX-radius, centerY-radius, radius*2, radius*2);
	UI.setColor(Color.black);
	UI.drawOval(centerX-radius, centerY-radius, radius*2, radius*2);
    }
    
    /** Make the balloon larger by a random amount between 4 and 10*/
    public void expand(){
	this.radius = this.radius + (Math.random()*6 + 4);
	this.draw();
    }

    /** Returns true if the point (x,y) is on the balloon, and false otherwise */
    public boolean on(double x, double y){
	double dx = this.centerX - x;
	double dy = this.centerY - y;
	return ((dx*dx + dy*dy) < (this.radius * this.radius));
    }

    /** Returns true if this Balloon is touching the other balloon, and false otherwise */
    public boolean touches(Balloon other){
	double dx = other.centerX - this.centerX;
	double dy = other.centerY - this.centerY;
	double dist = other.radius + this.radius;
	return (Math.hypot(dx,dy) < dist);
    }

  
    /** Calculates and returns the area of the balloon */
    public double size(){
	return  this.radius * this.radius * Math.PI;
    }

    /** pop the balloon (draws it in gray, and pauses briefly)*/
    public void pop(){
	UI.setColor(Color.lightGray);
	UI.fillOval(centerX-radius, centerY-radius, radius*2, radius*2);
	UI.sleep(20);
    }
    
  

}

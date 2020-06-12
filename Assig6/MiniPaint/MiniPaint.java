/* Code for COMP 102 Assignment 6
 * Name: Tianfu Yuan
 * Usercode: yuantian
 * ID: 300228072
 */

import comp102.*;
import java.awt.Color;
import javax.swing.JColorChooser;

public class MiniPaint implements UIButtonListener, UIMouseListener{

    // fields to remember
    //  the current shape that will be drawn when the mouse is next released.
    //  whether filled or not
    //  the position the mouse was pressed, 
    //  the name of the image file
    // YOUR CODE HERE
    private String object = null;
    private boolean filled = false;
    private double posX = 0;
    private double posY = 0;
    private String image = null;
    private Color colour = Color.black;
    
    //Constructor
    /** Sets up the user interface - mouselistener and buttons */
    public MiniPaint(){
    // YOUR CODE HERE
        UI.setMouseListener(this);
        UI.addButton("Line",this);
        UI.addButton("Rect",this);
        UI.addButton("Oval",this);
        UI.addButton("Image",this);
        UI.addButton("Colour",this);
        UI.addButton("Fill/NoFill",this);
        UI.addButton("Clear",this);
        UI.addButton("Bubbles",this);
        
    }

    /* Respond to button presses */
    public void buttonPerformed(String cmd){
    // YOUR CODE HERE
        if(cmd.equals("Line")){
            object = "line";
        }
        
        if(cmd.equals("Rect")){
            object = "rect";
        }
        
        if(cmd.equals("Oval")){
            object = "oval";
        }
        
        if(cmd.equals("Image")){
            object = "image";
            image = UIFileChooser.open();
        }
        
        if(cmd.equals("Colour")){
            colour = JColorChooser.showDialog(null,"Choose Colour",colour);
            UI.setColor(colour);
        }
        
        if(cmd.equals("Fill/NoFill")){
            if(filled == (false)){
                filled = true;
            }
            else{
                filled = false;
            }
        }
        
        if(cmd.equals("Clear")){
            UI.clearGraphics();
        }
        
        if(cmd.equals("Bubbles")){
            object = "bubbles";
        }
        
    }

    /** Respond to mouse events */
    public void mousePerformed(String action, double x, double y) {
    // YOUR CODE HERE
        if(object.equals("line")){
            
            if(action.equals("pressed")){
                posX = x;
                posY = y;
            }
            else if(action.equals("released")){
                UI.drawLine(posX, posY, x, y);    
            }

        }
        
        if(object.equals("rect")){
            
            if(action.equals("pressed")){
                posX = x;
                posY = y;
            }
            else if(action.equals("released")){
                
                if(posX<x && posY<y){
                    
                    if(filled == false){
                        UI.drawRect(posX, posY, x-posX, y-posY);
                    }
                    else{
                        UI.fillRect(posX, posY, x-posX, y-posY);
                    }
                }
                else if(posX>x && posY>y){ 
                    
                    if(filled == false){
                        UI.drawRect(x, y, posX-x, posY-y);
                    }
                    else{
                        UI.fillRect(x, y, posX-x, posY-y);
                    }
                }
                else if(posX<x && posY>y){ 
                    
                    if(filled == false){
                        UI.drawRect(posX, y, x-posX, posY-y);
                    }
                    else{
                        UI.fillRect(posX, y, x-posX, posY-y);
                    }
                }
                else if(posX>x && posY<y){ 
                    
                    if(filled == false){
                        UI.drawRect(x, posY, posX-x, y-posY);
                    }
                    else{
                        UI.fillRect(x, posY, posX-x, y-posY);
                    }
                }
            }
            
        }
        
        if(object.equals("oval")){
            
            if(action.equals("pressed")){
                posX = x;
                posY = y;
            }
            else if(action.equals("released")){
                
                if(this.posX<x && this.posY<y){
                    
                    if(filled == false){
                        UI.drawOval(posX, posY, x-posX, y-posY);
                    }
                    else{
                        UI.fillOval(posX, posY, x-posX, y-posY);
                    } 
                }
                else if(posX>x && posY>y){ 
                    
                    if(filled == false){
                        UI.drawOval(x, y, posX-x, posY-y);
                    }
                    else{
                        UI.fillOval(x, y, posX-x, posY-y);
                    }
                }
                else if(posX<x && posY>y){
                    
                    if(filled == false){
                        UI.drawOval(posX, y, x-posX, posY-y);
                    }
                    else{
                        UI.fillOval(posX, y, x-posX, posY-y);
                    }
                }
                else if(posX>x && posY<y){ 
                    
                    if(filled == false){
                        UI.drawOval(x, posY, posX-x, y-posY);
                    }
                    else{
                        UI.fillOval(x, posY, posX-x, y-posY);
                    }
                }
            }

        }
        
         if(object.equals("image")){
             
            if(action.equals("clicked")){
                UI.drawImage(image, x, y);
            }
            
        }

        if(object.equals("bubbles")){
            
            if(action.equals("clicked")){
                double size = 10;
                double bubY = y;
                
                while(bubY>0){
                    
                    if(filled == false){
                        UI.drawOval(x-(size/2), bubY-(size/2), size, size);
                    }
                    else{
                        UI.fillOval(x-(size/2), bubY-(size/2), size, size);
                    }
                    size = size + 5;
                    bubY = bubY - size;
                    
                }
            }
            
        }
    }
    
}

  
    /* Helper methods for drawing the shapes, if you choose to define them */
    // YOUR CODE HERE

  // Main:  constructs new MiniPaint object
  //public static void main(String[] arguments){
    //MiniPaint ob = new MiniPaint();
 // } 


//}

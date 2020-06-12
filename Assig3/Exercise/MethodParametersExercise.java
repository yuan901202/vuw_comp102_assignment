/* Code for Assignment 3, COMP102 2012
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.awt.Color;

/** The MethodParametersExercise class has several methods that could be
greatly simplified by creating new methods and calling them several times.

- nameTags() prints out a series of nametags for workshop participants.
Each nametag has the participant's name and workshop ID number.
It would be better if it called a drawNameTag method five times. 

- signalZeroFlag() draws the flag used by the US navy to signal the
value "zero", which is a white square with five small blue crosses,
laid out like the dots on the "5" side of ordinary dice.
It would be better if it called a drawCross method five times. 

- bottleSong() prints out the words to a traditional repetitive song.
It would be better if it called a bottleSongVerse method 10 times.

 */

public class MethodParametersExercise {

    public void nameTag(){
        this.drawNameTag("John Smith",325);
        this.drawNameTag("Jason Strickland",218);
        this.drawNameTag("Jane Salisor",15);
        this.drawNameTag("Jie Song",123);
        this.drawNameTag("Julia Sargeant",248);
    }
    
    public void drawNameTag(String name,int number){
        UI.println();
        UI.println("+-------------------------------+");
        UI.println("| The Programming Workshop 2011 |");
        UI.println("|                               |");
        UI.println("|  HELLO, my name is            |");
        UI.println("|                               |");
        UI.printf("|   %20s        |\n" , name);
        UI.println("|                               |");
        UI.printf("| # %3d                         |\n" , number);
        UI.println("+-------------------------------+");
        
    }   
    

    

    /** Prints out the words to a traditional repetitive song. */
    public void bottleSong(){
        this.bottleSongVerse(10);
        this.bottleSongVerse(9);
        this.bottleSongVerse(8);
        this.bottleSongVerse(7);
        this.bottleSongVerse(6);
        this.bottleSongVerse(5);
        this.bottleSongVerse(4);
        this.bottleSongVerse(3);
        this.bottleSongVerse(2);
        this.bottleSongVerse(1);
        
    }
    public void bottleSongVerse(int num){
        UI.println(num + " green bottles, hanging on the wall,");
        UI.println(num + " green bottles, hanging on the wall,");
        UI.println("And if one green bottle, should accidently fall,");
        UI.println("There'd be "+ (num-1) + " green bottles, hanging on the wall,");
        UI.println();

    }

    


    /** Draws the flag used by the US navy to signal the value "zero":
    a white square with five little blue crosses on it (laid out like the
    dots on the "5" side of ordinary dice).
    See http://www.navy.mil/navydata/communications/flags/num0.gif
     */
    public void signalZeroFlag(){
        this.drawCross();
    }
        
    public void drawCross(){
        double flagSize = UI.askDouble("Size of flag:");
        double left = 200;
        double top = 100;
        
        double centerX = left+flagSize/2;
        double centerY = top+flagSize/2;
        double offset = 0.3*flagSize;
        double crossSize = 0.15*flagSize;
        double crossThick = 0.05*flagSize;

        UI.setColor(Color.white);
        UI.fillRect(left, top, flagSize, flagSize);
        UI.setColor(Color.black);
        UI.drawRect(left, top, flagSize, flagSize);
        
        double leftHoriz = (centerX)-crossSize/2.0;
        double topHoriz = (centerY)-crossThick/2.0;
        double leftVert = (centerX)-crossThick/2.0;
        double topVert = (centerY)-crossSize/2.0;
        UI.setColor(Color.blue);
        UI.fillRect(leftHoriz, topHoriz, crossSize, crossThick);
        UI.fillRect(leftVert, topVert, crossThick, crossSize);
        
        
    }
        
        

        //first cross
     
        //top left cross
    leftHoriz = (centerX - offset) - crossSize/2;
    topHoriz  = (centerY - offset) - crossThick/2;
    leftVert  = (centerX - offset) - crossThick/2;
    topVert   = (centerY - offset) - crossSize/2;
        UI.setColor(Color.blue);
        UI.fillRect(leftHoriz, topHoriz, crossSize, crossThick);
        UI.fillRect(leftVert, topVert, crossThick, crossSize);

        //top right cross
        leftHoriz = (centerX + offset) - crossSize/2;
    topHoriz  = (centerY - offset) - crossThick/2;
        leftVert  = (centerX + offset) - crossThick/2;
    topVert   = (centerY - offset) - crossSize/2;
        UI.setColor(Color.blue);
        UI.fillRect(leftHoriz, topHoriz, crossSize, crossThick);
        UI.fillRect(leftVert, topVert, crossThick, crossSize);

        //bottom left cross
        leftHoriz = (centerX - offset) - crossSize/2;
    topHoriz  = (centerY + offset) - crossThick/2;
        leftVert  = (centerX - offset) - crossThick/2;
    topVert   = (centerY + offset) - crossSize/2;
        UI.setColor(Color.blue);
        UI.fillRect(leftHoriz, topHoriz, crossSize, crossThick);
        UI.fillRect(leftVert, topVert, crossThick, crossSize);

        //bottom right cross
        leftHoriz = (centerX + offset) - crossSize/2;
    topHoriz  = (centerY + offset) - crossThick/2;
        leftVert  = (centerX + offset) - crossThick/2;
    topVert   = (centerY + offset) - crossSize/2;
        UI.setColor(Color.blue);
        UI.fillRect(leftHoriz, topHoriz, crossSize, crossThick);
        UI.fillRect(leftVert, topVert, crossThick, crossSize);
    }

    
 
}

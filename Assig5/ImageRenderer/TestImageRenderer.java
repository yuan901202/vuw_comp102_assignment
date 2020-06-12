/* Code for COMP102 Assignment 5 2012
 * Name: Pondy
 */

import comp102.*;
import java.awt.Color;
import java.util.*;
import java.io.*;


/** TestImageRenderer   */

public class TestImageRenderer implements UIButtonListener{

    private ImageRenderer ir = new ImageRenderer();

    public TestImageRenderer(){
	UI.initialise();
	UI.addButton("Core", this);
	UI.addButton("Completion", this);
    }

    public void buttonPerformed(String b){
	UI.clearText();
	UI.clearGraphics();
	if (b.equals("Core")){
	    ir.renderImage();
	}
	else if (b.equals("Completion")){
	    ir.renderAnimatedImage();
	}
    }

    public static void main(String[] arguments){
	new TestImageRenderer();
    }
}


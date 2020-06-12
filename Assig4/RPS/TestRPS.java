/* Code for COMP102 Assignment 4
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.awt.Color;
import java.util.*;
import java.io.*;


/** TestRPS   */

public class TestRPS implements UIButtonListener{

    private  RPS rps = new RPS();

    public TestRPS(){
	UI.initialise();
	UI.addButton("One Round", this);
	UI.addButton("Core", this);
	UI.addButton("Completion", this);
	UI.addButton("Clear", this);
    }

    public void buttonPerformed(String b){
	if (b.equals("Clear")){
	    UI.clearText();
	    UI.clearGraphics();
	}
	else if (b.equals("One Round")){
	    rps.playRound();
	}
	else if (b.equals("Core")){
	    rps.playRPSGame();
	}
	else if (b.equals("Completion")){
	    rps.playRPS2();
	}
    }

    public static void main(String[] arguments){
	new TestRPS();
    }
}


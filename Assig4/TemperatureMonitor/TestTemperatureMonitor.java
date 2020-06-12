/* Code for COMP102 Assignment 4 2012
 * Name: pondy
 */
import comp102.*;

public class TestTemperatureMonitor implements UIButtonListener{


    TemperatureMonitor tm = new TemperatureMonitor();

    public TestTemperatureMonitor(){
	UI.initialise();
	UI.addButton("Core Analysis", this); 
	UI.addButton("Core Plot", this);
	UI.addButton("Completion Analysis", this);
	UI.addButton("Completion Plot", this);
    }
	
    public void buttonPerformed(String b){
	if (b.equals("Core Analysis")) {
	    tm.analyseTemps();
	}
	else if (b.equals("Core Plot")) {
	    tm.plotTemps();
	}
	else if (b.equals("Completion Analysis")) {
	    tm.analyseTempsCompletion();
	}
	else if (b.equals("Completion Plot")) {
	    tm.plotTempsCompletion();
	}
    }

    public static void main(String[] args){
	new TestTemperatureMonitor();
    }
}

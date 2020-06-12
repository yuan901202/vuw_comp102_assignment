/* Code for COMP102 2012T1 Assignment 2
 * Name: pondy
 */

import comp102.*;

/** Class for the demo and to help you test the methods in your Exercise
    Note that you do not need to understand or modify this code.
*/
public class Exercise implements UIButtonListener{
 
    private CalculatorExercise ce = new CalculatorExercise();
    private FlagExercise fe = new FlagExercise();

    public Exercise(){
        UI.addButton("milesToKilometers", this);
        UI.addButton("triangleArea", this);
        UI.addButton("gramsToOunces", this);
        UI.addButton("sphereArea", this); 
        UI.addButton("kelvinToFahrenheit", this);
        UI.addButton("orderOfPeppers", this);

        UI.addButton("franceFlag", this); 
        UI.addButton("bangladeshFlag", this);
        UI.addButton("indonesiaFlag", this);
        UI.addButton("austriaFlag", this);
        UI.addButton("japanFlag", this);
        UI.addButton("nigerFlag", this);
    }   


    public void buttonPerformed(String b){
        UI.clearText();
        UI.clearGraphics();
        if (b.equals("milesToKilometers")){ ce.milesToKilometers(); }
        else if (b.equals("triangleArea")){ ce.triangleArea(); }
        else if (b.equals("gramsToOunces")){ ce.gramsToOunces(); }
        else if (b.equals("sphereArea")){ ce.sphereArea(); }
        else if (b.equals("kelvinToFahrenheit")){ ce.kelvinToFahrenheit(); }
        else if (b.equals("orderOfPeppers")){ ce.orderOfPeppers(); }
        else if (b.equals("franceFlag")){ fe.franceFlag(); }
        else if (b.equals("bangladeshFlag")){ fe.bangladeshFlag(); }
        else if (b.equals("indonesiaFlag")){ fe.indonesiaFlag(); }
        else if (b.equals("austriaFlag")){ fe.austriaFlag(); }
        else if (b.equals("japanFlag")){ fe.japanFlag(); }
        else if (b.equals("nigerFlag")){ fe.nigerFlag(); }
    }

    public static void main(String[] arguments){
	new Exercise();
    }

}

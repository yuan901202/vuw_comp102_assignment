/* Code for COMP 102 Assignment 2 2012
 * Name: Tianfu Yuan
 * Usercode: yuantian
 * ID: 300228072
 */

import comp102.*;

/** Program for calculating various things
    Some methods convert between two units
    Other methods perform other simple calculations*/
public class CalculatorExercise{

    /** Convert from miles to kilometers */
    public void milesToKilometers(){
        double miles = UI.askDouble("Miles:");
        double kilometers = (miles * 1.609);
        UI.println("->" + kilometers + " kilometers");
    }




}

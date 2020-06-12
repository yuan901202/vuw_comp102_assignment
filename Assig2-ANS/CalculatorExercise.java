/* Code for COMP 102 Assignment 2 2012
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;

/** Program for calculating various things
    Some methods convert between two units
    Other methods perform other simple calculations*/
public class CalculatorExercise{

    /** Convert from miles to kilometers */
    public void milesToKilometers(){
    // YOUR CODE HERE
	double miles = UI.askDouble("Miles: ");
	double kilometers = miles * 1.609;
	UI.println(" = " + kilometers + " kilometers");
    }	

    /** Calculate area of triangle
    */
    public void triangleArea(){
	double base = UI.askDouble("length of triangle base:");
	double height = UI.askDouble("height of triangle:");
	double area = (base * height / 2 );
	UI.println("area = " + area);
    }

    /** Convert from grams to ounces
     */
    public void gramsToOunces(){
	double grams = UI.askDouble("Grams:");
	double ounces = (grams / 28.349 );
	UI.println(" = " + ounces + "oz");
    }

    /** Compute surface of a sphere */
    public void sphereArea(){
	double rad = UI.askDouble("Radius of the sphere:");
	double area = (rad*rad * 4 * 3.14159);
	UI.println("Surface area = " + area);
    }



    /** Convert from kelvin to fahrenheit t */
    public void kelvinToFahrenheit(){
	double kelvin = UI.askDouble("Temperature in degrees Kelvin:");
	double fahren = (kelvin * 9 / 5 - 459.67);
	UI.println(" = " + fahren + " fahrenheit");
    }

    /** Compute cost of order of peppers */
    public void orderOfPeppers(){
	double num = UI.askDouble("How many peppers:");
	double unit = UI.askDouble("Unit cost of peppers (in cents):");
	double cost = (num * unit)/100;
	UI.println("Order will cost $" + cost);
    // END OF YOUR CODE
    }




}

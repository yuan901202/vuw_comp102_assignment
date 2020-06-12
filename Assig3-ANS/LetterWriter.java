/* Code for COMP102 Assignment 3, 2012
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.awt.Color;
import java.util.*;
import java.io.*;


/** LetterWriter: Writes a series of marketing letters, each one tailored to the recipient  */

public class LetterWriter{

    /** Write out a series of at least five marketing letters. Each letter should
        be addressed to a different person and should use their name several times in
	the letter. Each letter should be marketing a different product at 60% off its
	retail price. Both the retail price and the discount price should be included
	in the letter. 
    */
    public void writeLetters(){
	// YOUR CODE HERE
	this.writeALetter("Paul", "grass catchers from Blunt Mowers", 245.00);
	this.writeALetter("Jane", "face mud made by Old Dirt", 107.50);
	this.writeALetter("Jim", "ceiling wipes from Dark Sky ", 33.75);
	this.writeALetter("Petra", "television curtains by New Control", 88.99);
	this.writeALetter("Tim", "headphones from Breaking Drums", 435.00);
    }

    /** Write a single marketing letter offering a 60% discount on a product.
	The parameters are the person's given name and family name,
	the name of the product, the normal retail price, and the number of
	items required for the further discount.
    */
    public void writeALetter(String name, String product, double price){
	UI.printf("Dear %s,\n", name);
	UI.printf("   You have been especially selected from the people of Wellington to\n");
	UI.printf("receive a special offer for %s. \n", product);
	UI.printf("%s is a premium brand product and retails for $%4.2f.  \n",
		  product, price);
	UI.printf("But, %s, if you order your %s today, you can purchase it\n", name, product);
	UI.printf("for just $%4.2f, a savings of 60%%!\n", price*0.4);
	UI.printf("Hurry today and send in your order for %s and make these fantastic savings\n", product);
	UI.println();
	UI.println();
	// END OF YOUR CODE
    }

    /** Write out a series of at least five marketing letters. Each letter should
        be addressed to a different person and should use their name several times in
	the letter. Each letter should be marketing a different product at 60% off its
	retail price. Both the retail price and the discount price should be included
	in the letter. There should be an additional discount for larger orders.
	The number of items required for a "larger" order will be different for each letter.
    */
    public void writeLettersCompletion(){
	// YOUR CODE HERE
	this.writeALetterCompl("Paul", "Andrews", "grass catcher", "Blunt Mowers", 245.00, 2);
	this.writeALetterCompl("Jane", "Johnston", "face mud", "Old Dirt", 107.50, 5);
	this.writeALetterCompl("Jim", "Allison", "ceiling wipe", "Dark Sky", 33.75, 20);
	this.writeALetterCompl("Petra", "Jaynes", "television curtains", "New Control", 88.99, 7);
	this.writeALetterCompl("Tim", "Wang", "headphones", "Anoia", 435.00, 2);
    }

    /** Write a single marketing letter offering a 60% discount on a product.
	The parameters are the person's given name and family name,
	the name of the product and the manufacturer, the normal retail price, and the number of
	items required for the further discount.
    */
    public void writeALetterCompl(String givenName, String familyName, String product, String manufacturer, double price, int largeOrder){
	UI.printf("Dear %s,\n", givenName, familyName);
	UI.printf("   You have been especially selected from the people of Wellington to\n");
	UI.printf("receive a special offer for %s. \n", product);
	UI.printf("%ss from %s are a premium brand product and retails for $%4.2f.  \n",
		  this.capitalise(product), manufacturer, price);
	UI.printf("But, %s, if you order your %s today, you can purchase it\n", givenName, product);
	UI.printf("for just $%4.2f, a savings of 60%%!\n", price*0.4);
	UI.printf("As a special bonus, just for the %s family, if you order %d %ss today,\n",
		  familyName, largeOrder, product);
	UI.printf("you will get an additional 10%% off - an amazing price for %s of just $%4.2f!\n", product, (price*0.3));
	UI.printf("Hurry today and send in your order for %s from %s and make these fantastic savings\n", product, manufacturer);
	UI.println();
	UI.println();
    }

    public String capitalise(String word){
	String first = word.substring(0,1);
	String rest = word.substring(1);
	return first.toUpperCase() + rest;
        // END OF YOUR CODE
    }
	


}


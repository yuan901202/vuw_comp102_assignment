/* Code for COMP102 Assignment 3, 2012
 * Name: Tianfu Yuan
 * Usercode: yuantian
 * ID: 300228072
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
    
   public void writeALetter(){
        this.writeLetters("Paul","grass cathers from Blunt Mowers",245.00);
        this.writeLetters("Jane","face mud made by Old Dirt",107.50);
        this.writeLetters("Jim","ceiling wipes from Dark Sky",33.75);
        this.writeLetters("Petra","television curtains by New Control",88.99);
        this.writeLetters("Tim","headphones from Breaking Drums",435.00);
       
    }
    
   public void writeLetters(String name, String brand, double price){
        UI.printf("Dear %s, \n " , name);
        UI.println("  You have been especially selected from the people of Weliington to");
        UI.printf("receive a soecial offer for %s. \n" , brand);
        UI.printf("%s is a premium brand product and retails for $%.2f \n" ,brand, price);
        UI.printf("But,%s if you order your %s today, you can purchass it \n" ,name, brand);
        UI.printf("for just $%.2f, a savings of 60%%! \n", (price*0.4));
        UI.printf("Hurry today and send in your order for %s and make these fantastic savings \n", brand);
        UI.println();
        UI.println();
        
    }
    
     

    /** Write out a series of at least five marketing letters. Each letter should
        be addressed to a different person and should use their name several times in
    the letter. Each letter should be marketing a different product at 60% off its
    retail price. Both the retail price and the discount price should be included
    in the letter. There should be an additional discount for larger orders.
    The number of items required for a "larger" order will be different for each letter.
    */
   
    public void writerALetterCompletion(){
        this.writeLettersCompletion("Paul","grass catcher","Blunt Mowers","Andrews",2,245.00);
        this.writeLettersCompletion("Jane","face mud","Old Dirt","Johnston",5,107.50);
        this.writeLettersCompletion("Jim","ceiling wipe","Dark Sky","Allison",20,33.75);
        this.writeLettersCompletion("Petra","television curtains","New Control","Jaynes",7,88.99);
        this.writeLettersCompletion("Tim","headphones","Anoia","Wang",2,435.00);
        
    }
    public void writeLettersCompletion(String name, String thing, String brand, String family, int num, double price){
        UI.printf("Dear %s, \n" , name);
        UI.println("  You have been especially selected from the people of Weliington to");
        UI.printf("receive a soecial offer for %s. \n", thing);
        UI.printf("%ss from %s are a premium brand product and retails for $%.2f. \n", thing, brand, price);
        UI.printf("But, %s, if you order your %s today, you can purchase it \n", name, thing);
        UI.printf("for just $%.2f, a savings of 60%%! \n", (price*0.4));
        UI.printf("As a special bonus, just for the %s family, if you order %d %ss today, \n", family, num, thing);
        UI.printf("you will get an additional 10%% off - an amazing price for ceiling wipe of just $%.2f! \n", (price*0.3));
        UI.printf("Hurry today and send in your order for %s from %s and make these fantastic savings \n",thing, brand);
        UI.println();
        UI.println();
        
    }
    


}


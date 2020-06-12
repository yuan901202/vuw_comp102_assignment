/* Code for Assignment 6
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;

/** A FlatAccount keeps track of the balances of two kinds of expenses in a flat:
    rent and food.
    When a new Flat Account object is constructed, the balances are set to 0.
    The constructor should have one argument -
      the name of the flat, which should be stored in the object.

    FlatAccount has three methods:
     - printBalances(), which prints out a statement of the two balances.
     - expense(...), which makes a payment of some amount from the flat
       account out of one of the balances. (reduces the balance)
       Requires the name of the balance ("rent" or "food"), and the amount of payment.
     - contribute(...), which records a deposit of some amount into the flat account
       (puts the amount into the smallest balance)
       Requires the amount.
 */
public class FlatAccount{

    // fields:
    // YOUR CODE HERE
    private String flatName;
    private double rent = 0.0;
    private double food = 0.0;
    // END OF YOUR CODE
    

    // Constructor: has one argument - the name of the flat.
    // YOUR CODE HERE
    public FlatAccount(String name){
	this.flatName = name;
    }
    // END OF YOUR CODE

    //methods

    //getName():  return the name of the flat
    // YOUR CODE HERE
    public String getName(){
	return this.flatName;
    }
    // END OF YOUR CODE

    //printBalances():  print the name of the flat and the two balances.
    // YOUR CODE HERE
    public void printBalances(){
	UI.println("Balance of accounts for " + this.flatName);
	UI.printf(" rent: $%4.2f\n", this.rent);
	UI.printf(" food: $%4.2f\n", this.food);
	UI.println();
    }
    // END OF YOUR CODE

    //expense(...), makes a payment out of one of the balances.
    //Requires name of balance and amount, and decreases that balance by the amount
    // YOUR CODE HERE
    public void expense(String balanceName, double amount){
	if (balanceName.equals("rent")){
	    this.rent = this.rent - amount;
	}
	else if (balanceName.equals("food")){
	    this.food = this.food - amount;
	}
	else {
	    UI.println("That balance is not recognised.");
	}
    }
    // END OF YOUR CODE

    //contribute(...), makes a payment into the flat account.
    //Requires the amount
    //Increases smallest balance by the amount.
    // YOUR CODE HERE
    public void contribute(double amount){
	if (this.rent < this.food){
	    this.rent = this.rent + amount;
	}
	else{
	    this.food = this.food + amount;
	}
    }
    // END OF YOUR CODE

}

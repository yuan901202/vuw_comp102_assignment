/* Code for Assignment 4, COMP 102 2011T2
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;


/** A program that plays Rock-Paper-Scissors with the user.
 */
public class RPS{

    /** Play one round of RPS and print out the choices and the result */
    public void playRound(){
    /* Outline of algorithm
	 make the computer's choice and store in variable
	 ask for the player's choice and store in variable
	 print out the computer's choice
	 compare the choices to work out who won and report it
     */
	// YOUR CODE HERE
	String comp = "rock";
	double rand = Math.random();
	if ( rand < 1/3.0 ){
	    comp = "paper";
	}
	if ( rand > 2/3.0) {
	    comp = "scissors";
	}

	// ask for the player's choice
	String user = UI.askToken("Your choice: ").toLowerCase();
	

	// print out the computer's choice
	UI.printf("Computer:    %s\n", comp);

	// work out who won and report it
	int score = 0;
	if ( comp.equals(user) ){
	    UI.println("Draw");
	}
	else if (user.equals("paper") ){
	    if (comp.equals("scissors") ) {
	    UI.println("You lost.");
	    }
	    else {
	    UI.println("You won.");
	    }
	}
	else if (user.equals("scissors") ){
	    if (comp.equals("rock") ) {
	    UI.println("You lost.");
	    }
	    else {
	    UI.println("You won.");
	    }
	}
	else if (user.equals("rock") ){
	    if (comp.equals("paper") ) {
	    UI.println("You lost.");
	    }
	    else {
	    UI.println("You won.");
	    }
	}
	else {
	    UI.println("You didn't make a valid choice");
	}	
	// END OF YOUR CODE
    }


    /** Play 6 rounds of RPS. This method contains a loop that
     *  will call the playRound method six times.
     */
    public void playRPSGame(){
	UI.initialise();
	UI.println("Hello, let's play Rock Paper Scissors");
	UI.println("Each round, you must choose rock, paper, or scissors;");
	UI.println("The computer will do the same then report who won.");
	// YOUR CODE HERE
	int count = 0;
	while (count < 6) {
	    UI.println("------------------------");
	    this.playRound();
	    count = count + 1;
	}
	UI.println("------------------------");
	UI.println("All done");
    }

    /** Alternative version of playRound that represents the choices by
     *	numbers rather than strings and uses sub-methods. 
     */
    public void playRoundNums(){
	// make the computer's choice  
	int comp = (int) (Math.random()*3);

	// ask for the player's choice
	String userAnswer = UI.askToken("Your choice: ");
	int user = this.choiceAsInt(userAnswer);

	UI.printf("Computer:    %s\n", this.choiceAsString(comp));

	// work out who won and report it
	int score = 0;
	if ( comp==user )           {UI.println("Draw");}
	else if (user==((comp+1)%3)){UI.println("You won.");}
	// alternatively: if ((user==1&&comp==0)||(user==2&&comp==1)||(user==0&&comp=2))...
	else                        {UI.println("You lost.");}
    }

    public int choiceAsInt(String choice) {
	if (choice.equalsIgnoreCase("rock")){return 0;}
	if (choice.equalsIgnoreCase("paper")){return 1;}
	if (choice.equalsIgnoreCase("scissors")){return 2;}
	return -1;
    }

    public String choiceAsString (int num){
	if (num==0) return "rock";
	if (num==1) return "paper";
	if (num==2) return "scissors";
	return "an invalid choice";
	// END OF YOUR CODE
    }


    /** COMPLETION VERSION
	Play  RPS rounds until the player's score reaches 5 or -5.
	or the user enters "exit" or "quit"
      */
    public void playRPS2(){
	// This method is needed to make the TestRPS work.
	// You do not have to use it.
	// YOUR CODE HERE
	UI.println("Hello, let's play Rock Paper Scissors");
	UI.println("Each round, you must choose rock, paper, or scissors;");
	UI.println("The computer will do the same then report who won.");
	UI.println("The game continues until one of us is ahead by 5");
	UI.println("or you type exit for one of your choices");
	int score = 0;
	while (Math.abs(score) < 5 ){
	    UI.println("------------------------");
	    int roundScore = playRoundScore();
	    if (roundScore<-1){break;}
	    score = score + roundScore;
	    UI.printf("Score is now: %d\n", score);
	}
	UI.println("------------------------");
	UI.println("All Done");
	
    }

    /** COMPLETION VERSION
     *	Play one round of RPS, print out the choices and result,
     *  and return the user's score from this round (-1, 0, or 1)
     *	If user enters "exit", it should return an extreme score.
     */
    public int playRoundScore(){
	// make the computer's choice
	String comp = "rock";
	double rand = Math.random();
	if ( rand < 1/3.0) {
	    comp = "paper";
	}
	if ( rand > 2/3.0) {
	    comp = "scissors";
	}

	// ask for the player's choice
	String user = UI.askToken("Your choice: ").toLowerCase();
	if (user.equalsIgnoreCase("exit")||user.equalsIgnoreCase("quit")){
	    return -1000;
	}

	//print out the choices
	UI.printf("Computer:    %s\n", comp);

	//work out who won and report it
	int score = 0;
	if ( comp.equals(user) ){
	    score = 0;
	}
	else if ( (comp.equals("paper") && user.equals("scissors"))  ||
		  (comp.equals("scissors") && user.equals("rock"))  ||
		  (comp.equals("rock") && user.equals("paper"))  ) {
	    score = 1;
	}
	else {
	    score = -1;
	}
	if (score == 0) {
	    UI.println("Draw");
	}
	else if (score == 1) {
	    UI.println("You won.");
	}
	else {
	    UI.println("You lost.");
	}
	return score;
	// END OF YOUR CODE
    }



}

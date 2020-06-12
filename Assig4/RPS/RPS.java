/* Code for Assignment 4, COMP 102 2011T2
 * Name:    Tianfu Yuan
 * Usercode: yuantian
 * ID: 300228072
 */

import comp102.*;


/** A program that plays Rock-Paper-Scissors with the user.
 */
public class RPS{

    //boolean ctg=true;

    /** Play one round of RPS and print out the choices and the result */
    public int playRound(){
    /* Outline of algorithm
     make the computer's choice and store in variable
     ask for the player's choice and store in variable
     print out the computer's choice
     compare the choices to work out who won and report it
     */ 
    
        //ctg = true;
        String player = UI.askString ("Your choice: "); /**Ask user choice */
        int score = 0; /**Set score to zero */
        if (player.equals("exit") || player.equals("quit")){ /**When user input "exit" or "quit" to stop*/
            //ctg = false;
            //UI.println("user wishes to quit");
            score = 100;
        }
       
        double comChoice = Math.random(); /**Random 3 different choice */
        String computer = "";
                
        if (comChoice < 0.333){ /**Computer chooce paper */
            computer = "paper"; 
            if (player.equals("paper")){
                UI.println("Draw.\n");
                score = score + 0;
            }
            else if (player.equals("rock")){
                UI.println("You lost.\n");
                score = score - 1;
            }
            else if (player.equals("scissors")){
                UI.println("You won.\n");
                score = score + 1;
            }
        }
        else if (comChoice > 0.667){ /**Computer choose rock */
            computer = "rock";
            if (player.equals("paper")){
                UI.println("You won.\n");
                score = score + 1;
            }
            else if (player.equals("rock")){
                UI.println("Draw.\n");
                score = score + 0;
            }
            else if (player.equals("scissors")){
                UI.println("You lost.\n");
                score = score - 1;
            }
        }
        else if (comChoice < 0.667 && comChoice > 0.333){ /**Computer choose scissors */
            computer = "scissors";
            if (player.equals("paper")){
                UI.println("You lost.\n");
                score = score - 1;
            }
            else if (player.equals("rock")){
                UI.println("You won.\n");
                score = score + 1;
            }
            else if (player.equals("scissors")){
                UI.println("Draw.\n");
                score = score + 0;
            }
        }
        else { /**If didn't enter unvalid choice */
            UI.println("You didn't make a valid choice.");
            UI.println("-----------------------------------------");
        }
        
        return score;
    }
    


    /** Play 6 rounds of RPS. This method contains a loop that
     *  will call the playRound method six times.
     */
    public void playRPSGame(){
        UI.initialise();
        UI.println("Hello, let's play Rock Paper Scissors");
        UI.println("Each round, you must choose rock, paper, or scissors;");
        UI.println("The computer will do the same then report who won.");
        UI.println("-----------------------------------------");
        
        int count = 0;
        int score = 0;
        while (count < 6){ /**Play 6 times */
           this.playRound();
           count++;
           UI.println("Score is now: " + score);
           UI.println ("-----------------------------------------");
        }
        
    }


    /** COMPLETION VERSION
    Play  RPS rounds until the player's score reaches 5 or -5.
    or the user enters "exit" or "quit"
      */
    public void playRPS2(){
    // This method is needed to make the TestRPS work.
    // You do not have to use it.
        UI.initialise();
        int score = 0;
        //UI.println(ctg);
        while ((score > -5) && (score < 5)){ /**Keep track of the total score of the user, until the user reaches a score of 5 or -5 */
            
            int temp = this.playRound();
            if (temp == 100){break;}
            score = score + temp;
            
            UI.println ("Score is now: " + score);
            UI.println ("-----------------------------------------");
        }
        
        UI.println ("FINISHED."); /**All finish */
        UI.println ("-----------------------------------------");
    }



}

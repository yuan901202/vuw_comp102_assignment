/* Code for COMP 102 Assignment 7  2011
 * Name: pondy
 */

import comp102.*;
import java.awt.Color;

/** A Duck object is an image of a yellow duck, displayed on the screen
  * with two methods:
  *   shuffle,  which moves the duck to the left, a little
  *   shoot,  which makes the duck fall over.
  * it is an error to make the duck shuffle after it has fallen over
*/
  
public class Duck {

  /* fields representing the state of a Duck */
  private double x = -100;
  private double y = -100;
  private boolean shot = false;

  /* fields containing dimensions of Ducks */

  private int size = 60;

  /** Constructor requires the coordinates (x, y) of where it should be placed */
  public Duck(double x){
    this.x = x;
    this.y = 200;
    this.draw();
  }

  /** makes the Duck shuffle to the left */
  public void shuffle() {
      if (this.shot){
	  UI.setColor(Color.red);
	  UI.fillOval(x-150, y-150, 300, 300);
	  UI.setColor(Color.yellow);
	  UI.drawString("YOU CAN'T SHUFFLE A DEAD DUCK", x-90, y);
	  throw new RuntimeException("You tried to shuffle the dead duck at ("+x+","+y+")");
      }
      for (int i=0; i<3; i++){
	  this.erase();
	  this.x = this.x - 5;
	  this.y = this.y - 5;
	  this.draw();
	  UI.sleep(100);
	  this.erase();
	  this.x = this.x - 5;
	  this.y = this.y + 5;
	  this.draw();
	  UI.sleep(100);
      }
  }

  /** shoots the Duck */
  public void shoot() {
      this.erase();
      UI.drawImage("shotduck.jpg", this.x-this.size/2, this.y+this.size/2, this.size, this.size);
      this.shot = true;
  }


  private void draw(){
      UI.drawImage("rubberduck.jpg", this.x-this.size/2, this.y-this.size/2, this.size, this.size);
  }

  private void erase(){
      UI.eraseRect(this.x-this.size/2, this.y-this.size/2, this.size, this.size);
  }


}



/* Code for COMP 102 Assignment 3  2011
 * Name: pondy
 */

import comp102.*;

/** A CartoonFigure object is a cartoon figure, displayed on the screen
  * that can 
  *   move around,
  *   change the direction the figure is facing,
  *   change its emotion (smiling or frowning)
  *   speak a phrase */
  
public class CartoonFigure {

  /* fields representing the state of a CartoonFigure */
  private String imageName = "yellow";
  private double figureX = -100;
  private double figureY = -100;
  private String direction = "right";
  private String emotion = "smile";

  /* fields containing dimensions of CartoonFigures */

  private int figureHeight = 100;
  private int figureWidth = 70;

  private int bubbleWidth = 140;
  private int bubbleHeight = 35;

  /** Constructor requires the directory name where the images are,
      and the coordinates (left, top) of where it should be placed */
  public CartoonFigure(String image, double x, double y){
    this.figureX = x;
    this.figureY = y;
    this.imageName=image;
    this.draw();
  }

  /** makes the CartoonFigure turn to the left */
  public void turnLeft() {
    this.erase();
    this.direction = "left";
    this.draw();
  }

  /** makes the CartoonFigure turn to the right */
  public void turnRight() {
    this.erase();
    this.direction = "right";
    this.draw();
  }

  
  /** makes the CartoonFigure smile */
  public void smile() {
    this.erase();
    this.emotion = "smile";
    this.draw();
  }

  /** makes the CartoonFigure frown */
  public void frown() {
    this.erase();
    this.emotion = "frown";
    this.draw();
  }



  /** move the CartoonFigure in the direction it is facing */
  public void move(double dist) {
    this.erase();
    if (this.direction.equals("right")){
      this.figureX = this.figureX + dist;
      }
    else{
      this.figureX = this.figureX - dist;
    }
    this.draw();
  }


  /** makes the CartoonFigure say something in a speech bubble */
  public void talk(String words) {
    double bubbleX = this.figureX;
    double bubbleY = this.figureY - this.bubbleHeight - 2;

    if (this.direction.equals("right"))
      bubbleX += 15 ;
    else
      bubbleX +=  this.figureWidth  - 15 - this.bubbleWidth;

    UI.drawOval(bubbleX, bubbleY, this.bubbleWidth, this.bubbleHeight);
    UI.drawString(words, bubbleX + 12, bubbleY + this.bubbleHeight/2 + 3);

    UI.sleep(1000);

    UI.eraseRect(bubbleX, bubbleY, this.bubbleWidth+1, this.bubbleHeight+1);
  }


  /** Helper method that erases the CartoonFigure 
    * All the public methods that change the figure call erase first */

  private void erase() {
      UI.eraseRect(this.figureX, this.figureY, this.figureWidth+1, this.figureHeight+1);
  }


  /** Helper method that draws the CartoonFigure
    * All the public methods that change the figure call draw.
    */

  private void draw(){
      String fname = null;
      fname = this.imageName + "/" + this.direction + "-" + this.emotion + ".png"; 
      UI.drawImage(fname, this.figureX, this.figureY, this.figureWidth, this.figureHeight);
      UI.sleep(500);
  }

}



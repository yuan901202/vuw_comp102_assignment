/* Code for COMP102 Assignment 5, 2012
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/** Renders plain ppm images onto the graphics panel
    ppm images are the simplest possible colour image format.
*/


public class ImageRenderer{

    public static final int left = 20;  // left edge of the image
    public static final	int top = 20;   // top edge of the image
    public static final	int pixelSize = 2;  

    /** Renders a ppm image file.
	Asks for the name of the file, then renders the image at position (left, top).
	Each pixel of the image	is rendered by a square of size pixelSize
	Assumes that
	- the colour depth is 255,
	- there is just one image in the file (not "animated"), and
	- there are no comments in the file.
	The first four tokens are P3, number of columns, number of rows, 255
	The remaining tokens are the pixel values (red, green, blue for each pixel)
    */
    public void renderImage(){
	// YOUR CODE HERE
	String fname = UIFileChooser.open("Name of file to render");
	File file = new File(fname);
	try{
	    Scanner sc = new Scanner(file);
	    String magicNumber = sc.next(); // should be P3
	    if (!magicNumber.equals("P3")){
		UI.println("Invalid file format");
		return;
	    }	int cols = sc.nextInt();
	    int rows = sc.nextInt(); 
	    int max = sc.nextInt(); // needs to be 255
	    int row = 0;
	    int y = top;
	    UI.clearGraphics(false);
	    while (row < rows){
		int col = 0;
		int x = left;
		while (col < cols){
		    UI.setColor(new Color(sc.nextInt(),sc.nextInt(),sc.nextInt()));
		    UI.drawRect(x, y, pixelSize, pixelSize, false);
		    col++;
		    x = x + pixelSize;
		}
		row++;
		y = y + pixelSize;
	    }
	    UI.repaintGraphics();
	    sc.close();
	}
	catch(IOException e){System.out.println("Fail: " + e);}
	UI.repaintGraphics();
	// END OF YOUR CODE
    }

    /** Renders a ppm image file, possibly animated (multiple images in the file)
	Asks for the name of the file, then renders the image at position (left, top).
	Each pixel of the image	is rendered by a square of size pixelSize
	Renders each image in the file in turn with 200 mSec delay.
	Repeats the sequence 3 times.
	Ignores comments (starting with # and occuring after the 1st, 2nd, or 3rd token) 
	The colour depth (max colour value) may be different from 255 (scales the
	colour values appropriately)
    */
    public void renderAnimatedImage(){
	// YOUR CODE HERE
	String fname = UIFileChooser.open("Name of file to render");
	File file = new File(fname);
	int count = 0;
	while (count < 3){
	    try{
		Scanner sc = new Scanner(file);
		while (sc.hasNext()){
		    this.renderImageCompletion(sc);
		    UI.sleep(200);
		}
		sc.close();
	    }
	    catch(IOException e){System.out.println("Fail: " + e);}
	    count++;
	}
    }

    public void renderImageCompletion(Scanner input){
	String magicNumber = input.next(); // should be P3
	while (!input.hasNextInt()){input.nextLine();} // gobble any comments
	int cols = input.nextInt();
	while (!input.hasNextInt()){input.nextLine();} // gobble any comments
	int rows = input.nextInt(); 
	while (!input.hasNextInt()){input.nextLine();} // gobble any comments
	int max = input.nextInt();         // max colour value

	int row = 0;
	int y = top;
	while (row < rows){
	    int col = 0;
	    int x = left;
	    while (col < cols){
		int red = input.nextInt()*255/max;
		int green = input.nextInt()*255/max;
		int blue = input.nextInt()*255/max;
		UI.setColor(new Color(red,green,blue));
		UI.drawRect(x, y, pixelSize, pixelSize, false);
		col++;
		x = x + pixelSize;
	    }
	    row++;
	    y = y + pixelSize;
	}
	UI.repaintGraphics();
	// END OF YOUR CODE
    }





}

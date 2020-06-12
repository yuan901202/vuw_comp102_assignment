/* Code for COMP102 Assignment 5, 2012
 * Name: Tianfu Yuan
 * Usercode: yuantian
 * ID: 300228072
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
    public static final int top = 20;   // top edge of the image
    public static final int pixelSize = 2;  

    /** Renders a ppm image file.
    Asks for the name of the file, then renders the image at position (left, top).
    Each pixel of the image is rendered by a square of size pixelSize
    Assumes that
    - the colour depth is 255,
    - there is just one image in the file (not "animated"), and
    - there are no comments in the file.
    The first four tokens are P3, number of columns, number of rows, 255
    The remaining tokens are the pixel values (red, green, blue for each pixel)
    */
    public void renderImage(){
    // YOUR CODE HERE
        UI.initialise();
        UI.clearGraphics();
        String numbers = UIFileChooser.open("Choose a file: ");

        int red = 0;
        int green = 0;
        int blue = 0;
        int total = 0;
        int rows = 0;
        int count2 = 0;
        int columns = 0;
        int depth = 0;
        int left = 2;
        String image;
        try {
            Scanner scan = new Scanner(new File(numbers));

            if (scan.hasNext()){
                image = scan.next();
                if (image.equals("P3")){
                    columns = scan.nextInt();
                    rows = scan.nextInt();
                    depth = scan.nextInt();   
                    int count = 0;
                       //the following code get help from tutors
                    while (count < rows){   
                        count2 = 0; //initialise count2
                        while (count2 < columns){
                        red = scan.nextInt(); //set first number to red scale
                        green = scan.nextInt(); //set second number to green scale
                        blue = scan.nextInt(); //set third number to blue scale   
                        UI.setColor(new Color(red,green,blue));  //set colours 
                        UI.fillRect(left + pixelSize * count2, top + pixelSize * count, pixelSize, pixelSize, false);   //draws the image column by column  
                        UI.repaintGraphics(); //updates graphics pane all at once
                        count2++;
                        }
                        count++;
                    }
                }else {
                    UI.println("Cannot Render this image format.");
                }
            }
        }catch (IOException e){UI.printf("File failure: %s\n" , e);}
    }

    /** Renders a ppm image file, possibly animated (multiple images in the file)
    Asks for the name of the file, then renders the image at position (left, top).
    Each pixel of the image is rendered by a square of size pixelSize
    Renders each image in the file in turn with 200 mSec delay.
    Repeats the sequence 3 times.
    Ignores comments (starting with # and occuring after the 1st, 2nd, or 3rd token) 
    The colour depth (max colour value) may be different from 255 (scales the
    colour values appropriately)
    */
    public void renderAnimatedImage(){
    // YOUR CODE HERE
        UI.initialise();
        UI.clearGraphics();
        String fileName = UIFileChooser.open("Choose a file: ");
        try{
            //doing sequence 3 times
            int count = 0;
            while (count < 3){

                Scanner scan = new Scanner(new File(fileName));

                while (scan.hasNext()){
                    String first = scan.next();
                    //the following code get help from tutors and Jacky Chang
                    if (first.equalsIgnoreCase("p3")){
                        String next = scan.next();
                        while (next.startsWith("#")){
                            scan.nextLine();
                            next = scan.next();
                        }

                        int column = Integer.parseInt(next);
                        next = scan.next();
                        while (next.startsWith("#")){
                            scan.nextLine();
                            next = scan.next();
                        }

                        int row = Integer.parseInt(next);
                        next = scan.next();
                        while (next.startsWith("#")){
                            scan.nextLine();
                            next = scan.next();
                        }

                        int colorDepth = Integer.parseInt(next);

                        while (scan.hasNextInt()){
                            int countRow = 0;
                            while (countRow < row){
                                int countColumn = 0;
                                while (countColumn < column){
                                    int red = scan.nextInt();
                                    int green = scan.nextInt();
                                    int blue = scan.nextInt();

                                    UI.setColor(new Color(255 / colorDepth * red, 255 / colorDepth * green, 255 / colorDepth * blue));
                                    UI.fillRect(left + countColumn * pixelSize, top + countRow * pixelSize, pixelSize, pixelSize, false);
                                    countColumn++;
                                }
                                countRow++;
                            }
                            UI.repaintGraphics();
                            UI.sleep(200);
                        }
                    }else{
                        UI.println("Cannot Render this image format.");
                    }    
                }
                count++;
            }
        }catch (IOException e){UI.printf("File failure: %s\n" , e);}
    }
}

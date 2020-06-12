/* Code for COMP102 Assignment
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.awt.Color;
import java.util.*;
import java.io.*;


/** ScaleImage   */

public class ScaleImage{

    public void scaleImage(){
	// YOUR CODE HERE
	String infname = UIFileChooser.open("Name of file to scale");
	File infile = new File(infname);
	this.renderAnimatedImage(infile);
	String outfname = UIFileChooser.save("Scaled file");
	File outfile = new File(outfname);
	int scale = UI.askInt("New scale: ");
	try{
	    Scanner sc = new Scanner(infile);
	    PrintStream out = new PrintStream(outfile);
	    while (sc.hasNext()){
		out.println(sc.next());
		while (!sc.hasNextInt()){out.println(sc.nextLine());}
		int cols = sc.nextInt();
		while (!sc.hasNextInt()){out.println(sc.nextLine());}
		int rows = sc.nextInt(); 
		out.println(cols+" "+rows);
		while (!sc.hasNextInt()){out.println(sc.nextLine());}
		int max = sc.nextInt(); // needs to be 255
		out.println(scale);
		UI.println(cols+" "+rows+" "+max);
		int count = 0;
		for (int row = 0;row < rows; row++){
		    for (int col = 0;col < cols; col++){
			out.print(sc.nextInt()*scale/max+" ");
			out.print(sc.nextInt()*scale/max+" ");
			out.print(sc.nextInt()*scale/max+" ");
			if (count++ >9){
			    count=0;
			    out.println();
			}
		    }
		}
		if (count!=0){out.println();}
	    }
	    sc.close();
	    out.close();
	    UI.println("done");
	}
	catch(IOException e){System.out.println("Fail: " + e);}
	this.renderAnimatedImage(outfile);
    }

    public static final int left = 20;
    public static final	int top = 20;
    public static final	int pixelSize = 2;


    public void renderAnimatedImage(File file){
	int count = 0;
	try{
	    Scanner sc = new Scanner(file);
	    while (sc.hasNext()){
		this.renderImageCompletion(sc);
		UI.sleep(100);
	    }
	    sc.close();
	}
	catch(IOException e){System.out.println("Fail: " + e);}
    }

    public void renderImageCompletion(Scanner input){
	String magicNumber = input.next(); // should be P3
	while (!input.hasNextInt()){
	    input.nextLine();
	}
	int cols = input.nextInt();
	while (!input.hasNextInt()){
	    input.nextLine();
	}
	int rows = input.nextInt(); 
	while (!input.hasNextInt()){
	    input.nextLine();
	}
	int max = input.nextInt(); // needs to be 255
	int row = 0;
	int y = top;
	while (row < rows){
	    int col = 0;
	    int x = left;
	    while (col < cols){
		UI.setColor(new Color(input.nextInt()*255/max,input.nextInt()*255/max,input.nextInt()*255/max));
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

    public static void main(String[] arguments){
	while (true) {
	    new ScaleImage().scaleImage();
	    UI.askBoolean("next");
	}
    }	


}

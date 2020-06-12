/* Code for COMP 102 Assignment 9 
 * Name: Tianfu Yuan
 * Usercode: yuantian
 * ID: 300228072
 */

import comp102.*;
import java.util.*;
import java.awt.Color;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


/** ImageProcessor allows the user to display and edit a
    greyscale image in a number of ways.
    The program represents the image as a 2D array of integers, which must
     all be between 0 (black) and 255 (white).
    The class includes three methods (already written for you) that will
     - read a png or jpeg image file and store a 2D array of greyscale values
       into the image field.
     - write the 2D array of greyscale values in the image field as a png file.
     - render the 2D arrray of greyscale values in the image field on the canvas
    
    You are to complete the methods to modify an image:
     - lighten the image
     - increase the contrast
     - flip image horizontally
     - expand the top left quarter of the image to fill the image
     - zoom in on the image

     - blur the image.  [filter]

     - given one pixel, find all the connected pixels that are within x greylevels
       and turn them white (erase them)  [recursion]


 */
public class ImageProcessor implements UIButtonListener, UIMouseListener{
    // the current image (initialised to a very small image)
    private int[][] image = new int[][]{{80,80,80},{80, 200, 80},{80,80,80}}; 
 
    // current selected point
    private int selectedRow = 0;
    private int selectedCol = 0;

    private final int pixelSize = 1;  // the size of the pixels as drawn on screen


    // Constructors
    /** Construct a new ImageProcessor object
     * and set up the GUI
     */
    public ImageProcessor(){
    UI.setMouseListener(this);

    UI.addButton("Load", this);
    UI.addButton("Save", this);
    UI.addButton("Lighten", this);
    UI.addButton("Contrast", this);
    UI.addButton("Flip", this);
    UI.addButton("Expand", this);
    UI.addButton("Fade", this);
    UI.addButton("Zoom", this);
    UI.addButton("Blur", this);
    UI.addButton("FillErase", this);

    this.computeGreyColours();
    }

    /** Respond to button presses */
    public void buttonPerformed(String cmd){
    if (cmd.equals("Load"))            { this.image = this.loadImage(UIFileChooser.open()); }
    else if (cmd.equals("Save"))       { this.saveImage();     }
    else if (cmd.equals("Lighten"))    { this.lightenImage();  }
    else if (cmd.equals("Contrast"))   { this.contrastImage(); }
    else if (cmd.equals("Flip"))       { this.flipImage();     }
    else if (cmd.equals("Fade"))       { this.fadeImage();     }
    else if (cmd.equals("Expand"))     { this.expandImage();     }
    else if (cmd.equals("Zoom"))       { this.zoomImage(); }
    else if (cmd.equals("Blur"))       { this.blurImage();     }
    else if (cmd.equals("FillErase"))  { this.fillErase();     }

    this.selectedRow = 0;
    this.selectedCol = 0;
    this.redisplayImage();
    }

    /** Respond to mouse events */
    public void mousePerformed(String action, double x, double y) {
    if (action.equals("released")){
        this.setPos(x, y);
    }
    }

    /** Make all pixels in the image lighter by 20 greylevels.
    but make sure that you never go over 255 (maximum level - white).
     */
    public void lightenImage(){
    // YOUR CODE HERE
        for(int i=0; i<image.length; i++){
            for(int j=0; j<image[i].length; j++){
                image[i][j] += 20;
                if(image[i][j] > 255){
                    image[i][j] = 255;
                }
            }
        }
    }  

    /** Increase the contrast of the image -
    make all lighter pixels in the image (above 128) even lighter (by 20%)
    and make all darker pixels even darker (by 20%)
    */
    public void contrastImage(){
    // YOUR CODE HERE
        //The following code get help from tutors
        for(int rows=0; rows<this.image.length; rows++){
            for(int cols=0; cols<this.image[0].length; cols++){
                int greyColor = this.image[rows][cols];
                if(greyColor>128){
                    greyColor = greyColor + (greyColor-128)/5;
                }
                
                if(greyColor>255){
                    greyColor = 255;
                }
                
                if(greyColor<0){
                    greyColor = 0;    
                }
                
                else{
                    greyColor = greyColor - (128-greyColor)/5;
                }
                this.image[rows][cols] = greyColor;
            }
        }
    } 

    /** Flip the image vertically
    exchange the values on the top half of the image
    with the values on the bottom half
    */
    public void flipImage(){
    // YOUR CODE HERE
        for(int i=0; i<image.length; i++){
            for(int j=0; j<image[i].length; j++){
                int flip = i++;
                int flip2 = j++;
                image[flip][flip2] = image[i][j];
            }
        }
    }

    /** Expand the top left quarter of the image to fill the whole image
    each pixel in the top left quarter will be copied to four pixels
    in the new image.
    Be careful not to try to access elements past the edge of the array!
    Hint: It is actually easier to work backwards from the bottom right corner.
    */
    public void expandImage(){
    // YOUR CODE HERE
        int rows = this.image.length;
        int cols = this.image[0].length;
        for(int row=rows-1; row>=0; row=row-1){
            for(int col=cols-1; col>=0; col=col-1){
                this.image[row][col] = this.image[row/2][col/2];
            }
        }
    }

    /** Fade the image
    Ask the user to select another image file, and load it into another array.
        Check that the other image is the same size as the current image.
        Replace each pixel value in the current image by a weighted combination of the
    current pixel value and the corresponding pixel value in the other image:
    value <=  (int) (weight * currentpixel + (1-weight) * otherpixel)
        The weight should be 0.0 for pixels on the top edge and 1.0 for pixels
    on the bottom edge, and should change smoothly between.
    */
    public void fadeImage(){
    int [][] other = loadImage(UIFileChooser.open());
    if (other.length != this.image.length ||
        other[0].length != this.image[0].length ){
        return;
    }
    // YOUR CODE HERE
        int cols = this.image[0].length;
        for(int row=0; row<this.image.length; row++){
            for(int col=0; col<this.image[0].length; col++){
                this.image[row][col] = (int)(col/cols*this.image[row][col] + (1-col/cols)*other[row][col]);
            }
        }
    }
    
 
    // ==== Completion ==================


    /** Zoom in on the image, expanding by 133%, centered on the currently
    selected pixel.
    (The user can use the mouse to select a pixel which will be highlighted)
    Hint: the selected pixel should stay where it is, and other pixels should be
    moved away from it by a factor or 4/3.
    Be careful not to try to access elements past the edge of the array!
    Be careful not to leave gaps in the image.
    Hint: It is easier to make a new array, copy the image over, expanding as you go
    and then assign the new array to the image field.
    */
    public void zoomImage(){
    // YOUR CODE HERE
        int rows = this.image.length;
        int cols = this.image[0].length;
        int [][] zoom = new int[rows][cols];
        for(int row=0; row<rows; row++){
            int originalRow = this.selectedRow + (row-selectedRow)*3/4;
            for(int col=0; col<cols; col++){
                int originalCol = this.selectedCol + (col-selectedCol)*3/4;
                zoom[row][col] = this.image[originalRow][originalCol];
            }
        }
        this.image = zoom;
    }



    /** Blur the image 
    Modify each pixel to make it a weighted average of itself and
    the pixels around it
    A simple blur will weight the pixel by 0.4, its horizontal and vertical
        neighbours by 0.1, and the diagonal neighbours by 0.05.
    Hint: It is easier to make a new image array of the same size as the image,
    then work out the weighted averages in the new array,
    and then assign the new array to the image field.
    */
    public void blurImage(){
    double[][] weights = {{0.05, 0.1, 0.05},     // size must be an odd number
                  {0.1, 0.4, 0.1},       // and sum of values must be 1
                  {0.05, 0.1, 0.05}};
    // YOUR CODE HERE
        //The following code get help from tutors
        int pixelChange = weights.length/2;
        int rows = this.image.length;
        int cols = this.image[0].length;
        double [][] blur = new double[rows][cols];
        for(int row=pixelChange; row<rows-pixelChange; row++){
            for(int col=pixelChange; col<cols-pixelChange; col++){
                for(int i=0; i<weights.length; i++){
                    for(int j=0; j<weights.length; j++){
                        blur[row][col] += this.image[row+i-pixelChange][col+j-pixelChange] * weights[i][j];
                    }
                }
            }
        }
        
        for(int row=pixelChange; row<rows-pixelChange; row++){
            for(int col=pixelChange; col<cols-pixelChange; col++){
                this.image[row][col] = (int)blur[row][col];
            }
        }
    }
        
        

    /** {Challenge)
    Erase the connected region of the image, starting at the selected point,
    with values within 10 greylevels of the selected point. 
    This will need a recursive helper method - spreadWhite, which spreads
    white to the pixel at (x,y) if it is within the range (min to max) and is
    not already white. It then has to spreadWhite to each of its four neighbours.
    */

    public void fillErase(){
    // YOUR CODE HERE
    }


    //=========================================================================
    // Methods below here are complete -
    // for loading an image file into the image array,
    // for saving the image array into a file
    // for redisplaying the image array on the canvas.

    /** field and helper methods to precompute and store all the possible grey colours,
    so the redisplay method does not have to constantly construct new color objects */
    private Color[] greyColors = new Color[256];
    private void computeGreyColours(){
    for (int i=0; i<256; i++){
        this.greyColors[i] = new Color(i, i, i);
    }
    }
    private Color greyColor(int grey){
    if (grey < 0){
        return Color.blue;
    }
    else if (grey > 255){
        return Color.red;
    }
    else {
        return this.greyColors[grey];
    }
    }

    /** Set the selected Row and Col to the pixel on the mouse position x, y */
    public void setPos(double x, double y){
    int row = (int)(y/this.pixelSize);
    int col = (int)(x/this.pixelSize);
    if (this.image != null && row < this.image.length && col < this.image[0].length){
        this.selectedRow = row;
        this.selectedCol = col;
        this.redisplayImage();
    }
    }

    /** Display the image on the screen with each pixel as a square of size pixelSize.
    To speed it up, all the possible colours from 0 - 255 have been precalculated.
    */
    public void redisplayImage(){
    UI.clearGraphics(false);
    for(int row=0; row<this.image.length; row++){
        int y = row * this.pixelSize;
        for(int col=0; col<this.image[0].length; col++){
        int x = col * this.pixelSize;
        UI.setColor(this.greyColor(this.image[row][col]));
        UI.fillRect(x, y, this.pixelSize, this.pixelSize, false);
        }
    }
    UI.setColor(Color.red);
    UI.drawRect(this.selectedCol*this.pixelSize,this.selectedRow*this.pixelSize,
                 this.pixelSize,this.pixelSize);
    UI.repaintGraphics();
    }

    /** Get and return an image as a two-dimensional grey-scale image (from 0-255). 
        This method will cause the image to be returned as a grey-scale image,
        regardless of the original colouration.
    */
    public int[][] loadImage(String imageName) {
    int[][] ans = null;
    if (imageName==null) return null;
    try {
        BufferedImage img = ImageIO.read(new File(imageName));
        UI.printf("loaded image height(rows)= %d width(cols)= %d\n",
                  img.getHeight(), img.getWidth());
        ans = new int[img.getHeight()][img.getWidth()];
        for (int row = 0; row < img.getHeight(); row++){
        for (int col = 0; col < img.getWidth(); col++){
            Color c = new Color(img.getRGB(col, row), true);
            // Use a common algorithm to move to greyscale
            ans[row][col] = (int)Math.round((0.3 * c.getRed()) + (0.59 * c.getGreen())
                            + (0.11 * c.getBlue()));
        }
        }
    } catch(IOException e){UI.println("Image reading failed: "+e);}
    return ans;
    }


    /**
       Write the current greyscale image to the specified filename
    */
    public  void saveImage() {
    // For speed, we'll assume every row of the image is the same length!
    int height = this.image.length;
    int width = this.image[0].length;
    BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    for (int row = 0; row < height; row++) {
        for (int col = 0; col < width; col++) {
        int greyscaleValue = this.image[row][col];
        Color c = new Color(greyscaleValue, greyscaleValue, greyscaleValue);
        img.setRGB(col, row, c.getRGB());
        }
    }
    try {
        String fname = UIFileChooser.save("save to png image file");
        if (fname==null) return;
        File imageFile = new File(fname);
        ImageIO.write(img, "png", new File(fname));
    } catch(IOException e){UI.println("Image reading failed: "+e);}
    }



    // Main
    public static void main(String[] arguments){
    ImageProcessor ob = new ImageProcessor();
    }   


}

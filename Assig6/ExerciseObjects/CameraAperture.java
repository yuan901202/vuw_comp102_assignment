/* Code for Assignment 6 COMP102
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.awt.Color;


/** A CameraAperture object represents the aperture of a camera, which can be opened or closed.
    It is drawn using a cicle outline of the camera lens, and a solid black circle
      representing the aperture. The aperture may be varied (in small steps) between wide open,
      (about 80% of the camera lens) and closed (about 20% of the camera lens)
    The CameraAperture object needs to remember
      - the position of the lens (which doesn't change), and
      the width of the aperture (which does change)
    The constructor requires two arguments:
       the x and y position of the lens
    The aperture is initially wide open

    The class has two methods:
      open(),  which opens the aperture by a further 10% (unless it is fully open)
      close(), which closes the aperture by a further 10% (unless it is fully closed)
      They don't need to redraw the lens outline
 */
public class CameraAperture{

    //fields
    static final double lensWidth = 100;   // width of the whole lens
    // YOUR CODE HERE

    //Constructor: passed the center of the lens
    // YOUR CODE HERE

    // open method: if current width less than 80% of lensWidth, increase it by 10% of lensWidth
    // YOUR CODE HERE

    // raiseRight method: right right end of tightrope by the specified distance.
    // YOUR CODE HERE


}

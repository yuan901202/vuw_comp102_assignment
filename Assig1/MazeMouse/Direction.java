
/** Direction Class
   * Author:  pondy
   * Description: Provides four distinct directions, and methods to obtain
   * the direction left, right, and opposite a given direction.
   */

public enum Direction {
    NORTH, SOUTH, EAST, WEST ;
  

    public Direction left(){
	if (this == NORTH) return WEST;
	else if (this == SOUTH) return EAST;
	else if (this == EAST) return NORTH;
	else if (this == WEST) return SOUTH;
	else      return null;
    }

    public Direction right(){
	if (this == NORTH) return EAST;
	else if (this == SOUTH) return WEST;
	else if (this == EAST) return SOUTH;
	else if (this == WEST) return NORTH;
	else return null;
    }

    public Direction opposite(){
	if (this == NORTH) return SOUTH;
	else if (this == SOUTH) return NORTH;
	else if (this == EAST) return WEST;
	else if (this == WEST) return EAST;
	else      return null;
    }

}
  


/** Coord Class
   * Author:  pondy
   * Description: Provides row-column pairs for specifying cells of a maze
   */


public class Coord{
  
  public  int row;
  public int col;

  
  public Coord(int r, int c){
    row = r;
    col = c;
  }
  
  public Coord next(Direction d){
    if  (this == null) 
      return null;
    if (d == Direction.NORTH) {
      return new Coord(row - 1, col);
    }
    else if (d == Direction.SOUTH) {
      return new Coord(row + 1, col);
    }
    else if (d == Direction.EAST) {
      return new Coord(row, col + 1);
    }
    else if (d == Direction.WEST) {
      return new Coord(row, col - 1);
    }
    else
      return null;
  }
}

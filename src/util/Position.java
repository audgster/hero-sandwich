package util;

import java.util.Objects;


public class Position
{
  private int x;
  private int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public boolean equals(Position p)
  {
    if(this.getX() != p.getX()){
      return false;
    }
    else if(this.getY() != p.getY()){
      return false;
    }
    else{
      return true;
    }
  }

  @Override
  public String toString() {
    String str = "Position [" + x + "," + y + "]";
    return str;
  }

    public Position incrementPosition(Direction directionMoved)
    {
        return incrementPosition(directionMoved, 1);
    }

  public Position incrementPosition(Direction directionMoved, int numberOfSquares)
  {
      if (numberOfSquares < 1)
      {
          throw new IndexOutOfBoundsException("numberOfSquares not valid");
      }

      int x = getX();
      int y = getY();

      switch (directionMoved)
      {
          case NORTH: y = y - numberOfSquares;
              break;
          case NORTHEAST: y = y - numberOfSquares;
              x = x + numberOfSquares;
              break;
          case EAST: x = x + numberOfSquares;
              break;
          case SOUTHEAST: y = y + numberOfSquares;
              x = x + numberOfSquares;
              break;
          case SOUTH: y = y + numberOfSquares;
              break;
          case SOUTHWEST: y = y + numberOfSquares;
              x = x - numberOfSquares;
              break;
          case WEST: x = x - numberOfSquares;
              break;
          case NORTHWEST: y = y - numberOfSquares;
              x = x - numberOfSquares;
              break;
      }

      return new Position(x,y);
  }

    @Override
    public boolean equals(Object p)
    {
        Position position;

        try
        {
            position = (Position) p;
        }
        catch (ClassCastException ex)
        {
            System.out.println("Position: Invalid cast exception");
            System.out.println("Position: These obviously can't be equal");

            return false;
        }

        return (getX() == position.getX()) && (getY() == position.getY());
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

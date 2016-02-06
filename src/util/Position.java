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

  @Override
  public String toString() {
    String str = "Position [" + x + "," + y + "]";
    return str;
  }
    // Audrey: need this for movement
    // Given a position and a direction, returns a new position
    public Position incrementPosition(Direction directionMoved) {return new Position(0, 0);}

  public Position incrementPosition(Direction directionMoved, int numberOfSquares) {return new Position(0, 0);}

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
}

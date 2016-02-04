package util;

public class Position
{
  private int x;
  private int y;

  Position(int x, int y) {
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
    public Position incrementPosition(Direction directionMoved) {return new Position();}
}

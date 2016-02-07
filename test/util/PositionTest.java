package util;

import org.junit.Assert;
import org.junit.Test;

public class PositionTest
{
    Position oldP = new Position(2, 2);


    /*
    * Input:
    * 0 1 2 3
    * x x x x
    * x x x x
    * x x p x
    * x x x x
    *
    * Result:
    * 0 1 2 3
    * x x p x
    * x x x x
    * x x x x
    * x x x x
    * */
    @Test
    public void testIncrementNorth()
    {
        Position newP = oldP.incrementPosition(Direction.NORTH, 2);
        Assert.assertEquals(newP.getX(), 2);
        Assert.assertEquals(newP.getY(), 0);
    }

    /*
    * Input:
    * 0 1 2 3
    * x x x x
    * x x x x
    * x x p x
    * x x x x
    *
    * Result:
    * 0 1 2 3
    * x x x x
    * x x x p
    * x x x x
    * x x x x
    * */
    @Test
    public void testIncrementNorthEast()
    {
        Position newP = oldP.incrementPosition(Direction.NORTHEAST, 1);
        Assert.assertEquals(newP.getX(), 3);
        Assert.assertEquals(newP.getY(), 1);
    }

    /*
    * Input:
    * 0 1 2 3
    * x x x x
    * x x x x
    * x x p x
    * x x x x
    *
    * Result:
    * 0 1 2 3
    * x x x x
    * x x x x
    * x x x p
    * x x x x
    * */
    @Test
    public void testIncrementEast()
    {
        Position newP = oldP.incrementPosition(Direction.EAST, 1);
        Assert.assertEquals(newP.getX(), 3);
        Assert.assertEquals(newP.getY(), 2);
    }

    /*
    * Input:
    * 0 1 2 3
    * x x x x
    * x x x x
    * x x p x
    * x x x x
    *
    * Result:
    * 0 1 2 3
    * x x x x
    * x x x x
    * x x x x
    * x x x p
    * */
    @Test
    public void testIncrementSouthEast()
    {
        Position newP = oldP.incrementPosition(Direction.SOUTHEAST, 1);
        Assert.assertEquals(newP.getX(), 3);
        Assert.assertEquals(newP.getY(), 3);
    }

    /*
    * Input:
    * 0 1 2 3
    * x x x x
    * x x x x
    * x x p x
    * x x x x
    *
    * Result:
    * 0 1 2 3
    * x x x x
    * x x x x
    * x x x x
    * x x p x
    * */
    @Test
    public void testIncrementSouth()
    {
        Position newP = oldP.incrementPosition(Direction.SOUTH, 1);
        Assert.assertEquals(newP.getX(), 2);
        Assert.assertEquals(newP.getY(), 3);
    }

    /*
    * Input:
    * 0 1 2 3
    * x x x x
    * x x x x
    * x x p x
    * x x x x
    *
    * Result:
    * 0 1 2 3
    * x x x x
    * x x x x
    * x x x x
    * x p x x
    * */
    @Test
    public void testIncrementSouthWest()
    {
        Position newP = oldP.incrementPosition(Direction.SOUTHWEST, 1);
        Assert.assertEquals(newP.getX(), 1);
        Assert.assertEquals(newP.getY(), 3);
    }

    /*
    * Input:
    * 0 1 2 3
    * x x x x
    * x x x x
    * x x p x
    * x x x x
    *
    * Result:
    * 0 1 2 3
    * x x x x
    * x x x x
    * p x x x
    * x x x x
    * */
    @Test
    public void testIncrementWest()
    {
        Position newP = oldP.incrementPosition(Direction.WEST, 2);
        Assert.assertEquals(newP.getX(), 0);
        Assert.assertEquals(newP.getY(), 2);
    }

    /*
    * Input:
    * x x x x
    * x x x x
    * x x p x
    * x x x x
    *
    * Result:
    *
    * x x p x
    * x x x x
    * x x x x
    * x x x x
    * */
    @Test
    public void testIncrementNorthWest()
    {
        Position newP = oldP.incrementPosition(Direction.NORTHWEST, 2);
        Assert.assertEquals(newP.getX(), 0);
        Assert.assertEquals(newP.getY(), 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidMovementAmount_Boundary()
    {
        oldP.incrementPosition(Direction.NORTH, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidMovementAmount_Boundary2()
    {
        oldP.incrementPosition(Direction.NORTH, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidMovementAmount_Normal()
    {
        oldP.incrementPosition(Direction.NORTH, -5);
    }
}

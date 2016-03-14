package com.herosandwich.util;

public enum DirectionHex{

    NORTH(0, 1, -1),
    NORTH_EAST(1, 0, -1),
    SOUTH_EAST(1, -1, 0),
    SOUTH(0, -1, 1),
    SOUTH_WEST(-1, 0, 1),
    NORTH_WEST(-1, 1, 0);

    private final int qMod;
    private final int rMod;
    private final int sMod;

    DirectionHex(int qMod, int rMod, int sMod){
        this.qMod = qMod;
        this.rMod = rMod;
        this.sMod = sMod;
    }

    public int getQMod(){
        return qMod;
    }

    public int getRMod(){
        return rMod;
    }

    public int getSMod(){
        return sMod;
    }

    public PositionHex getPosInDirection(PositionHex p){
        return new PositionHex(p.getQ() + qMod, p.getR() + rMod, p.getS() + sMod);
    }

    public static DirectionHex clockwise(DirectionHex dir){
        return DirectionHex.values()[(dir.ordinal() + 1) % 6];
    }

    public static DirectionHex counterClockwise(DirectionHex dir){
        return DirectionHex.values()[(dir.ordinal() - 1) % 6];
    }

    public static DirectionHex convertFromString(String s)
    {
        s = s.toLowerCase();

        switch (s)
        {
            case "north":
                return DirectionHex.NORTH;
            case "north_east":
                return DirectionHex.NORTH_EAST;
            case "south_east":
                return DirectionHex.SOUTH_EAST;
            case "south":
                return DirectionHex.SOUTH;
            case "south_west":
                return DirectionHex.SOUTH_WEST;
            case "north_west":
                return DirectionHex.NORTH_WEST;
            default:
                return DirectionHex.SOUTH;
        }
    }

    /** Returns an int that represents the DirectionHex, starting from North = 0, and moving clockwise **/
    /** Returns -1 if the input is not a valid direction **/
    public static int getIntRepresentation( DirectionHex direction ) {
        switch (direction) {
            case NORTH:
                return 0;
            case NORTH_EAST:
                return 1;
            case SOUTH_EAST:
                return 2;
            case SOUTH:
                return 3;
            case SOUTH_WEST:
                return 4;
            case NORTH_WEST:
                return 5;
            default:
                return -1;
        }
    }

}
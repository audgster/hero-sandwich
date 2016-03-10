package com.herosandwich.models.map;

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

}
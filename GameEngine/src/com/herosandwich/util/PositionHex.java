package com.herosandwich.util;

public class PositionHex{

    private int q;
    private int r;
    private int s;

    public PositionHex(int q, int r, int s){
        if((q + r + s) != 0){
            throw new IllegalArgumentException("Sum q + r + s must be 0");
        }
        this.q = q;
        this.r = r;
        this.s = s;
    }

    public PositionHex(int q, int r){
        this.q = q;
        this.r = r;
        this.s = -q + -r;
    }

    public PositionHex getPosInDirection(DirectionHex dir){
        return dir.getPosInDirection(this);
    }

    public int getQ(){
        return q;
    }

    public int getR(){
        return r;
    }

    public int getS(){
        return s;
    }

    @Override
    public int hashCode(){
        int hash = 31;
        hash = (17 * hash) + this.q;
        hash = (17 * hash) + this.r;
        hash = (17 * hash) + this.s;
        return hash;
    }

    @Override
    public boolean equals(Object p){
        return (this.getQ() == ((PositionHex)p).getQ() &&
                this.getR() == ((PositionHex)p).getR() &&
                this.getS() == ((PositionHex)p).getS());
    }

    public static int distanceTo(PositionHex p1, PositionHex p2){
        int sum = Math.abs(p1.getQ() - p2.getQ()) +
                Math.abs(p1.getR() - p2.getR()) +
                Math.abs(p1.getS() - p2.getS());
        return sum / 2;
    }

}
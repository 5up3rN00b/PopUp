package com.example.popup.Mole;

public class nice {
    public static void main(String[ ] args) {
        Position mole = new Position(1,2);
        System.out.println(mole.getX());
        System.out.println(mole.getY());
    }
}

class Position{
    private double x;
    private double y;

    public Position(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }
}

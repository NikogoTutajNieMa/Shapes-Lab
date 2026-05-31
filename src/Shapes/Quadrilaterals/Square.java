package Shapes.Quadrilaterals;

import Shapes.FiguresTypes;

public class Square extends Rectangle{
    public Square(double a) throws IllegalArgumentException {
        super(a, a);
    }

    @Override
    public double area(){
        return this.sideA * this.sideA;
    }

    @Override
    public double perimeter(){
        return this.sideA * 4;
    }

    @Override
    public FiguresTypes figureType(){
        return FiguresTypes.SQUARE;
    }

    public double sidesLength(){
        return sideA;
    }

    @Override
    public double diagonal(){
        return sideA * Math.sqrt(2);
    }
}
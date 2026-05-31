package Shapes.Quadrilaterals;

import Shapes.FiguresTypes;

public class Rectangle extends Parallelogram {
    public Rectangle(double a, double b) throws IllegalArgumentException {
        super(a, b, 90);
    }

    @Override
    public double area() {
        return this.sideA * this.sideB;
    }

    @Override
    public FiguresTypes figureType(){
        return FiguresTypes.RECTANGLE;
    }

    public double diagonal(){
        return Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
    }
}
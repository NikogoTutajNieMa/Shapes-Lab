package Shapes.Quadrilaterals;

import Shapes.Exceptions.InvalidAngleException;
import Shapes.FiguresTypes;

public class Rhombus extends Parallelogram {
    public Rhombus(double a, double alphaAngle) throws IllegalArgumentException, InvalidAngleException{
        super(a, a, alphaAngle);
    }

    @Override
    public double area() {
        return diagonalA() * diagonalB() / 2;
    }

    @Override
    public double perimeter() {
        return 4 * sideA;
    }

    @Override
    public FiguresTypes figureType(){
        return FiguresTypes.RHOMBUS;
    }

    public double getSides(){
        return sideA;
    }
}
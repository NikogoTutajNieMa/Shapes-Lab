package Shapes.Quadrilaterals;

import Shapes.Exceptions.InvalidAngleException;
import Shapes.FiguresTypes;

public class Parallelogram extends Quadrilateral {
    protected final double alphaAngle;

    protected final boolean isSquare;
    protected final boolean isRectangle;
    protected final boolean isRhombus;

    public Parallelogram(double sideA, double sideB, double alphaAngle) throws IllegalArgumentException, InvalidAngleException{
        if(sideA <= 0 || sideB <= 0){
            throw new IllegalArgumentException("The sides can not be negative or equal to 0");
        } else if (alphaAngle <= 0 || alphaAngle >= 180) {
            throw new InvalidAngleException("The angle can not negative, equal to 0, equal to 180 or higher than 180");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideA;
        this.sideD = sideB;

        this.alphaAngle = alphaAngle;

        isRhombus = sideA == sideB;
        isRectangle = alphaAngle == 90;
        isSquare = isRhombus && isRectangle;

        numberCreatedQuadrilaterals++;
    }

    @Override
    public double area() {
        return sideA * sideB * Math.sin(Math.toRadians(alphaAngle));
    }

    @Override
    public double perimeter() {
        return 2 * (sideA + sideB);
    }

    @Override
    public FiguresTypes figureType() {
        return FiguresTypes.PARALLELOGRAM;
    }

    public double getSideA(){
        return sideA;
    }

    public double getSideB(){
        return sideB;
    }

    public double getAlphaAngleDegrees(){
        return alphaAngle;
    }

    public double getBetaAngleDegrees(){
        return 180 - alphaAngle;
    }

    public double alphaAngleRadians(){
        return Math.toRadians(alphaAngle);
    }

    public double betaAngleRadians(){
        return Math.toRadians(180 - alphaAngle);
    }

    public double diagonalA(){
        return Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2) - (2 * sideA * sideB * Math.cos(alphaAngleRadians())));
    }

    public double diagonalB(){
        return Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2) + (2 * sideA * sideB * Math.cos(alphaAngleRadians())));
    }

    public boolean isSquare(){
        return isSquare;
    }

    public boolean isRectangle(){
        return isRectangle;
    }

    public boolean isRhombus() {
        return isRhombus;
    }
}

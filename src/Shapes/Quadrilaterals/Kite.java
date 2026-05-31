package Shapes.Quadrilaterals;

import Shapes.Exceptions.InvalidAngleException;
import Shapes.FiguresTypes;

public class Kite extends Quadrilateral {
    private final double alphaAngle;
    private final double diagonalA;
    private final double diagonalB;
    private final boolean isRhombus;

    private Kite(double sideA, double sideB, double alphaAngle, double diagonalA, double diagonalB) throws IllegalArgumentException{
        if(sideA <= 0 || sideB <= 0 || alphaAngle <= 0){
            throw new IllegalArgumentException("All arguments must not be less or equal to 0");
        }

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideA;
        this.sideD = sideB;

        this.alphaAngle = alphaAngle;

        this.diagonalA = diagonalA;
        this.diagonalB = diagonalB;

        isRhombus = sideA == sideB;
    }

    public Kite(double sideA, double sideB, double alphaAngle){
        this(sideA, sideB, alphaAngle, countDiagonalA(sideA, alphaAngle), countDiagonalB(sideB, 180 - alphaAngle));
    }

    public Kite(double sideA, double sideB, double diagonalA, double diagonalB){
        this(sideA, sideB, countAlphaAngle(sideA, sideB, diagonalA, diagonalB), diagonalA, diagonalB);
    }

    private static double countDiagonalA(double a, double alphaAngle) throws InvalidAngleException{
        if(alphaAngle <= 0){
            throw new InvalidAngleException("The angles can't be negative or equal to 0");
        } else if (alphaAngle == 180) {
            throw new InvalidAngleException("The angles can not be 180");
        }

        return a * 2 * Math.sin(Math.toRadians((alphaAngle/2)));
    }

    private static double countDiagonalB(double b, double betaAngle) throws InvalidAngleException{
        if(betaAngle <= 0){
            throw new InvalidAngleException("The angles can't be negative or equal to 0");
        } else if (betaAngle == 180) {
            throw new InvalidAngleException("The angles can not be 180");
        }

        return b * 2 * Math.sin(Math.toRadians((betaAngle/2)));
    }

    private static double countAlphaAngle(double a, double b, double e, double f){
        double area = (e * f)/2;

        return Math.toDegrees(Math.asin(area/(a*b)));
    }

    @Override
    public double area() {
        return (diagonalA * diagonalB)/2;
    }

    @Override
    public double perimeter() {
        return 2 * (sideA + sideB);
    }

    @Override
    public FiguresTypes figureType() {
        return FiguresTypes.KITE;
    }

    public double getSideA(){
        return sideA;
    }

    public double getSideB(){
        return sideB;
    }

    public double getAlphaAngle(){
        return alphaAngle;
    }

    public double getDiagonalA(){
        return diagonalA;
    }

    public double getDiagonalB(){
        return diagonalB;
    }

    public boolean isRhombus(){
        return isRhombus;
    }

    public double betaAngle(){
        return 180 - alphaAngle;
    }
}
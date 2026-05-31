package Shapes.Quadrilaterals;

import Shapes.Exceptions.InvalidAngleException;
import Shapes.FiguresTypes;

public class Trapezoid extends Quadrilateral {
    private final double height;
    private final double alphaAngle;
    private final double betaAngle;

    private Trapezoid(double longer_base, double shorter_base, double leg1, double leg2, double height, double alphaAngle, double betaAngle) throws IllegalArgumentException{
        if(longer_base <= 0 || shorter_base <= 0 || leg1 <= 0 || leg2 <= 0 || height <= 0 || alphaAngle <= 0 || betaAngle <= 0){
            throw new IllegalArgumentException("All arguments can not be negative or equal to 0");
        }

        sideA = Math.max(longer_base, shorter_base);
        sideB = Math.min(shorter_base, longer_base);
        sideC = leg1;
        sideD = leg2;

        this.height = height;

        this.alphaAngle = alphaAngle;
        this.betaAngle = betaAngle;
    }

    public Trapezoid(double base1, double base2, double leg1, double leg2, double height){
        this(base1, base2, leg1, leg2, height, getAlphaAngleFromHeight(leg1, height), getBetaAngleFromHeight(leg2, height));
    }

    public Trapezoid(double base1, double base2, double leg1, double leg2, double alpha, double beta){
        this(base1, base2, leg1, leg2, validateAndGetHeight(leg1, leg2, alpha, beta), alpha, beta);
    }

    private static double getAlphaAngleFromHeight(double leg1, double height){
        return Math.toDegrees(Math.asin(height / leg1));
    }

    private static double getBetaAngleFromHeight(double leg2, double height){
        return Math.toDegrees(Math.asin(height / leg2));
    }

    private static double validateAndGetHeight(double leg1, double leg2, double alpha, double beta) throws InvalidAngleException{
        double heightC = Math.sin(Math.toRadians(alpha)) * leg1;
        double heightD = Math.sin(Math.toRadians(beta)) * leg2;

        if (!(Math.abs(heightC - heightD) < 0.0001)){
            throw new InvalidAngleException("Angles do not make a valid trapezoid");
        }

        return heightC;
    }

    @Override
    public double area() {
        return (sideA + sideB) * (height/2);
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC + sideD;
    }

    public FiguresTypes figureType(){
        return FiguresTypes.TRAPEZOID;
    }

    public double diagonalA(){
        return Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideD, 2) - (Math.sin(Math.toRadians(alphaAngle)) * sideA * sideD * 2));
    }

    public double diagonalB(){
        return Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideC, 2) - (Math.sin(Math.toRadians(betaAngle)) * sideA * sideC * 2));
    }

    public double gammaAngle(){
        return 180 - alphaAngle;
    }

    public double deltaAngle(){
        return 180 - betaAngle;
    }

    public double getShortBasis(){
        return sideA;
    }

    public double getLongBasis(){
        return sideB;
    }

    public double getLeg1(){
        return sideC;
    }

    public double getLeg2(){
        return sideD;
    }

    public double getAlphaAngle(){
        return alphaAngle;
    }

    public double getBetaAngle(){
        return betaAngle;
    }

    public double getHeight(){
        return height;
    }
}

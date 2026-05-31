package Shapes;

import Shapes.Exceptions.TriangleInequalityException;
import java.util.Arrays;

public class Triangle implements Shape {
    private final double sideA;
    private final double sideB;
    private final double sideC;
    private static int numberOfTriangles;

    public Triangle(double sideA){
        this(sideA, sideA, sideA);
    }

    public Triangle(double sideA, double sideB){
        this(sideA, sideB, sideB);
    }

    public Triangle(double sideA, double sideB, double sideC) throws TriangleInequalityException, IllegalArgumentException{
        if(sideA >= sideB + sideC || sideB >= sideA + sideC || sideC >= sideB + sideA){
            throw new TriangleInequalityException("The triangle doesn't exists according to the Triangle Inequality Rule");
        } else if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new IllegalArgumentException("Arguments shouldn't be less than 0 or equal to 0");
        }

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;

        numberOfTriangles++;
    }

    @Override
    public double area() {
        double s = perimeter()/2;

        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public FiguresTypes figureType(){
        return FiguresTypes.TRIANGLE;
    }

    public TriangleAngleTypes getAngleType(){
        double[] sides = {sideA, sideB, sideC};
        Arrays.sort(sides);

        double x = sides[0];
        double y = sides[1];
        double z = sides[2];

        double pitagoras = (x*x)+(y*y);
        if(pitagoras > z*z){
            return TriangleAngleTypes.ACUTE;
        } else if (pitagoras == z*z) {
            return TriangleAngleTypes.RIGHT;
        } else {
            return TriangleAngleTypes.OBTUSE;
        }
    }

    public TriangleSideTypes getSideType(){
        if(this.sideA == this.sideB && this.sideB == this.sideC){
            return TriangleSideTypes.EQUILATERAL;
        } else if (this.sideA == this.sideB || this.sideB == this.sideC || this.sideA == this.sideC) {
            return TriangleSideTypes.ISOSCELES;
        }else{
            return TriangleSideTypes.SCALENE;
        }
    }

    public double getSideA(){
        return this.sideA;
    }

    public double getSideB(){
        return this.sideB;
    }

    public double getSideC(){
        return this.sideC;
    }

    public double getHeightA(){
        return (area()*2)/this.sideA;
    }

    public double getHeightB(){
        return (area()*2)/this.sideB;
    }

    public double getHeightC(){
        return (area()*2)/sideC;
    }

    public double getAngleAlpha(){
        return Math.toDegrees(Math.acos((sideB * sideB + sideC * sideC - sideA * sideA)/ (2 * sideB * sideC)));
    }

    public double getAngleBeta(){
        return Math.toDegrees(Math.acos((sideA * sideA + sideC * sideC - sideB * sideB)/ (2 * sideA * sideC)));
    }

    public double getAngleDelta(){
        return Math.toDegrees(Math.acos((sideA * sideA + sideB * sideB - sideC * sideC) / (2 * sideA * sideB)));
    }
}
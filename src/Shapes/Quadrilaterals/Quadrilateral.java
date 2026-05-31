package Shapes.Quadrilaterals;

import Shapes.Shape;

public abstract class Quadrilateral implements Shape {
    protected double sideA;
    protected double sideB;
    protected double sideC;
    protected double sideD;

    protected static int numberCreatedQuadrilaterals = 0;

    static int getNumberCreatedQuadrilaterals(){
        return numberCreatedQuadrilaterals;
    }
}
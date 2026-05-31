package Shapes;

public record Circle(double diameter) implements Shape {
    private static int numberOfCircles = 0;

    public Circle{
        if(diameter <= 0){
            throw new IllegalArgumentException("The diameter, can't be less or equal to 0");
        }

        numberOfCircles++;
    }

    @Override
    public double area() {
        double radius = radius();

        return Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public double perimeter() {
        return this.diameter * Math.PI;
    }

    @Override
    public FiguresTypes figureType(){
        return FiguresTypes.CIRCLE;
    }

    public double radius(){
        return this.diameter / 2;
    }
}
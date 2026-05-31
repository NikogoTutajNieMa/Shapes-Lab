import Shapes.*;
import Shapes.Exceptions.*;
import Shapes.Quadrilaterals.*;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static HashMap<String, Shape> figures = new HashMap<>();

    public static void main(String[] args) {
        int central_command;
        boolean isRunning = true;

        System.out.println("\n" + "Hello! In this program you can analyze geographical figures");

        while (isRunning) {
            System.out.println(Typography.BOLD.getCode() + "\n--- MENU ---" + Typography.RESET.getCode());

            System.out.println("*******************");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "1." + Typography.RESET.getCode() + " Make a figure");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "2." + Typography.RESET.getCode() + " Choose a figure");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "3." + Typography.RESET.getCode() + " Show all created figures");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "4." + Typography.RESET.getCode() + " Leave a program");
            System.out.println("*******************");

            System.out.print("Choose an operation (1-4): ");

            try {
                central_command = scanner.nextInt();
            } catch (InputMismatchException e) {
                central_command = 0;
            } finally {
                scanner.nextLine();
            }

            switch (central_command){
                case 1 -> createFigure();
                case 2 -> useShape();
                case 3 -> displayAllFigures();
                case 4 -> isRunning = false;
                default -> System.out.println("Unknown operation");
            }
        }

        System.out.println("Goodbye and have a great day");
        scanner.close();
    }

    static void createFigure(){
        int figure_choice = 0;
        boolean isNaN;

        System.out.println("\n" + Typography.BOLD.getCode() + "--- CREATOR PANEL ---" + Typography.RESET.getCode());

        System.out.println("Please choose a shape to create");
        System.out.println("****************");
        System.out.println(Typography.BRIGHT_CYAN.getCode() + "1. " + Typography.RESET.getCode() + "Triangle");
        System.out.println(Typography.BRIGHT_CYAN.getCode() + "2. " + Typography.RESET.getCode() + "Square");
        System.out.println(Typography.BRIGHT_CYAN.getCode() + "3. " + Typography.RESET.getCode() + "Circle");
        System.out.println(Typography.BRIGHT_CYAN.getCode() + "4. " + Typography.RESET.getCode() + "Rectangle");
        System.out.println(Typography.BRIGHT_CYAN.getCode() + "5. " + Typography.RESET.getCode() + "Parallelogram");
        System.out.println(Typography.BRIGHT_CYAN.getCode() + "6. " + Typography.RESET.getCode() + "Kite");
        System.out.println(Typography.BRIGHT_CYAN.getCode() + "7. " + Typography.RESET.getCode() + "Trapezoid");
        System.out.println(Typography.BRIGHT_CYAN.getCode() + "8. " + Typography.RESET.getCode() + "Rhombus");
        System.out.println("****************");

        try {
            System.out.print("Now enter your number (1-8): ");
            figure_choice = scanner.nextInt();
            isNaN = false;
        }catch (InputMismatchException e){
            System.out.println(Typography.BRIGHT_RED.getCode() + "This is not a number");
            isNaN = true;
        } finally {
            scanner.nextLine();
        }

        switch (figure_choice){
            case 1 -> createTriangle();
            case 2 -> createSquare();
            case 3 -> createCircle();
            case 4 -> createRectangle();
            case 5 -> createParallelogram();
            case 6 -> createKite();
            case 7 -> createTrapezoid();
            case 8 -> createRhombus();
            default -> {
                String information = !isNaN ? "a wrong number" : "something which is not a number";

                System.out.printf("You typed a %s %n", information);
                System.out.print("Do you want to repeat, if yes enter \"yes\", otherwise the you will return to the menu: ");

                if(scanner.nextLine().equalsIgnoreCase("yes")){
                    createFigure();
                }
            }
        }
    }

    static void createTriangle(){
        String name;

        System.out.println("\n" + Typography.BOLD.getCode() + "--- Square creator panel ---" + Typography.RESET.getCode());

        do {
            System.out.print("Enter a name for a new triangle: ");
            name = scanner.nextLine();
        } while (figures.containsKey(name));

        double a = InputManager.inputDouble("Enter 1st side of triangle: ");

        double b = InputManager.inputDouble("Enter 2nd side of triangle: ");

        double c = InputManager.inputDouble("Enter 3rd side of triangle: ");

        try {
            Triangle triangle = new Triangle(a, b, c);
            figures.put(name, triangle);
        } catch (TriangleInequalityException e) {
            System.out.println(Typography.BRIGHT_RED.getCode() + "The creating of a new triangle, failed due to the triangle inequality rule" + Typography.RESET.getCode());
        } catch (IllegalArgumentException e) {
            System.out.println(Typography.BRIGHT_RED.getCode() + "All arguments must be above 0" + Typography.RESET.getCode());
        }
    }

    static void createSquare(){
        String name;

        System.out.println("\n" + Typography.BOLD.getCode() + "--- Square creator panel ---" + Typography.RESET.getCode());

        do {
            System.out.print("Enter a name for a new square: ");
            name = scanner.nextLine();
        } while (figures.containsKey(name));

        double side = InputManager.inputDouble("Enter side length: ");

        try{
            Square square = new Square(side);
            figures.put(name, square);
            System.out.println(Typography.BRIGHT_GREEN.getCode() + "The square has been made successfully" + Typography.RESET.getCode());
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to create a square, because: " + e);
            System.out.println("If you want to try again enter \"yes\", otherwise you will return to the menu");
            if (scanner.nextLine().equalsIgnoreCase("yes")){
                createSquare();
            }
        }
    }

    static void createCircle(){
        String name;
        double diameter_length;

        System.out.println("\n" + Typography.BOLD.getCode() + "--- Circle creator panel ---" + Typography.RESET.getCode());

        do {
            System.out.print("Enter a name for a new circle: ");
            name = scanner.nextLine();
        } while (figures.containsKey(name));

        diameter_length = InputManager.inputDouble("Enter diameter length: ");

        try {
            Circle circle = new Circle(diameter_length);
            figures.put(name, circle);
            System.out.println(Typography.BRIGHT_GREEN.getCode() + "The circle has been made successfully" + Typography.RESET.getCode());
        } catch (IllegalArgumentException e) {
            System.out.println("Diameter length can not be negative or equal to 0");
        }
    }

    static void createRectangle() {
        System.out.println("\n" + Typography.BOLD.getCode() + "--- Rectangle creator panel ---" + Typography.RESET.getCode());

        String name;
        boolean is_attempted = false;
        do {
            if (is_attempted){
                System.out.println(Typography.BRIGHT_RED.getCode() + "You cannot create with existing name");
            }
            System.out.print("Enter a name for a new rectangle: ");
            name = scanner.nextLine();
            is_attempted = true;
        } while (figures.containsKey(name));

        double sideA = InputManager.inputDouble("Enter first side for the rectangle: ");

        double sideB = InputManager.inputDouble("Enter second side for the rectangle: ");

        try {
            Rectangle rectangle = new Rectangle(sideA, sideB);
            figures.put(name, rectangle);
        } catch (IllegalArgumentException e) {
            System.out.println(Typography.BRIGHT_RED.getCode() + "The numbers can't be negative or less than 0" + Typography.RESET.getCode());
        }
    }

    static void createParallelogram(){
        System.out.println("\n" + Typography.BOLD.getCode() + "--- Parallelogram creator panel ---" + Typography.RESET.getCode());

        String name;
        do {
            System.out.print("Enter a name for a new parallelogram: ");
            name = scanner.nextLine();
        } while (figures.containsKey(name));

        double sideA = InputManager.inputDouble("Enter first side for the parallelogram: ");

        double sideB = InputManager.inputDouble("Enter second side for the parallelogram: ");

        double angle = InputManager.inputDouble("Enter alpha angle (in degrees) for the parallelogram: ");

        try {
            Parallelogram parallelogram = new Parallelogram(sideA, sideB, angle);
            figures.put(name, parallelogram);
        } catch (IllegalArgumentException e) {
            System.out.println(Typography.BRIGHT_RED.getCode() + "The numbers can't be negative or less than 0" + Typography.RESET.getCode());
        } catch (InvalidAngleException e) {
            System.out.println(Typography.BRIGHT_RED.getCode() + "The angle can not be higher or equal to 180 and also can not be 0 or negative" + Typography.RESET.getCode());
        }
    }

    static void createTrapezoid(){
        System.out.println("\n" + Typography.BOLD.getCode() + "--- Trapezoid creator panel ---" + Typography.RESET.getCode());

        String name;
        do {
            System.out.print("Enter a name for a new trapezoid: ");
            name = scanner.nextLine();
        } while (figures.containsKey(name));

        int mode;
        boolean isCreated = false;

        double base1;
        double base2;
        double leg1;
        double leg2;

        do {
            System.out.println("\n" + Typography.BRIGHT_CYAN.getCode() + "1." + Typography.RESET.getCode() + " Using height");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "2." + Typography.RESET.getCode() + " Using angles");
            mode = InputManager.inputInt("Choose a method to create a new trapezoid: ");

            switch (mode){
                case 1 -> {
                    base1 = InputManager.inputDouble("Enter 1st base for the trapezoid: ");
                    base2 = InputManager.inputDouble("Enter 2nd base for the trapezoid: ");
                    leg1 = InputManager.inputDouble("Enter 1st leg for the trapezoid: ");
                    leg2 = InputManager.inputDouble("Enter 2nd leg for the trapezoid: ");

                    double height = InputManager.inputDouble("Enter height for the trapezoid: ");

                    try{
                        Trapezoid trapezoid = new Trapezoid(base1, base2, leg1, leg2, height);
                        figures.put(name, trapezoid);
                        isCreated = true;
                        System.out.println(Typography.BRIGHT_GREEN + "The trapezoid has been created successfully" + Typography.BRIGHT_RED.getCode());
                    } catch (IllegalArgumentException e){
                        System.out.println(Typography.BRIGHT_RED.getCode() + "All arguments must be higher than 0" + Typography.RESET.getCode());
                    }
                }
                case 2 -> {
                    base1 = InputManager.inputDouble("Enter 1st base for the trapezoid: ");
                    base2 = InputManager.inputDouble("Enter 2nd base for the trapezoid: ");
                    leg1 = InputManager.inputDouble("Enter 1st leg for the trapezoid: ");
                    leg2 = InputManager.inputDouble("Enter 2nd leg for the trapezoid: ");

                    double alphaAngle = InputManager.inputDouble("Enter left angle in degrees: ");
                    double betaAngle = InputManager.inputDouble("Enter right angle in degrees: ");

                    try{
                        Trapezoid trapezoid = new Trapezoid(base1, base2, leg1, leg2, alphaAngle, betaAngle);
                        figures.put(name, trapezoid);
                        isCreated = true;
                        System.out.println(Typography.BRIGHT_GREEN + "The trapezoid has been created successfully" + Typography.BRIGHT_RED.getCode());
                    } catch (IllegalArgumentException e){
                        System.out.println(Typography.BRIGHT_RED.getCode() + "All arguments must be higher than 0" + Typography.RESET.getCode());
                    } catch (InvalidAngleException e){
                        System.out.println(Typography.BRIGHT_RED.getCode() + "Angles do not make a valid trapezoid" + Typography.RESET.getCode());
                    }
                }
            }
        } while (!isCreated);
    }

    static void createKite(){
        System.out.println("\n" + Typography.BOLD.getCode() + "--- Kite creator panel ---" + Typography.RESET.getCode());

        String name;
        do {
            System.out.print("Enter a name for a new kite: ");
            name = scanner.nextLine();
        } while (figures.containsKey(name));

        int mode;
        boolean isCreated = false;

        double base1;
        double base2;

        do {
            System.out.println("\n" + Typography.BRIGHT_CYAN.getCode() + "1." + Typography.RESET.getCode() + " Using diagonals");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "2." + Typography.RESET.getCode() + " Using angle");
            mode = InputManager.inputInt("Choose a method to create a new trapezoid: ");

            switch (mode){
                case 1 -> {
                    base1 = InputManager.inputDouble("Enter 1st side for the trapezoid: ");
                    base2 = InputManager.inputDouble("Enter 2nd side for the trapezoid: ");
                    double diagonal1 = InputManager.inputDouble("Enter 1st diagonal for the trapezoid: ");
                    double diagonal2 = InputManager.inputDouble("Enter 2nd diagonal for the trapezoid: ");

                    try{
                        Kite kite = new Kite(base1, base2, diagonal1, diagonal2);
                        figures.put(name, kite);
                        isCreated = true;
                        System.out.println(Typography.BRIGHT_GREEN + "The trapezoid has been created successfully" + Typography.BRIGHT_RED.getCode());
                    } catch (IllegalArgumentException e){
                        System.out.println(Typography.BRIGHT_RED.getCode() + "All arguments must be higher than 0" + Typography.RESET.getCode());
                    }
                }
                case 2 -> {
                    base1 = InputManager.inputDouble("Enter 1st base for the trapezoid: ");
                    base2 = InputManager.inputDouble("Enter 2nd base for the trapezoid: ");

                    double alphaAngle = InputManager.inputDouble("Enter alpha angle for the kite: ");

                    try{
                        Kite kite = new Kite(base1, base2, alphaAngle);
                        figures.put(name, kite);
                        isCreated = true;
                        System.out.println(Typography.BRIGHT_GREEN + "The Kite has been created successfully" + Typography.BRIGHT_RED.getCode());
                    } catch (IllegalArgumentException e){
                        System.out.println(Typography.BRIGHT_RED.getCode() + "All arguments must be higher than 0" + Typography.RESET.getCode());
                    } catch (InvalidAngleException e){
                        System.out.println(Typography.BRIGHT_RED.getCode() + "Angles do not make a valid trapezoid" + Typography.RESET.getCode());
                    }
                }
            }
        } while (!isCreated);
    }

    static void createRhombus() {
        System.out.println("\n" + Typography.BOLD.getCode() + "--- Rhombus creator panel ---" + Typography.RESET.getCode());

        String name;
        do {
            System.out.print("Enter a name for a new rhombus: ");
            name = scanner.nextLine();
        } while (figures.containsKey(name));

        System.out.print("Enter first side for the rhombus: ");
        double sideA = scanner.nextDouble();

        System.out.print("Enter second side for the rhombus: ");
        double sideB = scanner.nextDouble();

        try {
            Rectangle rectangle = new Rectangle(sideA, sideB);
            figures.put(name, rectangle);
        } catch (IllegalArgumentException e) {
            System.out.println(Typography.BRIGHT_RED.getCode() + "The numbers can't be negative or less than 0" + Typography.RESET.getCode());
        } catch (InvalidAngleException e) {
            System.out.println(Typography.BRIGHT_RED.getCode() + "The angle can not be higher or equal to 180 and also can not be 0 or negative" + Typography.RESET.getCode());
        }
    }

    static void displayAllFigures(){
        if(figures.isEmpty()) System.out.println("You didn't created any figure (for now)");
        else {
            String figureType = "";
            for (Map.Entry<String, Shape> entry : figures.entrySet()){
                figureType = switch (entry.getValue().figureType()){
                    case KITE -> "kite";
                    case CIRCLE -> "circle";
                    case SQUARE -> "square";
                    case TRIANGLE -> "triangle";
                    case RHOMBUS -> "rhombus";
                    case RECTANGLE -> "rectangle";
                    case TRAPEZOID -> "trapezoid";
                    case PARALLELOGRAM -> "parallelogram";
                };
                System.out.printf("You have created %s called %s %n", figureType, entry.getKey());
            }
            System.out.println("You have created " + Typography.BOLD.getCode() + figures.size() + Typography.RESET.getCode() + " figures in total");
        }
    }

    static void useShape(){
        if (figures.isEmpty()) {
            System.out.println("You didn't created any figure (for now)");
        } else {
            System.out.print("Enter the name of figure of what you want to choose: ");
            String figureName = scanner.nextLine();

            Shape shape;
            try {
                shape = figures.get(figureName);
            } catch (NullPointerException e){
                System.out.println(Typography.BRIGHT_RED.getCode() + "There is not any shape with the name " + Typography.BOLD.getCode() + figureName + Typography.RESET.getCode());
                System.out.println("Do you want to try again, if yes enter \"yes\", otherwise you will return to the menu");
                if(scanner.nextLine().equalsIgnoreCase("yes")){
                    useShape();
                }
                return;
            }
            FiguresTypes figureType = shape.figureType();

            System.out.println(figureType);
            switch (figureType){
                case CIRCLE -> useCircle((Circle) figures.get(figureName));
                case SQUARE -> useSquare((Square) figures.get(figureName));
                case TRIANGLE -> useTriangle((Triangle) figures.get(figureName));
                case RECTANGLE -> useRectangle((Rectangle) figures.get(figureName));
                case PARALLELOGRAM -> useParallelogram((Parallelogram) figures.get(figureName));
                case TRAPEZOID -> useTrapezoid((Trapezoid) figures.get(figureName));
                case KITE -> useKite((Kite) figures.get(figureName));
                case RHOMBUS -> useRhombus((Rhombus) figures.get(figureName));
            }
        }
    }

    static void useSquare(Square square){
        int figureMethod;
        boolean isUsed = true;

        System.out.println("\n" + Typography.BOLD.getCode() + "--- Square menu ---" + Typography.RESET.getCode());

        while (isUsed) {
            System.out.println("\n" + "******************************");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "1. " + Typography.RESET.getCode() + "Count the area");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "2. " + Typography.RESET.getCode() + "Count the perimeter");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "3. " + Typography.RESET.getCode() + "Count the diagonal");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "4. " + Typography.RESET.getCode() + "Show sides length");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "5. " + Typography.RESET.getCode() + "Leave that figure");
            System.out.println("******************************");

            System.out.print("Enter the command: ");
            figureMethod = scanner.nextInt();
            scanner.nextLine();

            switch (figureMethod) {
                case 1 -> System.out.println("The area of square is: " + Typography.BOLD.getCode() + square.area() + Typography.RESET.getCode());
                case 2 -> System.out.println("The perimeter of square is: " + Typography.BOLD.getCode() + square.perimeter() + Typography.RESET.getCode());
                case 3 -> System.out.println("The diagonal of square is: " + Typography.BOLD.getCode() + square.diagonal() + Typography.RESET.getCode());
                case 4 -> System.out.println("The square sides are: " + Typography.BOLD.getCode() + square.sidesLength() + Typography.RESET.getCode());
                case 5 -> isUsed = false;
                default -> System.out.println("Invalid operation");
            }
        }
    }

    static void useCircle(Circle circle){
        int figureMethod;
        boolean isUsed = true;

        System.out.println("\n" + Typography.BOLD.getCode() + "--- Circle menu ---" + Typography.RESET.getCode());

        while (isUsed) {
            System.out.println("\n" + "******************************");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "1. " + Typography.RESET.getCode() + "Count the area");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "2. " + Typography.RESET.getCode() + "Count the perimeter");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "3. " + Typography.RESET.getCode() + "Count the radius");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "4. " + Typography.RESET.getCode() + "Show the diameter");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "5. " + Typography.RESET.getCode() + "Leave that figure");
            System.out.println("******************************");

            System.out.print("Enter the command: ");
            figureMethod = scanner.nextInt();

            switch (figureMethod){
                case 1 -> System.out.println("The area of circle is: " + Typography.BOLD.getCode() + circle.area() + Typography.RESET.getCode());
                case 2 -> System.out.println("The perimeter of circle is: " + Typography.BOLD.getCode() + circle.perimeter() + Typography.RESET.getCode());
                case 3 -> System.out.println("The radius of circle is: " + Typography.BOLD.getCode() + circle.radius() + Typography.RESET.getCode());
                case 4 -> System.out.println("The diameter of circle is: " + Typography.BOLD.getCode() + circle.diameter() + Typography.RESET.getCode());
                case 5 -> isUsed = false;
                default -> System.out.println("Invalid method");
            }
        }
    }

    static void useTriangle(Triangle triangle){
        int figureMethod;
        boolean isUsed = true;

        System.out.println("\n" + Typography.BOLD.getCode() + "--- Triangle menu ---" + Typography.RESET.getCode());

        while (isUsed) {
            System.out.println("\n" + "******************************");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "1. " + Typography.RESET.getCode() + "Count the area");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "2. " + Typography.RESET.getCode() + "Count the perimeter");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "3. " + Typography.RESET.getCode() + "Show the side a");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "4. " + Typography.RESET.getCode() + "Show the side b");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "5. " + Typography.RESET.getCode() + "Show the side c");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "6. " + Typography.RESET.getCode() + "Count the height a");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "7. " + Typography.RESET.getCode() + "Count the height b");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "8. " + Typography.RESET.getCode() + "Count the height c");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "9. " + Typography.RESET.getCode() + "Show the triangle type");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "10. " + Typography.RESET.getCode() + "Count the alpha angle");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "11. " + Typography.RESET.getCode() + "Count the beta angle");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "12. " + Typography.RESET.getCode() + "Count the delta angle");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "13. " + Typography.RESET.getCode() + "Leave that figure");
            System.out.println("******************************");

            try {
                System.out.print("Enter the command: ");
                figureMethod = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("That's not a number");
                continue;
            }

            switch (figureMethod){
                case 1 -> System.out.println("The area of triangle is: " + Typography.BOLD.getCode() + triangle.area() + Typography.RESET.getCode());
                case 2 -> System.out.println("The perimeter of triangle is: " + Typography.BOLD.getCode() + triangle.perimeter() + Typography.RESET.getCode());
                case 3 -> System.out.println("The side a of triangle is: " + Typography.BOLD.getCode() + triangle.getSideA() + Typography.RESET.getCode());
                case 4 -> System.out.println("The side b of triangle is: " + Typography.BOLD.getCode() + triangle.getSideB() + Typography.RESET.getCode());
                case 5 -> System.out.println("The side c of triangle is: " + Typography.BOLD.getCode() + triangle.getSideC() + Typography.RESET.getCode());
                case 6 -> System.out.println("The height a of triangle is: " + Typography.BOLD.getCode() + triangle.getHeightA() + Typography.RESET.getCode());
                case 7 -> System.out.println("The height b of triangle is: " + Typography.BOLD.getCode() + triangle.getHeightB() + Typography.RESET.getCode());
                case 8 -> System.out.println("The height c of triangle is: " + Typography.BOLD.getCode() + triangle.getHeightC() + Typography.RESET.getCode());
                case 9 -> {
                    TriangleAngleTypes triangleAngleType = triangle.getAngleType();
                    TriangleSideTypes triangleSideType = triangle.getSideType();

                    switch (triangleAngleType){
                        case ACUTE -> {
                            switch (triangleSideType){
                                case EQUILATERAL -> System.out.println("This triangle" + Typography.BOLD.getCode() + " is acute, equilateral" + Typography.RESET.getCode());
                                case ISOSCELES -> System.out.println("This triangle" + Typography.BOLD.getCode() + " is acute, isosceles" + Typography.RESET.getCode());
                                case SCALENE -> System.out.println("This triangle" + Typography.BOLD.getCode() + " is acute, scalene" + Typography.RESET.getCode());
                            }
                        }
                        case RIGHT -> {
                            switch (triangleSideType){
                                case ISOSCELES -> System.out.println("This triangle" + Typography.BOLD.getCode() + " is right, isosceles" + Typography.RESET.getCode());
                                case SCALENE -> System.out.println("This triangle" + Typography.BOLD.getCode() + " is right, scalene" + Typography.RESET.getCode());
                            }
                        }
                        case OBTUSE -> {
                            switch (triangleSideType){
                                case ISOSCELES -> System.out.println("This triangle" + Typography.BOLD.getCode() + " is obtuse, isosceles" + Typography.RESET.getCode());
                                case SCALENE -> System.out.println("This triangle" + Typography.BOLD.getCode() + " is obtuse, scalene" + Typography.RESET.getCode());
                            }
                        }
                    }
                }
                case 10 -> System.out.println("The alpha angle of triangle is: " + Typography.BOLD.getCode() + triangle.getAngleAlpha() + Typography.RESET.getCode());
                case 11 -> System.out.println("The beta angle of triangle is: " + Typography.BOLD.getCode() + triangle.getAngleBeta() + Typography.RESET.getCode());
                case 12 -> System.out.println("The delta angle of triangle is: " + Typography.BOLD.getCode() + triangle.getAngleDelta() + Typography.RESET.getCode());
                case 13 -> isUsed = false;
                default -> System.out.println("Invalid method");
            }
        }
    }

    static void useRectangle(Rectangle rectangle){
        int figureMethod;
        boolean isUsed = true;

        System.out.println("\n" + Typography.BOLD.getCode() + "--- Rectangle Menu ---" + Typography.RESET.getCode());

        while (isUsed) {
            System.out.println("\n******************************");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "1. " + Typography.RESET.getCode() + "Count the area");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "2. " + Typography.RESET.getCode() + "Count the perimeter");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "3. " + Typography.RESET.getCode() + "Count the diagonal");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "4. " + Typography.RESET.getCode() + "Show side a length");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "5. " + Typography.RESET.getCode() + "Show side b length");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "6. " + Typography.RESET.getCode() + "Check if it's a square");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "7. " + Typography.RESET.getCode() + "Leave that figure");
            System.out.println("******************************");

            try {
                System.out.print("Enter the command: ");
                figureMethod = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("That's not a number");
                continue;
            }


            switch (figureMethod) {
                case 1 -> System.out.println("The area of rectangle is: " + Typography.BOLD.getCode() + rectangle.area() + Typography.RESET.getCode());
                case 2 -> System.out.println("The perimeter of rectangle is: " + Typography.BOLD.getCode() + rectangle.perimeter() + Typography.RESET.getCode());
                case 3 -> System.out.println("The diagonal of rectangle is: " + Typography.BOLD.getCode() + rectangle.diagonal() + Typography.RESET.getCode());
                case 4 -> System.out.println("The rectangle side a is: " + Typography.BOLD.getCode() + rectangle.getSideA() + Typography.RESET.getCode());
                case 5 -> System.out.println("The rectangle side b is: " + Typography.BOLD.getCode() + rectangle.getSideB() + Typography.RESET.getCode());
                case 6 -> System.out.println(rectangle.isSquare() ? "This rectangle is a square (all sides are equal)" : "This rectangle is not a square");
                case 7 -> isUsed = false;
                default -> System.out.println("Invalid operation");
            }
        }
    }

    static void useParallelogram(Parallelogram parallelogram){
        int figureMethod;
        boolean isUsed = true;

        System.out.println("\n" + Typography.BOLD.getCode() + "--- Rectangle Menu ---" + Typography.RESET.getCode());

        while (isUsed) {
            System.out.println("\n******************************");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "1. " + Typography.RESET.getCode() + "Count the area");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "2. " + Typography.RESET.getCode() + "Count the perimeter");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "3. " + Typography.RESET.getCode() + "Count the diagonal a");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "4. " + Typography.RESET.getCode() + "Count the diagonal b");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "5. " + Typography.RESET.getCode() + "Show side a length");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "6. " + Typography.RESET.getCode() + "Show side b length");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "7. " + Typography.RESET.getCode() + "Check if it's a rhombus");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "8. " + Typography.RESET.getCode() + "Check if it's a rectangle");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "9. " + Typography.RESET.getCode() + "Check if it's a square");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "10. " + Typography.RESET.getCode() + "Show side alpha angle");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "11. " + Typography.RESET.getCode() + "Show side alpha angle");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "12. " + Typography.RESET.getCode() + "Leave that figure");
            System.out.println("******************************");

            try {
                System.out.print("Enter the command: ");
                figureMethod = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("That's not a number");
                continue;
            }


            switch (figureMethod) {
                case 1 -> System.out.println("The area of parallelogram is: " + Typography.BOLD.getCode() + parallelogram.area() + Typography.RESET.getCode());
                case 2 -> System.out.println("The perimeter of parallelogram is: " + Typography.BOLD.getCode() + parallelogram.perimeter() + Typography.RESET.getCode());
                case 3 -> System.out.println("The diagonal a of parallelogram is: " + Typography.BOLD.getCode() + parallelogram.diagonalA() + Typography.RESET.getCode());
                case 4 -> System.out.println("The diagonal b of parallelogram is: " + Typography.BOLD.getCode() + parallelogram.diagonalB() + Typography.RESET.getCode());
                case 5 -> System.out.println("The parallelogram side a is: " + Typography.BOLD.getCode() + parallelogram.getSideA() + Typography.RESET.getCode());
                case 6 -> System.out.println("The parallelogram side b is: " + Typography.BOLD.getCode() + parallelogram.getSideB() + Typography.RESET.getCode());
                case 7 -> System.out.println(parallelogram.isRhombus() ? "This parallelogram is a square (all sides are equal)" : "This rectangle is not a square");
                case 8 -> System.out.println(parallelogram.isRectangle() ? "This parallelogram is a square (all angles are 90°)" : "This rectangle is not a square");
                case 9 -> System.out.println(parallelogram.isSquare() ? "This parallelogram is a square (all sides are equal and all angles are 90°)" : "This rectangle is not a square");
                case 10 -> System.out.println("The parallelogram alpha angle is: " + Typography.BOLD.getCode() + parallelogram.getAlphaAngleDegrees() + Typography.RESET.getCode());
                case 11 -> System.out.println("The parallelogram beta angle is: " + Typography.BOLD.getCode() + parallelogram.getAlphaAngleDegrees() + Typography.RESET.getCode());
                case 12 -> isUsed = false;
                default -> System.out.println("Invalid operation");
            }
        }
    }

    static void useTrapezoid(Trapezoid trapezoid){
        int figureMethod;
        boolean isUsed = true;

        System.out.println("\n" + Typography.BOLD.getCode() + "--- Trapezoid Menu ---" + Typography.RESET.getCode());

        while (isUsed) {
            System.out.println("\n******************************");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "1. " + Typography.RESET.getCode() + "Count the area");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "2. " + Typography.RESET.getCode() + "Count the perimeter");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "3. " + Typography.RESET.getCode() + "Count the diagonal a");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "4. " + Typography.RESET.getCode() + "Count the diagonal b");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "5. " + Typography.RESET.getCode() + "Show short basis length");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "6. " + Typography.RESET.getCode() + "Show long basis length");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "7. " + Typography.RESET.getCode() + "Show leg 1 length");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "8. " + Typography.RESET.getCode() + "Show leg 2 length");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "9. " + Typography.RESET.getCode() + "Show height");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "10. " + Typography.RESET.getCode() + "Show alpha angle");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "11. " + Typography.RESET.getCode() + "Show beta angle");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "12. " + Typography.RESET.getCode() + "Show gamma angle");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "13. " + Typography.RESET.getCode() + "Show delta angle");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "14. " + Typography.RESET.getCode() + "Leave that figure");
            System.out.println("\n******************************");

            try {
                System.out.print("Enter the command: ");
                figureMethod = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("That's not a number");
                continue;
            }

            switch (figureMethod){
                case 1 -> System.out.println("The area of the trapezoid is: " + Typography.BOLD.getCode() + trapezoid.area() + Typography.RESET.getCode());
                case 2 -> System.out.println("The perimeter of the trapezoid is: " + Typography.BOLD.getCode() + trapezoid.perimeter() + Typography.RESET.getCode());
                case 3 -> System.out.println("The diagonal a of the trapezoid is: " + Typography.BOLD.getCode() + trapezoid.diagonalA() + Typography.RESET.getCode());
                case 4 -> System.out.println("The diagonal b of the trapezoid is: " + Typography.BOLD.getCode() + trapezoid.diagonalB() + Typography.RESET.getCode());
                case 5 -> System.out.println("The short basis of the trapezoid is: " + Typography.BOLD.getCode() + trapezoid.getShortBasis() + Typography.RESET.getCode());
                case 6 -> System.out.println("The long basis of the trapezoid is: " + Typography.BOLD.getCode() + trapezoid.getLongBasis() + Typography.RESET.getCode());
                case 7 -> System.out.println("The leg 1 of the trapezoid is: " + Typography.BOLD.getCode() + trapezoid.getLeg1() + Typography.RESET.getCode());
                case 8 -> System.out.println("The leg 2 of the trapezoid is: " + Typography.BOLD.getCode() + trapezoid.getLeg2() + Typography.RESET.getCode());
                case 9 -> System.out.println("The height of the trapezoid is: " + Typography.BOLD.getCode() + trapezoid.getLeg2() + Typography.RESET.getCode());
                case 10 -> System.out.println("The alpha angle of trapezoid is: " + Typography.BOLD.getCode() + trapezoid.getAlphaAngle() + Typography.RESET.getCode());
                case 11 -> System.out.println("The beta angle of trapezoid is: " + Typography.BOLD.getCode() + trapezoid.getBetaAngle() + Typography.RESET.getCode());
                case 12 -> System.out.println("The gamma angle of trapezoid is: " + Typography.BOLD.getCode() + trapezoid.gammaAngle() + Typography.RESET.getCode());
                case 13 -> System.out.println("The delta angle of trapezoid is: " + Typography.BOLD.getCode() + trapezoid.deltaAngle() + Typography.RESET.getCode());
                case 14 -> isUsed = false;
                default -> System.out.println("Invalid operation");
            }
        }
    }

    static void useKite(Kite kite){
        int figureMethod;
        boolean isUsed = true;

        System.out.println("\n" + Typography.BOLD.getCode() + "--- Trapezoid Menu ---" + Typography.RESET.getCode());

        while (isUsed) {
            System.out.println("\n******************************");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "1. " + Typography.RESET.getCode() + "Count the area");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "2. " + Typography.RESET.getCode() + "Count the perimeter");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "3. " + Typography.RESET.getCode() + "Show diagonal a");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "4. " + Typography.RESET.getCode() + "Show diagonal b");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "5. " + Typography.RESET.getCode() + "Show side a length");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "6. " + Typography.RESET.getCode() + "Show side b length");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "7. " + Typography.RESET.getCode() + "Show alpha angle");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "8. " + Typography.RESET.getCode() + "Show beta angle");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "10. " + Typography.RESET.getCode() + "Leave that figure");
            System.out.println("\n******************************");

            figureMethod = InputManager.inputInt("Enter the command");

            switch (figureMethod){
                case 1 -> System.out.println("The area of the kite is: " + Typography.BOLD.getCode() + kite.area() + Typography.RESET.getCode());
                case 2 -> System.out.println("The perimeter of the kite is: " + Typography.BOLD.getCode() + kite.perimeter() + Typography.RESET.getCode());
                case 3 -> System.out.println("The diagonal a of the kite is: " + Typography.BOLD.getCode() + kite.getDiagonalA() + Typography.RESET.getCode());
                case 4 -> System.out.println("The diagonal b of the kite is: " + Typography.BOLD.getCode() + kite.getDiagonalB() + Typography.RESET.getCode());
                case 5 -> System.out.println("The side a of the kite is: " + Typography.BOLD.getCode() + kite.getSideA() + Typography.RESET.getCode());
                case 6 -> System.out.println("The side b of the kite is: " + Typography.BOLD.getCode() + kite.getSideB() + Typography.RESET.getCode());
                case 7 -> System.out.println("The alpha angle of kite is: " + Typography.BOLD.getCode() + kite.getAlphaAngle() + Typography.RESET.getCode());
                case 8 -> System.out.println("The beta angle of kite is: " + Typography.BOLD.getCode() + kite.betaAngle() + Typography.RESET.getCode());
                case 9 -> System.out.println(kite.isRhombus() ? "This kite is a rhombus (all sides are equal)" : "This kite is not a rhombus");
                case 10 -> isUsed = false;
            }
        }
    }

    static void useRhombus(Rhombus rhombus){
        int figureMethod;
        boolean isUsed = true;

        System.out.println("\n" + Typography.BOLD.getCode() + "--- Rectangle Menu ---" + Typography.RESET.getCode());

        while (isUsed) {
            System.out.println("\n******************************");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "1. " + Typography.RESET.getCode() + "Count the area");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "2. " + Typography.RESET.getCode() + "Count the perimeter");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "3. " + Typography.RESET.getCode() + "Count the diagonal a");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "4. " + Typography.RESET.getCode() + "Count the diagonal b");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "5. " + Typography.RESET.getCode() + "Show sides length");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "6. " + Typography.RESET.getCode() + "Check if it's a square");
            System.out.println(Typography.BRIGHT_CYAN.getCode() + "7. " + Typography.RESET.getCode() + "Leave that figure");
            System.out.println("******************************");

            try {
                System.out.print("Enter the command: ");
                figureMethod = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("That's not a number");
                continue;
            }

            switch (figureMethod) {
                case 1 -> System.out.println("The area of rhombus is: " + Typography.BOLD.getCode() + rhombus.area() + Typography.RESET.getCode());
                case 2 -> System.out.println("The perimeter of rhombus is: " + Typography.BOLD.getCode() + rhombus.perimeter() + Typography.RESET.getCode());
                case 3 -> System.out.println("The diagonal a of rhombus is: " + Typography.BOLD.getCode() + rhombus.diagonalA() + Typography.RESET.getCode());
                case 4 -> System.out.println("The diagonal b of rhombus is: " + Typography.BOLD.getCode() + rhombus.diagonalB() + Typography.RESET.getCode());
                case 5 -> System.out.println("The rhombus sides length is: " + Typography.BOLD.getCode() + rhombus.getSides() + Typography.RESET.getCode());
                case 6 -> System.out.println(rhombus.isSquare() ? "This rhombus is a square (all angles equals 90°)" : "This rhombus is not a square");
                case 7 -> isUsed = false;
                default -> System.out.println("Invalid operation");
            }
        }
    }
}
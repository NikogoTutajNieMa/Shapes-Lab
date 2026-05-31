# Shapes

A Java object-oriented programming project focused on modeling and analyzing geometric figures. The application allows users to create various 2D shapes, calculate their properties, classify them, and explore relationships between different geometric figures through inheritance and polymorphism.

## Features

### Supported Shapes

* Circle
* Triangle
* Square
* Rectangle
* Parallelogram
* Rhombus
* Kite (Deltoid)
* Trapezoid

### Geometric Calculations

Depending on the shape, the application can calculate:

* Area
* Perimeter
* Heights
* Angles
* Side lengths
* Shape classifications

### Shape Classification

#### Triangles

Classification by sides:

* Equilateral
* Isosceles
* Scalene

Classification by angles:

* Acute
* Right
* Obtuse

#### Trapezoids

Classification by angle configuration:

* Acute trapezoid
* Right trapezoid
* Obtuse trapezoid

## Object-Oriented Design

The project was developed to demonstrate key Object-Oriented Programming concepts:

### Interfaces

The `Shape` interface defines a common contract for all geometric figures:

```java
public interface Shape {
    double area();
    double perimeter();
    FiguresTypes figureType();
}
```

### Inheritance

The project uses an inheritance hierarchy to model relationships between geometric figures:

```text
Shape
├── Circle
├── Triangle
└── Quadrilateral
    ├── Trapezoid
    ├── Kite
    └── Parallelogram
        ├── Rectangle
        │   └── Square
        └── Rhombus
```

### Polymorphism

All figures can be handled through the common `Shape` interface, allowing generic operations regardless of the concrete figure type.

### Encapsulation

Shape properties are stored as private or protected fields and accessed through dedicated methods.

### Enums

Enums are used to represent:

* Figure types
* Triangle side classifications
* Triangle angle classifications

Additionaly one enum was made to use ANSII Escape Code

### Custom Exceptions

The project includes custom exceptions for invalid geometric configurations:

* `TriangleInequalityException`
* `InvalidAngleException`

These exceptions help ensure that only mathematically valid figures can be created.

## Validation

The application validates user input and geometric constraints, including:

* Positive side lengths
* Valid angle ranges
* Triangle inequality theorem
* Shape-specific geometric requirements

## Console Application

The project includes an interactive console interface that allows users to:

1. Create geometric figures
2. Store created figures
3. Browse existing figures
4. Perform calculations on selected figures
5. Display information about all created figures

## Technologies

* Java
* Object-Oriented Programming (OOP)
* Collections Framework (`HashMap`)
* Enums
* Custom Exceptions
* Mathematical Geometry

## Educational Goals

The main purpose of this project is to practice:

* Object-Oriented Design
* Inheritance Hierarchies
* Interface-Based Programming
* Exception Handling
* Geometric Algorithms
* Mathematical Modeling
* Clean Java Code Practices

## Future Development

Planned improvements include:

* Additional geometric figures
* More advanced geometric constructions
* Coordinate-based figure creation
* Shape transformations
* SVG or graphical visualization
* Unit tests
* JavaDoc documentation
* Serialization and file saving
* Support for concave quadrilaterals

## Author

Created by Oskar Faluszewski

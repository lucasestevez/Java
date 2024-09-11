package Geometry_Calculator.Flat.Square;

import Geometry_Calculator.Flat.FlatFigure;

public class Square implements FlatFigure {

    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return Math.pow(this.side, 2);
    }

    @Override
    public double perimeter() {
        return this.side * 4;
    }
}

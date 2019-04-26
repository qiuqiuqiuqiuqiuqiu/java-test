package com.test.design;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        Color color1 = colorFactory.getColor("RED");
        color1.fill();
        Color color2 = colorFactory.getColor("GREEN");
        color2.fill();
    }
}

class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if("SHAPE".equalsIgnoreCase(choice)) {
            return new ShapeAbstractFactory();
        } else if("COLOR".equalsIgnoreCase(choice)){
            return new ColorAbstractFactory();
        }
        return null;
    }
}

abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}

interface Shape{
    void draw();
}

class Square implements Shape {
    @Override
    public void draw(){
        System.out.println("Square draw() method.");
    }
}

class Circle implements Shape {
    @Override
    public void draw(){
        System.out.println("Circle draw() method.");
    }
}

class ShapeAbstractFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shape) {
        if (shape == null) return null;
        if("SQUARE".equalsIgnoreCase(shape)) {
            return new Square();
        } else if("CIRCLE".equalsIgnoreCase(shape)){
            return new Circle();
        }
        return null;
    }

    @Override
    public Color getColor(String color){
        return null;
    }
}

interface Color {
    void fill();
}

class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Red fill() method.");
    }
}

class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Green fill() method.");
    }
}

class ColorAbstractFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if (color == null) return null;
        if("RED".equalsIgnoreCase(color)) {
            return new Red();
        } else if("GREEN".equalsIgnoreCase(color)){
            return new Green();
        }
        return null;
    }
    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
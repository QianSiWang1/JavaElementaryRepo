package com.qy.designpattern.behavioral.visitor;

// 对象结构
class ShapeStructure {
    private java.util.ArrayList<Shape> shapes = new java.util.ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void accept(Visitor visitor) {
        for (Shape shape : shapes) {
            shape.accept(visitor);
        }
    }
}

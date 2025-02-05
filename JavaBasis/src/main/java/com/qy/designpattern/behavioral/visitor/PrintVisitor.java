package com.qy.designpattern.behavioral.visitor;

// 具体访问者：打印信息
class PrintVisitor implements Visitor {
    @Override
    public void visit(Circle circle) {
        System.out.println("This is a circle with radius: " + circle.getRadius());
    }

    @Override
    public void visit(Rectangle rectangle) {
        System.out.println("This is a rectangle with width: " + rectangle.getWidth() +
                " and height: " + rectangle.getHeight());
    }
}

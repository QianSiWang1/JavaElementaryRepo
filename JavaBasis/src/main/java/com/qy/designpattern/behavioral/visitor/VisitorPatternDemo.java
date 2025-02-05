package com.qy.designpattern.behavioral.visitor;

// 客户端代码
public class VisitorPatternDemo {
    public static void main(String[] args) {
        // 创建对象结构
        ShapeStructure shapeStructure = new ShapeStructure();
        shapeStructure.addShape(new Circle(5));
        shapeStructure.addShape(new Rectangle(3, 4));

        // 创建访问者
        Visitor areaVisitor = new AreaVisitor();
        Visitor printVisitor = new PrintVisitor();

        // 让访问者访问对象结构
        shapeStructure.accept(areaVisitor);
        shapeStructure.accept(printVisitor);
    }
}

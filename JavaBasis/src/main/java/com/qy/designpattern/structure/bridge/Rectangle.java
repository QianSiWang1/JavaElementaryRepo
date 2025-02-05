package com.qy.designpattern.structure.bridge;

// 扩展抽象化角色：矩形
class Rectangle extends Shape {
    public Rectangle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Drawing a rectangle. ");
        color.applyColor();
    }
}

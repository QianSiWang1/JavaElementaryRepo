package com.qy.designpattern.structure.bridge;

// 扩展抽象化角色：圆形
class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Drawing a circle. ");
        color.applyColor();
    }
}

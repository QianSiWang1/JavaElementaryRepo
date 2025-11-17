package com.qy._99_design_pattern.structure.bridge;

// 抽象化角色：图形抽象类
abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}

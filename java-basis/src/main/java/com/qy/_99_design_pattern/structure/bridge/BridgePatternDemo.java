package com.qy._99_design_pattern.structure.bridge;

// 客户端代码
public class BridgePatternDemo {
    public static void main(String[] args) {
        // 创建红色圆形
        Shape redCircle = new Circle(new RedColor());
        redCircle.draw();

        // 创建蓝色矩形
        Shape blueRectangle = new Rectangle(new BlueColor());
        blueRectangle.draw();
    }
}

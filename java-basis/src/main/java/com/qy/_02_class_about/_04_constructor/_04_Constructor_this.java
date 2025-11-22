package com.qy._02_class_about._04_constructor;

public class _04_Constructor_this {
    public static void main(String[] args) {
        _04_Constructor_this rect1 = new _04_Constructor_this();
        // 输出:
        // 全参数构造器完成
        // 尺寸构造器完成
        // 无参构造器完成

        rect1.display();  // 10x5, Color: White
    }
    private int width;
    private int height;
    private String color;

    // 无参构造器
    public _04_Constructor_this() {
        this(10, 5, "White");  // 调用三参数构造器
        System.out.println("无参构造器完成");
    }

    // 带尺寸的构造器
    public _04_Constructor_this(int width, int height) {
        this(width, height, "Black");  // 调用三参数构造器
        System.out.println("尺寸构造器完成");
    }

    // 全参数构造器
    public _04_Constructor_this(int width, int height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
        System.out.println("全参数构造器完成");
    }

    public void display() {
        System.out.println(width + "x" + height + ", Color: " + color);
    }
}

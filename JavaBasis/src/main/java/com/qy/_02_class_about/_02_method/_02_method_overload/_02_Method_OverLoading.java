package com.qy._02_class_about._02_method._02_method_overload;

public class _02_Method_OverLoading {
    public static void main(String[] args) {
        _02_Method_OverLoading demo = new _02_Method_OverLoading();
        demo.print("Hello");                    // 调用单参数方法
        demo.print("Hello", "World");           // 调用双参数方法
        demo.print("A", "B", "C");              // 调用可变参数方法
        demo.print(new String[]{"X", "Y"});     // 调用可变参数方法
    }
    public void print(String... messages) {

        System.out.println("可变参数方法");
        for (String msg : messages) {
            System.out.println(msg);
        }
    }

    public void print(String message) {
        System.out.println("单参数方法: " + message);
    }

    public void print(String message1, String message2) {
        System.out.println("双参数方法: " + message1 + ", " + message2);
    }
}

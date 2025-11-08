package com.qy._02_class_about._02_method._01_method_hiding;

public class Parent {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Parent childAsParent = new Child();  // 父类引用指向子类对象
        Child child = new Child();

        System.out.println("=== static 方法调用（方法隐藏）===");
        Parent.staticMethod();        // 输出: Parent's static method
        Child.staticMethod();         // 输出: Child's static method
        parent.staticMethod();        // 输出: Parent's static method
        childAsParent.staticMethod(); // 输出: Parent's static method（看引用类型！）
        child.staticMethod();         // 输出: Child's static method

        System.out.println("\n=== 实例方法调用（方法重写）===");
        parent.instanceMethod();        // 输出: Parent's instance method
        childAsParent.instanceMethod(); // 输出: Child's instance method（看对象类型！）
        child.instanceMethod();         // 输出: Child's instance method
    }
    public static void staticMethod() {
        System.out.println("Parent's static method");
    }

    public void instanceMethod() {
        System.out.println("Parent's instance method");
    }
}

class Child extends Parent {
    // 这是方法隐藏，不是重写
    public static void staticMethod() {
        System.out.println("Child's static method");
    }

    // 这是方法重写
    @Override
    public void instanceMethod() {
        System.out.println("Child's instance method");
    }
}

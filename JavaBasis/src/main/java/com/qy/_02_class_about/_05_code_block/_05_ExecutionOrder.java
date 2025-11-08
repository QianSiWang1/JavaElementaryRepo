package com.qy._02_class_about._05_code_block;

public class _05_ExecutionOrder {
    // 静态变量
    private static String staticVar = "静态变量";

    // 静态初始化块
    static {
        System.out.println("1. 静态初始化块: " + staticVar);
    }

    // 实例变量
    private String instanceVar = "实例变量";

    // 实例初始化块1
    {
        System.out.println("3. 实例初始化块1: " + instanceVar);
        System.out.println("   可以访问静态变量: " + staticVar);
    }

    // 构造器
    public _05_ExecutionOrder() {
        System.out.println("4. 构造器执行");
        System.out.println("   实例变量: " + instanceVar);
        System.out.println("   静态变量: " + staticVar);
    }

    // 实例初始化块2
    {
        System.out.println("5. 实例初始化块2");
    }

    // 静态初始化块2
    static {
        System.out.println("2. 静态初始化块2");
    }

    public static void main(String[] args) {
        System.out.println("程序开始");
        System.out.println("创建第一个对象:");
        _05_ExecutionOrder obj1 = new _05_ExecutionOrder();

        System.out.println("\n创建第二个对象:");
        _05_ExecutionOrder obj2 = new _05_ExecutionOrder();
    }
}

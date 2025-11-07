package com.qy._01_basic;

import java.util.Properties;

public class _03_Keyword_static {
    public _03_Keyword_static() {

    }

    public static void main(String[] args) {
        // 访问静态变量（推荐方式）
        System.out.println(_03_Keyword_static.school);  // 清华大学
        System.out.println(_03_Keyword_static.studentCount);  // 0

        _03_Keyword_static s1 = new _03_Keyword_static("张三", 20);
        _03_Keyword_static s2 = new _03_Keyword_static("李四", 21);

        System.out.println(_03_Keyword_static.studentCount);  // 2
        System.out.println(s1.studentCount);       // 2（不推荐这样访问）
        System.out.println(s2.studentCount);       // 2

        // 修改静态变量会影响所有实例
        _03_Keyword_static.school = "北京大学";
        System.out.println(s1.school);  // 北京大学
        System.out.println(s2.school);  // 北京大学

        // 创建静态内部类实例（不需要外部类实例）
        _03_Keyword_static.StaticNestedClass nested = new _03_Keyword_static.StaticNestedClass(100);
        nested.display();
        _03_Keyword_static.StaticNestedClass.staticMethod();

        // 创建非静态内部类实例（需要外部类实例）
        _03_Keyword_static outer = new _03_Keyword_static();
        _03_Keyword_static.InnerClass inner = outer.new InnerClass();
        inner.display();
    }

    // 实例变量 - 每个对象独立拥有
    String name;
    int age;

    // 静态变量 - 所有对象共享
    static String school = "清华大学";
    static int studentCount = 0;

    public _03_Keyword_static(String name, int age) {
        this.name = name;
        this.age = age;
        studentCount++;  // 所有对象共享同一个计数器
    }

    /*
    ========================================================================================================================
    */
    // 静态方法
    public static int add(int a, int b) {
        return a + b;
    }

    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    // 错误示例：静态方法中访问实例变量
    // private String name;
    // public static void printName() {
    //     System.out.println(name);  // 编译错误
    // }
/*
========================================================================================================================
*/
    // 静态变量
    static String url;
    static String username;
    static String password;
    static Properties props;

    // 静态代码块 - 在类加载时执行
    static {
        System.out.println("加载数据库配置...");
        props = new Properties();
        try {
            // 从配置文件加载配置
            //props.load(DatabaseConfig.class.getResourceAsStream("/db.properties"));
            url = props.getProperty("db.url");
            username = props.getProperty("db.username");
            password = props.getProperty("db.password");
        } catch (Exception e) {
            // 设置默认值
            url = "jdbc:mysql://localhost:3306/test";
            username = "root";
            password = "123456";
        }
    }

    // 另一个静态代码块
    static {
        System.out.println("数据库配置加载完成");
    }

    /*
    ========================================================================================================================
    */
    private static String staticField = "静态字段";
    private String instanceField = "实例字段";

    // 静态内部类
    static class StaticNestedClass {
        private int nestedField;

        public StaticNestedClass(int value) {
            this.nestedField = value;
            // 可以访问外部类的静态成员
            System.out.println(staticField);
            // 不能访问外部类的实例成员
            // System.out.println(instanceField);  // 编译错误
        }

        public void display() {
            System.out.println("静态内部类: " + nestedField);
        }

        // 静态内部类可以有静态方法
        public static void staticMethod() {
            System.out.println("静态内部类的静态方法");
        }
    }

    // 非静态内部类（对比）
    class InnerClass {
        public void display() {
            // 可以访问外部类的所有成员
            System.out.println(staticField);
            System.out.println(instanceField);
        }
    }
}

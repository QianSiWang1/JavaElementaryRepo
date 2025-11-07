package com.qy._01_basic;

import java.util.ArrayList;
import java.util.List;

public class _02_Keyword_final {
    /**
     * final修饰实例变量
     */
    final int id;          // 必须在声明时或构造器中初始化
    final String name = "张三"; // 声明时初始化
    public _02_Keyword_final(int id) {
        this.id = id;      // 在构造器中初始化
    }
    // 错误示例：final变量未初始化
    // final int age;      // 编译错误


    /*
    final修饰静态变量
     */
    public static final double PI = 3.14159;        // 声明时初始化
    public static final int MAX_VALUE;
    static {
        MAX_VALUE = 100;   // 在静态代码块中初始化
    }

    /**
     * final修饰局部变量
     */
    public void process() {
        final int localVar = 10;    // 必须在声明时初始化
        // localVar = 20;           // 错误：不能重新赋值
        final List<String> list = new ArrayList<>();
        list.add("item");           // 正确：可以修改对象内容
        // list = new ArrayList<>(); // 错误：不能重新赋值引用
    }

    /*
     * final修饰参数
     */
    public void process(final int x, final String str) {
        // x = 5;        // 错误：不能修改final参数
        // str = "new";  // 错误：不能修改final参数
        System.out.println(x + str);
    }

    class Parent {
        // final方法，不能被子类重写
        public final void finalMethod() {
            System.out.println("这是final方法");
        }

        // 普通方法，可以重写
        public void normalMethod() {
            System.out.println("普通方法");
        }

        // final方法可以重载
        public final void finalMethod(int x) {
            System.out.println("重载的final方法");
        }
    }

    class Child extends Parent {
        // 正确：可以重写普通方法
        @Override
        public void normalMethod() {
            System.out.println("子类重写的方法");
        }

        // 错误：不能重写final方法
        // @Override
        // public final void finalMethod() { }
    }

    final class FinalClass {
        public void show() {
            System.out.println("final类的方法");
        }
    }

    // 错误：不能继承final类
    // class SubClass extends FinalClass { }
}

package com.qy.objectoriented.method;

/**
 * @Author QianSiWang
 * @Date 2022/7/13 10:22
 * @Description 验证构造方法的子类
 */
public class ConstructorB extends ConstructorA{
    public ConstructorB() {
        System.out.println("B 无参构造");
    }

    public ConstructorB(String str) {
        System.out.println("B 带参数: " + str + "的构造器");

    }

    public ConstructorB(int num) {
        super("AAA");
        //this("BBB");//不能在同一个构造方法中同时显式调用自己的和父类的构造方法，它们都要求放在第一行，产生冲突。
        System.out.println("B 带参数: " + num + "的构造器");

    }

    public static void main(String[] args) {
        new ConstructorB(1);
    }
}

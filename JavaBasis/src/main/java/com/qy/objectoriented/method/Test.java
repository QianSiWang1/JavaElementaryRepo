package com.qy.objectoriented.method;

/**
 * @Author QianSiWang
 * @Date 2022/7/12 9:25
 * @Description 关于普通成员变量，静态成员变量，普通方法，静态方法的测试
 */
public class Test {
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.nonStaticStr);
        System.out.println(c.staticStr);
        c.staticMethod();//输出的结果都是父类中的非静态属性、静态属性和静态方法,推出静态属性和静态方法可以被继承

        System.out.println("-------------------------------");

        A c1 = new C();
        System.out.println(c1.nonStaticStr);
        System.out.println(c1.staticStr);
        c1.staticMethod();//结果同上，输出的结果都是父类中的非静态属性、静态属性和静态方法,推出静态属性和静态方法可以被继承

        System.out.println("-------------------------------");
        B b = new B();
        System.out.println(b.nonStaticStr);
        System.out.println(b.staticStr);
        b.staticMethod();//子类的静态方法
        b.nonStaticMethod();//子类的非静态方法

        System.out.println("-------------------------------");
        A b1 = new B();
        System.out.println(b1.nonStaticStr);
        System.out.println(b1.staticStr);
        b1.staticMethod();//父类的静态方法，说明静态方法不可以被重写，不能实现多态
        b1.nonStaticMethod();//子类的非静态方法
    }

}

package com.qy._02_class_about._08_inner_class;

/**
 * @Author QianSiWang
 * @Date 2022/7/31 11:17
 * @Description 非静态成员内部类
 */
// 如果出现了重名现象，那么格式是：外部类名称.this.外部类成员变量名
public class Outer {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.new Inner();
        inner.methodInner();

    }

    int num = 10; // 外部类的成员变量

    public class Inner /*extends Object*/ {

        int num = 20; // 内部类的成员变量

        public void methodInner() {
            int num = 30; // 内部类方法的局部变量
            System.out.println(num); // 局部变量，就近原则
            System.out.println(this.num); // 内部类的成员变量
            System.out.println(Outer.this.num); // 外部类的成员变量
        }

    }

    static class StaticInner{
        public int age;

        public String name;

        public void staticInnerFunc(){
            System.out.println("静态内部类中的方法");
        }
    }

}

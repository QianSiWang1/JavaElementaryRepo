package com.qy.objectoriented.method;

/**
 * @Author QianSiWang
 * @Date 2022/7/12 9:24
 * @Description
 */
public class B extends A{//子类B
    public static String staticStr = "B改写后的静态属性";
    public String nonStaticStr = "B改写后的非静态属性";
    public static void staticMethod(){
        System.out.println("B改写后的静态方法");
    }
    public void nonStaticMethod(){
        System.out.println("B改写后的非静态方法");
    }
}
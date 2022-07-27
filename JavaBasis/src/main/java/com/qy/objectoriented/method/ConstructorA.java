package com.qy.objectoriented.method;

/**
 * @Author QianSiWang
 * @Date 2022/7/13 10:21
 * @Description 验证构造方法的父类
 */
public class ConstructorA {
    public ConstructorA() {
        System.out.println("A 无参构造");
    }

    public ConstructorA(String str){
        System.out.println("A 带参数：" + str + "的构造器");
    }
}

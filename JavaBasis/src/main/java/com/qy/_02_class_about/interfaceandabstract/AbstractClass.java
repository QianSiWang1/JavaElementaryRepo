package com.qy._02_class_about.interfaceandabstract;

/**
 * @Author QianSiWang
 * @Date 2022/7/30 21:49
 * @Description
 */
public abstract class AbstractClass {
    AbstractClass(){
        System.out.println("抽象类中的构造器");
    }

    {
        System.out.println("抽象方法中的代码块");
    }
    public void funcCommon(){
        System.out.println("抽象类中的普通方法");
    }

    public abstract void func1();

    public abstract void func2();
}

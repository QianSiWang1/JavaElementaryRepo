package com.qy.classabout.interfaceandabstract;

/**
 * @Author QianSiWang
 * @Date 2022/7/30 17:21
 * @Description 接口可以继承多个父接口
 */
public interface Interface1 extends Interface2,Interface3{
    public int a = 0;
//    Interface1(){
//        System.out.println("接口中不能够构造器");
//    }

//    {
//        System.out.println("接口中不能有代码块");
//    }

    // Java8 接口中可以有类方法
    public static void func1(){
        System.out.println("接口中的类方法");
    }
    // Java8 接口中可以有default修饰的默认方法
    default void func2(){
        System.out.println("接口中的默认方法");
    }

    //默认default抽象方法
    void func3();

    // public 抽象方法 不能有实现体
    public void func4();

    //私有方法提供实现
//    private void func5(){
//        System.out.println("Java 9 中 可以有私有方法");
//    }

}

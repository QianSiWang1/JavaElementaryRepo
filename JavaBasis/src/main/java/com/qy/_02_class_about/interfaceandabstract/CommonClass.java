package com.qy._02_class_about.interfaceandabstract;

/**
 * @Author QianSiWang
 * @Date 2022/7/30 21:57
 * @Description
 */
public class CommonClass extends AbstractClass implements Interface1 {
    public static void main(String[] args) {
        CommonClass commonClass = new CommonClass();
        commonClass.func1();
        commonClass.func2();
    }

    //抽象类 与 接口中func1
    @Override
    public void func1(){
        System.out.println("func1 where?");
    }

    @Override
    public void func2() {
        //这边的func2挺有意思
        //Interface1.super.func2();
        System.out.println("func2 where?");

    }

    @Override
    public void func3() {

    }

    @Override
    public void func4() {

    }

    CommonClass() {
        super();
    }
}

package com.qy.objectoriented.interfaceandabstract;

/**
 * @Author QianSiWang
 * @Date 2022/7/30 21:57
 * @Description
 */
public class CommonClass extends AbstractClass implements Interface1 {


    @Override
    public void func2() {
        //这边的func2挺有意思
        Interface1.super.func2();
    }

    @Override
    public void func3() {

    }

    @Override
    public void func4() {

    }
}

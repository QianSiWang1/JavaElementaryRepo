package com.qy.objectoriented.innerclass;

/**
 * 匿名内部类测试 使用到的接口实现类
 */
public class MyInterfaceImpl implements MyInterface {
    @Override
    public void method1() {
        System.out.println("实现类覆盖重写了方法！111");
    }

    @Override
    public void method2() {
        System.out.println("实现类覆盖重写了方法！222");
    }
}

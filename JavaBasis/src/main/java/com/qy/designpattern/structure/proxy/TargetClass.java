package com.qy.designpattern.structure.proxy;

// 目标类，这是一个普通类，没有实现任何接口
public class TargetClass {
    public String doSomething() {
        System.out.println("TargetClass is doing something.");
        return "Result from TargetClass";
    }
}

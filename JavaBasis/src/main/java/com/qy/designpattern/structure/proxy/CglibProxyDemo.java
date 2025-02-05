package com.qy.designpattern.structure.proxy;

import net.sf.cglib.proxy.Enhancer;

public class CglibProxyDemo {
    public static void main(String[] args) {
        // 创建 Enhancer 对象，用于生成代理类
        Enhancer enhancer = new Enhancer();
        // 设置要代理的目标类
        enhancer.setSuperclass(TargetClass.class);
        // 设置方法拦截器
        enhancer.setCallback(new MyMethodInterceptor());
        // 创建代理对象
        TargetClass proxy = (TargetClass) enhancer.create();
        // 调用代理对象的方法
        String result = proxy.doSomething();
        System.out.println("Result: " + result);
    }
}

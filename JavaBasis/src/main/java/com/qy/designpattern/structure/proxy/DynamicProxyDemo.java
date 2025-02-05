package com.qy.designpattern.structure.proxy;

import java.lang.reflect.Proxy;

// 客户端代码
public class DynamicProxyDemo {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        ProxyInvocationHandler handler = new ProxyInvocationHandler(realSubject);
        Subject proxySubject = (Subject) Proxy.newProxyInstance(
                Subject.class.getClassLoader(),
                new Class<?>[]{Subject.class},
                handler
        );
        proxySubject.request();
    }
}

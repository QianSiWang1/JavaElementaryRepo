package com.qy._99_design_pattern.structure.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 调用处理器
class ProxyInvocationHandler implements InvocationHandler {
    private Object target;

//    public ProxyInvocationHandler(Object target) {
//        this.target = target;
//    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy: Before handling request.");
        //Object result = method.invoke(target, args);
        System.out.println("Proxy: After handling request.");
        return null;
    }
}

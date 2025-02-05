package com.qy.designpattern.structure.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

// 方法拦截器，实现 MethodInterceptor 接口
public class MyMethodInterceptor implements MethodInterceptor {
    /**
     * 拦截目标方法的调用
     * @param obj 被代理的对象
     * @param method 被拦截的方法
     * @param args 方法的参数
     * @param proxy 用于调用原始方法的代理对象
     * @return 方法调用的结果
     * @throws Throwable 可能抛出的异常
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        // 在调用目标方法之前执行的额外逻辑
        System.out.println("Before method call");
        // 调用目标方法
        Object result = proxy.invokeSuper(obj, args);
        // 在调用目标方法之后执行的额外逻辑
        System.out.println("After method call");
        return result;
    }
}

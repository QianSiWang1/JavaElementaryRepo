package com.qy.jvm._01_memory_structure._01_oom_case;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * VM Args： -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * jdk8 -XX：MaxMetaspaceSize=10M
 * Caused by: java.lang.OutOfMemoryError: Metaspace
 * 	at java.lang.ClassLoader.defineClass1(Native Method)
 * 	at java.lang.ClassLoader.defineClass(ClassLoader.java:763)
 * 	... 11 more
 * @author zzm
 */
public class _08_JavaMethodAreaOOM {

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject {
    }
}

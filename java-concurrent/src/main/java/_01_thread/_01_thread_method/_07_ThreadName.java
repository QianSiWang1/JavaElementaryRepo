package _01_thread._01_thread_method;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程命名的重要性：
 * 1. 便于调试和监控
 * 2. 线程转储时能清晰识别
 * @author qy
 */
public class _07_ThreadName {


    public static void threadNaming() {
        // 方式1: 通过构造器命名
        Thread thread1 = new Thread(() -> {
        }, "数据库连接线程");

        // 方式2: 通过setName()命名
        Thread thread2 = new Thread(() -> {
        });
        thread2.setName("日志处理线程");

        // 方式3: 使用线程工厂
        ThreadFactory factory = new ThreadFactory() {
            private final AtomicInteger counter = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Worker-" + counter.getAndIncrement());
            }
        };

        Thread thread3 = factory.newThread(() -> {
        });

        System.out.println("Thread1: " + thread1.getName());
        System.out.println("Thread2: " + thread2.getName());
        System.out.println("Thread3: " + thread3.getName());
    }

    /**
     * 获取当前线程名称
     */
    public static void currentThreadName() {
        System.out.println("当前线程: " + Thread.currentThread().getName());

        // 在Lambda表达式中获取线程名
        Runnable task = () -> {
            System.out.println("执行线程: " + Thread.currentThread().getName());
        };

        new Thread(task, "自定义线程").start();
    }

}

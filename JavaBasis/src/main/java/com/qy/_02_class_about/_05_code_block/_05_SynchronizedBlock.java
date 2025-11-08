package com.qy._02_class_about._05_code_block;

public class _05_SynchronizedBlock {
    private int count = 0;
    private final Object lock = new Object(); // 专门的锁对象

    // 使用同步代码块保护共享资源
    public void increment() {
        synchronized (lock) { // 同步代码块
            count++;
            System.out.println(Thread.currentThread().getName() + " - Count: " + count);
        }
    }

    // 使用this作为锁对象
    public void decrement() {
        synchronized (this) { // 使用当前对象作为锁
            count--;
            System.out.println(Thread.currentThread().getName() + " - Count: " + count);
        }
    }

    // 同步静态方法使用的代码块
    private static int staticCount = 0;
    private static final Object staticLock = new Object();

    public static void incrementStatic() {
        synchronized (staticLock) { // 同步静态变量
            staticCount++;
            System.out.println(Thread.currentThread().getName() + " - StaticCount: " + staticCount);
        }
    }
}

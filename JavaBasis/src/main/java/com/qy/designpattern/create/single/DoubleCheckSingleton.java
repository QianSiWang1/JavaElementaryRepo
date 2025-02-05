package com.qy.designpattern.create.single;

public class DoubleCheckSingleton {
    // 使用volatile禁止指令重排序
    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {}

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {                    // 第一次检查
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {            // 第二次检查
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}

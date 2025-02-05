package com.qy.designpattern.create.single;

public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
    }

    // 线程不安全！
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}

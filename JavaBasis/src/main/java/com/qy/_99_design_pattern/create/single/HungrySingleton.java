package com.qy._99_design_pattern.create.single;

public class HungrySingleton {
    // 类加载时直接初始化实例
    private static final HungrySingleton instance = new HungrySingleton();

    // 私有构造函数
    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return instance;
    }
}

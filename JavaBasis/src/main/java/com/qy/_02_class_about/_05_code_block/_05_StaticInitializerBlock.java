package com.qy._02_class_about._05_code_block;

import java.util.HashMap;
import java.util.Map;

/**
 * * 每个静态代码块只会执行一次。由于JVM在加载类时会执行静态代码块，所以静态代码块先于主方法执行。
 */
public class _05_StaticInitializerBlock {
    private static Map<String, String> config;
    private static boolean isInitialized = false;
    private static final String DEFAULT_CONFIG_FILE = "app.properties";

    // 静态初始化块 - 加载默认配置
    static {
        System.out.println("开始初始化配置管理器...");
        config = new HashMap<>();
        loadDefaultConfig();
        isInitialized = true;
        System.out.println("配置管理器初始化完成");
    }

    // 静态初始化块 - 验证配置
    static {
        if (config.isEmpty()) {
            throw new RuntimeException("配置加载失败");
        }
        System.out.println("配置验证通过，共加载 " + config.size() + " 个配置项");
    }

    private static void loadDefaultConfig() {
        // 模拟从文件加载配置
        config.put("database.url", "jdbc:mysql://localhost:3306/mydb");
        config.put("database.username", "admin");
        config.put("database.password", "secret");
        config.put("app.name", "MyApplication");
        config.put("app.version", "1.0.0");

        System.out.println("默认配置加载完成");
    }

    public static String getConfig(String key) {
        if (!isInitialized) {
            throw new IllegalStateException("配置管理器未初始化");
        }
        return config.get(key);
    }

    public static void reloadConfig() {
        config.clear();
        loadDefaultConfig();
        System.out.println("配置重新加载完成");
    }

    // 测试
    public static void main(String[] args) {
        System.out.println("程序开始");

        // 第一次访问类，触发静态初始化块
        String dbUrl = _05_StaticInitializerBlock.getConfig("database.url");
        System.out.println("数据库URL: " + dbUrl);

        // 再次创建对象，静态初始化块不会再次执行
        _05_StaticInitializerBlock manager = null; // 不会触发静态初始化
        System.out.println("应用名称: " + _05_StaticInitializerBlock.getConfig("app.name"));
    }
}

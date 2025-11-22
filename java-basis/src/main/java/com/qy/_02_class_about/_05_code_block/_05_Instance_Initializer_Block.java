package com.qy._02_class_about._05_code_block;

/**
 *  * 构造代码块在创建对象时被调用，每次创建对象都会被调用，
 *  * 并且构造代码块的执行次序优先于类构造函数。
 *  * 如果存在多个构造代码块，执行顺序由他们在代码中出现的次序决定，先出现先执行。
 */
public class _05_Instance_Initializer_Block {
    private String url;
    private String username;
    private String password;
    private boolean isConnected;
    private long connectionTime;

    // 实例初始化块 - 设置默认配置
    {
        System.out.println("初始化数据库连接默认配置...");
        this.url = "jdbc:mysql://localhost:3306/mydb";
        this.username = "admin";
        this.password = "password";
        this.isConnected = false;
        this.connectionTime = 0L;
    }

    // 实例初始化块 - 验证配置
    {
        if (url == null || url.trim().isEmpty()) {
            throw new IllegalStateException("数据库URL不能为空");
        }
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalStateException("用户名不能为空");
        }
    }

    // 构造器
    public _05_Instance_Initializer_Block() {
        System.out.println("创建数据库连接对象");
    }

    public _05_Instance_Initializer_Block(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        System.out.println("创建自定义数据库连接对象");
    }

    public void connect() {
        this.isConnected = true;
        this.connectionTime = System.currentTimeMillis();
        System.out.println("连接到: " + url);
    }

    // 测试
    public static void main(String[] args) {
        _05_Instance_Initializer_Block conn1 = new _05_Instance_Initializer_Block();
        // 输出:
        // 初始化数据库连接默认配置...
        // 创建数据库连接对象

        _05_Instance_Initializer_Block conn2 = new _05_Instance_Initializer_Block(
                "jdbc:mysql://prod:3306/proddb", "user", "pass"
        );
        // 输出:
        // 初始化数据库连接默认配置...
        // 创建自定义数据库连接对象
    }
}

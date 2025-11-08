package com.qy._02_class_about._02_method;

public class _02_Method_Basis {
    public static void main(String[] args) {
        _02_Method_Basis example = new _02_Method_Basis();

        // 调用实例方法
        example.greet();                    // 无参数无返回值
        example.greetPerson("张三");        // 带参数无返回值

        int result = example.add(5, 3);    // 带参数有返回值
        System.out.println("5 + 3 = " + result);

        String time = example.getCurrentTime(); // 有返回值无参数
        System.out.println("当前时间: " + time);

        example.logMessage("这是一条日志消息"); // 使用公共方法间接调用私有方法

        // 调用静态方法（不需要创建实例）
        _02_Method_Basis.staticMethod();
    }
    // 1. 无参数无返回值的方法
    public void greet() {
        System.out.println("Hello, World!");
    }

    // 2. 带参数无返回值的方法
    public void greetPerson(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // 3. 带参数有返回值的方法
    public int add(int a, int b) {
        return a + b;
    }

    // 4. 有返回值无参数的方法
    public String getCurrentTime() {
        return java.time.LocalTime.now().toString();
    }

    // 5. 静态方法
    public static void staticMethod() {
        System.out.println("这是一个静态方法");
    }

    // 6. 私有方法（辅助方法）
    private String formatMessage(String message) {
        return "[" + java.time.LocalDateTime.now() + "] " + message;
    }

    // 使用私有辅助方法的公共方法
    public void logMessage(String message) {
        System.out.println(formatMessage(message));
    }
}

package com.qy._02_class_about._03_variables;

public class _03_ClassVariables {
    // 实例变量
    private String name;
    private int age;

    // 类变量（静态变量）
    private static String schoolName = "某某学校";  // 所有学生共享
    private static int studentCount = 0;           // 学生计数

    public _03_ClassVariables(String name, int age) {
        this.name = name;
        this.age = age;
        studentCount++;  // 每创建一个学生，计数器加1
    }

    // 静态方法访问静态变量
    public static int getStudentCount() {
        return studentCount;
    }
}
